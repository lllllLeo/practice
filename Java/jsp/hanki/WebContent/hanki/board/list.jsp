<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.board.db.*" %>

<%
	List boardList=(List)request.getAttribute("boardlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
	String mb_id = (String)request.getSession().getAttribute("mb_id");
%>

<!-- ������  ��� ȸ������ ���� / ���� -->
<!-- ����ڸ�      �� ���� ���� / ���� -->
<html>
<head>
	<title>MVC �Խ���</title>
</head>

<body>
<!-- �Խ��� ����Ʈ -->
<table width=50% border="0" cellpadding="0" cellspacing="0">
<c:set var="mb_id" value="�� �ݰ����ϴ�"/>
${mb_id} <c:out value="${mb_id}"/>

<c:choose>
<c:when test="${mb_id=='admin'}">
	
	<p align ="left" ><a href="#" onclick="history.go(-1)">�α׾ƿ�</a></p>
	<p align ="right" ><a href="./MemberListAction.yu?mb_id=${mb_id}">��� ȸ�� ��� ����</a></p>
	
</c:when>
<c:otherwise>			
	<a href="./MemberViewAction.yu?mb_id=${mb_id}">�� ���� ����</a>		/* View�ؾ��� */
}

	<tr align="center" valign="middle">
		<td colspan="4">MVC �Խ���</td>
		<td align=right>
			<font size=2>�� ���� : ${listcount }</font>
		</td>
	</tr>
	
	<tr align="center" valign="middle" bordercolor="#333333">
		<td style="font-family:Tahoma;font-size:8pt;" width="8%" height="26">
			<div align="center">��ȣ</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="50%">
			<div align="center">����</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="14%">
			<div align="center">�ۼ���</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="17%">
			<div align="center">��¥</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="11%">
			<div align="center">��ȸ��</div>
		</td>
	</tr>
	
	<c:forEach var="board" items="${boardlist}">
	<%
		for(int i=0;i<boardList.size();i++){
			BoardBean bl=(BoardBean)boardList.get(i);
	%>
	<tr align="center" valign="middle" bordercolor="#333333"
		onmouseover="this.style.backgroundColor='F8F8F8'"
		onmouseout="this.style.backgroundColor=''">
		<td height="23" style="font-family:Tahoma;font-size:10pt;">
			${board.BOARD_NUM}
		</td>
		
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="left">
			<c:choose>
			<c:when test="${board.BOARD_RE_LEV()!=0)}">
				<c:forEach var<!-- �������============ -->
				<%for(int a=0;a<=bl.getBOARD_RE_LEV()*2;a++){ %>
				&nbsp;
				<%} %>
				��
				</c:when>
			<%}else{ %>
				��
			<%} %>
			<a href="./BoardDetailAction.bo?num=<%=bl.getBOARD_NUM()%>">
				<%=bl.getBOARD_SUBJECT()%></a>
			</div>
		</td>
		
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bl.getBOARD_NAME() %></div>
		</td>
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bl.getBOARD_DATE() %></div>
		</td>	
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bl.getBOARD_READCOUNT() %></div>
		</td>
	</tr>
	<%} %>
	<tr align=center height=20>
		<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
			<%if(nowpage<=1){ %>
			[����]&nbsp;
			<%}else{ %>
			<a href="./BoardList.bo?page=<%=nowpage-1 %>">[����]</a>&nbsp;
			<%} %>
			
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./BoardList.bo?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			<%if(nowpage>=maxpage){ %>
			[����]
			<%}else{ %>
			<a href="./BoardList.bo?page=<%=nowpage+1 %>">[����]</a>
			<%} %>
		</td>
	</tr>
	<tr>
		<td align="left" colspan="5"> <a href="#" onclick="history.go(-1)">[�ڷΰ���]</a></td>
		<td align="right" colspan="5"> <a href="./BoardWrite.bo">[�۾���]</a></td>
	</tr>
	</c:forEach>
	</c:otherwise>
