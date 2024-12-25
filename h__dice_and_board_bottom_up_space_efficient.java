package DP;

public class h__dice_and_board_bottom_up_space_efficient {
    public static void main(String[] args) {

        int arr [] =new int [6];
        arr[0]=1;

        for(int i=9;i>=0;i--)
        {
            int sum=arr[0]+arr[1]+arr[2]+arr[3]+arr[4]+arr[5];


            arr[5]=arr[4];
            arr[4]=arr[3];
            arr[3]=arr[2];
            arr[2]=arr[1];
            arr[1]=arr[0];


            arr[0]=sum;
        }

        System.out.println(arr[0]);
    }
    
}
