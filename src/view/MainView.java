package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.EmpDAO;
import dao.JobGrantDAO;
import network.Client;
import network.Receiver;
import network.Send;
import network.Server;
import network.User;
import vo.EmpVO;
import vo.JobGrantVO;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
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
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class MainView extends JFrame {
	JPanel contentPane;
	String empId;
	JobGrantDAO jobGrantDAO = null;
	JobGrantVO jobGrantVO = null;
	EmpVO empVO = null;
	EmpDAO empDAO = null;
	String password = null;
	String empName = null;
	
	/**
	 * Launch the app plication.
	 */
	public static void main(String[] args) {
		//서버 실행?
//		Server server = new Server();
//		Client client = new Client();
//		server.networkMethod();
//		client.clientMethod();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					MainView frame = new MainView();
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
	public MainView(String empId, String password) throws Exception{
		System.out.println("MainView empId 값 받아 오는지 확인 : " + empId);
		this.empId = empId;
		
		getContentPane().setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/img/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 536);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainView.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(100, 70, 295, 108);
		contentPane.add(lblNewLabel);
		
		setLocationRelativeTo(null); 		// 창 가운데 정렬
		setResizable(false);
		
		JButton btnNewButton = new JButton("프로젝트");		// 프로젝트 버튼 시작
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// 현재창 닫기
//				ProjectView project = new ProjectView(empId);
//				project.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(MainView.class.getResource("/img/p1.jpg")));
		btnNewButton.setBounds(66, 228, 147, 37);
		contentPane.add(btnNewButton);
		
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));			// 커서 모양 변경 								
		btnNewButton.setBorderPainted(false); 							// 선택 되지 않은 상태와, 마우스 올려 놨을 때 테두리	
		btnNewButton.setContentAreaFilled(false); 						// 배경										
		btnNewButton.setFocusPainted(false);								// 선택 됐을 때 선							
		btnNewButton.setOpaque(false);
		
		JButton btnNewButton2 = new JButton("메신저");		// 메신저 버튼 시작
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// 현재창 닫기
				SNSView sns = new SNSView(empId);
				sns.setVisible(true);
			}
		});
		btnNewButton2.setIcon(new ImageIcon(MainView.class.getResource("/img/p2.jpg")));
		btnNewButton2.setOpaque(false);
		btnNewButton2.setFocusPainted(false);
		btnNewButton2.setContentAreaFilled(false);
		btnNewButton2.setBorderPainted(false);
		btnNewButton2.setBounds(268, 228, 147, 37);
		contentPane.add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("New button");		// 발주 버튼 시작
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// 현재창 닫기
//				OrderView order = new OrderView();
//				order.setVisible(true);
			}
		});
		btnNewButton3.setIcon(new ImageIcon(MainView.class.getResource("/img/p3.jpg")));
		btnNewButton3.setOpaque(false);
		btnNewButton3.setFocusPainted(false);
		btnNewButton3.setContentAreaFilled(false);
		btnNewButton3.setBorderPainted(false);
		btnNewButton3.setBounds(66, 291, 147, 37);
		contentPane.add(btnNewButton3);
		
		JButton btnNewButton4 = new JButton("New button");		//납품 시작 버튼 시작
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// 현재창 닫기
//				SupplyView supply = new SupplyView();
//				supply.setVisible(true);
			}
		});
		btnNewButton4.setIcon(new ImageIcon(MainView.class.getResource("/img/p4.jpg")));
		btnNewButton4.setOpaque(false);
		btnNewButton4.setFocusPainted(false);
		btnNewButton4.setContentAreaFilled(false);
		btnNewButton4.setBorderPainted(false);
		btnNewButton4.setBounds(268, 291, 147, 37);
		contentPane.add(btnNewButton4);
		
		// 결제버튼 시작

		JButton btnNewButton5 = new JButton("New button");
		btnNewButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empDAO = new EmpDAO();
				empVO = new EmpVO();
				empVO = empDAO.SerchInfo2(empId, password);
				int jgNum = empVO.getJg_no();
				System.out.println("관리자 버튼 클릭하기 직전의 empID 값 확인 : " + empId);
				System.out.println("jgNum 값 확인 : " + jgNum);
				if(jgNum == 1 || jgNum == 2 || jgNum ==3) {
					dispose();		// 현재창 닫기
					ApprovalAdminView approvalAdminView = new ApprovalAdminView(empId,password);
					approvalAdminView.setVisible(true);
				}else if(jgNum == 4 || jgNum == 5 || jgNum == 6) {
					dispose();
//					ApprovalView approvalView = new ApprovalView();
					ApprovalView approvalView = new ApprovalView(empId,password);
					approvalView.setVisible(true);
				}else {
					System.out.println("여기로 들어갈 가능성 99.97% 없음");
				}
			}
		});
		btnNewButton5.setIcon(new ImageIcon(MainView.class.getResource("/img/p5.jpg")));
		btnNewButton5.setOpaque(false);
		btnNewButton5.setFocusPainted(false);
		btnNewButton5.setContentAreaFilled(false);
		btnNewButton5.setBorderPainted(false);
