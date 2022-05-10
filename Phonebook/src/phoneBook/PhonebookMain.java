package phoneBook;

public class PhonebookMain {

	public static void main(String[] args) {
		Contact[] contactList = new Contact[0];

		Contact contact = new Contact();
		Address address = new Address();
		contact.setAddress(address);

		boolean run = true;

		while (run) {

			switch (DisplayMenu.displayInitialMenu()) {
			case 1: {// Add a record
				try {
					Contact newContact = new Contact();
					newContact.setAddress(new Address());
					newContact.saveRecord();
					contactList = DataLogic.addRecordToArray(newContact, contactList);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error Please try again");
				}
				break;
			}
			case 2: {// Delete a record
				try {
					contact.deleteRecord(); // Locate a record to delete
					contactList = DataLogic.deleteRecordFromArray(contact, contactList);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error Please try again");
				}
				break;
			}
			case 3: {// Update a record
				try {
					contact.updateRecord(contactList);
					contactList = DataLogic.deleteRecordFromArray(contact, contactList);
					contactList = DataLogic.addRecordToArray(contact, contactList);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error Please try again");
				}
				break;
			}
			case 4: {// Find a record - first, last, city, state, number

				try {
					Contact[] foundContacts = contact.findRecord(contactList);
					for (Contact c : foundContacts) {
						c.display();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error Please try again");
				}
				break;
			}
			case 5: {// Show all records
				//System.out.println(contactList.length);
				try {
					contactList = Contact.sortRecords(contactList);
					for (Contact c : contactList) {
						c.display();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error Please try again");

				}
				break;
			}
			case 6: {// Exit
				run = false;
				break;
			}

			default:
				DisplayMenu.clearScreen();
				run = true;
				break;
			}

		}

	}

}
