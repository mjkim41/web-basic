<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>


  <%--
    String name = (String) request.getAttribute("name");
    String crewName = (String) request.getAttribute("crew");
    String danceLevel = (String) request.getAttribute("level");
  --%>

 <%--  ////
    servlet 에서 setAttribute(String 속성이름, Object 속성값)으로 정보를 전달하면,
    jsp에서는 getAttribute 혹은  ${}라는 expressive language(EL)를 통해 정보를 가져올 수 있음
    이 때, ${dance.crew} 이런식으로 입력하면, crew가 private field 더라도 알아서 jsp에서 dance.getCrew()의 값을 가져 옴.
      --%>

  <%-- //// <%= => : System.out.println --%>
  <h1>댄서 등록 결과 페이지입니다.</h1>
  <h2>${dancer.name}님 (소속: ${dancer.crewName})이 정상 등록되었습니다.</h2>
  <h3>댄스 수준: ${dancer.danceLevel}</h3>


  <a href="/mvc/v1/register"> 다시 등록하러 가기 </a>
  <a href="/mvc/v1/show"> 댄서 목록 조회하기</a>
</body>
</html>