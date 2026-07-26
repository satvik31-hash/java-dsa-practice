package Array_Array_List;
/*import java.lang.reflect.Array;
import java.util.*;
public class Code_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Rows of the array : ");
        int a = sc.nextInt();
        System.out.print("Enter the columns of the array : ");
        int b = sc.nextInt();
        int[][] arr = new int[a][b];
        for (int i = 0; i<arr.length; i++){
            for ( int j = 0; j<arr[i].length;j++){
                arr[i][j] = sc.nextInt();
            }
            arr[i][b-1]=sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
    }


}*/
import java.util.*;
public class Code_1{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number:- ");
        int a = sc.nextInt();
        System.out.println("Enter second number:- ");
        int b = sc.nextInt();
        if (a>b){
            System.out.println("Bigger Number is:- ");
        }
    }
}

