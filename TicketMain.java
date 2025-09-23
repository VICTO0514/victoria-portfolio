import java.util.Scanner;
class Ticket{

    private int id;
    private String passengerName;
    private boolean isBooked;

public Ticket(int id){
    
    this.id=id;
    this.passengerName=null;
    this.isBooked=false;
}

void book(String passengerName) {

    if(!isBooked){
    this.passengerName=passengerName;
    this.isBooked=true;

    System.out.println("Ticket: "+ id +" booked for "+passengerName);
    }
    
    else{
    System.out.println("Ticket" + id+" are already booked");
    }
}

void cancel() {
    
    if(isBooked){
    System.out.println("Ticket: "+id+" cancelled for (Passenger "+ passengerName +" )");
    this.passengerName=null;
    this.isBooked=false;
    }
    else{
    System.out.println("No tickets "+id+" not yet booked");
    }
}

void display(){

     if(isBooked){
     System.out.println("Ticket :"+id +"--->"+passengerName);
     }
     else{
     System.out.println("Ticket is available");
     }
}

public int getId(){ return id; }
public String getName(){ return passengerName; }
public boolean isBooked(){ return isBooked; }

}

class TicketReservationSystem{
    private Ticket[] tickets;
    
    public TicketReservationSystem(int size){
        tickets=new Ticket[size];
        for(int i=0;i<size;i++){
        tickets[i]=new Ticket(i+1);
        }
    }

public void bookTicket(String name){
    
    for(Ticket t: tickets){
        if(!t.isBooked()){
        t.book(name);
        return;
        }
    }
    System.out.println("No tickets available");
}
    
public void cancelTicket(int id) {
    
    if(id<=0 && id>=tickets.length){
       System.out.println("Invalid ticket id");
       return;
    }
    Ticket t=tickets[id-1]; //array index=id-1
    t.cancel();
}

public void viewTicket() {
    
    for(Ticket t: tickets){
    t.display();}
}
}

public class TicketMain{
    public static void main(String[] args){
    
    Scanner sc=new Scanner(System.in);
    TicketReservationSystem system=new TicketReservationSystem(5);
    
    while(true){ 
            System.out.println("\n--- Ticket Reservation Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Tickets");
            System.out.println("4. Exit");
            
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            
            switch(choice){
            
            case 1: 
            System.out.print("Enter Passenger Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            system.bookTicket(name); break;
            
            case 2: 
            System.out.print("Enter Ticket id to cancel: ");
            int id = sc.nextInt();
            system.cancelTicket(id); break;
            
            case 3: system.viewTicket(); break;
            case 4: System.out.println("Existing...."); return;
            default: System.out.println("Invalid option");
            
            }
    }
    }
}
            
    
    
    

