package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import javax.swing.JTextArea;

import Network.Client;

public class TextAreaEnterSend extends JTextArea  implements KeyListener{
	BiFunction<Client,BodyBone,Integer> funtion;
	boolean isOk;
	Client client;
	BodyBone bone;
	TextAreaEnterSend(){
		isOk=false;
		addKeyListener(this);
	}
	public void setKeyListener(Client client,BodyBone bone,BiFunction<Client,BodyBone,Integer> f) {
		this.client = client;
		this.bone = bone;
		funtion = f;
		isOk=true;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(isOk) {
			if(e.getKeyChar() == KeyEvent.VK_ENTER)
				funtion.apply(client, bone); 
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
