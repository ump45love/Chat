package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.JoinListBone.JoinListPanel;

import java.awt.FlowLayout;
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
		ImageIcon JoinListAreaImg = new ImageIcon("AreaImage/JoinListAreaImage.png");
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
		JoinListPanel a = new JoinListPanel(JoinListAreaImg.getImage());
		JoinListPanel a1 = new JoinListPanel(JoinListAreaImg.getImage());
		JoinListPanel a2 = new JoinListPanel(JoinListAreaImg.getImage());
		JoinListPanel a3 = new JoinListPanel(JoinListAreaImg.getImage());
		JoinListPanel a4 = new JoinListPanel(JoinListAreaImg.getImage());
		JoinListPanel a5 = new JoinListPanel(JoinListAreaImg.getImage());
		JoinListPanel a6 = new JoinListPanel(JoinListAreaImg.getImage());
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setPreferredSize(size);
		scrollPane.setViewportView(panel);
		panel.setBackground(Color.GRAY);
		panel.setForeground(Color.GRAY);
		Dimension size2 = new Dimension(330, 25);
		a.setPreferredSize(size2);
		panel.add(a);
		panel.add(a1);
		panel.add(a2);
		panel.add(a3);
		panel.add(a4);
		panel.add(a5);
		panel.add(a6);
	}

}
