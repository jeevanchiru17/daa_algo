import java.util.Scanner;
public class Dijktras_Algo{
public static int path[] = new int[10];
public static void main(String[] args) {
int tot_nodes,i,j;
int cost[][]=new int[10][10];
int dist[]=new int[10];
int s[]=new int[10];
System.out.println("\n\t\t-------Creation of Graph-----");
System.out.println("\nEnter Total Number of Nodes:");
Scanner in = new Scanner(System.in);
tot_nodes=in.nextInt();
create(tot_nodes,cost);
for(i=0;i<tot_nodes;i++) {
System.out.println("\n\t\tPress any Key To Continue...");
System.out.println("\n\t\tWhen Source="+i);
for(j=0;j<tot_nodes;j++) {
    Dijkstra(tot_nodes,cost,i,dist);
    if(dist[j]==999)
    System.out.println("\n There is no Path to"+j);
    else
    {
    display(i,j,dist);
    }
    }
    }
    }
    public static void create(int tot_nodes,int cost[][]) {
    int i,j,val,tot_edges,count=0;
    for(i=0;i<tot_nodes;i++) {
    for(j=0;j<tot_nodes;j++) {
    if(i==j)
    cost[i][j]=0;
    else
    cost[i][j]=999;
    }
    }
    System.out.println("\n Total Number of Edges:");
    Scanner in = new Scanner(System.in);
    tot_edges=in.nextInt();
    while(count<tot_edges) {
        System.out.println("\nEnter Vi and Vj:");
        i=in.nextInt();
        System.out.println("\nEnter the cost along this edge:");
        j=in.nextInt();
        val=in.nextInt();
        cost[j][i]=val;
        cost[i][j]=val;
        count++;
        }
        }
        public static void Dijkstra(int tot_nodes,int cost[][],int source,int dist[])
        { int i,j,v1,v2,min_dist;
        int s[]=new int[10];
        for(i=0;i<tot_nodes;i++) {
        dist[i]=cost[source]
        [i]; s[i]=0;
        path[i]=source;
        }
        s[source]=1;
        for(i=1;i<tot_nodes;i++) {
        min_dist=999;
        v1=-1;
        for(j=0;j<tot_nodes;j++) {
        if(s[j]==0) {
        if(dist[j]<min_dist) {
            min_dist=dist[j];
v1=j;
}
}
}
s[v1]=1;
for(v2=0;v2<tot_nodes;v2++) {
if(s[v2]==0) {
if(dist[v1]+cost[v1][v2]<dist[v2]) {
dist[v2]=dist[v1]+cost[v1][v2];
path[v2]=v1;
}
}
}
}
}
public static void display(int source,int destination,int dist[]) {
int i;
System.out.println("\n Step By Step Shortest Path is...\n");
for(i=destination;i!=source;i=path[i]) {
System.out.println(i+"<-");
}
System.out.println(""+i);
System.out.println("The Length="+dist[destination]);
}
}