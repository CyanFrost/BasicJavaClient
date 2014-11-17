package com.bluefrost.clientsoftware.client1.listeners;

import bluefrost.serializable.objects.v1.CM;

import com.bluefrost.clientsoftware.client1.events.EventSystemWrapper.EventSystem.EventHandler;
import com.bluefrost.clientsoftware.client1.events.EventSystemWrapper.EventSystem.Listener;

public class CMListener implements Listener{

	@EventHandler
	public void _(CM event){
		System.out.println(event.getMessage());
	}
}
