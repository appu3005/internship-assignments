package swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sunbeam.DaoImpl.AdminDaoImpl;
import com.sunbeam.entity.Admin;

public class AdminLoginWindow extends JFrame {

    private JLabel lblTitle;
    private JLabel lblEmail;
    private JLabel lblPassword;

    private JTextField txtEmail;
    private JPasswordField txtPassword;

    private JButton btnLogin;
    private JButton btnBack;

    public AdminLoginWindow() {

        setTitle("Admin Login");
        setSize(500, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        
        lblTitle = new JLabel("ADMIN LOGIN");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setBounds(150, 30, 250, 30);
        add(lblTitle);

       
        lblEmail = new JLabel("Email");
        lblEmail.setBounds(80, 90, 100, 30);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(180, 90, 180, 30);
        add(txtEmail);

      
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(80, 140, 100, 30);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(180, 140, 180, 30);
        add(txtPassword);

       
        btnLogin = new JButton("Login");
        btnLogin.setBounds(120, 220, 100, 40);
        add(btnLogin);

      
        btnBack = new JButton("Back");
        btnBack.setBounds(250, 220, 100, 40);
        add(btnBack);

    
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String email = txtEmail.getText().trim();

                    String password =
                            String.valueOf(txtPassword.getPassword());

                    AdminDaoImpl dao =
                            new AdminDaoImpl();
                    
                    System.out.println("Email = " + email);
                    System.out.println("Password = " + password);

                    Admin admin = dao.logAdmin(email, password);

                    if(admin != null) {
                    	
                        JOptionPane.showMessageDialog(
                                AdminLoginWindow.this,
                                "Login Successful");

                        dispose();

                        AdminDashboardWindow dashboard =
                                new AdminDashboardWindow();

                        dashboard.setVisible(true);
                    }
                    else {

                        JOptionPane.showMessageDialog(
                                AdminLoginWindow.this,
                                "Invalid Email or Password");
                    }

                }
                catch(Exception ex) {

                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(
                            AdminLoginWindow.this,
                            ex.getMessage());
                }
            }
        });
        
       
        
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}