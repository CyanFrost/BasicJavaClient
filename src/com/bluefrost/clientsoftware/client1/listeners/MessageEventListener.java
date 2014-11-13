package com.bluefrost.clientsoftware.client1.listeners;

import bluefrost.serializable.objects.v1.Utils;

import com.bluefrost.clientsoftware.client1.events.EventSystemWrapper.EventSystem.EventHandler;
import com.bluefrost.clientsoftware.client1.events.EventSystemWrapper.EventSystem.Listener;
import com.bluefrost.clientsoftware.client1.main.Main;

public class MessageEventListener implements Listener{

	@EventHandler
	public void messageRecievedEvent(MessageEvent me){
		try{
			Object o = Utils.fromByteArray(me.getBytes());
			System.out.println("Recieved Object! Class: " + o.getClass());
			Main.getDefaultEventSystem().listen(o);
		}catch(Exception e){e.printStackTrace();}
	}
	
	public static class MessageEvent {
		private byte[]  b = null;
		public byte[] getBytes(){return b;}
		public MessageEvent setBytes(byte[] c){ b = c; return this;}
		public MessageEvent(byte[] c){
			b = c;
		}
	}

}
