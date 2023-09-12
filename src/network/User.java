package network;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/*
Client���� User ������ ���� �� �ֵ��� ���ִ� Ŭ�����Դϴ�.

Server���� Receiver�� ����Ǹ�, Receiver�� ���� User�� ����� �ǰ�, User Ŭ������ ���� ��Ŀ� ���� ���� ���� ���� ���̰� �Ǵ� �޼��� ������ �����ϰ� �˴ϴ�.
*/
public class User {
	HashMap<String, DataOutputStream> clientMap = new HashMap<String, DataOutputStream>();
	//clientmap�� String ���� key�� DataOutputStream ���� Value���� ����
	
	public synchronized void AddClient(String name, Socket socket) {
		try {
			System.out.println("User class�� AddClient �޼ҵ� �� : " + name + " socket : " + socket);
//			User class�� AddClient �޼ҵ� �� : 17 socket : Socket[addr=/192.168.0.86,port=51850,localport=9003]
//			sendMsg(name + " ���� �����ϼ̽��ϴ�.", "Server"); // server�� ���� �޼��� ����
			clientMap.put(name, new DataOutputStream(socket.getOutputStream()));
			// HashMap�� put(key, value)�Լ��� key�� value�� �޴´� 
			
			System.out.println("���� �������� ȸ��� �ο� : " + clientMap.size());
		} catch (Exception e) {
			System.out.println("user exception");
			e.printStackTrace();
		}
	}
	
	public synchronized void RemoveClient(String name) {
		try {
			clientMap.remove(name); //name value�� ������ client ����
			
		} catch (Exception e) {
			System.out.println("RemoveClient failed");
			e.printStackTrace();
		}
	}
	
//	public synchronized void sendMsg(String msg, String name) throws Exception{
//		Iterator iterator = clientMap.keySet().iterator(); //client�� key������ �о�ɴϴ�.
//		while (iterator.hasNext()) { //key ���� next�� �����ϸ� ��� ����
//			String clientname = (String) iterator.next(); //ä���� �Է��� ���� �̸��� �޾ƿͼ�
//			clientMap.get(clientname).writeUTF(name + " : " + msg); //��Ĵ�� ä���� ����մϴ�.
//		}
//	}
}
