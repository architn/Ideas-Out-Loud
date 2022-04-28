package com.app.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logoutCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("userid");
        session.setAttribute("isUserLoggedIn", false);
        return new ModelAndView("login");

    }

}
