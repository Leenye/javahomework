package com.tw.web;

import com.tw.dao.UsrDao;
import com.tw.entity.Usr;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by twer on 7/8/15.
 */
public class UsrServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usr> usrs = new UsrDao().get_usrs();
        request.setAttribute("usrs",usrs);


        RequestDispatcher de = request.getRequestDispatcher("index.jsp");
        de.forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String email = request.getParameter("email");

        Usr usr = new Usr(0,name,gender,Integer.parseInt(age),email);

        new UsrDao().insert_usr(usr);

        response.sendRedirect("/web");
    }

}
