package courseManagement;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JEditorPane;

public class Student extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
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
	public Student() {
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
		
		JScrollPane StuTable = new JScrollPane();
		StuTable.setBounds(8, 467, 567, 172);
		panel_2.add(StuTable);
		
		table = new JTable();
		StuTable.setViewportView(table);
		
		JButton Viewdetails = new JButton("View Student Details");
		Viewdetails.setBackground(SystemColor.info);
//		

		
		Viewdetails.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	refreshStudentDetails();
		    }
		});

		
		Viewdetails.setFont(new Font("Andy", Font.BOLD, 25));
		Viewdetails.setBounds(125, 224, 301, 50);
		panel_2.add(Viewdetails);
		
		JButton btnNewButton_7 = new JButton("Add ??");
		btnNewButton_7.setBackground(SystemColor.info);
		btnNewButton_7.setForeground(SystemColor.desktop);
		btnNewButton_7.setFont(new Font("Andy", Font.BOLD, 25));
		btnNewButton_7.setBounds(41, 112, 158, 71);
		panel_2.add(btnNewButton_7);
		
	    btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call a method to handle adding a new student
                addStudent();
            }
        });
		
		
		JButton btnNewButton_8 = new JButton("Delete ??");
		btnNewButton_8.setBackground(SystemColor.info);
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ask user for student username
                String studentIDToDelete = JOptionPane.showInputDialog("Enter Student ID to delete:");

                if (studentIDToDelete != null) {
                    int result = JOptionPane.showConfirmDialog(
                            null,
                            "Are you sure you want to delete the student with ID '" + studentIDToDelete + "'?",
                            "Delete Student",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (result == JOptionPane.YES_OPTION) {
                        deleteStudent(studentIDToDelete);
                        JOptionPane.showMessageDialog(null, "Student deleted successfully!");
                        // Refresh the table or perform any other necessary updates
                        refreshStudentDetails();
                    }
                }
            }
        });
        btnNewButton_8.setFont(new Font("Andy", Font.BOLD, 25));
        btnNewButton_8.setBounds(376, 112, 158, 71);
        panel_2.add(btnNewButton_8);
        
        
        JLabel lblNewLabel_1 = new JLabel("Search ");
        lblNewLabel_1.setIcon(new ImageIcon(Student.class.getResource("/image/icons8-search-30.png")));
        lblNewLabel_1.setFont(new Font("Andy", Font.BOLD, 20));
        lblNewLabel_1.setBounds(197, 409, 109, 29);
        panel_2.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Do you want to add or delete!!");
        lblNewLabel_2.setFont(new Font("Andy", Font.BOLD, 30));
        lblNewLabel_2.setBounds(93, 21, 373, 81);
        panel_2.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("OR");
        lblNewLabel_2_1.setFont(new Font("Andy", Font.BOLD, 30));
        lblNewLabel_2_1.setBounds(263, 117, 91, 59);
        panel_2.add(lblNewLabel_2_1);
        
        
        JEditorPane editorPane = new JEditorPane();
        editorPane.setBackground(SystemColor.textHighlightText);
        editorPane.setBounds(327, 409, 207, 30);
        panel_2.add(editorPane);
        


        editorPane.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTable();
            }

            private void updateTable() {
                String searchText = editorPane.getText().trim();
                populateTable(searchText);
            }
        });
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlShadow);
		panel_1.setBounds(8, 83, 183, 685);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        		openDashboard();
		        	}
		        	public void openDashboard() {
		        		dispose();
		        		new Dashboard().setVisible(true);
		        	}
			
		});
		btnNewButton.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-dashboard-30.png")));
		btnNewButton.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setBounds(8, 100, 165, 55);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Courses");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Viewcourse().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-courses-30.png")));
		btnNewButton_1.setBackground(SystemColor.info);
		btnNewButton_1.setBounds(8, 180, 165, 55);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Tutors");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Tutor().setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-training-30.png")));
		btnNewButton_2.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_2.setBackground(SystemColor.info);
		btnNewButton_2.setBounds(8, 260, 165, 55);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Students");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Student().setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-auditorium-30.png")));
		btnNewButton_3.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_3.setBackground(SystemColor.info);
		btnNewButton_3.setBounds(8, 340, 165, 55);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Mail");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            // Open the default web browser with the Gmail inbox URL
		            Desktop.getDesktop().browse(new URI("https://mail.google.com/mail/u/0/?tab=om#inbox"));
		        } catch (Exception ex) {
		            // Handle any exceptions that may occur
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-mail-30.png")));
		btnNewButton_4.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_4.setBackground(SystemColor.info);
		btnNewButton_4.setBounds(8, 420, 165, 55);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Settings");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Settingadmin().setVisible(true);
			}
		});
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
	 
	 
	    private void addStudent() {
	        // Create a dialog to input new student details
	        JPanel panel = new JPanel(new GridLayout(6, 2));

	        JTextField usernameField = new JTextField();
	        JTextField mailField = new JTextField();
	        JTextField passwordField = new JTextField();
	        JTextField addressField = new JTextField();
	        JTextField courseField = new JTextField();

	        panel.add(new JLabel("Username:"));
	        panel.add(usernameField);
	        panel.add(new JLabel("Mail:"));
	        panel.add(mailField);
	        panel.add(new JLabel("Password:"));
	        panel.add(passwordField);
	        panel.add(new JLabel("Address:"));
	        panel.add(addressField);
	        panel.add(new JLabel("Course:"));
	        panel.add(courseField);

	        int result = JOptionPane.showConfirmDialog(
	                null,
	                panel,
	                "Add New Student",
	                JOptionPane.OK_CANCEL_OPTION
	        );

	        if (result == JOptionPane.OK_OPTION) {
	            String username = usernameField.getText();
	            String mail = mailField.getText();
	            String password = passwordField.getText();
	            String address = addressField.getText();
	            String course = courseField.getText();

	            // Validate the input if needed

	            // Add the new student to the database
	            addStudentToDatabase(username, mail, password, address, course);

	            // Refresh the student table or perform any other necessary updates
	            refreshStudentDetails();
	        }
	    }

	    private void addStudentToDatabase(String username, String mail, String password, String address, String course) {
	        Connection con;
	        String Username = "root";
	        String Passwords = "";
	        String url = "jdbc:mysql://localhost:3306/cms";

	        try {
	            // Load the MySQL JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Making the connection
	            con = DriverManager.getConnection(url, Username, Passwords);

	            Statement st = con.createStatement();
	            String insertQuery = "INSERT INTO signup (Username, Mail, `Set Password`, Address, Mode, `Course Name`) " +
	                    "VALUES ('" + username + "', '" + mail + "', '" + password + "', '" + address + "', 'Student', '" + course + "')";

	            st.executeUpdate(insertQuery);

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace(); // or log the exception
	        }
	    }
	 private void deleteStudent(String username) {
	        Connection con;
	        String Username = "root";
	        String Passwords = "";
	        String url = "jdbc:mysql://localhost:3306/cms";

	        try {
	            // Load the MySQL JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Making the connection
	            con = DriverManager.getConnection(url, Username, Passwords);

	            Statement st = con.createStatement();
	            String deleteQuery = "DELETE FROM student WHERE `Student-id` = '" + username + "'";
	            st.executeUpdate(deleteQuery);

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace(); // or log the exception
	        }
	    }
	 private void refreshStudentDetails() {
	        Connection con;
	        String Username = "root";
	        String Passwords = "";
	        String url = "jdbc:mysql://localhost:3306/cms";

	        try {
	            // Load the MySQL JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Making the connection
	            con = DriverManager.getConnection(url, Username, Passwords);

	            Statement st = con.createStatement();
	            String selectQuery = "SELECT `Student-id`,Username, Mail, `Set Password`, Address,  `Course Name` FROM student ";
	            ResultSet rs = st.executeQuery(selectQuery);

	            // Method for getData from the database.
	            ResultSetMetaData rsmd = rs.getMetaData();

	            // Created a DefaultTableModel object
	            DefaultTableModel mode = new DefaultTableModel();
	            int columnCount = rsmd.getColumnCount();

	            // Using for loop to add the columns
	            for (int i = 1; i <= columnCount; i++) {
	                mode.addColumn(rsmd.getColumnName(i));
	            }

	            while (rs.next()) {
	                Object[] row = new Object[columnCount];

	                // For loop to count the rows
	                for (int i = 1; i <= columnCount; i++) {
	                    row[i - 1] = rs.getObject(i);
	                }

	                mode.addRow(row);
	            }

	            // Set the model for the existing table
	            table.setModel(mode);

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace(); // or log the exception
	        }
	    }
	 
	 private void populateTable(String searchText) {
		    // Assuming columnNames is an array representing your column names
		    String[] columnNames = {"Student-id", "Username", "Mail", "Address", "Course Name"};

		    // Create a DefaultTableModel
		    DefaultTableModel model = new DefaultTableModel(null, columnNames);

		    // Fetch data from the database and populate the model
		    fetchDataFromDatabase(model, searchText);

		    // Set the model to your JTable
		    table.setModel(model);
		}

		private void fetchDataFromDatabase(DefaultTableModel model, String searchText) {
		    // JDBC connection parameters
		    String url = "jdbc:mysql://localhost:3306/cms";
		    String username = "root";
		    String password = "";

		    try (Connection con = DriverManager.getConnection(url, username, password)) {
		        String query = "SELECT * FROM student WHERE Username LIKE ?";
		        try (PreparedStatement pst = con.prepareStatement(query)) {
		            pst.setString(1, "%" + searchText + "%");

		            try (ResultSet rs = pst.executeQuery()) {
		                while (rs.next()) {
		                    // Assuming your columns are: Student-id, Username, Mail, Address, Course Name
		                    int studentId = rs.getInt("Student-id");
		                    String usernameFromDB = rs.getString("Username");
		                    String mail = rs.getString("Mail");
		                    String address = rs.getString("Address");
		                    String courseName = rs.getString("Course Name");

		                    // Add a new row to the table model
		                    model.addRow(new Object[]{studentId, usernameFromDB, mail, address, courseName});
		                }
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        // Handle the exception (e.g., show an error message)
		    }
}}
