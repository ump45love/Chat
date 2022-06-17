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
import ImageFile.ReadImage;
import Network.Client;
import Network.ImgClient;
import Object.ReadFileDir;

public class JFrameEventInsert {
	
	public static void SetNickName(BodyBone bone, Client client) {
		bone. OtherAreaOption.nickButton.addActionListener(e->{
			if(!bone.OtherAreaOption.nickField.getText().isEmpty()) {
				client.changeNickName(bone.OtherAreaOption.nickField.getText());
				JOptionPane.showMessageDialog(null, "닉네임 설정 완료", "이름", JOptionPane.WARNING_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null, "닉네임을 입력해주세요", "이름", JOptionPane.WARNING_MESSAGE);
		});
	}
	
	public static void SetProfileImage(BodyBone bone,ImgClient imgClient) {
		bone. OtherAreaOption.profileButton.addActionListener(e->{
			ReadFileDir read = new ReadFileDir();
			if(read.IsOk()) {
				ReadImage image = new ReadImage(read.GetFileDir());
				imgClient.SetProfileImage(image.Getbyte(),read.GetName());
				System.out.println(image.Getbyte().length);
				JOptionPane.showMessageDialog(null, "프로필 설정 완료", "프로필", JOptionPane.WARNING_MESSAGE);
			}
		});
	}
	
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
		Function<Integer,Integer> funtion= i->i+1;
		BiFunction<Client,BodyBone,Integer> f = (c,b) ->{
			String s= b.ChatTextArea.getText();
			if(s.length() >255)
				s= b.ChatTextArea.getText().substring(0,255);
			if(!s.isEmpty()) {
				client.SendMessage(s);
				ChatInsertBone data = new ChatInsertBone(s,null,null,false);
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
		bone.ChatTextArea.setKeyListener(client,bone,f);
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
			System.out.println(bone.ChatArea.countComponents());
			if(bone.ChatArea.countComponents() > 30) {
				bone.scrollHeight -=bone.ChatArea.getComponent(1).getHeight();
				bone.ChatArea.remove(1);
			}
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
	
	public static void RequestServer(BodyBone bone,Client client) {
		bone.OtherAreaUserList.ServerJoinButton.addActionListener(e ->{
			bone.newWin.panel.removeAll();
			bone.newWin.setVisible(true);
			client.RequestRommList();
		});
	}
	
	public static void CreateServerWinOpen(BodyBone bone,Client client) {
		bone.OtherAreaUserList.ServerCreateButton.addActionListener(e ->{
			bone.CreateRoomNewWin.setVisible(true);
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
			else {
				JOptionPane.showMessageDialog(null, "방 이름을 입력해주세요\n비밀번호는 입력하지 않아도 됩니다.", "이름", JOptionPane.WARNING_MESSAGE);
				System.out.println("asdasdasdad");
			}
		});
	}
	
	public static void InsertEvent(BodyBone bone,Client client,ImgClient imgClient) {
		UserListEvent(bone);
		SettingButtonEvent(bone);
		SendMessage(bone,client);
		CreateServer(bone,client);
		RequestServer(bone,client);
		ScrollUpdate(bone);
		Login(bone,client);
		SignUp(bone,client);
		CreateServerWinOpen(bone,client);
		SendEnter(bone,client);
		SetNickName(bone,client);
		SetProfileImage(bone,imgClient);
	}
	

}
