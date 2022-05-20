package com.app.DAO;

import java.util.List;

import org.hibernate.Criteria;
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

    public List<Users> returnUserSearchResults(String searchParameter){
        Session session = getSession();
        Query qry = session.createQuery("From Users as user where user.username  like ?1 or user.firstName like ?2 or user.lastName like ?3");
        qry.setParameter(1, "%"+searchParameter+"%");
        qry.setParameter(2, "%"+searchParameter+"%");
        qry.setParameter(3, "%"+searchParameter+"%");

        List<Users> searchResults =  qry.list();
        return searchResults;

    }
}

