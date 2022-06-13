package MainPakage;

import java.awt.Event;
import java.awt.EventQueue;

import Event.JFrameEventInsert;
import GUI.BodyBone;
import Network.Client;

public class Main {
	
	public static void main(String[] args) {
		BodyBone bone = new BodyBone();
		Client client = new Client("127.0.0.1",5000,bone);
		CombineClass comine = new CombineClass(bone,client);	
	}


}
