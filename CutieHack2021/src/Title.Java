import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Title extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Title frame = new Title();
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
	public Title() {
		String text;
		String[] Desc2, Desc3;
		Main parsing = new Main();
		Movie test = new Movie();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 1331, 796);
		contentPane = new JPanel();
		contentPane.setToolTipText("\\");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 JPanel result = new JPanel();
		result.setLayout(null);
		JLabel lblNewLabel = new JLabel("Movie and TV Show Searcher");
		lblNewLabel.setBounds(280, 30, 537, 300);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter in a Movie or TV Show");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(150, 100, 537, 300);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbl2 = new JLabel();
		lbl2.setBounds(74, 150, 637, 352);
		JLabel lbl3 = new JLabel(), lbl4 = new JLabel(), lbl5 = new JLabel();
		lbl3.setBounds(74, 250, 637, 300); 
		lbl4.setBounds(74, 400, 737, 300); 
		lbl5.setBounds(84, 500, 837, 300); 
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField = new JTextField();
		textField.setBounds(316, 203, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setBounds(74, 100, 537, 300);
				ArrayList<MovieEntry> movies = null;
				try {
					movies = parsing.main(textField.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField.setVisible(false);
				/*
				Desc1 = movies.get(0).services.toArray(Desc1);
				Desc2 = movies.get(1).services.toArray(Desc2);
				Desc3 = movies.get(2).services.toArray(Desc3);
				Desc4 = movies.get(3).services.toArray(Desc4);
				*/
				lblNewLabel_1.setText("<html>"+movies.get(0).movieName + "<br/>" + movies.get(0).services.get(0) + "<br/>" + movies.get(1).services.get(1) + "<html>");
				lbl2.setText("<html>"+movies.get(1).movieName + "<br/>" + movies.get(1).services.get(0) + "<br/>"+ movies.get(1).services.get(1) + "<html>");
				lbl3.setText("<html>"+movies.get(2).movieName + "<br/>" +movies.get(2).services.get(0) + "<br/>" + movies.get(2).services.get(1) + "<html>");
				//lbl4.setText("<html>"+movies.get(3).movieName + "<br/>" + movies.get(3));
				lblNewLabel.setBounds(74, 50, 537, 300);
				lblNewLabel.setText("Results:");
				contentPane.add(lbl2);
				contentPane.add(lbl3);
				contentPane.add(lbl4);
				btnNewButton.setVisible(false);
			
				System.out.println("HERE HRER HERE HERE HERE" + movies.get(0));
			}
		});
		btnNewButton.setBounds(316, 240, 89, 23);
		contentPane.add(btnNewButton);
	}
}
