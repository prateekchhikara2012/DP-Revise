package DP;


import java.util.Arrays;

public class m__Longest_common_Subsequence {

    public static void main(String[] args) {
        
        String a="acbd";
        String b="abcjk";


        // recursion
        System.out.println(without_virtual_index(a,b));

        //index for unserstanding better  
        System.out.println(with_virtual_index(a, b, 0, 0));


        //DP top down
        // See if both the strings dont have anything in common . If we try to do with normal 
        // the time compexity will be very high so we fill the array with -1 and than do it

        int arr[][]= new int [a.length()][b.length()];

        for(int i=0;i<arr.length;i++)
        {
            Arrays.fill(arr[i],-1);
        }
        System.out.println( top_down(a, b, 0, 0, arr));


        
        // DP Bottom-up 
        bottom_up(a, b);


        bu_se(a, b);




    }

    public static int without_virtual_index(String a ,String b)
    {
        if(a.length()==0 || b.length()==0)
        return 0;

        if(a.charAt(0)==b.charAt(0))
        {
            int x=without_virtual_index(a.substring(1), b.substring(1));
            x++;
            return x;
        }
        else
        {
            int x=without_virtual_index(a,b.substring(1));
            int y=without_virtual_index(a.substring(1),b);
            
            return Math.max(x, y);
        }
    }
    

    public static int with_virtual_index(String a , String b , int vdx_1 , int vdx_2)
    {

        if(vdx_1==a.length() || vdx_2==b.length())
        {
            return 0; 
        }
        if(a.charAt(vdx_1)==b.charAt(vdx_2))
        {
            int x=with_virtual_index(a, b, vdx_1+1, vdx_2+1);
            x++;
            return x;
        }
        else
        {
            int x=with_virtual_index(a, b, vdx_1, vdx_2+1);
            int y=with_virtual_index(a, b, vdx_1+1, vdx_2);

            return Math.max(x, y);
        }
    }
    
    
    public static int top_down(String a ,String b , int vdx_1, int vdx_2 , int arr[][]) 
    {
        if(vdx_1==a.length() || vdx_2==b.length())
        {
            return 0; 
        }

        
        //reuse the values
        if(arr[vdx_1][vdx_2]!=-1) 
        {
            return arr[vdx_1][vdx_2] ; 
        }


        int count=0;
        if(a.charAt(vdx_1)==b.charAt(vdx_2))
        {
            count=top_down(a, b, vdx_1+1, vdx_2+1,arr);
            count++;

        }
        else
        {
            int x=top_down(a, b, vdx_1, vdx_2+1,arr);
            int y=top_down(a, b, vdx_1+1, vdx_2,arr);

            count= Math.max(x, y);
        }

        arr[vdx_1][vdx_2]=count;
        return count ; 
    }


    public static void bottom_up(String a ,String b)
    {

        int arr[][]=new int [a.length()+1][b.length()+1];


        for(int row=a.length()-1 ; row>=0;row--)
        {
            for(int col=b.length()-1 ;col>=0; col--)
            {
                if(a.charAt(row)==b.charAt(col))
                {
                    arr[row][col]=arr[row+1][col+1]+1;
                }
                else
                {
                    arr[row][col]=Math.max(arr[row][col+1] , arr[row+1][col]);
                }
            }
        }


        System.out.println(arr[0][0]);


    }


    public static void bu_se(String s_1 , String s_2){

        int arr[]=new int [s_2.length()+1];

        for(int row=s_1.length()-1;row>=0;row--)
        {
            int diag=0;
            for(int col=s_2.length()-1;col>=0;col--)
            {
                if(s_1.charAt(row)==s_2.charAt(col))
                {
                    int sum=diag+1;
                    diag=arr[col];
                    arr[col]=sum;
                }
                else
                {
                    int sum=Math.max(arr[col],arr[col+1]);
                    diag=arr[col];
                    arr[col]=sum;
                }
            }
        }
        System.out.println(arr[0]);
    }


} 
