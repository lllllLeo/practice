package net.reserve.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.reserve.action.Action;
import net.reserve.action.ActionForward;
import net.qna.db.QnaDAO;

 public class QnaListAction implements Action {
   
    public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
      request.setCharacterEncoding("UTF-8");
      QnaDAO qnadao = new QnaDAO();
      List qnalist=new ArrayList();
      
        int page=1;
      int limit=10;
      
      if(request.getParameter("page")!=null){
         page=Integer.parseInt(request.getParameter("page"));
      }
      
      int listcount=qnadao.getListCount(); //�� ����Ʈ ���� �޾ƿ�.
      qnalist = qnadao.getQnaList(page,limit); //����Ʈ�� �޾ƿ�.
      
         int maxpage=(int)((double)listcount/limit+0.95); 
         int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
         int endpage = maxpage;
         
         if (endpage>startpage+10-1) endpage=startpage+10-1;
         
         request.setAttribute("page", page);       
         request.setAttribute("maxpage", maxpage);
         request.setAttribute("startpage", startpage);
         request.setAttribute("endpage", endpage);    
      request.setAttribute("listcount",listcount); 
      request.setAttribute("qnalist", qnalist); 
      System.out.println(maxpage);
      System.out.println(startpage);
      System.out.println(endpage);
      System.out.println(listcount);
      System.out.println(qnalist);
      
      ActionForward forward= new ActionForward();
         forward.setRedirect(false);
         forward.setPath("/hanki/board/cus_board_list.jsp");
         return forward;
    }
 }