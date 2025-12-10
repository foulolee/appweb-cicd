<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.InetAddress" %>

<%
    // 세션 가져오기
    javax.servlet.http.HttpSession session = request.getSession(true);

    Integer count = (Integer) session.getAttribute("count");
    if (count == null) count = 0;
    count++;
    session.setAttribute("count", count);

    // 어느 노드인지 확인 (hostname)
    String host = InetAddress.getLocalHost().getHostName();

    // JSESSIONID 가져오기
    String jsid = null;
    if (request.getCookies() != null) {
        for (javax.servlet.http.Cookie c : request.getCookies()) {
            if ("JSESSIONID".equals(c.getName())) {
                jsid = c.getValue();
            }
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tomcat Session Cluster Test</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        table { border-collapse: collapse; }
        th, td { border: 1px solid #888; padding: 8px 12px; }
    </style>
</head>
<body>
<h2>Tomcat 세션 클러스터 테스트 (JSP 버전)</h2>

<table>
    <tr><th>세션 ID</th><td><%= session.getId() %></td></tr>
    <tr><th>JSESSIONID (Cookie)</th><td><%= jsid %></td></tr>
    <tr><th>현재 노드 (Hostname)</th><td><%= host %></td></tr>
    <tr><th>접속 횟수 (count)</th><td><%= count %></td></tr>
</table>

<p><a href="session-test.jsp">🔄 새로고침</a></p>

</body>
</html>
