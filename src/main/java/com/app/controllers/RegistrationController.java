package com.app.controllers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.DAO.UserDAO;
import com.app.POJOs.Users;
import com.app.services.RegistrationService;

@Controller
public class RegistrationController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView returnSignUpPage() {

        return new ModelAndView("signup");
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView registerNewUser(HttpServletRequest request, RegistrationService registerService, Users users, 
    		UserDAO userDAO) {
        String userName = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String firstname = request.getParameter("txtFirstName");
        String lastname = request.getParameter("txtLastName");
        String dob = request.getParameter("txtDOB");
        Date dateOfBirth = new Date();
        String bio = request.getParameter("bio");
 
        try {
            dateOfBirth=new SimpleDateFormat("YYYY-MM-DD").parse(dob);
        }
        catch(Exception ex) {

        }
        users.setUsername(userName);
        users.setPassword(password);
        users.setFirstName(firstname);
        users.setLastName(lastname);
        users.setDateOfBirth(dateOfBirth);
        users.setBio(bio);
        userDAO.createNewUser(users);

        return new ModelAndView("redirect:login");
    }
}
