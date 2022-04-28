package com.app.DAO;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.LongType;

import com.app.POJOs.Users;

public class UserFollowerDAO extends DAO {

    public Long getNumberOfFollowersOfUser(long userID) {
        Session session = getSession();
        SQLQuery query = session.createSQLQuery("select count(*) from user_followers where followerid="+userID);
        BigInteger numberOfFFollowersB = (BigInteger) query.uniqueResult();
        long numberOfFFollowers = numberOfFFollowersB.longValue();
        return numberOfFFollowers;

    }

    public Long getNumberOfFollowingOfUser(long userID) {
        Session session = getSession();
        SQLQuery query = session.createSQLQuery("select count(*) from user_followers where userid="+userID);
        BigInteger numberOfFFollowingB = (BigInteger) query.uniqueResult();
        long numberOfFFollowing = numberOfFFollowingB.longValue();
        return numberOfFFollowing;
    }

    public boolean doesLoggedInUserFollowThisAccount(long idOfLoggedInUser, long idOfFellowUser){
        Session session = getSession();
        SQLQuery query = session.createSQLQuery("select count(*) from user_followers where followerid ="+idOfLoggedInUser+
                " and userid="+idOfFellowUser);
        BigInteger countOfSuchAConditionB = (BigInteger) query.uniqueResult();
        long countOfSuchACondition = countOfSuchAConditionB.longValue();
        if(countOfSuchACondition == 0){
                return false;
        }
        return true;
    }

    public boolean doesProfileUserFollowLoggedInUser(long idOfLoggedInUser, long idOfFellowUser){
        Session session = getSession();
        SQLQuery query = session.createSQLQuery("select count(*) from user_followers where userid ="+idOfLoggedInUser+
                " and followerid="+idOfFellowUser);
        BigInteger countOfSuchAConditionB = (BigInteger) query.uniqueResult();
        long countOfSuchACondition = countOfSuchAConditionB.longValue();
        if(countOfSuchACondition == 0){
            return false;
        }
        return true;
    }

    public void followAUser(long loggedInUser, long idOfProspectiveFollow){
        Session session = getSession();
        SQLQuery query = session.createSQLQuery("INSERT INTO user_followers(userid, followerid) VALUES(?, ?)");
        session.beginTransaction();
        query.setParameter(1, loggedInUser);
        query.setParameter(2, idOfProspectiveFollow);
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void unFollowAUser(long loggedInUser, long idOfProspectiveUnfollow){
        Session session = getSession();
        session.beginTransaction();

        SQLQuery query = session.createSQLQuery("DELETE from user_followers where userid="+loggedInUser+" and followerid="
                +idOfProspectiveUnfollow+"");
        query.executeUpdate();
        session.getTransaction().commit();

    }

}
