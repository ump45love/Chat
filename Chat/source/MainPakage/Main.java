package MainPakage;

import java.awt.Event;
import java.awt.EventQueue;

import Event.JFrameEventInsert;
import GUI.BodyBone;
import Network.Client;
import Network.ImgClient;

public class Main {
	
	public static void main(String[] args) {
		BodyBone bone = new BodyBone();
		ImgClient imgClient = new ImgClient("127.0.0.1",5123,bone);
		Client client = new Client("127.0.0.1",5123,bone,imgClient);
		bone.SetClient(client);
		CombineClass comine = new CombineClass(bone,client,imgClient);	
	}


}
