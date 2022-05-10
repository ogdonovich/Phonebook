package phoneBook;

public class Address {
	private int number;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	
	public Address() {}
	
	public void parseString(String str) {
		String[] data = str.split(",");
		this.number = Integer.parseInt(data[1].trim().split(" ")[0]);
		String tempStreet = this.street = data[1].trim().replaceAll("[0-9]+", "");
		
		//this.street = tempStreet.trim().split(" ")[1];
		this.street =  tempStreet.trim();
		this.city = data[2].trim();
		this.state = data[3].trim();
		this.zipcode = data[4].trim();
		
//		System.out.println(this.number);
//		System.out.println(this.street);
	}
	
	public String display() {
		String display = this.number + " " + this.street + "\n"
				+ this.city + ", " + this.state + " " + this.zipcode;
		return display;
	}
	
	public void updateAddress() {
		
		switch (DisplayMenu.updateAddress()) {
		case 1:
			this.number = Integer.parseInt(DataLogic.getUserInputString().trim());
			break;
		case 2:
			this.street = DataLogic.getUserInputString().trim();
			break;
		case 3:
			this.city = DataLogic.getUserInputString().trim();
			break;
		case 4:
			this.state = DataLogic.getUserInputString().trim();
			break;
		case 5:
			this.zipcode = DataLogic.getUserInputString().trim();
			break;
		case 6:
			DisplayMenu.displayInitialMenu();
			break;
		default:
			break;
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
