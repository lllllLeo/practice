package next.web;

import core.db.DataBase;
import next.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/user/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        log.info("id는 : {}, pw는 : {}", userId, password);
        User DbUser = DataBase.findUserById(userId);
        if ( DbUser != null ) {
            log.info("있는 사용자네");
            if(!DbUser.matchPassword(password)){
                log.info("비밀번호가 틀렸습니다.");
                session.setAttribute("loginFailed", true);
                forward(req, resp);
                return;
            }

            session.setAttribute("session", DbUser);
            resp.sendRedirect("/");
            return;
        }
            log.info("존재하지 않는 사용자입니다.");
            session.setAttribute("loginFailed", true);
            forward(req, resp);

    }

    private void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/user/login.jsp");
        rd.forward(req, resp);
    }
}
