class Vehicle{
     
     static void drive() {
        System.out.println("Vehicle");
     }
}

class Car extends Vehicle {

     static void drive() {
        //super.drive(); --> non static cannot be referrenced from an static context
        System.out.println("Car");
     }
}
public class MethodOverriding {

    public static void main(String[] args){
    
        Vehicle.drive();   
        Car.drive();
        
    }
}
