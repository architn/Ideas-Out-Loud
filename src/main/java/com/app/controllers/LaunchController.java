package com.app.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import com.app.DAO.TweetsDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.POJOs.DisplayedTweet;
import com.app.DAO.TweetsDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LaunchController {

    //private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getLandingPage(HttpServletRequest request, TweetsDAO tweetDAO) {
        HttpSession session = request.getSession();
        if(session.getAttribute("isUserLoggedIn") == null) {
            return new ModelAndView("login");
        }
        long loggedInUserID = (Long) session.getAttribute("userid");
        List<DisplayedTweet> allTweetsOfUsersFollowing = tweetDAO.getAllTweetsFromAUsersFollowing(loggedInUserID);
        request.setAttribute("tweetsOnHomePage", allTweetsOfUsersFollowing);
        return new ModelAndView("home", "session", session);
    }


}

