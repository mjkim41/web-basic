<!-- utf 등 java 코드로 -->
 <!--  page source 보기에는 안나옴  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>

  <!-- <% %> </% %> 해서 java 코드 넣음 -->
  <% for (int i = 0; i < 3; i++) { %>
    <h1>Hello JSP!</h1>
  <% } %>
  <a href="https://www.naver.com" target="_blank">네이버</a>
</body>
</html>