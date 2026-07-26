package Practice;
import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        check();
    }

    public static void check() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = sc.nextInt();

        if (a <= 1) {
            System.out.println("Not a Prime Number");
            return;
        }

        boolean isPrime = true;

        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println("Prime Number");
        } else {
            System.out.println("Not a Prime Number");
        }
    }
}