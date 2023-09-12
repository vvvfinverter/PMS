package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AdministratorDAO;
import vo.AdministratorVO;
import vo.AdministratorVOList;
import vo.EmpVO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JList;

public class AdministratorView extends JFrame implements ActionListener {

	JPanel contentPane;
	JTextField empNoTextField;
	JTextField empNameTextField;
	JTextField empJgtextField;
	JComboBox<Integer> comEmpNo;
	JComboBox comEmpJob;
	


	EmpVO empVO = null;
	AdministratorVO administratorVO = null;
	AdministratorVOList administratorVOList = null;
	AdministratorDAO administratorDAO = null;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdministratorView frame = new AdministratorView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AdministratorView(String empId) {

		System.out.println("ADministratorView empID �� �޾ƿ����� Ȯ��: " + empId);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 584);
		newObject();

	
		
//		comEmpNo = new JComboBox();
//		contentPane.add(comEmpNo);

		getContentPane().setLayout(null);
		
		
		
		JLabel empNumLbl = new JLabel("�����ȣ");
		empNumLbl.setBounds(61, 49, 48, 32);
		getContentPane().add(empNumLbl);
		
		empNoTextField = new JTextField();
		empNoTextField.setBounds(123, 43, 176, 45);
		getContentPane().add(empNoTextField);
		empNoTextField.setColumns(10);
		administratorVO = new AdministratorVO();
		administratorDAO = new AdministratorDAO();
		administratorVO = administratorDAO.SelectEmp(empId);
		int empNo = administratorVO.getEmp_no();
//		String empNo = administratorVO.getEmp_no();
		String empNoString = String.valueOf(empNo);
	    
//	    String empNo = administratorDAO.SelectEmpCombo().getEmp_no();
//		administratorDAO.SelectEmp();
//		empNoTextField.setText(administratorDAO.SelectEmp().getEmp_no());
//	    empNoTextField.setText(empNoString);
	    empNoTextField.setText("");
		
		
		
		// JComboBox ����
		comEmpNo = new JComboBox<Integer>();
		comEmpNo.setBounds(311, 46, 62, 38);
		getContentPane().add(comEmpNo);
		// DB���� �����ȣ �����ͼ� �޺� ���ڿ� �߰�
		administratorDAO = new AdministratorDAO();
		administratorVOList = new AdministratorVOList();
		administratorVOList = administratorDAO.SelectEmpCombo(); // ��� ������ �������� �޼��带 ȣ��
		List<Integer> empTxtNo = administratorVOList.getEmp_no(); // �����ȣ�� ������
		// �޺� ���ڿ� �����ȣ �߰�
		for (Integer empNum : empTxtNo) {
			comEmpNo.addItem(empNum);
		}

//		comEmpNo.addItem(administratorVO);
		// DB���� �����ȣ �����ͼ� �޺� ���ڿ� �߰�
//		int empNoList = (int) .SelectEmp().getEmp_no(); // �����ȣ�� �������� �޼��带 �����ؾ� �մϴ�.
//		for (int i = 0;empNoList;i++) {
//			
//		}
		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setBounds(311, 46, 62, 38);
//		contentPane.add(comboBox);
		
		
		JLabel empNameLbl = new JLabel("�̸�");
		empNameLbl.setBounds(61, 108, 41, 23);
		getContentPane().add(empNameLbl);
		
		empNameTextField = new JTextField();
		empNameTextField.setBounds(123, 104, 176, 32);
		getContentPane().add(empNameTextField);
		empNameTextField.setColumns(10);
		empNameTextField.setEditable(false);  // ���� �Ұ��� ����
//		empNameTextField.setText(administratorDAO.SelectEmp(empId).getEmp_name());
		empNameTextField.setText("");
		
		JLabel empJobLbl = new JLabel("����");
		empJobLbl.setBounds(61, 156, 33, 32);
		getContentPane().add(empJobLbl);
		
		empJgtextField = new JTextField();
		empJgtextField.setBounds(123, 162, 176, 26);
		getContentPane().add(empJgtextField);
		empJgtextField.setColumns(10);	
//		empJgtextField.setText(administratorDAO.SelectEmp(empId).getEmp_job());
		empJgtextField.setText("");
		
		
		
		
		
//		comEmpJob = new JComboBox<Integer>();

		administratorDAO = new AdministratorDAO();
		administratorVOList = new AdministratorVOList();
		administratorVOList = administratorDAO.SelectEmpCombo();
		
//		List<Integer> empTxtjg = administratorVOList.getJg_no();
//		
//		for (Integer empjgNo : empTxtjg) {
//			comEmpJob.addItem(empjgNo);
//		}
		String jobJg[] = {"1","2","3","4","5","6" };
		int JobJg1[] = {1,2,3,4,5,6};
		comEmpJob = new JComboBox<String>(jobJg);
		comEmpJob.setSelectedItem(administratorVO.getJg_no());
		

		comEmpJob.setBounds(311, 165, 62, 23);
//		contentPane.add(comEmpJob);
		getContentPane().add(comEmpJob);


		
		comEmpJob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
//				int jobjg1 = (int) comEmpJob.getSelectedItem();
				
				
				String jobjg = (String) comEmpJob.getSelectedItem();
				System.out.println("jobjg  : " + jobjg);
				
