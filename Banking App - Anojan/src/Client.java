public class Client {
    String username;
    String password;
    double chequing;
    double savings;
    char mode;
    public Client(String username, String password, double chequing, double savings, char mode) {
        this.username = username;
        this.password = password;
        this.chequing = chequing;
        this.savings = savings;
        this.mode = mode;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getChequing() {
        return chequing;
    }

    public void setChequing(double chequing) {
        this.chequing = chequing;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public char getMode() {
        return mode;
    }

    public void setMode(char mode) {
        this.mode = mode;
    }
}
