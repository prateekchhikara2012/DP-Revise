package DP;


public class w__k_order_LCS
{
    public static void main(String[] args) {
        String s_1= "aKLJfdskjgiurgdafghjbadfhjgalfbghjadbfghabdfghjlbdfhjgbahjfbgahdjfbgertuhqeriuthieuqrhkjsdgkjfhdjgkahdkljjk dfgdf gdnfgnmfdbgjbfjabgjdgbkjfdblgjabdfkgjbfdjkgjkgnkjGffdgd";
        String s_2="adfsjgasdjkfdfkjvjkdafnvjkbnfdjbjhafbdghjbdfjhbghfdbgjhdafbgjhbadfhjgbadfgnkjsdbfjksabdgjkbfjhgbdahbghregdgjfkgnkjdasahjd";

        int k=53;


        //recursion
       // System.out.println(    recursion(s_1, s_2, 0, 0, k)     );

       


        // top_down
        int [][][] strg= new int  [k+1]   [s_1.length()]   [s_2.length()]     ;

        for(int i=0;i<strg.length;i++)
        {

            for(int row=0;row<strg[0].length;row++)
            {
                for(int col=0;col<strg[0][0].length;col++)
                {
                    strg[i][row][col]=-1;
                }
            }
        }

       System.out.println(     top_down(s_1, s_2, 0, 0, k, strg)     )  ;




       //bottom_up


       System.out.println(bottom_up(s_1, s_2, k));



        
    }

    public static int recursion(String s_1 , String s_2 , int vdx_1 ,int vdx_2  , int k)
    {

        if(s_1.length()==vdx_1 || vdx_2==s_2.length())
        {
            return 0;
        }


        int val=0;
        if(s_1.charAt(vdx_1)==s_2.charAt(vdx_2))
        {
            val=recursion(s_1, s_2, vdx_1+1, vdx_2+1, k)+1;
        }
        else
        {
            int max=0;
            if(k>0)
            {
               max = recursion(s_1, s_2, vdx_1+1, vdx_2+1, k-1)+1;
            }

            int x=recursion(s_1, s_2, vdx_1, vdx_2+1, k);
            int y=recursion(s_1, s_2, vdx_1+1, vdx_2, k);

            val=Math.max(max,Math.max(x, y));
        }

        return val;
    }
    

    public static int top_down(String s_1 , String s_2 , int vdx_1 ,int vdx_2 , int k , int strg[][][])
    {

        if(s_1.length()==vdx_1 || vdx_2==s_2.length())
        {
            return 0;
        }

        if(strg    [k]    [vdx_1]  [vdx_2]   !=-1)
        {
            return strg   [k]  [vdx_1]  [vdx_2]   ;
        }


        int val=0;
        if(s_1.charAt(vdx_1)==s_2.charAt(vdx_2))
        {
            val=top_down(s_1, s_2, vdx_1+1, vdx_2+1, k,strg)+1;
        }
        else
        {
            int max=0;
            if(k>0)
            {
               max = top_down(s_1, s_2, vdx_1+1, vdx_2+1, k-1,strg)+1;
            }

            int x=top_down(s_1, s_2, vdx_1, vdx_2+1, k,strg);
            int y=top_down(s_1, s_2, vdx_1+1, vdx_2, k,strg);

            val=Math.max(max,Math.max(x, y));
        }


        strg  [k]   [vdx_1]  [vdx_2]   =  val;


        return val;

    }


    public static int bottom_up(String s_1 , String s_2 , int tk)
    {

        int strg [][][]=new int [tk+1][s_1.length()+1][s_2.length()+1];


        for(int k=0;k<strg.length;k++)
        {
            for(int row=strg[0].length-2;row>=0 ;row--)
            {
                for(int col=strg[0][0].length-2;col>=0 ;col--)
                {
                    int val=0;

                    if(s_1.charAt(row)==s_2.charAt(col))
                    {
                        val=strg[k][row+1][col+1]+1;
                    }
                    else
                    {
                        int max=0;
                        if(k>0)
                        {
                            max = strg[k-1][row+1][col+1]+1;
                        }

                        int x=strg[k][row][col+1];
                        int y=strg[k][row+1][col];

                        val=Math.max(max,Math.max(x, y));
                    }

                    strg[k][row][col]=val;


                }
            }
        }

        return strg[tk][0][0];







    }
}