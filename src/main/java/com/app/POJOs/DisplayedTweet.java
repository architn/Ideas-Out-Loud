package com.app.POJOs;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DisplayedTweet {
    private String userProfilePic;
    private String userFullName;
    private String username;
    private Date dateOfTweets;
    private String tweetBody;
    private int numberOfLikes;
    private boolean isUserVerified;
    private boolean hasTweetBeenEdited;

    public String getUserProfilePic() {
        return userProfilePic;
    }
    public void setUserProfilePic(String userProfilePic) {
        this.userProfilePic = userProfilePic;
    }
    public String getUserFullName() {
        return userFullName;
    }
    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Date getDateOfTweets() {
        return dateOfTweets;
    }
    public void setDateOfTweets(Date dateOfTweets) {
        this.dateOfTweets = dateOfTweets;
    }
    public String getTweetBody() {
        return tweetBody;
    }
    public void setTweetBody(String tweetBody) {
        this.tweetBody = tweetBody;
    }
    public int getNumberOfLikes() {
        return numberOfLikes;
    }
    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public boolean isUserVerified() {
        return isUserVerified;
    }

    public void setUserVerified(boolean userVerified) {
        isUserVerified = userVerified;
    }
	public boolean isHasTweetBeenEdited() {
		return hasTweetBeenEdited;
	}
	public void setHasTweetBeenEdited(boolean hasTweetBeenEdited) {
		this.hasTweetBeenEdited = hasTweetBeenEdited;
	}
    
    
}
