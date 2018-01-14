//==========================================================================================
// Assignment #4
// Part: 1
// Written by: Vickel Leung, 40005344
//==========================================================================================

package A;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import A.listOfLinks.Node;


public class paymentSystem {
	
	//private helper method that read only employeeId and store into arrayList
	private static ArrayList<Long> readAndGiveEmployeeId(Scanner sc){
		
		ArrayList<Long> a1 = new ArrayList<Long>();
		Long employeeId;
		while(sc.hasNextLine()){
			
			employeeId = sc.nextLong();
			
			//get rid of all un-used information
			sc.nextLine();
			
			//add employeeId into arrayList
			a1.add(employeeId);
			}
		
		return a1;
	}
	
	// helper method to check if the employeeId is a duplicate, if true ask user to re-enter
	private static void checkForIdDuplicate(ArrayList<Long> a, Long id){
		Scanner kb = new Scanner(System.in);
		//check if employee id is already used, if it is then re-ask user to input
		while(a.contains(id)){
				System.out.print("please enter your Employee id again: ");
				id = kb.nextLong();
		}
		
	}
	
	//=====================================PART1 - 1 =======================================================
	
	// add records for full time employee
	public static void addFTRecords(Scanner scan, PrintWriter pw)
	{
		
		Scanner kb = new Scanner(System.in);
		
		// create arrayList to store id of employee
		ArrayList<Long> a1 = new ArrayList<Long>();
		
		// create new array list to store the new information from user
		ArrayList<fullTimeFaculty>userInfo = new ArrayList<fullTimeFaculty>();
		
		// declare variables
		long employeeId;
		String firstName;
		String familyName;
		String cityRes;
		int salary;
		int hireYear;
		
		boolean continuation = true;
		
		System.out.println("Executing program to read from full-time...");
		
		// read file and add all employee id to ArrayList
		a1 = readAndGiveEmployeeId(scan);
		
		System.out.println("Would you like to add a new entry?");
		System.out.println("If you wish to quit please Enter [-1] else press any key");
		
		String userInput = kb.next();
		if(userInput.equals("-1"))
			continuation = false;
		
		while(continuation){
		//prompt user to enter a new record
		System.out.println("We will now proceed to add a new record.");
		
		System.out.print("please enter your Employee id: ");
		employeeId = kb.nextInt();
		
		//check if employee id is already used, if it is then re-ask user to input
		checkForIdDuplicate(a1, employeeId);

		System.out.print("please enter your first name: ");
		firstName = kb.next();
		
		System.out.print("Please enter your last name: ");
		familyName = kb.next();
			
		System.out.print("Please enter you city of residence: ");
		cityRes = kb.next();
		
		System.out.print("Please enter your hire year: ");
		hireYear = kb.nextInt();

		System.out.print("Please enter your salary: ");
		salary = kb.nextInt();
	
		// add employee id into the arrayList to keep track if it has been entered before
		a1.add(employeeId);
		
		// create object of employee to add into array list
		fullTimeFaculty userEntry = new 
				fullTimeFaculty(employeeId, firstName, familyName, cityRes, hireYear, salary);
		
		// add user information into array list
		userInfo.add(userEntry);
		System.out.println("we have added your entry into the file.");
		
		System.out.println("If you wish to quit please Enter [-1] else press any key");

		// ask user input and check for first character
		userInput = kb.next();	
		String input = userInput.substring(0);
		
		//check if user inputed -1, if true then continuation becomes false and quit loop
		if(input.equals("-1")){
			continuation = false;
			}
		}
			
			//print array list into a text file
			for(fullTimeFaculty x: userInfo){
				// write a new line to start the entries
				pw.println("");
				pw.print(x);
		
				}

	}	
	
