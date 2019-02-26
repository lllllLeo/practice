package net.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.db.AdminBean;
import net.admin.db.AdminDAO;

public class AdminJoinAction implements Action {
   
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      request.setCharacterEncoding("UTF-8");
      AdminDAO admindao = new AdminDAO();
      AdminBean adminbean = new AdminBean();
      ActionForward forward = new ActionForward();
      HttpSession session = request.getSession();
      boolean result = false;
      
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      String store_name = request.getParameter("store_name");
      
      adminbean.setId(id);
      adminbean.setPw(pw);
      adminbean.setStore_name(store_name);
      
      result = admindao.storeReg(adminbean);
         
      if(result==false) {
         System.out.println("가입 실패 (AdminJoinAction)");
         session.setAttribute("suc", 1);
         forward.setPath("./adminJoin.ad");
         forward.setRedirect(true);         //������ true ��
         return forward;
      }
      
      System.out.println("���� ��� ���� (AdminJoinAction)");
      
      session.setAttribute("suc", 0);
      forward.setPath("./admin.ad");
      forward.setRedirect(true);         //������ true ��
      return forward;
   }

}