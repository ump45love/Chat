package MainPakage;

import java.awt.Event;
import java.awt.EventQueue;

import Event.JFrameEventInsert;
import GUI.BodyBone;
import Network.Client;
import Network.ImgClient;

public class runMain {
	
	public static void main(String[] args) {
		BodyBone bone = new BodyBone();
		ImgClient imgClient = new ImgClient("lovecein4858.iptime.org",5123,bone);
		Client client = new Client("lovecein4858.iptime.org",5123,bone,imgClient);
		bone.SetClient(client);
		CombineClass comine = new CombineClass(bone,client,imgClient);	
	}


}