	public static void addPtRecords(Scanner scan, PrintWriter pw)
	{
		
		Scanner kb = new Scanner(System.in);
		
		// declares variables
		long employeeId;
		String firstName;
		String familyName;
		String cityRes;
		int hireYear;
		double hourRate;
		int numHours;
		int numOfStudents;
		
		// make array list to check store employee id
		ArrayList<Long> empId = new ArrayList<Long>();
		
		// make array list of objects to store user input
		ArrayList<partTimeFaculty> userInfo = new ArrayList<partTimeFaculty>();
		
		System.out.println("Executing program to read from part-time...");
		
		// readn and give back arrayList of employeeId
		empId = readAndGiveEmployeeId(scan);
		
		//prompting user to enter 
		System.out.println("Would you like to add a new record?");
		System.out.println("Press [-1] to stop entering record, else press any key");
		
		String userInput = kb.next();	
		
		boolean continuation = true;
		
		if(userInput.equals("-1"))
			continuation = false;
		
		while(continuation){
			System.out.println("We will now proceed to add a new record.");
			
			System.out.print("Please enter your employee id: ");
			
			employeeId = kb.nextInt();
			
			//check if employee id is already used, if it is then re-ask user to input
			checkForIdDuplicate(empId, employeeId);
			
			//add user inputed employeeId into arraylist of employeeId
			empId.add(employeeId);
			
			System.out.print("Please enter your first name: ");
			firstName = kb.next();
			
			System.out.print("Please enter your family name: ");
			familyName = kb.next();
			
			System.out.print("Please enter your city of residence: ");
			cityRes = kb.next();
			
			System.out.print("please enter your hired year: ");
			hireYear = kb.nextInt();
			
			System.out.print("Please enter your hourly rate: ");
			hourRate = kb.nextDouble();
			
			System.out.print("Please enter the number of hours of current term: ");
			numHours = kb.nextInt();
			
			System.out.print("Please enter the number of student in class: ");
			numOfStudents = kb.nextInt();
			
			//create objects of part time faculty
			
			partTimeFaculty pt= new 
					partTimeFaculty(employeeId, firstName, familyName, cityRes, hireYear, hourRate, numHours, numOfStudents);
			
			//add entries into array list
			userInfo.add(pt);
			
			System.out.println("Press [-1] to stop entering record, else press any key");
			
			userInput = kb.next();
			
			if(userInput.equals("-1"))
				continuation = false;
		}
		
		//print array list into a text file
		for(partTimeFaculty x: userInfo){
			// write a new line to start the entries
			pw.println("");
			pw.print(x);
	
			}
		
	}
	
	
	public static void addTARecords(Scanner scan, PrintWriter pw){
		
		Scanner kb = new Scanner(System.in);
			
		Long employeeId;
		String firstName;
		String familyName;
		String cityRes;
		int hireYear;
		String type;
		int numOfClass;
		int numOfHours;
		
		ArrayList<Long> emId = new ArrayList<Long>();
		ArrayList<Ta> userInfo = new ArrayList<Ta>();
		
		System.out.println("Executing program to read from TA...");
		
		emId = readAndGiveEmployeeId(scan);
	
		// prompt the user if they wish to add a new entry
		
		System.out.println("Would you like to add a new entry?");
		System.out.println("Press [-1] to quit, else press any key to continue.");
		
		boolean continuation = true;
		String userInput = kb.next();
			
		if(userInput.equals("-1"))
			continuation = false;
		
		while(continuation){
			
			System.out.println("We will now proceed to add a new record.");
			System.out.print("Please enter your employee id: ");
			
			employeeId = kb.nextLong();
			
			//check if employee id is already used, if it is then re-ask user to input
			checkForIdDuplicate(emId, employeeId);
			
			//add user inputed employeeId into arraylist of employeeId
			emId.add(employeeId);
			
			System.out.print("Please enter your first name: ");
			firstName = kb.next();
			
			System.out.print("Please enter your family name: ");
			familyName = kb.next();
			
			System.out.print("Please enter your city of residence: ");
			cityRes = kb.next();
			
			System.out.print("please enter your hired year: ");
			hireYear = kb.nextInt();
			
			System.out.print("Please enter your hourly rate: ");
			type = kb.next();
			
			System.out.print("Please enter the number of student in class: ");
			numOfClass = kb.nextInt();
			
			System.out.print("Please enter the number of hours of current term: ");
			numOfHours = kb.nextInt();
						
			//create objects of Ta
			Ta t = new Ta(employeeId, firstName, familyName, cityRes, hireYear, type, numOfClass, numOfHours);
			
			// add object of Ta into arrayList
			userInfo.add(t);	
			
			System.out.println("Press [-1] to quit, else press any key to continue.");
			userInput = kb.next();
			
			if(userInput.equals("-1"))
				continuation = false;
			
		}
			
		// print newly added information into ta.txt
		for(Ta x: userInfo){
			// write a new line to start the entries
			pw.println("");
			pw.print(x);
	
			}
	}

