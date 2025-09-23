interface Machine {
    int speed=10; //public static final
}

abstract class Vehicle {
    int speed=60;
}

class Car extends Vehicle {}

public class AbsInterEx1 {
    public static void main(String[] args) {
     
    Car c = new Car();
    c.speed=120;
    System.out.println(c.speed);
    
    System.out.println(Machine.speed); 
    //able to access directly beacause variables inside interface are public static final by default without declaring
    
    }
}

