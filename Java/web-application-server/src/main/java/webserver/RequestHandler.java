package webserver;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Map;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.HttpRequestUtils;

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
            String line = br.readLine();
            if (isEmpty(line)) { return;}
            String url = HttpRequestUtils.getUrl(line);
            if (url.startsWith("/user/create")) {
                int index = url.indexOf("?");
                String requestPath = url.substring(0, index);
                String queryString = url.substring(index + 1);
                Map<String, String> params = HttpRequestUtils.parseQueryString(queryString);
                User user = new User(params.get("userId"),params.get("password"), params.get("name"), params.get("email"));
                log.debug("User : {}", user);
            }
            url = "/index.html";

//            readLine(br, line);

            DataOutputStream dos = new DataOutputStream(out);
            byte[] body = Files.readAllBytes(new File("./webapp" + url).toPath());
            response200Header(dos, body.length);
            responseBody(dos, body);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void readLine(BufferedReader br, String line) throws IOException {
        while(!"".equals(line)){
            log.info("header : {}", line);
            line = br.readLine();
        }
    }

    private boolean isEmpty(String line) {
        if (line == null) {
            return true;
        }
        return false;
    }

    private void response200Header(DataOutputStream dos, int lengthOfBodyContent) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void responseBody(DataOutputStream dos, byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
