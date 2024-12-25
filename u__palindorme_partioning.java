package DP;

import java.util.Arrays;

public class u__palindorme_partioning {

    public static void main(String[] args) {
        
        String str="aaasddkjnaffdhjgbjhdfbghjabdfjhbadjhhfasdh fjhsdjfhruegferytbehcuruetjn jkgtinth eh rnffjsndfkjasansdnfhrae cruruentbltu ub the the andkjdsjafbjhdsbfhjbsdhjfbjashdbfmnsabdfnmbsadnmfbsdnfvsfs fjdfhdjhhhhhhhhhhhhhhhhhhhhhhhhhhsdhhfhdhfhhshhdnkfajnsjkldndsksdnkjdsafjkbsd  hfjhsdfkj s f s fkj sfjks fsf jdsjhkfhjkshdfkj asdjkfhasjkd fs df s df sldfjfahkdshfkjdsfkjahsfjkdshfiuerqhtiuehruikjasdfnjkdnfjakdnjkasdfhlsahjfsldhfkjhs kjshjkh sjkfh skj hkjfh jksd hjks jks j h jdksfhkjshfiuhetiuhertuihruithkdjhtjkehrtjehehe cururent scarui isu ote otell met aght aiam th e new and the curuent ly inthe sotuher america whiuchg ius not at all good thing inthe above disxussd apaper that ait sthe the the new and the currebntly setting in the north america areawhicihus very habital and the currentlu my nmames ir aptaeek chhiakaaa and iam th estudentfoof thw bahbhati My name isr apMy namr My My name is prayeek cjhiiakra nadi th enew My name is rateek chikar andi amthe student of the aaadfgadfsdmnn";


       // System.out.println( top_down(str, 0, str.length()-1, new int [str.length()][str.length()] ));

        System.out.println(bottom_up(str));

    }

    public static int recrusion(String str , int si , int ei)
    {

        if(si==ei)
        return 0;

        if(check(str, si, ei))
        {
            return 0 ;
        }

        int min=Integer.MAX_VALUE;
        for(int k=si ; k<ei ; k++)
        {
            int x=recrusion(str, si, k);
            int y=recrusion(str, k+1, ei);

            int sum=x+y+ 1 ;

            if(sum<min)
            {
                min=sum;
            }
        }

        return min;
    }

    public static int top_down(String str, int si ,int ei , int [][] strg)
    {
 
        if(si==ei)
        {
            return 0 ;
        }
        if(strg[si][ei]!=0)
        {
            return strg[si][ei];
        }
        if(check(str, si, ei))
        {
            return 0;
        }



        int min=Integer.MAX_VALUE;
        for(int k=si;k<ei ;k++)
        {
            int x=top_down(str, si, k, strg);
            int y=top_down(str, k+1, ei, strg);

            int sum=x+y+1;

            if(sum<min)
            {
                min=sum;
            }
        }

        strg[si][ei]=min;

        return min;


    }

    public static boolean check(String str, int si , int ei)
    {
        int i=si ,j=ei;

        while(i<j)
        {
            if(str.charAt(i) == str.charAt(j));
            else
            {
                return false ; 
            }

            i++;
            j--;
        }
        return true ;
    }



    public static int bottom_up(String str)
    {
        boolean [][] arr=new boolean[str.length()][str.length()];
        for(int i=0;i<arr.length;i++)
        {
            Arrays.fill(arr[i],true);
        }

        
        for(int row=arr.length-2 ;row>=0 ;row--)
        {
           
            for(int col=row+1; col<arr.length; col++)
            {
                
                if(str.charAt(row)==str.charAt(col))
                {
                    arr[row][col]=arr[row+1][col-1];
                }
                else
                {
                    arr[row][col]=false;
                }
            }
        }




        int [][] strg=new int [str.length()][str.length()];


        for(int slide=1;slide<str.length() ;slide++)
        {
            for(int si= 0 ,ei=slide ; si<str.length() && ei<str.length() ; si++ ,ei++ )
            {



                if(arr[si][ei])
                {
                    strg[si][ei]=0;

                }
                else
                {

                    int min=Integer.MAX_VALUE;

                    for(int k=si;k<ei;k++)
                    {
                        int x=strg[si][k];
                        int y=strg[k+1][ei];

                        int sum=x+y+1;

                        if(sum<min)
                        {
                            min=sum;
                        }
                    }

                    strg[si][ei]=min;
                }
                


            }

        }

        return strg[0][str.length()-1];
    }

}
