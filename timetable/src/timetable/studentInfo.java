package timetable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class studentInfo extends JFrame {

	private JPanel contentPane;
	
	String COURSE_SYS_ER = "sys Er";
	String COURSE_DATABASE = "dbms";
	String COURSE_PM = "pm";
	String COURSE_SW = "soft";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentInfo frame = new studentInfo(null, null);
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
	public studentInfo(String studentName, String studentId) {
		
		DatabaseHelper databaseHelper = new DatabaseHelper();
		LoginDetails loginDetails = databaseHelper.getLoginDetails(studentName, Integer.parseInt(studentId));
		setTitle("StudentInfo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name\t\t\t");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(33, 24, 89, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(33, 98, 46, -26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Courses");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(117, 131, 89, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(33, 83, 62, 35);
		contentPane.add(lblNewLabel_3);
		
		
		int courseIdCounter = 1;
		
		if(loginDetails.getCourseId1() > 0) {
			JLabel lblNewLabel_4 = new JLabel("course_id" + courseIdCounter);
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_4.setBounds(117, 164, 62, 14);
			contentPane.add(lblNewLabel_4);
			
			JButton btnNewButton_1 = new JButton("show info");
			btnNewButton_1.setBounds(294, 160, 89, 23);
			contentPane.add(btnNewButton_1);
			addActionListenerToPrint(btnNewButton_1, databaseHelper.getCourseName(loginDetails.getCourseId1()), this);
			courseIdCounter++;
		}		
		
		if(loginDetails.getCourseId2() > 0) {
			JLabel lblNewLabel_5 = new JLabel("course_id" + courseIdCounter);
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_5.setBounds(117, 203, 70, 14);
			contentPane.add(lblNewLabel_5);
			
			JButton btnNewButton_2 = new JButton("show info");
			btnNewButton_2.setBounds(294, 199, 89, 23);
			contentPane.add(btnNewButton_2);
			addActionListenerToPrint(btnNewButton_2, databaseHelper.getCourseName(loginDetails.getCourseId2()), this);
			
			courseIdCounter++;
		}
		
		if(loginDetails.getCourseId3() > 0) {
			JLabel lblNewLabel_6 = new JLabel("course_id" + courseIdCounter);
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_6.setBounds(117, 243, 64, 14);
			contentPane.add(lblNewLabel_6);
			
	
			
			JButton btnNewButton_3 = new JButton("show info");
			btnNewButton_3.setBounds(294, 239, 89, 23);
			contentPane.add(btnNewButton_3);
			addActionListenerToPrint(btnNewButton_3, databaseHelper.getCourseName(loginDetails.getCourseId3()), this);
			courseIdCounter++;
		}
		
		if(loginDetails.getCourseId3() > 0) {
			JLabel lblNewLabel_7 = new JLabel("course_id" + courseIdCounter);
			lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_7.setBounds(117, 282, 62, 14);
			contentPane.add(lblNewLabel_7);
			
			JButton btnNewButton_4 = new JButton("show info");
			btnNewButton_4.setBounds(294, 278, 89, 23);
			contentPane.add(btnNewButton_4);
			addActionListenerToPrint(btnNewButton_4, databaseHelper.getCourseName(loginDetails.getCourseId4()), this);
			
			courseIdCounter++;
		}
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 131, 424, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_8 = new JLabel(loginDetails.getStudentName());
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_8.setBounds(198, 24, 137, 35);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(loginDetails.getStudentId() + "");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_9.setBounds(198, 82, 96, 35);
		contentPane.add(lblNewLabel_9);
	}
	
	private void addActionListenerToPrint(JButton printButton, String courseName, JFrame studentInfoFrame) {
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// write the condition here

				//contentPane.setVisible(false);
//				JDialog dialog = new JDialog(studentInfoFrame);
//				dialog.setContentPane(new CourseInfo(courseName).getContentPane());
//				//CourseInfo obj = new CourseInfo(courseName);
//				//obj.setVisible(true);
//				dialog.setVisible(true);
				
				
				final JDialog popUp = new JDialog(studentInfoFrame, "Course Info", true);
				popUp.setMinimumSize(new Dimension(600,  600));
				popUp.getContentPane().add(new CourseInfo(courseName, popUp).getContentPane());
				popUp.pack();
				popUp.setVisible(true);

			}
		});

}
}
