package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.ApprovalVO;

public class ApprovalDAO {
   private Connection conn = null;
   private String driver = "oracle.jdbc.driver.OracleDriver";
   private String url="jdbc:oracle:thin:@192.168.0.90:1521:air3";
   private String id = "tokki";
   private String pass="so";
   PreparedStatement ps = null;
   Statement stmt = null;
   ResultSet rs = null;
   ArrayList list = null;
   ApprovalVO vo;
   int pro_no;
   
      public ApprovalDAO() throws Exception{          
    	  connectDB();
      
      }
      
//      Connection  con;
      
   void connectDB() throws Exception {
      // TODO Auto-generated method stub
      Class.forName(driver);
      conn=DriverManager.getConnection(url, id, pass);
   }

   public ApprovalVO Writer(String id) {
	    ApprovalVO vo = new ApprovalVO(); // ApprovalVO ��ü ����
	    try {
	        String sql = "SELECT emp_name FROM emp WHERE emp_no = ?"; 
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();
	      
	        if (rs.next()) {
	            vo = new ApprovalVO();
	            vo.setApp_writer(rs.getString("emp_name"));
	        }
	        
	        rs.close();
	        ps.close();
	    } catch (Exception e) {
	        // ���� ó�� �ڵ� �ۼ�
	    }
	    return vo;
	

	  
	}
      
  
   public ApprovalVO Master(String id) {
	  ApprovalVO vo = new ApprovalVO();
	  try {
      String sql = "select e.emp_no, e.emp_mgr, m.emp_name from emp e, emp m where e.emp_no = ? and e.emp_mgr = m.emp_no"; 
      ps = conn.prepareStatement(sql);
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      
      
      if(rs.next()) {
         vo.setApp_master(rs.getString("emp_name"));
      }
      
      rs.close();
      ps.close();
	  } catch (Exception e) {
		// TODO: handle exception
	}
      return vo;
         
   }
   
   ///
   public ApprovalVO ProjectNo(String id) {
	ApprovalVO vo = new ApprovalVO();
	try {
//		select pro_no  from business_management bm,TEAM t,DEPARTMENT_TEAM dt, DEPARTMENT d,emp e
//		 WHERE bm.TEAM_NO =  t.TEAM_NO AND t.TEAM_NO = dt.TEAM_NO AND dt.EMP_NO = e.EMP_NO AND e.D_NO = d.D_NO;
//		String sql = "SELECT pro_no FROM business_management bm,team t,department_team dt, department d,emp e"
//				+ " WHERE bm.team_no =  t.team_no and t.team_no = dt.team_no and dt.emp_no = e.emp_no and e.d_no = d.d_no and e.emp_no =?";
		
		String sql = "SELECT p.PRO_NO FROM APPROVAL a, PROJECT p, EMP e, DEPARTMENT d, DEPARTMENT_TEAM dt, TEAM t "
		+ "WHERE a.PRO_NO = p.PRO_NO AND a.EMP_NO = e.EMP_NO AND e.D_no = d.D_NO AND e.EMP_NO = DT.EMP_NO AND dt.TEAM_NO = t.TEAM_NO and e.emp_no =?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
	        if (rs.next()) {
//	            vo = new ApprovalVO();
	            vo.setPro_no(rs.getInt("pro_no"));
	        }
	        
	        System.out.println("proNo db���� ���� �� " + vo.getApp_no());
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return vo;
   }
   
   
   public int ApprovalInsert(ApprovalVO vo) {
	   String sql = "INSERT INTO APPROVAL(app_no, pro_no, app_writer, app_master, app_date, app_title, app_contents,emp_no) "
	   		+ "VALUES (s_approval_app_no.NEXTVAL,?, ?, ?, ?, ?, ?, ?)";
	   try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, vo.getPro_no());
		ps.setString(2, vo.getApp_writer());
		ps.setString(3, vo.getApp_master());
		ps.setDate(4, vo.getApp_date());
		ps.setString(5, vo.getApp_title());
		ps.setString(6, vo.getApp_contents());
		ps.setInt(7, vo.getEmp_no());
		int result = ps.executeUpdate();
		ps.close();
		return result;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	   
	   return -1; // ������ ��� -1�� ��ȯ�ϰų� ���� ó���� �߰��Ͽ� �˸��� ����� ��ȯ�մϴ�.
   }
   
