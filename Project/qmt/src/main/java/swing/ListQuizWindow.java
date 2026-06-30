package swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sunbeam.DaoImpl.QuizzeDaoimpl;
import com.sunbeam.entity.Quizze;

public class ListQuizWindow extends JFrame {

    private JLabel lblTitle;

    private JTable table;
    private JScrollPane scrollPane;

    private JButton btnRefresh;
    private JButton btnBack;

    private DefaultTableModel model;

    public ListQuizWindow() {

        setTitle("List Quiz");
        setSize(600, 450);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

       
        lblTitle = new JLabel("LIST OF QUIZZES");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setBounds(180, 20, 300, 30);
        add(lblTitle);

       
        model = new DefaultTableModel();

        model.addColumn("Quiz ID");
        model.addColumn("Quiz Title");

        table = new JTable(model);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 70, 500, 230);
        add(scrollPane);


        
        btnBack = new JButton("Back");
        btnBack.setBounds(320, 330, 120, 40);
        add(btnBack);

        
        loadQuizzes();


       
        btnBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

            }
        });

    }

    private void loadQuizzes() {

        try {

            model.setRowCount(0);

            QuizzeDaoimpl dao = new QuizzeDaoimpl();

            HashSet<Quizze> quizzes = dao.viewQuizzes();
            System.out.println("Total Quizzes = " + quizzes.size());

            for(Quizze q : quizzes) {

                model.addRow(new Object[] {

                        q.getQuizze_id(),
                        q.getTitle()

                });

            }

        }
        catch(Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(this,
                    e.getMessage());
        }
    }

}