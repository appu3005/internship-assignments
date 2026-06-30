package swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.sunbeam.DaoImpl.QuizzeDaoimpl;
import com.sunbeam.entity.Question;

public class TakeQuizWindow extends JFrame {

    private JLabel lblTitle;
    private JLabel lblQuizId;
    private JLabel lblQuestion;

    private JTextField txtQuizId;

    private JButton btnStart;
    private JButton btnNext;

    private JRadioButton rbA;
    private JRadioButton rbB;
    private JRadioButton rbC;
    private JRadioButton rbD;

    private ButtonGroup group;

    private List<Question> questions;

    private int current = 0;
    private int score = 0;

    private int studentId;

    public TakeQuizWindow(int studentId) {

        this.studentId = studentId;

        setTitle("Take Quiz");
        setSize(700,500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lblTitle = new JLabel("TAKE QUIZ");
        lblTitle.setFont(new Font("Arial",Font.BOLD,22));
        lblTitle.setBounds(260,20,200,30);
        add(lblTitle);

        lblQuizId = new JLabel("Quiz ID");
        lblQuizId.setBounds(60,70,80,30);
        add(lblQuizId);

        txtQuizId = new JTextField();
        txtQuizId.setBounds(150,70,150,30);
        add(txtQuizId);

        btnStart = new JButton("Start Quiz");
        btnStart.setBounds(340,70,130,30);
        add(btnStart);

        lblQuestion = new JLabel("");
        lblQuestion.setBounds(60,130,600,30);
        add(lblQuestion);

        rbA = new JRadioButton();
        rbA.setBounds(80,180,500,30);
        add(rbA);

        rbB = new JRadioButton();
        rbB.setBounds(80,220,500,30);
        add(rbB);

        rbC = new JRadioButton();
        rbC.setBounds(80,260,500,30);
        add(rbC);

        rbD = new JRadioButton();
        rbD.setBounds(80,300,500,30);
        add(rbD);

        group = new ButtonGroup();
        group.add(rbA);
        group.add(rbB);
        group.add(rbC);
        group.add(rbD);

        btnNext = new JButton("Next");
        btnNext.setBounds(280,370,120,40);
        btnNext.setEnabled(false);
        add(btnNext);

      
        btnStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    int quizId = Integer.parseInt(txtQuizId.getText());

                    QuizzeDaoimpl dao = new QuizzeDaoimpl();

                    questions = dao.getQuestions(quizId);
                    
                    System.out.println("Questions Loaded = "
                            + questions.size());

                    if(questions.isEmpty()) {

                        JOptionPane.showMessageDialog(null,
                                "No Questions Found");

                        return;
                    }

                    current = 0;
                    score = 0;

                    showQuestion();

                    btnNext.setEnabled(true);

                }

                catch(Exception ex) {

                    JOptionPane.showMessageDialog(null,
                            ex.getMessage());

                }

            }

        });



        btnNext.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                checkAnswer();

                current++;

                if(current < questions.size()) {

                    showQuestion();

                }
                else {

                    try {

                        int quizId = Integer.parseInt(txtQuizId.getText());

                        QuizzeDaoimpl dao = new QuizzeDaoimpl();

                        dao.saveResult(studentId, quizId, score);

                        JOptionPane.showMessageDialog(null,
                                "Quiz Completed\n\nScore : "
                                        + score + "/" + questions.size());

                        dispose();

                    }

                    catch(Exception ex) {

                        ex.printStackTrace();

                    }

                }

            }

        });

    }

   

    private void showQuestion() {

        Question q = questions.get(current);

        System.out.println("Question = " + q.getQuestion());
        System.out.println("Correct Answer DB = " + q.getCorrect_ans());

        lblQuestion.setText((current + 1) + ". " + q.getQuestion());

        rbA.setText("A. " + q.getOption_A());
        rbB.setText("B. " + q.getOption_B());
        rbC.setText("C. " + q.getOption_C());
        rbD.setText("D. " + q.getOption_D());

        group.clearSelection();
    }
    

    private void checkAnswer() {

        Question q = questions.get(current);

        String answer = "";

        if (rbA.isSelected())
            answer = "A";

        else if (rbB.isSelected())
            answer = "B";

        else if (rbC.isSelected())
            answer = "C";

        else if (rbD.isSelected())
            answer = "D";

        System.out.println("Selected = " + answer);
        System.out.println("Correct = " + q.getCorrect_ans());

        if (answer.trim().equalsIgnoreCase(q.getCorrect_ans().trim())) {

            score++;

            System.out.println("Correct Answer");
        }
        else {

            System.out.println("Wrong Answer");
        }

        System.out.println("Current Score = " + score);
    }

}
