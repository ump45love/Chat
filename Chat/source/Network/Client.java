package Network;

import java.awt.Dimension;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.BodyBone;
import GUI.ChatAreaInsertBone.ChatInsertBone;
import GUI.JoinListBone.JoinListPanel;
import Object.RoomList;

public class Client extends Thread{
	public static final byte GET_MESSAGE = 0;
	public static final byte SIGN_UP_CHECK = 1;
	public static final byte CREATE_ROOM_CHECK = 2;
	public static final byte GET_ROOM_LIST = 3;
	public static final byte LOGIN_CHECK = 4;

	BodyBone bone;
	Socket ClientSocket;
	DataInputStream in;
	DataOutputStream out;
	String postAddress;
	int port;
	boolean connectCheck;
	ImgClient imgClient;
	
	
	int PortNumber;
	public Client(String Address,int port_,BodyBone bone,ImgClient imgClient){
		ClientSocket = null;
		in = null;
		out = null;
		postAddress = Address;
		port = port_;
		connectCheck= false;
		this.bone = bone;
		this.imgClient =imgClient;
	}
	public void ConnectServer() {
		try {
			ClientSocket = new Socket(postAddress,port);
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
			out.writeUTF(msg);
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
			out.writeUTF(name);
			out.writeUTF(ps);
			bone.ChatSendButton.setEnabled(true);
			imgClient.RequestUserList();
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

	
	public void connectRoom(RoomList data) {
		try {
			out.writeByte(5);
			out.writeByte(data.getRoomNumber());
			imgClient.RequestUserList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeNickName(String name) {
		try {
			out.writeByte(6);
			out.writeUTF(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void StopConnect() {
		try {
			ClientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	synchronized void receiveMessage() {
		try {
			String name = in.readUTF();
			String content = in.readUTF();
			ChatInsertBone data = new ChatInsertBone(content,imgClient.userArray.get(name),name,true);
			bone.ChatArea.add(data);
			bone.scrollHeight +=data.getHeight();
			bone.ChatTextArea.setText(null);
			Dimension size = null;
			if(bone.scrollHeight > bone.ChatArea.getHeight()) {
				size = new Dimension(bone.ChatArea.getWidth(),bone.scrollHeight);
				bone.ChatArea.setPreferredSize(size);
			}
			bone.revalidate();

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
				bone.OtherAreaOption.nickButton.setEnabled(true);
				bone.OtherAreaOption.profileButton.setEnabled(true);
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
				int roomNumber = in.readByte();
				list.add(new RoomList(name,password,number,roomNumber));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		bone.newWin.SetJoinListPanel(list,bone);
		bone.revalidate();
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
					 receiveMessage();
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
			 }
			 	
			 else {
				 ConnectServer();
				 try {Thread.sleep(1000);} 
				 catch (InterruptedException e) {e.printStackTrace();}
			 }
		 }
	  }
}
