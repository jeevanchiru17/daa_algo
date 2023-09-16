import java.util.Scanner;
public class Floyd {
public static void main(String[] args) {
int wt[][]=new int[10][10];
int n,i,j;
System.out.println("\nCreate A Graph Using Adjancency Matrix");
System.out.println("\n\nHow Many Vertices are There?:"); Scanner in = new
Scanner(System.in);
n = in.nextInt();
System.out.println("\n Enter the Elements");
System.out.println("[Enter 999 as infinity value]");
for(i=1;i<=n;i++)
{
for(j=1;j<=n;j++)
{
System.out.println("\nwt["+i+"]["+j+"]");
wt[i][j]=in.nextInt();
}
}
System.out.println("\n\tComputing All Pair Shrotest Path...\n");
Floyd_shortest_path(wt,n);
}
public static void Floyd_shortest_path(int wt[][],int n)
{
int D[][][]= new int[5][10][10];
int i,j,k;
for(i=1;i<=n;i++)
{
for(j=1;j<=n;j++)
{
D[0][i][j]=wt[i][j]; }
}
for(k=1;k<=n;k++) {
for(i=1;i<=n;i++) {
for(j=1;j<=n;j++) {
D[k][i][j] = min(D[k-1][i][j],(D[k-1][i][k]+D[k-1][k][j]));
}
}
}
for(k=0;k<=n;k++)
{
System.out.println("D("+k+")\t");
for(i=1;i<=n;i++)
{
    for(j=1;j<=n;j++)
    {
    System.out.println(""+D[k][i][j]);
    }
    System.out.println("\n");
    }
    }
    }
    public static int min(int a,int b)
    {
    if(a<b)
    return a;
    else
    return b;
    }
    }
    