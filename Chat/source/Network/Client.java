package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread{
	
	  public static final char CHAT = 'a';
	  public static final char IMAGE = 'b';
	  public static final char USER_DATA = 'c';
	  public static final char ROOM_CREATE = 'd';
	  public static final char ROOM_CONNECT= 'e';
	  public static final char ROOM_OUT = 'f';
	  public static final char SERVER_WARNING = 'g';
	
	Socket ClientSocket;
	BufferedReader in;
	PrintWriter out;
	String postAddress;
	int port;
	
	
	int PortNumber;
	public Client(String Address,int port_){
		ClientSocket = null;
		in = null;
		out = null;
		postAddress = Address;
		port = port_;
	}
	
	public void ConnectServer() {
		try {
			ClientSocket = new Socket("127.0.0.1",port);
			out = new PrintWriter(ClientSocket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String ReadMessage() {
		try {
			return in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void SendMessage(String msg) {
		out.println(msg);
		out.flush();
	}
	public void StopConnect() {
		out.close();
		try {
			ClientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 @Override
	  public void run() {
		 while(true) {
			 try {Thread.sleep(10);} catch (InterruptedException e) 
			 {e.printStackTrace();}
			 ReadMessage();
		 }
	  }
}
