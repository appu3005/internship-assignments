package swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sunbeam.DaoImpl.StudentDaoImple;
import com.sunbeam.entity.Student;

public class StudentLoginWindow extends JFrame {

    private JLabel lblTitle;
    private JLabel lblEmail;
    private JLabel lblPassword;

    private JTextField txtEmail;
    private JPasswordField txtPassword;

    private JButton btnLogin;
    private JButton btnBack;

    public StudentLoginWindow() {

        setTitle("Student Login");
        setSize(500, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

      
        lblTitle = new JLabel("STUDENT LOGIN");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setBounds(140, 30, 250, 30);
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

                String email = txtEmail.getText().trim();

                String password =
                        String.valueOf(
                                txtPassword.getPassword());

                try {

                    StudentDaoImple dao =
                            new StudentDaoImple();

                    Student student =
                            dao.loginStudent(email,password);

                    if(student != null) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Login Successful");

                        dispose();

                        StudentDashboardWindow dashboard =
                                new StudentDashboardWindow(
                                        student.getStudent_id());

                        dashboard.setVisible(true);
                    }
                    else {

                        JOptionPane.showMessageDialog(
                                null,
                                "Invalid Email or Password");
                    }

                }
                catch(Exception ex) {

                    ex.printStackTrace();
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