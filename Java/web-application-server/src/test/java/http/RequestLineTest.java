package http;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RequestLineTest {
    @Test
    public void create_method(){
        RequestLine line = new RequestLine("GET /index.html HTTP/1.1");
        assertEquals(HttpMethod.GET, line.getMethod());
        assertEquals("/index.html", line.getPath());

        line = new RequestLine("POST /index.html HTTP/1.1");
        assertEquals(HttpMethod.POST, line.getMethod());
    }

    @Test
    public void create_path_and_QueryString(){
        RequestLine line = new RequestLine("GET /user/create?userId=yjworld&password=1234 HTTP/1.1");
        assertEquals(HttpMethod.GET,line.getMethod());
        assertEquals("/user/create", line.getPath());
        assertEquals("userId=yjworld&password=1234",line.getQueryString());

    }
}
