<%-- //// Maven 빌드 도구 사용 시, JSP 파일은 정적 웹페이지 저장 위치인 webapp 경로 저장 --%>
<%-- //// <%@ page %> : 페이지 설정 관련 JSP 지시어 문법 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.jsp.basic.chap02.*" %>

<%-- //// <% %> : JAVA 코드 --%>
<%-- //// 어떻게 request 객체가 생성되냐? JSP 파일은 템플릿일 뿐이고, WAS에 의해 JSP가 servlet으로 자동 변환되면, 그 때 WAS가 자동으로 클라이언트의 요청이 들어오면 servlet 객체를 생성하면서 httpReqeustServlet을 생성함 --%>
<%
  String name = request.getParameter("name");
  String crewName = request.getParameter("crewName");
  String danceLevel = request.getParameter("danceLevel");
  String[] genres = request.getParameterValues("genres");

  List<Genre> genreList = new ArrayList<>();
  for (String g : genres) {
      genreList.add(Genre.valueOf(g));
  }

  Dancer dancer = new Dancer(
        name, crewName, DanceLevel.valueOf(danceLevel), genreList
  );

  DancerList.addDancer(dancer);
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <h1> <%= dancer.getName() %>님이 등록되었습니다.</h1>
  <a href="/chap03/dancer/show-list.jsp">댄서 목록 모아보기</a>
</body>
</html>