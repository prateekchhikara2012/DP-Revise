package DP;

public class c__fibonacci_bottom_up_space_efficient {
    public static void main(String[] args) {
        
        fun(7);
    }

    public static void fun(int num )
    {
        int arr[]=new int [2];     // 1-> Array size


        // 2 -> base case
        arr[0]=0;
        arr[1]=1;


        for(int i=1;i<num;i++){
            int sum=arr[0]+arr[1];

            arr[0]=arr[1];
            arr[1]=sum;
        }
        

        System.out.println(arr[1]);
    }
    
}
