package swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Swing extends JFrame {

    private JButton registerButton;
    private JButton adminLoginButton;
    private JButton studentLoginButton;
    private JButton ExitButton;
    private JLabel titleLabel;

    public Swing() {

     
        setTitle("Quiz Management System");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

       
        titleLabel = new JLabel("QUIZ MANAGEMENT SYSTEM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(120, 30, 350, 30);
        add(titleLabel);

        
        registerButton = new JButton("Register");
        registerButton.setBounds(200, 100, 150, 40);
        add(registerButton);

                adminLoginButton = new JButton("Admin Login");
        adminLoginButton.setBounds(200, 160, 150, 40);
        add(adminLoginButton);

        studentLoginButton = new JButton("Student Login");
        studentLoginButton.setBounds(200, 220, 150, 40);
        add(studentLoginButton);
        
        ExitButton = new JButton("Exit");
        ExitButton.setBounds(200, 280, 150, 40);
        add(ExitButton);

       
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterWindow rw = new RegisterWindow();
                rw.setVisible(true);
            }
        });

        
        adminLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminLoginWindow aw = new AdminLoginWindow();
                aw.setVisible(true);
            }
        });

       
        studentLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentLoginWindow sw = new StudentLoginWindow();
                sw.setVisible(true);
            }
        });
        
    
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int choice = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to exit?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION);

                if(choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) {

        Swing s = new Swing();
        s.setVisible(true);
    }
}