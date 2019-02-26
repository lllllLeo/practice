package net.admin.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminDAO {

   Connection con;
   PreparedStatement pstmt;
   ResultSet rs;

   public AdminDAO() {
      
      try {
         Context init = new InitialContext();
         DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
         con = ds.getConnection();
      } catch (Exception ex) {
         System.out.println("DB ���� ����: " + ex);
         return;
      }
   }
   
   
   
   
   public List showSale(String Store_name) {
       String sql = "Select * from statis where store_name ="+"'"+Store_name+"'"+" "+"ORDER BY SALDATE";
       List list = new ArrayList();
           try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            int i= 0;
            
            while(rs.next()) {
                System.out.println("뭐찍히냐");
                AdminSalesBean adminsalebean = new AdminSalesBean();
                adminsalebean.setSaldate(rs.getString(1));
                adminsalebean.setSales(rs.getInt(2));
                adminsalebean.setStore_name(rs.getString(3));
                System.out.println(rs.getString(1));
                System.out.println(rs.getInt(2));
                System.out.println(rs.getString(3));
                list.add(adminsalebean);   
                System.out.println(list.get(i));
                i++;
            }
            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
       
       
       return null;
       
   }
   
   
public List<AdminSalesBean> adminchart(String Store_name) {
       
       String sql = "select * from statis where store_name="+"'"+Store_name+"'"+"order by saldate";
       List<AdminSalesBean> list = new ArrayList<AdminSalesBean>();
       try {
        
        pstmt=con.prepareStatement(sql);
        rs = pstmt.executeQuery();
        int i = 0 ;
        if(rs.next()) {
        while(rs.next()) {    
            AdminSalesBean adminsalebean = new AdminSalesBean();
            System.out.println(rs.getString(1));
            adminsalebean.setSaldate(rs.getString(1));
            System.out.println(rs.getInt(2));
            adminsalebean.setSales(rs.getInt(2));
            System.out.println(rs.getString(3));
            adminsalebean.setStore_name(rs.getString(3));
            list.add(adminsalebean);   
            
            System.out.println(list.get(i));
            i++;
           }
        
        return list;}
        else {
            return null;
        }
        
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }finally{
        if(rs!=null)try{rs.close();}catch(SQLException ex){}
        if(pstmt !=null)try{pstmt.close();}catch(SQLException ex){}
    }
    return null;
   }
   
   
   
   
   
   
   public boolean adsaldel(String date, int sal) {
       int result = 0;
       String sql = "delete from statis where sales="+sal+" "+"and saldate="+"'"+date+"'";
       System.out.println(sql);
       try{
           pstmt=con.prepareStatement(sql);
           
           result=pstmt.executeUpdate();
           if(result== 0) {
               System.out.println("판매삭제 실패");
               return false;
           }
           System.out.println("성공");
           return true;
       }catch(Exception ex){
           System.out.println("admin : "+ex);
       }finally{
           if(rs!=null)try{rs.close();}catch(SQLException ex){}
           if(pstmt !=null)try{pstmt.close();}catch(SQLException ex){}
       }
       
       
       return false;
   }
   
   
   
   
   public List showAd() {
       
       String sql = "SELECT store_name FROM han_admin";
       List list = new ArrayList();
       try {
          pstmt = con.prepareStatement(sql);
          rs = pstmt.executeQuery();
          int i= 0;
          while(rs.next()) {
              
              AdminBean adminbean = new AdminBean();
              adminbean.setStore_name(rs.getString("store_name"));
              list.add(adminbean);   
              System.out.println(list.get(i));
              i++;
             }
          
          return list;

       } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
       }
       return null;
       
   }
   
   public boolean inputStatis(String date, int sales, String Store_name) {
       int sal;
       int result = 0;
       String sql = "insert into statis values("+"'"+date+"'"+","+"'"+sales+"'"+","+"'"+Store_name+"'"+")";
       try {
        pstmt=con.prepareStatement(sql);
        rs = pstmt.executeQuery();
   
        return true;
        
    } catch (SQLException ex) {
        ex.printStackTrace();
        System.out.println("admin : "+ex);
    }
    return false;
      
   }

   
   public int outputStatis(String Store_name) {
       int result = 0;
       String sql = "select * from statis";
       
       
       
       return 0;
       
   }
   

   
   public boolean addel(String Store_name) {
       int result = 0;
       String sql = "delete from han_admin where store_name="+"'"+Store_name+"'";
       System.out.println(sql);
       try{
           pstmt=con.prepareStatement(sql);
           
           result=pstmt.executeUpdate();
           if(result== 0) {
               System.out.println("어드민삭제 실패");
               return false;
           }
           System.out.println("성공");
           return true;
       }catch(Exception ex){
           System.out.println("admin : "+ex);
       }finally{
           try{
               if(pstmt!=null)pstmt.close();
           }catch(Exception ex) {}
       }
       
       return false;
   }

   public String login(String id, String pw) {
      
      
      String sql = "SELECT * FROM han_admin WHERE id=?";
      System.out.println(id);
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();
         
         //System.out.println(rs.getString(id));
         //System.out.println(rs.getString(pw));
         if(rs.next()) {
            System.out.println("ù��° if ���");
            if(id.equals(rs.getString("id")) && (pw.equals(rs.getString("pw")))){
               System.out.println("�ι�° if ���");
               String sql2 = "SELECT store_name FROM han_admin WHERE id=?";
               pstmt = con.prepareStatement(sql2);
               pstmt.setString(1, id);
               rs = pstmt.executeQuery();
               if(rs.next()) {
                  String store_name = (String)rs.getString("store_name");
                  System.out.println(store_name);
                  System.out.println("���̵�, ��й�ȣ ��ġ (AdminDAO)");
                  return store_name;
               }
            }
         }
         System.out.println("���̵�, ��й�ȣ ����ġ (AdminDAO)");

      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return null;
   }

   public boolean storeReg(AdminBean adminbean) {
      
      String sql = "INSERT INTO han_admin(id, pw, store_name) VALUES(?,?,?)";
      
      int result = 0;
      try {
         pstmt = con.prepareStatement(sql);
         
         pstmt.setString(1, adminbean.getId());
         pstmt.setString(2, adminbean.getPw());
         pstmt.setString(3, adminbean.getStore_name());
         
         result = pstmt.executeUpdate();
         
         if(result ==0) {
            System.out.println("��Ͻ���(DAO)");
            return false;
         }
         System.out.println("��ϼ���(DAO)");
         
         return true;
         
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return false;
      
   }
}