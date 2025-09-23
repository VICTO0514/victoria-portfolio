class Car {
    
    int a;
    int b=10;
    int r;
    
    Car() {
        a = 5;
    } 
    
    void car(int r) {
        this.r = r;
    }
}


//abstract

abstract class Vehicle {

    int speed;
    
    Vehicle(int s) {
        speed = s;
    }
    
    void setSpeed(int s) {
        speed = s;
    }
    
    abstract void drive();
}
  
class Bike extends Vehicle {
    
    Bike(int s) {
        super(s);
    }
    
    void drive() {
        System.out.println("Bike is driving at speed"+speed);
    }
}

//interface

interface Machine {

    int speed=10;
    
    void run();
}

class Fan implements Machine {
    int speed;
    
    Fan(int s) {
        speed = s;
    } 
    
    void setSpeed(int s) {
        speed = s;
    }
    
    public void run() {
        System.out.println("Fan running at speed " + speed);
    }
}   

public class CheckAbsInt {
    public static void main(String[] args) {
    
    Car c = new Car();   
    System.out.println(c.a);
    System.out.println(c.b);
    c.car(15);
    System.out.println(c.r);
    c.car(20); //modify
    System.out.println(c.r);

    Bike bi = new Bike(40);
    bi.drive();
    bi.setSpeed(60);
    bi.drive();
    
    Fan f = new Fan(20);
    f.run();
    f.setSpeed(100);
    f.run();
    }
}
