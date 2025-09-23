import java.io.FileReader;
import java.io.IOException;

/* class BankException extends Exception{
    public BankException(String message){
        super(message);
    }
} */


class Bank{
    private double balance = 2000;

    public void withdraw(double amount)throws BankException{
        if(amount <= 0){
            throw new BankException("Amount must be positive");
        }
        
        if(amount > balance){
        throw new BankException("Insufficient Balance");
        }
        balance -= amount;
        System.out.println("Withdraw successful. Balance: "+ balance);
    }

    public void readData() throws IOException{
        FileReader reader = new FileReader("data.txt");
    }
}

class ExceptionHandlingTest{
    public static void main(String[] args) {
        Bank bank = new Bank();

        try{
            bank.withdraw(500);
            bank.readData();
        }
        catch(BankException e){
            System.out.println("Bank Error: "+e.getMessage());
        }
        catch(IOException e){
            System.out.println("IO Error: "+e.getMessage());
        }
        finally{
            System.out.println("Transaction attempt completed");
        }

        try{
            try{
                bank.withdraw(2000);
            } catch(BankException e){
                System.out.println("Inner catch: "+e.getMessage());
                //throw e;
            }
        }
        catch(BankException e){
            System.out.println("Outer Catch, Transaction failed");
        }
    }
}
