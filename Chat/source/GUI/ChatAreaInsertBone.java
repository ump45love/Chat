package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class ChatAreaInsertBone extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatAreaInsertBone frame = new ChatAreaInsertBone("asdasd");
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
		
		ChatInsertBone panel = new ChatInsertBone("sadasd");
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBounds(50, 64, 370, 115);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(2, 0, 50, 50);
		panel.add(panel_1);

		
	}
	
	public static class ChatInsertBone extends JPanel {
		ImageIcon topLImg = new ImageIcon("chatArea/topl.png");
		ImageIcon topRImg = new ImageIcon("chatArea/topr.png");
		ImageIcon bottomLImg = new ImageIcon("chatArea/bottoml");
		ImageIcon bottomRImg = new ImageIcon("chatArea/bottomr");
		DrawImage panelUpL;
		DrawImage panelUpR;
		DrawImage panelDownL;
		DrawImage panelDownR;
		JPanel panelWidth;
		JTextField textField;
		int sizeX;
		int sizeY;
		public ChatInsertBone(String s) {
			sizeX = getxLength(s);
			sizeY = getyLength(s);
			setBackground(Color.GRAY);
			setBounds(380, 34, 370, 10+sizeY); 
			setLayout(null);
			panelUpL= new DrawImage(topLImg.getImage());
			panelUpR = new DrawImage(topRImg.getImage());
			panelDownL = new DrawImage(bottomLImg.getImage());
			panelDownR = new DrawImage(bottomRImg.getImage());
			panelWidth = new JPanel();
			panelWidth.setBackground(new Color(157,157,157));
			panelWidth.setBounds(64, 23, sizeX, 3);
			add(panelWidth);
			textField = new JTextField(s);
			textField.setForeground(Color.WHITE);
			textField.setBackground(new Color(157,157,157));
			textField.setBorder(null);
			textField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
			textField.setEditable(false);
			textField.setBounds(58, 27, sizeX+10, sizeY);
			add(textField);
			textField.setColumns(10);
			panelUpL.setBounds(58, 23, 6, 6);
			add(panelUpL);
			
			setLayout(null);
			
		}
		
		int getxLength(String s) {
			int size = s.length();
			if(size >16)
				return 64;
			return size*8;
		}
		int getyLength(String s) {
			int size = s.length()/16;
			return (size+1)*15;
		}
	}
}
