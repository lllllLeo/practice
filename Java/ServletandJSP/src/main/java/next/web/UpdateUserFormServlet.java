package next.web;

import core.db.DataBase;
import next.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/update")
public class UpdateUserFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        System.out.println(userId);
        User user = DataBase.findUserById(userId);
        req.setAttribute("user", user);
        System.out.println(user.toString());
        RequestDispatcher rd = req.getRequestDispatcher("/user/update.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = DataBase.findUserById(req.getParameter("userId"));
        User updateUser = new User(user.getUserId(), req.getParameter("password"), req.getParameter("name"), req.getParameter("email"));
        user.updateUser(updateUser);
        req.setAttribute("users", user);
        System.out.println("바꼈나요? "+user.toString());
        resp.sendRedirect("/user/list");
//        RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
//        rd.forward(req, resp);
    }
}
