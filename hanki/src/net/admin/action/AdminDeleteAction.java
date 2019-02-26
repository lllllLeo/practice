package net.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.db.AdminBean;
import net.admin.db.AdminDAO;

public class AdminDeleteAction implements Action {
   
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      request.setCharacterEncoding("UTF-8");
      AdminDAO admindao = new AdminDAO();
      ActionForward forward = new ActionForward();
      HttpSession session = request.getSession();
      boolean result = false;

      String store_name = request.getParameter("store_name");
      result = admindao.addel(store_name);
         
      if(result==false) {
         System.out.println("삭제실패 (AdminDeleteAction)");
         return null;
      }
      
      System.out.println("삭제성공 (AdminDeleteAction)");
      
      session.setAttribute("suc", 0);
      forward.setPath("./adminManage.ad");
      forward.setRedirect(true);         //������ true ��
      return forward;
   }

}