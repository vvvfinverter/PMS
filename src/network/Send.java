package network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

/*
 * extends Thread, implements Runnable�� ������ ������ ���� ����մϴ�.
 * extends Thread�� Thread�� ��ӹް� ��äȭ�� �ڿ� ��ü��.start()�� ���� ����ϸ�,
 * implements Runnable�� Thread ��ü �ȿ� �����带 ����Ϸ��� ��ü�� �־��༭ ��üȭ�� �� ����մϴ�.
 * extends Thread�� implements Runnable�� ����մϴ�.
 * ������ implements Runnable�� ����ϸ� ���� ����� �����մϴ�.
 * 
 */

public class Send implements Runnable{
	
	DataOutputStream out;
	
	//Send Class������ in2�� ä�� ������ �޾ƿ��� ������ �մϴ�.
	BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
	
	public Send(DataOutputStream out) {System.out.println("send ������ ���� " + out);
		this.out = out;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				String msg = in2.readLine(); //�޽����� �޾ƿ���
				out.writeUTF(msg); //msg ���
			} catch (Exception e) {
				System.out.println("send exception");
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
