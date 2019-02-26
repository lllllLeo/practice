package net.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class BoardFrontController 
    extends javax.servlet.http.HttpServlet 
    implements javax.servlet.Servlet {
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException {
 
       String RequestURI=request.getRequestURI();
       String contextPath=request.getContextPath();
       String command=RequestURI.substring(contextPath.length());
       System.out.println(command);
       ActionForward forward=null;
       Action action=null;
         
         if(command.equals("/hanki/BoardWrite.bo")){
            forward=new ActionForward();
            forward.setRedirect(false);
            forward.setPath("./board/write_form.jsp");
         }else if(command.equals("/BoardReplyAction.bo")){
            action = new BoardReplyView();
            try{
               forward=action.execute(request, response);
            }catch(Exception e){
               e.printStackTrace();
            }
         }else if(command.equals("/BoardDelete.bo")){
            forward=new ActionForward();
            forward.setRedirect(false);
            forward.setPath("./board/qna_board_delete.jsp");
         }else if(command.equals("/hanki/BoardAddAction.bo")){
            action  = new BoardAddAction();
            try {
               forward=action.execute(request, response );
            } catch (Exception e) {
               e.printStackTrace();
            }
         }else if(command.equals("/BoardReplyView.bo")){
            action = new BoardReplyAction();
            try{
               forward=action.execute(request, response);
            }catch(Exception e){
               e.printStackTrace();
            }
         }else if(command.equals("/BoardModifyAction.bo")){
            action = new BoardModifyAction();
            try{
               forward=action.execute(request, response);
            }catch(Exception e){
               e.printStackTrace();
            }
         }else if(command.equals("/BoardDeleteAction.bo")){
            action = new BoardDeleteAction();
            try{
               forward=action.execute(request, response);
            }catch(Exception e){
               e.printStackTrace();
            }
            //자유게시판c
         }else if(command.equals("/BoardList.bo")){
            action = new BoardListAction();
            try{
               forward=action.execute(request, response);
            }catch(Exception e){
               e.printStackTrace();
            }
            //글쓰기 후 AddAction에서 보냄
         }else if(command.equals("/hanki/BoardList.bo")){
            action = new BoardListAction();
            System.out.println("들어간거 확인좀");
            try{
               forward=action.execute(request, response);
            }catch(Exception e){
               e.printStackTrace();
            }
         }else if(command.equals("/hanki/bbs_shop/BoardAddAction.bo")){
            action = new BoardListAction();
            try{
               forward=action.execute(request, response);
            }catch(Exception e){
               e.printStackTrace();
            }
         }else if(command.equals("/BoardDetailAction.bo")){
            action = new BoardDetailAction();
            try{
               forward=action.execute(request, response);
            }catch(Exception e){
               e.printStackTrace();
            }
         }else if(command.equals("/passch.bo")){
             forward=new ActionForward();
             forward.setRedirect(false);
             forward.setPath("/hanki/bbs_shop/popup/pwd_chk_form.jsp");
          }else if(command.equals("/hanki/board/qna_board_list.bo")){
            forward=new ActionForward();
            forward.setRedirect(false);
            forward.setPath("/hanki/board/qna_board_list.jsp");
         }else if(command.equals("/passchAction.bo")){
             action = new BoardModifyAction();
             try{
                 System.out.println("체크1");
                forward=action.execute(request, response);
                System.out.println("체크2");
             }catch(Exception e){
                e.printStackTrace();
             }
          }else if(command.equals("/BoardModify.bo")){
              forward=new ActionForward();
              forward.setRedirect(true);
              forward.setPath("./hanki/board/qna_board_modify.jsp?num="+request.getAttribute("num"));
          }/*else if(command.equals("/BoardModify.bo")){
              action = new BoardModifyView();
              try{
                 forward=action.execute(request, response);
              }catch(Exception e){
                 e.printStackTrace();
              }
            }*/
         /*}else if(command.equals("/MemberListAction.yu")){
            forward = new ActionForward();
            forward.setRedirect(false);
            forward.setPath("/MemberListAction.yu");
         }*/
         
         //���۹��ó��  => forward��� �Ǵ� sendRedirect��� ����
         
         if(forward.isRedirect()){
            response.sendRedirect(forward.getPath());
         }else{
            RequestDispatcher dispatcher=
               request.getRequestDispatcher(forward.getPath());
            dispatcher.forward(request, response);
         }
    }
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
      doProcess(request,response);
   }     
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
      doProcess(request,response);
   }               
}