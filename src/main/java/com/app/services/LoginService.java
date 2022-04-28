package com.app.services;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.app.AppConstants.LoginCodes;
import org.springframework.stereotype.Service;

import com.app.POJOs.Users;
import com.app.DAO.UserDAO;


@Service
public class LoginService {
    LoginCodes LOGINCODES = new LoginCodes();

    public HashMap<Integer, Users> returnAuthenticationSuccess(HttpServletRequest request) {
        String userName = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        HashMap<Integer, Users> returnedUser = new HashMap<Integer, Users>();
        UserDAO userDAO = new UserDAO();
        Users user = userDAO.retrieveUserWithUsernameAndPassword(userName, password);

        if(user == null) {
            returnedUser.put(LOGINCODES.LoginFailed, user);

        }

        if(user.isAccountSuspended()) {
            returnedUser.put(LOGINCODES.AccountSuspended, user);

        }

        if(user.isUserAdministrator()) {
            returnedUser.put(LOGINCODES.UserIsAdministrator, user);
        }
        returnedUser.put(LOGINCODES.SuccessfulLogin, user);
        return returnedUser;
    }


}
