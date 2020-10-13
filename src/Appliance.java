/**
 * This is an Appliance class that
 * creates new appliances, changes an appliance information, and displays existing appliances.
 * @author Farah Salhany.
 * COMP249
 * Assignment# 1
 * Concordia University
 */

public class Appliance {
	
	/**
	 * 4 attributes that are the main data of an appliance 
	 * and a variable to keep count of how many appliances exist in the store
	 */
	private String type;
	private String brand;
	private long serialNumber;
	private double price;
	
	//keeps count of the number of appliances created.
	public static int applianceCounter = 0;
	
	/**
	 * Default constructor
	 */
	public Appliance() {
		this.type = "null";
		this.brand = "null";
		this.serialNumber = 1000000+applianceCounter;
		this.price = 1;
		applianceCounter++;
	}	
	
	/**
	 * Constructor with 3 arguments
	 * initializes a new appliance with values entered from the store owner 
	 * 
	 * @param applianceType appliance type 
	 * @param applianceBrand appliance brand
	 * @param appliancePrice appliance price
	 */
	public Appliance(String applianceType, String applianceBrand, double appliancePrice) {
		this.type = applianceType;
		this.brand = applianceBrand;
		this.serialNumber = 1000000+applianceCounter;
		if (appliancePrice>=1)
			this.price = appliancePrice;
		else {
			System.out.println("The price of an appliance cannot be less than $1");
			this.price = 1;
		}
		applianceCounter++;
	}
	
	/**
	 * Copy constructor
	 * copies an appliance information into another appliance.
	 * 
	 * @param newAppliance a parameter of type Appliance 
	 */
	public Appliance(Appliance newAppliance) {
		this.type = newAppliance.type;
		this.brand = newAppliance.brand;
		this.serialNumber = newAppliance.serialNumber;
		this.price = newAppliance.price;
	}
	
	// mutators & accessors
	/**
	 * Mutators method to set or change an appliance type.
	 * 
	 * @param type the new type of an appliance.
	 */
	public void setType(String type) {
		final String [] applianceType = {"Fridge", "Air Conditioner", "Washer", "Dryer", "Freezer", "Stove", "Dishwasher", "Water Heaters", "Microwave"}; 
		boolean check= false;
		for (int i=0 ; i<applianceCounter ; i++) {
			if (applianceType[i].equalsIgnoreCase(type)){
				check= true;
				this.type= type;
			}
		}
		if (check == false) {
			System.out.println("Appliance type is invalid");
		}
	}
	
	/**
	 * Accessor method to get the type of a specific appliance.
	 * 
	 * @return type the type of an appliance.
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Mutators method to set or change an appliance brand.
	 * 
	 * @param brand the new brand of an appliance.
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Accessor method to get the brand of a specific appliance.
	 * 
	 * @return brand the brand of an appliance.
	 */
	public String getBrand() {
		return this.brand;
	}
	
	// there's no mutator for serial number because it cannot be changed
	/**
	 * Accessor method to get the serial number of a specific appliance
	 * serial numbers can't be changes ones created 
	 * 
	 * @return serialNumber the serial number of an appliance.
	 */
	public long getSerialNumber() {
		return this.serialNumber;
	}
	
	/**
	 * Mutators method to set or change an appliance price.
	 * 
	 * @param price the new price of an appliance.
	 */
	public void setPrice(double price) {
		if (price>=1)
			this.price = price;
		else {
			System.out.println("The price of an appliance cannot be less than $1");
			this.price = 1;
		}
	}
	
	/**
	 * Accessor method to get the price of a specific appliance
	 *  
	 * @return price of an appliance.
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * toString method to print out an appliance information.
	 */
	public String toString() {
		return ("\nAppliance Serial # " +this.serialNumber + "\nBrand: "+this.brand.toUpperCase()
				+ "\nType: " +this.type +"\nPrice: $" +this.price);
	}

	/**
	 * equals method that checks if two appliances have the same type, brand, and price.
	 * 
	 * @param someAppliance a parameter of type Appliance to get the information of the appliance passed.
	 * @return boolean returns true if two appliances are equal, and false if they are not equal.
	 */
	public boolean equals(Appliance someAppliance) {
		if ((this.type.equals(someAppliance.type)) && (this.brand.equals(someAppliance.brand)) && (this.price == someAppliance.price))
			return true;
		else
			return false;
	}

	/**
	 * findNumberOfCreatedAppliances a method to return the number of existing appliances in store.
	 * 
	 * @return int applianceCounter which gives the number of appliances in store.
	 */
	public static int findNumberOfCreatedAppliances() {
		return applianceCounter;
	}
	
}// end of class Appliance 
