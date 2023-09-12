package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import java.awt.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

public class MainView2 extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView2 frame = new MainView2();
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
	public MainView2() throws Exception{
		getContentPane().setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView2.class.getResource("/img/logo.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 536);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainView2.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(98, 41, 295, 108);
		contentPane.add(lblNewLabel);
		
		setLocationRelativeTo(null); 		// 창 가운데 정렬
		setResizable(false);
		
		JButton btnNewButton = new JButton("프로젝트");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 이벤트");
//				new ProjectView(vNum);

			}
		});
		btnNewButton.setIcon(new ImageIcon(MainView2.class.getResource("/img/p1.jpg")));
		btnNewButton.setBounds(66, 228, 147, 37);
		contentPane.add(btnNewButton);
		
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));			// 커서 모양 변경 								
		btnNewButton.setBorderPainted(false); 							// 선택 되지 않은 상태와, 마우스 올려 놨을 때 테두리	
		btnNewButton.setContentAreaFilled(false); 						// 배경										
		btnNewButton.setFocusPainted(false);								// 선택 됐을 때 선							
		btnNewButton.setOpaque(false);
		
		JButton btnNewButton2 = new JButton("New button");
		btnNewButton2.setIcon(new ImageIcon(MainView2.class.getResource("/img/p2.jpg")));
		btnNewButton2.setOpaque(false);
		btnNewButton2.setFocusPainted(false);
		btnNewButton2.setContentAreaFilled(false);
		btnNewButton2.setBorderPainted(false);
		btnNewButton2.setBounds(268, 228, 147, 37);
		contentPane.add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("New button");
		btnNewButton3.setIcon(new ImageIcon(MainView2.class.getResource("/img/p3.jpg")));
		btnNewButton3.setOpaque(false);
		btnNewButton3.setFocusPainted(false);
		btnNewButton3.setContentAreaFilled(false);
		btnNewButton3.setBorderPainted(false);
		btnNewButton3.setBounds(66, 291, 147, 37);
		contentPane.add(btnNewButton3);
		
		JButton btnNewButton4 = new JButton("New button");
		btnNewButton4.setIcon(new ImageIcon(MainView2.class.getResource("/img/p4.jpg")));
		btnNewButton4.setOpaque(false);
		btnNewButton4.setFocusPainted(false);
		btnNewButton4.setContentAreaFilled(false);
		btnNewButton4.setBorderPainted(false);
		btnNewButton4.setBounds(268, 291, 147, 37);
		contentPane.add(btnNewButton4);
		
		JButton btnNewButton5 = new JButton("New button");
		btnNewButton5.setIcon(new ImageIcon(MainView2.class.getResource("/img/p5.jpg")));
		btnNewButton5.setOpaque(false);
		btnNewButton5.setFocusPainted(false);
		btnNewButton5.setContentAreaFilled(false);
		btnNewButton5.setBorderPainted(false);
		btnNewButton5.setBounds(66, 353, 147, 37);
		contentPane.add(btnNewButton5);
		
		JButton btnNewButton6 = new JButton("New button");
		btnNewButton6.setIcon(new ImageIcon(MainView2.class.getResource("/img/p6.jpg")));
		btnNewButton6.setOpaque(false);
		btnNewButton6.setFocusPainted(false);
		btnNewButton6.setContentAreaFilled(false);
		btnNewButton6.setBorderPainted(false);
		btnNewButton6.setBounds(268, 353, 147, 37);
		contentPane.add(btnNewButton6);
		
		JButton btnNewButton7 = new JButton("New button");
		btnNewButton7.setIcon(new ImageIcon(MainView2.class.getResource("/img/p7.jpg")));
		btnNewButton7.setOpaque(false);
		btnNewButton7.setFocusPainted(false);
		btnNewButton7.setContentAreaFilled(false);
		btnNewButton7.setBorderPainted(false);
		btnNewButton7.setBounds(66, 416, 147, 37);
		contentPane.add(btnNewButton7);
		
	}
}
