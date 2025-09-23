public class WrapperReturnType {


    static Integer getValue(Integer a) {
        return a;
    }

    Integer getValue(){
        return 50;
    }

    public static void main(String[] args) {

        WrapperReturnType.getValue(10); 

        WrapperReturnType w = new WrapperReturnType();  
        w.getValue(); 
    }

}

