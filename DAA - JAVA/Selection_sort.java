import java.util.Random;
import java.util.Scanner;
public class Selection_sort {
    public static int SIZE = 7000;
     public static void main(String[] args) throws ArrayIndexOutOfBoundsException 
    {
     int a[] = new int[SIZE];
     System.out.println("Enter the total number of elements for sorting:");
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     Random m = new Random();
     for (int i = 0; i < n; i++) 
     {
         a[i] = m.nextInt(10) + 1;
     }
 System.out.println("\nThe elements before sorting....");
 for (int i = 0; i < n; i++) 
 {
 System.out.println("" + a[i]);
 }
 long start_time, end_time;
 start_time = System.nanoTime();
 selectionSort(a, n);
 end_time = System.nanoTime();
 System.out.println("\nThe elements after sorting");
 for (int i = 0; i < n; i++) 
 {
 System.out.println("" + a[i]);
 }
 System.out.println("\nThe time required for sorting " + n + " numbers is: " +(end_time - start_time) + " ns");
 }
 static void selectionSort(int[] a, int n) 
 {
 int i, j, minValue = 0, minIndex = 0, temp;
 for (i = 0; i < n; i++) 
 {
    minValue = a[i];
    minIndex = i;
 for (j = i; j < n; j++) 
 {
     if (a[j] < minValue) 
     {
     minValue = a[j];
     minIndex = j;
     }
 }
 if (minValue < a[i]) 
 {
     temp = a[i];
     a[i] = a[minIndex];
     a[minIndex] = temp;
 }
 }
 }
}
