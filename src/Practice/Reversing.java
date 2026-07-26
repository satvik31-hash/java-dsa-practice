package Practice;
import java.util.Scanner;
public class Reversing {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to be reversed:- ");
        int a = sc.nextInt();
        int rev = 0;
        while (a != 0){
             int rem = a % 10;
             rev = rev*10 + rem;
             a = a/10;
        }
        System.out.print("Reversed Number:- " + rev);
    }
}
