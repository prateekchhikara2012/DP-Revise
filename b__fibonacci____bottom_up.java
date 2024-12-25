package DP;

public class b__fibonacci____bottom_up {
    public static void main(String[] args) {
        System.out.println(fun(10));
        
    }
    
    public static int fun(int num)
    {

        int arr[]=new int [num+1];

        arr[0]=0;
        arr[1]=1;

        for(int i=2;i<arr.length;i++)
        {
            arr[i]=arr[i-1]+arr[i-2];
        }

        return arr[arr.length-1];
    }
}
