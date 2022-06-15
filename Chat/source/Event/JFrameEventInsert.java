package Event;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.swing.JTextField;

import GUI.BodyBone;
import GUI.ChatAreaInsertBone.ChatInsertBone;
import GUI.JoinListBone.JoinListPanel;
import GUI.OptionBone.OptionBonePanel;
import GUI.ServerJoinFrameBone;
import GUI.UserListBone.UserListBonePanel;
import Network.Client;

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
	
	
	public static void SendEnter(BodyBone bone,Client client) {
		BiFunction<Client,BodyBone,Integer> f = (c,b) ->{
			String s= b.ChatTextArea.getText();
			if(s.length() >255)
				s= b.ChatTextArea.getText().substring(0,255);
			if(!s.isEmpty()) {
				//c.SendMessage(Network.Client.CHAT + s);
				ChatInsertBone data = new ChatInsertBone(s,null,false);
				b.ChatArea.add(data);
				b.scrollHeight +=data.getHeight();
				b.ChatTextArea.setText(null);
				Dimension size = null;
				if(b.scrollHeight > b.ChatArea.getHeight()) {
					size = new Dimension(b.ChatArea.getWidth(),b.scrollHeight);
					b.ChatArea.setPreferredSize(size);
				}
				b.revalidate();
				b.ChatAreaScroll.getVerticalScrollBar().setValue(b.ChatAreaScroll.getVerticalScrollBar().getMaximum());
				b.ChatTextArea.requestFocus();
			}
			return null;
		};
		bone.ChatTextArea.setKeyListener(client, bone, f);
	}
	
	public static void SendMessage(BodyBone bone,Client client) {
		bone.ChatSendButton.addActionListener(e ->{
			String s= bone.ChatTextArea.getText();
			if(s.length() >255)
				s= bone.ChatTextArea.getText().substring(0,255);
			if(s.isEmpty())
				return;
			//client.SendMessage(Network.Client.CHAT + s);
			ChatInsertBone data = new ChatInsertBone(s,null,false);
			bone.ChatArea.add(data);
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
	
	public static void CreateServer(BodyBone bone,Client client) {
		bone.OtherAreaUserList.ServerJoinButton.addActionListener(e ->{
			bone.newWin.setVisible(true);
			bone.ChatTextArea.setText(null);
		});
	}
	
	
	public static void InsertEvent(BodyBone bone,Client client) {
		UserListEvent(bone);
		SettingButtonEvent(bone);
		SendMessage(bone,client);
		CreateServer(bone,client);
		ConnectServer(bone,client);
		ScrollUpdate(bone);
		SendEnter(bone,client);
		Login(bone,client);
		SignUp(bone,client);
	}
	

}
