import java.util.Date;

public class Account {
    private String customerName;
    private int customerId;
    protected double customerBalance;
    private double annualInterestrate;
    private Date date;

    public Account() {
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public Account(String custmerName,int accountNumber, double rate, double initBalace) {
        this();
        this.customerName = custmerName;
        this.customerId = accountNumber;
        this.annualInterestrate = rate;
        this.customerBalance = initBalace;
    }

	public double getAnnualInterestrate() {
        return annualInterestrate;
    }

    public void setAnnualInterestrate(double annualInterestRate) {
        this.annualInterestrate = annualInterestRate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(double customerBalance) {
        this.customerBalance = customerBalance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void deposit(double amountDeposit) {
        this.customerBalance = this.customerBalance + amountDeposit;
    }

    public void withdraw(double amountWithdraw) {
        this.customerBalance = this.customerBalance - amountWithdraw;
    }

    public double monthlyInterest(){
        return(this.customerBalance * (annualInterestrate /1200.00));
    }
}