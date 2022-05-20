package com.app.controllers;

import com.app.DAO.OffensiveTweetsDAO;
import com.app.DAO.TweetsDAO;
import com.app.DAO.UserDAO;
import com.app.POJOs.OffensiveTweets;
import com.app.POJOs.Tweets;
import com.app.POJOs.Users;
import com.app.services.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
	

    @RequestMapping(value = "/manageTweets", method = RequestMethod.GET)
    public ModelAndView returnTweetsManagementPage(HttpServletRequest request, OffensiveTweetsDAO offensiveTweetsDAO,
                                                   TweetsDAO tweetDAO)
    {
        List<Tweets> tweets = tweetDAO.getAllOffensiveTweetsForAdministrator();

       
        request.setAttribute("tweets", tweets);
        return new ModelAndView("managetweets","tweets", tweets);
    }
    
    @RequestMapping(value = "/tweetDetails", method = RequestMethod.GET)
    public ModelAndView returnOffensivetTweetInfo(HttpServletRequest request, OffensiveTweetsDAO offensiveTweetsDAO,
                                                   TweetsDAO tweetDAO)
    {
    	long ID = Long.parseLong(request.getParameter("id"));
    	OffensiveTweets tweetDetail = offensiveTweetsDAO.getOffensiveTweetByTweetID(ID);
    	Tweets tweet = tweetDAO.getTweetByTweetID(ID);
        request.setAttribute("reason", tweetDetail.getReason());
        return new ModelAndView("flaggedTweets","tweets", tweet);
    }
    
    

    @RequestMapping(value = "/manageUsers", method = RequestMethod.GET)
    public ModelAndView returnUserDisplayPage(HttpServletRequest request, UserDAO userDAO)
    {
        List<Users> allUsers = userDAO.getAllUsers();
        return new ModelAndView("usermanage", "allUsers", allUsers);
    }
    @RequestMapping(value = "/userActions", method = RequestMethod.GET)
    public ModelAndView returnUserManagementPage(HttpServletRequest request, UserDAO userDAO)
    {
        String username = request.getParameter("username");
        Users user = userDAO.getUserByUsername(username);
        return new ModelAndView("useractions", "user", user);
    }
    @RequestMapping(value = "/suspend", method = RequestMethod.POST)
    public ModelAndView suspendAUser(HttpServletRequest request, UserDAO userDAO)
    {
        String username = request.getParameter("username");
        String suspensionAction = request.getParameter("action");
        Users user = userDAO.getUserByUsername(username);
        user.setId(user.getId());
        user.setUsername(username);
        user.setPassword(user.getPassword());
        user.setProfilepic(user.getProfilepic());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setDateOfBirth(user.getDateOfBirth());
        user.setBio(user.getBio());
        user.setUserAdministrator(user.isUserAdministrator());
        user.setNumberOfFollowers(user.getNumberOfFollowers());
        user.setNumberOfFollowing(user.getNumberOfFollowers());
        user.setNumberOfTweets(user.getNumberOfTweets());
        user.setUserVerified(user.isUserVerified());
        if(suspensionAction.equals("suspend")){
            user.setAccountSuspended(true);
        }
        else if(suspensionAction.equals("unlock")){
            user.setAccountSuspended(false);
        }

        userDAO.updateUser(user);
        return new ModelAndView("redirect:manageUsers", "user", user);
    }
    @RequestMapping(value = "/verifiedAccount", method = RequestMethod.POST)
    public ModelAndView makeUserAVerifiedAccount(HttpServletRequest request, UserDAO userDAO, EmailService emailService)
    {
        String username = request.getParameter("username");
        String verificationAction = request.getParameter("verification");
        Users user = userDAO.getUserByUsername(username);
        user.setId(user.getId());
        user.setUsername(username);
        user.setPassword(user.getPassword());
        user.setProfilepic(user.getProfilepic());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setDateOfBirth(user.getDateOfBirth());
        user.setBio(user.getBio());
        user.setUserAdministrator(user.isUserAdministrator());
        user.setAccountSuspended(user.isAccountSuspended());
        user.setNumberOfFollowers(user.getNumberOfFollowers());
        user.setNumberOfFollowing(user.getNumberOfFollowers());
        user.setNumberOfTweets(user.getNumberOfTweets());
        if(verificationAction.equals("remove")){
            user.setUserVerified(false);
        }
        else if(verificationAction.equals("add")){
            user.setUserVerified(true);
        }

        userDAO.updateUser(user);
        try {
        	emailService.SendEmailOfAccountVerification("archit.nigam711@gmail.com", username);
        }
        catch(Exception ex) {
            return new ModelAndView("redirect:manageUsers", "user", user);
        }
        return new ModelAndView("redirect:manageUsers", "user", user);
    }
    
    
}
