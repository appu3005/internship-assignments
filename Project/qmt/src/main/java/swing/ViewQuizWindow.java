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

public class ViewQuizWindow extends JFrame {

    private JLabel lblTitle;

    private JTable table;

    private JScrollPane scrollPane;

    private JButton btnRefresh;

    private JButton btnBack;

    private DefaultTableModel model;

    public ViewQuizWindow() {

        setTitle("View Quiz");
        setSize(600, 450);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

 
        lblTitle = new JLabel("AVAILABLE QUIZZES");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setBounds(170, 20, 300, 30);
        add(lblTitle);

        
        model = new DefaultTableModel();

        model.addColumn("Quiz ID");
        model.addColumn("Quiz Title");

        table = new JTable(model);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 70, 480, 230);
        add(scrollPane);

      
        btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(120, 330, 120, 40);
        add(btnRefresh);

       
        btnBack = new JButton("Back");
        btnBack.setBounds(330, 330, 120, 40);
        add(btnBack);

        
        loadQuizzes();

        
        btnRefresh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                loadQuizzes();

            }

        });

        
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

            if(quizzes == null || quizzes.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "No Quiz Available");

                return;
            }

            for(Quizze q : quizzes) {

                model.addRow(new Object[] {

                        q.getQuizze_id(),
                        q.getTitle()

                });
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());

            e.printStackTrace();

        }

    }

}