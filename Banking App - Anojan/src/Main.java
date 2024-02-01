import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main{
    public static void main(String[] args) {
        Login.frame1.setContentPane(new Login().MyLogin);
        Login.frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login.frame1.pack();
        Login.frame1.setVisible(true);
        Invalid_Login.frame2.setContentPane(new Invalid_Login().InvalidLogin);
        Invalid_Login.frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Invalid_Login.frame2.pack();
        Invalid_Login.frame2.setVisible(false);
        Register.frame3.setContentPane(new Register().RegisterPage);
        Register.frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Register.frame3.pack();
        Register.frame3.setVisible(false);
        TooManyAttempts.frame4.setContentPane(new TooManyAttempts().TooManyAtt);
        TooManyAttempts.frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TooManyAttempts.frame4.pack();
        TooManyAttempts.frame4.setVisible(false);
        Home.frame5.setContentPane(new Home().home);
        Home.frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Home.frame5.pack();
        Home.frame5.setVisible(false);
        Accounts.frame6.setContentPane(new Accounts().accounts);
        Accounts.frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Accounts.frame6.pack();
        Accounts.frame6.setVisible(false);
        Transfer.frame7.setContentPane(new Transfer().transfer);
        Transfer.frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Transfer.frame7.pack();
        Transfer.frame7.setVisible(false);
        Settings.frame8.setContentPane(new Settings().settings);
        Settings.frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Settings.frame8.pack();
        Settings.frame8.setVisible(false);
        Enter_Password.frame9.setContentPane(new Enter_Password().enter_password);
        Enter_Password.frame9.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Enter_Password.frame9.pack();
        Enter_Password.frame9.setVisible(false);
    }
    public static Client returnClient(String clientName){
        for(Client client:Login.clientList){
            if(client.getUsername().equals(clientName)){
                return client;
            }
        }
        return null;
    }
}