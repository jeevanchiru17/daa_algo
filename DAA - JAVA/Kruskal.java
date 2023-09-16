import java.util.Scanner;
public class Kruskal {
public static void main(String[] args) {
int i,j,u=0,v=0,n ,tot_edges,k=1;
int v1=0,v2=0,count=0;
int min,totalCost=0,val;
int cost[][]=new int[10][10];
int parent[]= new int[10];
System.out.println("\n\tImplementation of Kruskal's Algorithm Algorithm\n");
System.out.println("\nEnter the no.of vertices:");
Scanner in = new Scanner(System.in);
n=in.nextInt();
System.out.println("\nEnter the no.of Edges:");
tot_edges=in.nextInt();
while(count<tot_edges)
{
System.out.println("\nEnter edge in the form of v1 and v2:");
v1=in.nextInt();
v2=in.nextInt();
System.out.println("\nEnter Cost:");
val=in.nextInt();
cost[v1][v2]=val;
cost[v2][v1]=val;
count++;
}
for(i=1;i<=n;i++) {
for(j=1;j<=n;j++) {
if(cost[i][j]==0)
cost[i][j]=999;
}
}
System.out.println("The Edges of Minimum Cost Spanning Tree Are..");
while(k<n)
{
for(i=1,min=999;i<=n;i++) {
for(j=1;j<=n;j++){
if(cost[i][j]<min) {
min = cost[i][j];
v1=u=i;
v2=v=j;
}
}
}
u = find(u,parent);
v = find(v,parent);
if(union(u,v,parent)>0) {
k++;
System.out.println("Edge["+v1+","+v2+"]="+min);
totalCost+=min;
}
cost[v1][v2] = cost[v2][v1] = 999;
}
System.out.println("\n\tCost of Spanning Tree="+totalCost);
}
public static int find(int i,int parent[]) {
while(parent[i]!=0)
i= parent[i];
return i;
}
public static int union(int i,int j,int parent[]) {
if(i!=j) {
parent[j]=i;
return 1;
}
return 0;
}
}