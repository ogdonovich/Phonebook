package phoneBook;

public class DisplayMenu {
	
	public static int displayInitialMenu() {
		System.out.println(
				"1 Add a record \n"
			  + "2 Delete a record \n"
			  + "3 Update a record \n"
			  + "4 Find a record \n"
			  + "5 Show all records \n"
			  + "6 Exit \n"
			  + "------------------"
				);
		return DataLogic.getIntInput();
	}
	
	public static void clearScreen() {
		
	}
	
	public static int updateRecord() {
		System.out.println(
				"Which field would you like to update: \n"
			  + "1 First Name \n"
			  + "2 Last Name \n"
			  + "3 Address \n"
			  + "4 PhoneNumber \n"
			  + "5 Back");
		
		return DataLogic.getIntInput();
	}
	
	public static int updateAddress( ) {
		System.out.println(
				"Which field would you like to update: \n"
			  + "1 Number \n"
			  + "2 Street Name \n"
			  + "3 City \n"
			  + "4 Region or State \n"
			  + "5 Zipcode ");
		
		return DataLogic.getIntInput();
	}
	
	public static int searchByItem() {
		System.out.println(
				"Which field would you like to search by: \n"
			  + "1 First Name \n"
			  + "2 Last Name \n"
			  + "3 Full Name \n"
			  + "4 Phone Number \n"
			  + "5 City \n"
			  + "6 State \n"
			  + "7 Return ");
		return DataLogic.getIntInput();
	}
	
	
	

}
