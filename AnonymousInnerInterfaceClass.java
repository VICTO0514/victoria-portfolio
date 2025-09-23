interface Animal {
    void sound();
}

public class AnonymousInnerInterfaceClass {
    public static void main(String[] args) {

        Animal a = new Animal() {
            public void sound() {
                System.out.println("Animals makes sound");
            }
        };
        a.sound();
        
    }
}

