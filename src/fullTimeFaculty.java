//==========================================================================================
// Assignment #4
// Part: 1
// Written by: Vickel Leung, 40005344
//==========================================================================================


package A;

public class fullTimeFaculty extends Employees {

	private int salary;
	
	public fullTimeFaculty() {
		super();
		salary = 0;
	}

	public fullTimeFaculty(long e, String fn, String famN, String cr, int hy, int salary) {
		super(e, fn, famN, cr, hy);
		this.salary = salary;
		
	}
	
	public int getSalary(){
		return salary;
	}
	public void setSalary(int salary){
		this.salary = salary;
	}
	
	public String toString(){
		
		return super.toString() + "\t" + salary;
		
	}
	
	
}
