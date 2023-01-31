
import java.util.Scanner;// Import the Scanner class to read text files
import java.lang.System;
import java.lang.String;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;  // Import the Collections class, which contains sorting methods
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class LockedMe {
	public static void navigation(String[] args) {
			System.out.println("Please select, would you like to return to the main menu? if so type yes"); 
    	Scanner yesNo = new Scanner(System.in);
    	String yesNoResponse = yesNo.nextLine();
    		if (yesNoResponse.equalsIgnoreCase("Yes")) {
    			options(args); }
    		else if (yesNoResponse.equalsIgnoreCase("No")) {
    			System.out.println("Would you like to close the application? (Yes/No)");
    			//creating another yes/no storage input 
    			Scanner yesNo1 = new Scanner(System.in);
    	    	String yesNoResponse1 = yesNo1.nextLine();
    	    		if (yesNoResponse1.equalsIgnoreCase("Yes")) {
    	    			System.out.println("Ok, closing application now");
    	    			System.exit(0);  //close application  
    	    			}
    	    		else if (yesNoResponse.equalsIgnoreCase("No")) {
    			System.out.println("Ok, directing to you the main menu now");
    			main(args); }
    	    		else {
    	    			System.out.println("sorry I didn't get that, closing applicationm");
    	    			System.exit(0);  //close application  
    	    		//adding else to address if the users response if not the expected yes or no answer
    		}} else {
			System.out.println("sorry I didn't get that, closing application");
			System.exit(0);  //close application  
	    			}
						
					}

	//launch welcome screen with greeting
	public static void main(String[] args) {
		//launch welcome page
		System.out.println("Welcome to LockedMe.com!");
		System.out.println("Please enter your Login name");
		Scanner login = new Scanner(System.in);// Create a Scanner object
		String name = login.nextLine();// Read user input
		System.out.println("Hi " +  name);	// Output user input
		
		options(args);
	}
	
	

	//options screen
	public static void options(String[] args) { 
		//presenting possible options on navigation screen
		System.out.println("Please choose a number from the following options");
		System.out.println("Option 1: View a list of the File directory in assending order");
		System.out.println("Option 2: Add/ Delete or Search for a specific user file");
		System.out.println("Option 3: Close Application");
		//setting the input stream
		Scanner sc = new Scanner(System.in);// Create a Scanner object
		String option = sc.nextLine(); // Read user input
		    
		ArrayList<String> fileNames = new ArrayList<String>(); // Create an ArrayList object *****
		fileNames.add("Document A");
		fileNames.add("Document Z");
		//Object option;
		// setting rules to determine which flow will be showed depending on users choice of option
		if (option.equals("1")) { 
			//or (option.equalsIgnoreCase("Option 1")) { 
				//||  || (option.equalsIgnoreCase("View a list of the File directory in ascending order")); {
		System.out.println("you chose option " +  option);	// Output user input	
		System.out.println("This is a list of file directory in assending order");
		Collections.sort(fileNames);
	    for (String i : fileNames) {
	        System.out.println(i); }
	    //directing to navigation screen/////////////////////////
	    try {	
	    navigation(args); }
	    //if users type anything other than yes or no
		catch (Exception e) { 
		 	System.out.println("Sorry didn't quite get that"); 
		 	navigation(args); }

	    		
		} else if (option.equals("2")) { 
				//|| option == "Option 2"|| option == "Add/ Delete or Search for a specific user file") {
		System.out.println("You chose option " +  option);
		System.out.println("Would you like to add, delete or search for a specific user file?");
		Scanner question = new Scanner(System.in);// Create a Scanner object
		String option2 = question.nextLine(); // Read user input
	 
				if (option2.equalsIgnoreCase("add")) {
				//run add method
				System.out.println("What is the name of the file you would like to add?");
				Scanner question2 = new Scanner(System.in);// Create a Scanner object
				String option3 = question2.nextLine(); // Read user input
				fileNames.add(option3);
				System.out.println("This is the updated list" + fileNames);
				navigation(args);
				
				}
				else if (option2.equalsIgnoreCase("delete")) {
					//run delete method
					System.out.println("What is the name of the file you would like to delete?");
					Scanner question3 = new Scanner(System.in);// Create a Scanner object
					String option4 = question3.nextLine(); // Read user input 
						if (fileNames.contains(option4)) { 
							System.out.println("File found and is being deleted ");
							{fileNames.remove(option4);      
							System.out.println("This is the updated list" + fileNames);
							navigation(args);
							}
						} else {
							System.out.println("Sorry that file has not been found");
							navigation(args);
					
						}
					}
				else if (option2.equalsIgnoreCase("search")) {
					//run search method
					System.out.println("What is the name of the file you are searching for?");
					Scanner question4 = new Scanner(System.in);// Create a Scanner object
					String option5 = question4.nextLine(); // Read user input
						//for (String i : fileNames) {
							if (fileNames.contains(option5)) { 
								System.out.println("File found");
								navigation(args);
						} else {
							System.out.println("Sorry that file has not been found");
							navigation(args); }
			
						  }
				///when users types something unexpected 
				else {
		 	System.out.println("Sorry didn't quite get that"); 
		 	navigation(args); }
		

		}
	
		//If user has selected option 3 to Close application
		else if (option.equals("3")) {
			System.out.println("You chose to Close the application.. the application is closing now.");
			System.exit(0);
			}
		
		//setting an exception in case when invalid entry
		else { 
			System.out.println("Sorry I didn't get that, please try entering a number from the options available");
			//NEED TO RETURN TO THE START OF THE CODE HERE
			options(args);
		}
	
	}
	
	}
