package DP;

public class e__dice_and_board_top_down {

    public static void main(String[] args) {

        System.out.println(fun(0,3,new int [3]));
        
    }

    public static int fun(int curr , int target , int [] arr)
    {

        if(curr==target)
        {
            return 1;
        }
        if(curr>target)
        {
            return 0;
        }

        if(arr[curr]!=0)
        {
            return arr[curr];
        }


        int count=0;

        for(int i=1;i<=6;i++)
        {
            count=count+ fun(curr+i , target,arr);
        }

        arr[curr]=count ;
        return  count ;
    }
    
}
