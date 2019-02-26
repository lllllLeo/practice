package net.qna.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.board.db.BoardBean;
import net.reserve.db.ReservationBean;

public class QnaDAO {
   Connection con;
   PreparedStatement pstmt;
   ResultSet rs;

   public QnaDAO() {
      try {
         Context init = new InitialContext();
         DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
         con = ds.getConnection();
      } catch (Exception ex) {
         System.out.println("DB �뿰寃� �떎�뙣 : " + ex);
         return;
      }
   }

   public boolean qnaInsert(QnaBean qnabean) {
      int num =0;
      int result = 0;
      String sql="";
      try{
         pstmt=con.prepareStatement("select max(q_num) from qna");
         rs = pstmt.executeQuery();
         
         if(rs.next())
            num =rs.getInt(1)+1;   //理쒕�媛믪쓣 援ы븳 湲�踰덊샇�뿉 +1�쓣 �븿
         else
            num=1;
         sql = "INSERT INTO QNA (q_num, q_name, q_location, q_phone1, q_phone2, q_phone3, q_email1,";
         sql += "q_email2, q_email3, q_title, q_content, q_file) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
         
         pstmt = con.prepareStatement(sql);

         pstmt.setInt(1, num);
         pstmt.setString(2, qnabean.getQ_name());
         pstmt.setString(3, qnabean.getQ_location());
         pstmt.setInt(4, qnabean.getQ_phone1());
         pstmt.setInt(5, qnabean.getQ_phone2());
         pstmt.setInt(6, qnabean.getQ_phone3());
         pstmt.setString(7, qnabean.getQ_email1());
         pstmt.setString(8, qnabean.getQ_email2());
         pstmt.setString(9, qnabean.getQ_email3());
         pstmt.setString(10, qnabean.getQ_title());
         pstmt.setString(11, qnabean.getQ_content());
         pstmt.setString(12, qnabean.getQ_file());

         result = pstmt.executeUpdate();

         if (result == 0) {
            System.out.println("荑쇰━�떎�뻾�떎�뙣");
            return false;
         }
         System.out.println("荑쇰━�꽦怨�");
         return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return false;
   }

   public int getListCount() {
      int x = 0;

      try {
         pstmt = con.prepareStatement("select count(*) from qna");
         rs = pstmt.executeQuery();

         if (rs.next()) {
            x = rs.getInt(1);
         }
      } catch (Exception ex) {
         System.out.println("getListCount 占쏙옙占쏙옙: " + ex);
      } finally {
         if (rs != null)
            try {
               rs.close();
            } catch (SQLException ex) {
            }
         if (pstmt != null)
            try {
               pstmt.close();
            } catch (SQLException ex) {
            }
      }
      return x;
   }

   public List<QnaBean> getQnaList(int page, int limit) {
      String q_board_list_sql = "select * from (select rownum rnum, q_num, q_name, q_location, q_phone1, q_phone2, q_phone3, q_email1, q_email2, q_email3, q_title, q_content, q_file from qna order by q_num desc) where rnum>=? and rnum<=?";

      List<QnaBean> list = new ArrayList<QnaBean>();

      int startrow = (page - 1) * 10 + 1; // 占싻깍옙 占쏙옙占쏙옙占쏙옙 row 占쏙옙호.
      int endrow = startrow + limit - 1; // 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 row 占쏙옙호.
      try {
         pstmt = con.prepareStatement(q_board_list_sql);
         pstmt.setInt(1, startrow);
         pstmt.setInt(2, endrow);
         rs = pstmt.executeQuery();

         while (rs.next()) {
            QnaBean qnabean = new QnaBean();
            qnabean.setQ_num(rs.getInt("q_num"));
            qnabean.setQ_name(rs.getString("q_name"));
            qnabean.setQ_location(rs.getString("q_location"));
            qnabean.setQ_phone1(rs.getInt("q_phone1"));
            qnabean.setQ_phone2(rs.getInt("q_phone2"));
            qnabean.setQ_phone3(rs.getInt("q_phone3"));
            qnabean.setQ_email1(rs.getString("q_email1"));
            qnabean.setQ_email2(rs.getString("q_email2"));
            qnabean.setQ_email3(rs.getString("q_email3"));
            qnabean.setQ_title(rs.getString("q_title"));
            qnabean.setQ_content(rs.getString("q_content"));
            qnabean.setQ_file(rs.getString("q_file"));
            list.add(qnabean);
         }

         return list;
      } catch (Exception ex) {
         System.out.println("getBoardList 占쏙옙占쏙옙 : " + ex);
      } finally {
         if (rs != null)
            try {
               rs.close();
            } catch (SQLException ex) {
            }
         if (pstmt != null)
            try {
               pstmt.close();
            } catch (SQLException ex) {
            }
      }
      return null;
   }

    public QnaBean getDetail(int num) throws Exception{
        QnaBean board = null;
        System.out.println("여기옴>?");
        try{
            pstmt = con.prepareStatement(
                    "select * from qna where q_num= ?");
            pstmt.setInt(1, num);
            
            rs= pstmt.executeQuery();
           
            if(rs.next()){
               
                board = new QnaBean();
                board.setQ_num(rs.getInt("q_num"));
                board.setQ_name(rs.getString("q_name"));
                board.setQ_location(rs.getString("q_location"));
                board.setQ_phone1(rs.getInt("q_phone1"));
                board.setQ_phone2(rs.getInt("q_phone2"));
                board.setQ_phone3(rs.getInt("q_phone3"));
                board.setQ_email1(rs.getString("q_email1"));
                board.setQ_email2(rs.getString("q_email2"));
                board.setQ_email3(rs.getString("q_email3"));
                board.setQ_title(rs.getString("q_title"));
                board.setQ_content(rs.getString("q_content"));
                board.setQ_file(rs.getString("q_file"));
            }
            return board;
        }catch(Exception ex){
            System.out.println("getDetail 占쏙옙占쏙옙 : " + ex);
        }finally{
            if(rs!=null)try{rs.close();}catch(SQLException ex){}
            if(pstmt !=null)try{pstmt.close();}catch(SQLException ex){}
        }
        return null;
    }
}