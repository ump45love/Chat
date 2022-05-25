package Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.BodyBone;
import GUI.OptionBone.OptionBonePanel;
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
	
	public static void SendMessage(BodyBone bone,Client client) {
		bone.ChatSendButton.addActionListener(e ->{
			client.SendMessage(Network.Client.CHAT + bone.ChatTextArea.getText());
			bone.ChatTextArea.setText(null);
		});
	}
	
	public static void InsertEvent(BodyBone bone,Client client) {
		UserListEvent(bone);
		SettingButtonEvent(bone);
		 SendMessage(bone,client);
	}
	

}
