package network;

import java.io.DataInputStream;
import java.net.Socket;

/*
 * extends Thread, implements Runnable�� ������ ������ ���� ����մϴ�.
 * extends Thread�� Thread�� ��ӹް� ��äȭ�� �ڿ� ��ü��.start()�� ���� ����ϸ�,
 * implements Runnable�� Thread ��ü �ȿ� �����带 ����Ϸ��� ��ü�� �־��༭ ��üȭ�� �� ����մϴ�.
 * extends Thread�� implements Runnable�� ����մϴ�.
 * ������ implements Runnable�� ����ϸ� ���� ����� �����մϴ�.
 */
public class Receiver implements Runnable{
	Socket Socket;
	DataInputStream in;
	String name;
	User user = new User();
	
	/*
	 * ������������ ���� �ʱ�ȭ�մϴ�.
	 * ���� user Ŭ������ AddClient�� ȣ���Ͽ� ����ڸ� ����մϴ�.
	 */
	public Receiver(User user, Socket socket) throws Exception {
		System.out.println("Receiver ������ �� user : " + user + " Socket : " + socket);
//		Receiver ������ �� user : network.User@1d082e88 Socket : Socket[addr=/192.168.0.79,port=56913,localport=9003]
//		User class�� AddClient �޼ҵ� �� : 11 socket : Socket[addr=/192.168.0.79,port=56913,localport=9003]
//		���� �������� ȸ��� �ο� : 4
//		Receiver class�� run �޼ҵ� ��
		this.user = user;
		this.Socket = socket;
		in = new DataInputStream(socket.getInputStream());
		this.name = in.readUTF(); //UTF-8 �� ���ڵ� �� �о��
		user.AddClient(name, socket); //����� ���
				
	}
	
	@Override
	public void run() {System.out.println("Receiver class�� run �޼ҵ� ��");
		try {
			while (true) {
				String msg = in.readUTF(); //in�� ���� �޽����� UTF-8�� ���ڵ� �� �о��
				System.out.println("Receiver�� msg : " + msg);
//				user.sendMsg(msg, name); //name �̸��� ���� user�� msg��� �޽����� ����
				System.out.println("Receiver�� name : "+ name);
			}
		} catch (Exception e) {
			System.out.println("���� �߻��ؼ� name ������ client���� ���� ��");
			user.RemoveClient(this.name); //���� �߻��� name ������ client���� ����
			e.printStackTrace();
		}
	}

}
