package com.app.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.app.DAO.OffensiveTweetsDAO;
import com.app.POJOs.OffensiveTweets;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.POJOs.DisplayedTweet;
import com.app.POJOs.Tweets;
import com.app.POJOs.Users;
import com.app.DAO.TweetsDAO;
import com.app.DAO.UserDAO;

@Controller
public class TweetController {

    // For posting a new Tweet
    @RequestMapping(value = "/tweet", method = RequestMethod.POST)

    public ModelAndView postTweet(HttpServletRequest request, TweetsDAO tweetDAO, UserDAO userDAO, Tweets tweet) {
        String tweetBody = request.getParameter("tweetBody");
        HttpSession session = request.getSession();
        long userIDOfTweeter = (Long) session.getAttribute("userid");
        Users user = userDAO.getUserByUserID(userIDOfTweeter);
        if(tweetBody.length() <= 280 ) {
            tweet.setTweetBody(tweetBody);
            tweet.setUser(user);
            tweet.setDateOfTweet(new Date());
            tweetDAO.postTweet(tweet);
        }
        long loggedInUserID = (Long) session.getAttribute("userid");
        List<DisplayedTweet> allTweetsOfUsersFollowing = tweetDAO.getAllTweetsFromAUsersFollowing(loggedInUserID);
        request.setAttribute("tweetsOnHomePage", allTweetsOfUsersFollowing);
        request.setAttribute("profilepic", user.getProfilepic());
        return new ModelAndView("home");
    }

    // If User refreshes the view after posting a tweet

    @RequestMapping(value = "/tweet", method = RequestMethod.GET)

    public ModelAndView postTweetGet(HttpServletRequest request, TweetsDAO tweetDAO, UserDAO userDAO, Tweets tweet)
    {
        HttpSession session = request.getSession();
        long loggedInUserID = (Long) session.getAttribute("userid");
        Users user = userDAO.getUserByUserID(loggedInUserID);
        List<DisplayedTweet> allTweetsOfUsersFollowing = tweetDAO.getAllTweetsFromAUsersFollowing(loggedInUserID);
        request.setAttribute("tweetsOnHomePage", allTweetsOfUsersFollowing);
        request.setAttribute("profilepic", user.getProfilepic());
        return new ModelAndView("home");
    }

    // For Editing a tweet

    @RequestMapping(value="/editTweet", method=RequestMethod.GET)
    public ModelAndView editTweet(HttpServletRequest request, TweetsDAO tweetDAO) {

        String tweetID = request.getParameter("id");
        long tweetId = Long.parseLong(tweetID);
        Tweets tweet = tweetDAO.getTweetByTweetID(tweetId);
        request.setAttribute("user", tweet.getUser());
        request.setAttribute("tweet", tweet);
        return new ModelAndView("editTweet");
    }

    // Posting an edited tweet

    @RequestMapping(value="/editedTweet", method=RequestMethod.POST)
    public ModelAndView postEditedTweet(HttpServletRequest request, TweetsDAO tweetDAO, UserDAO userDAO) {
        try {
            System.out.println("In Controller");
            String tweetID = request.getParameter("id");
            long tweetId = Long.parseLong(tweetID);
            HttpSession session = request.getSession();
            long userIDOfTweeter = (Long) session.getAttribute("userid");
            Users user = userDAO.getUserByUserID(userIDOfTweeter);

            Tweets tweet = new Tweets();
            String newTweetBody = request.getParameter("tweetBody");
            tweet.setTweetID(tweetId);
            tweet.setUser(user);
            tweet.setTweetBody(newTweetBody);
            tweet.setDateOfTweet(new Date());
            System.out.println("Updating....");
            tweetDAO.postEditedTweet(tweet);
            List<Tweets> tweets = tweetDAO.getAllTweetsForAUser(userIDOfTweeter);
            return new ModelAndView("userprofile", "tweets", tweets);

        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return new ModelAndView("userprofile");
    }

    @RequestMapping(value="/offensive", method=RequestMethod.GET)
    public ModelAndView getOffensiveTweetForm(HttpServletRequest request, TweetsDAO tweetDAO, UserDAO userDAO) {
        long tweetID = Long.parseLong(request.getParameter("id"));
        Tweets tweet = tweetDAO.getTweetByTweetID(tweetID);
        Users user = tweet.getUser();
        request.setAttribute("user", user);
        return new ModelAndView("offensive", "tweet", tweet);
        }
    @RequestMapping(value="/offensive", method=RequestMethod.POST)
    public ModelAndView postOffensiveTweetForm(HttpServletRequest request, TweetsDAO tweetDAO, UserDAO userDAO,
                                               OffensiveTweetsDAO offensiveTweetsDAO, OffensiveTweets offensiveTweet) {
        long tweetID = Long.parseLong(request.getParameter("id"));
        String reasonForOffensiveTweet = request.getParameter("reason");
        Tweets tweet = tweetDAO.getTweetByTweetID(tweetID);
        offensiveTweet.setTweetID(tweet);
        offensiveTweet.setReason(reasonForOffensiveTweet);
        offensiveTweetsDAO.insertTweetInOffensiveTweet(offensiveTweet);
//        request.setAttribute("user", user);
        return new ModelAndView("offensive", "tweet", tweet);
    }
    }

