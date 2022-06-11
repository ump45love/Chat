package Network;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread{
	public static final byte GET_MESSAGE = 0;
	public static final byte SIGN_UP_CHECK = 1;
	public static final byte CREATE_ROOM_CHECK = 2;
	public static final byte GET_ROOM_LIST = 3;
	public static final char GET_IMAGE = 0;
	public static final char GET_USER_LIST = 1;
	public static final char CHAT = 'a';
	public static final char IMAGE = 'b';
	public static final char USER_DATA = 'c';
	public static final char ROOM_CREATE = 'd';
	public static final char ROOM_CONNECT= 'e';
	public static final char ROOM_OUT = 'f';
	public static final char SERVER_WARNING = 'g';

	Socket ClientSocket;
	Socket ClientImageSocket;
	DataInputStream in;
	DataOutputStream out;
	DataInputStream imageIn;
	DataOutputStream imageOut;
	String postAddress;
	int port;
	boolean connectCheck;
	
	
	int PortNumber;
	public Client(String Address,int port_){
		ClientSocket = null;
		in = null;
		out = null;
		postAddress = Address;
		port = port_;
		connectCheck= false;
	}
	public void SendMessage() {
		
	}
	public void ConnectServer() {
		try {
			ClientSocket = new Socket(postAddress,port);
			ClientImageSocket = new Socket(postAddress,port+1);
			imageOut= new DataOutputStream(ClientImageSocket.getOutputStream());
			imageIn = new DataInputStream(ClientImageSocket.getInputStream());
			out = new DataOutputStream(ClientSocket.getOutputStream());
			in = new DataInputStream(ClientSocket.getInputStream());
			connectCheck =true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void	SendMessage(String msg) {
		try {
			out.writeByte(0);
			out.writeChars(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SignUp(String id, String ps) {
		try {
			out.writeByte(1);
			out.writeChars(id);
			out.writeChars(ps);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void CreateRoom(String name,String ps) {
		try {
			out.writeByte(2);
			out.writeChars(name);
			out.writeChars(ps);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void RequestRommList() {
		try {
			out.writeByte(3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SendImage(byte data[]) {
		long dataLength = data.length;
		try {
			imageOut.writeByte(0);
			imageOut.writeLong(dataLength);
			imageOut.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SetProfileImage(byte data[]) {
		long dataLength = data.length;
		try {
			imageOut.writeByte(1);
			imageOut.writeLong(dataLength);
			imageOut.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void StopConnect() {
		try {
			ClientImageSocket.close();
			ClientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	synchronized public void recievImage() {
		int type = 0;
		try {
			type = imageIn.readByte();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(type) {
			case GET_IMAGE:
				break;
			case GET_USER_LIST:
				break;
		}
		
	}
	
	synchronized public void recievString() {
		try {
			int type = in.readByte();
			switch(type) {
				case GET_MESSAGE:
				break;
				case SIGN_UP_CHECK:
				break;
				case CREATE_ROOM_CHECK:
				break;
				case GET_ROOM_LIST:

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 @Override
	  public void run() {
		 while(true) {
			 try {Thread.sleep(10);} catch (InterruptedException e) 
			 {e.printStackTrace();}
			 if(connectCheck) {
				 recievString();
				 recievImage();
			 }
			 	
			 else {
				 ConnectServer();
				 try {Thread.sleep(1000);} 
				 catch (InterruptedException e) {e.printStackTrace();}
			 }
		 }
	  }
}
