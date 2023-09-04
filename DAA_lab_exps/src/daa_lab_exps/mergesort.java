package daa_lab_exps;

import java.util.Random;
import java.util.Scanner;

public class mergesort {

    private int[] a;
    int n;
    void input()
    {
        Scanner sc=new Scanner(System.in);
        Random ran =new Random();
        int i;
        System.out.println("Enter the number of elements");
        n=sc.nextInt();
        a=new int[n];
        for(i=0;i<n;i++)
        {
            a[i]=ran.nextInt(500);
        }
    }
    void display()
    {
        for(int x:a){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    void sort()
    {
        mergesortmeth(0,a.length-1);
    }

    void mergesortmeth(int left,int right){
        if(left>=right)
        {
            return;
        }
        else{
            int mid=(left+right)/2;
            mergesortmeth(left,mid);
            mergesortmeth(mid+1,right);
            merge(left,mid,right);

        }
    }
    void merge(int left,int mid,int right )
    {
        int i=left;
        int j=mid+1;
        int k=0;
        int []temp=new int[n+1];

        while(i<=mid && j<=right){
            if(a[i]<=a[j])
            {
                temp[k++]=a[i++];
            }
            else if(a[i]>=a[j])
            {
                temp[k++]=a[j++];
            }
        }
        while(i<=mid)
        {
            temp[k++]=a[i++];
        }
        while(j<=right) {
            temp[k++] = a[j++];
        }
        for(i=left;i<=right;i++)
        {
            a[i]=temp[i-left];
        }
    }

    public static void main(String[] args) {
        mergesort m=new mergesort();
        m.input();
        System.out.println("Array before sorting:");
        m.display();
        long start=System.nanoTime();
        m.sort();
        long end=System.nanoTime();
        System.out.println("Array after sorting:");
        m.display();
        double duration=(end-start)/1000000;
        System.out.println("The time taken for sorting:"+duration+" milliseconds.");
    }
}
