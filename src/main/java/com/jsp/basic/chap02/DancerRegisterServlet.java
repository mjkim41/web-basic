package com.jsp.basic.chap02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
    [이 class 구현 내용]
    만약에 클라이언트가
    /chap02/dancer/register 라고 요청하면
    새로운 댄서정보를 등록할 수 있는 HTML form을 생성해서 응답해주세요
 */

// http://url/chap02/dancer/show-list로 오는 요청은 이 servlet에서 받겠다.
@WebServlet("/chap02/dancer/register")
// 클라이언트의 요청을 받아서 html를 생성할 수 있는 Servlet class을 만들겠다.
public class DancerRegisterServlet extends HttpServlet {

    @Override
    // FYI. Main에서 Tomcat.start()를 하면,
    // 1) 자동으로 클라이언트가 url/chap02/dancer/register를 요청하면 이 클래스(DancerRegisterServlet)가 생성됨
    // 2) 그러면서 자동으로 HttpServletRequest, HttpServletResponse도 생성되고,
    // 3) 아래의 service()가 호출되면서 이 메서드의 인자로 전다로딤
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();

        // 개발자도구 response에서도 코드 확인 가능
        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("<style>\n");
        w.write("label { display: block; }\n");
        w.write("</style>\n");
        w.write("</head>\n");
        w.write("<body>\n");
        // <form action=\"/path\" method=\"get\"> : form을 누르면 해당 path 로 이동해라.
        w.write("<form action=\"/chap02/dancer/process\" method=\"get\" id=\"reg-form\">");
        // form 안에 input을 넣고, input에 <name="crewName" value="professional">이라고 입력 필드의 이름과 값을 지정하면
        //   form action에 적힌 path로 이동하면서 이 때 스트링 쿼리로 ?crewName=professional 가 추가됨
        w.write("<label># 이름 : <input type=\"text\" name=\"name\"></label>");
        w.write("<label># 크루이름 : <input type=\"text\" name=\"crewName\"></label>");
        w.write("<label># 레벨 :<input type=\"radio\" name=\"danceLevel\" value=\"PROFESSIONAL\"> 프로 <input type=\"radio\" name=\"danceLevel\" value=\"AMATEUR\"> 아마추어 <input type=\"radio\" name=\"danceLevel\" value=\"BEGINNER\"> 초보자 </label>");
        w.write("<label># 장르 :<input type=\"checkbox\" name=\"genres\" value=\"HIPHOP\"> 힙합 <input type=\"checkbox\" name=\"genres\" value=\"STREET\"> 스트릿 <input type=\"checkbox\" name=\"genres\" value=\"KPOP\"> 케이팝 </label>");
        w.write("<label><button id=\"reg-btn\" type=\"submit\">등록</button></label>");
        w.write("</form>");
        w.write("</body>\n");
        w.write("</html>");



    }
}