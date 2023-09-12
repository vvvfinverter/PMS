package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.EmpDAO;
import dao.JobGrantDAO;
import vo.EmpVO;
import vo.JobGrantVO;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import java.awt.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

public class MainView1Newer extends JFrame {
	private JPanel contentPane;
	private String empId;
	String password = null;
	EmpVO empVO = null;
	EmpDAO empDAO = null;
	/**
	 * Launch the ap plication.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView1Newer frame = new MainView1Newer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView1Newer(String empId,String password){
		System.out.println("MainView empId 값 받아 오는지 확인 : " + empId);
		System.out.println("MainView empId 값 받아 오는지 확인 : " + password);
		getContentPane().setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView1Newer.class.getResource("/img/logo.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 536);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainView1Newer.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(98, 41, 295, 108);
		contentPane.add(lblNewLabel);
		
		setLocationRelativeTo(null); 		// 창 가운데 정렬
		setResizable(false);
		
		
		// 프로젝트 버튼 시작
		JButton btnNewButton = new JButton("프로젝트");		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// 현재창 닫기
				ProjectOpenView projectOpen = new ProjectOpenView();
//				ProjectView project = new ProjectView(empId);
				projectOpen.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(MainView1Newer.class.getResource("/img/p1.jpg")));
		btnNewButton.setBounds(71, 228, 147, 37);
		contentPane.add(btnNewButton);
		
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));			// 커서 모양 변경 								
		btnNewButton.setBorderPainted(false); 							// 선택 되지 않은 상태와, 마우스 올려 놨을 때 테두리	
		btnNewButton.setContentAreaFilled(false); 						// 배경										
		btnNewButton.setFocusPainted(false);								// 선택 됐을 때 선							
		btnNewButton.setOpaque(false);
		
		// 메신저 버튼 시작
		JButton btnNewButton2 = new JButton("메신저");		
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// 현재창 닫기
				SNSView sns = new SNSView();
				sns.setVisible(true);
			}
		});
		btnNewButton2.setIcon(new ImageIcon(MainView1Newer.class.getResource("/img/p2.jpg")));
		btnNewButton2.setOpaque(false);
		btnNewButton2.setFocusPainted(false);
		btnNewButton2.setContentAreaFilled(false);
		btnNewButton2.setBorderPainted(false);
		btnNewButton2.setBounds(273, 228, 147, 37);
		contentPane.add(btnNewButton2);
		
		// 발주 버튼 시작
		JButton btnNewButton3 = new JButton("New button");		
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// 현재창 닫기
//				OrderView order = new OrderView();
//				order.setVisible(true);
			}
		});
		btnNewButton3.setIcon(new ImageIcon(MainView1Newer.class.getResource("/img/p3.jpg")));
		btnNewButton3.setOpaque(false);
		btnNewButton3.setFocusPainted(false);
		btnNewButton3.setContentAreaFilled(false);
		btnNewButton3.setBorderPainted(false);
		btnNewButton3.setBounds(71, 291, 147, 37);
		contentPane.add(btnNewButton3);
		
		//납품 버튼 시작
		JButton btnNewButton4 = new JButton("New button");		
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// 현재창 닫기
//				SupplyView supply = new SupplyView();
//				supply.setVisible(true);
			}
		});
		btnNewButton4.setIcon(new ImageIcon(MainView1Newer.class.getResource("/img/p4.jpg")));
		btnNewButton4.setOpaque(false);
		btnNewButton4.setFocusPainted(false);
		btnNewButton4.setContentAreaFilled(false);
		btnNewButton4.setBorderPainted(false);
		btnNewButton4.setBounds(273, 291, 147, 37);
		contentPane.add(btnNewButton4);

		
		// 협력기간 버튼 (협력기간 확인 기능)
		JButton btnNewButton8 = new JButton("협력기간");
		btnNewButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// 현재창 닫기
//				AdministratorView administrator = new AdministratorView();
//				administrator.setVisible(true);
			}
		});
		btnNewButton8.setIcon(new ImageIcon(MainView1Newer.class.getResource("/img/p8.jpg")));		
		btnNewButton8.setOpaque(false);
		btnNewButton8.setFocusPainted(false);
		btnNewButton8.setContentAreaFilled(false);
		btnNewButton8.setBorderPainted(false);
		btnNewButton8.setBounds(71, 353, 147, 37);
		contentPane.add(btnNewButton8);
		
		// 발주기간 버튼 시작 (발주기간 추가기능)
		JButton btnNewButton6 = new JButton("New button");		
		btnNewButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// 현재창 닫기
//				partnerView project = new partnerView();
//				project.setVisible(true);
			}
		});
		btnNewButton6.setIcon(new ImageIcon(MainView1Newer.class.getResource("/img/p6.jpg")));
		btnNewButton6.setOpaque(false);
		btnNewButton6.setFocusPainted(false);
		btnNewButton6.setContentAreaFilled(false);
		btnNewButton6.setBorderPainted(false);
		btnNewButton6.setBounds(273, 353, 147, 37);
		contentPane.add(btnNewButton6);
		
		// 결제버튼 시작
		JButton btnNewButton5 = new JButton("New button");		
		btnNewButton5.setIcon(new ImageIcon(MainView1Newer.class.getResource("/img/p5.jpg")));
		btnNewButton5.setOpaque(false);
		btnNewButton5.setFocusPainted(false);
		btnNewButton5.setContentAreaFilled(false);
		btnNewButton5.setBorderPainted(false);
		btnNewButton5.setBounds(71, 412, 147, 37);
		contentPane.add(btnNewButton5);
		
		
		// 관리자 버튼 시작
		JButton btnNewButton7 = new JButton("New button");		
		btnNewButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				empDAO = new EmpDAO();
				
				int grantAccess = empDAO.SerchInfo2(empId, password).getJg_no();
				System.out.println("권한코드 : " + grantAccess);

				System.out.println("관리자 버튼 클릭하기 직전의 empID 값 확인 : " + empId);
					if(grantAccess == 1 || grantAccess == 2) {
						dispose();		// 현재창 닫기
//						AdministratorView administrator = new AdministratorView(empId);
//						administrator.setVisible(true);
					}else {
						
					JOptionPane.showMessageDialog(null, "권한이 없어", "권한없음", JOptionPane.DEFAULT_OPTION);
					return;
				}

			}
		});
		btnNewButton7.setIcon(new ImageIcon(MainView1Newer.class.getResource("/img/p7.jpg")));
		btnNewButton7.setOpaque(false);
		btnNewButton7.setFocusPainted(false);
		btnNewButton7.setContentAreaFilled(false);
		btnNewButton7.setBorderPainted(false);
		btnNewButton7.setBounds(66, 416, 147, 37);
		contentPane.add(btnNewButton7);
		
	
	// 관리자 권한변경
//	JButton btnNewButton9 = new JButton("New button");		
//	btnNewButton9.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			
//			empDAO = new EmpDAO();
//			
//			int grantAccess = empDAO.SerchInfo2(empId, password).getJg_no();
//			System.out.println("권한코드 : " + grantAccess);
//			
//			System.out.println("관리자 버튼 클릭하기 직전의 empID 값 확인 : " + empId);
//			if(grantAccess == 1 || grantAccess == 2) {
//				dispose();		// 현재창 닫기
//				AdministratorView administrator = new AdministratorView(empId);
//				administrator.setVisible(true);
//			}else {
//				
//			JOptionPane.showMessageDialog(null, "권한이 없어", "권한없음", JOptionPane.DEFAULT_OPTION);
//			return;
//		}
//			
//	  }
//	});
//	btnNewButton9.setIcon(new ImageIcon(MainView.class.getResource("/img/p7.jpg")));
//	btnNewButton9.setOpaque(false);
//	btnNewButton9.setFocusPainted(false);
//	btnNewButton9.setContentAreaFilled(false);
//	btnNewButton9.setBorderPainted(false);
//	btnNewButton9.setBounds(273, 412, 147, 37);
//	contentPane.add(btnNewButton9);
	
}

	public MainView1Newer() {
		// TODO Auto-generated constructor stub
	}
}
