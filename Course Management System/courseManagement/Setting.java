package courseManagement;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Setting extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
    	    public void run() {
    	        try {
    	            Setting frame = new Setting();
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
    public Setting() {
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

        JButton btnUpdate = new JButton("Update my Information");
        btnUpdate.setBackground(SystemColor.info);
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                updateTutorInformation();
            }

            private void updateTutorInformation() {
                try {
                    String loggedInTutorEmail = CourseManagement.getLoggedInUserEmail();
                    if (loggedInTutorEmail != null && !loggedInTutorEmail.isEmpty()) {
                        String updatedEmail = JOptionPane.showInputDialog("Enter updated email:");
                        String updatedPassword = JOptionPane.showInputDialog("Enter updated password:");
                        String updatedAddress = JOptionPane.showInputDialog("Enter updated address:");

                        DatabaseHelperTutor.updateTutorInfo(loggedInTutorEmail, updatedEmail, updatedPassword, updatedAddress);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error updating tutor information: " + ex.getMessage());
                }
            }
        });
        btnUpdate.setFont(new Font("Andy", Font.BOLD, 25));
        btnUpdate.setBounds(125, 108, 249, 39);
        panel_2.add(btnUpdate);

        JLabel lblNewLabel_1 = new JLabel("You can update your info here");
        lblNewLabel_1.setFont(new Font("Andy", Font.BOLD, 30));
        lblNewLabel_1.setBounds(74, 10, 501, 88);
        panel_2.add(lblNewLabel_1);

        JButton btnNewButton_7 = new JButton("Generate result");
        btnNewButton_7.setBackground(SystemColor.info);
        btnNewButton_7.setFont(new Font("Andy", Font.BOLD, 25));
        btnNewButton_7.setBounds(299, 206, 250, 88);
        panel_2.add(btnNewButton_7);
        
        JButton btnNewButton_2 = new JButton("Check Student result");
        btnNewButton_2.setBackground(SystemColor.info);
        
        	btnNewButton_2.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        try {
        	            checkStudentResult();
        	        } catch (HeadlessException e1) {
        	            e1.printStackTrace();
        	        }
        	    }

        	    private void checkStudentResult() {
        	        try {
        	            // Ask for student name and course name
        	            String studentName = JOptionPane.showInputDialog("Enter student name:");
        	            String courseName = JOptionPane.showInputDialog("Enter course name:");

        	            // Query the database to check if there is a student with the provided name and enrolled in the provided course
        	            if (validateStudent(studentName, courseName)) {
        	                // If a matching student is found, retrieve their result from the database
        	                ResultSet resultSet = getStudentResult(studentName, courseName);

        	                // Display the result
        	                if (resultSet.next()) {
        	                    // Display all the modules and their corresponding scores
        	                    StringBuilder resultMessage = new StringBuilder("Student Results for " + studentName + " in " + courseName + ":\n");
        	                    resultMessage.append("Level 4 module1: ").append(resultSet.getInt("Level 4 module1")).append("\n");
        	                    resultMessage.append("Level 4 module2: ").append(resultSet.getInt("Level 4 module2")).append("\n");
        	                    resultMessage.append("Level 4 module3: ").append(resultSet.getInt("Level 4 module3")).append("\n");
        	                    resultMessage.append("Level 5 module1: ").append(resultSet.getInt("Level 5 module1")).append("\n");
        	                    resultMessage.append("Level 5 module2: ").append(resultSet.getInt("Level 5 module2")).append("\n");
        	                    resultMessage.append("Level 5 module3: ").append(resultSet.getInt("Level 5 module3")).append("\n");
        	                    resultMessage.append("Level 6 module1: ").append(resultSet.getInt("Level 6 module1")).append("\n");
        	                    resultMessage.append("Level 6 module2: ").append(resultSet.getInt("Level 6 module2")).append("\n");
        	                    resultMessage.append("Level 6 module3: ").append(resultSet.getInt("Level 6 module3")).append("\n");

        	                    JOptionPane.showMessageDialog(null, resultMessage.toString());
        	                } else {
        	                    JOptionPane.showMessageDialog(null, "No result found for the student in the specified course.");
        	                }
        	            } else {
        	                JOptionPane.showMessageDialog(null, "No student found with the provided name enrolled in the specified course.");
        	            }
        	        } catch (HeadlessException | SQLException e) {
        	            e.printStackTrace();
        	            JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage());
        	        }
        	    }


        	    private boolean validateStudent(String studentName, String courseName) throws SQLException {
        	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "")) {
        	            String selectQuery = "SELECT * FROM student WHERE Username=? AND `Course name`=?";
        	            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
        	                preparedStatement.setString(1, studentName);
        	                preparedStatement.setString(2, courseName);

        	                try (ResultSet resultSet = preparedStatement.executeQuery()) {
        	                    // If there is at least one row in the result set, the student exists
        	                    return resultSet.next();
        	                }
        	            }
        	        } catch (SQLException ex) {
        	            ex.printStackTrace();
        	            JOptionPane.showMessageDialog(null, "Error validating student: " + ex.getMessage());
        	            return false;
        	        }
        	    }

        	    private ResultSet getStudentResult(String studentName, String courseName) throws SQLException {
        	        Connection connection = null;
        	        PreparedStatement preparedStatement = null;
        	        ResultSet resultSet = null;

        	        try {
        	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "");
        	            String selectQuery = "SELECT * FROM result WHERE Username=? AND `Course name`=?";
        	            preparedStatement = connection.prepareStatement(selectQuery);
        	            preparedStatement.setString(1, studentName);
        	            preparedStatement.setString(2, courseName);

        	            resultSet = preparedStatement.executeQuery();
        	            return resultSet;
        	        } catch (SQLException ex) {
        	            ex.printStackTrace();
        	            JOptionPane.showMessageDialog(null, "Error retrieving student result: " + ex.getMessage());
        	            // Close resources in case of an exception
        	            if (resultSet != null) {
        	                resultSet.close();
        	            }
        	            if (preparedStatement != null) {
        	                preparedStatement.close();
        	            }
        	            if (connection != null) {
        	                connection.close();
        	            }
        	            throw ex;
        	        }
        	    }


        	});

        btnNewButton_2.setFont(new Font("Andy", Font.BOLD, 25));
        btnNewButton_2.setBounds(21, 206, 250, 88);
        panel_2.add(btnNewButton_2);
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
					generateStudentResult();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }

         // Inside your Setting class
            private void generateStudentResult() {
                try {
                    // Ask for student username and course name
                    String studentUsername = JOptionPane.showInputDialog("Enter student username:");
                    String courseName = JOptionPane.showInputDialog("Enter course name:");

                    // Validate student against the student table
                    if (validateStudent(studentUsername, courseName)) {
                        // Check if a row already exists for the student and course
                        boolean rowExists = doesRowExist(studentUsername, courseName);

                        if (!rowExists) {
                            // Insert a new row for the student and course
                            insertNewRow(studentUsername, courseName);
                        }

                        // Create a panel to input scores
                        JPanel scorePanel = new JPanel();
                        scorePanel.setLayout(new GridLayout(0, 2));

                        // Manually input scores for each module
                        String[] modules = {
                                "Level 4 module1", "Level 4 module2", "Level 4 module3",
                                "Level 5 module1", "Level 5 module2", "Level 5 module3",
                                "Level 6 module1", "Level 6 module2", "Level 6 module3"
                        };

                        for (String module : modules) {
                            String score = JOptionPane.showInputDialog("Enter score for " + module + ":");
                            scorePanel.add(new JLabel(module));
                            scorePanel.add(new JTextField(score));
                        }

                        // Show the score input panel in an option pane
                        int result = JOptionPane.showConfirmDialog(
                                null,
                                scorePanel,
                                "Enter Scores",
                                JOptionPane.OK_CANCEL_OPTION
                        );

                        // If the user clicks OK, update scores in the result table
                        if (result == JOptionPane.OK_OPTION) {
                            // Update scores for each module in the existing row
                            updateScoresInRow(studentUsername, courseName, modules, scorePanel);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid student or course name.");
                    }
                } catch (HeadlessException | SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage());
                }
            }

            private boolean doesRowExist(String studentUsername, String courseName) throws SQLException {
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "")) {
                    String selectQuery = "SELECT * FROM result WHERE `Username`=? AND `Course Name`=?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                        preparedStatement.setString(1, studentUsername);
                        preparedStatement.setString(2, courseName);

                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            // If there is at least one row in the result set, the row exists
                            return resultSet.next();
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error checking if row exists: " + ex.getMessage());
                    return false;
                }
            }

            private void insertNewRow(String studentUsername, String courseName) {
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "")) {
                    // Build the SQL query dynamically based on module names
                    StringBuilder insertQuery = new StringBuilder("INSERT INTO result (`Username`, `Course Name`, `Level 4 module1`, `Level 4 module2`, `Level 4 module3`, `Level 5 module1`, `Level 5 module2`, `Level 5 module3`, `Level 6 module1`, `Level 6 module2`, `Level 6 module3`) VALUES (?, ?, 0, 0, 0, 0, 0, 0, 0, 0, 0)");

                    try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery.toString())) {
                        preparedStatement.setString(1, studentUsername);
                        preparedStatement.setString(2, courseName);

                        // Execute the update
                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "New row inserted successfully for student: " + studentUsername);
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to insert new row for student.");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error inserting new row for student: " + ex.getMessage());
                }
            }


            private void updateScoresInRow(String studentUsername, String courseName, String[] modules, JPanel scorePanel) {
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "")) {
                    // Build the SQL query dynamically based on module names
                    StringBuilder updateQuery = new StringBuilder("UPDATE result SET `Level 4 module1`=?, `Level 4 module2`=?, `Level 4 module3`=?, `Level 5 module1`=?, `Level 5 module2`=?, `Level 5 module3`=?, `Level 6 module1`=?, `Level 6 module2`=?, `Level 6 module3`=? WHERE `Username`=? AND `Course Name`=?");
                    

                    try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery.toString())) {
                        // Insert scores for each module
                        for (int i = 0; i < modules.length; i++) {
                            String score = ((JTextField) scorePanel.getComponent(i * 2 + 1)).getText();
                            preparedStatement.setInt(i + 1, Integer.parseInt(score));
                        }

                        preparedStatement.setString(modules.length + 1, studentUsername);
                        preparedStatement.setString(modules.length + 2, courseName);

                        // Execute the update
                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Scores updated successfully for student: " + studentUsername);
                        } else {
                            JOptionPane.showMessageDialog(null, "No rows were updated. Please check if the student and course exist.");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error updating scores for student: " + ex.getMessage());
                }
            }


			private boolean validateStudent(String studentUsername, String courseName) throws SQLException {
				try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "")) {
			        String selectQuery = "SELECT * FROM student WHERE Username=? AND `Course Name`=?";
			        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
			            preparedStatement.setString(1, studentUsername);
			            preparedStatement.setString(2, courseName);

			            try (ResultSet resultSet = preparedStatement.executeQuery()) {
			                // If there is at least one row in the result set, the student exists
			                return resultSet.next();
			            }
			        }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			        JOptionPane.showMessageDialog(null, "Error validating student: " + ex.getMessage());
			        
			    }
				return false;
			}
        });
        
        
        

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
        btnNewButton_1.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
        btnNewButton_1.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-courses-30.png")));
        btnNewButton_1.setBackground(SystemColor.info);
        btnNewButton_1.setBounds(8, 180, 165, 55);
        panel_1.add(btnNewButton_1);

        JButton btnNewButton_5 = new JButton("Settings");
        btnNewButton_5.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-setting-30-removebg-preview.png")));
        btnNewButton_5.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
        btnNewButton_5.setBackground(SystemColor.info);
        btnNewButton_5.setBounds(8, 259, 165, 55);
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
            new CourseManagement().setVisible(true);
        }
    }
}

class DatabaseHelperTutor {
    public static void updateTutorInfo(String loggedInTutorEmail, String updatedEmail, String updatedPassword, String updatedAddress) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "")) {
            String updateQuery = "UPDATE tutor SET `Mail`=?, `Set Password`=?, `Address`=? WHERE `Mail`=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, updatedEmail);
                preparedStatement.setString(2, updatedPassword);
                preparedStatement.setString(3, updatedAddress);
                preparedStatement.setString(4, loggedInTutorEmail);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Tutor information updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update tutor information.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating tutor information: " + ex.getMessage());
        }
    }
}
