package com.app.POJOs;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean isUserVerified;
    private String profilepic;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String bio;
    private boolean isUserAdministrator;
    private boolean isAccountSuspended;
    private long numberOfFollowers;
    private long numberOfTweets;
    private long numberOfFollowing;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUserVerified() {
        return isUserVerified;
    }

    public void setUserVerified(boolean isUserVerified) {
        this.isUserVerified = isUserVerified;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isUserAdministrator() {
        return isUserAdministrator;
    }

    public void setUserAdministrator(boolean isUserAdministrator) {
        this.isUserAdministrator = isUserAdministrator;
    }

    public boolean isAccountSuspended() {
        return isAccountSuspended;
    }

    public void setAccountSuspended(boolean isAccountSuspended) {
        this.isAccountSuspended = isAccountSuspended;
    }

    public long getNumberOfFollowers() {
        return numberOfFollowers;
    }


    public void setNumberOfFollowers(long numberOfFollowers) {
        this.numberOfFollowers = numberOfFollowers;
    }

    public long getNumberOfFollowing() {
        return numberOfFollowing;
    }

    public void setNumberOfFollowing(long numberOfFollowing) {
        this.numberOfFollowing = numberOfFollowing;
    }

    public long getNumberOfTweets() {
        return numberOfTweets;
    }

    public void setNumberOfTweets(long numberOfTweets) {
        this.numberOfTweets = numberOfTweets;
    }

}
