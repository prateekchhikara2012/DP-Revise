package DP;

public class t__wildcard_matching {


    public static void main(String args[])
    {

        String src="abcde";
        String pattern="a?**?e";

        // recursion
       System.out.println(    recursion(src, pattern, 0, 0)     );


       // top_down
       System.out.println(    top_down( src,  pattern, 0, 0, new int  [src.length()][pattern.length()])        );


       // bottom_up
       bottom_up(src, pattern);
    }

    public static boolean recursion(String src, String pattern,int s_vdx , int p_vdx)
    {
        if(s_vdx==src.length() && p_vdx==pattern.length())
        {
            return true;
        }

        // if pattern length is =  0 
        if(p_vdx==pattern.length())
        {
            return false;
        }

        //if source length is =0 
        // pattern can be all * also
        if(s_vdx==src.length())
        {

            for(int i=p_vdx ; i<pattern.length();i++)
            {
                if(pattern.charAt(i)!='*')
                {
                    return false;
                }
            }
            return true;

        }
                

        boolean value = false ;
         
        if(src.charAt(s_vdx)==pattern.charAt(p_vdx) || pattern.charAt(p_vdx)=='?')
        {
            value= recursion(src, pattern, s_vdx+1, p_vdx+1);
        }
        else if(pattern.charAt(p_vdx)=='*')
        {
            boolean blank  =  recursion(src, pattern, s_vdx, p_vdx+1);   // blank call
            boolean single =  recursion(src, pattern, s_vdx+1, p_vdx+1);  // single character
            boolean multi  =  recursion(src, pattern, s_vdx+1, p_vdx);   // Mutliple characters

            if(blank==true || single==true  || multi==true)
            {
                value=true ;
            }

        }
        else 
        {
            value= false;
        }
        return value; 
    }


    public static boolean top_down(String src , String pattern , int s_vdx , int p_vdx , int [][] strg)
    {


        if(s_vdx==src.length() && p_vdx==pattern.length())
        {
            return true;
        }

        // if pattern length is =  0 
        if(p_vdx==pattern.length())
        {
            return false;
        }

        //if source length is =0 
        // pattern can be all * also
        if(s_vdx==src.length())
        {

            for(int i=p_vdx ; i<pattern.length();i++)
            {
                if(pattern.charAt(i)!='*')
                {
                    return false;
                }
            }
            return true;
        }

        if(strg[s_vdx][p_vdx]!=0)
        {
            if(strg[s_vdx][p_vdx]==2)
            {
                return true;
            }
            else
            {
                return false;
            }
        }



        boolean ans;
        if(src.charAt(s_vdx)==pattern.charAt(p_vdx) || pattern.charAt(p_vdx)=='?')
        {
            ans=top_down(src, pattern, s_vdx+1, p_vdx+1, strg);
        }
        else if(pattern.charAt(p_vdx)=='*')
        {
            boolean blank =top_down(src, pattern, s_vdx, p_vdx+1, strg);
            boolean single=top_down(src, pattern, s_vdx+1, p_vdx+1, strg);
            boolean multi=top_down(src, pattern, s_vdx+1, p_vdx, strg);

            ans =blank || single || multi ;
        }
        else
        {
            ans=false;
        }

        if(ans)
        {
            strg[s_vdx][p_vdx]=2;
        }
        else
        {
            strg[s_vdx][p_vdx]=1;
        }

        return ans;
    }

    public static void bottom_up(String src , String pattern)    
    {
         
        boolean [][]arr =new boolean [src.length()+1][pattern.length()+1];



        arr[src.length()][pattern.length()]=true;

        for(int col=pattern.length()-1 ; col>=0; col--)
        {
            if(pattern.charAt(col)=='*')
            {
                arr[src.length()][col]=true;
            }
            else
            {
                break;
            }
        }

        for(int row=src.length()-1 ; row>=0 ;row--)
        {
            for(int col=pattern.length()-1; col>=0; col--)
            {
                if(src.charAt(row)==pattern.charAt(col) || pattern.charAt(col)=='?')
                {
                    arr[row][col]=arr[row+1][col+1];
                }
                else if(pattern.charAt(col)=='*')
                {
                    boolean blank=arr[row][col+1];
                    boolean single=arr[row+1][col+1];
                    boolean multi=arr[row+1][col];

                    arr[row][col]= blank || single || multi ; 
                }
                else
                {
                    arr[row][col]=false; 
                }
            }
        }

        System.out.println(arr[0][0]);



    }
}

