package com.jsp.basic.chap04;

import com.jsp.basic.chap02.DanceLevel;
import com.jsp.basic.chap02.Dancer;
import com.jsp.basic.chap02.DancerList;
import com.jsp.basic.chap02.Genre;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 새로운 댄서 정보를 리스트(데이터베이스)에 등록하기 위해
// 댄서 정보들을 읽어와서 리스트에 저장하는 처리
@WebServlet("/mvc/v1/process")
public class AddNewDancerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String crewName = req.getParameter("crewName");
        String danceLevel = req.getParameter("danceLevel");
        String[] genres = req.getParameterValues("genres");

        List<Genre> genreList = new ArrayList<>();
        for (String g : genres) {
            genreList.add(Genre.valueOf(g));
        }

        Dancer dancer = new Dancer(
                name, crewName, DanceLevel.valueOf(danceLevel), genreList
        );

        DancerList.addDancer(dancer);

        /*
          Servlet이 JSP으로 클라이언트의 요청을 전달해 주기 전에,
          먼저 HttpRequestServlet에 필요한 정보를 전달해주어야 함
          => 어떻게??
          => 1) Servlet에서 HttpRequestServlet.setAttribute(속성이름, 속성값)로 전달하고자 하는 정보 저장
            2) JSP에서 EL(Expressive Language)인 ${}로 정보를 가져올 수 있음
         */
        /* req.setAttribute("name", name);
        req.setAttribute("crew", crewName);
        req.setAttribute("level", danceLevel);
        */
        req.setAttribute("dancer", dancer);

        /*
          (FYI. Servlet -> JSP 클라이언트 요청 전달 방법 :
              1) req.getRequestDispatcher(리소스 경로)로 RequestDispatcher 객체 생성
              2) RequestDispatcher.forward(HttpRequestServlet, HttpResponseServlet)로 jsp에 요청 전달)
        */
        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/WEB-INF/chap04/dancer/result.jsp");
        dispatcher.forward(req, resp);

    }
}