   public ApprovalVO ApprovalAdminViewTeamNoSelect() {
	   System.out.println("ApprovalAdminViewTeamNoSelect �����ϴ��� Ȯ��");
	ApprovalVO vo = new ApprovalVO();
//	ArrayList<ApprovalVO> approvalList = new ArrayList<>();
	
	try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
//        conn = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
		String sql = "SELECT t.team_no "
				+ "FROM APPROVAL a, EMP e, DEPARTMENT d, DEPARTMENT_TEAM dt, TEAM t "
				+ "WHERE a.EMP_NO = e.EMP_NO AND e.D_NO = d.D_NO AND d.D_NO = dt.DT_NO AND dt.TEAM_NO = t.TEAM_NO";
		ps = conn.prepareStatement(sql);
		  rs = ps.executeQuery();
		
	        if (rs.next()) { // ����� �����ϴ��� Ȯ��
//	            vo.setTeam_no(rs.getInt(vo.getTeam_no()));
	            vo.setTeam_no(rs.getInt("team_no")); // �÷����� ���ڿ��� �����Ͽ� ���� ������
	            
	        }
	} catch (Exception e) {
		e.printStackTrace();
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
				if(ps != null) {
					ps.close();
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
	return vo;
   }
   
   
   public ArrayList<ApprovalVO> ApprovalAdminViewSelect(int teamNo) {
	   System.out.println("ApprovalAdminViewSelect�� teamNo �� �޾ƿ����� Ȯ�� : " + teamNo);
//	ApprovalVO vo = new ApprovalVO(); //�̺κ� ����ϸ� �ȵ�
	ArrayList<ApprovalVO> approvalList = new ArrayList<>();
	
	
	try {
//        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, id, pass);
		String sql = "SELECT a.app_no ,a.app_title, a.app_writer, a.app_date, a.app_check, a.app_contents "
				+ "FROM APPROVAL a, EMP e, DEPARTMENT d, DEPARTMENT_TEAM dt, TEAM t "
				+ "WHERE a.EMP_NO = e.EMP_NO AND e.D_NO = d.D_NO AND d.D_NO = dt.DT_NO AND dt.TEAM_NO = t.TEAM_NO and t.team_no = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, teamNo);
		  rs = ps.executeQuery();
		
	        while (rs.next()) {
	        	ApprovalVO vo = new ApprovalVO();
	        	vo.setApp_no(rs.getInt("app_no"));
	            vo.setApp_title(rs.getString("app_title"));
	            vo.setApp_writer(rs.getString("app_writer"));
	            vo.setApp_date(rs.getDate("app_date"));
	            vo.setApp_check(rs.getString("app_check"));
	            vo.setApp_contents(rs.getString("app_contents"));
//	            vo.setTeam_no(rs.getInt(teamNo));
//	            vo.setTeam_no(vo.getTeam_no());
	            
	            System.out.println("title : " + vo.getApp_title());
	            System.out.println("writer : " + vo.getApp_writer());
	            System.out.println("date : " + vo.getApp_date());
	            System.out.println("check : " + vo.getApp_check());
	            System.out.println("contents : " + vo.getApp_contents());
	            approvalList.add(vo);
	        }
		
	} catch (Exception e) {
		e.printStackTrace();
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
				if(ps != null) {
					ps.close();
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
	return approvalList;
   }
   
   public int updateApproval(ApprovalVO vo) {
	   String sql = "UPDATE APPROVAL SET write_date = SYSDATE, app_check = 'Y' WHERE app_no = ? and app_check is null";
		   try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pass);
			ps = conn.prepareStatement(sql);
//			ps.setDate(1, vo.getApp_date());
//			ps.setString(2, vo.getApp_check());
//			ps.setInt(3, vo.getApp_no());
	        ps.setInt(1, vo.getApp_no());
			int result = ps.executeUpdate();
			ps.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		   return -1; // ������ ��� -1�� ��ȯ�ϰų� ���� ó���� �߰��Ͽ� �˸��� ����� ��ȯ�մϴ�.
   }
   
   public int updateReject(ApprovalVO vo) {
	   String sql = "UPDATE APPROVAL SET write_date = SYSDATE, app_check = 'N' WHERE app_no = ? and app_check is null";
		   try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pass);
			ps = conn.prepareStatement(sql);
	        ps.setInt(1, vo.getApp_no());
			int result = ps.executeUpdate();
			ps.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		   return -1; // ������ ��� -1�� ��ȯ�ϰų� ���� ó���� �߰��Ͽ� �˸��� ����� ��ȯ�մϴ�.
   }
   
   
   
   
   
   
   
   
   
   public ApprovalVO ApprovalAdminViewContents(int appNo) {System.out.println("ApprovalAdminViewContents �����ϴ��� Ȯ��");
	ApprovalVO vo = new ApprovalVO();
	
	try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, id, pass);
		String sql = "SELECT app_contents FROM APPROVAL "
				+ "WHERE app_no = ?";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		ps.setInt(1, appNo);
	        if (rs.next()) {
	            vo = new ApprovalVO();
//	            vo.setTeam_no(vo.getTeam_no());
//	            vo.setApp_title(rs.getString(vo.getApp_title()));
//	            vo.setApp_writer(rs.getString(vo.getApp_writer()));
//	            vo.setApp_date(rs.getDate(vo.getApp_date()));
//	            vo.setApp_check(rs.getString(vo.getApp_check()));
	            vo.setApp_contents(rs.getString(vo.getApp_contents()));
//	            vo.setTeam_no(vo.getTeam_no());
	            
//	            System.out.println("title : " + vo.getApp_title());
//	            System.out.println("writer : " + vo.getApp_writer());
//	            System.out.println("date : " + vo.getApp_date());
//	            System.out.println("check : " + vo.getApp_check());
	            System.out.println("contents : " + vo.getApp_contents());
	        }
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("���̺� Ŭ�� ���� ����");
		e.printStackTrace();
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
				if(ps != null) {
					ps.close();
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
	return vo;
   }
   
   
   
   public ArrayList approvalDocumentList(String app_writer) throws Exception {
	   
	   String sql = "insert into app_title, app_writer, write_date, app_check, app_contents from approval "
			   		+ "where app_writer = ?";
	   ps = conn.prepareStatement(sql);
	   ps.setString(1, app_writer);
	   ResultSet rs = ps.executeQuery();
	   
	   ArrayList<String> documentList = new ArrayList();
	   	   
	   while(rs.next()) {
		   documentList.add(rs.getString("app_title"));
		   documentList.add(rs.getString("app_writer"));
		   documentList.add(rs.getString("writer_date"));
		   documentList.add(rs.getString("app_check"));
		   documentList.add(rs.getString("app_contents"));
		  	   
	   }
	   rs.close();
	   ps.close();
	   return documentList;
   }

  public String documentContents(String app_writer) throws Exception {
	   String app_contents = null;
	   String sql = "select app_contents from approval "
			   		+ "where app_writer = ?";
	   ps = conn.prepareStatement(sql);
	   ps.setString(1, app_writer);
	   ResultSet rs = ps.executeQuery();
	   	   
	   if(rs.next()) {	
		  app_contents = rs.getString("app_contents");
	   }  	   
	   return app_contents;
   }
}
   

