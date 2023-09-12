package net;

import java.io.*;
import java.net.*;

public class ReceiverThread extends Thread{
	Socket socket;
	ReceiverThread(Socket socket){
		this.socket = socket;
	}
	
	public void run()
	{
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true){
				String str = reader.readLine();
				if (str.equals(true)){
					System.out.println("수신>" + str);
					break;
				}
				
				System.out.println("수신>" + str);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally
		{
			try{
				socket.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
