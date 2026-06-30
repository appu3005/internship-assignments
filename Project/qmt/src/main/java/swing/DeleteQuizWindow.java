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

public class DeleteQuizWindow extends JFrame {

    private JLabel lblTitle;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    private JButton btnDelete;
    private JButton btnBack;

    public DeleteQuizWindow() {

        setTitle("Delete Quiz");
        setSize(700, 450);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lblTitle = new JLabel("DELETE QUIZ");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setBounds(230, 20, 250, 30);
        add(lblTitle);

        String column[] = { "Quiz ID", "Quiz Name" };

        model = new DefaultTableModel(column, 0);

        table = new JTable(model);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 80, 580, 220);
        add(scrollPane);

        btnDelete = new JButton("Delete Selected");
        btnDelete.setBounds(150, 340, 150, 40);
        add(btnDelete);

        btnBack = new JButton("Back");
        btnBack.setBounds(360, 340, 120, 40);
        add(btnBack);

        // Load all quizzes
        loadQuizzes();

        btnDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    int row = table.getSelectedRow();

                    if (row == -1) {

                        JOptionPane.showMessageDialog(null,
                                "Please Select Quiz");

                        return;
                    }

                    int quizId =
                            (Integer) model.getValueAt(row, 0);

                    QuizzeDaoimpl dao =
                            new QuizzeDaoimpl();

                    int count =
                            dao.deleteQuizze(quizId);

                    if (count > 0) {

                        model.removeRow(row);

                        JOptionPane.showMessageDialog(null,
                                "Quiz Deleted Successfully");
                    } else {

                        JOptionPane.showMessageDialog(null,
                                "Quiz Not Found");
                    }

                } catch (Exception ex) {

                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(null,
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

    // Load quizzes into table
    private void loadQuizzes() {

        try {

            model.setRowCount(0);

            QuizzeDaoimpl dao =
                    new QuizzeDaoimpl();

            HashSet<Quizze> quizzes =
                    dao.viewQuizzes();

            System.out.println("Total Quiz = "
                    + quizzes.size());

            for (Quizze q : quizzes) {

                System.out.println(
                        q.getQuizze_id() + " "
                                + q.getTitle());

                model.addRow(new Object[] {

                        q.getQuizze_id(),
                        q.getTitle()

                });
            }

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(this,
                    e.getMessage());
        }
    }
}