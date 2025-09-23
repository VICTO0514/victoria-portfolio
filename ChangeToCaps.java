class Letters{
    void changeToCaps(String[] a,String sen) {

        String[] words = sen.split(" ");
        String result="";

        for(int i=0;i<words.length;i++){
            String word = words[i];

            if(i==0){
            char first=word.charAt(0);
                if(first>='a' && first<='z'){
                    first=(char)(first-'a'+'A');
                }
                result += first+word.substring(1);
            }
            else{ 
                boolean found = false;
                for(int j=0;j<a.length;j++){

                    if(word.equals(a[j])){
                        found=true;
                        break;
                    }
                }
                if(found) {
                    char c = word.charAt(0);
                    if(c>='a' && c<='z'){
                    c=(char)(c-'a'+'A');
                    }
                    result +=" "+c+word.substring(1);   
                }
                else{
                    result +=" "+word;
                }
            }
        }
        System.out.println(result);  
        }  
}
public class ChangeToCaps {
    public static void main(String[] args){

        String[] a={"zoho","i","hi","how"};
        String sen = "i am in zoho office";

        Letters obj = new Letters();
        obj.changeToCaps(a, sen);
    }
}

