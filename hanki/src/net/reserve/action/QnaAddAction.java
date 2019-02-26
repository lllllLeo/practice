package net.reserve.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.org.apache.xml.internal.utils.QName;

import net.reserve.action.Action;
import net.reserve.action.ActionForward;
import net.qna.db.QnaBean;
import net.qna.db.QnaDAO;

public class QnaAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.setCharacterEncoding("URF-8");
		
		QnaDAO qnadao = new QnaDAO();
		QnaBean qnabean = new QnaBean();
		ActionForward forward = new ActionForward();
		
		String realFolder="";
   		String saveFolder="qnaupload";
   		
   		int fileSize=5*1024*1024;
   		
   		realFolder=request.getRealPath(saveFolder);
   		
   		boolean result=false;
   		
   		try{
   			
   			MultipartRequest multi=null;
   			
   			multi=new MultipartRequest(request,
   					realFolder,
   					fileSize,
   					"UTF-8",
   					new DefaultFileRenamePolicy());
		
		/*String q_name = multi.getParameter("q_name");
		String q_location = multi.getParameter("q_location");
		int q_phone1 = Integer.parseInt(multi.getParameter("q_phone1"));
		int q_phone2 = Integer.parseInt(multi.getParameter("q_phone2"));
		int q_phone3 = Integer.parseInt(multi.getParameter("q_phone3"));
		String q_email1 = multi.getParameter("q_email1");
		String q_email2 = multi.getParameter("q_email2");
		String q_email3 = multi.getParameter("q_email3");
		String q_title = multi.getParameter("q_title");
		String q_content = multi.getFilesystemName((String)multi.getFileNames().nextElement()));
		String q_file = multi.getParameter("q_file");*/
		
		qnabean.setQ_name(multi.getParameter("q_name"));
		qnabean.setQ_location(multi.getParameter("q_location"));
		qnabean.setQ_phone1(Integer.parseInt(multi.getParameter("q_phone1")));
		qnabean.setQ_phone2(Integer.parseInt(multi.getParameter("q_phone2")));
		qnabean.setQ_phone2(Integer.parseInt(multi.getParameter("q_phone3")));
		qnabean.setQ_email1(multi.getParameter("q_email1"));
		qnabean.setQ_email1(multi.getParameter("q_email2"));
		qnabean.setQ_email1(multi.getParameter("q_email3"));
		qnabean.setQ_title(multi.getParameter("q_title"));
		qnabean.setQ_content(multi.getParameter("q_content"));
		qnabean.setQ_file(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
		
		result = qnadao.qnaInsert(qnabean);
		
		if(result ==false) {
			System.out.println("실패 (QnaAddAction)");
			return null;
		}
		System.out.println("문의완료");
		//request.getSession().setAttribute("qnabean", qnabean);
		
		forward.setPath("/hanki/myreg/qna.yu");
		forward.setRedirect(true);
		return forward;
		
	}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}  	
}
/*package net.qna.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.utils.QName;

import net.qna.db.QnaBean;
import net.qna.db.QnaDAO;

public class QnaAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("URF-8");
		
		QnaDAO qnadao = new QnaDAO();
		QnaBean qnabean = new QnaBean();
		ActionForward forward = new ActionForward();
		
		String q_name = request.getParameter("q_name");
		String q_location = request.getParameter("q_location");
		int q_phone1 = Integer.parseInt(request.getParameter("q_phone1"));
		int q_phone2 = Integer.parseInt(request.getParameter("q_phone2"));
		int q_phone3 = Integer.parseInt(request.getParameter("q_phone3"));
		String q_email1 = request.getParameter("q_email1");
		String q_email2 = request.getParameter("q_email2");
		String q_email3 = request.getParameter("q_email3");
		String q_title = request.getParameter("q_title");
		String q_content = request.getParameter("q_content");
		String q_file = request.getParameter("q_file");
		
		qnabean.setQ_name(q_name);
		qnabean.setQ_location(q_location);
		qnabean.setQ_phone1(q_phone1);
		qnabean.setQ_phone2(q_phone2);
		qnabean.setQ_phone2(q_phone3);
		qnabean.setQ_email1(q_email1);
		qnabean.setQ_email1(q_email2);
		qnabean.setQ_email1(q_email3);
		qnabean.setQ_title(q_title);
		qnabean.setQ_content(q_content);
		qnabean.setQ_file(q_file);
		
		qnabean = qnadao.qnaInsert(qnabean);
		
		if(qnabean ==null) {
			System.out.println("실패 (QnaAddAction)");
			return null;
		}
		System.out.println("문의완료");
		request.getSession().setAttribute("qnabean", qnabean);
		
		forward.setPath("");
		forward.setRedirect(false);
		return forward;
	}

}*/
