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
 * Created by twer on 7/9/15.
 */
public class UpdateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Usr usr = new UsrDao().get_element_by_id(id);
        request.setAttribute("usr",usr);

        RequestDispatcher de = request.getRequestDispatcher("update.jsp");
        de.forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");

        Usr usr = new Usr(id,name,gender,age,email);

        new UsrDao().update(usr);
        request.setAttribute("usr",usr);

        response.sendRedirect("/web");
        RequestDispatcher de = request.getRequestDispatcher("index.jsp");
        de.forward(request,response);
    }




}
