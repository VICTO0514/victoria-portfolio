class IndividualLetters{
public static void main(String[] args){ 

    String s=" Zoho##[]";
    
    int[] freq=new int[256];
    boolean[] printed=new boolean[256];
    
    for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        freq[c]++;
    }
    
    for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        if(!printed[c] && c!=' '){
        System.out.println(c + "--->" + freq[c]);
        printed[c]=true;
        }
    }
    
}
}
        
  
