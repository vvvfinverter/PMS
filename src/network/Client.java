package network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

import dao.EmpDAO;


public class Client {
	String id = null;
	String password = null;
//	public static void main(String[] args) {System.out.println("Client �޼ҵ� ��");
	public void clientMethod() {System.out.println("client network method����?");
		Socket socket = null;
		DataInputStream in = null; //�� ������ ����ڰ� �Է��ϴ� ä�� �κп� �ش�˴ϴ�.
		BufferedReader in2 = null; //�� ������ ������� �г��ӿ� �ش�˴ϴ�. 
		
		DataOutputStream out = null; //�� ������ ����ڰ� �Է��� �����͸� ����� �� ����մϴ�.
		
		try {
			InetAddress ia = null; //Local Host IP Address �������� ���� ����
			ia = InetAddress.getLocalHost(); //���� PC�� IP Address ��������
			socket = new Socket(ia, 9002); //Client�� IP�� port ��ȣ �Է�
//			socket = new Socket("192.168.0.90", 9000);
			/*
			 * DataInputStream�� �Է� ��Ʈ���� �޴� �Ű������̸�,
			 * socket.getInputStream()�Լ��� ���� ���Ͽ��� ���޵Ǵ� ������ ��Ʈ���� �о�ɴϴ�.
			 * BufferedReader�� Scanner�� ����� �����Դϴ�.
			 * Scanner���� �����ٴ� ������ ������ String������ ���ۿ� �����ϱ� ������
			 * ���� �����͸� �����ؼ� ����ؾ��ϴ� ��찡 �����ϴ�.
			 */
			in = new DataInputStream(socket.getInputStream());
			in2 = new BufferedReader(new InputStreamReader(System.in));
			out = new DataOutputStream(socket.getOutputStream());
			
//			System.out.println("�г����� �Է����ּ��� : ");
//			String data = in2.readLine(); // ä�ÿ� ����� �г����� �޾ƿɴϴ�.

			EmpDAO empDAO = new EmpDAO();
			int empId = empDAO.SerchInfo2("1", "1234").getEmp_no();
			System.out.println("client empId : " + empId);
			out.write(empId);
//			out.writeUTF(data); //�г����� UTF-8�� ���� �� ��½�Ʈ���� �ֽ��ϴ�.
			Thread th = new Thread(new Send(out)); //���ο� �����忡 out�� ����ֵ��� �մϴ�.
			th.start();  //������ ����
		} catch (IOException e) {
			System.out.println("Client excception");
			e.printStackTrace();
		}
	} //client�޼ҵ�
//	}//main

}
