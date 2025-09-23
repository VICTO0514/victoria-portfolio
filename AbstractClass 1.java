abstract class A {

    abstract void a();

    void b() {
        System.out.println("b");
    }
}

class C extends A {
    
    void a() {
        System.out.println("a");
    }
}

public class AbstractClass1 {
    public static void main(String[] args){

        C c = new C();
        c.a();
        c.b();
    }
    

}
