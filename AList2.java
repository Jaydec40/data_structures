public class AList2<T> implements ListInterface<T> {

    private T[] L;
    private int count;

    public AList() {
        this(20);
    }

    public AList(int p) {
        L = (T[]) new Object[p];
        count = 0;
    }

	//add an item at the end of the list:
	public void add (T item) throws ListException
	{
		if(item==null)
		throw new ListException("Cannot add. Nulls not allowed");

		if (count == L.length)
			resize();

		L[count] = item;
		count++;
	}

	public T delete(int pos) throws ListException
	{
		if(count==0)  //The list is empty!
			throw new ListException("Cannot delete. List is empty.");

		if ( pos < 1 || pos > count )
			throw new ListException("Cannot delete. Bad Position.");

		T temp = L[pos-1];
		for( int k = pos; k <= count-1; k++)
			L[k-1]=L[k];

		count--;

		return temp;

	}

	public void resize()
	{
		T[] temp;
		//Step1: Make a larger array
		temp= (T[])new Object[L.length+25];

		//Step 2: copy everything from the older (smaller)
		//array into the newer larger array:
		for(int k = 0; k<L.length;k++)
		temp[k]= L[k];

		//get rid the older (smaller) array
		L= temp;
	}





	public void insert(int pos,T item) throws ListException
	{

			if (item == null)
			throw new ListException("Cannot insert. Nulls not allowed.");


			if (pos<1 || pos>count)
				 throw new ListException("Cannot insert. Bad position");

			if (L.length == count)
				resize();

			int k = count -1;

			while(k>=pos-1)
			{
				L[k+1]=L[k];
				k--;
			}

			L[pos-1]=item;
			count++;
	}

	public String toString()
	{
		if (count == 0 )
			return "(List is empty.)";

		String temp="\n";
		int k;
		for ( k = 0 ; k < count ; k++ )
			temp += L[k] + "\n";

		return temp;

	}



}