package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import GUI.OptionBone.OptionBonePanel;
import GUI.UserListBone.UserListBonePanel;

import java.awt.FlowLayout;
import javax.swing.border.CompoundBorder;

public class BodyBone extends JFrame {
	
	ImageIcon SendImg = new ImageIcon("ButtonImage/Send.png");
	ImageIcon ServerCreateImg = new ImageIcon("ButtonImage/ServerCreate.png");
	ImageIcon ServerJoinImg = new ImageIcon("ButtonImage/ServerJoin.png");
	ImageIcon PressedSnedImg = new ImageIcon("ButtonImage/PressedSend.png");
	ImageIcon PressedServerCreateImg = new ImageIcon("ButtonImage/PressedServerCreate.png");
	ImageIcon PressedServerJoinImg = new ImageIcon("ButtonImage/PressedServerJoin.png");
	ImageIcon SettingIconImg = new ImageIcon("Image/SettingIcon.png");
	ImageIcon ChatAreaImg = new ImageIcon("AreaImage/ChatAreaImage.png");
	ImageIcon SendAreaImg = new ImageIcon("AreaImage/SendAreaImage.png");
	ImageIcon MenuAreaImg = new ImageIcon("AreaImage/MenuAreaImage.png");
	ImageIcon OtherAreaImg = new ImageIcon("AreaImage/OtherAreaImage.png");
	ImageIcon UserListIconImg = new ImageIcon("Image/UserListIcon.png");
	ImageIcon PressedUserListIconImg = new ImageIcon("Image/PressedUserListIcon.png");
	ImageIcon PressedSettingIconImage = new ImageIcon("Image/PressedSettingIconArea.png");
	private JPanel contentPane;
	
	
	DrawImage ChatArea;	
	JScrollPane ChatAreaScroll;
	DrawImage ChatSendArea;
	public JTextArea ChatTextArea;
	JScrollPane ChatSendScroll;
	DrawImage MenuArea;
	
	public JButton ChatSendButton;
	public JButton UserListButton;
	public JButton SettingButton;
	
	public UserListBonePanel OtherAreaUserList;
	public OptionBonePanel OtherAreaOption;
	public ServerJoinFrameBone newWin;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BodyBone frame = new BodyBone();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	void InitOtherWise() {
		OtherAreaUserList = new UserListBonePanel(OtherAreaImg.getImage());
		OtherAreaOption = new OptionBonePanel(OtherAreaImg.getImage());
		newWin = new ServerJoinFrameBone(this);
		newWin.setVisible(false);
	}
	/**
	 * Create the frame.
	 */
	public BodyBone() {
		
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 607);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(29,29,29));
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		InitOtherWise();
		ChatArea = new DrawImage(ChatAreaImg.getImage());
		ChatArea.setForeground(Color.DARK_GRAY);
		ChatArea.setBorder(null);
		ChatArea.setBackground(new Color(174, 174, 174));
		ChatArea.setBounds(0, 0, 380, 492);
		
		ChatAreaScroll = new JScrollPane(ChatArea);
		ChatArea.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		ChatAreaScroll.setBorder(new CompoundBorder());
		ChatAreaScroll.setBounds(0, 4, 380, 490);
		contentPane.add(ChatAreaScroll);
		
		ChatSendArea = new DrawImage(SendAreaImg.getImage());
		ChatSendArea.setBorder(null);
		ChatSendArea.setBackground(new Color(163,163,163));
		ChatSendArea.setBounds(0, 492, 380, 73);
		contentPane.add(ChatSendArea);
		ChatSendArea.setLayout(null);
		
		
		
		ChatTextArea = new JTextArea();
		ChatTextArea.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		ChatTextArea.setBackground(new Color(115,115,115));
		ChatTextArea.setForeground(Color.BLACK);
		ChatTextArea.setLineWrap(true);
		ChatTextArea.setWrapStyleWord(true);
		ChatTextArea.setBorder(null);
		
		ChatSendScroll = new JScrollPane(ChatTextArea);
		ChatSendScroll.setBounds(11, 11, 290, 55);
		ChatSendScroll.setBorder(new CompoundBorder());
		ChatSendArea.add(ChatSendScroll);
		
		
		ChatSendButton = new JButton(SendImg);
		ChatSendButton.setContentAreaFilled(false);
		ChatSendButton.setFocusPainted(false);
		ChatSendButton.setBounds(312, 11, 60, 55);
		ChatSendArea.add(ChatSendButton);
		ChatSendButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		ChatSendButton.setForeground(UIManager.getColor("window"));
		ChatSendButton.setBackground(new Color(163,163,163));
		ChatSendButton.setBorderPainted(false);
		ChatSendButton.setPressedIcon(PressedSnedImg);
		
		contentPane.add(OtherAreaUserList);
		OtherAreaUserList.setLayout(null);
		
		
		MenuArea = new DrawImage(MenuAreaImg.getImage());
		MenuArea.setBackground(Color.YELLOW);
		MenuArea.setBorder(null);
		MenuArea.setBounds(405, 4, 128, 30);
		contentPane.add(MenuArea);
		MenuArea.setLayout(null);
		
		SettingButton = new JButton(SettingIconImg);
		SettingButton.setBounds(98, 5, 24, 24);
		SettingButton.setContentAreaFilled(false);
		SettingButton.setFocusPainted(false);
		MenuArea.add(SettingButton);
		SettingButton.setForeground(new Color(0, 0, 0));
		SettingButton.setBackground(new Color(101,101,101));
		SettingButton.setPressedIcon(PressedSettingIconImage);
		SettingButton.setBorderPainted(false);
		
		UserListButton = new JButton(UserListIconImg);
		UserListButton .setContentAreaFilled(false);
		UserListButton .setFocusPainted(false);
		UserListButton.setBackground(new Color(101,101,101));
		UserListButton.setBounds(10, 5, 79, 24);
		UserListButton.setBorderPainted(false);
		UserListButton.setPressedIcon(PressedUserListIconImg);
		MenuArea.add(UserListButton);
	}
	
	void InsertChat(String s) {
		
	}
}
