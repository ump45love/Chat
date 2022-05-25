package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserListBone frame = new UserListBone();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserListBone() {
		ImageIcon ServerCreateImg = new ImageIcon("ButtonImage/ServerCreate.png");
		ImageIcon ServerJoinImg = new ImageIcon("ButtonImage/ServerJoin.png");
		ImageIcon PressedServerCreateImg = new ImageIcon("ButtonImage/PressedServerCreate.png");
		ImageIcon PressedServerJoinImg = new ImageIcon("ButtonImage/PressedServerJoin.png");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 601);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		ImageIcon OtherAreaImg = new ImageIcon("AreaImage/OtherAreaImage.png");
		UserListBonePanel OtherArea = new UserListBonePanel(OtherAreaImg.getImage());
		getContentPane().add(OtherArea);
		OtherArea.setLayout(null);

		contentPane.setLayout(null);
	}
	public static class UserListBonePanel extends DrawImage{
		ImageIcon ServerCreateImg = new ImageIcon("ButtonImage/ServerCreate.png");
		ImageIcon ServerJoinImg = new ImageIcon("ButtonImage/ServerJoin.png");
		ImageIcon PressedServerCreateImg = new ImageIcon("ButtonImage/PressedServerCreate.png");
		ImageIcon PressedServerJoinImg = new ImageIcon("ButtonImage/PressedServerJoin.png");
		public UserListBonePanel(Image img) {
			super(img);
			setBackground(Color.GRAY);
			setBounds(380, 34, 153, 535);
			setLayout(null);
			
			JTextArea UserListTextArea = new JTextArea();
			UserListTextArea.setFont(new Font("Monospaced", Font.BOLD, 13));
			UserListTextArea.setBackground(new Color(178,178,178));
			UserListTextArea.setBounds(12, 10, 129, 446);
			
			JButton ServerJoinButton = new JButton(ServerJoinImg);
			ServerJoinButton.setBounds(10, 502, 136, 23);
			add(ServerJoinButton);
			ServerJoinButton.setForeground(UIManager.getColor("window"));
			ServerJoinButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			ServerJoinButton.setFont(new Font("���� ����", Font.PLAIN, 12));
			ServerJoinButton.setBackground(new Color(174,174,174));
			ServerJoinButton.setBorderPainted(false);
			ServerJoinButton.setPressedIcon(PressedServerJoinImg);
			
			
			JButton ServerCreateButton = new JButton(ServerCreateImg);
			ServerCreateButton.setBounds(10, 469, 136, 23);
			add(ServerCreateButton);
			ServerCreateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			ServerCreateButton.setBackground(new Color(174,174,174));
			ServerCreateButton.setForeground(UIManager.getColor("window"));
			ServerCreateButton.setBorderPainted(false);
			ServerCreateButton.setPressedIcon(PressedServerCreateImg);
			
			add(UserListTextArea);
		}
	}
	
}
