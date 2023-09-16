import java.util.Scanner;
public class TSP {
static int cost=0;
public static void main(String[] args) {
int a[][] = new int[10][10];
int visited[] = new int[10];
int n;
System.out.println("\n Enter No.of Cities:");
Scanner in = new Scanner(System.in);
n = in.nextInt();
create(a,visited,n);
System.out.println("\n\nThe Path is:");
mincost(a,n,0,visited);
display();
}
public static void create(int a[][], int visited[],int n)
{
int i,j;
System.out.println("\nEnter Cost Matrix:");
for(i=0;i<n;i++) {
System.out.println("Row#:"+(i+1));
for(j=0;j<n;j++)
{
Scanner sc = new Scanner(System.in);
a[i][j]=sc.nextInt();
}
visited[i]=0;
}
System.out.println("\n\nThe Cost Matrix is:....");
for(i=0;i<n;i++)
{
System.out.println("\n");
for(j=0;j<n;j++)
System.out.println(""+a[i][j]);
}
}
public static void mincost(int a[][],int n,int city,int visited[])
{
int i,city_no;
visited[city]=1;
System.out.println((city+1)+"-->");
city_no = least(a,visited,n,city);
if(city_no==999)
{
city_no=0;
System.out.println(""+(city_no+1));
cost+=a[city][city_no];
return;
}
mincost(a,n,city_no,visited);
}
public static int least(int a[][],int visited[],int n,int c) {
int i,min_node=999;
int min = 999,New_min = 0; for(i=0;i<n;i++)
{
if((a[c][i]!=0)&&(visited[i]==0))
if(a[c][i]<min) {
min=a[i][0]+a[c][i];
New_min = a[c][i];
min_node = i;
}
}
if(min!=999)
cost+=New_min;
return min_node;
}
public static void display()
{
System.out.println("\n\nThe Cost of Tour:"+cost);
}
}