/**
 * creating a software that helps the store owner in acquiring and
 * keeping track of appliances at the store.
 * 
 * @author Farah Salhany.
 * COMP249
 * Assignment #1
 * Concordia University
 */

import java.util.Scanner;
public class DriverProgram {
	
	/**
	 * A static variables that can be used in different methods within the class
	 */
	public static Appliance inventory [];
	public static Scanner scan = new Scanner(System.in);
	public static int index;
	
	/**
	 * main method
	 */
	public static void main(String[] args) {
		
		//welcome message
		System.out.println("\t****** Welcome to your store program ******");
		System.out.println("\t-------------------------------------------");
		// prompt the store owner for the maximum number of appliances
		System.out.print("Please enter the maximum number of appliances the store can contain: ");
		
		//variables declaration 
		int maxAppliances = scan.nextInt();
		int option;
		int passwordCount = 0;
		
		//creates an empty array, will have the potential of keeping track of the created Appliance objects
		inventory = new Appliance [maxAppliances];	
		
		//displays the main menu
		while ( passwordCount<12 ) {
			System.out.println("\nWhat do you want to do?");
			System.out.println("\t1. Enter new appliances (password required).\n"
							+ "\t2. Change information of an appliance (password required).\n"
							+ "\t3. Display all appliances by a specific brand. \n"
							+ "\t4. Display all appliances under a certain a price.\n"
							+ "\t5. Quit.");
			System.out.print("Please enter your choice > ");
			option = scan.nextInt();
			
			//validates if the number entered is between 1 and 5
			if (option<1 || option>5) {
				System.out.println("Invalid number will result in repeating the display of the main menu");
			}
			
			//switch statement to handle the menu
			switch (option) {

			//enter new appliances (password required)
			case 1 : 
				do {
					System.out.print("Please enter your passward: ");
					String passwordEntered = scan.next();
	
					//if password is correct ask for number of new appliances
					if (passwordIsCorrect(passwordEntered)) {
						passwordCount = 0;
						System.out.print("How many appliances you want to enter: ");
						int numOfNewAppliances = scan.nextInt();
			
						//if the maximum number of appliances the store can contain is not exceeded, ask for appliances info 
						if (numOfNewAppliances+Appliance.findNumberOfCreatedAppliances() <= inventory.length) {
							for (int i=0 ; i<numOfNewAppliances ; i++) {
								System.out.println("Enter details for appliance "+(i+1)+":");
								System.out.print("Appliance type: ");
								String newApplianceType = scan.next() ;
								System.out.print("Appliance brand: ");
								String newApplianceBrand = scan.next() ;
								System.out.print("Appliance price: ");
								double newAppliancePrice = scan.nextDouble();
								// stores the appliance info
								inventory[i] = new Appliance(newApplianceType, newApplianceBrand, newAppliancePrice);
							}
						}
						//error message if store cannot contain all the appliances the owner wants to enter
						else {
							System.out.println("Maximum number of appliances is exceeded.");
							System.out.println("You can only enter "+ (inventory.length-Appliance.findNumberOfCreatedAppliances())+" new appliance(s).");
						}
					}	
					
					//if password is incorrect, ask to re-enter password
					else {
						System.out.println("You entered a wrong password");
						passwordCount++;
						
						if (passwordCount == 12) {
							System.out.println("Program detected suspicious activities and will terminate immediately!");
							System.exit(0);
						}
					}
				}
				while (passwordCount%3 != 0);
				break;	//break after case 1
				
			//change information of an appliance (password required)	
			case 2 :
				//resets the password counter so the owner can have another 3 attempts 
				passwordCount = 0;
				while (passwordCount<3) {
					System.out.print("Please enter your passward: ");
					String passwordEntered = scan.next();
					
					//if password is correct
					if (passwordIsCorrect(passwordEntered)) {
						passwordCount = 0;
						//asks for the serial number for the appliance the owner wish to change
						System.out.print("Enter the serial number of the appliance you wish to update: ");
						long serialNum = scan.nextLong();
						// checks if there is appliances in store 
						if (Appliance.findNumberOfCreatedAppliances() == 0) {
							System.out.println("No appliances in the store.");
							break;
						}
						//if an appliance is found by the serial number 
						if(findApplianceBySerialNumber(serialNum, Appliance.findNumberOfCreatedAppliances())) {
							int choice =-1;
							//asks for the information that the owner with to change for an existing appliance 
							while (choice != 4) {
								System.out.println("What information would you like to change? ");
								System.out.println("\t1. Brand\n\t2. Type\n\t3. Price \n\t4. Quit");	
								System.out.print("Please enter your choice > ");
								choice = scan.nextInt();
								if (choice ==1) {
									System.out.print("Enter new brand: ");
									String brand = scan.next();
									inventory[index].setBrand(brand);
									System.out.println(inventory[index]);
								}
								else if (choice ==2) {
									System.out.print("Enter new type: ");
									String type = scan.next();
									inventory[index].setType(type);
									System.out.println(inventory[index]);
									
								}
								else if (choice ==3) {
									System.out.print("Enter new price: ");
									double price = scan.nextDouble();
									inventory[index].setPrice(price);
									System.out.println(inventory[index]);
								}
							}
							
							break;	//to go back to the main menu
						}
						//if no appliance is found by the serial number entered
						else
							System.out.println("Do you wish to (1)re-enter another serial number or (2)go back to main menu? ");
						int choice = scan.nextInt();
						if (choice == 2)
							break;
					}
					
					//if password is incorrect 
					else {
						System.out.println("You entered a wrong password");
						passwordCount++;
					}	
				}	
				break;	//break after case 2
				
			//display all appliances by a specific brand.	
			case 3 :
				System.out.print("Enter brand name: ");
				String brandName = scan.next();
				findAppliancesByBrand(brandName, Appliance.findNumberOfCreatedAppliances());
				
				break;	//break after case 3
				
			//display all appliances under a certain a price.	
			case 4 :
				System.out.print("Enter a price: ");
				double price = scan.nextDouble();
				findCheaperThan(price, Appliance.findNumberOfCreatedAppliances());
				break;	// break after case 4	
			
			//quits the program
			case 5 :
				System.out.println("\t-------------------------------------------");
				System.out.println("\t****** Thank you for using this program ******");
				System.exit(0);
				break;	
			}// end of switch statement
			
		}//end of while statement	
			
		//closes the scanner object
		scan.close();
	}// end of main
	
