package net.admin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.db.AdminBean;
import net.admin.db.AdminDAO;
import net.admin.db.AdminSalesBean;

public class AdminSalDailyAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      AdminDAO admindao = new AdminDAO();
      AdminSalesBean adminsalesbean = new AdminSalesBean();
      ActionForward forward = new ActionForward();
      
      List result = null;
      
      HttpSession session = request.getSession();
      
  
      String Store_name = (String)request.getSession().getAttribute("store_name");
      result = admindao.showSale(Store_name);
      System.out.println(result);
      
      
      if(result == null) {
         System.out.println("들어옴ㅎㅎ (AdminLoginAction)");
         session.setAttribute("error", 1);
         forward.setRedirect(true);
         forward.setPath("./admin.ad");
         return forward;
      }
      System.out.println("들어옴(AdminLoginAction)");
      System.out.println(result.get(0));
      session.setAttribute("chartlist", result);
     
      forward.setRedirect(true);
      forward.setPath("./storeChart.ad");
      return forward;
   }

}