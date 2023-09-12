package dao;

import java.sql.*;

import vo.AdministratorVO;
import vo.AdministratorVOList;
import vo.EmpVO;

import java.io.*;

public class AdministratorDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String jdbc_url="jdbc:oracle:thin:@192.168.0.90:1521:air3"; //ip:post:DB��
	private String db_id="tokki";
	private String db_pwd="so";
//	EmpVO empVO = null;
	AdministratorVO administratorVO = null;
	AdministratorVOList administratorVOList = null;
	



	
	  public AdministratorVOList SelectEmpCombo() {
		  administratorVOList = new AdministratorVOList();
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            conn = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
	            String sql = "SELECT emp_no, emp_name, emp_job, emp_pw, jg_no, d_no FROM emp";
	            
	            pstmt = conn.prepareStatement(sql);
//	            pstmt.setInt(1, emp_no);
//	            pstmt.setString(1, empId);
	            
	            rs = pstmt.executeQuery();
	            System.out.println("SelectEmpCombo------------------------------------------");
	            while (rs.next()) {
	            	// ���� �ڵ忡�� emp_no�� ����Ʈ�� �߰��ϴ� �κ��� ����
	            	administratorVOList.getEmp_no().add(rs.getInt("emp_no"));
	            	
	            	administratorVOList.getJg_no().add(rs.getInt("jg_no"));
	                
			        System.out.println();
			        
	            }
	        }
	        catch (ClassNotFoundException e) {
	            System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + e.getMessage());
	            e.printStackTrace();
	        }
	        catch (SQLException se) {
	            System.out.println(se.getMessage());
	            se.printStackTrace();
	        }
	        
	        finally {
	        		try {
	        			if(rs != null) {
	        				rs.close();
	        			}
	        		} catch (SQLException e) {
	        			System.out.println("RESULTSET ERROR");
	        			e.printStackTrace();
	        		}
	        		try {
	        			if(pstmt != null) {
	        				pstmt.close();
	        			}
					} catch (Exception e) {
						System.out.println("PREPAREDSTATEMENT ERROR");
						e.printStackTrace();
					}
	        		try {
	        			if(conn != null) {
	        				conn.close();
	        			}
	        		}
	        		catch (Exception e) {
	        			System.out.println("CONNECTION ERROR");
	        			e.printStackTrace();
	        		}
	        }
		  return administratorVOList;
	}
	  
	  public AdministratorVO SelectEmp(String empId) {
		  administratorVO = new AdministratorVO();
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            conn = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
	            String sql = "SELECT emp_no, emp_name, emp_job, emp_pw, jg_no, d_no FROM emp where emp_no = ?";
	            
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, empId);
	            
	            rs = pstmt.executeQuery();
	            System.out.println("SelectEmp------------------------------------------");
	            while (rs.next()) {
	            	// ���� �ڵ忡�� emp_no�� ����Ʈ�� �߰��ϴ� �κ��� ����
	            	administratorVO.setEmp_no(rs.getInt("emp_no"));
	            	
	            	
//            	setEmp_no.(rs.getInt("emp_no")); //���� ���Ű��� �ڵ� �ؼ� �ȵƴ� �ڵ�
	            	
	            	administratorVO.setEmp_name(rs.getString("emp_name"));
	            	administratorVO.setEmp_job(rs.getString("emp_job"));
	            	administratorVO.setEmp_pw(rs.getString("emp_pw"));
	            	administratorVO.setJg_no(rs.getInt("jg_no"));
	            	administratorVO.setD_no(rs.getInt("d_no"));
	                
	            	
	                System.out.printf("�����ȣ : %d \n", rs.getInt("emp_no"));
			        System.out.printf("��    �� : %s \n", rs.getString("emp_name"));
			        System.out.printf("��	å: %s \n", rs.getString("emp_job"));
			        System.out.printf("��й�ȣ : %s \n", rs.getString("emp_pw"));
			        System.out.printf("���ޱ����ڵ� : %d \n", rs.getInt("jg_no"));
			        System.out.printf("�μ���ȣ : %d \n", rs.getInt("d_no"));
			        System.out.println();
			        
	            }
	        }
	        catch (ClassNotFoundException e) {
	            System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + e.getMessage());
	            e.printStackTrace();
	        }
	        catch (SQLException se) {
	            System.out.println(se.getMessage());
	            se.printStackTrace();
	        }
	        
	        finally {
	        		try {
	        			if(rs != null) {
	        				rs.close();
	        			}
	        		} catch (SQLException e) {
	        			System.out.println("RESULTSET ERROR");
	        			e.printStackTrace();
	        		}
	        		try {
	        			if(pstmt != null) {
	        				pstmt.close();
	        			}
					} catch (Exception e) {
						System.out.println("PREPAREDSTATEMENT ERROR");
						e.printStackTrace();
					}
	        		try {
	        			if(conn != null) {
	        				conn.close();
	        			}
	        		}
	        		catch (Exception e) {
	        			System.out.println("CONNECTION ERROR");
	        			e.printStackTrace();
	        		}
	        }
		  return administratorVO;
	}
	
	   //���ޱ��� ����
	   public int EmpGrantModify(int jgNo, String empJob, int empNo) throws Exception {
//	public int EmpGrantModify(AdministratorVO administratorVO) throws Exception {
           System.out.println(jgNo);
           System.out.println(empJob);
           System.out.println(empNo);
		   Class.forName("oracle.jdbc.driver.OracleDriver");
           conn = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
		   String sql = "update EMP " 
				   + "set jg_no = ?, emp_job = ? where emp_no = ?";
		   pstmt = conn.prepareStatement(sql);
		   System.out.println("���ޱ��� ���� ���� Ž");
//		   int jgNo = administratorVO.getJg_no();
//		   String empJob = administratorVO.getEmp_job();
//		   String empNo = administratorVO.getEmp_no();
//		   System.out.println("jgNo : " + jgNo);
//		   System.out.println("empJob : " + empJob);
//		   System.out.println("empno : " + empNo);
//		   pstmt.setInt(1, jgNo);
//		   pstmt.setString(2, empJob);
//		   pstmt.setString(3, empNo);
		   pstmt.setInt(1, jgNo);
		   pstmt.setString(2, empJob);
		   pstmt.setInt(3, empNo);
		    
		   int rownum = pstmt.executeUpdate();
		   pstmt.close();
		   return rownum;
	   }

	
	

}
