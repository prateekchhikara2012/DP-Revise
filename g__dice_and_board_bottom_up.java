package DP;

public class g__dice_and_board_bottom_up {

    public static void main(String[] args) {

        fun(9);
    }
    

    public static void fun(int num)
    {


        int arr[]=new int [16];
         
        // back to front
        arr[num]=1;

        for(int i=num-1; i >=0 ; i--)
        {
            arr[i]=arr[i+1]+arr[i+2]+arr[i+3]+arr[i+4]+arr[i+5]+arr[i+6];
        }

        System.out.println(arr[0]);
    }
}
