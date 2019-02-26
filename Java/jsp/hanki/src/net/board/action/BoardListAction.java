package net.board.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardDAO;

 public class BoardListAction implements Action {
   
    public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
      request.setCharacterEncoding("UTF-8");
      BoardDAO boarddao=new BoardDAO();  //DB����
      List boardlist=new ArrayList();
      
        int page=1;
      int limit=10;
      
      if(request.getParameter("page")!=null){
         page=Integer.parseInt(request.getParameter("page"));
      }
      
      int listcount=boarddao.getListCount(); //�� ����Ʈ ���� �޾ƿ�.
      boardlist = boarddao.getBoardList(page,limit); //����Ʈ�� �޾ƿ�.
      
      //�� ������ ��.
         int maxpage=(int)((double)listcount/limit+0.95); //0.95�� ���ؼ� �ø� ó��.
         //���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
         int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
         //���� �������� ������ ������ ������ ��.(10, 20, 30 ��...)
         int endpage = maxpage;
         
         if (endpage>startpage+10-1) endpage=startpage+10-1;
         
         request.setAttribute("page", page);        //���� ������ ��.
         request.setAttribute("maxpage", maxpage); //�ִ� ������ ��.
         request.setAttribute("startpage", startpage); //���� �������� ǥ���� ù ������ ��.
         request.setAttribute("endpage", endpage);     //���� �������� ǥ���� �� ������ ��.
      request.setAttribute("listcount",listcount); //�� ��.
      request.setAttribute("boardlist", boardlist); //�Խ��� �� .
      System.out.println(page);
      System.out.println(maxpage);
      System.out.println(startpage);
      System.out.println(endpage);
      System.out.println(listcount);
      System.out.println(boardlist);
      
      ActionForward forward= new ActionForward();
         forward.setRedirect(false);
         forward.setPath("/hanki/board/qna_board_list.jsp");
         return forward;
    }
 }