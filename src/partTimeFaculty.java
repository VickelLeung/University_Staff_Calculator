//==========================================================================================
// Assignment #4
// Part: 1
// Written by: Vickel Leung, 40005344
//==========================================================================================


package A;

public class partTimeFaculty extends Employees {


	//Hourly Rate, Number of Hours of Current Term, and Number of Student in Class
	private double hourRate;
	private int numHours;
	private int numOfStudents;
	
	
	public partTimeFaculty()
	{
	
		super();
		hourRate = 0;
		numHours = 0;
		numOfStudents = 0;
	}
	
	public partTimeFaculty(long e, String fn, String famN, String cr, int hy, double hr, int nh, int ns)
	{
		super( e, fn, famN, cr, hy);
		hourRate = hr;
		numHours = nh;
		numOfStudents = ns;
		
	}
	
	public void setHourRate(double hr){
		hourRate = hr;
	}
	
	public void setNumHours(int nh){
		numHours = nh;
	}
	
	public void setNumOfStudents(int ns){
		numOfStudents = ns;
	}
	
	
	public double getHourRate(){
		return hourRate;
	}
	
	public int getNumHours(){
		return numHours;
	}
	
	public int getNumOfStudents(){
		return numOfStudents;
	}
	
	
	public String toString(){
		
		return super.toString() + "\t" + hourRate + "\t" + numHours + "\t" + numOfStudents;  
	}
	
	
}
