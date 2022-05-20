package com.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.POJOs.Users;
import com.app.DAO.TweetsDAO;
import com.app.DAO.UserDAO;
import com.app.DAO.UserFollowerDAO;

@Controller
public class SearchController {

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView returnProfilePage(HttpServletRequest request, UserDAO userDAO)
    {
        HttpSession session = request.getSession();
        List<Users> searchedUsers = new ArrayList<>();
        long loggedInUserID = (Long) session.getAttribute("userid");
        List<Users> listOfTopTenRecommendedUsers = userDAO.getTenUsers(loggedInUserID);
        request.setAttribute("recommendedusers", listOfTopTenRecommendedUsers);
        request.setAttribute("searchedUsers", searchedUsers);
        return new ModelAndView("search");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView returnSearchResults(HttpServletRequest request, UserDAO userDAO)
    {
        HttpSession session = request.getSession();
        String searchParameter = request.getParameter("searchParameter");
        List<Users> searchedUsers = userDAO.returnUserSearchResults(searchParameter);
        long loggedInUserID = (Long) session.getAttribute("userid");
        List<Users> listOfTopTenRecommendedUsers = userDAO.getTenUsers(loggedInUserID);
        request.setAttribute("recommendedusers", listOfTopTenRecommendedUsers);
        request.setAttribute("searchedUsers", searchedUsers);
        return new ModelAndView("search");
    }
}
