<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- //// <%@ taglib prefix="c" uri="라이브러리 uri"> : uri에 적힌 라이브러리를 가져올 건데, 이 라이브러리를 jsp에서 사용할 때는 prefix인 c를 사용하여 <c: > 형태로 쓰겠다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    .del-btn {
        padding: 5px 10px;
        outline: none;
        border: none;
        background: red;
        border-radius: 10px;
        color: #fff;
        margin-left: 10px;
        margin-bottom: 10px;
        cursor: pointer;
    }
    .del-btn:hover {
        border: 1px solid orange;
        opacity: 0.8;
    }
</style>
</head>
<body>
  <h1>MVC 댄서 정보 목록</h1>
  <ul id="dancer-list">

    <%--
      /// 코드 두번째 줄에서 c라는 prefix는 jstl 라이브러리를 가져오는 것이라고 설정함
      /// 따라서, <c:forEach>는 jstl 태그의 forEach 태그를 쓰겠다는 말임
     --%>
    <c:forEach var="d" items="${dancers}">
      <li>
        # 이름: <span class="dancer-name">${d.name}</span>,
        # 크루명: ${d.crewName},
        # 수준: ${d.danceLevel}
        <button class="del-btn">삭제</button>
      </li>
    </c:forEach>
     <%--  ////  이렇게 하면, 이 파일이 servlet으로 변환되면서 자동으로 태그를 생성해줌 --%>
  </ul>

  <a href="/mvc/v1/register">다시 등록하기</a>

  <script>
    // li 태그들에게 인덱스 부여하기
    [...document.querySelectorAll('li')].forEach(($li, i) => {
      $li.dataset.index = i;
    });

    const $dancerList = document.getElementById('dancer-list');
    $dancerList.addEventListener('click', e => {
      if (!e.target.matches('.del-btn')) return;
      const $targetLi = e.target.closest('li');
      const index = $targetLi.dataset.index;


      // 삭제 요청 보내기
      window.location.href='/mvc/v1/remove?id=' + index;

    });
  </script>

</body>
</html>