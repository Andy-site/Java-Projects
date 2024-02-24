package courseManagement;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Signnup extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textUsername;
    private JTextField textMail;
    private JTextField textPassword;
    private JTextField textConfirm;
    private JTextField textAddress;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Signnup frame = new Signnup();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Signnup() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 735, 816);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.activeCaption);
        panel.setBounds(8, 10, 704, 769);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Welcome to sign up page ");
        lblNewLabel.setBounds(91, 26, 479, 77);
        lblNewLabel.setIcon(new ImageIcon(Signnup.class.getResource("/image/icons8-sign-up-100.png")));
        lblNewLabel.setFont(new Font("Forte", Font.PLAIN, 30));
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Username: ");
        lblNewLabel_1.setBounds(91, 205, 179, 39);
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 24));
        lblNewLabel_1.setIcon(new ImageIcon(Signnup.class.getResource("/image/usersss.png")));
        panel.add(lblNewLabel_1);

        textUsername = new JTextField();
        textUsername.setBounds(326, 205, 220, 30);
        panel.add(textUsername);
        textUsername.setColumns(10);

        JSeparator separator = new JSeparator();
        separator.setBounds(326, 234, 220, 2);
        panel.add(separator);

        JLabel lblNewLabel_2 = new JLabel(" Mail: ");
        lblNewLabel_2.setBounds(91, 275, 179, 39);
        lblNewLabel_2.setIcon(new ImageIcon(Signnup.class.getResource("/image/icons8-mail-30.png")));
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(lblNewLabel_2);

        textMail = new JTextField();
        textMail.setBounds(326, 275, 220, 30);
        panel.add(textMail);
        textMail.setColumns(10);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(326, 303, 220, 2);
        panel.add(separator_1);

        JLabel lblNewLabel_3 = new JLabel("Set Password:");
        lblNewLabel_3.setBounds(91, 345, 206, 39);
        lblNewLabel_3.setIcon(new ImageIcon(Signnup.class.getResource("/image/key.png")));
        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(lblNewLabel_3);

        textPassword = new JPasswordField();
        textPassword.setBounds(326, 345, 220, 30);
        panel.add(textPassword);
        textPassword.setColumns(10);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(326, 373, 220, 2);
        panel.add(separator_2);

        JLabel lblNewLabel_5 = new JLabel("Confirm pssd");
        lblNewLabel_5.setIcon(new ImageIcon(Signnup.class.getResource("/image/icons8-confirm-40.png")));
        lblNewLabel_5.setBounds(91, 415, 206, 39);
        lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(lblNewLabel_5);

        textConfirm = new JPasswordField();
        textConfirm.setBounds(326, 415, 220, 30);
        panel.add(textConfirm);
        textConfirm.setColumns(10);

        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(326, 443, 220, 2);
        panel.add(separator_3);

        JLabel lblNewLabel_4 = new JLabel(" Address: ");
        lblNewLabel_4.setIcon(new ImageIcon(Signnup.class.getResource("/image/icons8-address-30.png")));
        lblNewLabel_4.setBounds(91, 485, 206, 39);
        lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(lblNewLabel_4);

        textAddress = new JTextField();
        textAddress.setBounds(326, 485, 220, 30);
        panel.add(textAddress);
        textAddress.setColumns(10);

        JSeparator separator_4 = new JSeparator();
        separator_4.setBounds(326, 513, 220, 2);
        panel.add(separator_4);

        JLabel lblNewLabel_6 = new JLabel(" Mode: ");
        lblNewLabel_6.setIcon(new ImageIcon(Signnup.class.getResource("/image/mode.png")));
        lblNewLabel_6.setBounds(91, 555, 206, 39);
        lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(lblNewLabel_6);

        JComboBox<String> userTypeComboBox = new JComboBox<>();
        userTypeComboBox.setBackground(new Color(152, 251, 152));
        userTypeComboBox.setFont(new Font("Arial", Font.ITALIC, 18));

        ArrayList<String> userTypes = new ArrayList<>(Arrays.asList("Select user type", "Student", "Tutor", "Admin"));
        userTypeComboBox.setModel(new DefaultComboBoxModel<>(userTypes.toArray(new String[0])));

        userTypeComboBox.setBounds(326, 555, 220, 30);
        panel.add(userTypeComboBox);

        JComboBox<String> courseComboBox = new JComboBox<>();
        courseComboBox.setBackground(new Color(152, 251, 152));
        courseComboBox.setFont(new Font("Arial", Font.ITALIC, 18));
        ArrayList<String> courseOptions = new ArrayList<>(Arrays.asList("Select course", "BCS", "BIBM"));
        courseComboBox.setModel(new DefaultComboBoxModel<>(courseOptions.toArray(new String[0])));
        courseComboBox.setBounds(326, 605, 220, 30);
        panel.add(courseComboBox);
        courseComboBox.setVisible(false);
        userTypeComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedUserType = (String) userTypeComboBox.getSelectedItem();
                if ("Student".equals(selectedUserType)) {
                    courseComboBox.setVisible(true);
                } else {
                    courseComboBox.setVisible(false);
                    courseComboBox.setSelectedItem("Select course");
                }
            }
        });
        

        JButton btnNewButton = new JButton("Sign up");
        btnNewButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String username = textUsername.getText().trim();
                String mail = textMail.getText().trim();
                String password = textPassword.getText().trim();
                String confirmpssd = textConfirm.getText().trim();
                String address = textAddress.getText().trim();
                String value = userTypeComboBox.getSelectedItem().toString().trim();
                String value1 = courseComboBox.getSelectedItem().toString().trim();

             // Print out the entries in the console
                System.out.println("Username: " + username);
                System.out.println("Mail: " + mail);
                System.out.println("Password: " + password);
                System.out.println("Confirm Password: " + confirmpssd);
                System.out.println("Address: " + address);
                System.out.println("User Type: " + value);
                System.out.println("Course: " + value1);
                
                
                if (!username.equals("") && !mail.equals("") && !password.equals("") && !confirmpssd.equals("")
                        && !address.equals("") && !value.equals("") && !value1.equals("")) {
                    if (Pattern.matches("^[A-Z][a-zA-Z]*\\s[A-Z][a-z]*$", username)
                            && Pattern.matches("^[a-z_0-9]+[@][a-z]+[.][a-z]{2,}$", mail)
                            && Pattern.matches("^[a-zA-Z0-9@#$]+{7,}$", password)
                            && Pattern.matches("^[A-Z]+[a-z]+[-]+[0-9]+[,][\\s][A-Z]+[a-z]+[,][\\s][A-Z]+[a-z]+$",
                                    address)) {
                        if (password.equals(confirmpssd)) {
                            signup(userTypeComboBox, courseComboBox);
                            JOptionPane.showMessageDialog(null, "Successfully created the account!!!");

                            try {
                                String url = "jdbc:mysql://localhost:3306/cms";
                                String username1 = "root";
                                String password1 = "";
                                Connection con;
                                con = DriverManager.getConnection(url, username1, password1);
                                switch (value) {
                                case "Student":
                                    try (PreparedStatement pstStudent = con.prepareStatement(
                                            "INSERT INTO student (`Username`,`Mail`,`Set Password`,`Address`,`Course Name`) VALUES (?, ?, ?,?, ?)")) {
                                        pstStudent.setString(1, username);
                                        pstStudent.setString(2, mail);
                                        pstStudent.setString(3, password);
                                        pstStudent.setString(4, address);
                                        pstStudent.setString(5, value1);
                                        pstStudent.executeUpdate();
                                    }
                                    break;

                                case "Tutor":
                                    try (PreparedStatement pstTutor = con.prepareStatement(
                                            "INSERT INTO tutor (`Username`,`Mail`,`Set Password`,`Address`) VALUES (?, ?, ?, ?)")) {
                                        pstTutor.setString(1, username);
                                        pstTutor.setString(2, mail);
                                        pstTutor.setString(3, password);
                                        pstTutor.setString(4, address);
                                        pstTutor.executeUpdate();
                                    }
                                    break;

                                case "Admin":
                                    try (PreparedStatement pstAdmin = con.prepareStatement(
                                            "INSERT INTO admin (`Username`,`Mail`,`Set Password`,`Address`) VALUES (?, ?,?, ?)")) {
                                        pstAdmin.setString(1, username);
                                        pstAdmin.setString(2, mail);
                                        pstAdmin.setString(3, password);
                                        pstAdmin.setString(4, address);
                                        pstAdmin.executeUpdate();
                                    }
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(Signnup.this, "Invalid user mode.", "Error",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                                JOptionPane.showMessageDialog(Signnup.this,
                                        "Addition of information about this account in database has been completed!!!");

                            } catch (Exception ee) {
                                ee.printStackTrace();
                                JOptionPane.showMessageDialog(Signnup.this, "Error in database operation.", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Password doesn't match");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Regex error");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Every field is mandatory");
                }
            }
        });
        btnNewButton.setBackground(SystemColor.textHighlight);
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 24));
        btnNewButton.setBounds(246, 689, 155, 48);
        panel.add(btnNewButton);
    }

    private void signup(JComboBox<String> userTypeComboBox, JComboBox<String> courseComboBox) {
        String userType = (String) userTypeComboBox.getSelectedItem();
        String course = (String) courseComboBox.getSelectedItem();

        if ("Select user type".equals(userType)) {
            JOptionPane.showMessageDialog(this, "Please select a user type.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if ("Student".equals(userType) && "Select course".equals(course)) {
            JOptionPane.showMessageDialog(this, "Please select a course for students.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            dispose();
            CourseManagement courseManagement = new CourseManagement();
            courseManagement.setVisible(true);
        }
    }
}
