package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = {"/"})
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>안녕, K8S + ArgoCD + GitHub Actions!</h1>");
        out.println("<h1>안녕, K8S + ArgoCD + GitHub Actions!</h1>");
        out.println("<h1>안녕, K8S + ArgoCD + GitHub Actions!</h1>");
        out.println("<h1>안녕, K8S + ArgoCD + GitHub Actions!</h1>");
        out.println("<h1>안녕, K8S + ArgoCD + GitHub Actions!</h1>");
        out.println("<h1>안녕, K8S + ArgoCD + GitHub Actions!</h1>");
        out.println("</body></html>");
    }
}







