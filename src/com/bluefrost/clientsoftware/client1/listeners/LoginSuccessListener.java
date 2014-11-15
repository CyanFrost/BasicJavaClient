package com.bluefrost.clientsoftware.client1.listeners;

import bluefrost.serializable.objects.v1.KeyObject;
import bluefrost.serializable.objects.v1.LoggedInSuccessObject;

import com.bluefrost.clientsoftware.client1.connection.Connection;
import com.bluefrost.clientsoftware.client1.events.EventSystemWrapper.EventSystem.EventHandler;
import com.bluefrost.clientsoftware.client1.events.EventSystemWrapper.EventSystem.Listener;
import com.bluefrost.encryption.Crypto;

public class LoginSuccessListener implements Listener{

	@EventHandler
	public void Event(LoggedInSuccessObject event){
		
	}
	
}
