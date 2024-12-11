package com.jsp.basic;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class Main {

    public static void main(String[] args) throws LifecycleException {

        // Tomcat이나 웹 서버가 **정적 콘텐츠**를 찾을 위치
        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();

        // 웹 에플리케이션의 포트 번호 설정
        //보통 8080으로 설정.
        //FYI. 포트(PORT) :  네트워크에서 특정 애플리케이션이나 서비스를 식별하기 위해 사용되는 숫자
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8181";
        }

        // TOMCAT의 포트 설정
        tomcat.setPort(Integer.parseInt(webPort));
        //  Tomcat이 HTTP 요청을 수신하고 처리하는 역할을 하며, 포트 번호와 프로토콜(예: HTTP)을 설정하는 기능을 합니다.
        //이 메서드는 Tomcat 서버의 연결 지점(포트)을 가져오는 역할을 하며, 이를 통해 서버의 설정이나 작동을 더 세밀하게 다룰 수 있습니다.
        tomcat.getConnector();

        // Tomcat 서버에 웹 어플리케이션을 추가한다
        // -> 이 웹 어플리케이션을 rooth에 배포한다 (즉, http://localhost:포트번호/에서 이 애플리케이션에 접근할 수 있게 됩니다.)
        // -> 웹 애플리케이션의 실제 파일 경로를 지정
        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

        // Declare an alternative location for your "WEB-INF/classes" dir
        // Servlet 3.0 annotation will work
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await(); // tomcat 서버 실행이 완료될 때 까지 대기
    }
}
