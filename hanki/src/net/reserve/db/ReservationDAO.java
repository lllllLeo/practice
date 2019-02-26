package net.reserve.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sun.jmx.snmp.Timestamp;


public class ReservationDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public ReservationDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}

	public boolean reserve(ReservationBean reserbean) {

		String sql = "INSERT INTO reservation values(?,?,?,?,?)";

		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reserbean.getStore_code());
			pstmt.setString(2, reserbean.getRes_name());
			pstmt.setString(3, reserbean.getRes_phone());
			pstmt.setInt(4, reserbean.getRes_ppl());
			pstmt.setTimestamp(5, reserbean.getRes_date());

			result = pstmt.executeUpdate();

			if (result == 0) {
				System.out.println("쿼리실행 실패 (DAO)");
			}
			System.out.println("쿼리실행 성공 (DAO)");

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean resCheck(String res_name, String res_phone, ReservationBean reserbean) {
		
		String sql = "SELECT * FROM reservation WHERE res_name=?";
			System.out.println("1");
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, res_name);

			rs = pstmt.executeQuery();
			System.out.println("2");
			if (rs.next()) {
				if (res_name.equals(rs.getString("res_name")) && res_phone.equals(rs.getString("res_phone"))) {
					reserbean.setStore_code(rs.getString("store_code")); //
					reserbean.setRes_name(rs.getString("res_name"));
					reserbean.setRes_phone(rs.getString("res_phone"));
					reserbean.setRes_ppl(rs.getInt("res_ppl"));
					reserbean.setRes_date(rs.getTimestamp("res_date"));
					System.out.println("3");
				}
				System.out.println("정보넣기 성공 (resCheck in DAO)");
				System.out.println(reserbean.getRes_name());
				System.out.println(reserbean.getRes_ppl());
				
				return true;
			}else {
				System.out.println("정보넣기 실패 (resCheck in DAO)");
				return false ;
			}
			//System.out.println("예약자 정보넣기실패 (resCheck in DAO)");
		}catch(SQLException e){
		e.printStackTrace();
		
		}return false;
	}
	
	
	public HashMap<Integer, String> inputCode(HashMap<Integer, String> map) {

		String sql="SELECT * FROM store_code_tb";
		
		try {
			System.out.println("1");
			pstmt = con.prepareStatement(sql);
			System.out.println("2");
			rs = pstmt.executeQuery();
			System.out.println("3");
			while(rs.next()) {
				map.put(rs.getInt("code"),rs.getString("store"));
			}
			
			if(map.isEmpty()) {
				System.out.println("Map에 키, 값 넣기 실패 (inputCode in DAO)");
				return null;
			}
			System.out.println("Map에 키, 값 넣기 성공");
			
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int resCancel(String res_name) {

		String sql="DELETE FROM reservation WHERE res_name=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, res_name);
			
			result = pstmt.executeUpdate();
			
			if(result==0) {
				System.out.println("삭제실패 (resCancel in DAO)");
				return 0;
			}
			System.out.println("삭제성공 (DAO)");
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}		
	//예약게시판
	public int getListCount() {
		int x= 0;
		
		try{
			pstmt=con.prepareStatement("select count(*) from reservation");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				x=rs.getInt(1);
			}
		}catch(Exception ex){
			System.out.println("getListCount ����: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		return x;
	}
	
	public List<ReservationBean> getBoardList(int page,int limit){
		String res_board_list_sql="select * from (select rownum rnum,res_date,store_code,res_name,res_phone,res_ppl from reservation order by res_date desc) where rnum>=? and rnum<=?";
		
		List<ReservationBean> list = new ArrayList<ReservationBean>();
		
		int startrow=(page-1)*10+1; //�б� ������ row ��ȣ.
		int endrow=startrow+limit-1; //���� ������ row ��ȣ.		
		try{
			pstmt = con.prepareStatement(res_board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ReservationBean reserbean = new ReservationBean();
				reserbean.setRes_date(rs.getTimestamp("res_date"));
				reserbean.setRes_name(rs.getString("res_name"));
				reserbean.setRes_phone(rs.getString("res_phone"));
				reserbean.setRes_ppl(rs.getInt("res_ppl"));
				reserbean.setStore_code(rs.getString("store_code"));
				list.add(reserbean);
			}
			
			return list;
		}catch(Exception ex){
			System.out.println("getBoardList ���� : " + ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		return null;
	}
}
