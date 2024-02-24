package courseManagement;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JCheckBox;

;public class CourseManagement extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField textPassword;
	private static String loggedInUserEmail;
	private static String loggedInUserMode;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseManagement frame = new CourseManagement();
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
	public CourseManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 797);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(8, 10, 704, 750);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email :");
		lblNewLabel.setBounds(160, 267, 107, 30);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 23));
		panel.add(lblNewLabel);
		
		textUsername = new JTextField();
		textUsername.setBounds(330, 267, 220, 30);
		panel.add(textUsername);
		textUsername.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(330, 294, 220, 2);
		panel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(100, 255, 40, 42);
		lblNewLabel_1.setIcon(new ImageIcon(CourseManagement.class.getResource("/image/usersss.png")));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password: ");
		lblNewLabel_2.setBounds(160, 330, 124, 30);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 23));
		panel.add(lblNewLabel_2);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(330, 330, 220, 30);
		panel.add(textPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(330, 358, 220, 2);
		panel.add(separator_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(330, 400, 220, 30);
		comboBox.setBackground(new Color(152, 251, 152));
		comboBox.setFont(new Font("Arial", Font.ITALIC, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select user type", "Admin", "Tutor", "Student"}));
		panel.add(comboBox);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(330, 415, 220, 2);
		panel.add(separator_2);
		
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.setBounds(392, 590, 145, 35);
		btnNewButton.setBackground(new Color(244, 164, 96));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 24));
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 signupPanel();
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Log IN");
		btnNewButton_1.setBounds(271, 474, 157, 42);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 25));
		panel.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(244, 164, 96));
		
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String username = textUsername.getText();
		        String password = textPassword.getText();
		        String selectedMode = comboBox.getSelectedItem().toString();

		        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "")) {
		            // Specify the columns you need explicitly
		            String query = "SELECT Mail FROM " + selectedMode.toLowerCase() + " WHERE Mail=? AND `Set Password`=?";

		            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
		                preparedStatement.setString(1, username);
		                preparedStatement.setString(2, password);

		                boolean userExists = preparedStatement.executeQuery().next();
		                if (userExists) {
		                    loggedInUserEmail = username; 
		                    loggedInUserMode = selectedMode;// Set the logged-in user's email
		                    if ("Admin".equals(selectedMode)) {
		                        // Successful login for Admin
		                        openDashboard();
		                    } else if ("Tutor".equals(selectedMode) || "Student".equals(selectedMode)) {
		                        // Successful login for Tutor or Student
		                        openDashboard1();
		                    } else {
		                        // Invalid credentials
		                        JOptionPane.showMessageDialog(null, "Incorrect credentials. Please try again.");
		                    }
		                } else {
		                    // Invalid credentials
		                    JOptionPane.showMessageDialog(null, "Incorrect credentials. Please try again.");
		                }
		            } catch (Exception ee) {
		                ee.printStackTrace();
		            }
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		    }
		});



			
			
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(100, 318, 40, 42);
		lblNewLabel_3.setIcon(new ImageIcon(CourseManagement.class.getResource("/image/key.png")));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mode");
		lblNewLabel_4.setBounds(160, 400, 124, 30);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 23));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(100, 400, 40, 42);
		lblNewLabel_5.setIcon(new ImageIcon(CourseManagement.class.getResource("/image/mode.png")));
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Don't have an account?");
		lblNewLabel_6.setBounds(196, 585, 243, 49);
		lblNewLabel_6.setFont(new Font("Arial", Font.ITALIC, 16));
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(265, 29, 133, 119);
		lblNewLabel_7.setIcon(new ImageIcon(CourseManagement.class.getResource("/image/Course management.png")));
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Course Manangement System");
		lblNewLabel_8.setBounds(138, 158, 461, 60);
		lblNewLabel_8.setFont(new Font("Forte", Font.PLAIN, 30));
		panel.add(lblNewLabel_8);
		
		JCheckBox showpassword = new JCheckBox("Show Password");
		showpassword.setBounds(430, 366, 105, 21);
		showpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showpassword.isSelected()) {
					textPassword.setEchoChar((char)0);
					}
			
				else {
						textPassword.setEchoChar('*');
				}				
				}
		});
		panel.add(showpassword);

	}
	
	
	public void openDashboard() {
		
		dispose();
		Dashboard redirect = new Dashboard();
		redirect.setVisible(true);
	}
private void openDashboard1() {
		
		dispose();
		Dashboard1 redirect = new Dashboard1();
		redirect.setVisible(true);
	}
	
	private void signupPanel() {
		dispose();
		Signnup redirect = new Signnup();
		redirect.setVisible(true);
}	
	public static String getLoggedInUserEmail() {
	    return loggedInUserEmail;
	}
	public static String getloggedInUserMode() {
	return loggedInUserMode;
	}
}
