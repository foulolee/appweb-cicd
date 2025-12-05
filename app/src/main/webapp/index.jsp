<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.InetAddress" %>

<%
    javax.servlet.http.HttpSession session = request.getSession();

    String hostname = InetAddress.getLocalHost().getHostName();
    String hostaddr = InetAddress.getLocalHost().getHostAddress();

    if (session.getAttribute("count") == null) {
        session.setAttribute("count", 1);
    } else {
        int count = (int) session.getAttribute("count");
        session.setAttribute("count", count + 1);
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Session Cluster Test - index.jsp</title>
</head>
<body>
    <h1>Tomcat Session Cluster Test - index.jsp</h1>

    <h3>Session Info</h3>
    <p>Session ID: <b><%= session.getId() %></b></p>
    <p>Session Count: <b><%= session.getAttribute("count") %></b></p>

    <h3>Server Node Info</h3>
    <p>Hostname: <b><%= hostname %></b></p>
    <p>IP Address: <b><%= hostaddr %></b></p>

    <hr>
    <p>새로고침하면 count 값이 증가합니다.</p>
</body>
</html>