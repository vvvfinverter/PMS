package network;

import java.net.ServerSocket;
import java.net.Socket;

import dao.EmpDAO;

public class Server {
//	public static void main(String[] args) {System.out.println("Server ��");
	public void networkMethod() {
		System.out.println("���� ��Ʈ��ũ ���� �޼ҵ� ����");
		
		Socket socket = null; //Client�� ����ϱ� ���� Socket ����
		User user = new User();  // ä�ù濡 ������ �ִ� Client ���� ��ü
		ServerSocket serverSocket = null; //Client ������ �ޱ� ���� ServerSocket
		
		int count = 0; // ������ �Ҵ��� ���� ����
		Thread thread[] = new Thread[100]; //100���� ������ �Ҵ�, �� 100�� ���Ӱ���
		
		try {
			serverSocket = new ServerSocket(9003); //���� ��Ʈ�� ������ ����
			
			while (true) {
				socket = serverSocket.accept(); //����� ����Ǳ� ������ ����
				

				/*
				 * receiver Class���� implements Runnable�� ����߱� ������
				 * Thread ��ü �ȿ� �����带 ����Ϸ��� ��ü�� �־��༭ ��üȭ�� �� �� �ֽ��ϴ�.
				 */
				thread[count] = new Thread(new Receiver(user, socket)); //Receiver class�� Thread���� ����
				
				thread[count].start(); //������ ���� 
				count++;
			}
		} catch (Exception e) {
			System.out.println("server exception");
			e.printStackTrace();
		}
	} //method
//	} //main

}
