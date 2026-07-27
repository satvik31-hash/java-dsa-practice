/*You are given an Array arr[] of size n-1 with n distinct elements integers in the range from 1 to n(inclusive), This
array represents a permutation of the integers from 1 to n with one missing element. Your task is to identify and return
the missing element*/
package Array_Array_List;
import java.util.Scanner;
public class Missing_Element {
    static void main() {
         int arr[] = {8,2,4,5,3,7,1};
         Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n = '8':-  ");
         int n = scanner.nextInt();
         int sum = (n*(n+1))/2;
         int sum1=0;
         for(int i = 0; i<arr.length;i++){
             sum1+=arr[i];
         }
         if(sum==sum1){
             System.out.println("No missing element found");
         }
         else{
             System.out.print("Missing Number is:- "+ (sum-sum1));
         }
    }
}
