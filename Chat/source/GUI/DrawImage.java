package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class DrawImage extends JPanel {
		  private Image img;
		  
		  public DrawImage(Image img) {
		      this.img = img;
		      if(img == null) {
		    	  setLayout(null);
		    	  setOpaque(true);
		      }
		      else {
		    	  setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		    	  setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		      }
		  }
		  
		  public void paintComponent(Graphics g) {
		      g.drawImage(img, 3, 0, null);
		  }
}
