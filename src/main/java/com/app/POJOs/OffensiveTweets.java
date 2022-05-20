package com.app.POJOs;


import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Component
@Entity
public class OffensiveTweets {
    @Id
    private long offensiveTweetId;

    @ManyToOne
    @JoinColumn(name = "tweet_id_tweet_id")
    private Tweets tweetID;
    private String reason;
    private boolean isResolved;
    private Users user;

    public long getOffensiveTweetId() {
        return offensiveTweetId;
    }

    public void setOffensiveTweetId(long offensiveTweetId) {
        this.offensiveTweetId = offensiveTweetId;
    }

    public Tweets getTweetID() {
        return tweetID;
    }

    public void setTweetID(Tweets tweetID) {
        this.tweetID = tweetID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isResolved() {
        return isResolved;
    }

    public void setResolved(boolean isResolved) {
        this.isResolved = isResolved;
    }

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
    
    
}
