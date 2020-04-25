package com.company;
import java.util.Scanner;
public class Sortare {
    Scanner scanner = new Scanner(System.in);
    public void sortare(){

        int n;
        System.out.print("\n"+"n=");
        n=scanner.nextInt();
        int[] a=new int[100];
        citire(n,a);
        int[] vp=new int[50];
        int[] vi=new int[50];
        int i,s=0,h=0;
        for(i=0;i<n;i++)
        {   if(i%2==0)
            vp[s++]=a[i];
            if(i%2==1)
                vi[h++]=a[i];}
        heapsort(vi,h);
        shellSort(vp,s);
        for(i=0;i<n;i=i+2)
            a[i]=vp[i/2];
        for(i=1;i<n;i=i+2)
            a[i]=vi[i/2];
        afisare(n,a);
    }
    public void citire(int n, int[] a)
    {
        int i;
        for(i=0;i<n;i++)
        {
            System.out.print("a["+i+"]=");
            a[i]=scanner.nextInt();
        }
    }
    public void afisare(int n, int[] a)
    {
        int i;
        System.out.println("\n"+"Vectorul sortat conform cerintei:");
        for(i=0;i<n;i++)
            System.out.println("\t"+"a["+i+"]="+a[i]);
    }
    void shellSort(int[] a,int n)
    {
        int gap,temp,i,j;
        for (gap = n/2; gap > 0; gap /= 2)
        {
            for (i = gap; i < n; i += 1)
            {
                temp = a[i];
                for (j = i; j >= gap && a[j - gap] > temp; j -= gap)
                    a[j] = a[j - gap];
                a[j] = temp;
            }
        }
    }
    void swap(int[] a,int i,int j)
    {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;

    }
    void downheap(int[] a,int v,int n)
    {
        int w = 2 * v + 1; // primul descendent al lui v
        while (w<n)
        {
            if (w+1<n) // mai exista unul?
                if (a[w+1]<a[w]) w++; //crescator
            // w este decendentul lui v
            if (a[v]<=a[w]) return; //crescator
            swap(a,v, w); // interschimbam v cu w
            v = w; // continuam
            w = 2 * v + 1;
        }
    }
    void heapsort(int[] a,int n)
    {
        for (int v = n/2-1; v >= 0; v--)
            downheap (a,v,n);
        while (n>1)
        {
            n--;
            swap(a,0, n);
            downheap (a,0,n);
        }
    }
}


