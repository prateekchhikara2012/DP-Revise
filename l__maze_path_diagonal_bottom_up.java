package DP;

import java.util.Arrays;

public class l__maze_path_diagonal_bottom_up {

    public static void main(String[] args) {

        int row=3 , col=3;
       

        not_space_efficient(row, col );

      
        // As we have seen the 1 is occuring both the sides so we can take advantage by 
        // not including the 0s
        excluding_0s(row,col);




        space_efficient(col);

        
    }

    public static void not_space_efficient(int er , int ec)
    {


        int arr[][]=new int [er+1][ec+1];
        arr[er-1][ec-1]=1;


        for(int row=arr.length-2;row>=0 ; row -- )
        {
            for(int col=arr[0].length-2;col>=0 ;col--)
            {
                if(arr[row][col]==1)
                {
                    continue;
                }

                arr[row][col]=arr[row][col+1]+arr[row+1][col+1]+arr[row+1][col];
            }
        }
        System.out.println(arr[0][0]);
    }
    
    public static void excluding_0s(int er,int ec)
    {
        int arr[][]=new int [er][ec];

        //for filling
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                arr[i][j]=1;
            }
        }

        for(int row=arr.length-2;row>=0 ;row--)
        {
            for(int col=arr[0].length-2;col>=0;col--)
            {
                arr[row][col]=arr[row][col+1]+arr[row+1][col+1]+arr[row+1][col];
            }
        }
        System.out.println(arr[0][0]);

    }

    public static void space_efficient(int ec)
    {

        
        int arr[] =new int [ec];

        Arrays.fill(arr,1);

        for(int i=1;i<=2;i++)
        {
            int prev=1;
            for(int col=ec-2;col>=0;col--)
            {
                int temp=arr[col];

                arr[col]=arr[col]+arr[col+1]+prev;

                prev=temp;
                
            }
        }

        System.out.println(arr[0]);

    }
}
