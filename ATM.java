import java.text.DecimalFormat;
import java.util.Scanner;

public class ATM {
    //creating ATM class

    final static Scanner scan = new Scanner(System.in);// using Scanner class
    Account account[] = new Account[10]; // Account class as array for holding objects
    private int savingIndex = 0; 

    private boolean accountIdNumChecker(int value) {
        //will return true if id already exist
        for(int i=savingIndex-1;i>=0;i--) {
            if(account[i].getCustomerId() == value){
                return true;
            }
        }
        return false;
    }
    
    void createChequingAccount(String name,int accId,double rate,double balance,int index) {
        //will create Chequing Account depending upon parameters
        if(rate > 1) {
            System.out.println("max of 1% is required for Chequing Account\n"+"Please try again");
            this.menu();
            return;
        }
        else if(accountIdNumChecker(accId)){
            System.out.println("Account Number You entered Is already registered, Please Try with New One");
            this.menu();
            return;
        }else{
            account[index] = new ChequingAccount(name,accId,rate,balance);
            System.out.println(account[index]);
        }
        
    }

    void createSavingAccount(String name,int accId,double rate,double balance,int index) {
        //will create Saving Account depending upon parameters
        if(rate < 3) {
            System.out.println("Min of 3% is required for Saving Account\n"+"Please try again");
            this.menu();
        }
        else if(accountIdNumChecker(accId)){
            System.out.println("Account Number You entered Is already registered, Please Try with New One");
            this.menu();
            return;
        }
        else{
            account[index] = new SavingsAccount(name,accId,rate,balance);
            System.out.println(account[index]);
        }
        
    }

    public void createAccount(int holder) {
        // Creating Account 
        System.out.println("Account ID");
        int accountId = scan.nextInt();
        try {
            //checking if user inputs negative number
            if(accountId < 0) throw new RuntimeException();
        }catch (Exception e) {
            System.err.println(e.getMessage());
            createAccount(holder);
        } 
        System.out.println("Enter Customer Name");
        String name = scan.next();
        System.out.println("Initial Balance");
        double initBalance = scan.nextDouble();
        System.out.println("Annual Interest Rate");
        double rate = scan.nextDouble();
        System.out.println("What Type of Account You Want to Create?");
        System.out.println("1. Chequing Account");
        System.out.println("2. Saving Account");
        int accountInfo = scan.nextInt();
        if(accountInfo == 1) {
            //calling method to create cheqAccount
            createChequingAccount(name,accountId,rate,initBalance,holder);

        }else if(accountInfo == 2){
            //calling method to create savinAccount
            createSavingAccount(name,accountId,rate,initBalance,holder);
        }
    }
    public void userOutput(int keyvalue) {
        //created Method to show output according to user need
        switch(keyvalue){
            case 1:{
                System.out.println("#_SPECIFY FOLLOW DETAILS_#");
                createAccount(savingIndex);
                savingIndex++;
                break;
            }
            case 2:{
                System.out.println("Customer : "+ account[savingIndex-1].getCustomerName());
                System.out.println("Account Balance : "+ account[savingIndex-1].getCustomerBalance());
                System.out.println("Monthly Interest earned: "+ DecimalFormat.getInstance().format(account[savingIndex-1].monthlyInterest()));
                System.out.println("Account Created On: "+ account[savingIndex-1].getDate());
                break;
            }
            
            case 3:{
                System.out.print("Enter Amount to withdraw: ");
                account[savingIndex-1].withdraw(scan.nextDouble());
                break;
            }

            case 4:{
                System.out.print("Enter Amount to Deposit: ");
                account[savingIndex-1].deposit(scan.nextDouble());
                break;
            }
            default: System.out.print("Invalid Input please try again");
        }
    }

    public void menu() {

        // will display Menu to user
        System.out.print("Enter an account ID:");
        while(true){
            System.out.println(" #___Main Menu___# \n"+"1. Create Account \n"+"2. Account Info \n"+"3. Withdraw \n"+"4. Deposit \n"+"5. Exit \n");
            System.out.print("Please Choose What would you like to do : ");
            int userChoice = scan.nextInt();
            if(userChoice == 5) System.exit(1);
            userOutput(userChoice);
        }
    }
    public static void main(String args[]){
        while(true){
            ATM atmObject = new ATM(); //creating ATM object 
            atmObject.menu(); //calling menu method of ATM class
        }
    }//end of main
}//end of class ATM