</c:choose>
</table>
</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.board.db.*" %>

<%
	List boardList=(List)request.getAttribute("boardlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
	String mb_id = (String)request.getSession().getAttribute("mb_id");
%>

<!-- ������  ��� ȸ������ ���� / ���� -->
<!-- ����ڸ�      �� ���� ���� / ���� -->
<html>
<head>
	<title>MVC �Խ���</title>
</head>

<body>
<!-- �Խ��� ����Ʈ -->
<table width=50% border="0" cellpadding="0" cellspacing="0">
<%=mb_id+"�� ȯ���մϴ�." %>

<%if(mb_id.equals("admin")){%>
	<p align ="right" ><a href="./MemberListAction.yu?mb_id=<%=mb_id%>">��� ȸ�� ��� ����</a></p>
	<p align ="left"><a href="#" onclick="history.go(-1)">�α׾ƿ�</a></p>
	
	<%}
else{%> 			
	<a href="./MemberViewAction.yu?mb_id=<%=mb_id%>">�� ���� ����</a>		<!-- View�ؾ��� -->
	<p align ="left"><a href="#" onclick="history.go(-1)">�α׾ƿ�</a></p><%
}%>

	<tr align="center" valign="middle">
		<td colspan="4">MVC �Խ���</td>
		<td align=right>
			<font size=2>�� ���� : ${listcount }</font>
		</td>
	</tr>
	
	<tr align="center" valign="middle" bordercolor="#333333">
		<td style="font-family:Tahoma;font-size:8pt;" width="8%" height="26">
			<div align="center">��ȣ</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="50%">
			<div align="center">����</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="14%">
			<div align="center">�ۼ���</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="17%">
			<div align="center">��¥</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="11%">
			<div align="center">��ȸ��</div>
		</td>
	</tr>
	
	<%
		for(int i=0;i<boardList.size();i++){
			BoardBean bl=(BoardBean)boardList.get(i);
	%>
	<tr align="center" valign="middle" bordercolor="#333333"
		onmouseover="this.style.backgroundColor='F8F8F8'"
		onmouseout="this.style.backgroundColor=''">
		<td height="23" style="font-family:Tahoma;font-size:10pt;">
			<%=bl.getBOARD_NUM()%>
		</td>
		
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="left">
			<%if(bl.getBOARD_RE_LEV()!=0){ %>
				<%for(int a=0;a<=bl.getBOARD_RE_LEV()*2;a++){ %>
				&nbsp;
				<%} %>
				��
			<%}else{ %>
				��
			<%} %>
			<a href="./BoardDetailAction.bo?num=<%=bl.getBOARD_NUM()%>">
				<%=bl.getBOARD_SUBJECT()%></a>
			</div>
		</td>
		
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bl.getBOARD_NAME() %></div>
		</td>
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bl.getBOARD_DATE() %></div>
		</td>	
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bl.getBOARD_READCOUNT() %></div>
		</td>
	</tr>
	<%} %>
	<tr align=center height=20>
		<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
			<%if(nowpage<=1){ %>
			[����]&nbsp;
			<%}else{ %>
			<a href="./BoardList.bo?page=<%=nowpage-1 %>">[����]</a>&nbsp;
			<%} %>
			
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./BoardList.bo?page=<%=a %>">[<%=a %>]</a>&nbsp;
				<%} %>
			<%} %>
			<%if(nowpage>=maxpage){ %>
			[����]
			<%}else{ %>
			<a href="./BoardList.bo?page=<%=nowpage+1 %>">[����]</a>
			<%} %>
		</td>
	</tr>
	<tr>
		<td align="left" colspan="5"> <a href="#" onclick="history.go(-1)">[�ڷΰ���]</a></td>
		<td align="right" colspan="5"> <a href="./BoardWrite.bo">[�۾���]</a></td>
	</tr>
</table>
</body>
</html>