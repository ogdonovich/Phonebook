package phoneBook;

import java.util.Scanner;



public abstract class DataLogic {
	
	abstract void saveRecord(); // Saves a record to the file

	abstract void deleteRecord(); // Deletes a record

	public static int getIntInput() {
		int choice = '@';
		try {
			Scanner input = new Scanner(System.in);

			// System.out.println("E");
			boolean hasNext = true;
			while (hasNext) {


				if (input.hasNext()) {
					choice = input.nextInt();
					// System.out.println(choice);
					hasNext = false;

				} else {
					System.out.println("Error enter a number option.");
				}
			}

			
			return choice;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error Please enter a number");
			getIntInput();

		}
		return choice;
	}

	abstract void parseString(String str); // Parses a string to save or load a record

	public static Contact[] findRecords(Contact[] contactList, String searchTerm, int searchBy) {
		Contact[] c = new Contact[0];

		for (Contact contact : contactList) {
			String searchable = "";
			
			switch (searchBy) {
			case 1: {
				searchable = contact.getFirstName();
				break;
			}
			case 2: {
				searchable = contact.getLastName();
				break;
			}
			case 3: {
				searchable = contact.getFirstName() + " " + contact.getMiddleName() + " " + contact.getLastName();
				break;
			}
			case 4: {
				searchable = contact.getPhoneNumber();
				break;
			}
			case 5: {
				searchable = contact.getAddress().getCity();
				break;
			}
			case 6: {
				searchable = contact.getAddress().getState();
				break;
			}
			default:
				break;
			}
			//System.out.println(searchable);

			if (searchable.equalsIgnoreCase(searchTerm.trim())) {
				c = addRecordToArray(contact, c);
				
			}
		}
		
		

		return c;
	}

	public static String getUserInputString() {
		System.out.println("\nEnter your input below");
		Scanner lineReader = new Scanner(System.in);

		String contactEntry = "";
		if (lineReader.hasNextLine()) {
			contactEntry = lineReader.nextLine();
		}
		return contactEntry;
	}

	public static Contact[] addRecordToArray(Contact contact, Contact[] contactList) {
		int i;
		int n = contactList.length;

		Contact[] newContactList = new Contact[n + 1];

		for (i = 0; i < n; i++) {
			newContactList[i] = contactList[i];
		}
		newContactList[n] = contact;

		return newContactList;
	}

	public static Contact[] deleteRecordFromArray(Contact contact, Contact[] contactList) {
		int i;
		int n = contactList.length;

		Contact[] newContactList = new Contact[n - 1];

		for (i = 0; i < n; i++) {
			if (!contactList[i].getPhoneNumber().equals(contact.getPhoneNumber())) {
				newContactList[i] = contactList[i];
			}
		}

		return newContactList;
	}

}
