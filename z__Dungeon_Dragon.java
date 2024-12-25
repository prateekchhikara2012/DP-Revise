package DP;
//  https://leetcode.com/problems/dungeon-game/


public class z__Dungeon_Dragon {

    public static void main(String[] args) {

        int arr[][]={ {0,0,0},{1,1,-1}};

        System.out.println(  recursion(arr, 0, 0)   );


        System.out.println(  top_Down(arr, 0, 0, new int [arr.length][arr[0].length])   );


        bottom_Up(arr);

        
    }
    public static int recursion( int arr[][] ,int row, int col )
    {
        if(row==arr.length-1 && col==arr[0].length-1)
        {

            if(arr[row][col]<=0)
            {
                return -1*arr[row][col]+1;
            }
            else
            {
                return 1; 
            }

        }
        if(col==arr[0].length || row==arr.length)
        {
            return Integer.MAX_VALUE;
        }


        int right=recursion(arr, row, col+1);
        int left=recursion(arr, row+1, col);


        int min=Math.min(right, left);


        int sum=min-arr[row][col];

        int ans;
        if(sum>=1 ) // to check if the current money required is >=1
        {
            ans=sum;
        }
        else
        {
            ans=1;
        }

        return ans;
    }


    public static int top_Down(int arr[][] , int row ,int col , int [][] strg)
    {
        if(row==arr.length-1 && col==arr[0].length-1)
        {

            if(arr[row][col]<=0)
            {
                return -1*arr[row][col]+1;
            }
            else
            {
                return 1; 
            }

        }
        if(col==arr[0].length || row==arr.length)
        {
            return Integer.MAX_VALUE;
        }

        if(strg[row][col]!=0)
        {
            return strg[row][col];
        }




        int right=top_Down(arr, row, col+1,strg);
        int left=top_Down(arr, row+1, col,strg);


        int min=Math.min(right, left);


        int sum=min-arr[row][col];

        int ans;
        if(sum>=1 ) // to check if the current money required is >=1
        {
            ans=sum;
        }
        else
        {
            ans=1;
        }

        strg[row][col]=ans;

        return ans;
    }
 
    
    public static void bottom_Up(int arr[][])
    {
        int strg[][]=new int [arr.length+1][arr[0].length+1];

        for(int row=0;row<strg.length;row++)
        {
            strg[row][strg[0].length-1]=Integer.MAX_VALUE;
        }

        for(int col=0;col<strg[0].length;col++)
        {
            strg[strg.length-1][col]=Integer.MAX_VALUE;
        }


        if(arr[arr.length-1][arr[0].length-1]>=1)
        {
            strg[strg.length-2][strg[0].length-2]=1;
        }
        else
        {
            strg[strg.length-2][strg[0].length-2]=-1*arr[arr.length-1][arr[0].length-1]+1;
        }




        for(int row=strg.length-2;row>=0; row--)
        {
            for(int col=strg[0].length-2;col>=0; col--)
            {

                if(row==strg.length-2 && col==strg[0].length-2);
                else
                {
                    int min=Math.min(strg[row][col+1], strg[row+1][col]);

                    int sum = min - arr[row][col];

                    if(sum<=0)
                    {
                        sum=1;
                    }

                    strg[row][col]=sum;
                }

            }
        }
    }
}
