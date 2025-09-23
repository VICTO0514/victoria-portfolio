import java.util.Scanner;

class FillStar{
public static void main(String[] args){

     Scanner sc=new Scanner(System.in);
     System.out.println("Enter input");
     String s=sc.nextLine();
     
     System.out.println("Enter target");
     int target=sc.nextInt();
     
     int len=s.length();
     int space=0;
     int count=0;
     String result="";
     
     for(int i=0;i<len;i++){
         char ch=s.charAt(i);
         
         if(ch==' '){
         space++;
         }
         else{
         count++;
         }
     }
         
     int diff=target-count;
     int star=diff/space;
     int rem=diff%space;
     
     for(int i=0;i<len;i++){
     
         if(s.charAt(i) != ' '){
             result += s.charAt(i);
         }
         
         else if(s.charAt(i) == ' '){
         int add = star + (rem>0 ? 1 : 0);
         rem--;
         for(int j=0;j<add;j++){
             result += "*";
             }
         }
     }
          System.out.println(result);
     
}
}
     
     
     
 
