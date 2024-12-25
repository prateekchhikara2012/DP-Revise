package DP;

public class p__MCM {

    public static void main(String[] args) {
        
        int [] arr={2,3,5,2,1,6};

        //recursion
      //  System.out.println(recursion(arr, 0, arr.length-1));


        //top down 
        System.out.println(top_down(arr, 0, arr.length-1, new int [arr.length][arr.length]));


        bottom_up(arr);

    }

    public static int recursion(int arr[] , int si ,int ei )
    {

        if(si+1==ei)
        {
            return 0; 
        }

        int min=Integer.MAX_VALUE;

        for(int k=si+1 ; k<=ei-1 ; k++)
        {
            int fp= recursion(arr, si, k);
            int sp=recursion(arr, k, ei);

            int total=arr[si]*arr[k]*arr[ei];
  
            int sum =fp+sp+total;

            if(sum<min)
            {
                min=sum;
            }
        }

        return  min;
    }
 
    
    public static int top_down(int arr[] , int si ,int ei , int [][] nums)
    {
        if(si+1==ei)
        {
            return 0;
        }
        if(nums[si][ei]!=0)
        {
            return nums[si][ei];
        }

        int min =Integer.MAX_VALUE;

        for(int k=si+1; k<=ei-1; k++)
        {
            int fp=top_down(arr, si, k, nums);
            int sp=top_down(arr, k, ei, nums);


            int total=arr[si]*arr[k]*arr[ei];
            int sum=fp+sp+total;

            if(sum<min)
            {
                min=sum;
            }


        }
        nums[si][ei]=min;

        return min; 
    }


    public static void bottom_up(int arr[])
    {

        int nums[][]=new int [arr.length][arr.length];


        for(int si=arr.length-3;si>=0;si--)
        {
            for(int ei=si+2;ei<arr.length;ei++)
            {
                int min=Integer.MAX_VALUE;
                for(int k=si+1;k<=ei-1 ; k++)
                {
                    int fp=nums[si][k];
                    int sp=nums[k][ei];

                    int total=arr[si]*arr[k]*arr[ei];
                    int sum=total+fp+sp;
                    // System.out.println(total);

                    if(sum<min)
                    {
                        min=sum;
                    }
                }

                nums[si][ei]=min;

            }
        }
        System.out.println(nums[0][nums[0].length-1]);

        // for(int abc[]:nums)
        // {
        //     for(int i:abc)
        //     {
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }
    }
}
