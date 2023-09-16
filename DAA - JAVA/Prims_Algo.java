import java.util.Scanner;
public class Prims_Algo {
static int SIZE = 10;
static int INFINITY = 999;
public static void main(String[] args) {
int G[][] = new int[SIZE][SIZE];
int nodes;
int v1,v2,length,i,j,n;
System.out.println("\n\tPrim's Algorithm\n");
System.out.println("\nEnter Number of Nodes in The Graph:");
Scanner in = new Scanner(System.in);
nodes = in.nextInt();
System.out.println("\nEnter Number of Edges in The Graph:");
n = in.nextInt();
for(i=0;i<nodes;i++)
for(j=0;j<nodes;j++)
G[i][j]=0;
System.out.println("\nEnter Edges and Weights:\n");
for(i=0;i<n;i++) {
System.out.println("\nEnter Edges by V1 and V2:");
System.out.println("[Read the Graph From Starting Node 0]:");
v1 = in.nextInt();
v2 = in.nextInt();
System.out.println("\nEnter Corresponding Weight:");
length = in.nextInt();
G[v1][v2] = G[v2][v1]= length;
}
Prim(G,nodes);
}
public static void Prim(int G[][],int nodes) {
int tree[] = new int[SIZE];
int i,j,k;
int min_dist,v1=0,v2=0,total=0;
for(i=0;i<nodes;i++)
tree[i]=0;
System.out.println("\n\nThe Minimal Spanning Tree Is:\n");
tree[0]=1;
for(k=1;k<=nodes-1;k++) {
min_dist = INFINITY;
for(i=0;i<=nodes-1;i++) {
for(j=0;j<=nodes-1;j++) {
if(G[i][j]!=0&&((tree[i]==1&&tree[j]==0)||(tree[i]==0&&tree[j]==1))) {
if(G[i][j]<min_dist) {
min_dist = G[i][j];
v1 = i;
v2 = j;
}
}
}
}
System.out.println("\nEdge["+v1+","+v2+"]and Weight"+min_dist);
tree[v1] = tree[v2]=1;
total = total+min_dist;
}
System.out.println("\n\n\tTotal Path Length Is = "+total);
}
}