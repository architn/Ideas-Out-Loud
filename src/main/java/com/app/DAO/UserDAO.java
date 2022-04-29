package com.app.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.app.POJOs.Users;

public class UserDAO extends DAO {

    public void createNewUser(Users user) {
        begin(); // Marks the beginning of the transaction
        getSession().save(user);
        commit(); // Commit this transaction
    }

    public Users retrieveUserWithUsernameAndPassword(String userName, String password) {
        Session session = getSession();
        Query q = session.createQuery("from Users where username='"+userName+"' and password='"+password+"'");
        Users user = (Users) q.uniqueResult();
        return user;
    }

    public Users getUserByUserID(long userID) {
        Session session = getSession();
        Query q = session.createQuery("from Users where id="+userID);
        Users user = (Users) q.uniqueResult();
        return user;
    }

    public List<Users> getTenUsers(long loggedInUser){
        Session session = getSession();
        Query q = session.createQuery("from Users where id!="+loggedInUser+" and isUserAdministrator!="+true+"" +
                " and isAccountSuspended!=true").setMaxResults(10);

        List<Users> listOfTenUsers =  q.list();
        return listOfTenUsers;
    }

    public List<Users> getAllUsers(){
        Session session = getSession();
        Query q = session.createQuery("from Users where isUserAdministrator!=true");
        List<Users> listOfTenUsers =  q.list();
        return listOfTenUsers;
    }

    public Users getUserByUsername(String username) {
        Session session = getSession();
        Query q = session.createQuery("from Users where username='"+username+"'");
        Users user = (Users) q.uniqueResult();
        return user;
    }

    public void updateUser(Users user){
        begin(); // Marks the beginning of the transaction
        getSession().update(user);
        commit(); // Commit this transaction
    }
}

