package DP;



public class s__rod_cutting {


    public static void main(String[] args) {

        int arr[]={0,1,5,8,9,10,17,5435,43,54,36,134,1,45,43,51,346,5,346,54,61,5461,354,6,34,5,345,13,46,54,6,4516,134,56,43,5,3,17,20};


        long star=System.currentTimeMillis();


        //    DP BY NORMAL METHORD NOT BY GOLU METHORD  
         System.out.println(normal(arr.length-1, arr, new int [arr.length]));





        // recursion
       // System.out.println(   recursion(arr.length-1, arr)     );


        //  top_down
        //System.out.println(     top_down(arr, arr.length-1, new int [arr.length])      );


        // bottom_up
         bottom_up(arr);

        
        long end=System.currentTimeMillis();
       System.out.println(end-star);
    }





    public static int normal(int rem ,int arr[] ,int [] strg)
    {
        if(rem==0)
        {
            return 0;
        }
        if(strg[rem]!=0)
        {
            return strg[rem];
        }

        int max=Integer.MIN_VALUE;
        for(int i=1;i<=rem; i++)
        {
          int x=  normal(rem-i, arr,strg) + arr[i];
          if(x>max)
          {
            max=x;
          }
        }

        max=Math.max(arr[rem] , max);


        strg[rem]=max;

        return max;
    }








    

    public static int recursion(int num , int arr[])
    {

        int left=1;
        int right=num-1;

        int max=Integer.MIN_VALUE;
        // you can put max value as the current price value also but remove the 40 line......you can see in the top down code

        while(left<=right)
        {


            int x=recursion(left,arr);
            int y=recursion(right,arr);

            int sum=x+y;

            if(sum>max)
            {
                max=sum;
            }

            left++ ;
            right--; 
        }

        if(arr[num]>max)
        {
            max=arr[num];
        }

        return max;

    }


    public static int top_down(int prices [] , int num , int [] storage)
    {

        int max=prices[num];
        if(num==1)
        {
            return 1;
        }
        if(storage[num]!=0)
        {
            return storage[num];
        }

        int i=1;
        int j=num-1;

        while(i<=j)
        {

            int x=top_down(prices, i, storage);
            int y=top_down(prices, j, storage);

            int sum=x+y;    


            if(sum>max)
            {
                max=sum;
            }

            i++;
            j--;
        }

        storage[num]=max;

        return max;

    }

    public static void bottom_up(int [] prices)
    {
        int [] storage=new int [prices.length];


        for(int i=2;i<storage.length;i++)
        {
            int j=1;
            int k=i-1;
            int max=prices[i];

            while(j<=k)
            {
                int x=storage[j];
                int y=storage[k];

                int sum=x+y;

                if(sum>max)
                {
                    max=sum;
                }


                j++;
                k--;
            }

            storage[i]=max;
        }
        System.out.println(storage[storage.length-1]);

    }
    
}