	//=====================================PART1 - 2===========================================================
	
	//calculate the price of part-time and full-time 
	public static void findTermsSalary(Scanner pt, Scanner ta){
		//open file
		Scanner kb = new Scanner(System.in);
		
		//declares variables
		double hourlyRate;
		int numHours;
		int numOfStudents;
		
		double totalPiceTa = 0;
		double totalPricePt = 0;
		
		double sumOfListTa;
		double sumOfListPt;
		double totalTermSalary = 0;
		
		// create linklist
		listOfLinks linkPt = new listOfLinks();
		listOfLinks linkTa = new listOfLinks();
		
		System.out.println("Executing program to find total term salary...");
		// calculate the salary of part-time from the file
		while(pt.hasNextLine()){
			
			// stores variables from file
			pt.nextLong();
			pt.next();
			pt.next();
			pt.next();
			pt.nextInt();
			
			hourlyRate = pt.nextDouble();
			numHours = pt.nextInt();
			numOfStudents = pt.nextInt();
			
			// calculate the total price of part time 
			totalPricePt = (hourlyRate) * (numHours);
			
			
			// add the bonus
			 if(numOfStudents > 60){
				totalPricePt += 1000;
			}
			 else if(numOfStudents >= 40)
			{
				totalPricePt += 500;
			}
			
		
			//append it to linkedlist
			linkPt.addNode(totalPricePt);		
				
		}

		final double RATE = 1.2;
		
		String type;
		int numClass;
		int totalHours;
		double taHourlyRate = 0;
		
		System.out.println("======starting to read price of ta======");
		while(ta.hasNextLine()){
			
			//declare variables
			ta.nextLong();
			ta.next();
			ta.next();
			ta.next();
			ta.nextInt();
			
			type = ta.next();
			numClass = ta.nextInt();
			totalHours = ta.nextInt();

			
			// find the classification of students
			char letter = type.charAt(0);
			
			switch(letter){
			
			case 'A': taHourlyRate = 0; break;
			case 'G': taHourlyRate = 18.25 * RATE; break;
			case 'U': taHourlyRate = 18.25; break;
			
			}
			
			//calculate the total price of ta
			totalPiceTa = taHourlyRate * totalHours;
			
			linkTa.addNode(totalPiceTa);
			
		}
		
		//calculate the sum of the two linklist and return the total price
		sumOfListPt = linkPt.sumAllNode();
		sumOfListTa = linkTa.sumAllNode();
	
		System.out.printf("The sum of part-time salary is: %.2f", sumOfListPt );
		System.out.println();
		System.out.printf("The sum of Ta salary is: %.2f", sumOfListTa);
		System.out.println();
		
		totalTermSalary	= sumOfListPt + sumOfListTa;	
		System.out.printf("The total sum of the term salary is: %.2f", totalTermSalary);
		System.out.println("\n");
		
	}
	
	//=====================================PART1 - 3===========================================================
	
