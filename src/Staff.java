//==========================================================================================
// Assignment #4
// Part: 1
// Written by: Vickel Leung, 40005344
//==========================================================================================


package A;

public class Staff extends Employees {

	private int salary;
	private char performance;
	
	// default constructor
	public Staff(){
		
		super();
		salary = 0;
		performance = ' ';
	}
	
	// parameterized constructor
	public Staff(long e, String fn, String famN, String cr, int hy, int s, char p ){
		
		super(e, fn, famN, cr, hy);
		salary = s;
		performance = p;
	}
	
	//mutators
	public void setSalary(int s){
		salary = s;
	}
	
	public void setPerformance(char p){
		performance = p;
	}
	

	//accessors
	public int getSalary(){
		return salary;
	}
	
	public char getPerformance(){
		return performance;
	}
	
	public String toString(){
		
		return super.toString() + "\t" + salary + "\t" + performance;
	}
	
}
