package webserver;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.xpath.internal.operations.Bool;
import controller.Controller;
import controller.CreateUserController;
import controller.ListUserController;
import controller.LoginController;
import db.DataBase;
import http.HttpRequest;
import http.HttpResponse;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.HttpRequestUtils;
import util.IOUtils;

/* RequestHandler
*  Thread를 상속하고 있으며 사용자의 요청에 대한 처리와 응답에 대한 처리를 담당하는 가장 중심이 되는 클래스.
*
*  InputStream
*  클라이언트에서 서버로 요청을 보낼 때 전달되는 데이터를 담당하는 스트림
*
*  OutputStream
*  서버에서 클라이언트에 응답을 보낼 때 전달되는 데이터를 담당하는 스트림
*  */
public class RequestHandler extends Thread {
    private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);

    private Socket connection;

    public RequestHandler(Socket connectionSocket) {
        this.connection = connectionSocket;
    }

    public void run() {
        log.debug("New Client Connect! Connected IP : {}, Port : {}", connection.getInetAddress(),
                connection.getPort());

        try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
//            String line = br.readLine();
//            if (isEmpty(line)) { return; }
            HttpRequest request = new HttpRequest(in);
            HttpResponse response = new HttpResponse(out);

            boolean logined = false;
//            while( !"".equals(line)){
//                log.debug("header : {}", line);
//                line = br.readLine();
//                if(line.contains("Cookie")){
//                    logined = isLogin(line);
//                }
//            }

            log.debug("Content-length : {}", request.getHeader("Content-Length"));
            Controller controller = RequestMapping.getController(request.getPath());
            if (controller == null) {
                String url = getDefaultPath(request.getPath());
                response.forward(url);
            } else {
                controller.service(request, response);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private String getDefaultPath(String path) {
        if ("/".equals(path)){
            path = "/index.html";
        }
        return path;
    }

    private boolean isEmpty(String line) {
        if (line == null) {
            return true;
        }
        return false;
    }
}
