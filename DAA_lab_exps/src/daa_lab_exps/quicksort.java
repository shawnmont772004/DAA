package daa_lab_exps;

import java.util.Random;
import java.util.Scanner;

public class quicksort {
    private int[]a;
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
        quicksortmeth(0,a.length-1);
    }
    void quicksortmeth(int left,int right)
    {
        if (left < right) {
            int partind = partition(left, right);
            quicksortmeth(left, partind - 1);
            quicksortmeth(partind + 1, right);
        }
    }
    int partition(int left,int right)
    {
        int pivot=a[left];
        int i=left;
        int j=right;
        while(i<j)
        {
            while(i<right &&a[i]<=pivot)
            {
                i++;
            }
            while(j>left && a[j]>pivot)
            {
                j--;
            }
            if(i<j)
            {
                swap(i,j);
            }
        }
        swap(left,j);
        return j;
    }

    void swap(int i,int j)
    {
        int temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void main(String[] args) {
        quicksort q=new quicksort();
        q.input();
        System.out.println("Array before sorting:");
        q.display();
        long start=System.nanoTime();
        q.sort();
        long end=System.nanoTime();
        double duration=(end-start)/1000000;
        System.out.println("Array after sorting:");
        q.display();
        System.out.println("The time taken for sorting:"+duration+" milliseconds.");

    }
}
