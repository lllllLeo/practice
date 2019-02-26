package net.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.action.Action;
import net.admin.action.ActionForward;

public class AdminFrontController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		System.out.println(command);
		ActionForward forward = null;
		Action action = null;

		
		//   /hanki/admin.ad
		// ../AdminLoginAction.ad
		if (command.equals("/hanki/page/AdminLoginAction.ad")) {
			action = new AdminLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/hanki/page/adminLogin.ad")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/adminLogin.jsp");
		}
		else if (command.equals("/hanki/page/AdminJoinAction.ad")) {
			action = new AdminJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/hanki/page/admin.ad")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/hanki/page/admin.jsp");
			
		}else if (command.equals("/hanki/adminLogin.ad")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./page/adminLogin.jsp");

		}else if (command.equals("/hanki/page/adminJoin.ad")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./adminJoin.jsp");
		}
		else if (command.equals("/hanki/page/adminManage.ad")) {
		    System.out.println("매니지 들어왔다.");
		    action = new AdminListAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (command.equals("/hanki/page/admindelete.ad")) {
            System.out.println("매니지 들어왔다.");
            action = new AdminDeleteAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (command.equals("/hanki/page/adminsales.ad")) {
            System.out.println("세일즈 들어왔다.");
            forward = new ActionForward();
            forward.setRedirect(false);
            forward.setPath("./storeInput.jsp");
        }else if (command.equals("/hanki/page/AdminSalesAction.ad")) {
            System.out.println("매니지 들어왔다.");
            action = new AdminSalesAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (command.equals("/hanki/page/adminsaleslist.ad")) {
            System.out.println("세일즈리스트 들어왔다.");
            action = new AdminSaleListAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (command.equals("/hanki/page/adminsaldelete.ad")) {
            System.out.println("매니지 들어왔다.");
            action = new AdminSalDeleteAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (command.equals("/hanki/page/adminsales.ad")) {
            System.out.println("세일즈 들어왔다.");
            forward = new ActionForward();
            forward.setRedirect(false);
            forward.setPath("./storeInput.jsp");
        }else if (command.equals("/hanki/page/AdminSalesAction.ad")) {
            System.out.println("매니지 들어왔다.");
            action = new AdminSalesAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (command.equals("/hanki/page/adminsaleslist.ad")) {
            System.out.println("세일즈리스트 들어왔다.");
            action = new AdminSaleListAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (command.equals("/hanki/page/adminsaldelete.ad")) {
            System.out.println("매니지딜리트 들어왔다.");
            action = new AdminSalDeleteAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (command.equals("/hanki/page/adminDaily.ad")) {
            System.out.println("매니지딜리트 들어왔다.");
            action = new AdminSalDailyAction();
            try {
                forward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (command.equals("/hanki/page/storeChart.ad")) {
            System.out.println("세일즈 들어왔다.");
            forward = new ActionForward();
            forward.setRedirect(false);
            forward.setPath("./storeChart.jsp");
        }else if (command.equals("/hanki/page/adminboard.ad")) {
            System.out.println("세일즈 들어왔다.");
            forward = new ActionForward();
            forward.setRedirect(false);
            forward.setPath("./adminBoard.jsp");
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
