
public class CourseDBElement implements Comparable{
	
	//Attributes
	String courseID;
	int CRN;
	int credits;
	String roomNumber;
	String instructor;
	
	/*
	 * Constructor
	 */
	public CourseDBElement(String courseID, int CRN, int credits, String roomNumber, String instructor)
	{
		this.courseID = courseID;
		this.CRN = CRN;
		this.credits = credits;
		this.roomNumber = roomNumber;
		this.instructor = instructor;
	}
	
	/*
	 * No argument constructor
	 */
	public CourseDBElement()
	{
		courseID = null;
		CRN = 0;
		credits = 0;
		roomNumber = null;
		instructor = null;
	}
	
	/*
	 * This methods returns the courseID
	 * @returns the courseID
	 */
	public String getCourseID()
	{
		return courseID;
	}
	
	/*
	 * This methods returns the CRN
	 * @returns the CRN
	 */
	public int getCRN()
	{
		return CRN;
	}
	
	/*
	 * This methods returns the credits
	 * @returns the credits
	 */
	public int getCredits()
	{
		return credits;
	}
	
	/*
	 * This methods returns the room number
	 * @returns the room number
	 */
	public String getRoomNumber()
	{
		return roomNumber;
	}
	
	/*
	 * This methods returns the instructor
	 * @returns the instructor
	 */
	public String getInstructor()
	{
		return instructor;
	}
	
	/*
	 * This method sets the value of courseID
	 * @param courseID - this is the value that is being used to set courseID
	 */
	public void setCourseID(String courseID)
	{
		this.courseID = courseID;
	}
	
	/*
	 * This method sets the value of CRN
	 * @param CRN - this is the value that is being used to set CRN
	 */
	public void setCRN(int CRN)
	{
		this.CRN = CRN;
	}
	
	/*
	 * This method sets the value of credits
	 * @param credits - this is the value that is being used to set credits
	 */
	public void setCredits(int credits)
	{
		this.credits = credits;
	}
	
	/*
	 * This method sets the value of room number
	 * @param roomNumber - this is the value that is being used to set room number
	 */
	public void setRoomNumber(String roomNumber)
	{
		this.roomNumber = roomNumber;
	}
	
	/*
	 * This method sets the value of instructor
	 * @param instructor - this is the value that is being used to set instructor
	 */
	public void setInstructor(String instructor)
	{
		this.instructor = instructor;
	}

	public int hashCode()
	{
		int a = 31;
		int b = 0;
		int hash = 0;
		String str = String.valueOf(getCRN());
		for(int i = 0; i < str.length(); i++)
		{
			hash = a * hash + str.charAt(i);
		}
		return hash;
	}
	
	/*
	 * This method will return the CourseDBElement attributes as a String
	 * @returns a string representation of CoruseDBElement
	 */
	public String toString()
	{
		return ("\nCourse:" + getCourseID() + " CRN:" + getCRN() + " Credits:" + getCredits() + " Instructor:" + getInstructor() + " Room:" + getRoomNumber()); 
	}
	
	/*
	 * This method compares two objects
	 * @param ele this is the object that is being compared
	 * @returns either 1,0, or -1 depending on the results of the comparison
	 */
	@Override
	public int compareTo(CourseDBElement ele) 
	{
		int i = Integer.compare(this.CRN, ele.getCRN());
		return i;
	}	
	
	/*
	 * This methods checks to see if the CRN is equal
	 * @param o - this is the object
	 * returns true if equal
	 */
	public boolean equals(Object o)
	{
		
		if(o == this)
		{
			return true;
		}
		
		if(o == null)
		{
			return false;
		}
		
		if(!(o instanceof CourseDBElement))
		{
			return false;
		}
		
		CourseDBElement c = (CourseDBElement) o;
		return this.getCRN() == c.getCRN();
	}
}
