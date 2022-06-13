package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.CardLayout;
import javax.swing.JTextArea;

public class ChatAreaInsertBone extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatAreaInsertBone frame = new ChatAreaInsertBone("(..................................................................................................................................)");
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
		contentPane.setLayout(null);
		
		ChatInsertBone panel = new ChatInsertBone(" "+msg);
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBounds(50, 64, 370, 115);
		contentPane.add(panel);
		panel.setLayout(null);
		
		File sourceimage = new File("a.png");
		Image image1 = null;
		try {
			image1 = ImageIO.read(sourceimage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DrawImage panel_1 = new DrawImage(image1);
		panel_1.setBounds(2, 0, 50, 50);
		panel.add(panel_1);
		
		
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
		int sizeX;
		int sizeY;
		public ChatInsertBone(String s) {
			s = initString(s);
			setBackground(Color.GRAY);
			setBounds(380, 34, 370, 10+sizeY); 
			setLayout(null);
			panelUpL= new DrawImage(topLImg.getImage());
			panelUpR = new DrawImage(topRImg.getImage());
			panelDownL = new DrawImage(bottomLImg.getImage());
			panelDownR = new DrawImage(bottomRImg.getImage());
			panelUpWidth = new JPanel();
			
			panelUpWidth.setBackground(new Color(157,157,157));
			panelUpWidth.setBounds(61, 23, sizeX-2, 4);
			add(panelUpWidth);
			
			panelDownWidth = new JPanel();
			panelDownWidth.setBackground(new Color(157,157,157));
			panelDownWidth.setBounds(61, 26+sizeY, sizeX-2, 4);
			add(panelDownWidth);
			
			
			JTextArea textArea = new JTextArea(s);
			textArea.setBackground(new Color(157,157,157));
			textArea.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
			textArea.setEditable(false);
			textArea.setBounds(58, 27, sizeX+3, sizeY);
			add(textArea);
			panelUpL.setBounds(55, 23, 6, 6);
			panelUpR.setBounds(55+sizeX,23,6,6);
			panelDownL.setBounds(55, 26+sizeY, 6, 6);
			panelDownR.setBounds(55+sizeX,26+sizeY,6,6);
			add(panelUpL);
			add(panelUpR);
			add(panelDownL);
			add(panelDownR);
			
			setLayout(null);
			
		}
		String initString(String s) {
			String save = new String();
			Font font = new Font("¸¼Àº °íµñ", Font.BOLD, 12);
			FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);
			int width = 0;
			sizeX=0;
			System.out.println(s);
			System.out.println(s.length());
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
