package net.reserve.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.reserve.db.ReservationBean;
import net.reserve.db.ReservationDAO;

public class ReservationCancelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ReservationDAO reserdao = new ReservationDAO();
		ReservationBean reserbean = new ReservationBean();
		ActionForward forward = new ActionForward();
		
		int result = 0;
		String res_name = request.getParameter("res_name");
		
		System.out.println(res_name);
		
		result = reserdao.resCancel(res_name);
		
		if(result ==0) {
			System.out.println("삭제실패 (CancelAction)");
			return null;
		}
		System.out.println("삭제성공 (CancelAction)");
		
		forward.setRedirect(false);
		forward.setPath("/hanki/page/sub3_1.jsp");
		return forward;
	}

}
