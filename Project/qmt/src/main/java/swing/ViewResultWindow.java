package swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.sunbeam.DaoImpl.AdminDaoImpl;
import com.sunbeam.DaoImpl.QuizzeDaoimpl;
import com.sunbeam.entity.Result;

public class ViewResultWindow extends JFrame {

    private JLabel lblTitle;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton btnRefresh;
    private JButton btnBack;

    private DefaultTableModel model;

    public ViewResultWindow() {

        setTitle("View Result");
        setSize(700,450);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lblTitle = new JLabel("VIEW RESULTS");
        lblTitle.setFont(new Font("Arial",Font.BOLD,22));
        lblTitle.setBounds(230,20,250,30);
        add(lblTitle);

        model = new DefaultTableModel();

        model.addColumn("Result ID");
        model.addColumn("Student ID");
        model.addColumn("Quiz ID");
        model.addColumn("Score");

        table = new JTable(model);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40,70,600,250);
        add(scrollPane);

        btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(170,340,120,35);
        add(btnRefresh);

        btnBack = new JButton("Back");
        btnBack.setBounds(360,340,120,35);
        add(btnBack);

        loadResults();

        btnRefresh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                loadResults();

            }
        });

        btnBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

            }
        });

    }

    private void loadResults() {

        try {

            model.setRowCount(0);

            System.out.println("loadResults Called");

            AdminDaoImpl dao = new AdminDaoImpl();

            List<Result> list = dao.viewResult();

            System.out.println("Total Results = " + list.size());

            for(Result r : list) {

                model.addRow(new Object[] {

                    r.getResult_id(),
                    r.getStudent_id(),
                    r.getQuize_id(),
                    r.getScore()

                });

            }

        }
        catch(Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(this,e.getMessage());

        }

    }
}