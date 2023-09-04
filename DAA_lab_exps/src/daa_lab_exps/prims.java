package daa_lab_exps;

import java.util.Scanner;

public class prims {
    static int n;
    static int cost;
    static int [][]wt;
    static int [][]edges;
    static void primsmeth()
    {
        int []u,lowcost,visited;
        int i,j,v,min,mincost=0;

        visited=new int[n+1];
        lowcost=new int[n+1];
        u=new int[n+1];
        edges=new int[n+1][n+1];

        visited[1]=1;
        for(i=2;i<=n;i++)
        {
            visited[i]=0;
            u[i]=1;
            lowcost[i]=wt[1][i];
        }

        for(i=1;i<=n-1;i++)
        {
            min=lowcost[2];
            v=2;
            for(j=3;j<=n;j++)
            {
                if(lowcost[j]<min)
                {
                    min=lowcost[j];
                    v=j;
                }
            }
            edges[i][1]=u[v];
            edges[i][2]=v;
            mincost+=lowcost[v];
            visited[v]=1;
            lowcost[v]=99;

            for(j=2;j<=n;j++)
            {
                if(wt[v][j]<lowcost[j] && visited[j]==0)
                {
                    lowcost[j]=wt[v][j];
                    u[j]=v;
                }
            }
        }
        System.out.println("The edges with MST are:");
        for(i=1;i<n;i++)
        {
            System.out.println("("+edges[i][1]+","+edges[i][2]+")");
        }

        System.out.println("The cost of minimal spanning tree is"+mincost);
    }


    public static void main(String[] args) {
        int i,j;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        n=sc.nextInt();
        System.out.println("Enter the weights:");
        wt=new int[n+1][n+1];
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                wt[i][j]=sc.nextInt();
            }
        }
        primsmeth();


    }
}