	// This method will find the highest and lowest salary in a given text file
	public static void findHighest_and_Lowest_Ft_Salary(Scanner ft){
		
		Scanner kb = new Scanner(System.in);
		// open FTFile and read to linkedlist
		
		//declares variables
		long employeeId;
		String firstName;
		String familyName;
		String cityRes;
		int hireYear;
		int salary = 0;
		
		// create a linkList to store information of salary and text
		listOfLinks linkFt = new listOfLinks();
		listOfLinks linkInfo = new listOfLinks();
		
		System.out.println("Executing program to find the highest and lowest salary...");
		
		//go throught the text file and discard un-used information
		while(ft.hasNextLine()){
			
		employeeId = ft.nextLong();
		firstName = ft.next();
		familyName = ft.next();
		cityRes = ft.next();
		hireYear = ft.nextInt();
		salary = ft.nextInt();
			
		// create an object of fullTimeFaculty with given parameters
		fullTimeFaculty em1 = new fullTimeFaculty(employeeId, firstName, familyName, cityRes, hireYear, salary);
		
		// add newly created object into linkInfo
		linkInfo.addNode(em1);
		
		//add salary into linkFt
		linkFt.addNode(salary);
			
		}
		
		// call highest() and lowestNode() to find the maximum and lowest value in a given node
		int highestValue = linkFt.highestNode();
		int lowestValue =  linkFt.lowestNode();
		
		
		
		// the findAndPrint method will find the value and print it
		System.out.println("===============Here is(are) the record of highest salary in the list===============");
		linkInfo.findAndPrint(highestValue);
		
		System.out.println("===============Here is(are) the record of lowest salary in the list===============");
		linkInfo.findAndPrint(lowestValue);
			
						
	}
	
	//=====================================PART1 - 4===========================================================
	
