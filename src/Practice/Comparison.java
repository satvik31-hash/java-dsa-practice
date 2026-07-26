package Practice;
import java.util.Scanner;
//Method 1 (BASIC)
/*public class Comparison {
    static void main() {
       Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st Number:- ");
        int a = sc.nextInt();
        System.out.print("Enter 2nd Number:-");
        int b = sc.nextInt();
        System.out.print("Enter 3rd Number:- ");
        int c = sc.nextInt();
        if(a>b && a>c){
            System.out.println("The Number greatest among the all 3 Numbers:- "+a);
        }
        else if(b>a && b>c){
            System.out.println("The Number greatest among the all 3 Numbers:- "+b);
        }
        else if(c>a&&c>b){
            System.out.println("The Number greatest among the all 3 Numbers:- "+c);
        }
    }
}*/



//Method 2 (BETTER)
public class Comparison {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number:- ");
        int a = sc.nextInt();
        System.out.print("Enter the second number:- ");
        int b = sc.nextInt();
        System.out.print("Enter the third number:- ");
        int c = sc.nextInt();

        int max = a;
        if (b> max){
            max=b;
        }
        if (c> max){
            max=c;
        }
        System.out.print("Maximum number among them is:- " + max);

    }
}
