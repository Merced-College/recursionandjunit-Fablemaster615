//Ashton Jantz
//Kevin Leuthold :)
// Adam Lopes
//Anthony Rocci
//
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class StarbucksDataProgram {

	//arraylist
	public static ArrayList<StarbucksRecord> records = new ArrayList<StarbucksRecord>();

	public static void main(String[] args) {
		//read in our data and create this records Arraylist
		//read in our data and put it in an arraylist
		Scanner input = null;
		try {
			input = new Scanner(new File("StarbucksInCalifornia.csv"));
		} catch (FileNotFoundException e) {
			//file not found
			System.out.println("file not found");
			e.printStackTrace();
		}

		//reading in the header
		input.nextLine();

		while(input.hasNext()) {
			String record = input.nextLine();
			String[] fields = record.split(",");
			//9128,100 West Portal/Vicente,Company Owned,(415) 664-8370,100 West Portal 941271306  San Francisco County California,San Francisco - San Francisco County,San Francisco County,941271306,37.739684-122.467323,California,http://maps.googleapis.com/maps/api/streetview?size=600x600&location=37.739684-122.467323&fov=90&heading=235&pitch=10,5:00 AM to 11:00 PM,5:00 AM to 11:00 PM,5:00 AM to 11:00 PM,No,Yes,Yes,No,No,Yes,Yes,Yes,No,No,http://www.starbucks.com/store/9128/us
			records.add(new StarbucksRecord(
					fields[0], //id
					fields[1], //name
					fields[2], //ownership
					fields[3], //phoneNumber
					fields[4], //address
					fields[5], //city
					fields[6], //county
					fields[7], //zip
					fields[8], //coordinates
					fields[9], //state
					fields[10], //image
					fields[11], //regularHours
					fields[12], //saturdayOpeningHours
					fields[13], //sundayOpeningHours
					fields[14], //twentyFourHourService
					fields[15], //hasCloverCoffee
					fields[16], //hasWarmFood
					fields[17], //hasFreeWifi
					fields[18], //hasVerismoSystem
					fields[19], //hasMobilePay
					fields[20], //hasDigitalRewards
					fields[21], //hasLaBoulange
					fields[22], //hasFizzioSoda
					fields[23], //hasDriveThru
					fields[24])); //link

		}

		//for(int i = 0; i < records.size(); i++) {
		// 	//System.out.println(records.get(i));
		//}

		System.out.print("the number of Starbucks records with licensed is ");
		System.out.println(countOwnershipLicensed());
		System.out.println(countOwnershipLicensed("Merced County"));

		// Calculate percentage of stores closed on Saturdays
        double closedSaturdayPercentage = calculateClosedPercentage("Saturday");
        System.out.printf("Percentage of Starbucks closed on Saturdays: %.2f%%\n", closedSaturdayPercentage);
		
		System.out.println("Number of Starbucks open 24 hours within California: " + TwentyFourHrStarbucks());
		System.out.println("Number of locations that serve Clover Coffee but do not have Verismo Systems: " + countBoujeeCoffeeNoVerismo());
		
		System.out.println("Number of locations that are within 2 miles of another location: " + countRedundant());
	}//end main

	//return the number of Starbucks records that
	// have a given Ownership 
	//type of "Licensed"
	public static int countOwnershipLicensed()  {
		int count = 0;
		for(int i = 0; i < records.size(); i++) {
			if(records.get(i).getOwnership().equals("Licensed"))
				count++;
		}

		return count;
	}

	//How many Starbucks are closed on Saturdays?
	public static double calculateClosedPercentage(String day) {
        int closedCount = 0;
        int totalRecords = records.size();

        for (StarbucksRecord record : records) {
            String openingTime = day.equals("Saturday") ? record.getSaturdayOpenTime() : record.getSundayOpenTime();
            // Assuming "Closed" indicates the store is not open
            if (openingTime.equalsIgnoreCase("Closed") || openingTime.trim().isEmpty()) {
                closedCount++;
            }
        }

        return totalRecords > 0 ? (closedCount / (double) totalRecords) * 100 : 0;
    	
	}	
	//How many Starbucks are within 2 miles of each other?
	public static int countRedundant(){
		double[] coords = {0, 0};
		double[] lastCoord = {0,0}; //Private Variables
		int count = 0;
		for (int i = 0; i < records.size(); i++){
			String coordString[] = records.get(i).getCoordinates().split("-"); //Split up coords and parse into Int
			coords[0] = Double.parseDouble(coordString[0]); //Longitude
			coords[1] = Double.parseDouble(coordString[1]); //Latitude
			if((Math.abs(lastCoord[0] - coords[0]) < 0.1 )||(Math.abs(lastCoord[1] - coords[0]) < 0.1)){ 
				count++;	//Count each Starbucks within 2 miles of another
			}
			lastCoord[0] = coords[0];	//Set previous coords to compare
			lastCoord[1] = coords[1];
		}
		return count;
	} 


	// How many Starbucks are open for 24 hrs in a state?
	public static int TwentyFourHrStarbucks (){
		int count = 0; 
		for( int i = 0; i < records.size(); i++ ){
			if(records.get(i).getTwentyFourHourService())
				count++;
			}
			return count;
		}

	//return the number of Starbucks records that
	//are in a certain County and have a given Ownership 
	//type of "Licensed" //overloading your method
	public static int countOwnershipLicensed(String county)  {
		int count = 0;
		for(int i = 0; i < records.size(); i++) {
			if(records.get(i).getState().equals(county))
				if(records.get(i).getOwnership().equals("Licensed"))
					count++;
		}

		return count;
	}

	//How many Starbucks serve Starbucks Reserve Clover coffee, but do NOT have a Verismo system.
	public static int countBoujeeCoffeeNoVerismo(){
		int count = 0;
		for(int i = 0; i < records.size(); i++){
			if(records.get(i).getHasCloverCoffee() && !records.get(i).getHasVerismoSystem()) {
				count++;
			}
		}
		return count;
	}

}//end class
