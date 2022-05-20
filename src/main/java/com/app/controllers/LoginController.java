package com.app.controllers;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.app.AppConstants.LoginCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.POJOs.DisplayedTweet;
import com.app.POJOs.Tweets;
import com.app.POJOs.Users;
import com.app.DAO.TweetsDAO;
import com.app.DAO.UserDAO;
import com.app.services.LoginService;

@Controller
public class LoginController {
    LoginCodes LOGINCODES = new LoginCodes();

    //@Autowired

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView returnLoginPage(HttpServletRequest request, LoginService loginService, TweetsDAO tweetDAO) {
        HashMap<Integer, Users> authenticatedUser;

        HttpSession session = request.getSession();
        try {
            authenticatedUser = loginService.returnAuthenticationSuccess(request);
            if(authenticatedUser.containsKey(LOGINCODES.LoginFailed) ) {
                System.out.println("1");
                return new ModelAndView("login");
            }
            else if(authenticatedUser.containsKey(LOGINCODES.UserIsAdministrator)) {

                session.setAttribute("isUserLoggedIn", true);
                Users user = authenticatedUser.get(LOGINCODES.UserIsAdministrator);
                session.setAttribute("userid", user.getId());
                List<Tweets> offensiveTweets = tweetDAO.getAllOffensiveTweetsForAdministrator();
                request.setAttribute("offensivetweets", offensiveTweets);
                return new ModelAndView("adminview", "user", user);
            }
            else if(authenticatedUser.containsKey(LOGINCODES.AccountSuspended)) {
                return new ModelAndView("suspendedaccount");
            }
        }
        catch(Exception ex) {
            System.out.println("2");
            ex.printStackTrace();
            return new ModelAndView("login");
        }
        Users user = authenticatedUser.get(LOGINCODES.SuccessfulLogin);

        session.setAttribute("userid", user.getId());
        session.setAttribute("isUserLoggedIn", true);
        request.setAttribute("profilepic", user.getProfilepic());
//		request.setAttribute("user", user);

        long loggedInUserID = (Long) session.getAttribute("userid");
        List<DisplayedTweet> allTweetsOfUsersFollowing = tweetDAO.getAllTweetsFromAUsersFollowing(loggedInUserID);
        request.setAttribute("tweetsOnHomePage", allTweetsOfUsersFollowing);
        return new ModelAndView("home", "user", user);
    }


}

