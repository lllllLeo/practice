package net.reserve.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReservationFrontController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String RequestURI = request.getRequestURI();
		System.out.println("RequestURI는"+ RequestURI);
		String contextPath = request.getContextPath();
		System.out.println("contextPath는 "+ contextPath);
		String command = RequestURI.substring(contextPath.length());
		System.out.println("command는 "+command);
		ActionForward forward = null;
		Action action = null;

		// /ResCheckAction.yu
		// /ResAddAction.yu
		// /sub3_2.yu
		if (command.equals("/ResAddAction.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/page/NewFile.jsp");
			//�삁�빟 �썑 �떎�떆 �삁�빟�럹�씠吏�濡� 蹂대깂
		} else if (command.equals("/hanki/page/ResAddAction.yu")) {
			action = new ReservationAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// �삁�빟議고쉶
		}else if (command.equals("/sub3_1.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub3_1.jsp");
		}else if (command.equals("/sub3_2.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub3_2.jsp");
			// �삁�빟議고쉶�븯湲�
		}  else if (command.equals("/hanki/page/ResCheckAction.yu")) {
			action = new ReservationCheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//�삁�빟痍⑥냼
		} else if (command.equals("/hanki/page/ResCancelAction.yu")) {
			action = new ReservationCancelAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/sub3_3.yu")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./sub3_3.jsp");
		}
		////////////////////////////////////////////////////
		else if (command.equals("/hanki/page/sub1_3.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub1_3.jsp");
			
		}else if (command.equals("/hanki/page/sub1_4.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub1_4.jsp");
			
		}else if (command.equals("/hanki/page/sub1_7.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub1_7.jsp");
			
		}else if (command.equals("/hanki/page/sub2_1.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub2_1.jsp");
			
		}else if (command.equals("/hanki/page/sub2_10.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub2_10.jsp");
			
		}else if (command.equals("/hanki/page/sub2_2.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub2_2.jsp");
			
		}else if (command.equals("/hanki/page/sub2_3.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub2_3.jsp");
			
		}else if (command.equals("/hanki/page/sub2_4.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub2_4.jsp");
			
		}else if (command.equals("/hanki/page/sub2_5.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub2_5.jsp");
			
		}else if (command.equals("/hanki/page/sub2_6.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub2_6.jsp");
			
		}else if (command.equals("/hanki/page/sub2_7.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub2_7.jsp");
			
		}else if (command.equals("/hanki/page/sub22.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub22.jsp");

		}else if (command.equals("/hanki/page/sub3_1.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub3_1.jsp");
		
		}else if (command.equals("/hanki/page/sub3_2.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub3_2.jsp");
			
		}else if (command.equals("/hanki/page/sub3_4.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub3_4.jsp");
			
		}else if (command.equals("/hanki/myreg/qna.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/myreg/qna.jsp");
			
		}else if (command.equals("/hanki/myboard/cp368638.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/myboard/cp368638.jsp");
			
		}else if (command.equals("/hanki/page/sub4_1.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/sub4_1.jsp");
			
		}else if (command.equals("/hanki/myreg/qna.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/myreg/qna.jsp");
			
		}else if (command.equals("/hanki/bbs/news.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/bbs/news.jsp");
			
		}else if (command.equals("/hanki/bbs/g1.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/bbs/g1.jsp");
			
		}else if (command.equals("/hanki/bbs/hh1.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/bbs/hh1.jsp");
		
		}else if (command.equals("/hanki/page/out.yu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/out.jsp");
			//////////main////////////
		}else if (command.equals("/main.yu")) {
		    System.out.println("메인들어갑니당~");
			forward = new ActionForward();
			System.out.println("1");
			forward.setRedirect(false);
			System.out.println("2");
			forward.setPath("/hanki/main.jsp");
			System.out.println(forward.getPath());
		////////////////////////////////////////////////////
		//////////////////////admin Reservation mapping//////////////////////////
		
		//예약현황게시판
		}else if(command.equals("/hanki/ResBoardList.yu")){
			action = new ReservationBoardListAction();
				try{
					forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
				
			
				
				
				
				
				
//////////////////////////////////////////////////////////////////////////////////////				
		//1:1문의하기
		}else if(command.equals("/hanki/QnaAddAction.yu")){
			action = new QnaAddAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/hanki/QnaListAction.yu")){
			action = new QnaListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/QnaList.yu")){
			action = new QnaListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
}
