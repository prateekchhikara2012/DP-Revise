package DP;

import java.util.Arrays;

public class y__LIS {

    public static void main(String[] args) {

       // int nums[]={0,8,4,12,2,10,6,14,1,9,5,13,1234,23,14,23,534,5,56,35,67,65,7,254,7,45,7,268,567,876,8,46,786,4234,32,233215,4,3,56,1,4,7,6,7,57,2,457,45,7568,23,32678,979789,78,9789789,87,9,789,78,9,78,97,3,11,7,15};


        int nums[]=new int [10000];
        nums[0]=23;
        for(int i=1;i<nums.length;i++)
        {
            nums[i]=nums[i-1]*2-3;
        }


        // int [] strg=new int [nums.length];
        // Arrays.fill(strg ,-1);



        int max=Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++)
        // {
        //     max=Math.max(td(nums, i+1 ,strg)+1 ,max);
        // }
        System.out.println(max);


        
        //System.out.println(n_square(nums));

        System.out.println(n_log_n(nums));


        
    }


    public static int td(int arr[] , int idx , int []  strg)
    {
        if(idx==arr.length)
        {
            return 0;
        }

        if(strg[idx]!=-1)
        {
            return strg[idx];
        }

        int max=0;
        for(int i=idx ; i <arr.length ;i++)
        {
            if(arr[i]>arr[idx-1])
            {
                // can be a lis
                int val=td(arr ,i+1 ,strg) +1;
                max=Math.max(val , max);
            }
        }
        strg[idx]=max;
        return max;
    }

    public static int n_square(int[] nums) {

        int strg[]=new int [nums.length];

        Arrays.fill(strg,1); // every element is a LIS so that is why we are updating the array as a 1.

        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i]) // checking if the element in the array is smaller than the main element
                {
                    int sum=strg[j]+1; 

                    if(sum>strg[i])
                    {
                        strg[i]=sum;
                    }
                }
            }
        }
        
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(strg[i]>max)
            {
                max=strg[i];
            }
        }
        return max;
    }

    public static int n_log_n(int []nums)
    {
        int strg[]=new int [nums.length];
        strg[0]=nums[0];
        int last_element_pointer=0;

        for(int i=1;i<nums.length;i++)
        {

            if(nums[i]>strg[last_element_pointer])
            {

                strg[last_element_pointer+1]=nums[i];
                last_element_pointer++;
                
            }
            else
            {
                
               int replacing_index= binary_Search(nums[i] , 0 , last_element_pointer , strg);

               strg[replacing_index]=nums[i];
            }
        }

        return last_element_pointer+1;


    }

    public static int binary_Search(int element , int si , int ei , int [] strg)
    {
        int low=si ,  high=ei; 

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(element>strg[mid])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return low;
    }



}
    
