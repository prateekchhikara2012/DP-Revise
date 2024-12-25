package DP;

public class v__longest_Palindromic_Subsequence {

    public static void main(String[] args) {
        

        String str="aasdfdsfjdfjkgnkljdfshgjkhdsfkjghskdjflghlkbjdfdfdfdfdfdfddfdfdfdfaaabcde";
        //recursion
       // System.out.println(  recursoin(str, 0, str.length()-1)   );

        //top_Down
        System.out.println(      top_Down(str, 0, str.length()-1, new int [str.length()][str.length()])     );


        //bottom_up
        System.out.println(   bottom_Up(str)   );
    }

    public static int recursoin(String str ,int left ,int right )
    {

        if(left==right)
        {
            return 1; 
        }
        if(left>right)
        {
            return 0;
        }

        int ans=0;
        if(str.charAt(left)==str.charAt(right))
        {
            ans=recursoin(str, left+1, right-1) +2;
        }
        else
        {
            int x=recursoin(str, left+1, right);
            int y=recursoin(str, left, right-1);
            ans=Math.max(x, y);
        }

        return ans ;
    }
    
    public static int top_Down(String str , int left , int right , int [][] strg)
    {
        if(left==right)
        {
            return 1; 
        }
        if(left>right)
        {
            return 0;
        }

        if(strg[left][right]!=0)
        {
            return strg[left][right];
        }

        int ans=0;
        if(str.charAt(left)==str.charAt(right))
        {
            ans=top_Down(str, left+1, right-1,strg) +2;
        }
        else
        {
            int x=top_Down(str, left+1, right,strg);
            int y=top_Down(str, left, right-1,strg);
            ans=Math.max(x, y);
        }
        strg[left][right]=ans;

        return ans ;
    }

    public static int bottom_Up(String str)
    {

        int strg[][]=new int [str.length()][str.length()];

        for(int si=0, ei=0 ; si<str.length() && ei<str.length() ; si++, ei++ )
        {
            strg[si][ei]=1;
        }

        for(int row=str.length()-2; row>=0 ;row--)
        {
            for(int col=row+1 ; col<strg[0].length ; col++)
            {
                int ans=0;
                if(str.charAt(col)==str.charAt(row))
                {
                    ans=strg[row+1][col-1]+2;
                }
                else
                {
                    int x= strg[row+1][col];
                    int y=strg[row][col-1];
                    ans= Math.max(x, y);
                }
                strg[row][col]=ans;
            }
        }
        return strg[0][str.length()-1];
    }
}
