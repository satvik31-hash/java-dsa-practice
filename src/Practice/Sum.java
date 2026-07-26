package Practice;
import java.util.Scanner;
public class Sum{
    static void main(String[] args){
        int e = sum();
        System.out.println(e);}
     static int sum() {
        Scanner a = new Scanner(System.in);
        System.out.print("Enter the first number:-");
        int n = new Scanner(System.in).nextInt();
        System.out.print("Enter the second number:-");
        int m = new Scanner(System.in).nextInt();
        int sum=  n+m;
       return sum;
    }
}
