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

}
