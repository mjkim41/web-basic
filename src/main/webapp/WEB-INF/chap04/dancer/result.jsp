<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>

  <%--  servlet 에서 setAttribute 한 것을 getAttribute나 --%>
  <%-- ${}라는 expressive language(el)로 가져오기 --%>
  <%-- dance.crew라고 히면 알아서 el에서 dance.getcrew()를 가져옴--%>
  <%-- 객체로 가져옴 --%>

  <%--
    String name = (String) request.getAttribute("name");
    String crewName = (String) request.getAttribute("crew");
    String danceLevel = (String) request.getAttribute("level");
  --%>


  <%-- <%= => : System.out.println --%>
  <h1>댄서 등록 결과 페이지입니다.</h1>
  <h2>${dancer.name}님 (소속: ${dancer.crewName})이 정상 등록되었습니다.</h2>
  <h3>댄스 수준: ${dancer.danceLevel}</h3>


  <a href="/mvc/v1/register"> 다시 등록하러 가기 </a>
  <a href="/mvc/v1/show"> 댄서 목록 조회하기</a>
</body>
</html>