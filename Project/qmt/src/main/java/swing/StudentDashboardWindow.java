package swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StudentDashboardWindow extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel lblTitle;

    private JButton btnViewQuiz;
    private JButton btnTakeQuiz;
    private JButton btnViewScore;
    private JButton btnLogout;

    private int studentId;

    public StudentDashboardWindow(int studentId) {

        this.studentId = studentId;

        setTitle("Student Dashboard");
        setSize(600,450);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        

        lblTitle = new JLabel("STUDENT DASHBOARD");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setBounds(150, 30, 350, 30);
        add(lblTitle);


        btnViewQuiz = new JButton("View Quiz");
        btnViewQuiz.setBounds(180, 100, 200, 40);
        add(btnViewQuiz);


        btnTakeQuiz = new JButton("Take Quiz");
        btnTakeQuiz.setBounds(180, 160, 200, 40);
        add(btnTakeQuiz);


        btnViewScore = new JButton("View Score");
        btnViewScore.setBounds(180, 220, 200, 40);
        add(btnViewScore);

        
        btnLogout = new JButton("Logout");
        btnLogout.setBounds(180, 280, 200, 40);
        add(btnLogout);

       
        btnViewQuiz.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ViewQuizWindow view = new ViewQuizWindow();
                view.setVisible(true);

            }

        });

        

        btnTakeQuiz.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                TakeQuizWindow take = new TakeQuizWindow(studentId);
                take.setVisible(true);

            }

        });



        btnViewScore.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	ViewScoreWindow score = new ViewScoreWindow(studentId);
            	score.setVisible(true);
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