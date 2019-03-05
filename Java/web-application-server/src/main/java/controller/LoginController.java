package controller;

import db.DataBase;
import http.HttpRequest;
import http.HttpResponse;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.HttpRequestUtils;

import java.util.Map;

public class LoginController extends AbstractController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Override
    public void doPost(HttpRequest request, HttpResponse response) {
        log.info("LoginController");
        log.debug("UserId : {}, password : {}", request.getParameter("userId"), request.getParameter("password"));
        User user = DataBase.findUserById(request.getParameter("userId"));
        if (user == null) {
            log.debug("User Not Found!");
            response.sendRedirect("/user/login_failed.html");
        } else if (user.login(request.getParameter("password"))) {
            log.debug("Login Success!");
            response.addHeader("Set-Cookie", "logined=true");
            response.sendRedirect("/index.html");
        } else {
            log.debug("Password Mismatch!");
            response.sendRedirect("/user/login_failed.html");
        }
    }
}
