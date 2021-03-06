package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.ChatAreaInsertBone.ChatInsertBone;
import GUI.JoinListBone.JoinListPanel;
import Network.Client;
import Object.RoomList;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ServerJoinFrameBone extends JDialog {
	  JPanel contentPane;
	  public JPanel panel;
	  Client client;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ServerJoinFrameBone(BodyBone frame) {
		super(frame);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Dimension size = new Dimension(400, 261);
		scrollPane.setPreferredSize(size);
		scrollPane.setBounds(0, 0, 400, 261);
		contentPane.add(scrollPane);
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setPreferredSize(size);
		scrollPane.setViewportView(panel);
		panel.setBackground(Color.GRAY);
		panel.setForeground(Color.GRAY);
	}
	
	public void SetJoinListPanel(ArrayList<RoomList> list,BodyBone bone) {
		getContentPane().removeAll();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Dimension size = new Dimension(400, 261);
		scrollPane.setPreferredSize(size);
		scrollPane.setBounds(0, 0, 400, 261);
		contentPane.add(scrollPane);
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setPreferredSize(size);
		scrollPane.setViewportView(panel);
		panel.setBackground(Color.GRAY);
		panel.setForeground(Color.GRAY);
		
		for(int i = 0; i<list.size(); i++) {
			RoomList data = list.get(i);
			JoinListPanel save = data.getJoinListPanel();
				save.joinButton.addActionListener((e) ->{
				 RoomPasswordBone win = new RoomPasswordBone(data,bone);
					if(data.getPasword().isEmpty()) {
						bone.GetClient().connectRoom(data);
						bone.ChatSendButton.setEnabled(true);
						setVisible(false);
						return;
					}

				setVisible(false);
				win.setVisible(true);
				win.sendButton.addActionListener((a)->{
					if(data.getPasword().equals(win.passwordField.getText())) {
						bone.GetClient().connectRoom(data);
						bone.ChatSendButton.setEnabled(true);
						System.out.println("????"+data.getRoomNumber());
						win.setVisible(false);
					}
					else
						JOptionPane.showMessageDialog(null, "????????!", "????", JOptionPane.WARNING_MESSAGE);
					});
				});
				panel.add(save);
		}
	}

}
