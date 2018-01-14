//==========================================================================================
// Assignment #4
// Part: 1
// Written by: Vickel Leung, 40005344
//==========================================================================================


package A;

public class Ta extends Employees{
	
	private String type;
	private int numOfClass;
	private int totalHours;

	public Ta(){
		super();
		type = null;
		numOfClass = 0;
		totalHours = 0;
	}
	
	public Ta(long e, String fn, String famN, String cr, int hy, String t, int nc, int th){
		
		super(e, fn, famN, cr, hy);
		type = t;
		numOfClass = nc;
		totalHours = th;
		
	}
	
	//mutators
	
	public void SetType(String t){
		type = t;
	}
	
	public void setNumOfClass(int nc){
		numOfClass = nc;
	}
	
	public void setTotalHours(int th){
		totalHours = th;
	}
	
	
	//accessors
	
	public String getType(){
		return type;
	}

	public int getNumOfClass(){
		return numOfClass;
	}
	
	public int getTotalHours(){
		return totalHours;
	}
	
	public String toString(){
		
		return super.toString() + "\t" + type + "\t" + numOfClass + "\t" + totalHours;
	}
	
}
