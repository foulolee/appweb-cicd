package com.example.appweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        String hostname = InetAddress.getLocalHost().getHostName();
        String hostaddr = InetAddress.getLocalHost().getHostAddress();

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h1>HelloServlet - Session Cluster Test</h1>");
        out.println("<p>Session ID: " + session.getId() + "</p>");
        out.println("<p>Server Hostname: " + hostname + "</p>");
        out.println("<p>Server IP: " + hostaddr + "</p>");
        out.println("</body></html>");
    }
}