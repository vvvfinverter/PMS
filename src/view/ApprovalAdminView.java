package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import dao.ApprovalDAO;
import vo.ApprovalVO;

public class ApprovalAdminView extends JFrame implements ActionListener{

//	private static final int ArrayList = 0;
	private JPanel contentPane;
	private JTextField textContents;
	private JLabel lblDocuments;
	private JButton btnApproval;
	private JButton btnReject;
	
	ApprovalDAO dao;
	ApprovalVO vo;
	private ArrayList<ApprovalVO> approvalList;
	String empId;
	String password;
	
//    private DefaultTableModel tableModel;
    private JTable table;
    ApprovalAdminTableModel approvalAdminTableModel;
    private JButton btnMainView;
//    OpenTableModel openTableModel;
    
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ApprovalAdminView frame = new ApprovalAdminView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}


//	public ApprovalAdminView(ArrayList<ApprovalVO> approvalList) {
	public ApprovalAdminView(String empId, String password) {
		this.empId = empId;
		this.password = password;
	    try {
	        dao = new ApprovalDAO();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
//	    approvalList = dao.ApprovalAdminViewSelect(); // �ʱ�ȭ �߰�
//		initialise(empId);
	    newObject(empId, password);
		
	}
		
	void newObject(String empId, String password) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		JScrollPane scrollPane_1 = new JScrollPane();
		
		
		JLabel lblContents = new JLabel("��  ��");
		lblDocuments = new JLabel("���繮��");
		btnApproval = new JButton("����");
		btnReject = new JButton("�ݷ�");
		
		textContents = new JTextField();
		scrollPane_1.setViewportView(textContents);
		textContents.setColumns(10);
		
		ApprovalVO getTeamNo = dao.ApprovalAdminViewTeamNoSelect();
		int teamNo = getTeamNo.getTeam_no();
		
		approvalList = dao.ApprovalAdminViewSelect(teamNo); //�ʱ�ȭ
		approvalAdminTableModel = new ApprovalAdminTableModel(approvalList);
		table = new JTable(approvalAdminTableModel);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1 && selectedRow < approvalList.size()) {
                	
                    ApprovalVO selectedApproval = approvalList.get(selectedRow);
                    String appContents = selectedApproval.getApp_contents();
                    textContents.setText(appContents);
                	
                }
            }
        });
        
        
        scrollPane.setViewportView(table);
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int col = 0;
        		int row = table.getSelectedRow();
//        		int vNum = (int) table.getValueAt(row, col);
        		Object value = table.getValueAt(row, col);
        		if (value instanceof Integer) {
        		    int vNum = (int) value;
        		    // ���������� ����ȯ�� ���� ����ϴ� �ڵ� �ۼ�
        		} else {
        		    // ����ȯ �Ұ����� ��쿡 ���� ���� ó�� �ڵ� �ۼ�
        			System.out.println("����ȯ �Ұ���");
        		}
        		if(row != -1) {
        			//������ �࿡ ���� �۾��� �����մϴ�.
        			ApprovalVO selectedApproval = approvalList.get(row);
        			
        		}
        		
        	}
        });
        
        btnApproval.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if(selectedRow != -1 && selectedRow < approvalList.size()) {
					ApprovalVO selectedApproval = approvalList.get(selectedRow);
//					int appNo = selectedApproval.getApp_no();
					if(selectedApproval != null) {
//						String appTtile = selectedApproval.getApp_title();
//						 System.out.println("appNo �������� Ȯ��  : " + appNo);
//						 System.out.println("appTtile �������� Ȯ��  : " + appTtile);
			            // �����ͺ��̽��� ����� ���� ���¸� ������Ʈ�մϴ�.
			            if(dao.updateApproval(selectedApproval) == 1) {
				            JOptionPane.showMessageDialog(null, "���簡 �Ϸ�Ǿ����ϴ�.", "����Ϸ�", JOptionPane.DEFAULT_OPTION);
			                // ����� �����͸� �ٽ� ��ȸ�Ͽ� approvalList�� ������Ʈ�մϴ�.
			                approvalList = dao.ApprovalAdminViewSelect(teamNo);
			                // ���̺� �𵨿� ����� �����͸� �����ϰ�, ���̺��� �ٽ� �׸��ϴ�.
			                approvalAdminTableModel.setApprovalList(approvalList);
				            approvalAdminTableModel.fireTableDataChanged();
			            }else {
			            	JOptionPane.showMessageDialog(null, "�̹� ���簡 �Ǿ ���� �Ұ��� �մϴ�.", "�����Ұ�", JOptionPane.DEFAULT_OPTION);
			            }

					}

				}else {
					JOptionPane.showMessageDialog(null, "������ �ȵǾ����ϴ�", "���þȵ�", JOptionPane.DEFAULT_OPTION);
				}
				
			}
		});
        
        btnReject.addActionListener(new ActionListener() {
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if(selectedRow != -1 && selectedRow < approvalList.size()) {
					ApprovalVO selectedApproval = approvalList.get(selectedRow);
//					int appNo = selectedApproval.getApp_no();
					if(selectedApproval != null) {
//						 System.out.println("appNo �������� Ȯ��  : " + appNo);
			            // �����ͺ��̽��� ����� ���� ���¸� ������Ʈ�մϴ�.
			            if(dao.updateReject(selectedApproval) == 1) {
			            	JOptionPane.showMessageDialog(null, "�ݷ��� �Ϸ�Ǿ����ϴ�.", "�ݷ��Ϸ�", JOptionPane.DEFAULT_OPTION);
			            	// ����� �����͸� �ٽ� ��ȸ�Ͽ� approvalList�� ������Ʈ�մϴ�.
			            	approvalList = dao.ApprovalAdminViewSelect(teamNo);
			            	// ���̺� �𵨿� ����� �����͸� �����ϰ�, ���̺��� �ٽ� �׸��ϴ�.
			            	approvalAdminTableModel.setApprovalList(approvalList);
			            	approvalAdminTableModel.fireTableDataChanged();
			            }else {
			            	JOptionPane.showMessageDialog(null, "�̹� ���簡 �Ǿ ���� �Ұ��� �մϴ�.", "�����Ұ�", JOptionPane.DEFAULT_OPTION);
			            }
					}

				}else {
					JOptionPane.showMessageDialog(null, "������ �ȵǾ����ϴ�", "���þȵ�", JOptionPane.DEFAULT_OPTION);;
				}
				
			}
		});
		
		btnMainView = new JButton("����ȭ��");
		
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
        
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
								.addComponent(lblContents)
								.addComponent(scrollPane)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(btnApproval)
									.addGap(18)
									.addComponent(btnReject)))
							.addContainerGap(39, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDocuments)
							.addPreferredGap(ComponentPlacement.RELATED, 514, Short.MAX_VALUE)
							.addComponent(btnMainView, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(37))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDocuments)
						.addComponent(btnMainView))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(lblContents)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnApproval)
						.addComponent(btnReject))
					.addContainerGap())
		);
		
		contentPane.setLayout(gl_contentPane);
		
	}
		
    


		
		
	public ApprovalAdminView() {
		

	}
		
		
