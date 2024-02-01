import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class Enter_Password {
    public JPanel enter_password;
    private JTextArea enterPasswordTextArea;
    private JPasswordField passwordField1;
    private JButton verifyButton;
    static JFrame frame9 = new JFrame("Enter_Password");
    public static boolean bool3 = false;
    public static boolean bool6 = false;

    public Enter_Password() {
        frame9.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                passwordField1.setText("");
                if(Settings.bool2){
                    enter_password.setBackground(Color.BLACK);
                }
                else{
                    enter_password.setBackground(Color.WHITE);
                }
            }
        });
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(new String(passwordField1.getPassword()).equals(Objects.requireNonNull(Main.returnClient(Login.client)).getPassword())){
                    if(Settings.bool4){
                        bool3 = true;
                    }
                    if(Settings.bool5){
                        bool6 = true;
                    }
                    frame9.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Password.");
                }
            }
        });
    }
}
