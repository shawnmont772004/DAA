package daa_lab_exps;

import java.util.Scanner;

public class Kruskal {
    static int n,v1,v2;
    static int [][]wt;
    static int edgewt;
    static int mincost;
    static void kruskalmeth()
    {
        int i,j;
        int []root;
        root=new int[n+1];
        for(i=1;i<=n;i++)
        {
            root[i]=i;
        }
        i=0;
        while(i!=n-1)
        {
            find();
            edgewt=wt[v1][v2];
            wt[v1][v2]=wt[v2][v1]=0;
            if(root[v1]!=root[v2])
            {
                System.out.println("(" + v1 + "," + v2 + ")");
                union(root,v1,v2);
                mincost+=edgewt;
                i++;
            }
        }
        System.out.println("the cost of minimal spanning tree is:"+mincost);
    }

    static void find()
    {
        int i,j;
        int edgewt=99;
        int min=0;
        for(i=1;i<=n;i++)
        {
            for(j=i+1;j<=n;j++)
            {
                if(wt[i][j]<edgewt && wt[i][j]>min )
                {
                    edgewt=wt[i][j];
                    v1=i;
                    v2=j;
                }
            }
        }
    }

    static void union(int []root,int v1,int v2)
    {
        int i;
        int temp=root[v2];
        for(i=1;i<=n;i++)
        {
            if(root[i]==temp)
            {
                root[i]=root[v2];
            }
        }

    }

    public static void main(String[] args) {
        int i,j;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        n=sc.nextInt();
        System.out.println("Enter the weighted matrix:");
        wt=new int[n+1][n+1];
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                wt[i][j]=sc.nextInt();
            }
        }
        kruskalmeth();

    }
}
