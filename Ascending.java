class Ascending{
public static void main(String[] args){

int[] arr={8,2,9,1,5};
int len=arr.length;

for(int i=0;i<len;i++){
for(int j=0;j<len;j++){
if(arr[i]<arr[j]){
int t=arr[i];
arr[i]=arr[j];
arr[j]=t;
}
}
}

for(int num:arr){
System.out.println(num);
}


}
}
