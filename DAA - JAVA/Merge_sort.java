import java.util.Random;
import java.util.Scanner;
public class Merge_sort {
 public static int SIZE = 7000;
 public static void main(String[] args)throws ArrayIndexOutOfBoundsException 
 {
     int a[] = new int[SIZE];
     System.out.println("Enter total number of elements for Sorting");
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     Random m = new Random();
    for(int i=0;i<n;i++) 
    {
    a[i] = m.nextInt(10)+1;
    }
    System.out.println("\n The Elements Before Sorting...");
        for(int i=0;i<n;i++) 
        {
            System.out.println(""+a[i]);
        }
    long start_time,end_time;
    start_time = System.nanoTime();
    Merge_Sort(a,0,n-1);
    end_time = System.nanoTime();
    System.out.println("\n The Elements After Sorting....");
    for(int i=0;i<n;i++) 
    {
    System.out.println(""+a[i]);
    }
    System.out.println("\n The Time Required for Sorting"+n+"Numbers is:"+(end_time-start_time)+"ns");
 }
public static void Merge_Sort(int a[],int low,int high) 
{
int mid;
if(low<high) 
{
    mid = (low+high)/2;
    Merge_Sort(a,low,mid);
    Merge_Sort(a,mid+1,high);
    combine(a,low,mid,high);
}
}
public static void combine(int a[],int low,int mid,int high) 
{
    int i,j,k;
    int[] temp;
    temp = new int[7000];
    k = low;
    i = low;
    j = mid+1;
    while(i<=mid&&j<=high) 
    {
    if(a[i]<=a[j]) 
    {
        temp[k]=a[i];
        i++;
        k++;
    }
    else 
    {
        temp[k] = a[j];
        j++;
        k++;

    }
}
while(i<=mid) {
temp[k] = a[i];
i++;
k++;
}
while(j<=high) {
temp[k] = a[j];
j++;
k++;
}
for(k = low; k<=high; k++) {
a[k] = temp[k];
}
}
}
