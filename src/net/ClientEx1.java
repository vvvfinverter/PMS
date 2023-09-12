package net;

import java.net.*;

public class ClientEx1 {
	public static void main(String[] args)
	{
		Socket socket = null;
		
		try
		{
			socket = new Socket("127.0.0.1",5001);
			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
