package Arrays;
import java.util.Scanner;
 class Solution{
     public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
         System.out.print("Enter the Length of Arrays:- ");
         int a = sc.nextInt();
         System.out.print("Enter 1st Array elements:- ");
         int[] arr1 = new int[a];
         for (int i =0; i<arr1.length;i++){
             arr1[i] = sc.nextInt();
         }
         int c = 1;
         for (int i = 0; i<arr1.length;i++){
             c= c*arr1[i];
         }
         System.out.println("Product of elements of:- "+c) ;
         System.out.print("Enter 2nd Array elements:- ");
         int[] arr2 = new int[a];
         for (int i = 0; i< arr2.length; i++){
             arr2[i] = sc.nextInt();
         }
         int[] b = new int[a];
         for (int i = 0; i<a;i++){
             b[i] = arr1[i]*arr2[i];
         }
         for (int j =0; j<b.length;j++){
             System.out.println(b[j] + " ");
         }
         int min = arr2[0];
         for(int j = 1; j<arr2.length;j++){
             if (min>arr2[j]){
                 min=arr2[j];
             }
         }
          System.out.println("Min Value is:- "+min);
     }
 }