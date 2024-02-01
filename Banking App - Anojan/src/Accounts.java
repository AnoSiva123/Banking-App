import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class Accounts {
    public JPanel accounts;
    private JButton chequingButton;
    private JButton savingsButton;
    private JTextField textField1;
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton homeButton;
    private JButton accountsButton;
    private JButton transferButton;
    private JButton settingsButton;
    private JTextArea accountsTextArea;
    private JTextArea totalTextArea;
    static JFrame frame6 = new JFrame("Accounts");

    public Accounts() {
        chequingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chequingButton.setEnabled(false);
                savingsButton.setEnabled(true);
                totalTextArea.setText(String.valueOf(Objects.requireNonNull(Main.returnClient(Login.client)).getChequing()));
            }
        });
        savingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savingsButton.setEnabled(false);
                chequingButton.setEnabled(true);
                totalTextArea.setText(String.valueOf(Objects.requireNonNull(Main.returnClient(Login.client)).getSavings()));
            }
        });
        frame6.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                if(Settings.bool2){
                    accounts.setBackground(Color.BLACK);
                    accountsButton.setEnabled(true);
                }
                else{
                    accounts.setBackground(Color.WHITE);
                    accountsButton.setEnabled(false);
                }
                if(!chequingButton.isEnabled()){
                    totalTextArea.setText(String.valueOf(Objects.requireNonNull(Main.returnClient(Login.client)).getChequing()));
                }
                if(!savingsButton.isEnabled()){
                    totalTextArea.setText(String.valueOf(Objects.requireNonNull(Main.returnClient(Login.client)).getSavings()));
                }
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame6.setVisible(false);
                Home.frame5.setVisible(true);
            }
        });
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame6.setVisible(false);
                Transfer.frame7.setVisible(true);
            }
        });
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame6.setVisible(false);
                Settings.frame8.setVisible(true);
            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(!chequingButton.isEnabled()){
                        if(Objects.requireNonNull(Main.returnClient(Login.client)).getChequing()-Double.parseDouble(textField1.getText())<0){
                            JOptionPane.showMessageDialog(null,"Insufficient funds.");
                            textField1.setText("");
                        }
                        else if(!countDecimalPlaces(Double.parseDouble(textField1.getText()))){
                            JOptionPane.showMessageDialog(null,"Invalid Input");
                            textField1.setText("");
                        }
                        else if((Double.parseDouble(textField1.getText()))>1000){
                            JOptionPane.showMessageDialog(null,"Exceeded withdraw limit of $1000.");
                            textField1.setText("");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Scan QR Code on ATM.");
                            Objects.requireNonNull(Main.returnClient(Login.client)).setChequing(Objects.requireNonNull(Main.returnClient(Login.client)).getChequing()-Double.parseDouble(textField1.getText()));
                            totalTextArea.setText(String.valueOf(Objects.requireNonNull(Main.returnClient(Login.client)).getChequing()));
                            textField1.setText("");
                        }
                    }
                    if(!savingsButton.isEnabled()){
                        if(Objects.requireNonNull(Main.returnClient(Login.client)).getSavings()-Double.parseDouble(textField1.getText())<0){
                            JOptionPane.showMessageDialog(null,"Insufficient funds.");
                            textField1.setText("");
                        }
                        else if(!countDecimalPlaces(Double.parseDouble(textField1.getText()))){
                            JOptionPane.showMessageDialog(null,"Invalid Input");
                            textField1.setText("");
                        }
                        else if((Double.parseDouble(textField1.getText()))>1000){
                            JOptionPane.showMessageDialog(null,"Exceeded withdraw limit of $1000.");
                            textField1.setText("");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Scan QR Code on ATM.");
                            Objects.requireNonNull(Main.returnClient(Login.client)).setSavings(Objects.requireNonNull(Main.returnClient(Login.client)).getSavings()-Double.parseDouble(textField1.getText()));
                            totalTextArea.setText(String.valueOf(Objects.requireNonNull(Main.returnClient(Login.client)).getSavings()));
                            textField1.setText("");
                        }
                    }
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"Invalid Input");
                    textField1.setText("");
                }
            }
        });
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(!chequingButton.isEnabled()){
                        if(!countDecimalPlaces(Double.parseDouble(textField1.getText()))){
                            JOptionPane.showMessageDialog(null,"Invalid Input");
                            textField1.setText("");
                        }
                        else if((Double.parseDouble(textField1.getText()))>100000){
                            JOptionPane.showMessageDialog(null,"Exceeded deposit limit of $100000.");
                            textField1.setText("");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Upload photos of the front and back of the cheque.");
                            Objects.requireNonNull(Main.returnClient(Login.client)).setChequing(Objects.requireNonNull(Main.returnClient(Login.client)).getChequing()+Double.parseDouble(textField1.getText()));
                            totalTextArea.setText(String.valueOf(Objects.requireNonNull(Main.returnClient(Login.client)).getChequing()));
                            textField1.setText("");
                        }
                    }
                    if(!savingsButton.isEnabled()){
                        if(!countDecimalPlaces(Double.parseDouble(textField1.getText()))){
                            JOptionPane.showMessageDialog(null,"Invalid Input");
                            textField1.setText("");
                        }
                        else if((Double.parseDouble(textField1.getText()))>100000){
                            JOptionPane.showMessageDialog(null,"Exceeded deposit limit of $100000.");
                            textField1.setText("");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Upload photos of the front and back of the cheque.");
                            Objects.requireNonNull(Main.returnClient(Login.client)).setSavings(Objects.requireNonNull(Main.returnClient(Login.client)).getSavings()+Double.parseDouble(textField1.getText()));
                            totalTextArea.setText(String.valueOf(Objects.requireNonNull(Main.returnClient(Login.client)).getSavings()));
                            textField1.setText("");
                        }
                    }
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"Invalid Input");
                    textField1.setText("");
                }
            }
        });
    }
    public static boolean countDecimalPlaces(double number) {
        String numberStr = Double.toString(Math.abs(number));
        int integerPlaces = numberStr.indexOf('.');
        int decimalPlaces = 0;
        if(integerPlaces>0) {
            decimalPlaces = numberStr.length()-integerPlaces-1;
        }
        return decimalPlaces <= 2;
    }
}
