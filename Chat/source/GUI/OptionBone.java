package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import GUI.UserListBone.UserListBonePanel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class OptionBone extends JFrame {
	ImageIcon OtherAreaImg = new ImageIcon("AreaImage/OtherAreaImage.png");
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionBone frame = new OptionBone();
					
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
		JButton signupButton;
		JButton loginButton;
		JLabel idLabel;
		JLabel psLabel;
		JTextField idField;
		JTextField passwordField;
		public OptionBonePanel(Image img) {
			super(img);
			setBackground(Color.GRAY);
			setBounds(380, 34, 153, 535);
			setLayout(null);

			signupButton = new JButton(signupImg);
			signupButton.setBounds(7, 163, 69, 24);
			signupButton.setBackground(new Color(174,174,174));
			signupButton.setPressedIcon(pressedSignupImg);
			signupButton.setBorderPainted(false);
			add(signupButton);
			
			loginButton = new JButton(loginImg );
			loginButton.setBounds(81, 163, 69, 24);
			loginButton.setBackground(new Color(174,174,174));
			loginButton.setPressedIcon(pressedLoginImg);
			loginButton.setBorderPainted(false);
			add(loginButton);
			
			
			idLabel = new JLabel("ID:");
			idLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
			idLabel.setBounds(7, 96, 27, 20);
			add(idLabel);
			
			psLabel = new JLabel("PS:");
			psLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
			psLabel.setBounds(7, 128, 27, 20);
			add(psLabel);

			idField = new JTextField(""){
	            @Override
	            public void setBorder(Border border) {
	                
	            }
	        };
			idField.setBounds(30, 98, 118, 24);
			idField.setBackground(new Color(115,115,115));
			idField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
			add(idField);
			idField.setColumns(10);
			
			passwordField = new JTextField(""){
	            @Override
	            public void setBorder(Border border) {
	                
	            }
	        };
			passwordField.setBounds(30, 129, 118, 24);
			passwordField.setBackground(new Color(115,115,115));
			passwordField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
			add(passwordField);
			passwordField.setColumns(10);
			
			setLayout(null);
			
		}
		
		
	}
}
