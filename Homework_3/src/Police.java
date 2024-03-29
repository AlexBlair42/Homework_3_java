public class Police extends Person implements Employee {
	/**
	 * @author Alex Blair
	 * Police are a type of person and they also are employees.
	 * There are many different roles that police have.
	 * They are listed in an enumeration
	 */
	// Police can have many different roles
	public enum Role{Patrol, Sargent, Captain, Chief}
	private Role role;
	int money = 0;
	
	/**
	 * This is the constructor for the "Police" object. It has the following parameters.
	 * @param n name
	 * @param a age
	 * @param p Phone_Num
	 * @param r Role
	 */
	public Police(String n, int a, long p, Role r)
	{
		super(n,a,p);
		role = r;
	}

	/**
	 * These are the functions that implement Employee
	 */
	public void getPaid(int m) 
	{
		money+= m;
	}

	public long reqId()
	{
		return ID;
	}

}