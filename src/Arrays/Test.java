package Arrays;

public class Test {
    static void main() {
        int[] a = {1,2,3,4,5};
        int[] b = {6,7,8,9,10};
        int[] sum = new int[a.length];
        for (int i=0; i<b.length;i++){
            sum[i] = a[i]+b[i];
        }
        for (int i=0;i<sum.length;i++){
            System.out.print(sum[i]+" ");
        }
    }
}
