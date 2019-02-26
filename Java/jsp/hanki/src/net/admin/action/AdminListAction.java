package net.admin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.action.ActionForward;
import net.admin.db.AdminDAO;

public class AdminListAction implements Action {

    
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AdminDAO addao = new AdminDAO();
        
        List adlist = null;
       
       
        System.out.println("���ڽ���");
       
       
        adlist = addao.showAd(); //����Ʈ�� �޾ƿ�.
        
      
        request.setAttribute("adlist", adlist);
        System.out.println("���⵵ ������");
        ActionForward forward= new ActionForward();
        forward.setRedirect(false);
        forward.setPath("./adminShow.jsp");
        return forward;
    }

}
