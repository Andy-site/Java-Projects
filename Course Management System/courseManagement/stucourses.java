package courseManagement;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JToggleButton;

public class stucourses extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	/**
	 * @wbp.nonvisual location=-39,333
	 */
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stucourses frame = new stucourses();
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
	public stucourses() {
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
		
		JLabel lblNewLabel_1 = new JLabel("View your course information");
		lblNewLabel_1.setFont(new Font("Andy", Font.BOLD, 30));
		lblNewLabel_1.setBounds(138, 33, 396, 63);
		panel_2.add(lblNewLabel_1);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Level 4");
		tglbtnNewToggleButton.setFont(new Font("Andy", Font.BOLD, 25));
        tglbtnNewToggleButton.setBounds(36, 133, 127, 43);
        panel_2.add(tglbtnNewToggleButton);
        tglbtnNewToggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userEmail = CourseManagement.getLoggedInUserEmail();
                displayData("SELECT `Level 4 module1`,`Level 4 module2`,`Level 4 module3` FROM courses " +
                        "JOIN student ON courses.`Course Name` = student.`Course Name` " +
                        "WHERE student.`mail` = '" + userEmail + "'");
            }
        });

        JToggleButton tglbtnLevel = new JToggleButton("Level 5");
        tglbtnLevel.setFont(new Font("Andy", Font.BOLD, 25));
        tglbtnLevel.setBounds(221, 133, 127, 43);
        panel_2.add(tglbtnLevel);
        tglbtnLevel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userEmail = CourseManagement.getLoggedInUserEmail();
                displayData("SELECT `Level 5 module1`,`Level 5 module2`,`Level 5 module3` FROM courses " +
                        "JOIN student ON courses.`Course Name` = student.`Course Name` " +
                        "WHERE student.`mail` = '" + userEmail + "'");
            }
        });

        JToggleButton tglbtnLevel_1 = new JToggleButton("Level 6");
        tglbtnLevel_1.setFont(new Font("Andy", Font.BOLD, 25));
        tglbtnLevel_1.setBounds(396, 133, 127, 43);
        panel_2.add(tglbtnLevel_1);
        tglbtnLevel_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userEmail = CourseManagement.getLoggedInUserEmail();
                displayData("SELECT `Level 6 module1`,`Level 6 module2`,`Level 6 module3` FROM courses " +
                        "JOIN student ON courses.`Course Name` = student.`Course Name` " +
                        "WHERE student.`mail` = '" + userEmail + "'");
            }
        });
    	
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 369, 567, 222);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		
		
		
		
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
				stud();
			}

			private void stud() {
				// TODO Auto-generated method stub
				new stucourses().setVisible(true);
			}
		});
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
				// TODO Auto-generated method stub
				new Settingstudent().setVisible(true);
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-setting-30-removebg-preview.png")));
		btnNewButton_5.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_5.setBackground(SystemColor.info);
		btnNewButton_5.setBounds(8, 264, 165, 55);
		panel_1.add(btnNewButton_5);
		
		
		JButton btnNewButton_6 = new JButton("Logout");
		btnNewButton_6.setIcon(new ImageIcon(Dashboard.class.getResource("/image/icons8-logout-30.png")));
		btnNewButton_6.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_6.setBackground(SystemColor.info);
		btnNewButton_6.setBounds(8, 343, 165, 55);
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

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(stucourses.this, "Error fetching data.");
	        }
	    }
	
	}

