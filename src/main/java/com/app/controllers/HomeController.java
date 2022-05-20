package com.app.controllers;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.app.AppConstants.LoginCodes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.POJOs.DisplayedTweet;
import com.app.POJOs.Users;
import com.app.DAO.TweetsDAO;
import com.app.DAO.UserDAO;
import com.app.services.LoginService;


@Controller
public class HomeController {
    LoginCodes LOGINCODES = new LoginCodes();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView verifyAndReturnHomePage(HttpServletRequest request, LoginService loginService, TweetsDAO tweetDAO, UserDAO userDAO) {
        HttpSession session = request.getSession();
        try {
        	boolean isUserLoggedIn = (Boolean) session.getAttribute("isUserLoggedIn");
            if(isUserLoggedIn) {
                long loggedInUserID = (Long) session.getAttribute("userid");
                List<DisplayedTweet> allTweetsOfUsersFollowing = tweetDAO.getAllTweetsFromAUsersFollowing(loggedInUserID);
                request.setAttribute("tweetsOnHomePage", allTweetsOfUsersFollowing);
                Users user = userDAO.getUserByUserID(loggedInUserID);
                request.setAttribute("profilepic", user.getProfilepic());

                return new ModelAndView("home");
            }
        }
        catch(Exception ex) {
            return new ModelAndView("login");
        }
        
        return new ModelAndView("login");

    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public void returnHomePage(HttpServletRequest request, LoginService loginService, TweetsDAO tweetDAO, UserDAO userDAO) {

        verifyAndReturnHomePage(request, loginService, tweetDAO, userDAO);

    }
}

