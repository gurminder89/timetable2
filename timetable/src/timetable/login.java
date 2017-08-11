package timetable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frmLogin;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel Studentname = new JLabel("Studentname");
		Studentname.setFont(new Font("Tahoma", Font.BOLD, 14));
		Studentname.setBounds(70, 41, 125, 44);
		frmLogin.getContentPane().add(Studentname);
		
		JLabel StudentID = new JLabel("StudentID");
		StudentID.setFont(new Font("Tahoma", Font.BOLD, 14));
		StudentID.setBounds(70, 116, 125, 35);
		frmLogin.getContentPane().add(StudentID);
		
		textField = new JTextField();
		textField.setBounds(216, 50, 115, 30);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(216, 121, 115, 29);
		frmLogin.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// login code
				if(Studentname.getText().equals("guri") && StudentID.getText().equals("123")) {
					JOptionPane.showMessageDialog(null, "correct credential");
					frmLogin.dispose();
					
					//open the next window
					CourseInfo Obj = new CourseInfo();
					Obj.setVisible(true);
				}
				
			}
		});
		btnNewButton.setBounds(164, 191, 125, 35);
		frmLogin.getContentPane().add(btnNewButton);
	}
}
