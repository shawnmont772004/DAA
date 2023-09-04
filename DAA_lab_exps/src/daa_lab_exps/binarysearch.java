package daa_lab_exps;

import java.util.Scanner;

public class binarysearch {
    void input(int n,int []a)
    {
        int i;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the elements:");
        for(i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
    }
    int decnconq(int []a,int low,int high,int k)
    {
        if(low<=high)
        {
            int mid=(low+high)/2;
            if(a[mid]==k)
            {
                return mid;
            }
            else if(a[mid]<=k)
            {
                return decnconq(a,mid+1,high,k);

            }
            else if(a[mid]>=k)
            {
                return decnconq(a,low,mid-1,k);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int key,n;
        int []a;
        Scanner sc=new Scanner(System.in);
        binarysearch b=new binarysearch();
        System.out.println("enter the size of the array");
        n=sc.nextInt();
        a=new int[n];
        b.input(n,a);
        System.out.println("Please enter the element to be searched:");
        key=sc.nextInt();
        int low=0;
        int high=n-1;
        int loc=b.decnconq(a,low,high,key);
        if (loc == -1)
        {
            System.out.println("Element not found.");
        }
        else{
            loc++;
            System.out.println("Element found at location:"+loc);
        }
    }
}
