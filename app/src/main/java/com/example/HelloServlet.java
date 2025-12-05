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
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@WebServlet("/session-test")
public class HelloServlet extends HttpServlet {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                    .withZone(ZoneId.of("Asia/Seoul"));

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 세션 생성/조회
        HttpSession session = request.getSession(true);

        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }
        count++;
        session.setAttribute("count", count);

        // JSESSIONID & jvmRoute 추출
        String jsessionId = getJsessionIdFromCookie(request);
        String route = null;
        if (jsessionId != null && jsessionId.contains(".")) {
            route = jsessionId.substring(jsessionId.indexOf('.') + 1);
        }

        // 호스트네임 (어느 톰캣인지 확인용)
        String hostName = InetAddress.getLocalHost().getHostName();

        String creationTime = FORMATTER.format(Instant.ofEpochMilli(session.getCreationTime()));
        String lastAccessTime = FORMATTER.format(Instant.ofEpochMilli(session.getLastAccessedTime()));

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'><title>Tomcat Session Cluster Test</title>");
        out.println("<style>body{font-family:Arial,Helvetica,sans-serif;margin:30px;}" +
                "table{border-collapse:collapse;}" +
                "td,th{border:1px solid #aaa;padding:6px 10px;}</style>");
        out.println("</head><body>");

        out.println("<h2>Tomcat 세션 클러스터 테스트</h2>");
        out.println("<p>페이지를 새로고침하거나, 로드밸런서로 다른 노드로 붙여보면서 "
                + "세션 값이 유지되는지 확인하세요.</p>");

        out.println("<table>");
        out.println("<tr><th>세션 ID</th><td>" + session.getId() + "</td></tr>");
        out.println("<tr><th>JSESSIONID (쿠키)</th><td>" + jsessionId + "</td></tr>");
        out.println("<tr><th>jvmRoute (JSESSIONID 뒤쪽)</th><td>" +
                (route == null ? "(없음)" : route) + "</td></tr>");
        out.println("<tr><th>호스트명 (노드)</th><td>" + hostName + "</td></tr>");
        out.println("<tr><th>세션 생성 시각</th><td>" + creationTime + "</td></tr>");
        out.println("<tr><th>마지막 접근 시각</th><td>" + lastAccessTime + "</td></tr>");
        out.println("<tr><th>접속 횟수 (count)</th><td>" + count + "</td></tr>");
        out.println("</table>");

        out.println("<p><a href='session-test'>새로고침</a></p>");
        out.println("</body></html>");
    }

    private String getJsessionIdFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return null;
        for (Cookie c : cookies) {
            if ("JSESSIONID".equalsIgnoreCase(c.getName())) {
                return c.getValue();
            }
        }
        return null;
    }
}







