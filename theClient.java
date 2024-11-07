public class theClient
{
	public static void main(String[] args)
	{

	    try
	    {
		//Build the list:
		AList<House> hlist = new AList<House>(10);
		hlist.add(new House("31 main street", 500000));
		System.out.println("House added at 31 mainstreet" + (hlist.size)/2 + "costing $500k.");
		System.out.println("The current list is: " + hlist + "\n\n");

		hlist.add(new House("68 Grove Ave.", 700000));
		System.out.println("House added at 68 Grove Ave.," + (hlist.size)/2 + " costing $700k.");
		System.out.println("The current list is: " + hlist + "\n\n");

		hlist.add(new House("9 Cruch Ave..", 300000));
		System.out.println("House added at 9 Cruch Ave.," + (hlist.size)/2 + " costing $78K.");
		System.out.println("The current list is: " + hlist + "\n\n");






		}
		catch(ListException e)
		{
		}
} //end of main

} //end of class