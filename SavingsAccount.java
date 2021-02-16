public class SavingsAccount extends Account{
    final int interestRate = 3;
    public SavingsAccount(String name, int accId, double rate, double balance) {
        super(name,accId,rate,balance);
	}
	@Override
    public String toString() {
        return(
            "\n Saving Account created for"+this.getCustomerName()+" Successful \n"
        );
    }

    @Override
    public void deposit(double amountDeposit) {
        this.customerBalance = this.customerBalance + amountDeposit + amountDeposit/2;
    }

    @Override
    public void withdraw(double amountWithdraw) {
        System.out.println("Sorry Withdraw Not Avaliable In savings Account");
        return;
    }
}
