//==========================================================================================
// Assignment #4
// Part: 1
// Written by: Vickel Leung, 40005344
//==========================================================================================


package A;

public class Employees implements Ordered{
	
	private long employeeId;
	private String firstName;
	private String familyName;
	private String cityOfRes;
	private int hireYear;
	
	public Employees(){
		
		employeeId = 0;
		firstName = null;
		familyName = null;
		cityOfRes = null;
		hireYear = 0;
		
	}
	
	public Employees(long e, String fn, String famN, String cr, int hy)
	{
		employeeId = e;
		firstName = fn;
		familyName = famN;
		cityOfRes = cr;
		hireYear = hy;
		
	}
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		employeeId = employeeId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFamilyName(){
		return familyName;
	}
	public void setFamilyName(String familyName){
		this.familyName = familyName;
	}
	
	public String getCityOfRes() {
		return cityOfRes;
	}
	public void setCityOfRes(String cityOfRes) {
		this.cityOfRes = cityOfRes;
	}
	
	public int getHireYear() {
		return hireYear;
	}
	public void setHireYear(int hireYear) {
		this.hireYear = hireYear;
	}

	
public String toString(){
		
		if(cityOfRes.length() >= 8){
			return employeeId + "\t" + firstName + "\t" + familyName + "\t\t" 
					+ cityOfRes +  "\t" + hireYear;
		}
	
		return employeeId + "\t" + firstName + "\t" + familyName + "\t\t" 
		+ cityOfRes +  "\t\t" + hireYear;
		
	}


public boolean precedes(Employees a) {
	
	
	if(a.hireYear > this.hireYear)
		return true;
	
	return false;
}



public boolean follows(Employees a) {
	
	if(a.hireYear < this.hireYear)
	return true;
	
	return false;
}
	
	

}
