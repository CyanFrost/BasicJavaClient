package com.bluefrost.clientsoftware.client1.listeners;

import bluefrost.serializable.objects.v1.EncryptedObject;
import bluefrost.serializable.objects.v1.Utils;

import com.bluefrost.clientsoftware.client1.connection.Connection;
import com.bluefrost.clientsoftware.client1.events.EventSystemWrapper.EventSystem.EventHandler;
import com.bluefrost.clientsoftware.client1.events.EventSystemWrapper.EventSystem.Listener;
import com.bluefrost.clientsoftware.client1.main.Main;

public class MessageEventListener implements Listener{

	@EventHandler
	public void messageRecievedEvent(MessageEvent me){
		try{
			System.out.println(Utils.fromByteArray(me.b).getClass());
			Main.getDefaultEventSystem().listen(Utils.fromByteArray(me.b));
		}catch(Exception e){e.printStackTrace();}
	}
	
	public static class MessageEvent {
		private boolean canceled = false;
		public void setCanceled(boolean b){canceled = b;}
		public boolean isCanceled(){return canceled;}
		private byte[]  b = null;
		public byte[] getBytes(){return b;}
		public MessageEvent setBytes(byte[] c){ b = c; return this;}
		public MessageEvent(byte[] c){
			b = c;
		}
	}

}
