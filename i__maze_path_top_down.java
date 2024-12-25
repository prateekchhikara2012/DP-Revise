package DP;

public class i__maze_path_top_down {


    public static void main(String[] args) {

       System.out.println( fun(0,0,15,15,new int [16][16]));
        
    }

    public static int fun(int cc, int cr , int er, int ec , int arr[][])
    {

        // +ve bcase
        if(cr==er && cc==ec)
        {
            return 1; 
        }

        // -ve bcase
        if(cr>er || cc>ec)
        {
            return 0;
        }


        // DP conditon to check for the repeation
        if(arr[cr][cc]!=0)
        {
            return arr[cr][cc];
        }

        int x= fun(cc+1 , cr , er, ec , arr);
        int y= fun(cc, cr+1, er ,ec ,arr);

        int sum=x+y;

        // for the updatoin 
        arr[cr][cc]=sum;

        return sum;
    }
    
}
