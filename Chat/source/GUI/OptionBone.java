package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class OptionBone extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionBone frame = new OptionBone();
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
	public OptionBone() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 601);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		ImageIcon OtherAreaImg = new ImageIcon("AreaImage/OtherAreaImage.png");
		DrawImage OtherArea = new DrawImage(OtherAreaImg.getImage());
		OtherArea.setBackground(Color.GRAY);
		getContentPane().add(OtherArea);
		OtherArea.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(12, 132, 97, 23);
		OtherArea.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(12, 221, 97, 23);
		OtherArea.add(btnNewButton_1);
		contentPane.setLayout(null);
	}
	
	public static class OptionBonePanel extends DrawImage{
		public OptionBonePanel(Image img) {
			super(img);
			setBackground(Color.GRAY);
			setBounds(380, 34, 153, 535);
			setLayout(null);
			
			JButton btnNewButton = new JButton("New button");
			btnNewButton.setBounds(12, 132, 97, 23);
			add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("New button");
			btnNewButton_1.setBounds(12, 221, 97, 23);
			add(btnNewButton_1);
		}
		
		
	}
}
