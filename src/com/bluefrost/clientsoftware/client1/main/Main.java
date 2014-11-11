package com.bluefrost.clientsoftware.client1.main;

import com.bluefrost.clientsoftware.client1.events.EventSystemWrapper;
import com.bluefrost.clientsoftware.client1.listeners.MessageEventListener;

public class Main {

	/*
	 * Client1 made by BlueFrost 
	 */

	private static EventSystemWrapper esw = new EventSystemWrapper();
	public static EventSystemWrapper getDefaultEventSystem(){return esw;}
	
	public static void main(String args[]){
		try{
			
		}catch(Exception e){}
	}
	
	
	public static void registerListeners(){
		esw.addListener(new MessageEventListener());
	}
}
