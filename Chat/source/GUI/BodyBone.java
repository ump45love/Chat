package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import GUI.ChatAreaInsertBone.ChatInsertBone;
import GUI.OptionBone.OptionBonePanel;
import GUI.UserListBone.UserListBonePanel;
import Network.Client;
import Object.DrawImage;
import Object.TextAreaEnterSend;

import java.awt.FlowLayout;
import javax.swing.border.CompoundBorder;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;

public class BodyBone extends JFrame  implements KeyListener {
	java.net.URL imageURL = getClass().getClassLoader().getResource("ButtonImage/Send.png");
	ImageIcon SendImg = new ImageIcon(imageURL);
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
	
	public DrawImage ChatArea;	
	public JScrollPane ChatAreaScroll;
	DrawImage ChatSendArea;
	public TextAreaEnterSend  ChatTextArea;
	JScrollPane ChatSendScroll;
	DrawImage MenuArea;
	private Client client;
	public JButton ChatSendButton;
	public JButton UserListButton;
	public JButton SettingButton;
	public int scrollHeight;
	
	public UserListBonePanel OtherAreaUserList;
	public OptionBonePanel OtherAreaOption;
	public ServerJoinFrameBone newWin;
	public ServerCreateFrameBone CreateRoomNewWin;
	private JPanel panel;

	void InitOtherWise() {
		OtherAreaUserList = new UserListBonePanel(OtherAreaImg.getImage());
		OtherAreaOption = new OptionBonePanel(OtherAreaImg.getImage());
		newWin = new ServerJoinFrameBone(this);
		newWin.setVisible(false);
		CreateRoomNewWin = new ServerCreateFrameBone(this);
		CreateRoomNewWin.setVisible(false);
	}
	/**
	 * Create the frame.
	 */
	public BodyBone() {
		scrollHeight = 25;
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
		ChatArea.setBackground(Color.DARK_GRAY);
		ChatArea.setBounds(0, 0, 380, 492);
		Dimension size = new Dimension(380, 492);
		ChatArea.setPreferredSize(size);
		
		ChatAreaScroll = new JScrollPane(ChatArea);
		ChatAreaScroll.getVerticalScrollBar().setPreferredSize(new Dimension(6, 0));
		ChatAreaScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		ChatAreaScroll.getVerticalScrollBar().setUnitIncrement(16);
		ChatArea.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(54,54,54));
		Dimension a = new Dimension(100, 20);
		panel.setPreferredSize(new Dimension(200, 20));
		ChatArea.add(panel);
		ChatAreaScroll.setBorder(new CompoundBorder());
		ChatAreaScroll.setBounds(0, 4, 380, 490);
		ChatAreaScroll.setBorder(null);
		ChatAreaScroll.setOpaque(false);
		contentPane.add(ChatAreaScroll);
		
		ChatSendArea = new DrawImage(SendAreaImg.getImage());
		ChatSendArea.setBorder(null);
		ChatSendArea.setBackground(new Color(163,163,163));
		ChatSendArea.setBounds(0, 492, 380, 73);
		contentPane.add(ChatSendArea);
		ChatSendArea.setLayout(null);
		
		
		
		ChatTextArea = new TextAreaEnterSend();
		ChatTextArea.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		ChatTextArea.setBackground(new Color(115,115,115));
		ChatTextArea.setForeground(Color.BLACK);
		ChatTextArea.setLineWrap(true);
		ChatTextArea.setWrapStyleWord(true);
		ChatTextArea.setBorder(null);
		
		ChatSendScroll = new JScrollPane(ChatTextArea);
		ChatSendScroll.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
		ChatSendScroll.setBounds(11, 11, 290, 55);
		ChatSendScroll.setBorder(new CompoundBorder());
		ChatSendArea.add(ChatSendScroll);
		
		
		ChatSendButton = new JButton(SendImg);
		ChatSendButton.setEnabled(false);
		ChatSendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
	@Override
	public void keyTyped(KeyEvent e) {

		}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void SetClient(Client client) {
		this.client = client;
	}
	
	public Client GetClient() {
		return client;
	}
}

