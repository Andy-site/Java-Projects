package courseManagement;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
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
import javax.swing.border.EmptyBorder;

public class Settingstudent extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Settingstudent frame = new Settingstudent();
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
    public Settingstudent() {
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
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                updateStudentInformation();
            }

            private void updateStudentInformation() {
                try {
                    String loggedInUserEmail = CourseManagement.getLoggedInUserEmail();
                    if (loggedInUserEmail != null && !loggedInUserEmail.isEmpty()) {
                        String updatedEmail = JOptionPane.showInputDialog("Enter updated email:");
                        String updatedPassword = JOptionPane.showInputDialog("Enter updated password:");
                        String updatedAddress = JOptionPane.showInputDialog("Enter updated address:");

                        DatabaseHelper.updateStudentInfo(loggedInUserEmail, updatedEmail, updatedPassword, updatedAddress);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error updating student information: " + ex.getMessage());
                }
            }
        });
        btnUpdate.setFont(new Font("Andy", Font.BOLD, 25));
        btnUpdate.setBounds(62, 176, 349, 39);
        panel_2.add(btnUpdate);

        JLabel lblNewLabel_1 = new JLabel("You can update your info here");
        lblNewLabel_1.setFont(new Font("Andy", Font.BOLD, 30));
        lblNewLabel_1.setBounds(74, 10, 501, 88);
        panel_2.add(lblNewLabel_1);

        JButton btnNewButton_7 = new JButton("Check my result");
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkStudentResult();
            }
        });

        btnNewButton_7.setFont(new Font("Andy", Font.BOLD, 25));
        btnNewButton_7.setBounds(62, 290, 355, 39);
        panel_2.add(btnNewButton_7);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.controlShadow);
        panel_1.setBounds(8, 83, 183, 685);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JButton btnNewButton = new JButton("Dashboard");
        btnNewButton.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-dashboard-30.png")));
        btnNewButton.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
        btnNewButton.setBackground(SystemColor.info);
        btnNewButton.setBounds(8, 180, 165, 55);
        panel_1.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Courses");
        btnNewButton_1.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
        btnNewButton_1.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-courses-30.png")));
        btnNewButton_1.setBackground(SystemColor.info);
        btnNewButton_1.setBounds(8, 259, 165, 55);
        panel_1.add(btnNewButton_1);

        JButton btnNewButton_5 = new JButton("Settings");
        btnNewButton_5.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-setting-30-removebg-preview.png")));
        btnNewButton_5.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
        btnNewButton_5.setBackground(SystemColor.info);
        btnNewButton_5.setBounds(8, 347, 165, 55);
        panel_1.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("Logout");
        btnNewButton_6.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-logout-30.png")));
        btnNewButton_6.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
        btnNewButton_6.setBackground(SystemColor.info);
        btnNewButton_6.setBounds(8, 425, 165, 55);
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

    private void checkStudentResult() {
        try {
            String loggedInUserEmail = CourseManagement.getLoggedInUserEmail();
            if (loggedInUserEmail != null && !loggedInUserEmail.isEmpty()) {
                // Assuming you have a method to get the result for the logged-in student
                String result = DatabaseHelper.getStudentResult(loggedInUserEmail);
                JOptionPane.showMessageDialog(null, "Your result: " + result);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error checking student result: " + ex.getMessage());
        }
    }
}
class DatabaseHelper {
    public static void updateStudentInfo(String loggedInUserEmail, String updatedEmail, String updatedPassword, String updatedAddress) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "")) {
            String updateQuery = "UPDATE student SET `Mail`=?, `Set Password`=?, `Address`=? WHERE `Mail`=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, updatedEmail);
                preparedStatement.setString(2, updatedPassword);
                preparedStatement.setString(3, updatedAddress);
                preparedStatement.setString(4, loggedInUserEmail);

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
    public static String getStudentResult(String loggedInUserEmail) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "")) {
            String selectUsernameQuery = "SELECT `Username` FROM student WHERE `Mail`=?";
            try (PreparedStatement usernameStatement = connection.prepareStatement(selectUsernameQuery)) {
                usernameStatement.setString(1, loggedInUserEmail);

                try (ResultSet usernameResultSet = usernameStatement.executeQuery()) {
                    if (usernameResultSet.next()) {
                        String username = usernameResultSet.getString("Username");

                        String selectResultQuery = "SELECT `Level 4 module1`, `Level 4 module2`, `Level 4 module3`, " +
                                "`Level 5 module1`, `Level 5 module2`, `Level 5 module3`, " +
                                "`Level 6 module1`, `Level 6 module2`, `Level 6 module3` FROM result WHERE `Username`=?";
                        try (PreparedStatement preparedStatement = connection.prepareStatement(selectResultQuery)) {
                            preparedStatement.setString(1, username);

                            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                                if (resultSet.next()) {
                                    // Adjust the column names based on your actual column names in the database
                                    int totalModules = 9;
                                    int[] moduleResults = new int[totalModules];

                                    moduleResults[0] = resultSet.getInt("Level 4 module1");
                                    moduleResults[1] = resultSet.getInt("Level 4 module2");
                                    moduleResults[2] = resultSet.getInt("Level 4 module3");
                                    moduleResults[3] = resultSet.getInt("Level 5 module1");
                                    moduleResults[4] = resultSet.getInt("Level 5 module2");
                                    moduleResults[5] = resultSet.getInt("Level 5 module3");
                                    moduleResults[6] = resultSet.getInt("Level 6 module1");
                                    moduleResults[7] = resultSet.getInt("Level 6 module2");
                                    moduleResults[8] = resultSet.getInt("Level 6 module3");

                                    // Calculate average
                                    double average = 0;
                                    for (int i = 0; i < totalModules; i++) {
                                        average += moduleResults[i];
                                    }
                                    average /= totalModules;

                                    // Prepare the result string
                                    StringBuilder result = new StringBuilder();
                                    result.append("\nUsername: ").append(username).append("\n\n");
                                    result.append("Module\t\t\tResult\n");
                                    result.append("------------------------------\n");
                                    for (int i = 0; i < totalModules; i++) {
                                        result.append("Level ").append((i / 3) + 4).append(" Module ").append((i % 3) + 1).append(": ");
                                        result.append(moduleResults[i]).append("\n");
                                    }
                                    result.append("------------------------------\n");
                                    result.append("Average: \t\t").append(average);

                                    return result.toString();
                                } else {
                                    return "Result not available";
                                }
                            }
                        }
                    } else {
                        return "Username not found for the given email";
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error getting student result: " + ex.getMessage());
        }
    }
}