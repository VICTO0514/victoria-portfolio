class StringInCaps{

    public static void main(String[] args){

    String[] word={"zoho","i","hi","how"};
    String input="i am in zoho office";
    
    String result="";
    String join="";
    
    input=input+" ";
    
    for(int i=0;i<input.length();i++){
        char ch=input.charAt(i);
        
        if(ch != ' '){
            join = join+ch;
        }
        
        else{
        
            for(int j=0;j<word.length;j++){
                if(join.equals(word[j])) {
                    char first=join.charAt(0);
                    
                    if(first>='a' && first<='z') {
                        first=(char)(first-'a'+'A');
                    }
                    join =first+join.substring(1);
                }
            }
            
            result = result+join+" ";
            join="";
        }
     }
     
     if(result.length() > 0){
         char first=result.charAt(0);
         
         if(first>='a' && first<='z'){
             first=(char)(first-'a'+'A');
         }
         result=first + result.substring(1);
     }
                    
     System.out.println(result);
   
    }
}
        


