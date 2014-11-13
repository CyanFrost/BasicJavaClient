package com.bluefrost.clientsoftware.client1.connection;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.security.Key;

import bluefrost.serializable.objects.v1.EncryptableObject;

import com.bluefrost.clientsoftware.client1.threads.ReaderThread;

public class Connection {
	
	private static Key ConnectionKey = null; //will be null until an AES/RSA key is sent through in a KeyObject. Check if it is null before encrypting data.
	public static Key getKey(){return ConnectionKey;}
	public static void setKey(Key k){ConnectionKey = k;}
	
	private static boolean logedin;
	public static boolean isLoggedIn(){return logedin;}
	public static void setLogin(boolean b){logedin = b;}
	
	
	private static ByteBuffer b = ByteBuffer.allocate(8192);

	private static Socket sock;
	public static Socket getSocket(){return sock;}
	
	private static ReaderThread rt;
	public static ReaderThread getReaderThread(){return rt;}
	
	public static void connect(String ip, int port) throws Exception{
		sock = new Socket(ip,port);
		rt = new ReaderThread();
		rt.start();
	}
	
	public static void forceClose(){
		try{
			sock.close();
		}catch(Exception e){/*Expected Error*/}
	}
	
	public static InputStream getInputStream() throws IOException{return sock.getInputStream();}
	
	@Deprecated public static void sendObject(byte[] bytes){
		try{
			b.clear();
			b.put(bytes);
			sock.getOutputStream().write(b.array());
			sock.getOutputStream().flush();
		}catch(Exception e){}
	}
	
	public static void sendObject(EncryptableObject o){
		try{
			
			if(o instanceof EncryptableObject){
				b.clear();
				if(ConnectionKey != null){b.put(((EncryptableObject)o).encrypt(ConnectionKey).toByteArray());}
				else{b.put(((EncryptableObject)o).toByteArray());}
				sock.getOutputStream().write(b.array());
				sock.getOutputStream().flush();
			}
		}catch(Exception e){}
	}
}
