package swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdminDashboardWindow extends JFrame {

    private JLabel lblTitle;

    private JButton btnCreateQuiz;
    private JButton btnListQuiz;
    private JButton btnViewResult;
    private JButton btnDeleteQuiz;
    private JButton btnLogout;

    public AdminDashboardWindow() {

        setTitle("Admin Dashboard");
        setSize(600, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

       
        lblTitle = new JLabel("ADMIN DASHBOARD");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setBounds(170, 30, 300, 30);
        add(lblTitle);

        
        btnCreateQuiz = new JButton("Create Quiz");
        btnCreateQuiz.setBounds(190, 90, 200, 40);
        add(btnCreateQuiz);

        
        btnListQuiz = new JButton("List Quiz");
        btnListQuiz.setBounds(190, 150, 200, 40);
        add(btnListQuiz);

        
        btnViewResult = new JButton("View Result");
        btnViewResult.setBounds(190, 210, 200, 40);
        add(btnViewResult);

     
        btnDeleteQuiz = new JButton("Delete Quiz");
        btnDeleteQuiz.setBounds(190, 270, 200, 40);
        add(btnDeleteQuiz);

      
        btnLogout = new JButton("Logout");
        btnLogout.setBounds(190, 330, 200, 40);
        add(btnLogout);


        btnCreateQuiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CreateQuizWindow cq = new CreateQuizWindow();
                cq.setVisible(true);
            }
        });

   
        btnListQuiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ListQuizWindow lq = new ListQuizWindow();
                lq.setVisible(true);
            }
        });

       
        btnViewResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            	System.out.println("View Result Button Clicked");
            
                ViewResultWindow vr = new ViewResultWindow();
                vr.setVisible(true);
            }
        });

        
        btnDeleteQuiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DeleteQuizWindow dq = new DeleteQuizWindow();
                dq.setVisible(true);
            }
        });

       
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                new Swing().setVisible(true);
            }
        });
    }
}