				if(jobjg != null && jobjg.equals("1")) {
					empJgtextField.setText("����");
				}else if (jobjg != null && jobjg.equals("2")) {
					empJgtextField.setText("��");
				}else if (jobjg != null && jobjg.equals("3")) {
					empJgtextField.setText("����");
				}else if (jobjg != null && jobjg.equals("4")) {
					empJgtextField.setText("����");
				}else if (jobjg != null && jobjg.equals("5")) {
					empJgtextField.setText("����");
				}else{
					empJgtextField.setText("���");
				}
				
			}
		});
		
		
		//������� �޺����� ���õ� ��� 
		comEmpNo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				Integer selectedEmpNo = (Integer) comEmpNo.getSelectedItem();
//				empNoTextField.setText(selectedEmpNo.toString());
				Integer selectedEmpNo = (Integer) comEmpNo.getSelectedItem();
				String empNo = Integer.toString(selectedEmpNo);
				empNoTextField.setText(empNo);
				
//				String EmpTextName = empNameTextField.getSelectedText();
//				������ empNameTextField.getSelectedText() �޼��带 ����Ͽ� 
//				EmpTextName ���� ���������� �ϰ� �ֱ� ������ �߻��մϴ�. 
//				getSelectedText() �޼���� �ؽ�Ʈ �ʵ忡�� ���õ� �ؽ�Ʈ�� ��ȯ�ϴ� ���� �ƴ϶�
//				, ���� ���õ� �ؽ�Ʈ�� �����ɴϴ�. �׷��� empNameTextField���� �ؽ�Ʈ�� ���õ��� ���� �����̱� ������ null�� ��ȯ�Ǵ� ���Դϴ�.
//				��ſ� empNameTextField.getText() �޼��带 ����Ͽ� 
//				empNameTextField�� �ؽ�Ʈ ���� ������ �� �ֽ��ϴ�. �Ʒ��� ���� ������ ������:
				AdministratorDAO administratorDAO = null;
				AdministratorVO administratorVO = new AdministratorVO();
				
				administratorDAO = new AdministratorDAO();
				administratorVO = new AdministratorVO();
				administratorVO = administratorDAO.SelectEmp(empNo);
				String EmpTextName = administratorVO.getEmp_name();
//						empNameTextField.getText();
				System.out.println("EmpTextName : " + EmpTextName);
				empNameTextField.setText(EmpTextName);
				
				
				
				String empJobText = administratorVO.getEmp_job();
				empJgtextField.setText(empJobText);
				
			}
		});
		
		//��ư
		JButton empJgUpdateBtn = new JButton("���Ѻ���");
		empJgUpdateBtn.setBounds(303, 214, 97, 23);
		getContentPane().add(empJgUpdateBtn);
		empJgUpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("��ưŬ��");
//				administratorVO.setD_no();

				
				
//		        String jobjgComtxt = (String) comEmpJob.getSelectedItem();
		        
				String jobjg = (String) comEmpJob.getSelectedItem();
				
				if(jobjg != null && jobjg.equals("1")) {
					empJgtextField.setText("����");
				}else if (jobjg != null && jobjg.equals("2")) {
					empJgtextField.setText("��");
				}else if (jobjg != null && jobjg.equals("3")) {
					empJgtextField.setText("����");
				}else if (jobjg != null && jobjg.equals("4")) {
					empJgtextField.setText("����");
				}else if (jobjg != null && jobjg.equals("5")) {
					empJgtextField.setText("����");
				}else{
					empJgtextField.setText("���");
				}
		        
		        int jgNo = Integer.parseInt(jobjg);
		        System.out.println("jobjg : " + jgNo);
		        
		        
				
			
				String empJob =	empJgtextField.getText();//����txt
				System.out.println("empJob :  " + empJob);
//				
				String empNoText = empNoTextField.getText();//�����ȣtxt
				int empNo =	Integer.parseInt(empNoText);
				System.out.println("empNo :  " + empNo);

				//�����ȣ, �̸�, ���� �Ķ���ͷ� �ޱ�
				try {
//					JTextField empNoTextField;
//					JTextField empNameTextField;
//					JTextField empJgtextField;
//					JComboBox<Integer> comEmpNo;
//					JComboBox comEmpJob;
					//set jg_no = ?, emp_job = ? where emp_no = ?"
					
				

//					int empNo = administratorVO.getEmp_no();
//					String empNo = administratorVO.getEmp_no();
//					String empNoString = String.valueOf(empNo);
//				    empNoTextField.setText(empNoString);
	
					int rowNum = administratorDAO.EmpGrantModify(jgNo,empJob, empNo);
					
//					int rowNum = administratorDAO.EmpGrantModify(administratorVO);
					if(rowNum > 0) {
						System.out.println("������Ʈ");
						System.out.println("rownum : " + rowNum);
					
						
						
						
						
						
					}else {
						System.out.println("���Ѻ��� ������Ʈ ����");
					}
				} catch (Exception e1) {
					System.err.println("���Ѻ��� ������Ʈ �ȵ�");
					e1.printStackTrace();
				}
				
			}
		});
		

		
	}
	
	   //##############################################
	   // ����ʵ� ��ü ���� �׷��� ���� ����� �����Ǿ �߰� ������ �ʿ�
	   void   newObject(){
		   
		   
			contentPane = new JPanel();
			empNoTextField = new JTextField();
			empNameTextField = new JTextField();
			empJgtextField = new JTextField();
			comEmpNo = new JComboBox();
			comEmpJob = new JComboBox();
			
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			
	   }

	public AdministratorView() {
	
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
