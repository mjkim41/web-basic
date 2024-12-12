<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>

      <%-- //// --%>
      <%-- //// --%>
      <%-- //// --%>

  <%-- //// Maven으로 빌드할 경우, url만 입력하면 보이는 메인페이지는 루트 디렉토리(기본세팅 : webapp 폴더)에 index.jsp 파일이 불러와짐 --%>
  <%-- //// 만약 초기 페이지를 다른 파일로 설정하고 싶다면, web.xml 파일에서 설정 가능 --%>
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