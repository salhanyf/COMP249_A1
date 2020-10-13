# COMP249-A1
Java
You are hired by a major appliance dealer to write a software that helps the store owner in acquiring and keeping track of appliances at the store.<br><br>
Part 1)<br>
An appliance object has four attributes, a type, a brand, a serial number, and a price. <br>- The type of an appliance can be any of the following: Fridge, AirConditioner, Washer, Dryer, Freezer, Stove, Dishwasher, Water Heaters, and Microwave.
<br>- The brand indicates the vendor/manufacturer of the appliance (such as LG, Samsung, Bosch, etc.).
<br>- The serial number represents the serial number of the appliance, and must
be unique. For simplicity, we assume that the serial numbers start at 1000000 and it is
common/shared among all different brands and types
<br>- The price of an appliance cannot be less than 1$.<br><br>
For this part, you are required to design and implement the Appliance class according to the following specifications:<br>
1 - Upon the creation of an appliance object, the object must immediately be initialized with valid values; that is type, brand, serial number and price.<br>
2 - The design should allow enough flexibility so that the value of any of these attributes can be modified later on (with the exception of the serial number, which can never be changed once assigned).<br>
3 - The design should allow all information of an object to be displayed at once through the utilization of System.out.print() method.<br>
4 - It is required to know how many appliance objects have been created. For that, you need to add a method, called findNumberOfCreatedAppliances(), to the class. This method
must return the number of created appliance objects prior to the time this method is
called. The method would simply return 0 if no appliances have been created by the time
the method is called.<br>
5 - It is required to compare two Appliance objects for equality. Two appliances are
considered equal if they have the same brand, type and price.
6 - It is required to display any Appliance object (all info of that object) using
System.out.println() method.<br><br>
Part 2)<br>
A main() method that will:<br>
1 - Display a welcome message;<br>
2 - Prompt the store owner for the maximum number of appliances his/her
store can contain. Create an empty array, called inventory, that will have the potential of keeping track of the created Appliance objects.<br>
3 - Display a main menu (Figure 1) with the following choices and keep prompting the user
until they enter a number between 1 and 5 inclusive (i.e invalid number will result in
repeating the display of the main menu):
