package Object;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class LimitField extends JTextField implements KeyListener{
	int limit;
	public LimitField(int limit) {	
		addKeyListener(this);
		this.limit = limit;
	}
	public void keyTyped(KeyEvent e) {
		int max = limit;
		if(this.getText().length() > max+1) {
			e.consume();
			String shortened = this.getText().substring(0, max);
			this.setText(shortened);
		}else if(this.getText().length() > max) {
			e.consume();
		}
	}
	public void keyReleased(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
}