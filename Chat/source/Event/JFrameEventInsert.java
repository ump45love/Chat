package Event;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import GUI.BodyBone;
import GUI.ChatAreaInsertBone.ChatInsertBone;
import GUI.JoinListBone.JoinListPanel;
import GUI.OptionBone.OptionBonePanel;
import GUI.ServerJoinFrameBone;
import GUI.UserListBone.UserListBonePanel;
import Network.Client;
import Network.ImgClient;

public class JFrameEventInsert {
	
	public static void SettingButtonEvent(BodyBone bone) {
		
		bone.SettingButton.addActionListener((e) ->{bone.remove(bone.OtherAreaUserList); 	
		bone.add(bone.OtherAreaOption); 
		bone.repaint();});
	}
	
	public static void UserListEvent(BodyBone bone) {
		bone.UserListButton.addActionListener((e) -> {bone.remove(bone.OtherAreaOption); 	
		bone.add(bone.OtherAreaUserList);
		bone.repaint();});
	}
	
	public static void Login(BodyBone bone,Client client) {
		bone.OtherAreaOption.loginButton.addActionListener((e) -> {
			client.Login(bone.OtherAreaOption.idField.getText(), bone.OtherAreaOption.passwordField.getText());
			bone.OtherAreaOption.loginButton.setEnabled(false);
		});
	}
	
	public static void SignUp(BodyBone bone,Client client) {
		bone.OtherAreaOption.signupButton.addActionListener((e) ->{
			client.SignUp(bone.OtherAreaOption.idField.getText(), bone.OtherAreaOption.passwordField.getText());
			bone.OtherAreaOption.signupButton.setEnabled(false);
		});
	}
	
	
	
	public static void SendMessage(BodyBone bone,Client client) {
		bone.ChatSendButton.addActionListener(e ->{
			String s= bone.ChatTextArea.getText();
			if(s.length() >255)
				s= bone.ChatTextArea.getText().substring(0,255);
			if(s.isEmpty())
				return;
			client.SendMessage(s);
			ChatInsertBone data = new ChatInsertBone(s,null,null,false);
			bone.ChatArea.add(data);
			if(bone.ChatArea.countComponents() > 30)
				bone.ChatArea.remove(0);
			bone.scrollHeight +=data.getHeight();
			bone.ChatTextArea.setText(null);
			Dimension size = null;
			if(bone.scrollHeight > bone.ChatArea.getHeight()) {
				size = new Dimension(bone.ChatArea.getWidth(),bone.scrollHeight);
				bone.ChatArea.setPreferredSize(size);
			}
			bone.revalidate();
			bone.ChatAreaScroll.getVerticalScrollBar().setValue(bone.ChatAreaScroll.getVerticalScrollBar().getMaximum());
			bone.ChatTextArea.requestFocus();
		});
	}
	
	public static void ScrollUpdate(BodyBone bone) {
		bone.ChatAreaScroll.getViewport().addChangeListener((e) -> {bone.repaint();});
	}
	
	public static void ConnectServer(BodyBone bone,Client client) {
		bone.OtherAreaUserList.ServerCreateButton.addActionListener(e ->{
			bone.newWin = new ServerJoinFrameBone(bone);
			client.RequestRommList();
		});
	}
	
	public static void CreateServerWinOpen(BodyBone bone,Client client) {
		bone.OtherAreaUserList.ServerJoinButton.addActionListener(e ->{
			bone.newWin.setVisible(true);
		});
	}
	public static void CreateServer(BodyBone bone, Client client) {
		bone.CreateRoomNewWin.CreateRoomButton.addActionListener(e->{
			String s = bone.CreateRoomNewWin.roomNameField.getText();
			if(!s.isEmpty()) {
				client.CreateRoom(bone.CreateRoomNewWin.roomNameField.getText(), bone.CreateRoomNewWin.roomPasswordField.getText());
				bone.CreateRoomNewWin.roomNameField.setText(null);
				 bone.CreateRoomNewWin.roomPasswordField.setText(null);
				bone.CreateRoomNewWin.setVisible(false);
			}
			else
				JOptionPane.showMessageDialog(null, "방 이름을 입력해주세요\n비밀번호는 입력하지 않아도 됩니다.", "이름", JOptionPane.WARNING_MESSAGE);
		});
	}
	
	public static void InsertEvent(BodyBone bone,Client client,ImgClient imgClient) {
		UserListEvent(bone);
		SettingButtonEvent(bone);
		SendMessage(bone,client);
		CreateServer(bone,client);
		ConnectServer(bone,client);
		ScrollUpdate(bone);
		Login(bone,client);
		SignUp(bone,client);
	}
	

}
