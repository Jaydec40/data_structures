public class AList<T> implements ListInterface<T>
{
   private T[]L;
   private int count;
   
   //constructor
   public AList(int p)
   {
      L=(T[])new Object[p]
      count = 0;
      
     }
     
     public void add(T item) throws ListException
     {
         if(item==null)
         throws new ListException("cannot add, nulls arent allowed!");
         
         if (count == 
         
         
         ///
         
         public void delete() throws ListException
         {
         if(count==0)
         throws ListException("cannot delete nothing!");
         if (pos< 1|| pos>count)
          throw new ListException("cannot delete bad positioning");
         
         T temp = L[pos-1];
         for(int k= pos; k<= count-1; k++)
            L[k-1] = L[k];
            
          count--;
          
          return temp;
          
          }
          
          public void resize()
          {
          T[] temp;
          temp=(T[])new object[L.length + 25];
          
          for(int k=0; k<L.length; k++)
          
         
         
      