import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class Home{
    public JPanel home;
    private JButton homeButton;
    private JButton accountsButton;
    private JButton transferButton;
    private JButton settingsButton;
    static JFrame frame5 = new JFrame("Home");

    public Home() {
        homeButton.setEnabled(false);
        frame5.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                if(Settings.bool2){
                    home.setBackground(Color.BLACK);
                    homeButton.setEnabled(true);
                }
                else{
                    home.setBackground(Color.WHITE);
                    homeButton.setEnabled(false);
                }
            }
        });
        accountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame5.setVisible(false);
                Accounts.frame6.setVisible(true);
            }
        });
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame5.setVisible(false);
                Transfer.frame7.setVisible(true);
            }
        });
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame5.setVisible(false);
                Settings.frame8.setVisible(true);
            }
        });
    }
}
