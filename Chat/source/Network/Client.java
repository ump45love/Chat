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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import GUI.BodyBone;
import Object.RoomList;

public class Client extends Thread{
	public static final byte GET_MESSAGE = 0;
	public static final byte SIGN_UP_CHECK = 1;
	public static final byte CREATE_ROOM_CHECK = 2;
	public static final byte GET_ROOM_LIST = 3;
	public static final byte LOGIN_CHECK = 4;
	public static final char GET_IMAGE = 0;
	public static final char GET_USER_LIST = 1;
	public static final char CHAT = 'a';
	public static final char IMAGE = 'b';
	public static final char USER_DATA = 'c';
	public static final char ROOM_CREATE = 'd';
	public static final char ROOM_CONNECT= 'e';
	public static final char ROOM_OUT = 'f';
	public static final char SERVER_WARNING = 'g';

	BodyBone bone;
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
	public Client(String Address,int port_,BodyBone bone){
		ClientSocket = null;
		ClientImageSocket = null;
		in = null;
		out = null;
		imageIn = null;
		imageOut = null;
		postAddress = Address;
		port = port_;
		connectCheck= false;
		this.bone = bone;
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
			out.flush();
			out.writeUTF(id);
			out.flush();
			out.writeUTF(ps);
			out.flush();
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
	public void Login(String id, String ps) {
		try {
			out.writeByte(4);
			out.flush();
			out.writeUTF(id);
			out.flush();
			out.writeUTF(ps);
			out.flush();
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
	
	synchronized public void receiveImage() {
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
	
	synchronized void receiveMessage() {
		try {
			String s = in.readUTF();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	synchronized void receiveLogin() {
		try {
			int check = in.readByte();
			if(check == 1) {
				bone.OtherAreaOption.idField.setEnabled(false);
				bone.OtherAreaOption.passwordField.setEnabled(false);
				bone.OtherAreaOption.signupButton.setEnabled(false);
				bone.OtherAreaUserList.ServerJoinButton.setEnabled(true);
				bone.OtherAreaUserList.ServerCreateButton.setEnabled(true);
				JOptionPane.showMessageDialog(null, "로그인 성공", "로그인", JOptionPane.WARNING_MESSAGE);
			}else {
				bone.OtherAreaOption.loginButton.setEnabled(true);
				JOptionPane.showMessageDialog(null, "로그인 실패", "로그인", JOptionPane.WARNING_MESSAGE);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	synchronized public void receiveRoomList() {
		ArrayList<RoomList> list = new ArrayList<RoomList>();
		try {
			int num = in.readByte();
			for(int i = 0; i<num; i++ ) {
				String name = in.readUTF();
				String password = in.readUTF();
				int number = in.readByte();
				list.add(new RoomList(name,password,number));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bone.newWin.SetJoinListPanel(list);
		bone.newWin.setVisible(true);
	}
	
	synchronized void receiveSignUp() {
		int check = 0;;
		try {
			check = in.readByte();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check == 1) {
			bone.OtherAreaOption.signupButton.setEnabled(true);
			JOptionPane.showMessageDialog(null, "회원가입 성공", "회원가입", JOptionPane.WARNING_MESSAGE);
		}else {
			bone.OtherAreaOption.signupButton.setEnabled(true);
			JOptionPane.showMessageDialog(null, "회원가입 실패", "회원가입", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	synchronized public void recievString() {
		try {
			int type = in.readByte();
			switch(type) {
				case GET_MESSAGE:
				break;
				case SIGN_UP_CHECK:
					receiveSignUp();
				break;
				case CREATE_ROOM_CHECK:
				break;
				case GET_ROOM_LIST:
					receiveRoomList();
				break;
				case LOGIN_CHECK:
					receiveLogin();
				break;

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
				 //recievImage();
			 }
			 	
			 else {
				 ConnectServer();
				 try {Thread.sleep(1000);} 
				 catch (InterruptedException e) {e.printStackTrace();}
			 }
		 }
	  }
}
