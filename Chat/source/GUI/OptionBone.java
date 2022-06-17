package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Object.DrawImage;
import Object.LimitField;
import Object.LimitPasswordField;

import javax.swing.JLabel;

public class OptionBone extends JFrame {
	ImageIcon OtherAreaImg = new ImageIcon("AreaImage/OtherAreaImage.png");
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public OptionBone() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 601);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		OptionBonePanel OtherArea = new OptionBonePanel(OtherAreaImg.getImage());
		OtherArea.setBounds(375, 5, -1, -1);
		getContentPane().add(OtherArea);
		

		OtherArea.setLayout(null);
		
		
		
	}
	
	public static class OptionBonePanel extends DrawImage{
		ImageIcon loginImg = new ImageIcon("ButtonImage/Login.png");
		ImageIcon signupImg = new ImageIcon("ButtonImage/SignUp.png");
		ImageIcon pressedLoginImg = new ImageIcon("ButtonImage/PressedLogin.png");
		ImageIcon pressedSignupImg = new ImageIcon("ButtonImage/PressedSignUp.png");
		public JButton signupButton;
		public JButton loginButton;
		public JButton profileButton;
		public JButton nickButton;
		JLabel idLabel;
		JLabel psLabel;
		JLabel nickLabel;
		public LimitField idField;
		public LimitPasswordField passwordField;
		public LimitField nickField;
		public OptionBonePanel(Image img) {
			super(img);
			setBackground(Color.GRAY);
			setBounds(380, 34, 153, 535);
			setLayout(null);
			signupButton = new JButton(signupImg);
			signupButton .setContentAreaFilled(false);
			signupButton .setFocusPainted(false);
			signupButton.setBounds(7, 163, 69, 24);
			signupButton.setBackground(new Color(174,174,174));
			signupButton.setPressedIcon(pressedSignupImg);
			signupButton.setBorderPainted(false);
			add(signupButton);
			
			loginButton = new JButton(loginImg );
			loginButton.setBounds(81, 163, 69, 24);
			loginButton .setContentAreaFilled(false);
			loginButton .setFocusPainted(false);
			loginButton.setBackground(new Color(174,174,174));
			loginButton.setPressedIcon(pressedLoginImg);
			loginButton.setBorderPainted(false);
			add(loginButton);
			
			profileButton = new JButton("ÇÁ·ÎÇÊ ¼³Á¤");
			profileButton.setBounds(7, 285, 149, 24);
			profileButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
			//profileButton .setContentAreaFilled(false);
			profileButton .setFocusPainted(false);
			profileButton.setBackground(new Color(140,140,140));
			profileButton.setPressedIcon(pressedLoginImg);
			profileButton.setBorderPainted(false);
			profileButton.setEnabled(false);
			add(profileButton);
			
			nickButton = new JButton("´Ð³×ÀÓ ¼³Á¤");
			nickButton.setBounds(7, 255, 149, 24);
			nickButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
			//profileButton .setContentAreaFilled(false);
			nickButton .setFocusPainted(false);
			nickButton.setBackground(new Color(140,140,140));
			nickButton.setPressedIcon(pressedLoginImg);
			nickButton.setBorderPainted(false);
			nickButton.setEnabled(false);
			add(nickButton);
			
			
			
			idLabel = new JLabel("ID:");
			idLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
			idLabel.setBounds(7, 96, 27, 20);
			add(idLabel);
			
			psLabel = new JLabel("PS:");
			psLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
			psLabel.setBounds(7, 128, 27, 20);
			add(psLabel);
			idField = new LimitField(16){
	            @Override
	            public void setBorder(Border border) {
	                
	            }
	        };
	        nickLabel = new JLabel("´Ð³×ÀÓ:");
	        nickLabel.setBounds(7, 225, 118, 24);
	        nickLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 10));
	        add(nickLabel);
	        
			idField.setBounds(30, 98, 118, 24);
			idField.setBackground(new Color(115,115,115));
			idField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
			add(idField);
			idField.setColumns(10);
			
			passwordField = new LimitPasswordField(){
	            @Override
	            public void setBorder(Border border) {
	                
	            }
	        };
	        
			passwordField.setBounds(30, 129, 118, 24);
			passwordField.setBackground(new Color(115,115,115));
			passwordField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
			add(passwordField);
			passwordField.setColumns(10);
			
			nickField = new LimitField(12){
	            @Override
	            public void setBorder(Border border) {
	                
	            }
	        };
	        nickField.setBounds(42, 225, 114, 24);
	        nickField.setBackground(new Color(115,115,115));
	        nickField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
	        add(nickField);
			
			setLayout(null);
			
		}
		
		
	}
}
