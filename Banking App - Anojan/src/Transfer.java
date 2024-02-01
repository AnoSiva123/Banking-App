import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class Transfer {
    public JPanel transfer;
    private JTextField textField1;
    private JTextField textField2;
    private JButton sendButton;
    private JButton homeButton;
    private JButton accountsButton;
    private JButton settingsButton;
    private JButton transferButton1;
    private JTextArea transferTextArea;
    private JTextArea usernameTextArea;
    private JTextArea amountTextArea;
    private JTextArea selectAccountTextArea;
    private JButton chequingButton;
    private JButton savingsButton;
    static JFrame frame7 = new JFrame("Transfer");

    public Transfer() {
        chequingButton.setEnabled(false);
        transferButton1.setEnabled(false);
        frame7.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                if(Settings.bool2){
                    transfer.setBackground(Color.BLACK);
                    chequingButton.setEnabled(true);
                    transferButton1.setEnabled(true);
                }
                else{
                    transfer.setBackground(Color.WHITE);
                    chequingButton.setEnabled(true);
                    transferButton1.setEnabled(false);
                }
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame7.setVisible(false);
                Home.frame5.setVisible(true);
            }
        });
        accountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame7.setVisible(false);
                Accounts.frame6.setVisible(true);
            }
        });
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame7.setVisible(false);
                Settings.frame8.setVisible(true);
            }
        });
        chequingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chequingButton.setEnabled(false);
                savingsButton.setEnabled(true);
            }
        });
        savingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savingsButton.setEnabled(false);
                chequingButton.setEnabled(true);
            }
        });
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Main.returnClient(textField1.getText())==null){
                    JOptionPane.showMessageDialog(null,"Invalid Username.");
                    textField1.setText("");
                }
                else{
                    try{
                        if(!chequingButton.isEnabled()){
                            if(Objects.requireNonNull(Main.returnClient(Login.client)).getChequing()-Double.parseDouble(textField2.getText())<0){
                                JOptionPane.showMessageDialog(null,"Insufficient funds.");
                                textField2.setText("");
                            }
                            else if(!Accounts.countDecimalPlaces(Double.parseDouble(textField2.getText()))){
                                JOptionPane.showMessageDialog(null,"Invalid Input for Amount");
                                textField2.setText("");
                            }
                            else if((Double.parseDouble(textField2.getText()))>10000){
                                JOptionPane.showMessageDialog(null,"Exceeded transaction limit of $10000.");
                                textField2.setText("");
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Funds successfully transferred.");
                                Objects.requireNonNull(Main.returnClient(textField1.getText())).setChequing(Objects.requireNonNull(Main.returnClient(textField1.getText())).getChequing()+Double.parseDouble(textField2.getText()));
                                Objects.requireNonNull(Main.returnClient(Login.client)).setChequing(Objects.requireNonNull(Main.returnClient(Login.client)).getChequing()-Double.parseDouble(textField2.getText()));
                                textField1.setText("");
                                textField2.setText("");
                            }
                        }
                        if(!savingsButton.isEnabled()){
                            if(Objects.requireNonNull(Main.returnClient(Login.client)).getSavings()-Double.parseDouble(textField2.getText())<0){
                                JOptionPane.showMessageDialog(null,"Insufficient funds.");
                                textField2.setText("");
                            }
                            else if(!Accounts.countDecimalPlaces(Double.parseDouble(textField2.getText()))){
                                JOptionPane.showMessageDialog(null,"Invalid Input for Amount");
                                textField2.setText("");
                            }
                            else if((Double.parseDouble(textField2.getText()))>10000){
                                JOptionPane.showMessageDialog(null,"Exceeded transaction limit of $10000.");
                                textField2.setText("");
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Funds successfully transferred.");
                                Objects.requireNonNull(Main.returnClient(textField1.getText())).setSavings(Objects.requireNonNull(Main.returnClient(textField1.getText())).getSavings()+Double.parseDouble(textField2.getText()));
                                Objects.requireNonNull(Main.returnClient(Login.client)).setSavings(Objects.requireNonNull(Main.returnClient(Login.client)).getSavings()-Double.parseDouble(textField2.getText()));
                                textField1.setText("");
                                textField2.setText("");
                            }
                        }
                    }
                    catch(Exception exception){
                        JOptionPane.showMessageDialog(null,"Invalid Input for Amount");
                        textField2.setText("");
                    }
                }
            }
        });
    }
}
