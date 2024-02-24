package courseManagement;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Settingadmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Settingadmin frame = new Settingadmin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Settingadmin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 820, 817);
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
        
        JButton btnNewButton_7 = new JButton("Update Student Information");
        btnNewButton_7.setBackground(SystemColor.info);
        btnNewButton_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		        // Prompt the user for the student ID
        		        String studentId = JOptionPane.showInputDialog("Enter the Student ID to update:");

        		        // Check if the user canceled the input
        		        if (studentId != null) {
        		            // Call a method to update student information in the database
        		            updateStudentInformation(studentId);
        		        }
        		    }
        		});
        	
        btnNewButton_7.setFont(new Font("Andy", Font.BOLD, 25));
        btnNewButton_7.setBounds(105, 174, 303, 59);
        panel_2.add(btnNewButton_7);
        
        JButton btnNewButton_7_1 = new JButton("Update Tutor Information");
        btnNewButton_7_1.setBackground(SystemColor.info);
        btnNewButton_7_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String tutorId = JOptionPane.showInputDialog("Enter the Tutor ID to update:");

		        // Check if the user canceled the input
		        if (tutorId != null) {
		            // Call a method to update student information in the database
		            updatetutorInformation(tutorId);
		        }
        	}
        });
        btnNewButton_7_1.setFont(new Font("Andy", Font.BOLD, 25));
        btnNewButton_7_1.setBounds(105, 291, 303, 59);
        panel_2.add(btnNewButton_7_1);

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
				opencour();
			}

			private void opencour() {
				// TODO Auto-generated method stub
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
				opentutor();
			}

			private void opentutor() {
				// TODO Auto-generated method stub
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
				openstu();
			}

			private void openstu() {
				// TODO Auto-generated method stub
				new Student().setVisible(true);
			}
			
		});
		btnNewButton_3.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-auditorium-30.png")));
		btnNewButton_3.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_3.setBackground(SystemColor.info);
		btnNewButton_3.setBounds(8, 340, 165, 55);
		panel_1.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Mail");
        btnNewButton_4.setIcon(new ImageIcon(Settingadmin.class.getResource("/image/icons8-mail-30.png")));
        btnNewButton_4.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
        btnNewButton_4.setBackground(SystemColor.info);
        btnNewButton_4.setBounds(8, 420, 165, 55);
        panel_1.add(btnNewButton_4);
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		openMailLink();
        	}
        });

        JButton btnNewButton_5 = new JButton("Settings");
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Settingadmin().setVisible(true);
        	}
        });
        btnNewButton_5.setIcon(new ImageIcon(Settingadmin.class.getResource("/image/icons8-setting-30-removebg-preview.png")));
        btnNewButton_5.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
        btnNewButton_5.setBackground(SystemColor.info);
        btnNewButton_5.setBounds(8, 500, 165, 55);
        panel_1.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("Logout");
        btnNewButton_6.setIcon(new ImageIcon(Settingadmin.class.getResource("/image/icons8-logout-30.png")));
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
        lblNewLabel.setIcon(new ImageIcon(Settingadmin.class.getResource("/image/icons8-course-assign-50.png")));
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

    private void openMailLink() {
        try {
            Desktop.getDesktop().browse(new URI("https://mail.google.com/mail/u/0/?tab=om#inbox"));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }
    
    private void updateStudentInformation(String studentId) {
        // Your existing code to get updated values for Username, Email, Set Password, and Address
        String updatedUsername = JOptionPane.showInputDialog("Enter updated username:");
        String updatedEmail = JOptionPane.showInputDialog("Enter updated email:");
        String updatedPassword = JOptionPane.showInputDialog("Enter updated password:");
        String updatedAddress = JOptionPane.showInputDialog("Enter updated address:");

        // Check if the user canceled any of the input
        if (updatedUsername != null && updatedEmail != null && updatedPassword != null && updatedAddress != null) {
            try {
                // Establish database connection
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "");

                // Update student information using a PreparedStatement
                String updateQuery = "UPDATE student SET `Username`=?, `Mail`=?, `Set Password`=?, `Address`=? WHERE `Student-id`=?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, updatedUsername);
                    preparedStatement.setString(2, updatedEmail);
                    preparedStatement.setString(3, updatedPassword);
                    preparedStatement.setString(4, updatedAddress);
                    preparedStatement.setString(5, studentId);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Student information updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update student information.");
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error updating student information: " + ex.getMessage());
            }
        }
    }
    private void updatetutorInformation(String tutorId) {
        // Your existing code to get updated values for Username, Email, Set Password, and Address
        String updatedUsername = JOptionPane.showInputDialog("Enter updated username:");
        String updatedEmail = JOptionPane.showInputDialog("Enter updated email:");
        String updatedPassword = JOptionPane.showInputDialog("Enter updated password:");
        String updatedAddress = JOptionPane.showInputDialog("Enter updated address:");

        // Check if the user canceled any of the input
        if (updatedUsername != null && updatedEmail != null && updatedPassword != null && updatedAddress != null) {
            try {
                // Establish database connection
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "");

                // Update student information using a PreparedStatement
                String updateQuery = "UPDATE tutor SET `Username`=?, `Mail`=?, `Set Password`=?, `Address`=? WHERE `tutor-id`=?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, updatedUsername);
                    preparedStatement.setString(2, updatedEmail);
                    preparedStatement.setString(3, updatedPassword);
                    preparedStatement.setString(4, updatedAddress);
                    preparedStatement.setString(5, tutorId);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Student information updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update student information.");
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error updating student information: " + ex.getMessage());
            }
        }
    }
}