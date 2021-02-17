public class SavingsAccount extends Account{
    //creating Saving class extending main account class
    final int interestRate = 3;
    public SavingsAccount(String name, int accId, double rate, double balance) {
        super(name,accId,rate,balance);
	}
	@Override
    public String toString() {
        //overriding toString method
        return(
            "\n Saving Account created for"+this.getCustomerName()+" Successful \n"
        );
    }

    @Override
    public void deposit(double amountDeposit) {
        //overriding deposit method from account class
        this.customerBalance = this.customerBalance + amountDeposit + amountDeposit/2;
    }

    @Override
    public void withdraw(double amountWithdraw) {
        //overriding withdraw method 
        System.out.println("Sorry Withdraw Not Avaliable In savings Account");
        return;
    }
}
