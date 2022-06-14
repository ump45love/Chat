package Network;

import java.awt.Image;

import javax.swing.ImageIcon;

import GUI.JoinListBone.JoinListPanel;

public class RoomList {
	String name;
	String password;
	int number;
	Image image;
	
	public RoomList(String name,String password,int number) {
		this.name = name;
		this.password = password;
		this.number = number;
		image = new ImageIcon("AreaImage/JoinListAreaImage.png").getImage();
	}
	
	public RoomList() {
		this.name = new String();
		this.password = new String();
		this.number = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPasword() {
		return password;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setRoomList(String name,String password,int number) {
		this.name = name;
		this.password = password;
		this.number = number;
		
	}
	public JoinListPanel getJoinListPanel() {
		return new JoinListPanel(image,name,number);
	}
	

}
