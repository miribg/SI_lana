package bista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArazoOntziKokatu extends JFrame {

	private JPanel contentPane;
	private JTextField mezua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("arazoOntziKokatu --> main");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArazoOntziKokatu frame = new ArazoOntziKokatu();
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
	public ArazoOntziKokatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mezua = new JTextField();
		mezua.setEditable(false);
		mezua.setBounds(5, 53, 432, 86);
		mezua.setText("Arazo bat egon da ontzia kokatzeko orduan. Aukeratu beste gelaxka bat.");
		contentPane.add(mezua);
		mezua.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TableroaBista tab= TableroaBista.getNireTableroa();
				tab.partidaJokatu();	
			}
		});
		btnNewButton.setBounds(5, 233, 432, 25);
		contentPane.add(btnNewButton);
		//btnNewButton.addActionListener(new ActionListener() {

		
	}

}
