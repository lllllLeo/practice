package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.qna.db.QnaBean;
import net.qna.db.QnaDAO;

 public class BoardqnaDetailAction implements Action {
    public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
      request.setCharacterEncoding("UTF-8");
         
      	QnaDAO qnadao=new QnaDAO();
         QnaBean qnabean=new QnaBean();
         
         int num=Integer.parseInt(request.getParameter("num"));
         
      qnabean=qnadao.getDetail(num);
         
         if(qnabean==null){
            System.out.println("상세보기 실패");
            return null;
         }
         System.out.println("상세보기 성공 ");
         
         request.setAttribute("qnabean", qnabean);
         ActionForward forward = new ActionForward();
         forward.setRedirect(false);
         forward.setPath("/hanki/board/cus_board_view.jsp");
         return forward;

    }
}