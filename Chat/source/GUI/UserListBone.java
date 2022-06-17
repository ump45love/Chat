package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.DrawImage;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class UserListBone extends JFrame {
	
	private JPanel contentPane;
	ImageIcon OtherAreaImg = new ImageIcon("AreaImage/OtherAreaImage.png");

	public UserListBone() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 601);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		UserListBonePanel OtherArea = new UserListBonePanel(OtherAreaImg.getImage());
		OtherArea.UserListTextArea.setForeground(Color.WHITE);
		getContentPane().add(OtherArea);
		OtherArea.setLayout(null);

		contentPane.setLayout(null);
	}
	public static class UserListBonePanel extends DrawImage{
		ImageIcon ServerCreateImg = new ImageIcon("ButtonImage/ServerCreate.png");
		ImageIcon ServerJoinImg = new ImageIcon("ButtonImage/ServerJoin.png");
		ImageIcon PressedServerCreateImg = new ImageIcon("ButtonImage/PressedServerCreate.png");
		ImageIcon PressedServerJoinImg = new ImageIcon("ButtonImage/PressedServerJoin.png");
		public JButton ServerJoinButton;
		public JButton ServerCreateButton;
		public JTextArea UserListTextArea;
		public UserListBonePanel(Image img) {
			super(img);
			setBackground(Color.GRAY);
			setBounds(380, 34, 153, 535);
			setLayout(null);
			
			UserListTextArea = new JTextArea();
			UserListTextArea.setFont(new Font("Monospaced", Font.BOLD, 13));
			UserListTextArea.setBackground(new Color(178,178,178));
			UserListTextArea.setEditable(false);
			UserListTextArea.setBounds(12, 10, 129, 446);
			
			ServerJoinButton = new JButton(ServerJoinImg);
			ServerJoinButton  .setContentAreaFilled(false);
			ServerJoinButton .setFocusPainted(false);
			ServerJoinButton.setBounds(10, 502, 136, 23);
			add(ServerJoinButton);
			ServerJoinButton.setForeground(UIManager.getColor("window"));
			ServerJoinButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
			ServerJoinButton.setBackground(new Color(174,174,174));
			ServerJoinButton.setBorderPainted(false);
			ServerJoinButton.setPressedIcon(PressedServerJoinImg);
			ServerJoinButton.setEnabled(false);
			
			
			ServerCreateButton = new JButton(ServerCreateImg);
			ServerCreateButton.setEnabled(false);
			ServerCreateButton.setContentAreaFilled(false);
			ServerCreateButton.setFocusPainted(false);
			ServerCreateButton.setBounds(10, 469, 136, 23);
			add(ServerCreateButton);
			ServerCreateButton.setBackground(new Color(174,174,174));
			ServerCreateButton.setForeground(UIManager.getColor("window"));
			ServerCreateButton.setBorderPainted(false);
			ServerCreateButton.setPressedIcon(PressedServerCreateImg);
			
			add(UserListTextArea);
		}
	}
}
