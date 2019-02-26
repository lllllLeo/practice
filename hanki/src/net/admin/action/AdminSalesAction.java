package net.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.db.AdminBean;
import net.admin.db.AdminDAO;

public class AdminSalesAction implements Action {
   
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      request.setCharacterEncoding("UTF-8");
      AdminDAO admindao = new AdminDAO();
      AdminBean adminbean = new AdminBean();
      ActionForward forward = new ActionForward();
      HttpSession session = request.getSession();
      boolean result = false;
      
      String date = request.getParameter("date");
      int sal = Integer.parseInt(request.getParameter("sal"));
      String store_name = request.getParameter("store_name");
      
     // adminbean.setId(id);
    //  adminbean.setPw(pw);
      result = admindao.inputStatis(date, sal, store_name);
      
         
      if(result==false) {
         System.out.println("실패 (AdminJoinAction)");
         session.setAttribute("suc", 1);
         forward.setPath("./adminsales.ad");
         forward.setRedirect(true);         //������ true ��
         return forward;
      }
      
      
      session.setAttribute("succ", 0);
      forward.setPath("./adminsales.ad");
      forward.setRedirect(true);         //������ true ��
      return forward;
   }

}