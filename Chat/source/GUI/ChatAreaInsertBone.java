package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import GUI.JoinListBone.JoinListPanel;

import java.awt.CardLayout;
import javax.swing.JTextArea;
import java.awt.FlowLayout;

public class ChatAreaInsertBone extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatAreaInsertBone frame = new ChatAreaInsertBone("asdasdsadasしいけしいしけasdasdsadasしいけしいしけasdasdsadasしいけしいしけasdasdsadasしいけしいしけasdasdsadasしいけしいしけasdasdsadasしいけしいしけasdasdsadasしいけしいしけasdasdsadasしいけしいしけasdasdsadasしいけしいしけasdasdsadasしいけしいしけasdasdsadasしいけしいしけasdasdsadasしいけしいしけasdasdsadasしいけしいしけasdasdsadasしいけしいしけasdasdsadasしいけしいしけasdasdsadasしいけしいしけasdasdsadasしいけしいしけ");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public ChatAreaInsertBone(String msg) {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		File sourceimage = new File("a.png");
		Image image = null;
		try {
			image = ImageIO.read(sourceimage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 273);
		Dimension size = new Dimension(434, 273);
		panel_1.setPreferredSize(size);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		ChatInsertBone panel = new ChatInsertBone("sasfasfasgaうけいgげじぞqgげgq3ぞq3gさ",image,true);
		panel_1.add(panel);
				
		
	}
	public static class ChatInsertBone extends JPanel {
		ImageIcon topLImg = new ImageIcon("chatArea/topl.png");
		ImageIcon topRImg = new ImageIcon("chatArea/topr.png");
		ImageIcon bottomLImg = new ImageIcon("chatArea/bottoml.png");
		ImageIcon bottomRImg = new ImageIcon("chatArea/bottomr.png");
		DrawImage panelUpL;
		DrawImage panelUpR;
		DrawImage panelDownL;
		DrawImage panelDownR;
		JPanel panelUpWidth;
		JPanel panelDownWidth;
		JTextArea textArea;
		DrawImage panelImage;
		int sizeX;
		int sizeY;
		int positionX;
		int positionY;
		final int absolutLX = 55; 
		final int absolutLY = 23; 
		public ChatInsertBone(String s,Image image,boolean isleft) {
			s = initString(" "+s);
			setBounds(50, 64, 370, GetHeight());
			Dimension size = new Dimension(370, GetHeight());
			setPreferredSize(size);
			setLayout(null);	
			setBackground(new Color(54,54,54));
			setBorder(null);
			panelUpL= new DrawImage(topLImg.getImage());
			panelUpR = new DrawImage(topRImg.getImage());
			panelDownL = new DrawImage(bottomLImg.getImage());
			panelDownR = new DrawImage(bottomRImg.getImage());
			panelUpWidth = new JPanel();
			panelUpWidth.setBackground(new Color(157,157,157));
			add(panelUpWidth);
			
			panelDownWidth = new JPanel();
			panelDownWidth.setBackground(new Color(157,157,157));
			add(panelDownWidth);
			
			
			JTextArea textArea = new JTextArea(s);
			textArea.setBackground(new Color(157,157,157));
			textArea.setFont(new Font("玄精 壱拒", Font.BOLD, 12));
			textArea.setEditable(false);
			add(textArea);
			add(panelUpL);
			add(panelUpR);
			add(panelDownL);
			add(panelDownR);
			
			if(isleft) {
				panelImage = new DrawImage(image);
				panelImage .setBounds(2, 0, 50, 50);
				add(panelImage);
				panelUpL.setBounds(55, 23, 6, 6);
				panelUpR.setBounds(55+sizeX,23,6,6);
				panelDownL.setBounds(55, 26+sizeY, 6, 6);
				panelDownR.setBounds(55+sizeX,26+sizeY,6,6);
				panelDownWidth.setBounds(61, 26+sizeY, sizeX-2, 4);
				panelUpWidth.setBounds(61, 23, sizeX-2, 4);
				textArea.setBounds(58, 27, sizeX+3, sizeY);
			}
			else {
				int width = 360;
				panelUpL.setBounds(width-sizeX, 23, 6, 6);
				panelUpR.setBounds(width,23,6,6);
				panelDownL.setBounds(width-sizeX, 26+sizeY, 6, 6);
				panelDownR.setBounds(width,26+sizeY,6,6);
				panelDownWidth.setBounds(width+6-sizeX, 26+sizeY, sizeX-2, 4);
				panelUpWidth.setBounds(width+6-sizeX, 23, sizeX-2, 4);
				textArea.setBounds(width+3-sizeX, 27, sizeX+3, sizeY);
			}
			
			setLayout(null);
			
		}
		
		int GetHeight() {
			return sizeY+35;
		}
		String initString(String s) {
			String save = new String();
			Font font = new Font("玄精 壱拒", Font.BOLD, 12);
			FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);
			int width = 0;
			sizeX=0;
			for(int i = 0; i< s.length(); i++) {
				String data = s.substring(i,i+1);
				width += (int)(font.getStringBounds(data, frc).getWidth());
				if(Pattern.matches("^[a-z0-9]*$", data))
					width++;
				save += data;
				if(width >230) {
					save += "\n ";
					if(sizeX < width)
						sizeX = width;
					sizeY++;
					width = 0;
				}
			}
			if(sizeX < width)
				sizeX = width;
			sizeY++;
			sizeY *=17;
			return save;
		}
		
	}
}
