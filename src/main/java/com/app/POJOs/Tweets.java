package com.app.POJOs;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tweets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tweetID;
    private Users user;
    private String tweetBody;
    private int numberOfLikes;
    private Date dateOfTweet;
    private boolean isTweetOffensive;


    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public Long getTweetID() {
        return tweetID;
    }

    public void setTweetID(Long tweetID) {
        this.tweetID = tweetID;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getTweetBody() {
        return tweetBody;
    }

    public void setTweetBody(String tweetBody) {
        this.tweetBody = tweetBody;
    }

    public Date getDateOfTweet() {
        return dateOfTweet;
    }

    public void setDateOfTweet(Date dateOfTweet) {
        this.dateOfTweet = dateOfTweet;
    }

    public boolean isTweetOffensive() {
        return isTweetOffensive;
    }

    public void setTweetOffensive(boolean isTweetOffensive) {
        this.isTweetOffensive = isTweetOffensive;
    }


}