class ApprovalAdminTableModel extends AbstractTableModel {
		    private ArrayList<ApprovalVO> approvalList;
		    
		    private String[] columnNames = { "��  ��", "�� �� ��", "��ȳ�¥", "����/�ݷ�" };

		    public ApprovalAdminTableModel(ArrayList<ApprovalVO> approvalList) {
		        this.approvalList = approvalList;
		        fireTableDataChanged(); // ���� ����Ǿ����� �˸��ϴ�.
		    }

		    public int getColumnCount() {
		        return columnNames.length;
		    }

		    public int getRowCount() {
		    	if(approvalList == null)
		    		return 0;
		        return approvalList.size();
		    }

		    public Object getValueAt(int row, int col) {
		        ApprovalVO approval = approvalList.get(row);
		        switch (col) {
		            case 0:
		                return approval.getApp_title();
		            case 1:
		                return approval.getApp_writer();
		            case 2:
		                return approval.getApp_date();
		            case 3:
		                return approval.getApp_check();
		            default:
		                return null;
		        }
		    }

		    public String getColumnName(int col) {
		        return columnNames[col];
		    }
		    public String getApp_contents(int row) {
		        ApprovalVO approval = approvalList.get(row);
		        return approval.getApp_contents();
		    }
		    
		    public void setApprovalList(ArrayList<ApprovalVO> approvalList) {
		        this.approvalList = approvalList;
		        fireTableDataChanged(); // ���� ����Ǿ����� �˸��ϴ�.
		    }
		}





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
	}
		
		
		
		
		
		
//		class ApprovalAdminTableModel extends AbstractTableModel {
////		    private ArrayList<ArrayList<String>> data;  //original
//		    ArrayList data = new ArrayList();
//		    private String[] columnNames = { "��  ��", "�� �� ��", "��ȳ�¥", "����/�ݷ�" };
//
////		    public ApprovalAdminTableModel(ArrayList<ArrayList<String>> data) {
////		        this.data = data;
////		    }
//
//		  //=============================================================
//		 // 1. �⺻���� TabelModel  �����
//		 // �Ʒ� �� �Լ��� TabelModel �������̽��� �߻��Լ��ε�
//		 // AbstractTabelModel���� �������� �ʾұ⿡...
//		 // �ݵ�� ����� ���� �ʼ�!!!!
//		    public int getColumnCount() {
//		        return columnNames.length;
//		    }
//
//		    public int getRowCount() {
//		        return data.size();
//		    }
//
//		    public Object getValueAt(int row, int col) {
//		        ArrayList<String> temp = (ArrayList<String>) data.get(row);
//		        return temp.get(col);
//		    }
//		    
//		  //===============================================================
//		    // 2. ������ �÷������� ��ȯ�ϱ�
//		       //
////		    �⺻������ A, B, C, D ��� �̸����� �÷����� �����ȴ�
//		    public String getColumnName(int col) {
//		        return columnNames[col];
//		    }
//    
//		    
//		}
		
		
	}	
	
			

