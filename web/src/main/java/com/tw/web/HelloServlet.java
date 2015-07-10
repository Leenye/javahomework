package com.tw.web;

import com.tw.core.Service;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.print(new Service().service());

    }
}
