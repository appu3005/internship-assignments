package swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sunbeam.DaoImpl.QuizzeDaoimpl;

public class CreateQuizWindow extends JFrame {

    private JLabel lblTitle;
    private JLabel lblQuizName;
    private JLabel lblFile;

    private JTextField txtQuizName;
    private JTextField txtFilePath;

    private JButton btnBrowse;
    private JButton btnCreate;
    private JButton btnBack;

    private File selectedFile;

    public CreateQuizWindow() {

        setTitle("Create Quiz");
        setSize(650,350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

       
        lblTitle = new JLabel("CREATE QUIZ");
        lblTitle.setFont(new Font("Arial", Font.BOLD,22));
        lblTitle.setBounds(220,20,250,30);
        add(lblTitle);

        
        lblQuizName = new JLabel("Quiz Name");
        lblQuizName.setBounds(60,80,100,30);
        add(lblQuizName);

        txtQuizName = new JTextField();
        txtQuizName.setBounds(180,80,350,30);
        add(txtQuizName);

        
        lblFile = new JLabel("Question File");
        lblFile.setBounds(60,140,100,30);
        add(lblFile);

        txtFilePath = new JTextField();
        txtFilePath.setBounds(180,140,250,30);
        txtFilePath.setEditable(false);
        add(txtFilePath);

       
        btnBrowse = new JButton("Browse");
        btnBrowse.setBounds(450,140,100,30);
        add(btnBrowse);

     
        btnCreate = new JButton("Create Quiz");
        btnCreate.setBounds(170,230,130,40);
        add(btnCreate);

    
        btnBack = new JButton("Back");
        btnBack.setBounds(340,230,130,40);
        add(btnBack);


        btnBrowse.addActionListener(e -> {

            JFileChooser chooser = new JFileChooser();

            int result = chooser.showOpenDialog(CreateQuizWindow.this);

            if(result == JFileChooser.APPROVE_OPTION){

                selectedFile = chooser.getSelectedFile();

                txtFilePath.setText(selectedFile.getAbsolutePath());
            }

        });

       
        btnCreate.addActionListener(e -> {

            String title = txtQuizName.getText().trim();

            if(title.isEmpty()){

                JOptionPane.showMessageDialog(CreateQuizWindow.this,
                        "Please Enter Quiz Title");

                return;
            }

            if(selectedFile == null){

                JOptionPane.showMessageDialog(CreateQuizWindow.this,
                        "Please Select Question File");

                return;
            }

            try{

                QuizzeDaoimpl dao = new QuizzeDaoimpl();

                dao.CreateQuizze(title, selectedFile.getAbsolutePath());

                JOptionPane.showMessageDialog(CreateQuizWindow.this,
                        "Quiz Created Successfully.");

                txtQuizName.setText("");
                txtFilePath.setText("");
                selectedFile = null;

            }
            catch(Exception ex){

                ex.printStackTrace();

                JOptionPane.showMessageDialog(CreateQuizWindow.this,
                        ex.getMessage());
            }

        });


        btnBack.addActionListener(e -> dispose());

    }}