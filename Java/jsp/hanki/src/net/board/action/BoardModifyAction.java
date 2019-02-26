package net.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.*;

 public class BoardModifyAction implements Action {
    public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
       throws Exception{
//       DAO, Bean, forward 객체 만들고 게시판에 글번호와 비밀번호를 DAO에 전해주고 거기서 true로 넘어오면 끝
//       사용자가 맞으면 빈에 글번호, 제목, 내용을 담고 다시 DAO에가서 
       request.setCharacterEncoding("euc-kr");
       ActionForward forward = new ActionForward();
       boolean result = false;
               System.out.println(request.getParameter("num"));
               System.out.println("잘넘어옴0");
       int num=Integer.parseInt(request.getParameter("num"));
               System.out.println("잘넘어옴1");
       BoardDAO boarddao=new BoardDAO();
       //BoardBean boarddata=new BoardBean();
               System.out.println("잘넘어옴2");
       boolean usercheck=boarddao.isBoardWriter(num, request.getParameter("passwd"));
       if(usercheck==false){
               response.setContentType("text/html;charset=euc-kr");
               PrintWriter out=response.getWriter();
               out.println("<script>");
               out.println("alert('비밀번호가 틀렸습니다.');");
               out.println("location.href='./BoardList.bo';");
               out.println("</script>");
               out.close();
               return null;
       }
        System.out.println("제대로확인");
        BoardBean boardbean =  null;
            
        boardbean = boarddao.getDetail(num);
        
        request.setAttribute("boardbean", boardbean);
        forward.setRedirect(false);
         forward.setPath("/hanki/board/qna_board_modify.jsp");
         return forward;
        
}
    }