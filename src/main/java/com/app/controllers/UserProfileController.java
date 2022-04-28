package com.app.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.POJOs.Tweets;
import com.app.POJOs.Users;
import com.app.DAO.TweetsDAO;
import com.app.DAO.UserDAO;
import com.app.DAO.UserFollowerDAO;

@Controller
public class UserProfileController {


    // URL Mapping to user's own profile
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView returnProfilePage(HttpServletRequest request, UserDAO userDAO,
                                          UserFollowerDAO userFollowerDAO, TweetsDAO tweetDAO) {
        HttpSession session = request.getSession();
        Long userid = (Long) session.getAttribute("userid");
        List<Tweets> tweets = tweetDAO.getAllTweetsForAUser(userid);

        Users loggedInUser = userDAO.getUserByUserID(userid);
        long numberOfFollowersOfLoggedInUser = userFollowerDAO.getNumberOfFollowersOfUser(userid);
        long numberOfFollowingOfLoggedInUser = userFollowerDAO.getNumberOfFollowingOfUser(userid);
        long numberOfTweetsOfLoggedInUser = tweetDAO.getNumberOfTweetsForAUser(userid);
        loggedInUser.setNumberOfFollowers(numberOfFollowersOfLoggedInUser);
        loggedInUser.setNumberOfFollowing(numberOfFollowingOfLoggedInUser);
        loggedInUser.setNumberOfTweets(numberOfTweetsOfLoggedInUser);

        session.setAttribute("user", loggedInUser);
        return new ModelAndView("userprofile", "tweets", tweets);
    }

    // URL mapping to someone else's profile

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView returnProfilePageOfSomeUser(HttpServletRequest request, UserDAO userDAO,
                                                    UserFollowerDAO userFollowerDAO, TweetsDAO tweetDAO) {
        String username = request.getParameter("username");
        Users profileOfSomeUser = userDAO.getUserByUsername(username);
        HttpSession session = request.getSession();
        Long userid = profileOfSomeUser.getId();
        List<Tweets> tweetsForSomeUser = tweetDAO.getAllTweetsForAUser(userid);

        long numberOfFollowersOfLoggedInUser = userFollowerDAO.getNumberOfFollowersOfUser(userid);
        long numberOfFollowingOfLoggedInUser = userFollowerDAO.getNumberOfFollowingOfUser(userid);
        long numberOfTweetsOfLoggedInUser = tweetDAO.getNumberOfTweetsForAUser(userid);
        profileOfSomeUser.setNumberOfFollowers(numberOfFollowersOfLoggedInUser);
        profileOfSomeUser.setNumberOfFollowing(numberOfFollowingOfLoggedInUser);
        profileOfSomeUser.setNumberOfTweets(numberOfTweetsOfLoggedInUser);

        session.setAttribute("user", profileOfSomeUser);
        return new ModelAndView("profile", "tweets", tweetsForSomeUser);
    }
}

