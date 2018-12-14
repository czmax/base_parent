<%@ page import="com.max.code.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<%

    User user1 = new User();
    user1.setId(1);
    user1.setName("aaa");
    user1.setAge(11);
    User user2 = new User();
    user2.setId(2);
    user2.setName("bbb");
    user2.setAge(12);
    User user3 = new User();
    user3.setId(3);
    user3.setName("ccc");
    user3.setAge(13);
    List list = new ArrayList();
    list.add(user1);
    list.add(user2);
    list.add(user3);
%>

编号：<%=user1.id %> <br>
姓名：<%=user1.name %> <br>
性别：<%=user1.sex %> <br>
年龄：<%=user1.age %> <br>

</body>
</html>
hello maven
<a href="/hello">测试</a>
</body>
</html>