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
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;


public class Viewcourse extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton rdbtnNewRadioButton_1;
    private JRadioButton rdbtnNewRadioButton_2;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Viewcourse frame = new Viewcourse();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Viewcourse() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 970, 820);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.activeCaption);
        panel.setBounds(8, 10, 940, 790);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(199, 95, 733, 685);
        panel.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Total Courses");
        
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1.setBackground(SystemColor.inactiveCaption);
        lblNewLabel_1.setFont(new Font("Andy", Font.BOLD, 25));
        lblNewLabel_1.setBounds(435, 24, 246, 103);
        panel_2.add(lblNewLabel_1);

        JButton btnNewButton_7 = new JButton("");
        btnNewButton_7.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-folder-40.png")));
        btnNewButton_7.setBackground(SystemColor.info);
        btnNewButton_7.setFont(new Font("Andy", Font.BOLD, 25));
        btnNewButton_7.setBounds(577, 73, 65, 45);
        panel_2.add(btnNewButton_7);
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fetch and display course details
//                displayData("SELECT `Course Name`,`Level 4 module1`,`Level 4 module2`, `Level 4 module3`,`Level 5 module1`, `Level 5 module2`,`Level 5 module3`, `Level 6 module1`, `Level 6 module2`, `Level 6 module3` FROM courses");
                rdbtnNewRadioButton.setVisible(true);
                rdbtnNewRadioButton_1.setVisible(true);
                rdbtnNewRadioButton_2.setVisible(true);            
            }
        });

        JLabel lblNewLabel_2_2 = new JLabel("0");
        lblNewLabel_2_2.setFont(new Font("Andy", Font.BOLD, 30));
        lblNewLabel_2_2.setBounds(486, 73, 45, 45);
        panel_2.add(lblNewLabel_2_2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(8, 387, 717, 288);
        panel_2.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton View = new JButton("View Details");
        View.setBackground(SystemColor.info);
        View.setForeground(SystemColor.windowText);
        View.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		displayData("SELECT `Course ID`,`Course Name`,`Seats`,`Batch`,`Year Count` FROM courses");
        	}
        });
        View.setFont(new Font("Andy", Font.BOLD, 30));
        View.setBounds(31, 243, 198, 35);
        panel_2.add(View);
        
        JButton btnNewButton_8 = new JButton("Delete");
        btnNewButton_8.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 // Prompt user for Course ID to delete
                 String courseIDToDelete = JOptionPane.showInputDialog("Enter Course ID to delete:");

                 if (courseIDToDelete != null && !courseIDToDelete.isEmpty()) {
                     // Perform delete operation based on Course ID
                     deleteCourse(courseIDToDelete);
                 } else {
                     JOptionPane.showMessageDialog(null, "Invalid Course ID.");
                 }
             }
         });
        
        JLabel lblNewLabel_2 = new JLabel("Search ");
        lblNewLabel_2.setIcon(new ImageIcon(Student.class.getResource("/image/icons8-search-30.png")));
        lblNewLabel_2.setFont(new Font("Andy", Font.BOLD, 20));
        lblNewLabel_2.setBounds(372, 332, 109, 29);
        panel_2.add(lblNewLabel_2);
