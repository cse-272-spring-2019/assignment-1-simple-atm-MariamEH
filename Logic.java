
public class Logic {

    String userCardNumber = "123";
    private double balance;
    private double withdraw;
    private double deposit;


    public boolean validate(String cardNum) {
        boolean validation = true;
        if (userCardNumber.equals(cardNum) == false)
            validation = false;

        return validation;
    }

    public Logic(double balance) {
        if (balance >= 0)
            this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
            this.withdraw = withdraw;
        balance = balance - withdraw;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
            this.deposit = deposit;
        balance = balance + deposit;
    }
}

