public class Recursionvsiteration
{
   public static void main(String[]args)
   {  
   int k;
   
      k = sum1( 100 );
      System.out.println("after calling the iterative method:" + k);
      
      k = sum2( 100 );
      System.out.println("after callng the recursive method" + k);
   }
   
   public static int sum1(int n )
 
  {
      int total = 0;
      int k;
         for(k=1; k<=n; k++)
            {
               total+= k;
            }
            
       return total;
    
   }
   
   
   //iternative method
   public static int sum2(int n )
   {
      int total = 0;
      int k;
         if(n != 0)
             return n+sum2(n-1);
         else 
            return 0;
    }
   }
