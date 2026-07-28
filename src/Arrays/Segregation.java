package Arrays;
import java.util.Scanner;
public class Segregation {
    static void main() {
        int arr[] = {0,0,1,0,1,1,0};
        int NoOfOnes= 0;
        int NoOfZeroes=0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==0){
                NoOfZeroes++;
            }
            else{
                NoOfOnes++;
            }
        }
        for (int i = 0;i<arr.length;i++){
            if (NoOfZeroes!=0){
                arr[i]=0;
                NoOfZeroes--;
            }
            else{
                arr[i]=1;
                NoOfOnes--;
            }
        }
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
