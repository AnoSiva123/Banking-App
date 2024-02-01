import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class Settings{
    public JPanel settings;
    private JCheckBox checkBox1;
    private JTextField textField1;
    private JButton changeButton;
    private JPasswordField textField2;
    private JButton changeButton1;
    private JButton homeButton;
    private JButton accountsButton;
    private JButton settingsButton;
    private JButton transferButton;
    private JTextArea darkModeTextArea;
    private JTextArea usernameTextArea;
    private JTextArea passwordTextArea;
    private JButton logOutButton;
    static JFrame frame8 = new JFrame("Settings");
    public static boolean bool2 = false;
    public static boolean bool4 = false;
    public static boolean bool5 = false;
    public Settings() {
        frame8.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                if(bool2){
                    settings.setBackground(Color.BLACK);
                    settingsButton.setEnabled(true);
                    checkBox1.setSelected(true);
                }
                else{
                    settings.setBackground(Color.WHITE);
                    settingsButton.setEnabled(false);
                    checkBox1.setSelected(false);
                }
                if(Enter_Password.bool3){
                    Objects.requireNonNull(Main.returnClient(Login.client)).setUsername(textField1.getText());
                    Login.client = textField1.getText();
                    JOptionPane.showMessageDialog(null,"Username changed successfully.");
                    bool4 = false;
                    Enter_Password.bool3 = false;
                }
                if(Enter_Password.bool6){
                    Objects.requireNonNull(Main.returnClient(Login.client)).setPassword(new String(textField2.getPassword()));
                    JOptionPane.showMessageDialog(null,"Password changed successfully.");
                    bool5 = false;
                    Enter_Password.bool6 = false;
                }
                textField1.setText(Objects.requireNonNull(Main.returnClient(Login.client)).getUsername());
                textField2.setText(Objects.requireNonNull(Main.returnClient(Login.client)).getPassword());
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame8.setVisible(false);
                Home.frame5.setVisible(true);
            }
        });
        accountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame8.setVisible(false);
                Accounts.frame6.setVisible(true);
            }
        });
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame8.setVisible(false);
                Transfer.frame7.setVisible(true);
            }
        });
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkBox1.isSelected()){
                    bool2 = true;
                    Objects.requireNonNull(Main.returnClient(Login.client)).setMode('d');
                    settings.setBackground(Color.BLACK);
                    settingsButton.setEnabled(true);
                }
                else{
                    bool2 = false;
                    Objects.requireNonNull(Main.returnClient(Login.client)).setMode('l');
                    settings.setBackground(Color.WHITE);
                    settingsButton.setEnabled(false);
                }
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame8.setVisible(false);
                Login.frame1.setVisible(true);
            }
        });
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bool4 = true;
                Enter_Password.frame9.setVisible(true);
            }
        });
        changeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bool5 = true;
                Enter_Password.frame9.setVisible(true);
            }
        });
    }
}
