package net.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.db.AdminDAO;
import net.admin.db.AdminSalesBean;


public class AdminSalDeleteAction implements Action {
   
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      request.setCharacterEncoding("UTF-8");
      AdminDAO admindao = new AdminDAO();
      ActionForward forward = new ActionForward();
      HttpSession session = request.getSession();
      boolean result = false;

      int sal = Integer.parseInt(request.getParameter("sales"));
      String date = request.getParameter("date");
      result = admindao.adsaldel(date,sal);
         
      if(result==false) {
         System.out.println("삭제실패 (AdminDeletesalAction)");
         return null;
      }
      
      System.out.println("삭제성공 (AdminDeletesalAction)");
      
      session.setAttribute("sucsal", 0);
      forward.setPath("./adminsaleslist.ad");
      forward.setRedirect(true);         //������ true ��
      return forward;
   }

}