<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <!-- 이름을  index로 저장하면, 주소창에 /path 안하면 그 페이지로 이동 -->
  <h1>자바 웹 고전 기술 알아보기</h1>
  <ul>
    <!-- a href="path" -->
    <li>
      <a href="/chap02/dancer/register">댄서 등록하기(서블릿 버전)</a>
    </li>

    <li>
      
      <!-- 사용자는 WEBAPP의 주소가 아니라, 가상의 주소를 받음 -->
       <!-- MVC/V1 일단 servlet이 받음 -->
      <a href="/mvc/v1/register">댄서 등록하기(MVC-V1)</a>
    </li>
  </ul>
  
</body>
</html>