package me.yujun;

import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 이 이벤트는 웹서버가 초기화가 되면 / 생성이 되면 이 이벤트 리스너가 호출이 된다. (오버라이드된 메서드)
 * <p>
 * 호출이 되면 이 이벤트리스너에서 applicationContext를 꺼낸다.
 */
@Component
public class PortListener implements ApplicationListener<ServletWebServerInitializedEvent> {
    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent servletWebServerInitializedEvent) {
        ServletWebServerApplicationContext applicationContext = servletWebServerInitializedEvent.getApplicationContext();   // web application context를 꺼낸다.
        System.out.println(applicationContext.getWebServer().getPort());   // 이 applicationContext를 통해서 WEB server를 알 수 있고 또 Port를 알 수 있다.
    }
}
