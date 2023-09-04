package daa_lab_exps;

import java.util.Scanner;

public class knapsack {
    static int n,C,i,w,j;
    static int []p,wt;
    static int[][]K;
    static void knapsackmeth()
    {
        K=new int[n+1][C+1];
        for(i=0;i<=n;i++)
        {
            for(w=0;w<=C;w++)
            {
                if(w==0 || i==0)
                {
                    K[i][w]=0;
                }
                else if(w>=wt[i])
                {
                    K[i][w]=max(p[i]+K[i-1][w-wt[i]],K[i-1][w]);
                }
                else
                {
                    K[i][w]=K[i-1][w];
                }
            }
        }

        System.out.println("Selected items are:");
        int m=n;
        int c=C;
        while(m>0)
        {
            if(K[m-1][c]!=K[m][c])
            {
                System.out.print("Item:"+m+"(weight:"+wt[m]+",profit:"+p[m]+"),");
                c=c-wt[m];
            }
            m--;
        }
        System.out.print("Intermediate items are\nCapacity:");
        for(j=0;j<=C;j++)
        {
            System.out.print(j+"\t");
        }
        System.out.println();
        for(i=0;i<=n;i++)
        {
            System.out.print("Item"+i+"("+wt[i]+","+p[i]+")");
            for(j=0;j<=C;j++)
            {
                System.out.print(K[i][j]+"\t");
            }
            System.out.println();
        }

    }

    static int max(int x,int y)
    {
        return (x>y)?x:y;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of items:");
        n=sc.nextInt();
        System.out.println("Enter the profits:");
        p=new int[n+1];
        for(i=1;i<=n;i++)
        {
            p[i]=sc.nextInt();
        }
        System.out.println("Enter the weights:");
        wt=new int[n+1];
        for(i=1;i<=n;i++)
        {
            wt[i]=sc.nextInt();
        }
        System.out.println("Enter the max capacity:");
        C=sc.nextInt();
        knapsackmeth();
    }
}
