import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseDBManager implements CourseDBManagerInterface{
	
	private CourseDBStructure structure;
	
	public CourseDBManager()
	{
		structure = new CourseDBStructure(10);
	}

	/*
	 * This method adds a CourseDBElement to the data structure
	 * @param id - course id
	 * @param crn - course number
	 * @param credits - number of credits
	 * @param roomNum - room number
	 * @param instructor - name of instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) 
	{
		CourseDBElement ele;
		ele = new CourseDBElement(id, crn, credits, roomNum, instructor);
		structure.add(ele);
	}

	/*
	 * This method gets the CDE element
	 * @param crn - course number
	 */
	@Override
	public CourseDBElement get(int crn) 
	{
		try 
		{
			return structure.get(crn);
		}
		catch(IOException ex)
		{
			System.out.println("Exception was thrown from manager get method");
			ex.getMessage();
		}
		return null;
	}

	/*
	 * This method converts line to a text file
	 * @param input - file to read from
	 * @exception FileNotFoundException - thrown if the file is not found
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException 
	{
		List<String[]> ls;
		InputStream i;
		BufferedReader b;
		
		i = new FileInputStream(input);
		b = new BufferedReader(new InputStreamReader(i));
		ls = b.lines().map(s -> s.split(" ")).collect(Collectors.toList());

		for(String[] x : ls)
		{
			if(x.length > 5)
			{
				StringBuilder sb = new StringBuilder();
				for(int count = 4; count < x.length; count++)
				{
					sb.append(x[count] + " ");
				}
				structure.add(new CourseDBElement(x[0], Integer.valueOf(x[1]), Integer.valueOf(x[2]), x[3], sb.toString().trim()));
			}
			else
			{
				structure.add(new CourseDBElement(x[0], Integer.valueOf(x[1]), Integer.valueOf(x[2]), x[3], x[4]));
			}
		}
	}

	/*
	 * This method traverse the data structure and returns all the elements in an arraylist
	 * @returns ArrayList representation of the data structure
	 */
	@Override
	public ArrayList<String> showAll() 
	{ 
		ArrayList<CourseDBElement> x;
		x = new ArrayList<>();
		ArrayList<String> arrayList;
		
		for(int count = 0; count < structure.getTableSize(); count++)
		{
			if(structure.hashTable[count] != null)
			{
				x.addAll(structure.hashTable[count]);
			}
		}
		
		arrayList =(ArrayList<String>) x.stream().map(s -> s.toString()).collect(Collectors.toList());
		return arrayList;
	}


}