//		btnNewButton5.setBounds(66, 412, 147, 37);
		btnNewButton5.setBounds(66, 353, 147, 37);
		contentPane.add(btnNewButton5);
		
		JButton btnNewButton6 = new JButton("New button");		// 발주기간 버튼 시작
		btnNewButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// 현재창 닫기
//				partnerView project = new partnerView();
//				project.setVisible(true);
			}
		});
		btnNewButton6.setIcon(new ImageIcon(MainView.class.getResource("/img/p6.jpg")));
		btnNewButton6.setOpaque(false);
		btnNewButton6.setFocusPainted(false);
		btnNewButton6.setContentAreaFilled(false);
		btnNewButton6.setBorderPainted(false);
		btnNewButton6.setBounds(268, 353, 147, 37);
		contentPane.add(btnNewButton6);
		
		JButton btnNewButton7 = new JButton("New button");		// 관리자 버튼 시작
		btnNewButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				empDAO = new EmpDAO();
				
				int grantAccess = empDAO.SerchInfo2(empId, password).getD_no();
				System.out.println("권한코드 : " + grantAccess);

				System.out.println("관리자 버튼 클릭하기 직전의 empID 값 확인 : " + empId);
					if(grantAccess == 5) {
						dispose();		// 현재창 닫기
						AdministratorView administrator = new AdministratorView(empId);
						administrator.setVisible(true);
					}else {
						
					JOptionPane.showMessageDialog(null, "인사부가 아니기 때문에 권한이 없습니다.", "권한없음", JOptionPane.DEFAULT_OPTION);
					return;
				}

			}
		});
		btnNewButton7.setIcon(new ImageIcon(MainView.class.getResource("/img/p7.jpg")));
		btnNewButton7.setOpaque(false);
		btnNewButton7.setFocusPainted(false);
		btnNewButton7.setContentAreaFilled(false);
		btnNewButton7.setBorderPainted(false);
		btnNewButton7.setBounds(66, 416, 147, 37);
		contentPane.add(btnNewButton7);
		
		
		empDAO = new EmpDAO();
		empName = empDAO.SerchInfo2(empId, password).getEmp_name();

		JLabel lblNewLabel_1 = new JLabel(empName +"님 환영합니다.");
		lblNewLabel_1.setBounds(179, 178, 147, 24);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//logout 기능 실행하는 곳
//				empId = "";
				dispose();
				LoginView login = new LoginView();
				login.loggedIn = false;
				login.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(305, 179, 73, 23);
		contentPane.add(btnNewButton_1);
		
		Client(empId);



		
	}

	public MainView() {
		System.out.println("MainView 기본 생성자 실행됨");

	}
	
	
	public void Client(String empId) {
		System.out.println("Client 네트워크 관련된 메소드 탔음");
		Socket socket = null;
		DataInputStream in = null; //이 변수는 사용자가 입력하는 채팅 부분에 해당됩니다.
//		BufferedReader in2 = null; //이 변수는 사용자의 닉네임에 해당됩니다. 
		
		DataOutputStream out = null; //이 변수는 사용자가 입력한 데이터를 출력할 때 사용합니다.
		
		try {
			InetAddress ia = null; //Local Host IP Address 가져오기 위한 변수
			ia = InetAddress.getLocalHost(); //현재 PC의 IP Address 가져오기
			socket = new Socket(ia, 9003); //Client의 IP와 port 번호 입력
//			socket = new Socket("192.168.0.90", 9000);
			/*
			 * DataInputStream은 입력 스트림을 받는 매개변수이며,
			 * socket.getInputStream()함수를 통해 소켓에서 전달되는 데이터 스트림을 읽어옵니다.
			 * BufferedReader는 Scanner와 비슷한 개념입니다.
			 * Scanner보다 빠르다는 장점이 있지만 String형으로 버퍼에 저장하기 때문에
			 * 따로 데이터를 가공해서 사용해야하는 경우가 많습니다.
			 */
			in = new DataInputStream(socket.getInputStream());
//			in2 = new BufferedReader(new InputStreamReader(System.in));
			out = new DataOutputStream(socket.getOutputStream());
			
//			System.out.println("닉네임을 입력해주세요 : ");
//			String data = in2.readLine(); // 채팅에 사용할 닉네임을 받아옵니다.

//			EmpDAO empDAO = new EmpDAO();
//			empId = empDAO.SerchInfo2(String empId, String password).getEmp_no();
			
			System.out.println("client empId : " + empId);
//			out.write(empId);
			out.writeUTF(empId); //닉네임을 UTF-8로 변경 후 출력스트림에 넣습니다.
			Thread th = new Thread(new Send(out)); //새로운 쓰레드에 out을 집어넣도록 합니다.
			th.start();  //쓰레드 시작
		} catch (IOException e) {
			System.out.println("Client excception");
			e.printStackTrace();
		}
	}
}
