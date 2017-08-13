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
import javax.swing.JSeparator;

public class login {

	private JFrame frmLogin;
	private JTextField textStudentname;
	private JTextField textStudentID;

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
		
		textStudentname = new JTextField();
		textStudentname.setBounds(216, 50, 115, 30);
		frmLogin.getContentPane().add(textStudentname);
		textStudentname.setColumns(10);
		
		textStudentID = new JTextField();
		textStudentID.setBounds(216, 121, 115, 29);
		frmLogin.getContentPane().add(textStudentID);
		textStudentID.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// login code
				DatabaseHelper databaseHelper = new DatabaseHelper();
				if(databaseHelper.getLoginDetails(textStudentname.getText(), Integer.parseInt(textStudentID.getText())) != null) {
					JOptionPane.showMessageDialog(null, "correct credential");
					frmLogin.dispose();
					
					////open the next window
					studentInfo Obj = new studentInfo();
					Obj.setVisible(true);
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect credential. Please try again");
				}
				
			}
		});
		btnNewButton.setBounds(195, 201, 125, 35);
		frmLogin.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 192, 398, -2);
		frmLogin.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(36, 192, 388, -2);
		frmLogin.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(26, 192, 398, 2);
		frmLogin.getContentPane().add(separator_2);
	}
}
