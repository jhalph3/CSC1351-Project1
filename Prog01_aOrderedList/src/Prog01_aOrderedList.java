//Name: Jacob Halphen
//Student ID: 895454015
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.PrintWriter;

/**
* This class contains the main method where Car and aOrderedList objects are created and modified,
* a getInputFile method that takes in user input, validates it, and creates a Scanner object to read
* the input.txt file, and a GetOutPutFile method that takes in user input, validates it, and creates
* a PrintWriter object to allow for the ability to create and write in a new file.
*
* CSC 1351 Programming Project No. 1a
7
* Section 2
*
* @author Jacob Halphen
* @since 17 March 2024
*
*/
public class Prog01_aOrderedList {
	private int curr;
	//Is used to iterate through the list of objects of an aOrderedList object.
	
	/**
	* This method creates and modifies objects of the Car and aOrderedList classes.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public void main(String[] args) throws FileNotFoundException {
		Scanner read = getInputFile("inputfile.txt");
		PrintWriter write = GetOutPutFile("outputfile.txt");
		
		Car[] theList = new Car[20];
		int numObjects = 0;
		aOrderedList<Car> carList = new aOrderedList<Car>(theList, theList.length, numObjects);
		
		while(read.hasNextLine()) {
			String carLine = read.nextLine();
			String carMake = "";
			int carYear = 0;
			int carPrice = 0;
			curr = 2;

			if(carLine.charAt(0) == 'A') {
				while(carLine.charAt(curr) > 57) {
					carMake = carMake + carLine.substring(curr, curr + 1);
					curr++;
				}
				
				carYear = Integer.parseInt(carLine.substring(curr, curr + 4));
				carPrice = Integer.parseInt(carLine.substring(curr + 4));
				Car carObject = new Car(carMake, carYear, carPrice);
				carList.add(carObject);
				numObjects++;
			}
			else if(carLine.charAt(0) == 'D') {
				if(Integer.parseInt(carLine.substring(curr, curr + 1)) % 2 >= 0) {
					int theIndex = Integer.parseInt(carLine.substring(curr, curr + 1));
					Comparable<Car> deletedCar = carList.get(theIndex);
					carList.remove(theIndex);
				}
				else {
					String theMake = carLine.substring(curr, carLine.length() - 5);
					int theYear = Integer.parseInt(carLine.substring(carLine.length() - 4));
					Comparable<Car> deletedCar = new Car(theMake, theYear, 0);
					for(int l = 0; l < carList.size(); l++) {
						if(deletedCar.compareTo(carList.get(l)) == 0) {
							carList.remove(l);
						}
					}
				}
			}
			
			System.out.printf("Number of cars:\t%d\n\n", carList.size());
			for(int i = 0; i < carList.size(); i++) {
				Comparable<Car> carInList = carList.get(i);
				System.out.printf("Make:\t%s\n\n", carInList.getMake());
				System.out.printf("Year:\t%d\n\n", carInList.getYear());
				System.out.printf("Price:\t$%,d\n\n", carInList.getPrice());
			}
		}
	}
	/**
	* This method returns a Scanner object that can read a File object of the validated input of
	* a user.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public Scanner getInputFile(String UserPrompt) throws FileNotFoundException{
		File inputFile = new File(UserPrompt);
		Scanner promptName = new Scanner(System.in);
		while(!promptName.nextLine().equals(UserPrompt)) {
			System.out.print("Enter input filename: ");
			if(promptName.nextLine().equals(UserPrompt)) {
				Scanner input = new Scanner(inputFile);
				return input;
			}
			else {
				System.out.println("File specified <" + promptName.nextLine() + "> does not exist. Would you like to continue? <Y/N> ");
				String yesNo = promptName.nextLine();
				if(yesNo.toUpperCase().equals("N")) {
					promptName.close();
					throw new FileNotFoundException();
				}
			}
		}
		promptName.close();
		return null;
	}
	/**
	* This method returns a PrintWriter object that creates a writable file according to the
	* validated user input.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public PrintWriter GetOutPutFile(String UserPrompt) throws FileNotFoundException {
		Scanner promptName1 = new Scanner(System.in);
		File outPutFile = new File(UserPrompt);
;		while(!promptName1.nextLine().equals(UserPrompt)) {
			System.out.print("Enter output filename: ");
			if(promptName1.nextLine().equals(UserPrompt) && outPutFile.canWrite()) {
				PrintWriter outPut = new PrintWriter(UserPrompt);
				Scanner promptFile = new Scanner(outPutFile);
				promptFile.close();
				return outPut;
			}
			else {
				System.out.println("File specified <" + promptName1.nextLine() + "> is not a valid file name. Would you like to continue? <Y/N> ");
				String yesNo = promptName1.nextLine();
				if(yesNo.toUpperCase().equals("N")) {
					promptName1.close();
					throw new FileNotFoundException();
				}
			}
		}
		promptName1.close();
		return null;
	}
}
