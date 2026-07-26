package Practice;
import java.util.Scanner;
public class Fibonacci {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int a = sc.nextInt();
        int b = 0;
        int c = 1;
        int count = 1;
        System.out.print(b + " ");
        System.out.print(c + " ");
        while (count <= a){
            int sum = b+c;
            System.out.print(sum+ " ");
            count++;
            b=c;
            c=sum;
        }
    }
}
