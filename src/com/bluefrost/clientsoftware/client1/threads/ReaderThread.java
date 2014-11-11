package com.bluefrost.clientsoftware.client1.threads;

import com.bluefrost.clientsoftware.client1.connection.Connection;
import com.bluefrost.clientsoftware.client1.listeners.MessageEventListener.MessageEvent;
import com.bluefrost.clientsoftware.client1.main.Main;

public class ReaderThread extends Thread{

	public void run(){
		byte[] b = new byte[8192];
		MessageEvent me = new MessageEvent(b);
		while(true){
			try{
				Connection.getInputStream().read(b);
				Main.getDefaultEventSystem().listen(me.setBytes(b));
			}catch(Exception e){e.printStackTrace(); break;}
		}
		System.out.println("Reader Thread Ended!");
	}
}
