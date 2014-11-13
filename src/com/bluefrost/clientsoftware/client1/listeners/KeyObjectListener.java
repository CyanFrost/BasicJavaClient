package com.bluefrost.clientsoftware.client1.listeners;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

import bluefrost.serializable.objects.v1.KeyObject;
import bluefrost.serializable.objects.v1.LoginObject;

import com.bluefrost.clientsoftware.client1.connection.Connection;
import com.bluefrost.clientsoftware.client1.events.EventSystemWrapper.EventSystem.EventHandler;
import com.bluefrost.clientsoftware.client1.events.EventSystemWrapper.EventSystem.Listener;


public class KeyObjectListener implements Listener {
	
	
	@EventHandler
	public void onKeyEvent(KeyObject event){
		Connection.setKey(event.k);
		if(!Connection.isLoggedIn()){Connection.sendObject(new LoginObject("root","toor").encrypt(event.k).toByteArray());Connection.setLogin(true);}
		System.out.println("SAVED KEY! Type: " + preparedString(event.k));
	}
	
	private String preparedString(Key k){
		if(k instanceof PrivateKey){
			return "PrivateKey";
		}else if(k instanceof PublicKey){
			return "PublicKey";
		}else{
			return "AESKey";
		}
	}
	
}
