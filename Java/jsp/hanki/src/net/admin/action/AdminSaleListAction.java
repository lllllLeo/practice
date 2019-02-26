package net.admin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.action.ActionForward;
import net.admin.db.AdminDAO;

public class AdminSaleListAction implements Action {

    
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AdminDAO addao = new AdminDAO();
        
        List adsallist = null;
       
       
        String Store_name = (String) request.getSession().getAttribute("store_name");
       
        adsallist = addao.showSale(Store_name); //����Ʈ�� �޾ƿ�.
        System.out.println("adsallist 나왔음");
        request.setAttribute("adsallist", adsallist);
        ActionForward forward= new ActionForward();
        forward.setRedirect(false);
        forward.setPath("./storelist.jsp");
        return forward;
    }

}
