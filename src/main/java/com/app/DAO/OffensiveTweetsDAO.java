package com.app.DAO;

import com.app.POJOs.OffensiveTweets;
import com.app.POJOs.Tweets;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class OffensiveTweetsDAO extends DAO{

    public void insertTweetInOffensiveTweet(OffensiveTweets tweet){
        begin();
        getSession().save(tweet);
        commit();
    }

    public OffensiveTweets getOffensiveTweetByTweetID(long tweetID){
        Session session = getSession();
        Query q = session.createQuery("from OffensiveTweets where tweetID="+tweetID);
        OffensiveTweets tweet = (OffensiveTweets) q.uniqueResult();
        return tweet;
    }

    public List<OffensiveTweets> getAllUnresolvedTweets(){
        Session session = getSession();
        Query q = session.createQuery("from OffensiveTweets where isResolved=false");
        List<OffensiveTweets> tweets =  q.list();
        return tweets;
    }
}
