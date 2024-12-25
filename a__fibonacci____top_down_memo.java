package DP;

public class a__fibonacci____top_down_memo{
    public static void main(String[] args) {

        int arr[]=new int[11]; // We make an array size one more than the num which we are counting the fibonacci so that the indexing can be valid

        
        System.out.println( fun(10,arr) );

        
    }

    public static int fun(int num,int [] arr)
    {

        if(num==0 || num==1)
        return num;


        // so to check if the value is already used or not
        if(arr[num]!=0)   
        {
            return arr[num];
        }



        int x=fun(num-1,arr);
        int y=fun(num-2,arr);

        int sum=x+y;


        // to assign the value in the array 
        arr[num]=sum; 


        
        return sum ;
    }
    
}
