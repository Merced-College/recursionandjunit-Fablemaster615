//if you need a package in your IDE you will need this code, otherwise get rid of it
//package starbucksDataProjects;
//make sure to write your name(s) at the top
//the date 
//and what this class is

//Anthony Rocci
//09|19|2024
//CPSC-39

public class StarbucksRecord {
	
	//ID,Name,Ownership Type,Phone Number,
	//Address,City,County,Zip,Coordinates,State,
	//Image,Regular hours,Saturday Openint TImes,
	//Sunday Opening Times,
	//24-Hour Service,Starbucks Reserve-Clover Brewed,Oven-Warmed Food,Free Wi-Fi,Verismo System,Mobile Payment,Digital Rewards,La Boulange,Fizzio Handcrafted Sodas,Drive-Thru,Link
	
	//put your private instance variables here

	//make your default contructor here

	//the header for the non-default constructor is given to you
	public StarbucksRecord(String id, String name, String ownership, String phone, String address, String city,
			String county, String zip, String coordinates, String state, String image, String regHours,
			String saturdayOpenTime, String sundayOpenTime, String twentyFourHourService) {
		
		//fill in this constructor and initialize the instance vars to the correct parameters
	}

	//make all of the setters and getters for all of your instance variables here

	//this toString method is given to you
	@Override
	public String toString() {
		return "StarbucksRecord [id=" + id + ", name=" + name + ", ownership=" + ownership + ", phone=" + phone
				+ ", address=" + address + ", city=" + city + ", county=" + county + ", zip=" + zip + ", coordinates="
				+ coordinates + ", state=" + state + ", image=" + image + ", regHours=" + regHours
				+ ", saturdayOpenTime=" + saturdayOpenTime + ", sundayOpenTime=" + sundayOpenTime
				+ ", twentyFourHourService=" + twentyFourHourService + "]";
	}

}
