package http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestLine {
    private static final Logger log = LoggerFactory.getLogger(RequestLine.class);

    private HttpMethod method;

    private String path;

    private String queryString;


    public RequestLine(String requestLine) {
        log.debug("request line : {}", requestLine);
        String[] tokens = requestLine.split(" ");
        this.method = HttpMethod.valueOf(tokens[0]);

//      \은 \ 다음의 문자를 이스케이프함. 그래서 \를 찾으려면 \\
//      ?는 문자가 없거나 하나인 것
        String[] url = tokens[1].split("\\?");
        this.path = url[0];

        if (url.length == 2) {
            this.queryString = url[1];
        }
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getQueryString() {
        return queryString;
    }
}