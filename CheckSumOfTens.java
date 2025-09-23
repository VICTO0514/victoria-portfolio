import java.util.Scanner;
public class CheckSumOfTens {

    public boolean checkSumOfTens(int[] a){

        int count = 0;

        for(int i=0;i<a.length;i++){
            if(a[i]==10){
                count++;
            }
        }

        if(count == 3){
            return true;
        }
        else if(count < 3 || count > 3){
            return false;
        }

        return false;

    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size");
        int size = sc.nextInt();

        int[] a = new int[size];
        System.out.println("Enter arrays");

        for(int i=0;i<size;i++){
            a[i]=sc.nextInt();
        }
        
        CheckSumOfTens c = new CheckSumOfTens();
        System.out.println(c.checkSumOfTens(a));
    }
}
