package com.jsp.basic.chap02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/chap02/dancer/process")
public class DancerProcessServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("댄서 등록 수행중....");
        String name = req.getParameter("name");
        String crewName = req.getParameter("crewName");
        String danceLevel = req.getParameter("danceLevel");
        // req.getParameterValues() : String[] 반환
        String[] genres = req.getParameterValues("genres");


        /* 1. 문제
          - String[]을 어떻게 ArrayList<ENUM>으로 받지?
            즉, String b = {HIPHOP, KPOP}을 어떻게  ArrayList<ENUM> a = newArrayList<> (List.of(HIPHOP, KPOP))으로 바꾸지?

           2. 해결 방안
             1) 빈 ArrayList<ENUM>을 만든다.
             2) String[]인 {HIPHOP, KPOP}을 반복문으로 돌아가면서,
                ENUM.valueOf("HIPHOP") 이런식으로 ENUM 상수로 바꿔준다.
             3) 1에서 만든 빈 ArrayList<ENUM>에, add()를 이용하여 2의 값을 넣어준다.
        */
        List<Genre> genreList = new ArrayList<>();
        for (String g : genres) {
            genreList.add(Genre.valueOf(g));
        }

        /*
           string으로 받은 값을 어떻게 똑같은 이름을 가진 enum class의 상수로 변환해주지?
           (예시: 'BEGINNER'라는 문자열을 받으면 동일한 이름을 가진 ENUM의 상수인 'BEGINNER'로 어떻게 변환하지?)
           -> ENUM CLASS명.valueOf(BEGINNER
              (Enum.valueOf(String name) : 주어진 문자열과 일치하는 enum 상수를 반환)
        */

        Dancer dancer = new Dancer(
                name, crewName, DanceLevel.valueOf(danceLevel), genreList
        );
//        System.out.println("dancer = " + dancer);

        DancerList.addDancer(dancer);

        // 목록에 잘 쌓이는지 확인
        List<Dancer> dancerList = DancerList.getDancerList();
        dancerList.forEach(System.out::println);

        // 응답 html 생성
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();

        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("</head>\n");
        w.write("<body>\n");

        w.write("<h1>" + dancer.getName() + "님이 등록되었습니다. </h1>");
        w.write("<a href=\"/chap02/dancer/show-list\">댄서 정보 모아보기</a>");

        w.write("</body>\n");
        w.write("</html>");

    }
}