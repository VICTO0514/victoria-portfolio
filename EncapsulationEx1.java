class BankAccount {

    private String accHolder;
    private double balance;

    //data hiding & controlled access
    
    BankAccount(String accHolder, double balance){
        this.accHolder=accHolder;
        this.balance=balance;
    }
    
    public String getAccount() {
        return accHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount){
        balance += amount;
    }
    
    public void withdraw(double amount) {
        if(amount <= balance){
            balance -= amount;
        }
        else{
        System.out.println("Insufficient Bank Balance");
        }
    }
}

class EncapsulationEx1 {
    public static void main(String[] args) {
    
    BankAccount bank=new BankAccount("Arun",2500);
    
    bank.deposit(500);
    System.out.println("Name: "+bank.getAccount()+", Balance: "+bank.getBalance());
    bank.withdraw(700);
    System.out.println("Balance: "+bank.getBalance());
    bank.withdraw(3500);
    
    }
}
    
    
