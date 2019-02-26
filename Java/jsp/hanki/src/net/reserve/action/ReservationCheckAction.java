package net.reserve.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.reserve.db.ReservationBean;
import net.reserve.db.ReservationDAO;

public class ReservationCheckAction implements Action {
	
	HashMap<Integer, String> map;
	
	public ReservationCheckAction() {
		map = new HashMap<Integer, String>();
		
	}
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ReservationDAO reserdao = new ReservationDAO();
		ReservationBean reserbean = new ReservationBean();
		ActionForward forward = new ActionForward();
		boolean ch = false;
		HttpSession session = request.getSession();
		
		String res_name = request.getParameter("res_name");
		String res_phone = request.getParameter("res_phone");

		System.out.println(res_name);
		System.out.println(res_phone);
		
		ch = reserdao.resCheck(res_name, res_phone, reserbean);
		
		System.out.println(reserbean.getRes_name());
		
		if(ch == false) {
			session.setAttribute("error", 0);
			forward.setPath("/hanki/page/sub3_2.jsp");
			forward.setRedirect(false);
			return forward;
		}else {
			System.out.println("체크성공 ACTION");
			
			request.setAttribute("reserbean", reserbean);
			forward.setPath("/hanki/page/sub3_4.jsp");
			forward.setRedirect(false);
			return forward;
		}
		
		
	}

}
/*package net.reserve.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.reserve.db.ReservationBean;
import net.reserve.db.ReservationDAO;

public class ReservationCheckAction implements Action {
	
	HashMap<Integer, String> map;
	
	public ReservationCheckAction() {
		map = new HashMap<Integer, String>();
		
	}
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ReservationDAO reserdao = new ReservationDAO();
		ReservationBean reserbean = new ReservationBean();
		ActionForward forward = new ActionForward();
		boolean ch = false;
		HttpSession session = request.getSession();
		
		String res_name = request.getParameter("res_name");
		String res_phone = request.getParameter("res_phone");

		System.out.println(res_name);
		System.out.println(res_phone);
		if(map.isEmpty()) {
			map = reserdao.inputCode(map);
			System.out.println("map을 리턴받았습니다.");
		}
		System.out.println(map.get(0).toString());
		map.get(1).toString();
		map.get(2).toString();
		map.get(3).toString();
		map.get(4).toString();
		
		ch = reserdao.resCheck(res_name, res_phone, reserbean, map);
		
		System.out.println(reserbean.getRes_name());
		
		if(ch == false) {
			session.setAttribute("error", 0);
			forward.setPath("/hanki/page/sub3_2.jsp");
			forward.setRedirect(false);
			return forward;
		}else {
			System.out.println("체크성공 ACTION");
			
			request.setAttribute("reserbean", reserbean);
			forward.setPath("/hanki/page/sub3_4.jsp");
			forward.setRedirect(false);
			return forward;
		}
		
		
	}

}
*/