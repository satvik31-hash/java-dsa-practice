package Practice;
import java.util.Scanner;
public class Swap {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number:- " );
        double a = sc.nextDouble();
        System.out.print("Enter a second Number:- ");
        double b = sc.nextDouble();
        double temp = b;
        b=a;
        a=temp;
        System.out.println("Swapped Numbers are:- "+a);
        System.out.print(b);
    }
}
