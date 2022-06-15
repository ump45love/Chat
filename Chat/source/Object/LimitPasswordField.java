package Object;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPasswordField;

public class LimitPasswordField extends JPasswordField implements KeyListener{
	public LimitPasswordField() {	
		addKeyListener(this);
	}
	public void keyTyped(KeyEvent e) {
		int max = 15;
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