package phoneBook;

import java.util.Scanner;

public class Contact extends DataLogic{
	
	private String firstName;
	private String middleName;
	private String lastName;
	private Address address;
	private String phoneNumber;

	public Contact() {
	}

	public Contact(String firstName, String middleName,  String lastName, Address address, String phoneNumber) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}



	public void updateRecord(Contact[] contactList) {
		// TODO Auto-generated method stub
		System.out.println("\nEnter the telephone number of the contact you would like to find");
		Scanner lineReader = new Scanner(System.in);

		String contactEntry = "";
		if (lineReader.hasNextLine()) {
			contactEntry = lineReader.nextLine();
		}

		this.phoneNumber = contactEntry.trim();
		this.loadRecord(contactList);

		switch (DisplayMenu.updateRecord()) {
		case 1:{
			this.firstName = DataLogic.getUserInputString().trim();
			break;
		}
		case 2:{
			this.lastName = DataLogic.getUserInputString().trim();
			break;
		}
		case 3:{
			this.address.updateAddress();
			break;
		}
		case 4:{
			this.phoneNumber = DataLogic.getUserInputString().trim();
			break;
		}
		case 5:{
			DisplayMenu.displayInitialMenu();
			break;
		}
		default:
			break;
		}

	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void display() {
		if (middleName == "" || middleName == null) {
			System.out.println(
					this.firstName + " "  + this.lastName + "\n" + this.address.display() + " \n" + formatPhoneNumber(this.phoneNumber) + "\n");
		}
		else {
			
		System.out.println(
				this.firstName + " " + this.middleName + " " + this.lastName + "\n" + this.address.display() + " \n" + formatPhoneNumber(this.phoneNumber) + "\n");
		}
	}

	@Override // Grab all data in one line and parse out
	public void saveRecord() {
		System.out.println("\nEnter your information in a single line, comma and space seperated");
		Scanner lineReader = new Scanner(System.in);

		String contactEntry = "";
		if (lineReader.hasNextLine()) {
			contactEntry = lineReader.nextLine();
		}

		this.parseString(contactEntry);
	}

	@Override
	void deleteRecord() {
		// TODO Auto-generated method stub
		System.out.println("\nEnter the telephone number of the contact you would like to delete");
		Scanner lineReader = new Scanner(System.in);

		String contactEntry = "";
		if (lineReader.hasNextLine()) {
			contactEntry = lineReader.nextLine();
		}

		this.phoneNumber = contactEntry.trim();
	}

	public void loadRecord(Contact[] contactList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < contactList.length; i++) {
			if (contactList[i].getPhoneNumber().contentEquals(this.phoneNumber)) {
				this.firstName = contactList[i].getFirstName();
				this.middleName = contactList[i].getMiddleName();
				this.lastName = contactList[i].getLastName();
				this.address = contactList[i].getAddress();
				this.phoneNumber = contactList[i].getPhoneNumber();
			}
		}
	}

	public Contact[] findRecord(Contact[] contactList) {
		// TODO Auto-generated method stub
		Contact[] cl = new Contact[0];

		int inputNum = DisplayMenu.searchByItem();
		switch (inputNum) {
		case 1:{
			cl = DataLogic.findRecords(contactList, DataLogic.getUserInputString(), inputNum);
			break;
		}
		case 2:{
			cl = DataLogic.findRecords(contactList, DataLogic.getUserInputString(), inputNum);
			break;
		}
		case 3:{
			cl = DataLogic.findRecords(contactList, DataLogic.getUserInputString(), inputNum);
			break;
		}
		case 4:{
			cl = DataLogic.findRecords(contactList, DataLogic.getUserInputString(), inputNum);
			break;
		}
		case 5:{
			cl = DataLogic.findRecords(contactList, DataLogic.getUserInputString(), inputNum);
			break;
		}
		case 6:{
			cl = DataLogic.findRecords(contactList, DataLogic.getUserInputString(), inputNum);
			break;
		}
		case 7:{
			DisplayMenu.displayInitialMenu();
			break;
		}
		default:
			break;

		}

		return sortRecords(cl);

	}

	@Override
	public void parseString(String str) {

		String[] data = str.split(",");
		
		String[] tempName = data[0].split(" ");
		this.firstName = tempName[0];
		this.lastName = tempName[tempName.length - 1];
		
		this.middleName = "";
		for (int i = 1; i < tempName.length - 1; i++) {
			this.middleName += tempName[i];
			if (i != tempName.length - 2) {
				this.middleName += " ";
			}
		}
		
//		this.firstName = data[0].split(" ")[0].trim();
//		this.lastName = data[0].replaceAll(this.firstName, "").trim();
		this.address.parseString(str);
		this.phoneNumber = data[5].trim();

	}

	public static Contact[] sortRecords(Contact[] contactList) {
		
		int n = contactList.length; 
		  
        for (int i = 0; i < n-1; i++) 
        { 
            int min_i = i; 
            for (int j = i+1; j < n; j++) {
                if (isLowerAlphabetically(contactList[j], contactList[min_i])) {
                    min_i = j; 
                }
            }
            Contact tempContact = contactList[min_i]; 
            contactList[min_i] = contactList[i]; 
            contactList[i] = tempContact; 
        }   
        return contactList;
	    }

	private static boolean isLowerAlphabetically(Contact holder, Contact contact) {
		// if contact is lower return true
		char[] con = (contact.lastName).toCharArray();
		char[] hold = (holder.lastName).toCharArray();

		for (int i = 0; i < con.length; i++) {
			if (con[i] < hold[i]) {
				return false;
			}
		}

		return true;

	}

	public static String formatPhoneNumber(String str) {
		char[] n = str.trim().toCharArray();
		return "(" + n[0] + n[1] + n[2] + ")-" + n[3] + n[4] + n[5] + "-" + n[6] + n[7] + n[8] + n[9];
	}

	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
