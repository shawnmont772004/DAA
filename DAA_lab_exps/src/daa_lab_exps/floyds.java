package daa_lab_exps;

import java.util.Scanner;

public class floyds {

    static int [][]wt;
    static int n;

    static void floydd() {
        int i, j, k;
        for (k = 1; k <= n; k++) {
            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    wt[i][j] = min(wt[i][j], wt[i][k] + wt[k][j]);
                }
            }
        }

    }
    static int min(int x,int y)
    {
        if (x<y)
        {
            return x;
        }
        else{
            return y;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of nodes:");
        n=sc.nextInt();
        int i,j;
        System.out.println("Enter the weighted matrix(99 for no edge):");
        wt=new int[n+1][n+1];
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                wt[i][j]=sc.nextInt();
            }
        }
        floydd();
        System.out.println("All shortest pair distance is");
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {

                System.out.print(wt[i][j]+" ");
            }
            System.out.println();
        }

    }
}
