<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<html>
<head>
    <title>JSTL x:parse Tags</title>
</head>
<body>
<h3>Books Info:</h3>
<c:import var="Person" url="http://localhost:9101/xml/helloXmlPerson/abc"/>

<x:parse xml="${Person}" var="output"/>
<b>name</b>:
<x:out select="$output/Person[1]/name"/>
<br>
<b>sex</b>:
<x:out select="$output/Person[1]/sex"/>
<b>age</b>:
<br>
<x:out select="$output/Person[1]/age"/>
</body>
</html>

