package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import dao.ProjectOpenDAO;
import vo.ProjectOpenVO;
import javax.swing.ScrollPaneConstants;

public class ProjectOpenView extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	ArrayList list = null;
	ProjectOpenDAO dao = null;
	ProjectOpenVO vo = null;
	OpenTableModel tmVideo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectOpenView frame = new ProjectOpenView();
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
	public ProjectOpenView() {
		newObject();
		try {
			dao = new ProjectOpenDAO();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	void newObject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null); // â ��� ����
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 566, 37);
		contentPane.add(panel);
		panel.setLayout(null);

		// ���� ���� ��µǴ� �� ����
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 57, 566, 398);
		contentPane.add(scrollPane);

		tmVideo = new OpenTableModel();
		table = new JTable(tmVideo);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "������Ʈ��ȣ","������Ʈ��", "���۳�¥", "���⳯¥", "�����", "���Ῡ��" }));
		scrollPane.setViewportView(table);
		//addActionListener
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int col = 0;
				int row = table.getSelectedRow();
				int vNum = (Integer) table.getValueAt(row, col);
				
				dispose();		// ����â �ݱ�
				ProjectView project = new ProjectView(vNum);
				project.setVisible(true);
			}
		});
		
		
		
		// ���� ���� ��� �L

		// �˻� ��ũ�ѹ� ����
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "������Ʈ", "�����" }));
		comboBox.setBounds(0, 0, 240, 37);
		panel.add(comboBox);
		// �˻� ��ũ�ѹ� ��

		// �˻��� �Է�â ����
		textField = new JTextField();
		textField.setBounds(239, 0, 327, 37);
		panel.add(textField);
		textField.setColumns(10);
		// �˻��� �Է�â ��

		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = comboBox.getSelectedIndex();
				String test = textField.getText();
				
				try {
					list = dao.ProjectSearch(sel, test);
					tmVideo.data = list;
					table.setModel(tmVideo);			
					tmVideo.fireTableDataChanged();		
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage() + " ���� textField.addActionListener");
				}
			}
		});

	}
	
	class OpenTableModel extends AbstractTableModel{
		ArrayList data = new ArrayList();
		String[] columnNames = { "������Ʈ��ȣ", "������Ʈ��", "���۳�¥", "���⳯¥", "�����", "���Ῡ��" };
		
		
		public int getRowCount() {
			return data.size();
		}


		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			ArrayList temp = (ArrayList) data.get(rowIndex);
			return temp.get(columnIndex);
		}
		
		public String getColumnName(int col) {
			return columnNames[col];
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
	}

	
}
