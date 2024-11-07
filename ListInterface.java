public interface ListInterface<T>
{
	public void add(T item)throws ListException;
	public void insert(int pos, T item) throws ListException;
	public T delete(int pos) throws ListException;
}


