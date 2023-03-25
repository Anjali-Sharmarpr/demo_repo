package EmployeeManagementSystem;

import EmployeeManagementSystem.*;
import java.io.*;
import java.util.*;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           
		//variables of Employee
		String name;
		int id;
		String address;
		String title;
		double salary;
		
		//Arraylist of objects of employee type to store data
		
		ArrayList<Employee> list = new ArrayList<>();
		 ArrayList<Employee>list2=null;
		 
		Scanner s= new Scanner(System.in);
		
		int ch=(-1);
		
		//loop till exit
		while(ch!=5) {
		   System.out.println("\nWelcome to employee management system"+
		                      "\nEnter your choice:- "+
				              "\n1: Add employee details"+
		                      "\n2: Read all employee details"+
				              "\n3: Update Employee information"+
		                      "\n4: Delete employee detail"+
				              "\n5: exit"
				              );
		ch= s.nextInt();
		
		switch(ch) {
		
		case 1:
		   //adding employee details
		   System.out.println("Enter Employee id ");
		   id=s.nextInt();
		   System.out.println("Enter Employee name");
		   name = s.next();
		   System.out.println("Enter Employee Address");
		   address= s.next();
		   System.out.println("Enter Employee Job title");
		   title= s.next();
		   System.out.println("Enter Employee Salary");
		   salary=s.nextDouble();
		   
		   
		    //list  = new ArrayList<>();
		   list.add(new Employee(name,id,address,title,salary));
		   //list.add(new Employee("Anjali",1,"ssipmt","Student"));
		
		//writing into file
		
		try {
			FileOutputStream writeData= new FileOutputStream("Employee.txt");
			ObjectOutputStream writeStream =  new ObjectOutputStream(writeData);
			
			writeStream.writeObject(list);
			writeStream.flush();
			writeStream.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Employee added Succesfully");
		
	    break; //end of case 1
	    
	    case 2:	    	  
		//reading from file
		try {
		    FileInputStream readData = new FileInputStream("Employee.txt");
		    ObjectInputStream readStream = new ObjectInputStream(readData);
		    
		    list2 = (ArrayList<Employee>)readStream.readObject();
		    readStream.close();
		    
		    System.out.println(list2.toString());
		  
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		break;
		
	    case 3:
	    	//updating
	    	System.out.println("Enter Employee ID you want to update");
	    	int i= s.nextInt();
	    	
	    	boolean flag=false;
	    	
	    	//enhanced for loop was giving  ConcurrentModificationException therfore using normal for loop
	    	//for(Employee e : list2) { 
	    		//if(e.empID==i) {
	    			
	    	for(int it=0;it<list2.size();it++) {
	    		if(list2.get(it).empID==i) {
	    			
	    			flag=true;
	    			System.out.println("Enter Employee name");
	    			name=s.next();
	    			list2.get(it).setEmpName(name);
	    			
	    			System.out.println("Enter Employee Address");
	    			address=s.next();
	    			list2.get(it).setEmpAddress(address);;
	    			
	    			System.out.println("Enetr Employee Job title");
	    			title=s.next();
	    			list2.get(it).setJobTitle(title);
	    			
	    			System.out.println("Enter Employee Salary");
	    			salary=s.nextDouble();
	    			list2.get(it).setEmpSalary(salary);
	    			
	    			try {
	    				//writing the updated data into file
	    			FileOutputStream writeData= new FileOutputStream("Employee.txt");
	    			
					ObjectOutputStream writeStream =  new ObjectOutputStream(writeData);
						
					writeStream.writeObject(list2);
					writeStream.flush();
					writeStream.close();
					
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    			
	    		}
	    	} if(flag) {
	    		System.out.println("Employee Updated Succesfully");
	    	}
	    	else {
	    		System.out.println("ID not found");
	    	}
	    	
	    	break;
		
	    	
	    case 4:
	    	//deleting
	    	boolean found=false;
	    	System.out.println("Enter Employee ID to delete");
	    	int d= s.nextInt();
	    	
	    	//for(Employee e : list2) {
	    		//if(e.empID==d) {
	    	
	    	for(int it=0;it<list2.size();it++) {
	    		if(list2.get(it).empID==d) {
	    			
	    			found=true;
	    			list2.remove(list2.get(it));
	    			
	    			try {
	    				//writing the list (after deletion) into file
                    FileOutputStream writeData= new FileOutputStream("Employee.txt");
	    			
					ObjectOutputStream writeStream =  new ObjectOutputStream(writeData);
						
					writeStream.writeObject(list2);
					writeStream.flush();
					writeStream.close();
	    			}
	    			
	    			catch(Exception ex) {
	    				ex.printStackTrace();
	    			}
	    		}
	    	}
	    	if(found) {
	    		System.out.println("Employee Delted Successfully");
	    	}
	    	else {
	    		System.out.println("ID not found");
	    	}
	    	break;
	    	
	    case 5:
	    	System.out.println("Terminating.....");
	    	System.exit(0);
	    	break;
	    	
	    default:
	    	System.out.println("Enter a valid choice");
	    	break;
	    	
	   }//switch closing
		
	  }//while closing bracket
	}
}
