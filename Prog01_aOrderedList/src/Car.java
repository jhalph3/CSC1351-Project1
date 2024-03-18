/**
* This class contains the constructor for creating a Car object with the attributes make, year, and
* price. There are also methods to access each of the class's attributes, a compareTo method that
* compares two Car objects and returns -1, 0, or 1, and a toString method that prints out the
* make, year, and model of a Car object in a specified format.
*
* CSC 1351 Programming Project No. 1a
7
* Section 2
*
* @author Jacob Halphen
* @since 17 March 2024
*
*/
public class Car implements Comparable<Car>{
	private String make;
	//Used to store the make of a Car object
	private int year;
	//Used to store the year of a Car object
	private int price;
	//Used to store the price of a Car object
	
	public Car(String make, int year, int price) {
		this.make = make;
		this.year = year;
		this.price = price;
	}
	/**
	* Returns the make of a Car object.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public String getMake() {
		return make;
	}
	/**
	* Returns the year of a Car object.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public int getYear() {
		return year;
	}
	/**
	* Returns the price of a Car object.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public int getPrice() {
		return price;
	}
	/**
	* This method compares two Car objects first based on make, then year if the make comparison
	* equals 0. If the comparison returns -1, the inputed object goes before the compared object
	* in the list of objects.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public int compareTo(Comparable<Car> other) {
		if(make.compareTo(other.make) != 0) {
			return make.compareTo(other.make);
		}
		else {
			return Integer.compare(year, other.year);
		}
	}
	/**
	* This method returns a specified String line containing the make, year, and price of a Car
	* object in a specific format.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public String toString() {
		return ("Make: " + make + ", Year: " + year + ", Price: " + price + ";");
	}
}
