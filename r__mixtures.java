package DP;

//Harry Potter has n mixtures in front of him, arranged in a row. Each mixture has one of 100 different colors (colors have numbers from 0 to 99).
// He wants to mix all these mixtures together. At each step, he is going to take two mixtures that stand next to each other and mix them together, and put the resulting mixture in their place.
// When mixing two mixtures of colors a and b, the resulting mixture will have the color (a+b) mod 100.
// Also, there will be some smoke in the process. The amount of smoke generated when mixing two mixtures of colors a and b is a*b.
// Find out what is the minimum amount of smoke that Harry can get when mixing all the mixtures

import java.util.Arrays;

public class r__mixtures
{
    public static void main(String[] args) {
        
        int arr[]={43,25,34,52,34,56,16,4,36,143,134,23,56,4,5,345,43,15,46,5,67,567,6,78,76,8,6564,658,56,76,5,46,2,456,456,456246,546,254,7,67,6578356,7,5427,2,7,245,7,2546};


        //recursion
       // System.out.println( recursion(arr, 0, arr.length-1));




        // Top_down
        int storgae[][]=new int [arr.length][arr.length];
        for(int i=0;i<storgae.length;i++)
        {
            Arrays.fill(storgae[i],-1);
        }
        System.out.println(top_down(arr, 0, arr.length-1, storgae));

        


        // Bottom up
        bottom_up(arr);
    }

    public static int recursion(int arr[] , int si , int ei)
    {

        if(si==ei)
        {
            return 0;
        }
        

        int min =Integer.MAX_VALUE;

        for(int k=si+1; k<=ei;k++)
        {
            int a_smoke=recursion(arr, si, k-1);
            int b_smoke=recursion(arr, k, ei);


            int a_color=0;
            for(int i=si;i<=k-1;i++)
            {
                a_color=a_color+arr[i];
            }
            a_color=a_color%100;
            


            int b_color=0;
            for(int i=k;i<=ei;i++)
            {
                b_color=b_color+arr[i];
            }
            b_color=b_color%100;

            int total_smoke=(a_color*b_color) + a_smoke+b_smoke;

            if(total_smoke<min)
            {
                min=total_smoke;
            }

        }
        return min;
    }

    public static int top_down(int arr[] , int si , int ei , int [][] storage)
    {

        if(si==ei)
        {
            return 0; 
        }

        if(storage[si][ei]!=-1)
        {
            return storage[si][ei];
        }

        int min=Integer.MAX_VALUE;
        for(int k=si+1;k<=ei;k++)
        {
            int a_smoke=top_down(arr, si, k-1, storage);
            int b_smoke=top_down(arr, k, ei, storage);


            int a_color=0;
            for(int i=si;i<=k-1;i++)
            {
                a_color=a_color+arr[i];
            }
            a_color=a_color%100;
            


            int b_color=0;
            for(int i=k;i<=ei;i++)
            {
                b_color=b_color+arr[i];
            }
            b_color=b_color%100;




            int total_smoke=a_color*b_color + a_smoke+b_smoke;

            if(total_smoke<min)
            {
                min=total_smoke;
            }

        }

        storage[si][ei]=min;

        return min;
    }

    public static void bottom_up(int arr[] )
    {

        int nums[][]=new int [arr.length][arr.length];


        for(int slide=1;slide<arr.length;slide++)
        {
            for(int si=0 , ei=slide ; si<nums.length && ei<nums[0].length ; si++ ,ei++)
            {
                int min=Integer.MAX_VALUE;
                for(int k =si+1 ; k<=ei ; k++)
                {
                    int a_smoke=nums[si][k-1];
                    int b_smoke=nums[k][ei];



                    int a_color=0;
                    for(int i=si;i<=k-1;i++)
                    {
                        a_color=a_color+arr[i];
                    }
                    a_color=a_color%100;
                    


                    int b_color=0;
                    for(int i=k;i<=ei;i++)
                    {
                        b_color=b_color+arr[i];
                    }
                    b_color=b_color%100;



                    int total_smoke=a_color*b_color + a_smoke+b_smoke;

                    if(total_smoke<min)
                    {
                        min=total_smoke;
                    }
                }
                nums[si][ei]=min;
            }
        }


        System.out.println(nums[0][arr.length-1]);
    }

}