	public static void Increase_Staff_Salary(Scanner sfRead, PrintWriter sfWrite){
		
		Scanner kb = new Scanner(System.in);
		
		//declares variables
		double rates = 0;
		int totalSalary = 0;
		listOfLinks linkStaff = new listOfLinks();
		
		//open staff file and read to linkedList
		System.out.println("\nExecuting program to increase staff salary...");
		System.out.println("we will start reading from staff file...");
		while(sfRead.hasNextLine()){
			
			// read the values from files
			Long employeeId = sfRead.nextLong();
			String firstName = sfRead.next();
			String lastName =sfRead.next();
			String cityRes = sfRead.next();
			int hireYear = sfRead.nextInt();
			int salary = sfRead.nextInt();
			String performance = sfRead.next();
			
			char letter = performance.charAt(0);
			switch(letter){
			
			// find rate and set code to E
			case 'A': rates = 0.08; letter = 'E'; break;
			case 'B': rates = 0.06; letter = 'E'; break;
			case 'C': rates = 0.03; letter = 'E'; break;
			case 'D': rates = 0.01; letter = 'E'; break;
			case 'E': rates = 0; break;
			}
			
			//calculate price
			totalSalary = (int)((rates * salary)+ salary);
			
			//create object of staff
			Staff s1 = new Staff(employeeId, firstName, lastName, cityRes, hireYear, totalSalary, letter);
			// add object of staff into linkList
			linkStaff.addNode(s1);
			
		}
		sfRead.close();
		
		//re-open file to read and write to
		try{
			sfWrite = new PrintWriter(new FileOutputStream("Staff.txt"));
			
		}
		catch(FileNotFoundException e){
			System.out.println("File was not found");
		}
		System.out.println("here is the final result after increasing : \n" + linkStaff.iteration());

		// for loop that goes to each node and print the contents
		for(int i = 0; i<linkStaff.sizeNode(); i++){
			
			sfWrite.println(linkStaff.printNode(i));
		}
		
		sfRead.close();
		sfWrite.close();
	
		}

	
	public static void main(String[] args){
		
		//Scanners & PrintWriter for part 1
		Scanner ftRead = null;
		PrintWriter ftWrite = null;
		String fullTime = "Full-Time-Faculty.txt";
		File fullTimeFile = new File(fullTime);
		
		Scanner ptRead = null;
		PrintWriter ptWrite = null;
		String	partTime = "Part-Time-Faculty.txt";
		File partTimeFile = new File(partTime);
		
		Scanner taRead = null;
		PrintWriter taWrite = null;
		String ta = "Tas.txt";
		File taFile = new File(ta);

		Scanner sRead = null;
		PrintWriter sWrite = null; 
		File sfTest = new File("Staff.txt");

		boolean mismatch = true;
		
		try{
			// open all 3 files for reading and writting
		ftRead = new Scanner(new FileInputStream(fullTimeFile));
		ftWrite = new PrintWriter(new FileOutputStream(fullTimeFile, true));
		
		ptRead = new Scanner(new FileInputStream(partTimeFile));
		ptWrite = new PrintWriter(new FileOutputStream(partTimeFile, true));
		
		taRead = new Scanner(new FileInputStream(taFile));
		taWrite = new PrintWriter(new FileOutputStream(taFile,true));
			
		// call function addFtRecords for full time employee
		addFTRecords(ftRead, ftWrite);
		System.out.println("We have added your record into the file: " + fullTime + "\n");
		ftWrite.close();
		ftRead.close();
		
		addPtRecords(ptRead, ptWrite);
		System.out.println("We have added your record into the file: " + partTime + "\n");
		ptWrite.close();
		ptRead.close();
		
		addTARecords(taRead, taWrite);	
		System.out.println("We have added your record into the file: " + ta + "\n");
		taWrite.close();
		taRead.close();
		
		
		}
		catch(IOException e){
			System.out.println("Errors");
		
		}
		
		// open/read file for methods
		try{
			ftRead = new Scanner(new FileInputStream(fullTimeFile));
			ftWrite = new PrintWriter(new FileOutputStream(fullTimeFile, true));
			
			ptRead = new Scanner(new FileInputStream(partTimeFile));
			ptWrite = new PrintWriter(new FileOutputStream(partTimeFile, true));
			
			taRead = new Scanner(new FileInputStream(taFile));
			taWrite = new PrintWriter(new FileOutputStream(taFile,true));
			
			sRead = new Scanner(new FileInputStream(sfTest));
			sWrite = new PrintWriter(new FileOutputStream(sfTest, true));
			
			findTermsSalary(ptRead, taRead);
			ptRead.close();
			taRead.close();
			
			findHighest_and_Lowest_Ft_Salary(ftRead);
			ftRead.close();
			
			Increase_Staff_Salary(sRead, sWrite);
					
			sRead.close();
			sWrite.close();
			
		}
		catch(FileNotFoundException e){
			System.out.println("File was not found.");
		}
		
		
		//=====================================PART1 - 5===========================================================
	
		// Testing interfaces of ordering by calling the methods precedes and follows
		Employees e1 = new Employees(88888888, "John", "Kennedy", "Kansas", 1998);
		Employees e2 = new Employees(12434525, "Bruce", "Lee", "New York" , 2017);
		
		Employees e3 = new Employees(48124901, "Donaldo", "Trumpy", "Alabama", 2016);
		Employees e4 = new Employees(19847123, "Jackie", "Chan", "Hong Kong" , 2009);
		
		//print all informations of differents objects
		System.out.println("Here are the information of objects...");
		System.out.println("e1 : " + e1);
		System.out.println("e2 : " + e2);
		System.out.println("e3 : " + e3);
		System.out.println("e4 : " + e4);
		
		// true || e1 = 1980 , e2 = 1990
		System.out.print("Does e1 precedes e2 ?: ");
		System.out.println(e1.precedes(e2));
		
		System.out.print("Does e3 follows e4 ?: ");
		// true || e1 = 1980, e2 = 1990
		System.out.println(e3.follows(e4));
		
	}
	
}