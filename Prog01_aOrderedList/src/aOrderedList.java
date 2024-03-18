import java.util.Arrays;

/**
* This class contains the constructor for creating an aOrderedList object that contains a list of
* any kind of object with the list, list size, and number of objects in the list as attributes.
* The add method adds a comparable object to the list in an aOrderedList object in the correct
* index based on sorting. The size method returns the number of objects in the list of an
* aOrderedList object, the get method returns the object in a specified index of the list of an
* aOrderedList object, and isEmpty returns true or false depending on if the list of an
* aOrderedList object is empty or not. The remove method removes an object on the specified
* index of the aOrderedList's list of objects, reset sets the iterator's index of focus back to
* index zero of the aOrderedList's list of objects, and next sets the iterator to the next index
* and returns the object of that new index. The hasNext method returns true or false as to
* whether there is an object in the index after where the iterator is or not in the aOrderedList's
* list of objects, the other remove method removes an object at the index the iterator is at in
* the list of the aOrderedList object, and the toString method returns all of the attributes of
* each object of the aOrderedList's list in a specified format.
*
* CSC 1351 Programming Project No. 1a
7
* Section 2
*
* @author Jacob Halphen
* @since 17 March 2024
*
*/
public class aOrderedList <T> {
	final int  SIZEINCREMENTS = 20;
	//Is used to add 20 to the array of objects of an aOrderedList object.
	private Comparable<T>[] oList;
	//Is used to store a list of objects in an aOrderedList object.
	private int listSize;
	//Is used to store the value of the list of objects' size of an aOrderedList object.
	private int numObjects;
	//Is used to store the value of the number of objects in the list of objects of an
	//aOrderedList object.
	private int curr;
	//is used to increment through the indexes of the list of objects on an aOrderedList object.
	
	public aOrderedList(Comparable<T>[] oList, int listSize, int numObjects) {
		this.oList = oList;
		this.listSize = listSize;
		this.numObjects = numObjects;
	}
	/**
	* This method adds a comparable object into the list of objects of an aOrderedList object in
	* a specific index to keep the list sorted.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public void add(Comparable<T> newObject) {
		curr = 0;
		if(oList[listSize - 1] != null) {
			Comparable<T>[] newOList = Arrays.copyOf(oList, oList.length + SIZEINCREMENTS);
			oList = newOList;
			listSize += 20;
		}
		while(newObject.getMake().compareTo(oList[curr].getMake()) > -1) {
			if(newObject.getMake().compareTo(oList[curr].getMake()) == 0) {
				if(Integer.compare(newObject.getYear(), oList[curr].getYear()) == 0) {
					if(Integer.compare(newObject.getPrice(), oList[curr].getPrice()) == -1) {
						oList[curr + 1] = oList[curr];
						oList[curr] = newObject;
						return;
					}
					else {
						oList[curr + 1] = newObject;
						return;
					}
				}
				else if(Integer.compare(newObject.getYear(), oList[oIndex].getYear()) == -1) {
					oList[curr + 1] = oList[curr];
					oList[curr] = newObject;
					return;
				}
				else {
					oList[curr + 1] = newObject;
					return;
				}
			}
			else if(newObject.getMake().compareTo(oList[curr].getMake()) == 1) {
				oList[curr + 1] = newObject;
				return;
			}
			curr++;
		}
		if(newObject.getMake().compareTo(oList[curr].getMake()) == -1) {
			oList[curr + 1] = oList[curr];
			oList[curr] = newObject;
		}
	}
	/**
	* This method returns the number of objects in the list of an aOrderedList object.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public int size() {
		return numObjects;
	}
	/**
	* This method returns the object at a specified index of the list of objects of the
	* aOrderedList object.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public Comparable<T> get(int index) {
		return oList[index];
	}
	/**
	* This method return true or false depending on whether the list of objects in an
	* aOrderedList is empty or not.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public boolean isEmpty() {
		if(oList.length == 0 || oList[0] == null) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	* This method removes an object at a specified index of the list of objects in an
	* aOrderedList object and shifts the other objects accordingly.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public void remove(int index) {
		for(int i = index; i < oList.length; i++) {
			if(i != (oList.length - 1)) {
				oList[i] = oList[i + 1];
			}
			else {
				oList[i] = null;
			}
		}
	}
	/**
	* This method returns the iterator of the list of objects of the aOrderecList object back
	* to index 0.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public void reset() {
		curr = 0;
	}
	/**
	* This method brings the iterator of the list of objects of an aOrderedList object forward
	* one index and returns the object in that index.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public Comparable<T> next(){
		curr++;
		return oList[curr];
	}
	/**
	* This method returns true or false depending on whether the list of objects of an
	* aOrderedList object has an object in the index after the where the iterator is in the list
	* or not.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public boolean hasNext() {
		if(curr < numObjects - 1) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	* This method removes the object at the index the iterator is at in the list of the
	* aOrderedList object and shifts the object accordingly.
	*
	* CSC 1351 Programming Project No. 1a
	7
	* Section 2
	*
	* @author Jacob Halphen
	* @since 17 March 2024
	*
	*/
	public void remove() {
		remove(curr);
	}
	/**
	* This method prints out the attributes of each object in the list of an aOrderedLisy object
	* in a specific format.
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
		return "[" + oList.toString() + "]";
	}
}