//        
        JEditorPane editorPane = new JEditorPane();
        editorPane.setBackground(SystemColor.textHighlightText);
        editorPane.setBounds(504, 332, 207, 30);
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
        btnNewButton_8.setBackground(SystemColor.info);
        btnNewButton_8.setForeground(SystemColor.controlText);
        btnNewButton_8.setFont(new Font("Andy", Font.BOLD, 30));
        btnNewButton_8.setBounds(27, 109, 162, 45);
        panel_2.add(btnNewButton_8);
       
        
        JButton btnNewButton_9 = new JButton("Update");
        btnNewButton_9.setBackground(SystemColor.info);
        btnNewButton_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		openadd();
        	}

			private void openadd() {
				// TODO Auto-generated method stub
				new addCourseadmin().setVisible(true);
			}
        });
        btnNewButton_9.setFont(new Font("Andy", Font.BOLD, 30));
        btnNewButton_9.setBounds(27, 37, 162, 45);
        panel_2.add(btnNewButton_9);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Level 4");
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 displayData("SELECT `Course Name`,`Level 4 module1`,`Level 4 module2`, `Level 4 module3` from courses");
        	}
        });
        rdbtnNewRadioButton.setFont(new Font("Andy", Font.BOLD, 20));
        rdbtnNewRadioButton.setBounds(550, 156, 99, 21);
        panel_2.add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Level 5");
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 displayData("SELECT `Course Name`,`Level 5 module1`,`Level 5 module2`, `Level 5 module3` from courses");
        	}
        });
        rdbtnNewRadioButton_1.setFont(new Font("Andy", Font.BOLD, 20));
        rdbtnNewRadioButton_1.setBounds(550, 207, 99, 21);
        panel_2.add(rdbtnNewRadioButton_1);
        
        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Level 6");
        rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 displayData("SELECT `Course Name`,`Level 6 module1`,`Level 6 module2`, `Level 6 module3` from courses");
        	}
        });
        rdbtnNewRadioButton_2.setFont(new Font("Andy", Font.BOLD, 20));
        rdbtnNewRadioButton_2.setBounds(550, 253, 99, 21);
        panel_2.add(rdbtnNewRadioButton_2);
        
      

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
                dispose();
                openTutors();
            }

            private void openTutors() {
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
                dispose();
                openStudents();
            }

            private void openStudents() {
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
                openMail();
            }

            private void openMail() {
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
                dispose();
                openSettings();
            }

            private void openSettings() {
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
                logout();
            }
        });

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(8, 10, 924, 63);
        panel.add(panel_3);
        panel_3.setLayout(null);

        JLabel lblNewLabel = new JLabel("   Welcome to the SYSTEM");
        lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-course-assign-50.png")));
        lblNewLabel.setFont(new Font("Forte", Font.PLAIN, 30));
        lblNewLabel.setBounds(136, 10, 435, 48);
        panel_3.add(lblNewLabel);
        setLocationRelativeTo(null);
    }

    private void logout() {
        int result = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to logout?",
                "Logout",
                JOptionPane.YES_NO_OPTION
        );

        if (result == JOptionPane.YES_OPTION) {
            dispose();
            openCourseManagement();
        }
    }

    private void openCourseManagement() {
        CourseManagement courseManagement = new CourseManagement();
        courseManagement.setVisible(true);
    }

    void displayData(String query) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            DefaultTableModel model = new DefaultTableModel();
            table.setModel(model);

            int columnCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(resultSet.getMetaData().getColumnName(i));
            }

            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                model.addRow(rowData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data.");
        }
    }
    
    private void populateTable(String searchText) {
        // Assuming columnNames is an array representing your column names
        String[] columnNames = {"Course ID", "Course Name", "Seats", "Batch", "Year Count"};

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
            String query = "SELECT * FROM courses WHERE `Course Name` LIKE ?";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, "%" + searchText + "%");

                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        // Assuming your columns are: Course ID, Course Name, Seats, Batch, Year Count
                        int courseId = rs.getInt("Course ID");
                        String courseName = rs.getString("Course Name");
                        int seats = rs.getInt("Seats");
                        String batch = rs.getString("Batch");
                        int yearCount = rs.getInt("Year Count");

                        // Add a new row to the table model
                        model.addRow(new Object[]{courseId, courseName, seats, batch, yearCount});
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (e.g., show an error message)
        }
    }
    private void deleteCourse(String courseID) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "");
             Statement statement = connection.createStatement()) {

            String deleteQuery = "DELETE FROM courses WHERE `Course ID` = '" + courseID + "'";
            int rowsAffected = statement.executeUpdate(deleteQuery);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Course with Course ID " + courseID + " deleted successfully!");
                // Refresh the displayed data after deletion
                displayData("SELECT `Course ID`,`Course Name`,`Seats`,`Batch`,`Year Count` FROM courses");
            } else {
                JOptionPane.showMessageDialog(null, "Course with Course ID " + courseID + " not found.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error deleting course.");
        }
    }
}
