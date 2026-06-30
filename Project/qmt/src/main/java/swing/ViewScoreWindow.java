package swing;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sunbeam.DAO.StudentDao;
import com.sunbeam.DaoImpl.StudentDaoImple;
import com.sunbeam.entity.Result;

public class ViewScoreWindow extends JFrame {

    private JLabel lblTitle;

    private JTable table;

    private JScrollPane scrollPane;

    private JButton btnBack;

    private DefaultTableModel model;

    private int studentId;

    public ViewScoreWindow(int studentId) {

        this.studentId = studentId;

        setTitle("View Scores");

        setSize(700,450);

        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lblTitle = new JLabel("MY SCORES");

        lblTitle.setFont(new Font("Arial",Font.BOLD,22));

        lblTitle.setBounds(250,20,250,30);

        add(lblTitle);

        model = new DefaultTableModel();

        model.addColumn("Result ID");
        model.addColumn("Student ID");
        model.addColumn("Quiz ID");
        model.addColumn("Score");

        table = new JTable(model);

        scrollPane = new JScrollPane(table);

        scrollPane.setBounds(40,80,600,230);

        add(scrollPane);

        btnBack = new JButton("Back");

        btnBack.setBounds(270,340,120,40);

        add(btnBack);

        loadScores();

        btnBack.addActionListener(e -> dispose());
    }

    private void loadScores() {

        try {

            model.setRowCount(0);

            StudentDao dao =
                    new StudentDaoImple();

            List<Result> scores =
                    dao.viewScores(studentId);

            for(Result r : scores) {

                model.addRow(new Object[] {

                        r.getResult_id(),
                        r.getStudent_id(),
                        r.getQuize_id(),
                        r.getScore()

                });

            }

        }

        catch(Exception e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());

            e.printStackTrace();

        }

    }

}