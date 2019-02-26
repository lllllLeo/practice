package net.reserve.action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.glass.ui.GestureSupport;

import net.reserve.db.ReservationBean;
import net.reserve.db.ReservationDAO;

public class ReservationAction implements Action{
	//예약자의 정보들이 넘어옴
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		ReservationDAO reserdao = new ReservationDAO();
		ReservationBean reserbean = new ReservationBean();
		ActionForward forward = new ActionForward();
		System.out.println(request.getParameter("res_date")+ "날짜");
		HttpSession session = request.getSession();
		int hour = Integer.parseInt(request.getParameter("hour"));
		int minute = Integer.parseInt(request.getParameter("minute"));
		
		System.out.println(hour+ "시간");
		System.out.println(minute+ "분");
		boolean result = false;
		
		reserbean.setStore_code(request.getParameter("store_code"));		//고쳐짐
		System.out.println(reserbean.getStore_code()+" 지점번호");
		
		reserbean.setRes_name(request.getParameter("res_name"));
		System.out.println(reserbean.getRes_name()+" 예약자이름");
		
		reserbean.setRes_phone(request.getParameter("res_phone"));
		System.out.println(reserbean.getRes_phone()+" 폰번호");
		
		reserbean.setRes_ppl(Integer.parseInt(request.getParameter("res_ppl")));
		System.out.println(reserbean.getRes_ppl()+" 인원");
		
		reserbean.setRes_date(Timestamp.valueOf(request.getParameter("res_date")+" "+hour+":"+minute+":"+"00"));
		System.out.println(reserbean.getRes_date());
		
		
/*		reserbean.setRes_date(Timestamp.valueOf(request.getParameter("res_date") + " 15:00:00" ));
*/
		result = reserdao.reserve(reserbean);
		
		if(result ==false) {
			System.out.println("예약실패 (ReservationAction)");
			session.setAttribute("error", 0);
			forward.setPath("/sub3_1.yu");
			forward.setRedirect(false);
			return forward;
		}
		System.out.println("예약성공 (ReservationAction)");
		
		//request.setAttribute("hour", hour);

		forward.setPath("/sub3_1.yu");
/*		forward.setPath("/hanki/page/sub3_2.jsp");
*/		forward.setRedirect(false);
		return forward;
	}

}