	/**
	 * passwordIsCorrect method to check if the password entered is the correct password
	 * 
	 * @param passwordEntered the password entered by the owner 
	 * @return boolean true if the password is correct, false otherwise
	 */
		public static boolean passwordIsCorrect(String passwordEntered) {
			final String password = "c249";
			if (passwordEntered.equals(password))
				return true;
			else
				return false;
		}
	
	/**
	 * findApplianceBySerialNumber method to find if there is an appliance with a specific serial number (option2)
	 * 
	 * @param serialNum serial number to find an appliance 
	 * @param NumberOfCreatedAppliances the number of appliances in store
	 * @return boolean true if an appliance has been found, false otherwise 
	 */
	public static boolean findApplianceBySerialNumber(long serialNum, int NumberOfCreatedAppliances) {
		int i=0;
		
		for (i=0 ; i<NumberOfCreatedAppliances ; i++) {
			if (inventory[i].getSerialNumber() == serialNum) {
				System.out.println(inventory[i]+"\n");
				index = i;
				return true;
			}
		System.out.println("No appliance found with this Serial Number "+serialNum);
		}
		return false;
	}	
	
	/**
	 * findAppliancesByBrand method to find all appliances by their brand (option3)
	 * 
	 * @param brand to find its appliances
	 * @param NumberOfCreatedAppliances the number of appliances in store
	 */
	public static void findAppliancesByBrand(String brand, int NumberOfCreatedAppliances) {
		boolean check =false;
		for(int i=0;i<NumberOfCreatedAppliances;i++) {
			if(inventory[i].getBrand().equalsIgnoreCase(brand)) {
				check = true; 
				System.out.println(inventory[i]);     
			}   
		}
	    if (check == false) {
	    	System.out.println("There's no appliancea found with brand "+brand.toUpperCase());
	    }
	}
	
	/**
	 * findCheaperThan method to find all appliances cheaper than a specific price (option4)
	 * 
	 * @param price to find all appliances cheaper than that price 
	 * @param NumberOfCreatedAppliances the number of appliances in store
	 */
	public static void findCheaperThan(double price, int NumberOfCreatedAppliances) {
		boolean check =false;
		for(int i=0;i<NumberOfCreatedAppliances;i++) {
			if(inventory[i].getPrice() < price) {
				check = true;
				System.out.println(inventory[i]);
			}   			
		}
	    if (check == false) {
	    	System.out.println("There's no appliancea under $"+price);
	    }
	}
}// end of class
