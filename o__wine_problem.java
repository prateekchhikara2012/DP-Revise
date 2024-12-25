package DP;

public class o__wine_problem {

    public static void main(String[] args) {
        
        int arr[]={2,3,5,1,4};

        // recursion 
        // System.out.println(recursion(arr, 0, arr.length-1, 1));

        // td
        System.out.println(td(arr, 0, arr.length-1, 1, new int [arr.length][arr.length]));

        System.out.println(bu (arr));
    }

    public static int recursion(int arr[] , int left , int right , int level)
    {

        if(left==right)
        {

            return arr[left]*level;
        }

        int x=recursion(arr, left+1, right, level+1) + level*arr[left];
        int y=  recursion(arr, left, right-1, level+1) + level*arr[right];

        return Math.max(x,y);
    }
    


    public static int td(int arr[] , int left, int right , int yr , int nums[][])
    {
        if(left==right)
        {
            return arr[left]*yr;
        }

        if(nums[left][right]!=0)
        {
            return nums[left][right];
        }


        int x=td(arr, left+1, right, yr+1, nums) + yr*arr[left];
        int y=td(arr, left, right-1, yr+1, nums) + yr*arr[right]; 


        int max=Math.max(x,y);

        nums[left][right]=max;

        return max;
    }

    public static int bu(int arr[])
    {

        int nums[][]=new int [arr.length][arr.length];

        
        // Diagonal entering 
        for(int row=0 ,col=0 ;row<arr.length && col<arr.length ;row++ ,col++)
        {
            nums[row][col]=arr[row]*arr.length;
        }



        //work    
        for(int row=arr.length-2;row>=0 ; row--)
        {
           int yr=arr.length-1;
            for(int col=row+1;col<arr.length;col++)
            {

                int x=nums[row+1][col] + arr[row]*yr;

                int y=nums[row][col-1] + arr[col]*yr;
                
                yr--;
                nums[row][col]=Math.max(x,y);
            }
        }


        //for Displaying
        for(int abc[] :nums)
        {
            for(int i:abc)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }

        return nums[0][nums.length-1];

    }


}
