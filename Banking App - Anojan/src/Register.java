import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Register {
    public static JFrame frame3 = new JFrame("Register");
    public JPanel RegisterPage;
    private JTextField Usernamefield;
    private JTextField Passwordfield;
    private JButton registerButton;
    private JButton backToLoginButton;
    private JLabel Username;
    private JLabel Password;
    private JPanel Sidebar1;
    private JPanel Sidebar2;
    private JLabel Icon;
    private JButton regularButton;
    private JButton studentButton;
    private boolean bool1 = false;

    public Register() {
        Login.clientList.add(new Client("Anojan","Sivaranjan",50412.77,24587.23,'l'));
        Login.clientList.add(new Client("Jaydon123","Meloche987",45945.54,28921.46,'l'));
        Login.clientList.add(new Client("123!@#","987(*&",73123.46,1876.54,'d'));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bool1 = false;
                for(Client client:Login.clientList){
                    if(client.getUsername().equals(Usernamefield.getText())){
                        bool1 = true;
                        break;
                    }
                }
                String text = Usernamefield.getText();
                String text1 = Passwordfield.getText();
                if(bool1){
                    JOptionPane.showMessageDialog(null,"Username already taken.");
                }
                else if(text.isEmpty() || text1.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please fill out all fields.");
                }
                else {
                    if(!regularButton.isEnabled()){
                       RegularAccount reg = new RegularAccount(Usernamefield.getText(), Passwordfield.getText(), 10000, 5000, 'l');
                       Login.clientList.add(new Client(Usernamefield.getText(), Passwordfield.getText(), 10000, 5000, 'l'));
                       Usernamefield.setText("");
                       Passwordfield.setText("");
                       frame3.setVisible(false);
                       Login.frame1.setVisible(true);
                    }
                    else if(!studentButton.isEnabled()){
                        StudentAccount stu = new StudentAccount(Usernamefield.getText(), Passwordfield.getText(), 'l');
                        Login.clientList.add(new Client(Usernamefield.getText(), Passwordfield.getText(), 0, 0, 'l'));
                        Usernamefield.setText("");
                        Passwordfield.setText("");
                        frame3.setVisible(false);
                        Login.frame1.setVisible(true);
                    }
                }
            }
        });
        backToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame3.setVisible(false);
                Login.frame1.setVisible(true);
            }
        });
        regularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularButton.setEnabled(false);
                studentButton.setEnabled(true);
            }
        });
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentButton.setEnabled(false);
                regularButton.setEnabled(true);
            }
        });
    }
}
