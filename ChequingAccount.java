public class ChequingAccount extends Account {
    private final int overDraftLmit = 500;
    public ChequingAccount(String name, int accId, double rate, double balance) {
        super(name,accId,rate,balance);
	}
	@Override
    public String toString() {
        return( 
            "Chequing Account Created for "+this.getCustomerName()+" Successful"
         );
    }

    @Override
    public void withdraw(double amountWithdraw) {
        if(amountWithdraw > overDraftLmit){
            System.out.println("Withdraw Amount Exceeds Overdraft limit");
            return;
        }else{
            this.customerBalance = this.customerBalance - amountWithdraw;
        }
    } 
}
