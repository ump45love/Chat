package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.JoinListBone.JoinListPanel;
import Object.RoomList;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RoomPasswordBone extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private RoomList data;
	public JButton sendButton;
	public JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RoomPasswordBone dialog = new RoomPasswordBone(null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RoomPasswordBone(RoomList data,JFrame frame) {
		super(frame);
		this.data = data;
		setBounds(100, 100, 301, 69);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 285, 30);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uC785\uB825:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		lblNewLabel.setBounds(12, 6, 86, 15);
		panel.add(lblNewLabel);
		
		passwordField = new JTextField();
		passwordField.setBounds(96, 5, 116, 21);
		panel.add(passwordField);
		passwordField.setColumns(10);
		
		sendButton = new JButton("\uD655\uC778");
		sendButton.setBackground(Color.GRAY);
		sendButton.setForeground(Color.WHITE);
		sendButton.setBounds(220, 4, 60, 23);
		sendButton.setContentAreaFilled(false);
		panel.add(sendButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		}
	}
}
