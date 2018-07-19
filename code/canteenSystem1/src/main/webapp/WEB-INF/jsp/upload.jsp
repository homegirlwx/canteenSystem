<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Self-checkout canteen</title>
</head>
<body>
    ${user.userName},欢迎您进入Self-checkout canteen，您当前余额为${user.credits};
</body>
<body>
  <form action="/Photo.html" method="POST" enctype="multipart/form-data">
    <input type="file" name="fileName"/>
    <input type="submit" value="Upload"/>
  </form>


    <span>${msg}</span><br>


        <img src="/show?fileName=${fileName}" style="width: 200px"/>



</body>
</html>
