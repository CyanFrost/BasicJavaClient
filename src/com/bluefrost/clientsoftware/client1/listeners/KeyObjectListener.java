package com.bluefrost.clientsoftware.client1.listeners;

import bluefrost.serializable.objects.v1.KeyObject;
import bluefrost.serializable.objects.v1.LoginObject;

import com.bluefrost.clientsoftware.client1.connection.Connection;
import com.bluefrost.clientsoftware.client1.events.EventSystemWrapper.EventSystem.EventHandler;
import com.bluefrost.clientsoftware.client1.events.EventSystemWrapper.EventSystem.Listener;
import com.bluefrost.encryption.Crypto;


public class KeyObjectListener implements Listener {
	
	
	@EventHandler
	public void onKeyEvent(KeyObject event){
		Connection.setKey(event.k);
		Connection.sendObject(new LoginObject("root","toor", Crypto.getPubKey()));
		System.out.println("SAVED KEY!");
	}
	
	
	
}
