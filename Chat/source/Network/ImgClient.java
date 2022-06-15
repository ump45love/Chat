package Network;

import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import GUI.BodyBone;
import ImageFile.ReadImage;
import Object.RoomList;

public class ImgClient extends Thread {
	public static final char GET_IMAGE = 0;
	public static final char GET_USER_LIST = 1;

	BodyBone bone;
	Socket ClientImageSocket;
	DataInputStream imageIn;
	DataOutputStream imageOut;
	String postAddress;
	int port;
	boolean connectCheck;
	HashMap<String,Image> userArray;
	
	
	int PortNumber;
	public ImgClient(String Address,int port_,BodyBone bone){
		ClientImageSocket = null;
		imageIn = null;
		imageOut = null;
		postAddress = Address;
		port = port_;
		connectCheck= false;
		this.bone = bone;
		userArray =new HashMap<String,Image>();
	}
	public void ConnectServer() {
		try {
			ClientImageSocket = new Socket(postAddress,port+1);
			imageOut= new DataOutputStream(ClientImageSocket.getOutputStream());
			imageIn = new DataInputStream(ClientImageSocket.getInputStream());
			connectCheck =true;
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
	
	public void RequestUserList() {
		try {
			imageOut.writeByte(2);
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	synchronized void receiveUserList() {
		int count;
		String save = null;
		try {
			userArray.clear();
			count = imageIn.readByte();
			for(int i = 0; i<count; i++) {
				String name = imageIn.readUTF();
				int size = imageIn.readInt();
				if(size != 0) {
					byte data[] = new byte[size];
					imageIn.read(data);
					userArray.put(name, new ReadImage(data).GetImage());
					save = save + name +"\n";
				}
				else {
					userArray.put(name, null);
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bone.OtherAreaUserList.UserListTextArea.setText(save);
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
	
	 @Override
	  public void run() {
		 while(true) {
			 try {Thread.sleep(10);} catch (InterruptedException e) 
			 {e.printStackTrace();}
			 if(connectCheck) {
				 receiveImage();
			 }
			 	
			 else {
				 ConnectServer();
				 try {Thread.sleep(1000);} 
				 catch (InterruptedException e) {e.printStackTrace();}
			 }
		 }
	  }
}
