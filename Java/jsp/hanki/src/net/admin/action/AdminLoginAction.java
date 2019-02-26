package net.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.db.AdminBean;
import net.admin.db.AdminDAO;

public class AdminLoginAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      AdminDAO admindao = new AdminDAO();
      AdminBean adminbean = new AdminBean();
      ActionForward forward = new ActionForward();
      
      String result = "";
      
      HttpSession session = request.getSession();
      
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      
      System.out.println(id);
      System.out.println(pw);
      
      result = admindao.login(id,pw);
      
      if(result==null) {
         System.out.println("들어옴ㅎㅎ (AdminLoginAction)");
         session.setAttribute("error", 0);
         forward.setRedirect(true);
         forward.setPath("../page/adminLogin.jsp");
         return forward;
      }
      System.out.println("들어옴(AdminLoginAction)");
      
      session.setAttribute("id", id);
      session.setAttribute("store_name", result);
      request.setAttribute("store_name", result);
      
      forward.setRedirect(true);
      forward.setPath("./admin.ad");
      return forward;
   }

}