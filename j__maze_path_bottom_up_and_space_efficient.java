package DP;

import java.util.Arrays;

public class j__maze_path_bottom_up_and_space_efficient {


    public static void main(String[] args) {

        int er=2, ec =2;

        int arr[][]= new int [er+2][ec+2];

        arr[er][ec]=1;

        for(int i=er;i>=0;i--)
        {
            for(int j=ec;j>=0 ; j--)
            {

                if(arr[i][j]==1);
                else
                {
                    arr[i][j]=arr[i+1][j] + arr[i][j+1];
                }
            }
        }
        System.out.println(arr[0][0]);


        // Second methord  without adding the 0 int the end
        // fun();

        
        // for space efficeint way
        // bottom_up_space_eff();
    }

    public static void fun()
    {

        int arr[][]=new int [3][3];

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                arr[i][j]=1;
            }
        }


        for(int row=arr.length-2;row>=0;row--)
        {
            for(int col=arr[0].length-2; col>=0;col-- )
            {
                arr[row][col]=arr[row][col+1]+arr[row+1][col];
            }
        }

        System.out.println(arr[0][0]);
    }
    

    public static void bottom_up_space_eff()
    {

        int arr[]=new int [3];

        Arrays.fill(arr, 1);


        for(int i=1;i<=2;i++)
        {
            for(int j=arr.length-2;j>=0;j--)
            {
                arr[j]=arr[j]+arr[j+1];
            }
        }
        System.out.println(arr[0]);


    }
}
