package DP;

public class n__make_strings_equal {

    public static void main(String[] args) {


        String a="execution";
        String b="intention";



        // RECURSION 
        // System.out.println(recursion(a, b));

        // RECURSION WITH VIRTUAL INDEX
        // System.out.println(recursion_with_vdx(a, b, 0, 0));


        // TOP - DOWN 
        int arr[][]=new int [a.length()][b.length()];
        System.out.println(top_down(a, b, 0, 0, arr));



        //Bottom -up 
        bottom_up(a, b);


        // BU space eficeint time= o(n^2) space= o(n)
        bu_se(a, b);






    }

    public static int recursion(String a, String b)
    {


        if(a.length()==0 || b.length()==0)
        {
            return Math.max(a.length(), b.length());

        }


        int count=0;
        if(a.charAt(0)==b.charAt(0))
        {
            count=recursion(a.substring(1), b.substring(1));
        }
        else
        {
            int i=recursion(a.substring(1), b);
            int d=recursion(a, b.substring(1));
            int r=recursion(a.substring(1), b.substring(1));


            count=Math.min(i ,Math.min(d,r))+1;
        }

        return count ;
    }
    
    public static int recursion_with_vdx(String a ,String b , int vdx_1 , int vdx_2)
    {


        if(vdx_1==a.length() || vdx_2==b.length())
        {
            return Math.max(a.length()-vdx_1 , b.length()-vdx_2);
        }


        int count=0;

        if(a.charAt(vdx_1)==b.charAt(vdx_2))
        {
            count=recursion_with_vdx(a, b, vdx_1+1, vdx_2+1);
        }
        else
        {
            int i=recursion_with_vdx(a, b, vdx_1+1, vdx_2);
            int d=recursion_with_vdx(a, b, vdx_1, vdx_2+1);
            int r=recursion_with_vdx(a, b, vdx_1+1, vdx_2+1);


            count=Math.min(i, Math.min(d, r))+1;
        }


        return count;

    }

    public static int top_down(String a , String b, int vdx_1 , int vdx_2 , int arr[][])
    {

        if(vdx_1==a.length() || vdx_2==b.length())
        {
            return Math.max(a.length()-vdx_1 , b.length()-vdx_2);
        }

        if(arr[vdx_1][vdx_2]!=0)
        {
            return arr[vdx_1][vdx_2];
        }

        int count=0;
        if(a.charAt(vdx_1)==b.charAt(vdx_2))
        {
            count=top_down(a, b, vdx_1+1, vdx_2+1, arr);
        }
        else{

            int i=top_down(a, b, vdx_1+1, vdx_2, arr);
            int d=top_down(a, b, vdx_1, vdx_2+1, arr);
            int r=top_down(a, b, vdx_1+1, vdx_2+1, arr);

            count= Math.min(i, Math.min(d,r))+1;
        }

        arr[vdx_1][vdx_2]=count;
        return count;
    }

    public static void bottom_up(String a ,String b)
    {
        int arr[][]=new int [a.length()+1][b.length()+1];


        // Filling the base cases
        for(int col=0;col<=b.length();col++)
        {
            arr[a.length()][col]=b.length()-col;
        }
        for(int row=0;row<=a.length();row++)
        {
            arr[row][b.length()]=a.length()-row;
        }


        for(int row=a.length()-1;row>=0 ;row--)
        {
            for(int col=b.length()-1;col>=0 ; col--)
            {
                if(a.charAt(row)!=b.charAt(col))
                {
                    arr[row][col]=Math.min(arr[row][col+1] , Math.min( arr[row+1][col] ,arr[row+1][col+1] ) ) + 1 ;
                }
                else
                {
                    arr[row][col]=arr[row+1][col+1];
                }
            }
        }

        System.out.println(arr[0][0]);

        /* for displaying the array after the updation we have done in BU */

        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=0;j<arr[0].length-1;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void bu_se(String s_1 ,String s_2 )
    {
        int arr[]=new int [s_2.length()+1];

        for(int i=0;i<arr.length-1;i++)
        {
            arr[i]=s_2.length()-i;
        }


        for(int row=s_1.length()-1;row>=0;row--)
        {
            int diag=arr[arr.length-1];

            arr[arr.length-1]=s_1.length()-row;


            for(int col=s_2.length()-1;col>=0; col--)
            {

                if(s_1.charAt(row)==s_2.charAt(col))
                {
                    int temp=arr[col];
                    arr[col]=diag;
                    diag=temp;

                }
                else
                {
                    int sum=Math.min(Math.min(arr[col],arr[col+1]) , diag)+1;

                    diag=arr[col];
                    arr[col]=sum;
                }

            }
        }


        System.out.println(arr[0]);

        
    }


    
}
