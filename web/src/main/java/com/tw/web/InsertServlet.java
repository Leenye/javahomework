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
public class InsertServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usr usr = new Usr(0,"Jack","M",38,"123@1.com");
        int result = new UsrDao().insert_usr(usr);
        RequestDispatcher de = request.getRequestDispatcher("index.jsp");
        de.forward(request,response);
    }
}
