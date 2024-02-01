import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Login {
    public static JFrame frame1 = new JFrame("Login");
    public JPanel MyLogin;
    private JTextField Usernameinput;
    private JTextField Passwordinput;
    private JButton loginButton;
    private JLabel Sidebar2;
    private JLabel Sidebar1;
    private JLabel Icon;
    private JLabel Username;
    private JLabel Password;
    private JButton RegisterButton;
    private int counter = 0;
    public static String client;
    public static List<Client> clientList = new ArrayList<>();
    private boolean bool1 = false;

    public Login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Client client:clientList){
                    if(client.getUsername().equals(Usernameinput.getText()) && client.getPassword().equals(Passwordinput.getText())){
                        bool1 = true;
                    }
                }
                if(bool1){
                    client = Usernameinput.getText();
                    Usernameinput.setText("");
                    Passwordinput.setText("");
                    Settings.bool2 = Objects.requireNonNull(Main.returnClient(Login.client)).getMode() != 'l';
                    frame1.setVisible(false);
                    Home.frame5.setVisible(true);
                    counter = 0;
                    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                    scheduler.scheduleAtFixedRate(new AddSavings(), 1, 1, TimeUnit.MINUTES);
                }
                else{
                    counter+=1;
                    if(counter>=3){
                        TooManyAttempts.frame4.setVisible(true);
                    }
                    else{
                        Invalid_Login.frame2.setVisible(true);
                    }
                }
            }
        });
        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usernameinput.setText("");
                Passwordinput.setText("");
                frame1.setVisible(false);
                Register.frame3.setVisible(true);
            }
        });
    }
}
