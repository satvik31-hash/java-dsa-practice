package Practice;
import java .util.Scanner;
public class Counting_Occurence {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number:- ");
        int a = sc.nextInt();
        System.out.print("Enter the number whose occurance is to be searched:- ");
        int b = sc.nextInt();
        int count = 0;
        while (a !=0){
            int rem = a%10;
            if (rem == b){
                count++;
            }
            a=a/10;
        }
        System.out.println(count);
    }
}
