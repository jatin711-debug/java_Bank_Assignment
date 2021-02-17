public class ChequingAccount extends Account {
    //creating chequing Account which extemds main account class

    private final int overDraftLmit = 500;
    public ChequingAccount(String name, int accId, double rate, double balance) {
        super(name,accId,rate,balance);// calling Account class constructor and passing values
	}
	@Override
    public String toString() {
        //overriding toString 
        return( 
            "Chequing Account Created for "+this.getCustomerName()+" Successful"
         );
    }

    @Override
    public void withdraw(double amountWithdraw) {
        //overriding withdraw method
        if(amountWithdraw > overDraftLmit){
            System.out.println("Withdraw Amount Exceeds Overdraft limit");
            return;
        }else{
            this.customerBalance = this.customerBalance - amountWithdraw;
        }
    } 
}
