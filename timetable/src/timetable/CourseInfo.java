package timetable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseInfo frame = new CourseInfo(null, null);
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
	public CourseInfo(String courseName, JDialog popUp) {
		
		DatabaseHelper databaseHelper = new DatabaseHelper();
		
		CourseData courseData = databaseHelper.getCourseDate(courseName);
		
		setTitle("CourseInfo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBounds(341, 303, 89, 23);
		contentPane.add(btnNewButton);
		addCloseActionListener(btnNewButton, this, popUp);
		
		JLabel lblNewLabel = new JLabel("Subject");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(34, 23, 83, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(34, 66, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Teacher");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(34, 115, 95, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Time1");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(34, 174, 95, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Time2");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(34, 218, 95, 23);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Time3");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(34, 262, 95, 23);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblSubject = new JLabel(courseData.getSubject());
		lblSubject.setBounds(129, 28, 46, 14);
		contentPane.add(lblSubject);
		
		JLabel lblId = new JLabel(courseData.getId());
		lblId.setBounds(129, 67, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblTeacher = new JLabel(courseData.getTeacher());
		lblTeacher.setBounds(129, 121, 46, 14);
		contentPane.add(lblTeacher);
		
		JLabel lblTime = new JLabel(courseData.getTime1());
		lblTime.setBounds(129, 180, 254, 14);
		contentPane.add(lblTime);
		
		JLabel lblTime_1 = new JLabel(courseData.getTime2());
		lblTime_1.setBounds(129, 224, 264, 17);
		contentPane.add(lblTime_1);
		
		JLabel lblTime_2 = new JLabel(courseData.getTime3());
		lblTime_2.setBounds(129, 268, 269, 17);
		contentPane.add(lblTime_2);
	}

	private void addCloseActionListener(JButton btnNewButton, JFrame frame, JDialog popUp) {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frame.setVisible(false);
				contentPane.setVisible(false);
				popUp.dispose();
				//System.exit(0);
			}
		});
		
	}
}
