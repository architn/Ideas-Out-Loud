package com.app.DAO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.app.POJOs.DisplayedTweet;
import com.app.POJOs.Tweets;
import com.app.POJOs.Users;

public class TweetsDAO extends DAO{

    public void postTweet(Tweets tweet) {
        begin(); // Marks the beginning of the transaction
        getSession().save(tweet);
        commit(); // Commit this transaction
    }

    public List<Tweets> getAllTweetsForAUser(long userID){
        Session session = getSession();
        Query q = session.createQuery("from Tweets where user="+userID+" and isTweetOffensive = false");
        List<Tweets> tweets = q.list();
        return tweets;
    }

    public List<DisplayedTweet> getAllTweetsFromAUsersFollowing(long userID){
        List<DisplayedTweet> listOfTweetsOfFollowing = new ArrayList<DisplayedTweet>();
        Session session = getSession();
        String queryForUserRetrieval = "select distinct us.username, us.firstname, us.lastname, us.profilepic,"
                + " tw.body, tw.dateoftweet,"
                + " tw.numberOfLikes, tw.tweetid, us.isuserverified, tw.hasTweetBeenEdited\n" +
                "from users us join user_followers uf\n" +
                "on us.userid = uf.followerid\n" +
                "inner join tweets tw\n" +
                "on uf.followerid = tw.userid\n" +
                "where uf.followerid != "+userID + "\n"+
                "and tw.isTweetOffensive != true"+ "\n"+
                "or uf.followerid ="+userID + "\n"+
                "order by tw.tweetid desc";
        SQLQuery query = session.createSQLQuery(queryForUserRetrieval);
        List<Object[]> tweets =  query.list();
        for(Object[] followingTweet : tweets) {
            DisplayedTweet tweet = new DisplayedTweet();
            String username = (String) followingTweet[0];
            String firstname = (String) followingTweet[1];
            String lastname = (String) followingTweet[2];
            String profilepiclink = (String) followingTweet[3];
            String tweetbody = (String) followingTweet[4];
            Date dateOfTweet = (Date) followingTweet[5];
            int numberOfLikes = (Integer) followingTweet[6];
            boolean isUserVerified = (Boolean) followingTweet[8];
            boolean hasTweetBeenEdited = (Boolean) followingTweet[9];


            tweet.setUsername(username);
            tweet.setUserProfilePic(profilepiclink);
            tweet.setUserFullName(firstname + " " + lastname);
            tweet.setTweetBody(tweetbody);
            tweet.setDateOfTweets(dateOfTweet);
            tweet.setNumberOfLikes(numberOfLikes);
            tweet.setUserVerified(isUserVerified);
            tweet.setHasTweetBeenEdited(hasTweetBeenEdited);
            listOfTweetsOfFollowing.add(tweet);
        }

        return listOfTweetsOfFollowing;
    }


    public List<Tweets> getAllOffensiveTweetsForAdministrator(){
        Session session = getSession();
        Query q = session.createQuery("from Tweets where isTweetOffensive=true");
        List<Tweets> listOfOffensiveTweets = q.list();
        return listOfOffensiveTweets;

    }

    public long getNumberOfTweetsForAUser(long userID) {
        Session session = getSession();
        Query q = session.createQuery("select count(t) from Tweets t where user="+userID);
        long numberOfTweets = (Long) q.uniqueResult();
        return numberOfTweets;
    }

    public Tweets getTweetByTweetID(long tweetID) {
        Session session = getSession();
        Query q = session.createQuery("from Tweets t where tweetID="+tweetID);
        Tweets tweet = (Tweets) q.uniqueResult();
        return tweet;
    }

    public void postEditedTweet(Tweets tweet) {
        begin(); // Marks the beginning of the transaction
        getSession().update(tweet);
        commit(); // Commit this transaction
    }

    public void deleteTweet(Tweets tweet){
        begin(); // Marks the beginning of the transaction
        getSession().delete(tweet);
        commit(); // Commit this transaction
    }
}

