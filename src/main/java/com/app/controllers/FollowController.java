package com.app.controllers;

import com.app.DAO.TweetsDAO;
import com.app.DAO.UserDAO;
import com.app.DAO.UserFollowerDAO;
import com.app.POJOs.Tweets;
import com.app.POJOs.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FollowController {

    public void setViewOfUserProfile(UserDAO userDAO, UserFollowerDAO userFollowerDAO, TweetsDAO tweetDAO,
                         long IDOOfProspectiveUnfollow, HttpServletRequest request){

        Users profileOfSomeUser = userDAO.getUserByUserID(IDOOfProspectiveUnfollow);
        long numberOfFollowersOfLoggedInUser = userFollowerDAO.getNumberOfFollowersOfUser(IDOOfProspectiveUnfollow);
        long numberOfFollowingOfLoggedInUser = userFollowerDAO.getNumberOfFollowingOfUser(IDOOfProspectiveUnfollow);
        long numberOfTweetsOfLoggedInUser = tweetDAO.getNumberOfTweetsForAUser(IDOOfProspectiveUnfollow);
        profileOfSomeUser.setNumberOfFollowers(numberOfFollowersOfLoggedInUser);
        profileOfSomeUser.setNumberOfFollowing(numberOfFollowingOfLoggedInUser);
        profileOfSomeUser.setNumberOfTweets(numberOfTweetsOfLoggedInUser);

        HttpSession session = request.getSession();
        long userIDOfLoggedInUser = (Long) session.getAttribute("userid");
        boolean doesLoggedInUserFollowTheUser = userFollowerDAO.doesLoggedInUserFollowThisAccount(userIDOfLoggedInUser, IDOOfProspectiveUnfollow);
        boolean doesProfileUserFollowLoggedInUser = userFollowerDAO.doesProfileUserFollowLoggedInUser(userIDOfLoggedInUser, IDOOfProspectiveUnfollow);

        request.setAttribute("doesLoggedInUserFollowTheUser", doesLoggedInUserFollowTheUser);
        request.setAttribute("doesProfileUserFollowLoggedInUser", doesProfileUserFollowLoggedInUser);
    }


    @RequestMapping(value = "/follow", method = RequestMethod.POST)
    public ModelAndView followUser(HttpServletRequest request, UserFollowerDAO userFollowerDAO,
                                   TweetsDAO tweetDAO, UserDAO userDAO){
        String  loggedInUserS = request.getParameter("loggedInUser") ;
        String profileOfUserS = request.getParameter("profileOfUser") ;
        long loggedInUserID = Long.parseLong(loggedInUserS);
        long IDOfProspectiveFollower= Long.parseLong(profileOfUserS);
        userFollowerDAO.followAUser(loggedInUserID, IDOfProspectiveFollower);
        setViewOfUserProfile(userDAO, userFollowerDAO, tweetDAO,IDOfProspectiveFollower, request );
        List<Tweets> tweetsForSomeUser = tweetDAO.getAllTweetsForAUser(IDOfProspectiveFollower);

        return new ModelAndView("redirect:profile", "tweets", tweetsForSomeUser);
    }

    @RequestMapping(value = "/unfollow", method = RequestMethod.POST)
    public ModelAndView unFollowUser(HttpServletRequest request, UserFollowerDAO userFollowerDAO,
                                     TweetsDAO tweetDAO, UserDAO userDAO){
        String loggedInUserS = request.getParameter("loggedInUser") ;
        String profileOfUserS =request.getParameter("profileOfUser");
        long loggedInUserID = Long.parseLong(loggedInUserS);
        long IDOOfProspectiveUnfollow = Long.parseLong(profileOfUserS);
        userFollowerDAO.unFollowAUser(loggedInUserID, IDOOfProspectiveUnfollow);
        setViewOfUserProfile(userDAO, userFollowerDAO, tweetDAO,IDOOfProspectiveUnfollow, request );
        List<Tweets> tweetsForSomeUser = tweetDAO.getAllTweetsForAUser(IDOOfProspectiveUnfollow);
        return new ModelAndView("redirect:profile", "tweets", tweetsForSomeUser);
    }

}
