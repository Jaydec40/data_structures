public class ListException extends Exception
{
	private String message;

	public ListException( String m )
	{
		message=m;
	}

	public String toString()
	{
		return message;
	}
}