package swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sunbeam.DaoImpl.StudentDaoImple;
import com.sunbeam.entity.Student;

public class RegisterWindow extends JFrame {

    private JLabel lblTitle, lblName, lblEmail, lblPassword;
    private JTextField txtName, txtEmail;
    private JPasswordField txtPassword;
    private JButton btnRegister, btnBack;

    public RegisterWindow() {

        setTitle("Student Registration");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        lblTitle = new JLabel("Student Registration");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setBounds(140, 20, 250, 30);
        add(lblTitle);

        
        lblName = new JLabel("Name");
        lblName.setBounds(80, 80, 100, 30);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(180, 80, 180, 30);
        add(txtName);

     
        lblEmail = new JLabel("Email");
        lblEmail.setBounds(80, 130, 100, 30);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(180, 130, 180, 30);
        add(txtEmail);

        
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(80, 180, 100, 30);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(180, 180, 180, 30);
        add(txtPassword);

        
        btnRegister = new JButton("Register");
        btnRegister.setBounds(120, 260, 100, 40);
        add(btnRegister);

    
        btnBack = new JButton("Back");
        btnBack.setBounds(250, 260, 100, 40);
        add(btnBack);

        btnRegister.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String name = txtName.getText();
                    String email = txtEmail.getText();
                    String password =
                            String.valueOf(txtPassword.getPassword());

                    Student student = new Student();

                    student.setStd_name(name);
                    student.setEmail_id(email);
                    student.setPassword(password);

                    StudentDaoImple dao =
                            new StudentDaoImple();

                    int count =
                            dao.addStudent(student);

                    if(count > 0) {

                        JOptionPane.showMessageDialog(
                                RegisterWindow.this,
                                "Registration Successful!");

                        txtName.setText("");
                        txtEmail.setText("");
                        txtPassword.setText("");
                    }
                    else {

                        JOptionPane.showMessageDialog(
                                RegisterWindow.this,
                                "Registration Failed!");
                    }

                }
                catch(Exception ex) {

                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(
                            RegisterWindow.this,
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