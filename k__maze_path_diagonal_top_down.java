package DP;

public class k__maze_path_diagonal_top_down {

    public static void main(String[] args) {

        System.out.println(recursion(new int [3][3] , 0, 0));

    }

    public static int recursion(int arr[][] , int row, int col)
    {
        if(col==arr[0].length || row==arr.length)
        {
            return 0; 
        }
        
        if(row==arr.length-1 && col==arr[0].length-1)
        {
            return 1;
        }


        if(arr[row][col]!=0)
        {
            return arr[row][col];
        }

        int h=recursion(arr, row, col+1);
        int d=recursion(arr, row+1, col+1);
        int v=recursion(arr, row+1, col);

        arr[row][col]=h+d+v;
        return h+d+v;
    }
    
}
