package Array_Array_List;

public class Two_Sum {
    static void main() {
        //Given Array
        int[] a = {1,3,-3,5,4};
        int sum = 2;
        int b =1;
        for(int i = 0;i<a.length;i++){
            int point = a[i];
            for(int j =b;j<a.length;j++){
                if(point+a[j]==sum){
                    System.out.println("Two elements whose sum is 2 are "+point+" and "+a[j]);
                }
            }
            b+=1;
        }
    }
}
