package src;
//Qingtian Mei
//frankmei@brandeis.edu
//02, 12, 2019
//PA1
/* This class is a Rider Object class, containing all the method and constructor for building a Rider. This class contains all the property that a rider has,and the rider can wait on the train station and in the train */
/* Known Bugs */

public class Rider {
	 String riderID;
	 String startingStation;
	 String destinationStation;
	 int direction;
	 
	/**
	 * This constructor takes in three parameters to build this object;
	 * @param riderID This is the Rider Id of the object. 
	 * @param startingStation This is the startingStation for this object.
	 * @param destinationStation This is the destinationStation for this object.
	 * Time Complexity : O(1)
	 */
	public Rider(String riderID, String startingStation, String destinationStation) {
		//TODO
		this.riderID = riderID;
		this.startingStation = startingStation;
		this.destinationStation = destinationStation;
	    direction = 0;
	}
	
	/**
	 * This is the method return the startingDestination of the object.
	 * @return A string object that get the starting station of the object. 
	 * Time Complexity: O(1)
	 */
	public String getStarting() {
		//TODO
		return this.startingStation;
	}
	
	/**
	 * This method will return the Destination of the object;
	 * @return return the name of the station
	 * Time Complexity: O(1)
	 */
	public String getDestination() {
		//TODO
		return this.destinationStation;
	}
	
	/**
	 * this method will return the name of the object. 
	 * @return a string of the rider name. 
	 * Time Complexity O(1)
	 */
	public String getRiderID() {
		//TODO
		return this.riderID;
	}
	
	/**
	 * this method will return a integer value that indicate the direction of the rider.
	 * @return the integer value of that station.
	 * Time Complexity: O(1)
	 */
	public int getDirection() {
		//TODO
		return this.direction;
	}
	
	/**
	 * This method change the direction of the rider from the parameter of the rider.
	 * @param direc This is the direction of the rider.
	 * Time Complexity: O(1)
	 */
	public void setDirection(int direc) {
		//TODO
		this.direction = direc;
	}
	
	
	/**
	 * This method return the string of the rider. 
	 * Time Complexity: O(1)
	 */
	public String toString() {
		//TODO
		String result = this.getRiderID()+", "+ this.destinationStation;
		return result;
	}
	
	/**
	 * This method return the result whether the Object s is same with the RiderID.
	 * @param Object s that will compare with the riderID.  
	 * Time Complexity: O(1)
	 */
	@Override
	public boolean equals(Object s) {
		//TODO
		
		return s.equals(this.riderID);
	}
}
