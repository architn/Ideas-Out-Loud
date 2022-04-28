package com.app.controllers;

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
    public ModelAndView returnProfilePage(HttpServletRequest request, UserDAO userDAO,
                                          UserFollowerDAO userFollowerDAO, TweetsDAO tweetDAO)
    {
        HttpSession session = request.getSession();
        long loggedInUserID = (Long) session.getAttribute("userid");
        List<Users> listOfTopTenRecommendedUsers = userDAO.getTenUsers(loggedInUserID);
        request.setAttribute("recommendedusers", listOfTopTenRecommendedUsers);
        return new ModelAndView("search");
    }
}
