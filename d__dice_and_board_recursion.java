package DP;

public class d__dice_and_board_recursion {

    public static void main(String[] args) {

        
        System.out.println(fun(0,10));
        
    }

    public static int fun(int curr, int target)
    {

        if(curr==target)
        {
            return 1;
        }
        if( curr>target)
        {
            return 0;
        }

        int count=0;  // for making a local variable for each functoin frame

        for(int i=1;i<=6;i++)
        {
            count=count+fun(curr+i ,target);
        }

        return count; // so that the previous (calling) function get that the current function has this many ways to reach to the target
    }
    
}
