package net;

import java.sql.*;
import java.io.*;

public class SearchInfo {

	Connection conn = null;
    Statement stmt = null;
    int flag =0;
    
    void SerchInfo(String sid){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.14:1521:kudb", "ccp", "pass");
            
            stmt = conn.createStatement();
          
            ResultSet rs = stmt.executeQuery("select id,name,jubun,tel,e_mail,address,password from member where name="+"'"+sid+"'");;
            System.out.println("----------------------------------------------");
            while (rs.next()) {
                String name = rs.getString("name");
                String jubun = rs.getString("jubun");
                String tel = rs.getString("tel");
                String e_mail = rs.getString("e_mail");
                String address = rs.getString("address");
                String password = rs.getString("password");
             
                
		        System.out.printf("��    �� : %s \n", name);
		        //System.out.printf("�ֹι�ȣ : %s \n", jubun);
		        System.out.printf("��ȭ��ȣ : %s \n", tel);
		        System.out.printf("�� �� �� : %s \n", e_mail);
		        System.out.printf("��    �� : %s \n", address);
		        //System.out.printf("��й�ȣ : %s \n", password);
		        
		        flag++;
            }
            if(flag==0){
            	 System.out.printf("ã�� ������ �����ϴ�. �ٽ� �Է����ּ���.");
            }
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
        }
        catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        
        finally {
            try {
                stmt.close();
            }
            catch (Exception ignored) {
            }
            try {
                conn.close();
            }
            catch (Exception ignored) {
            }
        }
    }
    
}
