class Compression{
    void compression(String input){

    int count =1;
    char prev = input.charAt(0);
        
        for(int i=1;i<input.length();i++){
            char curr=input.charAt(i);

            if(curr==prev){
                count++;
            }
            else{
            if(count>1){
                System.out.print(prev+""+count);
            }
            else if(count==1){ 
                System.out.print(prev);
            }
            prev=curr;
            count=1;
            }    
        }
        System.out.print(prev+""+count);
    }
}
public class StringCompression {
    public static void main(String[] args){

        String input="aabccaddd";

        Compression a = new Compression();
        a.compression(input);
    }
}


