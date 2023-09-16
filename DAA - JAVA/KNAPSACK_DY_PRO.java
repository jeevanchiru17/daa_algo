public class KNAPSACK_DY_PRO {
static int[][] table = new int[5][6];
public static void main(String[] args) {
int w[] = {0,2,3,4,5};
int v[] = {0,3,4,5,6};
int W = 5;
int n = 4;
int i;
System.out.println("\n\t\t0/1 Knapsack Problem Using Dynamic Programming");
System.out.println("\nGiven Data...");
System.out.println("\nw[i]\t v[i]");
System.out.println("\n.......................");
for(i=1;i<=n;i++)
System.out.println("\n"+w[i]+"\t"+v[i]);
System.out.println("\n\t\tCapacity="+W);
for( i=0;i<=n;i++) {
for(int j=0;j<=W;j++)
{
table[i][j]=0;
}
}
DKP(n,W,w,v);
}
public static int max(int a,int b)
{
if(a>b)
return a;
else
return b;
}
public static void DKP(int n,int W,int w[],int v[])
{
int i,j;
int val1,val2;
for(i=0;i<=n;i++)
{
for(j=0;j<=W;j++)
{
table[i][0]=0;
table[0][j]=0;
}
}
for(i=1;i<=n;i++)
{
for(j=1;j<=W;j++)
{
if(j<w[i])
table[i][j]=table[i-1][j];
else if(j>=w[i])
{
val1=table[i-1][j];
val2=v[i]+table[i-1][j-w[i]];
table[i][j]=max(val1,val2);
}
}
}
System.out.println("\nTable constructed using dynamic programmingis....");
for(i=0;i<=n;i++)
{
for(j=0;j<=W;j++)
System.out.println(""+table[i][j]);
System.out.println("\n");
}
find_item(n,W,w);
}
public static void find_item(int i,int k,int w[])
{
System.out.println("\nSolution for the Knapsack...");
while(i>0&&k>0)
{
if(table[i][k]!=table[i-1][k])
{
System.out.println("\nItem\t"+i+"\tis Selected");
i=i-1;
k=k-w[i];
}
else
i=i-1;
}
}
}