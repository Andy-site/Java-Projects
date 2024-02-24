package courseManagement;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JTable;
import javax.swing.JEditorPane;

public class Dashboard1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard1 frame = new Dashboard1();
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
	public Dashboard1() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Total Courses");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBackground(SystemColor.inactiveCaption);
		lblNewLabel_1.setFont(new Font("Andy", Font.BOLD, 25));
		lblNewLabel_1.setBounds(130, 25, 246, 103);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Total Students");
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_1.setBackground(SystemColor.inactiveCaption);
		lblNewLabel_1_1.setFont(new Font("Andy", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(130, 154, 275, 97);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Total Tutors");
		lblNewLabel_1_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_2.setBackground(SystemColor.inactiveCaption);
		lblNewLabel_1_2.setFont(new Font("Andy", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(130, 274, 257, 112);
		panel_2.add(lblNewLabel_1_2);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-folder-40.png")));
		btnNewButton_7.setBackground(SystemColor.info);
		btnNewButton_7.setFont(new Font("Andy", Font.BOLD, 25));
		btnNewButton_7.setBounds(300, 73, 65, 45);
		panel_2.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fetch and display course details
                displayData("SELECT `Course Name`,`Level 4 module1`,`Level 4 module2`,`Level 4 module3`,`Level 5 module1`,`Level 5 module2`,`Level 5 module3`,`Level 6 module1`,`Level 6 module2`,`Level 6 module3` FROM courses");
            }
        });
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-folder-40.png")));
		btnNewButton_8.setFont(new Font("Andy", Font.BOLD, 25));
		btnNewButton_8.setBackground(SystemColor.info);
		btnNewButton_8.setBounds(300, 187, 65, 45);
		panel_2.add(btnNewButton_8);
		btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fetch and display course details
                displayData("SELECT `Student-id`,Username,Mail,Address,`Course Name` FROM student");
            }
        });
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-folder-40.png")));
		btnNewButton_9.setFont(new Font("Andy", Font.BOLD, 25));
		btnNewButton_9.setBackground(SystemColor.info);
		btnNewButton_9.setBounds(300, 307, 65, 45);
		panel_2.add(btnNewButton_9);
		btnNewButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fetch and display course details
                displayData("SELECT `tutor-id`,Username, Mail, Address FROM tutor ");
            }
        });
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 420, 557, 241);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel tutor = new JLabel("0");
		tutor.setFont(new Font("Andy", Font.BOLD, 30));
		tutor.setBounds(175, 311, 45, 45);
		panel_2.add(tutor);
		int tutorCount = gettutorCount();
	      tutor.setText(Integer.toString(tutorCount));
		
		
		JLabel student = new JLabel("0");
		student.setFont(new Font("Andy", Font.BOLD, 30));
		student.setBounds(175, 196, 45, 45);
		panel_2.add(student);
		int studentCount = getStudentCount();
  	  	student.setText(Integer.toString(studentCount));
		
		JLabel course = new JLabel("0");
		course.setFont(new Font("Andy", Font.BOLD, 30));
		course.setBounds(175, 61, 45, 45);
		panel_2.add(course);
		int coursecount = getcourseCount();
	      course.setText(Integer.toString(coursecount));
	      
	    
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlShadow);
		panel_1.setBounds(8, 83, 183, 685);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-dashboard-30.png")));
		btnNewButton.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setBounds(8, 100, 165, 55);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Courses");
		
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Check user type and redirect accordingly
                String userType = CourseManagement.getloggedInUserMode();
                if ("student".equalsIgnoreCase(userType)) {
                    // Redirect student to student courses page
                    openStudentCoursesPage();
                } else {
                    // Display invalid option for other user types
                    JOptionPane.showMessageDialog(null, "Invalid option for your user type.");
                }
            }

			private void openStudentCoursesPage() {
				// TODO Auto-generated method stub
				dispose();
				new stucourses().setVisible(true);
			}
        });
        btnNewButton_1.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
        btnNewButton_1.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-courses-30.png")));
        btnNewButton_1.setBackground(SystemColor.info);
        btnNewButton_1.setBounds(8, 180, 165, 55);
        panel_1.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-courses-30.png")));
		btnNewButton_1.setBackground(SystemColor.info);
		btnNewButton_1.setBounds(8, 180, 165, 55);
		panel_1.add(btnNewButton_1);
		
		
		JButton btnNewButton_5 = new JButton("Settings");
		
	    btnNewButton_5.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            opensetting();
	        }

	        private void opensetting() {
	            // Get the logged-in user mode
	            String userMode =CourseManagement.getloggedInUserMode();

	            // Check the user mode and open the corresponding Setting frame
	            if ("student".equalsIgnoreCase(userMode)) {
	            	dispose();
	                new Settingstudent().setVisible(true);
	            } else if ("Tutor".equalsIgnoreCase(userMode)) {
	            	dispose();
	                new Setting().setVisible(true);
	            } else {
	                // Handle the case when the user mode is unknown
	                System.out.println("Unknown user mode");
	            }
	        }
	    });

		
		btnNewButton_5.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-setting-30-removebg-preview.png")));
		btnNewButton_5.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_5.setBackground(SystemColor.info);
		btnNewButton_5.setBounds(8, 262, 165, 55);
		panel_1.add(btnNewButton_5);
		
		
		JButton btnNewButton_6 = new JButton("Logout");
		btnNewButton_6.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-logout-30.png")));
		btnNewButton_6.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_6.setBackground(SystemColor.info);
		btnNewButton_6.setBounds(8, 337, 165, 55);
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

	    void displayData(String query) {
	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "");
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {

	            // Assuming your table model is DefaultTableModel
	            // You may need to customize this based on your actual table model
	            DefaultTableModel model = new DefaultTableModel();
	            table.setModel(model);

	            // Get column names
	            int columnCount = resultSet.getMetaData().getColumnCount();
	            for (int i = 1; i <= columnCount; i++) {
	                model.addColumn(resultSet.getMetaData().getColumnName(i));
	            }

	            // Get data
	            while (resultSet.next()) {
	                Object[] rowData = new Object[columnCount];
	                for (int i = 1; i <= columnCount; i++) {
	                    rowData[i - 1] = resultSet.getObject(i);
	                }
	                model.addRow(rowData);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(Dashboard1.this, "Error fetching data.");
	        }
	    }
	    
	    
	    private int gettutorCount() {
	        int tutorCount = 0;

	        // JDBC connection parameters
	    	String Username = "root";
	    	String Passwords = "";
	    	String url = "jdbc:mysql://localhost:3306/cms";

	        // JDBC variables
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            // Connect to the database
	            connection = DriverManager.getConnection(url, Username, Passwords);

	            // SQL query to get the count of students
	            String query = "SELECT COUNT(*) FROM tutor";
	            preparedStatement = connection.prepareStatement(query);
	            resultSet = preparedStatement.executeQuery();

	            // Retrieve the count from the result set
	            if (resultSet.next()) {
	                tutorCount = resultSet.getInt(1);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close JDBC resources in the reverse order of their creation
	            try {
	                if (resultSet != null) resultSet.close();
	                if (preparedStatement != null) preparedStatement.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return tutorCount;
	    }
	    
	    
	    
	    private int getStudentCount() {
			// TODO Auto-generated method stub
	    	int studentCount = 0;

	        // JDBC connection parameters
	    	String Username = "root";
	    	String Passwords = "";
	    	String url = "jdbc:mysql://localhost:3306/cms";

	        // JDBC variables
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            // Connect to the database
	            connection = DriverManager.getConnection(url, Username, Passwords);

	            // SQL query to get the count of students
	            String query = "SELECT COUNT(*) FROM student";
	            preparedStatement = connection.prepareStatement(query);
	            resultSet = preparedStatement.executeQuery();

	            // Retrieve the count from the result set
	            if (resultSet.next()) {
	                studentCount = resultSet.getInt(1);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close JDBC resources in the reverse order of their creation
	            try {
	                if (resultSet != null) resultSet.close();
	                if (preparedStatement != null) preparedStatement.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return studentCount;
		}
	    
	    
	    private int getcourseCount() {
		// TODO Auto-generated method stub
    	int courseCount = 0;

        // JDBC connection parameters
    	String Username = "root";
    	String Passwords = "";
    	String url = "jdbc:mysql://localhost:3306/cms";

        // JDBC variables
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Connect to the database
            connection = DriverManager.getConnection(url, Username, Passwords);

            // SQL query to get the count of students
            String query = "SELECT COUNT(*) FROM courses";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            // Retrieve the count from the result set
            if (resultSet.next()) {
                courseCount = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close JDBC resources in the reverse order of their creation
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return courseCount;
	    }
}
