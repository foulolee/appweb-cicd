package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

@WebServlet("/session-test")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 세션 가져오기
        HttpSession session = request.getSession(true);

        Integer count = (Integer) session.getAttribute("count");
        if (count == null) count = 0;
        count++;
        session.setAttribute("count", count);

        // JSESSIONID
        String jsessionId = getJsessionId(request);

        // 어느 Tomcat 노드인지 확인
        String hostName = InetAddress.getLocalHost().getHostName();

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body style='font-family:Arial;'>");
        out.println("<h2>Tomcat Session Cluster Test</h2>");
        out.println("<table border='1' cellpadding='6'>");
        out.println("<tr><th>세션 ID</th><td>" + session.getId() + "</td></tr>");
        out.println("<tr><th>JSESSIONID (Cookie)</th><td>" + jsessionId + "</td></tr>");
        out.println("<tr><th>현재 노드(Hostname)</th><td>" + hostName + "</td></tr>");
        out.println("<tr><th>접속 횟수</th><td>" + count + "</td></tr>");
        out.println("</table>");
        out.println("<p><a href='session-test'>🔄 새로고침</a></p>");
        out.println("</body></html>");
    }

    private String getJsessionId(HttpServletRequest request) {
        if (request.getCookies() == null) return "(없음)";
        for (Cookie c : request.getCookies()) {
            if ("JSESSIONID".equals(c.getName())) {
                return c.getValue();
            }
        }
        return "(없음)";
    }
}
