import java.util.Date;

public class Account {
    //creaing Variables
    private String customerName;
    private int customerId;
    protected double customerBalance;
    private double annualInterestrate;
    private Date date;

    public Account() {
        //default constructor will give new date
        date = new Date();
    }

    public Date getDate() {
        //return date
        return date;
    }

    public Account(String custmerName,int accountNumber, double rate, double initBalace) {
        //creating parameterized constructor
        this(); //will invoke default-constructor
        this.customerName = custmerName;
        this.customerId = accountNumber;
        this.annualInterestrate = rate;
        this.customerBalance = initBalace;
    }

	public double getAnnualInterestrate() {
        //return annual rate
        return annualInterestrate;
    }

    public void setAnnualInterestrate(double annualInterestRate) {
        //set annual rate
        this.annualInterestrate = annualInterestRate;
    }

    public String getCustomerName() {
        //return customer name
        return customerName;
    }

    public void setCustomerName(String customerName) {
        //set customer name
        this.customerName = customerName;
    }

    public double getCustomerBalance() {
        //get customer balance
        return customerBalance;
    }

    public void setCustomerBalance(double customerBalance) {
        //set customer balance
        this.customerBalance = customerBalance;
    }

    public int getCustomerId() {
        //return customer id
        return customerId;
    }

    public void setCustomerId(int customerId) {
        //set customer id
        this.customerId = customerId;
    }

    public void deposit(double amountDeposit) {
        //method to deposit money in account
        this.customerBalance = this.customerBalance + amountDeposit;
    }

    public void withdraw(double amountWithdraw) {
        //to withdraw amount from account
        this.customerBalance = this.customerBalance - amountWithdraw;
    }

    public double monthlyInterest(){
        //return monthly interest
        return(this.customerBalance * (annualInterestrate /1200.00));
    }
}