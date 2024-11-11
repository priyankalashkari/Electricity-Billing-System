package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {
    Choice loginAsCho;
    TextField meterText, employerText, userNameText, nameText, passwordText;
    JButton create, back;
    //constructor
    Signup() {
        super("Sign Up");
        getContentPane().setBackground(new Color(168, 203, 255));

        //Create Account As
        JLabel createAs = new JLabel("Create Account As");
        createAs.setBounds(30, 50, 125, 20);
        add(createAs);

        loginAsCho = new Choice();
        loginAsCho.add("Admin");
        loginAsCho.add("Customer");
        loginAsCho.setBounds(170, 50, 120, 20);
        add(loginAsCho);


        //meter No.
        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(30, 100, 125, 20);
        meterNo.setVisible(false);
        add(meterNo);

        meterText = new TextField();
        meterText.setBounds(170, 100, 125, 20);
        meterText.setVisible(false);
        add(meterText);

        //employer ID
        JLabel employer = new JLabel("Employer ID");
        employer.setBounds(30, 100, 125, 20);
        employer.setVisible(true);
        add(employer);

        employerText = new TextField();
        employerText.setBounds(170, 100, 125, 20);
        employer.setVisible(true);
        add(employerText);


        //username
        JLabel userName = new JLabel("Username");
        userName.setBounds(30, 140, 125, 20);
        add(userName);

        userNameText = new TextField();
        userNameText.setBounds(170, 140, 125, 20);
        add(userNameText);


        //Name
        JLabel name = new JLabel("Name");
        name.setBounds(30, 180, 125, 20);
        add(name);

        nameText = new TextField();
        nameText.setBounds(170, 180, 125, 20);
        add(nameText);


        //Password
        JLabel password = new JLabel("Password");
        password.setBounds(30, 220, 125, 20);
        add(password);

        passwordText = new TextField();
        passwordText.setBounds(170, 220, 125, 20);
        add(passwordText);

        //choice of Login
        loginAsCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = loginAsCho.getSelectedItem();
                if(user.equals("Customer")) {
                    employer.setVisible(false);
                    employerText.setVisible(false);
                    meterNo.setVisible(true);
                    meterText.setVisible(true);
                } else {
                    employer.setVisible(true);
                    employerText.setVisible(true);
                    meterNo.setVisible(false);
                    meterText.setVisible(false);
                }
            }
        });


        //Buttons
        create = new JButton("Create");
        create.setBackground(new Color(24, 14, 234));
        create.setForeground(Color.white); //for text color
        create.setBounds(50, 280, 100, 25);
        create.addActionListener(this);
        add(create);

        back = new JButton("Back");
        back.setBackground(new Color(24, 14, 234));
        back.setForeground(Color.white); //for text color
        back.setBounds(180, 280, 100, 25);
        back.addActionListener(this);
        add(back);


        //Profile image
        ImageIcon boyIcon = new ImageIcon(ClassLoader.getSystemResource("icon/sign-up.png"));
        Image boyImg = boyIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon boyIcon2 = new ImageIcon(boyImg);
        JLabel boyLabel = new JLabel(boyIcon2);
        boyLabel.setBounds(320, 40, 250, 250);
        add(boyLabel);



        setSize(600, 380);
        setLocation(500, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == create) {
            String sloginAs = loginAsCho.getSelectedItem();
            String susername = userNameText.getText();
            String sname = nameText.getText();
            String spassword = passwordText.getText();
            String smeter = meterText.getText();
            try {
                database c = new database();
                String query = null;
                query = "insert into Signup value('"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"', '"+sloginAs+"')";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created");
                setVisible(false); //sign up will be closed
                new Login(); //login page will open
            } catch(Exception E) {
                E.printStackTrace();
            }
        } else if(e.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        //object
        new Signup();
    }
}
