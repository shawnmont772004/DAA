package daa_lab_exps;

import java.util.Scanner;

public class SumOfSubset {
    static int n,sum=0;
    static int d,flag=1;
    static int []set,x;

    static void sos(int s,int k)
    {

        x[k]=1;
        if(s+set[k]==d)
        {
            flag=0;
            System.out.print("{");
            for(int i=1;i<=n;i++)
            {
                if(x[i]==1)
                {
                    System.out.print(set[i] + ",") ;
                }
                System.out.print("}\b");
            }

        }
        else
        {
            if(s+set[k]<d && k+1<=n)
            {
                sos(s+set[k],k+1);
                x[k+1]=0;
            }
            if(k+1<=n && s+set[k+1]<=d)
            {
                x[k]=0;
                sos(s,k+1);
                x[k+1]=0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i;
        System.out.println("Enter the number of elements:");
        n=sc.nextInt();
        System.out.println("Enter the elements:");
        set=new int[n+1];
        x=new int[n+1];
        for(i=1;i<=n;i++)
        {
            set[i]=sc.nextInt();
        }
        for(i=1;i<=n;i++)
        {
            sum+=set[i];
        }
        System.out.println("Enter the sum:");
        d=sc.nextInt();
        if(d>sum || set[1]>d)
        {
            System.out.println("Not valid sum of subset");
        }
        else{
            System.out.println("the sum of subset of sum"+d+"is:");
            sos(0,1);
            if(flag==1)
            {
                System.out.println("No soln");
            }
        }
    }
}
