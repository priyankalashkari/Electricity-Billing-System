package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JTextField userText, pass;
    Choice loginChoice;
    JButton loginButton, cancelButton, signupButton;

    Login() { //constructor
        super("Login"); //super gives heading/title to the frame (super is the first statement)
        getContentPane().setBackground(Color.white);
        //username
        JLabel username = new JLabel("UserName");
        username.setBounds(300, 60, 100, 20);
        add(username);

        userText = new JTextField();
        userText.setBounds(400, 60, 150, 20);
        add(userText);

        //password
        JLabel password = new JLabel("password");
        password.setBounds(300, 100, 100, 20);
        add(password);

        pass = new JTextField();
        pass.setBounds(400, 100, 150, 20);
        add(pass);

        //login as
        JLabel log_in = new JLabel("Login As");
        log_in.setBounds(300, 140, 100, 20);
        add(log_in);

        loginChoice = new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400, 140, 150, 20);
        add(loginChoice);

        //buttons
        loginButton = new JButton("Login");
        loginButton.setBounds(330, 180, 100, 20);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(440, 180, 100, 20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        signupButton = new JButton("Signup");
        signupButton.setBounds(390, 210, 100, 20);
        signupButton.addActionListener(this);
        add(signupButton);

        //profile-1
        ImageIcon profileOne = new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profileTow = profileOne.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profileTow);
        JLabel profileLabel = new JLabel(fprofileOne);
        profileLabel.setBounds(5, 5, 250, 250);
        add(profileLabel);


        setSize(640, 300);
        setLocation(400, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
            //
        } else if(e.getSource() == cancelButton) {
            setVisible(false);
        } else if(e.getSource() == signupButton) {
            setVisible(false);
            new Signup();
        }

    }

    public static void main(String[] args) {
        new Login(); //object
    }
}
