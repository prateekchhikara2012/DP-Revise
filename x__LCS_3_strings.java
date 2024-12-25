package DP;

import java.util.Arrays;

// Given 3 strings str_1, Y and str_3, the task is to find the longest common sub-sequence in a three given sequence.

public class x__LCS_3_strings {

    public static void main(String[] args) {
        String s_1="absdfjhklsadfoijSFJGKNKSDFDHJGSBDFJHGBSHDJFGBHJDFBGHJDSBFGDFHJGBHJDFBGFJGNJKDFBNGJKDoiewjreiowjafcjsk;lfjwlekfcgdad";
        String s_2="afdscsdkklcgdaGDFJvkjdfbjvbjhfbhjvbfhjvbhdf vnf djabsdgjkshadfhrhjgkslahfkjhfbKHSJKLCHSKJHFCKJSdfhksjdhcbfjkshF KJSDJKFCSKJDFHGDFJHGBJSDHBBHJSDFHBGJKSDBFGFDJSBGJKDSFBGskjnfkasdkfjaksdjfkajdiojaeriotjoirejpratelk camsdnmfnad";
        String s_3="addsflkmalskdlkGSDJFBGJKDFBGJHSDBFHJGBDHJSFBGajSDJHFHJCSDHFKCHSkebfj jfhksd fvjksdhfckbb klshFKvshrfkjhEIURTIQUHYRTIUEYQFKCJHKUGFHQKERGUEKRHGUEQRHKJ dsbgjkbre bELJRBGERQUBGnd;fgreqng'ldkjnwbg'jqeabn'fgbjk;febga;kdjfsdlkjaslkdjakljfklsjdklfjkl";
        //System.out.println(recursion(s_1, s_2, s_3, 0, 0, 0));


        int strg[][][]=new int [s_1.length()][s_2.length()][s_3.length()];
        for(int i=0;i<strg.length;i++)
        {
            for(int j=0;j<strg[0].length;j++)
            {
                Arrays.fill(strg[i][j],-1);
            }
        }
 
        System.out.println(top_down(s_1, s_2, s_3, 0, 0, 0, strg));

        bottom_up(s_1, s_2, s_3);
    }

    public static int recursion(String str_1, String str_2 ,String str_3 , int vdx_1 ,int vdx_2 ,int vdx_3)
    {
        if(vdx_1==str_1.length() || vdx_2==str_2.length() || vdx_3==str_3.length())
        {
            return 0;
        }

        int val=0;
        if(str_1.charAt(vdx_1)==str_2.charAt(vdx_2) && str_1.charAt(vdx_1)==str_3.charAt(vdx_3))
        {

            val= recursion(str_1, str_2, str_3, vdx_1+1, vdx_2+1, vdx_3+1) + 1;

        }
        else
        {
            int a=recursion(str_1, str_2, str_3, vdx_1+1, vdx_2, vdx_3);
            int b=recursion(str_1, str_2, str_3, vdx_1, vdx_2+1, vdx_3);
            int c=recursion(str_1, str_2, str_3, vdx_1, vdx_2, vdx_3+1);

            val=Math.max(a, Math.max(b,c));
        }
        return val;
    }


    public static int top_down(String str_1, String str_2, String str_3 , int vdx_1 ,int vdx_2 , int vdx_3 , int [][][]strg )
    {
        if(vdx_1==str_1.length() || vdx_2==str_2.length() || vdx_3==str_3.length())
        {
            return 0;
        }

        if(strg[vdx_1][vdx_2][vdx_3]!=-1)
        {
            return strg[vdx_1][vdx_2][vdx_3];
        }

        int val=0;
        if(str_1.charAt(vdx_1)==str_2.charAt(vdx_2) && str_1.charAt(vdx_1)==str_3.charAt(vdx_3))
        {

            val= top_down(str_1, str_2, str_3, vdx_1+1, vdx_2+1, vdx_3+1,strg) + 1;

        }
        else
        {
            int a=top_down(str_1, str_2, str_3, vdx_1+1, vdx_2, vdx_3,strg);
            int b=top_down(str_1, str_2, str_3, vdx_1, vdx_2+1, vdx_3,strg);
            int c=top_down(str_1, str_2, str_3, vdx_1, vdx_2, vdx_3+1,strg);

            val=Math.max(a, Math.max(b,c));
        }

        strg[vdx_1][vdx_2][vdx_3]=val;
        return val;
    }
    

    public static void bottom_up(String str_1, String str_2 , String str_3)
    {

        int [][][] strg=new int [str_1.length()+1 ][str_2.length()+1][str_3.length()+1];

        for(int i=str_1.length()-1;i>=0;i--)
        {
            for(int row=str_2.length()-1;row>=0;row--)
            {

                int val=0;
                for(int col=str_3.length()-1;col>=0;col--)
                {


                    if(str_1.charAt(i)==str_2.charAt(row) && str_1.charAt(i)==str_3.charAt(col))
                    {

                        val= strg[i+1][row+1][col+1] + 1;

                    }
                    else
                    {
                        int a=strg[i+1][row][col];
                        int b=strg[i][row+1][col];
                        int c=strg[i][row][col+1];

                        val=Math.max(a, Math.max(b,c));
                    }

                    strg[i][row][col]=val;
                }
               

            }
        }

        System.out.println(strg[0][0][0]);
    }
}
