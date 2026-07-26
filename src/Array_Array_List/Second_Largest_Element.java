package Array_Array_List;
import java.util.Scanner;
public class Second_Largest_Element {
    static void main() {
        int[] arr = {5,2,5,1,3,6,7};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number for Rotation:- ");
        int a = scanner.nextInt();
        int n = arr.length;
        a%=n;
        int b = 0;
        int c = arr.length-1;
        while(b<c){
            int temp=0;
            temp = arr[b];
            arr[b]=arr[c];
            arr[c]=temp;
            b++;
            c--;
        }
        for (int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println();
        int e = 0;
        int f = arr.length-a-1;
        while(e<f){
            int temp = arr[e];
            arr[e]=arr[f];
            arr[f]=temp;
            e++;
            f--;
        }
        int j = arr.length-a;
        int i = arr.length;
        while(j<i) {
            int temp = arr[e];
            arr[e] = arr[f];
            arr[f] = temp;
            j++;
            i--;
        }
        for (int y = 0; y<arr.length;y++) {
            System.out.print(arr[y] + ",");
        }
    }
}