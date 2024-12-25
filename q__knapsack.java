package DP;

import java.util.Arrays;

public class q__knapsack {
    public static void main(String[] args) {


        int [] weight = {1,3,4,5};
        int [] prices = {1,4,5,7};

        int tw=7;


        //recursion
        // System.out.println(recursion(weight, prices, 0, tw));

        //top_down 
        int storage[][]=new int [tw+1][weight.length];
        for(int i=0;i<storage.length;i++)
        {
            Arrays.fill(storage[i],-1);
        }
        System.out.println( top_down(weight, prices, tw, 0, storage));


        
        // bottom_up
        bottom_up(weight, prices, tw);
        
    }

    public static int recursion(int [] weight ,  int [] prices , int vdx , int rem_weight)
    {

        if(vdx==weight.length || rem_weight==0)
        {
            return 0;
        }

        int sum=0;
        if(rem_weight<weight[vdx])
        {
            //exclude call only
            sum=recursion(weight, prices, vdx+1, rem_weight);
        }
        else
        {
            // include call
            int x= recursion(weight, prices, vdx+1, rem_weight-weight[vdx])+ prices[vdx];


            //exclude call 
            int y=recursion(weight, prices, vdx+1, rem_weight);

            sum=Math.max(x, y);
        }
        return sum ;
    }

    public static int top_down(int [] weight , int prices [] , int rem_weight , int vdx , int [][] storage)
    {

        if(vdx==weight.length || rem_weight==0)
        {
            return 0 ; 
        }

        if(storage[rem_weight][vdx]!=-1)
        {
            return storage[rem_weight][vdx];
        }

        int sum=0;
        if(rem_weight<weight[vdx])
        {
            sum=top_down(weight, prices, rem_weight, vdx+1, storage);
        }
        else{

            // iclude

           int x= top_down(weight, prices, rem_weight-weight[vdx], vdx+1, storage)+prices[vdx];

           int y=top_down(weight, prices, rem_weight, vdx+1, storage);


           sum=Math.max(x, y);

        }

        storage[rem_weight][vdx]=sum;
        return sum; 
    }

    public static void bottom_up(int [] weight , int price[] , int total_capcity)
    {

        int storage [] [] = new int [weight.length+1][total_capcity+1];


        for(int row=weight.length-1 ; row>=0 ; row--)
        {
            for(int col=1;col<=total_capcity;col++)
            {
                int sum=0;
                if(weight[row]>col)
                {
                    sum=storage[row+1][col];
                }
                else
                {
                    int I=storage[row+1][col-weight[row]]+price[row];
                    int E=storage[row+1][col];

                   sum= Math.max(I, E);

                }
                storage[row][col]=sum;
            }
        }

        System.out.println(storage[0][total_capcity]);
    }
}

