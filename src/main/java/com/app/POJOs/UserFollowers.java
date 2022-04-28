package com.app.POJOs;

import java.util.Date;

import javax.persistence.Id;

import com.app.POJOs.Users;
public class UserFollowers {
    private Users User;
    private Users Follower;

    private Date dateOfFollow;


    public Users getUser() {
        return User;
    }


    public void setUser(Users user) {
        this.User = user;
    }


    public Users getFollower() {
        return Follower;
    }


    public void setFollower(Users follower) {
        this.Follower = follower;
    }


    public Date getDateOfFollow() {
        return dateOfFollow;
    }


    public void setDateOfFollow(Date dateOfFollow) {
        this.dateOfFollow = dateOfFollow;
    }


}
