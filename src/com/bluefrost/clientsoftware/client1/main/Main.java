package com.bluefrost.clientsoftware.client1.main;

import bluefrost.serializable.objects.v1.LoginObject;

import com.bluefrost.clientsoftware.client1.connection.Connection;
import com.bluefrost.clientsoftware.client1.events.EventSystemWrapper;
import com.bluefrost.clientsoftware.client1.listeners.CMListener;
import com.bluefrost.clientsoftware.client1.listeners.KeyObjectListener;
import com.bluefrost.clientsoftware.client1.listeners.LoginSuccessListener;
import com.bluefrost.clientsoftware.client1.listeners.MessageEventListener;
import com.bluefrost.encryption.Crypto;

public class Main {

	/*
	 * Client1 made by BlueFrost 
	 */

	private static EventSystemWrapper esw = new EventSystemWrapper();
	public static EventSystemWrapper getDefaultEventSystem(){return esw;}
	
	public static void main(String args[]){
		try{
			registerListeners();
			Crypto.genKeys();
			Connection.connect("LocalHost", 9090);
			//Connection.sendObject(new LoginObject("root","toor").toByteArray());
		}catch(Exception e){}
	}
	
	
	public static void registerListeners(){
		esw.addListener(new MessageEventListener());
		esw.addListener(new KeyObjectListener());
		esw.addListener(new LoginSuccessListener());
		esw.addListener(new CMListener());
	}
}
