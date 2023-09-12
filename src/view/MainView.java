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
		//���� ����?
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
		System.out.println("MainView empId �� �޾� ������ Ȯ�� : " + empId);
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
		
		setLocationRelativeTo(null); 		// â ��� ����
		setResizable(false);
		
		JButton btnNewButton = new JButton("������Ʈ");		// ������Ʈ ��ư ����
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// ����â �ݱ�
//				ProjectView project = new ProjectView(empId);
//				project.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(MainView.class.getResource("/img/p1.jpg")));
		btnNewButton.setBounds(66, 228, 147, 37);
		contentPane.add(btnNewButton);
		
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));			// Ŀ�� ��� ���� 								
		btnNewButton.setBorderPainted(false); 							// ���� ���� ���� ���¿�, ���콺 �÷� ���� �� �׵θ�	
		btnNewButton.setContentAreaFilled(false); 						// ���										
		btnNewButton.setFocusPainted(false);								// ���� ���� �� ��							
		btnNewButton.setOpaque(false);
		
		JButton btnNewButton2 = new JButton("�޽���");		// �޽��� ��ư ����
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// ����â �ݱ�
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
		
		JButton btnNewButton3 = new JButton("New button");		// ���� ��ư ����
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// ����â �ݱ�
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
		
		JButton btnNewButton4 = new JButton("New button");		//��ǰ ���� ��ư ����
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// ����â �ݱ�
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
		
		// ������ư ����

		JButton btnNewButton5 = new JButton("New button");
		btnNewButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empDAO = new EmpDAO();
				empVO = new EmpVO();
				empVO = empDAO.SerchInfo2(empId, password);
				int jgNum = empVO.getJg_no();
				System.out.println("������ ��ư Ŭ���ϱ� ������ empID �� Ȯ�� : " + empId);
				System.out.println("jgNum �� Ȯ�� : " + jgNum);
				if(jgNum == 1 || jgNum == 2 || jgNum ==3) {
					dispose();		// ����â �ݱ�
					ApprovalAdminView approvalAdminView = new ApprovalAdminView(empId,password);
					approvalAdminView.setVisible(true);
				}else if(jgNum == 4 || jgNum == 5 || jgNum == 6) {
					dispose();
//					ApprovalView approvalView = new ApprovalView();
					ApprovalView approvalView = new ApprovalView(empId,password);
					approvalView.setVisible(true);
				}else {
					System.out.println("����� �� ���ɼ� 99.97% ����");
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
		
		JButton btnNewButton6 = new JButton("New button");		// ���ֱⰣ ��ư ����
		btnNewButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();		// ����â �ݱ�
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
		
		JButton btnNewButton7 = new JButton("New button");		// ������ ��ư ����
		btnNewButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				empDAO = new EmpDAO();
				
				int grantAccess = empDAO.SerchInfo2(empId, password).getD_no();
				System.out.println("�����ڵ� : " + grantAccess);

				System.out.println("������ ��ư Ŭ���ϱ� ������ empID �� Ȯ�� : " + empId);
					if(grantAccess == 5) {
						dispose();		// ����â �ݱ�
						AdministratorView administrator = new AdministratorView(empId);
						administrator.setVisible(true);
					}else {
						
					JOptionPane.showMessageDialog(null, "�λ�ΰ� �ƴϱ� ������ ������ �����ϴ�.", "���Ѿ���", JOptionPane.DEFAULT_OPTION);
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

		JLabel lblNewLabel_1 = new JLabel(empName +"�� ȯ���մϴ�.");
		lblNewLabel_1.setBounds(179, 178, 147, 24);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//logout ��� �����ϴ� ��
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
		System.out.println("MainView �⺻ ������ �����");

	}
	
	
	public void Client(String empId) {
		System.out.println("Client ��Ʈ��ũ ���õ� �޼ҵ� ����");
		Socket socket = null;
		DataInputStream in = null; //�� ������ ����ڰ� �Է��ϴ� ä�� �κп� �ش�˴ϴ�.
//		BufferedReader in2 = null; //�� ������ ������� �г��ӿ� �ش�˴ϴ�. 
		
		DataOutputStream out = null; //�� ������ ����ڰ� �Է��� �����͸� ����� �� ����մϴ�.
		
		try {
			InetAddress ia = null; //Local Host IP Address �������� ���� ����
			ia = InetAddress.getLocalHost(); //���� PC�� IP Address ��������
			socket = new Socket(ia, 9003); //Client�� IP�� port ��ȣ �Է�
//			socket = new Socket("192.168.0.90", 9000);
			/*
			 * DataInputStream�� �Է� ��Ʈ���� �޴� �Ű������̸�,
			 * socket.getInputStream()�Լ��� ���� ���Ͽ��� ���޵Ǵ� ������ ��Ʈ���� �о�ɴϴ�.
			 * BufferedReader�� Scanner�� ����� �����Դϴ�.
			 * Scanner���� �����ٴ� ������ ������ String������ ���ۿ� �����ϱ� ������
			 * ���� �����͸� �����ؼ� ����ؾ��ϴ� ��찡 �����ϴ�.
			 */
			in = new DataInputStream(socket.getInputStream());
//			in2 = new BufferedReader(new InputStreamReader(System.in));
			out = new DataOutputStream(socket.getOutputStream());
			
//			System.out.println("�г����� �Է����ּ��� : ");
//			String data = in2.readLine(); // ä�ÿ� ����� �г����� �޾ƿɴϴ�.

//			EmpDAO empDAO = new EmpDAO();
//			empId = empDAO.SerchInfo2(String empId, String password).getEmp_no();
			
			System.out.println("client empId : " + empId);
//			out.write(empId);
			out.writeUTF(empId); //�г����� UTF-8�� ���� �� ��½�Ʈ���� �ֽ��ϴ�.
			Thread th = new Thread(new Send(out)); //���ο� �����忡 out�� ����ֵ��� �մϴ�.
			th.start();  //������ ����
		} catch (IOException e) {
			System.out.println("Client excception");
			e.printStackTrace();
		}
	}
}
