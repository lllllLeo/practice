package me.yujun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        SpringApplication application = new SpringApplication(Application.class);
//        application.setWebApplicationType(WebApplicationType.NONE);
/*X
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        String docBase = Files.createTempDirectory("tomcat-basedir").toString();

        Context context = tomcat.addContext("/", docBase);

        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
                PrintWriter writer = res.getWriter();
                writer.println("<html><head><title>");
                writer.println("Hey, Tomcat");
                writer.println("</title></head>");
                writer.println("<body><h1>hihihihi</h1></body>");
                writer.println("</html>");
            }
        };

        String servletName = "helloServlet";
        tomcat.addServlet("/", servletName, servlet);   // contextPath인 / 에 뷰이름과 코드 추가
        context.addServletMappingDecoded("/hello", servletName); // "/hello" 로 요청이 오면 위 두줄의 Servlet을 보여준다. 즉 위에 @Override한 서블릿

        tomcat.start();
        tomcat.getServer().await();
        */
    }

}
