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
  <!-- src > main > webapp 폴더에 저장해야 함 -->
   <!-- jsp는 java에서 html를 쓰는 라이브러리 -->
  <!-- jsp .jsp 파일을 넣으면 ,  tomcat8181.root>apache>jsp 에 맞게  servlet 형식으로 변환해줌 -->


  <!-- <% %> </% %> 해서 java 코드 넣음 -->
  <% for (int i = 0; i < 3; i++) { %>
    <h1>Hello JSP!</h1>
  <% } %>
  <a href="https://www.naver.com" target="_blank">네이버</a>
</body>
</html>