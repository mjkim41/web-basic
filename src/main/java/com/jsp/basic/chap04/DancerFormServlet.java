package com.jsp.basic.chap04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// @WebServlet(path) : 이 path로 http에서 요청이 오면, 이 servlet에서 처리해라
@WebServlet("/mvc/v1/register")
// HttpServlet을 상속받은 DancerFormServlet 객체를 main 클래스의 tomcat 에서 자동으로 생성
public class DancerFormServlet extends HttpServlet {

    @Override
    // tomcat에 의해 DanceFormServlet.service() 메서드가 자동으로 실현될 건데,실행될 때 구현할 코드를 여기에 작성
    // HttpServletRequest, HttpServletResponse는 tomcat이 내부 구현 원리에 의해 전달해줌
    // 아래 코드는 메서드를 정의하는 것임.
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // java 코드로 비즈니스 로직 처리하는 코드 작성 하기에는 servlet이더 편하지만
        // html 생성은 jsp로 코드 짜기가 더 편하니까 jsp에 시켜 버리자
        // 그렇게 하기 위해 view forwarding을 하자(보이는 view, 즉 html은 jsp에 시키자.
        RequestDispatcher dispatcher
                // HttpServletResponse.getRequestDispacher(리소스) :
                //  -> 특정 리소스(예: JSP, 서블릿 등)의 경로를 인수로 받아 RequestDispatcher 객체를 반환합니다.
                = req.getRequestDispatcher("/WEB-INF/chap04/dancer/register.jsp");

        // 위에서 만든 RequestDispatcher를 jsp 파일에 보내자
        dispatcher.forward(req, resp);

    }
}