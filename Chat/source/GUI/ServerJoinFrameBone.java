package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.ChatAreaInsertBone.ChatInsertBone;
import GUI.JoinListBone.JoinListPanel;
import Network.RoomList;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ServerJoinFrameBone extends JDialog {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ServerJoinFrameBone(JFrame frame) {
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
		ChatInsertBone panelCover = new ChatInsertBone("asdasdasdsads",null,true);
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setPreferredSize(size);
		scrollPane.setViewportView(panel);
		panel.setBackground(Color.GRAY);
		panel.setForeground(Color.GRAY);
		Dimension size2 = new Dimension(330, 25);
	}
	
	public void SetJoinListPanel(ArrayList<RoomList> list) {
		for(int i = 0; i<list.size(); i++) {
			RoomList data = list.get(i);
			contentPane.add(data.getJoinListPanel());
		}
	}

}
