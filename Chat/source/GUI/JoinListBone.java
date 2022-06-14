package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JoinListBone extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinListBone frame = new JoinListBone();
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
	public JoinListBone() {
		
		ImageIcon JoinListAreaImg = new ImageIcon("AreaImage/JoinListAreaImage.png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JoinListPanel  panel = new JoinListPanel( JoinListAreaImg.getImage());
		panel.setBounds(28, 29, 319, 25);
		contentPane.add(panel);
		panel.setLayout(null);
		
	
	}
	
	public static class JoinListPanel extends DrawImage{
		public JoinListPanel(Image img) {
			super(img);
			setBackground(Color.GRAY);
			setBounds(380, 34, 330, 25);
			setLayout(null);
			JButton joinButton ;
			JLabel userCountLabel;
			JLabel roomNameLabel;
			
			joinButton = new JButton("\uC785\uC7A5");
			joinButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			joinButton.setForeground(Color.WHITE);
			joinButton.setContentAreaFilled(false);
			joinButton.setFocusPainted(false);
			joinButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
			joinButton.setBackground(new Color(54,54,54));
			joinButton.setBounds(250, 1, 58, 23);
			joinButton.setBorderPainted(false);
			add(joinButton);
			
			userCountLabel = new JLabel("");
			userCountLabel.setForeground(Color.WHITE);
			userCountLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
			userCountLabel.setBounds(220, 0, 39, 25);
			add(userCountLabel);
			
			roomNameLabel = new JLabel("");
			roomNameLabel.setForeground(Color.WHITE);
			roomNameLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
			roomNameLabel.setBounds(12, 0, 190, 25);
			add(roomNameLabel);
			
			setLayout(null);
			
		}
		
		
	}
}
