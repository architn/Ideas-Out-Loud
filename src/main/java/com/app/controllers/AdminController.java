package com.app.controllers;

import com.app.DAO.OffensiveTweetsDAO;
import com.app.DAO.TweetsDAO;
import com.app.DAO.UserDAO;
import com.app.POJOs.OffensiveTweets;
import com.app.POJOs.Tweets;
import com.app.POJOs.Users;
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
        List<OffensiveTweets> listOfOffensiveTweets = offensiveTweetsDAO.getAllUnresolvedTweets();
        List<Tweets> tweets = new ArrayList<>();

        for(OffensiveTweets tw: listOfOffensiveTweets){
            tweets.add(tw.getTweetID());
        }
        request.setAttribute("tweets", tweets);
        return new ModelAndView("managetweets", "offensiveTweets", listOfOffensiveTweets);
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
        System.out.println(suspensionAction);
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
        return new ModelAndView("useractions", "user", user);
    }
    @RequestMapping(value = "/verifiedAccount", method = RequestMethod.POST)
    public ModelAndView makeUserAVerifiedAccount(HttpServletRequest request, UserDAO userDAO)
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
        return new ModelAndView("useractions", "user", user);
    }
}
