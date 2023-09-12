package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.EmpDAO;
import network.User;
import vo.EmpVO;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	JPasswordField jPasswordField;
	JButton btnNewButton;
	EmpVO empVO = null;
	EmpDAO empDAO = null;
	Socket socket = new Socket();
	//���� ���¸� ��Ÿ���� ����
	 static boolean loggedIn = false;
	
	String empId;
	String password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		this.empId = "";
		this.password = "";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/img/logo.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 536);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null); 		// â ��� ����
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainView.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(98, 41, 295, 108);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("�����ȣ");
		lblNewLabel_1.setBounds(147, 267, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("��й�ȣ");
		lblNewLabel_2.setBounds(147, 315, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		//���̵� �Է� �ʵ�
		textField = new JTextField();
		textField.setBounds(238, 264, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//��й�ȣ �Է� �ʵ� JPasswordField
		jPasswordField = new JPasswordField();
		jPasswordField.setBounds(238, 312, 116, 21);
		contentPane.add(jPasswordField);
		jPasswordField.setColumns(10);
		
		btnNewButton = new JButton("�α���");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText().trim();
				char[] passwordChars = jPasswordField.getPassword(); // 1.getPassword() �޼��带 ȣ���Ͽ� char �迭�� ��й�ȣ�� ������ ����, 
				 password = new String(passwordChars).trim(); // 2.String���� ��ȯ�Ͽ� ���
						//jPasswordField.getText().trim(); //getText �޼ҵ带 �̿��ϸ� �Էµ� ��й�ȣ�� �Ϲ��ؽ�Ʈ�� ��ȯ�Ǿ� ���ȿ� ����� ���� �־ ���� �ڵ�� ����		
				try {
					if(id.length()==0 || password.length()==0) {
						JOptionPane.showMessageDialog(null, "�����ȣ �Ǵ� PW �Է��� �ȵǾ����ϴ�.", "��� �Ǵ� ��� �Է¾ȵ�", JOptionPane.DEFAULT_OPTION);

						return;
					}
					if(checkLogin(id, password)) {
//					    empDAO.SerchInfo2(id, password);
//					    int aa = empDAO.SerchInfo2(id, password).getJg_no();
//					    System.out.println("jg_no ���� �������� Ȯ�� : " +  aa);
						openMainView();
//						dispose();			// ����â �ݱ�
//						MainView main = new MainView();
//						main.setVisible(true);//main���� ȭ�� �̵�
					}else {
						JOptionPane.showMessageDialog(null, "��� �Ǵ� ��й�ȣ�� �߸� �Է��Ͽ����ϴ�.", "��� �Ǵ� ��� �߸� �Էµ�", JOptionPane.DEFAULT_OPTION);
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		btnNewButton.setBounds(257, 408, 97, 23);
		contentPane.add(btnNewButton);
		
	}
	
	private boolean checkLogin(String id, String password) {
	    empDAO = new EmpDAO();
	    boolean found = empDAO.SerchInfo(id, password);
	    this.empId = id;

	    System.out.println();
		User user = new User();
		System.out.println("checkLogin : " + id);
//		user.AddClient(id,);

	    if(found) {
	    	loggedIn = true; //���� ���¸� �α������� ����
	    	System.out.println("checkLogin �޼ҵ��� empId : " + empId);
	    }
	    return found;
	}
	
	private void openMainView() {
		if(loggedIn) {
			
			System.out.println("���� �α��� ����"); 
			System.out.println("loggedIn : " + loggedIn);
			try {
				String empName = empDAO.SerchInfo2(empId, password).getEmp_name();
				JOptionPane.showMessageDialog(null,empName + "�� �α����� �Ϸ� �Ǿ����ϴ�", "�α��� �Ϸ�", JOptionPane.DEFAULT_OPTION);
				dispose(); // ���� â �ݱ�
				MainView main = new MainView(empId,password);
				main.setVisible(true); //main���� ȭ�� �̵�
			} catch (Exception e) {
				// TODO: handle exception
			}

		}else {
			JOptionPane.showMessageDialog(null, "�α����� �ؾ� �մϴ�.", "�α��� �ʿ�", JOptionPane.DEFAULT_OPTION);
		}
	}

}
