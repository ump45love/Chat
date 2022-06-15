package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerCreateFrameBone extends JDialog {

	private JPanel contentPane;
	public JTextField roomNameField;
	public JTextField roomPasswordField;
	public JButton CreateRoomButton;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ServerCreateFrameBone(JFrame frame){
		super(frame);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 275, 113);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 370, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		roomNameField = new JTextField();
		roomNameField.setBounds(55, 10, 116, 21);
		panel.add(roomNameField);
		roomNameField.setColumns(10);
		
		roomPasswordField = new JTextField();
		roomPasswordField.setBounds(55, 41, 116, 21);
		panel.add(roomPasswordField);
		roomPasswordField.setColumns(10);
		
		CreateRoomButton = new JButton("\uB9CC\uB4E4\uAE30");
		CreateRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CreateRoomButton.setBackground(Color.GRAY);
		CreateRoomButton.setForeground(Color.WHITE);
		CreateRoomButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		CreateRoomButton.setBorderPainted(false);
		CreateRoomButton.setFocusPainted(false);
		CreateRoomButton.setBounds(182, 9, 70, 23);
		panel.add(CreateRoomButton);
		
		lblNewLabel = new JLabel("\uBC29 \uC774\uB984:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel.setBounds(8, 13, 57, 15);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_1.setBounds(0, 44, 57, 15);
		panel.add(lblNewLabel_1);
	}
}
