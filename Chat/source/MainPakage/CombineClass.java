package MainPakage;

import Event.JFrameEventInsert;
import GUI.BodyBone;
import Network.Client;

public class CombineClass {
	BodyBone bone;
	Client client;
	
	CombineClass(BodyBone b,Client c){
		bone = b;
		client = c;
		ClientSetting();
		GUISetting();
	}
	
	void ClientSetting(){
		client.ConnectServer();
		client.start();
	}
	
	void GUISetting() {
		JFrameEventInsert.InsertEvent(bone,client);
		bone.setVisible(true);
	}
}
