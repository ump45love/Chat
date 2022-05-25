package MainPakage;

import Event.JFrameEventInsert;
import GUI.BodyBone;
import Network.Client;

public class CombineClass {
	BodyBone bone;
	Client client;
	
	CombineClass(){
		bone = new BodyBone();
		client = new Client("127.0.0.0",40455);
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
