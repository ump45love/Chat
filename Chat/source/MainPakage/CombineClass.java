package MainPakage;

import Event.JFrameEventInsert;
import GUI.BodyBone;
import Network.Client;
import Network.ImgClient;

public class CombineClass {
	BodyBone bone;
	Client client;
	ImgClient imgClient;
	
	CombineClass(BodyBone b,Client c,ImgClient i){
		bone = b;
		client = c;
		imgClient = i;
		ClientSetting();
		GUISetting();
	}
	
	void ClientSetting(){
		client.ConnectServer();
		imgClient.ConnectServer();
		client.start();
	}
	
	void GUISetting() {
		JFrameEventInsert.InsertEvent(bone,client,imgClient);
		bone.setVisible(true);
	}
}
