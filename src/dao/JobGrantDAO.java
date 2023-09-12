package dao;

import java.sql.*;

import vo.EmpVO;
import vo.JobGrantVO;

import java.io.*;

public class JobGrantDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String jdbc_url="jdbc:oracle:thin:@192.168.0.90:1521:air3"; //ip:post:DB��
	private String db_id="tokki";
	private String db_pwd="so";
	JobGrantVO jobGrantVO;
	
	
	
	
	
	
//	public void SetJobGrant(String jgNum){ System.out.println("SetJobGrant �޼ҵ�");
//    try {
//        Class.forName("oracle.jdbc.driver.OracleDriver");
//        conn = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
//        
//        String sql = "SELECT jg_no, jg_grant FROM JOB_GRANT WHERE jg_no = ?";
//        
//         jgNum = jobGrantVO.getJg_no();
//        
//        pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, jobGrantVO.getJg_no());
//        System.out.println("DAO jgNum :");
//        rs = pstmt.executeQuery();
//        
//        System.out.println("----------------------------------------------");
//        while (rs.next()) {System.out.println("rs.next ������ Ȯ��");
//        	
//            int jgNo = rs.getInt("jg_no");
//            String jgGrant = rs.getString("jg_grant");
//        	
//            System.out.printf("���ޱ����ڵ� : %d \n", jgNo);
//	        System.out.printf("���ޱ��� : %s \n", jgGrant);
//	        System.out.println();
//	        System.out.println("----------------------------------------------");
//
//        }
//    }
//    catch (ClassNotFoundException e) {
//        System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + e.getMessage());
//        e.printStackTrace();
//    }
//    catch (SQLException se) {
//        System.out.println(se.getMessage());
//        se.printStackTrace();
//    }
//    
//    finally {
//    		try {
//    			if(rs != null) {
//    				rs.close();
//    			}
//    		} catch (SQLException e) {
//    			System.out.println("RESULTSET ERROR");
//    			e.printStackTrace();
//    		}
//    		try {
//    			if(pstmt != null) {
//    				pstmt.close();
//    			}
//			} catch (Exception e) {
//				System.out.println("PREPAREDSTATEMENT ERROR");
//				e.printStackTrace();
//			}
//    		try {
//    			if(conn != null) {
//    				conn.close();
//    			}
//    		}
//    		catch (Exception e) {
//    			System.out.println("CONNECTION ERROR");
//    			e.printStackTrace();
//    		}
//    }
//}
	
	
	

	public JobGrantVO jobGrant() throws Exception{ 
		System.out.println("jobGrant �޼ҵ�");
		
		
//		int found = jgNum; // jgNum ���� found ������ �Ҵ�
//        	String sql = "SELECT jg_no, jg_grant FROM JOB_GRANT WHERE jg_no = ?";
		String sql = "SELECT jg_no, jg_grant FROM JOB_GRANT WHERE jg_no = ?";
        	jobGrantVO = new JobGrantVO();
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
            
//            SELECT jg_no, jg_grant 
//            FROM JOB_GRANT
//            WHERE jg_no = 1;
            
            String jg_no = "1";
           
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, jg_no);
//            jobGrantVO.getJg_no();
//            System.out.println("DAO jgNum(jgNo) : " + jobGrantVO.getJg_no());
            rs = pstmt.executeQuery();
            
            System.out.println("----------------------------------------------");
            
            
            if(rs.next()) {
            	System.out.println("rs.next ������ Ȯ��");

            	jobGrantVO.setJg_no(rs.getString("jg_no"));
            	jobGrantVO.setJg_grant(rs.getString("jg_grant"));
            	
//            	rs.getString("jg_no");
//            	rs.getString("jg_grant");
            	
            	String aaa = jobGrantVO.getJg_no();
            	System.out.println("�� ���� aaa : " + aaa);
            	String bbb = jobGrantVO.getJg_grant();
            	System.out.println("�� ���� bbb : " + bbb);
            	
                System.out.printf("���ޱ����ڵ� : %s \n", rs.getString("jg_no"));
		        System.out.printf("���ޱ��� : %s \n", rs.getString("jg_grant"));
		        System.out.println();
            }
            
            rs.close();
            pstmt.close();
            return jobGrantVO;
            
//            while (rs.next()) {;
//            
//            	found = rs.getInt("jg_no");
//            	
////                int empNo = rs.getInt("emp_no");
////                String empName = rs.getString("emp_name");
////                String empJob = rs.getString("emp_job");
////                String empPw = rs.getString("emp_pw");
////                 rs.getInt("jg_no");
//                String jgGrant = rs.getString("jg_grant");
//            	
//                System.out.printf("���ޱ����ڵ� : %d \n", found);
//		        System.out.printf("���ޱ��� : %s \n", jgGrant);
//		        System.out.println();
//		        
//            }
        }

}
