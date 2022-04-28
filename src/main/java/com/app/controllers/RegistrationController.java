package com.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.POJOs.Users;
import com.app.services.RegistrationService;

@Controller
public class RegistrationController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView returnSignUpPage() {

        return new ModelAndView("signup");
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView registerNewUser(HttpServletRequest request, RegistrationService registerService) {
        Users users = new Users();
        String userName = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String firstname = request.getParameter("txtFirstName");
        String lastname = request.getParameter("txtLastName");
        String dob = request.getParameter("txtDOB");
        Date dateOfBirth = new Date();
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
        //userDAO.createNewUser(users);

        return new ModelAndView("home");
    }
}
