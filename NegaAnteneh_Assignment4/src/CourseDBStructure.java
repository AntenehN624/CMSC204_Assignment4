import java.io.IOException;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	protected LinkedList<CourseDBElement>[] hashTable;
	
	/*
	 * Constructor
	 */
	public CourseDBStructure(String str, int i)
	{
		hashTable = new LinkedList[i];
	}
	
	/*
	 * Constructor
	 */
	public CourseDBStructure(int i)
	{
		hashTable = new LinkedList[i];
	}

	/*
	 * This method will add elements to the data structure
	 * @param add - element being added
	 */
	@Override
	public void add(CourseDBElement element) 
	{
		int c;
		c = getHashIndex(element);

	    if (hashTable[c] == null) 
	    {
	    	hashTable[c] = new LinkedList<CourseDBElement>();
	    	hashTable[c].add(element);
	    } 
	    else 
	    {
	    	if (hashTable[c].contains(element))
	    	{
	    		return;
	    	}
	    	else
	    	{
	    		hashTable[c].add(element);
	    	}
	    }
	}
	
	/*
	 * Retrieves element from data structure
	 * @param crn - course number
	 * @returns the element
	 * @exception IOException - if the element is not found in the data structure
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException 
	{
		CourseDBElement t;
		t = new CourseDBElement();
		
		t.setCRN(crn);
		int x = getHashIndex(t);
		LinkedList<CourseDBElement> linked;
		linked = hashTable[x];
		
	    return linked.stream().filter(c -> c.getCRN() == crn).findAny().orElseThrow(IOException::new);
	}

	/*
	 * This method gets the size of the table
	 * @returns size of table
	 */
	@Override
	public int getTableSize() 
	{
		return hashTable.length;
	}
	
	/*
	 * This method gets the hash index of a specific entry
	 * @param ele entry
	 * @returns entries hash index
	 */
	public int getHashIndex(CourseDBElement ele)
	{
		int hashI;
		hashI = ele.hashCode() % hashTable.length;
		if(hashI < 0)
		{
			hashI = hashI + hashTable.length;
		}
		return hashI;
	}

}
