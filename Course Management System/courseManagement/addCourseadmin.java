package courseManagement;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JTable;

public class addCourseadmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField CourseName;
	private JTextField l4m1;
	private JTextField l4m2;
	private JTextField l4m3;
	private JTextField textField_15;
	private JTextField l5m2;
	private JTextField l5m3;
	private JTextField l6m1;
	private JTextField l6m2;
	private JTextField l6m3;
	private JTextField l5m1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addCourseadmin frame = new addCourseadmin();
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
	public addCourseadmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 820);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(8, 10, 790, 790);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(199, 83, 583, 685);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		CourseName = new JTextField();
		CourseName.setBounds(275, 158, 120, 30);
		CourseName.setColumns(10);
		panel_2.add(CourseName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Course name");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(103, 150, 120, 40);
		panel_2.add(lblNewLabel_1_1);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 240));
		panel_4.setBounds(8, 294, 567, 271);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Level 4");
		lblNewLabel_2.setBackground(SystemColor.controlShadow);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(120, 10, 100, 47);
		panel_4.add(lblNewLabel_2);
		
		l5m1 = new JTextField();
		l5m1.setBounds(120, 75, 140, 30);
		panel_4.add(l5m1);
		l5m1.setColumns(10);
		
		l5m2 = new JTextField();
		l5m2.setBounds(120, 140, 140, 30);
		panel_4.add(l5m2);
		l5m2.setColumns(10);
		
		l5m3 = new JTextField();
		l5m3.setBounds(120, 205, 140, 30);
		panel_4.add(l5m3);
		l5m3.setColumns(10);
		
		l6m1 = new JTextField();
		l6m1.setBounds(270, 75, 140, 30);
		panel_4.add(l6m1);
		l6m1.setColumns(10);
		
		l6m2 = new JTextField();
		l6m2.setBounds(270, 140, 140, 30);
		panel_4.add(l6m2);
		l6m2.setColumns(10);
		
		l6m3 = new JTextField();
		l6m3.setBounds(270, 205, 140, 30);
		panel_4.add(l6m3);
		l6m3.setColumns(10);
		
		l4m1 = new JTextField();
		l4m1.setBounds(420, 75, 140, 30);
		panel_4.add(l4m1);
		l4m1.setColumns(10);
		
		l4m2 = new JTextField();
		l4m2.setBounds(420, 140, 140, 30);
		panel_4.add(l4m2);
		l4m2.setColumns(10);
		
		l4m3 = new JTextField();
		l4m3.setBounds(420, 205, 140, 30);
		panel_4.add(l4m3);
		l4m3.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Level 5");
		lblNewLabel_2_1.setBackground(SystemColor.controlShadow);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(270, 10, 118, 47);
		panel_4.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Level 6");
		lblNewLabel_2_1_1.setBackground(SystemColor.controlShadow);
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(420, 10, 125, 47);
		panel_4.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Module 1");
		lblNewLabel_3.setBackground(new Color(100, 149, 237));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setBounds(8, 75, 104, 30);
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Module 2");
		lblNewLabel_3_1.setBackground(SystemColor.controlShadow);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(8, 140, 105, 30);
		panel_4.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Module 3");
		lblNewLabel_3_2.setBackground(SystemColor.controlShadow);
		lblNewLabel_3_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3_2.setBounds(8, 205, 105, 30);
		panel_4.add(lblNewLabel_3_2);
		
		
		
		JButton btnNewButton_7 = new JButton("Add");
		
		btnNewButton_7.setBackground(SystemColor.info);
		btnNewButton_7.setBackground(new Color(100, 149, 237));
		btnNewButton_7.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton_7.setBounds(177, 575, 150, 57);
		panel_2.add(btnNewButton_7);
		
		JLabel lblNewLabel_1 = new JLabel("Write Course name for editting");
		lblNewLabel_1.setFont(new Font("Andy", Font.BOLD, 30));
		lblNewLabel_1.setBounds(83, 10, 379, 72);
		panel_2.add(lblNewLabel_1);
		btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCourseOperation();
            }

			
			
        });



		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(8, 83, 183, 685);
		panel_1.setBackground(SystemColor.controlShadow);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-dashboard-30.png")));
		btnNewButton.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setBounds(8, 100, 165, 55);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Courses");
		btnNewButton_1.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-courses-30.png")));
		btnNewButton_1.setBackground(SystemColor.info);
		btnNewButton_1.setBounds(8, 180, 165, 55);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Tutors");
		btnNewButton_2.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-training-30.png")));
		btnNewButton_2.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_2.setBackground(SystemColor.info);
		btnNewButton_2.setBounds(8, 260, 165, 55);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Students");
		btnNewButton_3.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-auditorium-30.png")));
		btnNewButton_3.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_3.setBackground(SystemColor.info);
		btnNewButton_3.setBounds(8, 340, 165, 55);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Mail");
		btnNewButton_4.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-mail-30.png")));
		btnNewButton_4.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_4.setBackground(SystemColor.info);
		btnNewButton_4.setBounds(8, 420, 165, 55);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Settings");
		btnNewButton_5.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-setting-30-removebg-preview.png")));
		btnNewButton_5.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_5.setBackground(SystemColor.info);
		btnNewButton_5.setBounds(8, 500, 165, 55);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Logout");
		btnNewButton_6.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-logout-30.png")));
		btnNewButton_6.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_6.setBackground(SystemColor.info);
		btnNewButton_6.setBounds(8, 580, 165, 55);
		panel_1.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup();
			}
		});
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(8, 10, 774, 63);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Welcome to the SYSTEM");
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-course-assign-50.png")));
		lblNewLabel.setFont(new Font("Forte", Font.PLAIN, 30));
		lblNewLabel.setBounds(136, 10, 435, 48);
		panel_3.add(lblNewLabel);
		setLocationRelativeTo(null);
	}
	
	 private void signup() {
	        int result = JOptionPane.showConfirmDialog(
	                null,
	                "Are you sure you want to logout?",
	                "Logout",
	                JOptionPane.YES_NO_OPTION
	        );

	        if (result == JOptionPane.YES_OPTION) {
	            dispose();
	            CourseManagement a = new CourseManagement();
	            a.setVisible(true);
	        }
}	
	 
	 private void addCourseOperation() {
			// TODO Auto-generated method stub
			
		        // Check if any module fields are empty
		        if (l4m1.getText().trim().isEmpty() || l4m2.getText().trim().isEmpty() || l4m3.getText().trim().isEmpty() ||
		                l5m1.getText().trim().isEmpty() || l5m2.getText().trim().isEmpty() || l5m3.getText().trim().isEmpty() ||
		                l6m1.getText().trim().isEmpty() || l6m2.getText().trim().isEmpty() || l6m3.getText().trim().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
		        } else {
		            String url = "jdbc:mysql://localhost:3306/cms";
		            String username1 = "root";
		            String password1 = "";
		            Connection con;

		            try {
		                con = DriverManager.getConnection(url, username1, password1);
		                Statement st = con.createStatement();

		                String courseName = CourseName.getText().trim();
		                String l4m1a = l4m1.getText().trim();
		                String l4m2a = l4m2.getText().trim();
		                String l4m3a = l4m3.getText().trim();
		                String l5m1a = l5m1.getText().trim();
		                String l5m2a = l5m2.getText().trim();
		                String l5m3a = l5m3.getText().trim();
		                String l6m1a = l6m1.getText().trim();
		                String l6m2a = l6m2.getText().trim();
		                String l6m3a = l6m3.getText().trim();

		                // Check if the Course exists
		                String checkQuery = "SELECT * FROM courses WHERE `Course Name` = '" + courseName + "'";
		                ResultSet resultSet = st.executeQuery(checkQuery);

		                if (resultSet.next()) {
		                    // Course exists, update the modules
		                    String updateQuery = "UPDATE courses SET " +
		                            "`Level 4 module1` = '" + l4m1a + "', " +
		                            "`Level 4 module2` = '" + l4m2a + "', " +
		                            "`Level 4 module3` = '" + l4m3a + "', " +
		                            "`Level 5 module1` = '" + l5m1a + "', " +
		                            "`Level 5 module2` = '" + l5m2a + "', " +
		                            "`Level 5 module3` = '" + l5m3a + "', " +
		                            "`Level 6 module1` = '" + l6m1a + "', " +
		                            "`Level 6 module2` = '" + l6m2a + "', " +
		                            "`Level 6 module3` = '" + l6m3a + "' " +
		                            "WHERE `Course Name` = '" + courseName + "'";

		                    int rowsAffected = st.executeUpdate(updateQuery);

		                    if (rowsAffected > 0) {
		                        JOptionPane.showMessageDialog(null, "Modules updated Successfully!!!");
		                        dispose();
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Failed to update modules!!!");
		                    }
		                } else {
		                    JOptionPane.showMessageDialog(null, "Course with this Course Name does not exist.");
		                }

		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    
		}
}
