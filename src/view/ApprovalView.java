package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import dao.ApprovalDAO;
import dao.EmpDAO;
import vo.ApprovalVO;

public class ApprovalView extends JFrame {
   private JPanel contentPane;
   private JTextField txtWriter;
   private JLabel lblMaster;
   private JTextField txtAppDate;
   private JLabel lblAppDate;
   private JPanel panel;
   private JLabel lblNewLabel_3;
   private JTextField txtTitle;
   private JLabel lblContents;
   private JScrollPane scrollPane;
   private JTextField txtContents;
   private JButton btnApproval;
   ApprovalDAO dao;   
   ApprovalVO vo;
   private ArrayList<ApprovalVO> approvalList;
   private String empName;
   static EmpDAO empDAO = null;
   static String empId;
   static String password;
   private JTextField txtMaster;
   private JTextField txtPro;
   


   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
                empDAO = new EmpDAO();
//                empId = "EMPLOYEE_ID"; // ��ȿ�� ���� ID ������ �����ؾ� ��
//                password = "PASSWORD"; 
               String empName = empDAO.SerchInfo2(empId, password).getEmp_name();
               ApprovalView frame = new ApprovalView();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public ApprovalView() {

	      

   }
   /**
    * Create the frame.
    */
   public ApprovalView(String empId,String password) {
	   this.empId = empId;
	   this.password = password;
	      System.out.println("���ο��� �Ѿ�� empId �� : " + empId);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setBounds(100, 100, 571, 690);
	      contentPane = new JPanel();
	      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	      setContentPane(contentPane);
	      
		     JLabel proLbl = new JLabel("������Ʈ ��ȣ");
		     proLbl.setBounds(50, 42, 83, 14);
		      
		     txtPro = new JTextField();
		     txtPro.setBounds(145, 34, 116, 31);
		     txtPro.setText((String) null);
		     txtPro.setColumns(10);
		      
		      try {
		    	    dao = new ApprovalDAO();
		    	    
		    	    // project number ���� �����ͼ� textField�� ����
		    	    ApprovalVO proVO = dao.ProjectNo(empId);
		    	    int proNum = proVO.getPro_no();
//		    	    System.out.println("proNum : " + proNum);
		    	    //int���� String���� ��ȯ
		    	    String proNumString = String.valueOf(proNum);
		    	    txtPro.setText(proNumString);
		    	} catch (Exception e) {
		    	    e.printStackTrace();
		    	}
		      
		      txtPro.addActionListener(new ActionListener() {
		     	    public void actionPerformed(ActionEvent e) {
		     	        try {
		     	            // ApprovalDAO�� ����Ͽ� �����ͺ��̽��� ����
		     	        	ApprovalVO proVO = dao.ProjectNo(empId);
		     	        	 int proNum = proVO.getPro_no();
		    	    	    String proNumString = String.valueOf(proNum);
		     	            // projectNo ���� textField�� ����
		    	    	    txtPro.setText(proNumString);
//		    	    	    System.out.println("txtpro�� : " + txtPro.getText());
		     	        } catch (Exception e1) {
		     	            e1.printStackTrace();
		     	        }
		     	    }
		     	});
		     
	      JLabel lblWriter = new JLabel("�����");
	      lblWriter.setBounds(50, 83, 53, 15);
	      
	      txtWriter = new JTextField();
	      txtWriter.setBounds(145, 75, 116, 31);
	      txtWriter.setColumns(10);
	      
	      try {
	  	    dao = new ApprovalDAO();

	  	    // ���� �ۼ��� ���� �����ͼ� textField�� ����
	  	    ApprovalVO writerVO = dao.Writer(empId);
	  	    String writer = writerVO.getApp_writer();
	  	    txtWriter.setText(writer);
	  	} catch (Exception e) {
	  	    e.printStackTrace();
	  	}

	  	// ����� ���� �������� �ʴ� �ڵ�
	  	// textField.setText(empName);

	  	txtWriter.addActionListener(new ActionListener() {
	  	    public void actionPerformed(ActionEvent e) {
	  	        try {
	  	            // ApprovalDAO�� ����Ͽ� �����ͺ��̽��� ����
	  	            String empName = dao.Writer(empId).getApp_writer(); // �������� �ʵ��� ���� ������
	  	            
	  	            // ����� ���� textField�� ����
	  	            txtWriter.setText(empName);
	  	        } catch (Exception e1) {
	  	            e1.printStackTrace();
	  	        }
	  	    }
	  	});
	      
	  	
	  	
	      lblMaster = new JLabel("������");
	      lblMaster.setBounds(50, 131, 53, 15);
		      txtMaster = new JTextField();
		      txtMaster.setBounds(145, 124, 116, 29);
		      txtMaster.setColumns(10);
		      
		      try {
		    	    dao = new ApprovalDAO();
		    	    ApprovalVO masterVO = dao.Master(empId);
		    	    String master = masterVO.getApp_master();
		    	    txtMaster.setText(master);
		    	} catch (Exception e) {
		    	    e.printStackTrace();
		    	}
		      
		     	txtMaster.addActionListener(new ActionListener() {
		     	    public void actionPerformed(ActionEvent e) {
		     	        try {
		     	            // ApprovalDAO�� ����Ͽ� �����ͺ��̽��� ����
		     	            String masterName = dao.Master(empId).getApp_master(); // �������� �ʵ��� ���� ������
		     	            
		     	            // ����� ���� textField�� ����
		     	            txtMaster.setText(masterName);
		     	        } catch (Exception e1) {
		     	            e1.printStackTrace();
		     	        }
		     	    }
		     	});
	      
	      
	      txtAppDate = new JTextField();
	      txtAppDate.setBounds(145, 171, 116, 31);
	      txtAppDate.setColumns(10);
	      
	      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	      String sysdate = dateFormat.format(new Date());
	      
	      txtAppDate.setText(sysdate);
	      
	      

	      
	      lblAppDate = new JLabel("�������");
	      lblAppDate.setBounds(38, 179, 65, 15);
	      
	      panel = new JPanel();
	      panel.setBounds(21, 211, 491, 38);
	      
	      lblContents = new JLabel("��ȳ���");
	      lblContents.setBounds(27, 277, 59, 15);
	      
	      scrollPane = new JScrollPane();
	      scrollPane.setBounds(17, 304, 521, 337);
	      
	      btnApproval = new JButton("������");
	      btnApproval.setBounds(343, 38, 91, 23);
	      

	      // "������" ��ư ActionListener
	      btnApproval.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	              try {System.out.println("�����Ź�ư Ŭ����");
	              	  // ApprovalDAO�� ����Ͽ� �����ͺ��̽��� ����
	              	  String proNString = txtPro.getText();
	              	  String writer = txtWriter.getText();
	              	  String master = txtMaster.getText();
	              	  String app_date = txtAppDate.getText();
	              	  
	              	  
	                  // SimpleDateFormat�� ����Ͽ� �ؽ�Ʈ�� Date�� ��ȯ
	                  //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // �Էµ� ��¥ ���Ŀ� �´� SimpleDateFormat ��ü ����
//	                  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
//	                  java.util.Date utilDate = dateFormat.parse(app_date);
	                  java.util.Date utilDate = dateFormat.parse(app_date);
	                  // java.util.Date�� java.sql.Date�� ��ȯ
	                  java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	              	  
	                  String title = txtTitle.getText();
	                  String contents = txtContents.getText(); 
	              	  int empNo = Integer.parseInt(empId);
	              	  
	              	  System.out.println("proNString : " + proNString);
	              	System.out.println("writer : " + writer);
	              	System.out.println("master : " + master);
	              	System.out.println("sqlDate : " + sqlDate);
	              	System.out.println("sqlDate : " + sqlDate);
	              	System.out.println("title : " + title);
	              	System.out.println("empNo : " + empNo);
	              	  
//	                 Date date = new Date();
//	                 String dateString = dateFormat.format(date);
//	                 java.sql.Date sqlDate = java.sql.Date.valueOf(dateString);

	              	  
	                 // ApprovalVO ��ü ���� �� ������ ����
	                 ApprovalVO approvalVO = new ApprovalVO();
	                 approvalVO.setPro_no(Integer.parseInt(proNString));
	                 approvalVO.setApp_writer(writer);
	                 approvalVO.setApp_master(master);
	                 approvalVO.setApp_date(sqlDate);
	                 approvalVO.setApp_title(title);
	                 approvalVO.setApp_contents(contents);
	                 approvalVO.setEmp_no(empNo);
	                 
	 
	                 int result = dao.ApprovalInsert(approvalVO);
	                 
	                 if(result == 1) {
	                	 //inesrt ����
	                	 JOptionPane.showMessageDialog(null, "�������� �Ϸ�Ǿ����ϴ�.", "������", JOptionPane.DEFAULT_OPTION);
	                 }else {
	                	 JOptionPane.showMessageDialog(null, "������ �����Ͽ����ϴ�.", "�������", JOptionPane.DEFAULT_OPTION);
	                 }
	                  
	                 clearScreen();
	              } catch (Exception ex) {
	            	  System.out.println("������ ��� ����");
	                  ex.printStackTrace();
	              }
	          }
	      });
	      
	      JButton btnMainView = new JButton("����ȭ��");
	      btnMainView.setBounds(447, 38, 91, 23);
	      contentPane.add(btnMainView);
	      
	      btnMainView.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainView main;
				try {
					main = new MainView(empId,password);
					main.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		      
	   
	      
	      txtContents = new JTextField();
	      scrollPane.setViewportView(txtContents);
	      txtContents.setColumns(10);
	      panel.setLayout(null);
	      
	      lblNewLabel_3 = new JLabel("��������");
	      lblNewLabel_3.setBounds(12, 10, 73, 15);
	      panel.add(lblNewLabel_3);
	      
	      txtTitle = new JTextField();
	      txtTitle.setBounds(124, 2, 210, 31);
	      txtTitle.setColumns(10);
	      panel.add(txtTitle);
	      contentPane.setLayout(null);
	      contentPane.add(lblContents);
	      contentPane.add(scrollPane);
	      contentPane.add(proLbl);
	      contentPane.add(txtPro);
	      contentPane.add(lblWriter);
	      contentPane.add(lblMaster);
	      contentPane.add(lblAppDate);
	      contentPane.add(txtMaster);
	      contentPane.add(txtAppDate);
	      contentPane.add(txtWriter);
	      contentPane.add(btnApproval);
	      contentPane.add(panel);
	      


       
   }
   
   void clearScreen() {
 	  txtTitle.setText("");
 	  txtContents.setText("");
 	 
   }
}