package src;
//Qingtian Mei
//frankmei@brandeis.edu
//02, 12, 2019
//PA1
/* This class is a Train Object class, containing all the method and constructor for building a train object. The train class will be implement by an array. This will be stimulated as a data structure that shift the riders  */
/* Known Bugs: None */


public class Train {
	 final int TOTAL_PASSENGERS = 10;
	 Rider[] passengers;
	 String currentStation;
	 int direction;
	 int passengerIndex;
	 String removedPassenger;// only for printing the runLog,so I am creating a new String;
	 
	/**
	 * This is a constructor that takes in the station of that the station current in. And the direction of the train.
	 * @param currentStation This is the currentStation of the train.
	 * @param direction	This is the direction of the train
	 * Time Complexity: O(1)
	 */
	public Train(String currentStation, int direction) {
		this.direction = direction;
		this.currentStation = currentStation;
		this.passengers = new Rider[10];
		passengerIndex= 0;
		//TODO
	}
	
	/**
	 * This method will return the direction of the train. 
	 * @return Integer direction of the train.
	 * Time Complexity: O(N)
	 */
	public int getDirection(){
		//TODO
		return this.direction;
	}
	
	/**
	 * This method will change the direction of the train.
	 * @param direc This is the direction that the train will be changed.
	 * Time Complexity: O(1)
	 */
	public void setDirection(int direc) {
		this.direction= direc;
		//TODO 
	}
	
	/**
	 * This method will return all the current passengers that stay in the train.
	 * @return This is the name of the current passengers.
	 *O(1) or O(N) depending on whether considering the length of array, constant or N.
	 */
	public String currentPassengers() {
		//TODO
		String printout ="";
		for(int i =0;i<passengers.length;i++) {
			if(passengers[i]!=null) {
				printout = printout + passengers[i].toString()+"\n";
			}
		}
		return printout;
	}
	
	/**
	 * This method will receive a rider and add the rider into the train. Then return whether it is successful to return the string.  
	 * @param The rider that is ask to be add in.
	 * @return Whether the rider is successully added in.
	 * Time Complexity: O(1) or O(N) depending on whether considering the length of array, constant or N.
	 */
	public boolean addPassenger(Rider r) {
		//TODO
		if(r.direction != this.direction || !r.startingStation.equals(this.currentStation)) {
			return false;
		}
		for(int i = 0; i<passengers.length;i++) {
			if(	this.passengers[i] == null) {
				this.passengers[i] = r;
				this.passengerIndex++;
				return true;
			}
		}
		return false;
	}

	/**
	 * This method will return whether it is still allowed to add more riders.
	 * @return boolean statement whether is is still allowed to add more riders.
	 * Time Complexity: O(N)
	 */
	
	public boolean canAddPassenger() {
		//TODO
		if(this.passengerIndex<10) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method removes a rider from the station S, and return the name of the riders that being removed. 
	 * @param s This is the station that they will be removed. 
	 * @return It will return the name of the people who is removed from the queue. 
	 * O(1) or O(N) depending on whether considering the length of array, constant or N.
	 */
	public String removePassenger(Station s) {
		//TODO
		String result ="";
		for(int i = 0; i<passengers.length;i++) {
			if(passengers[i]!=null) {
				if(passengers[i].destinationStation.equals(s.stationName())) {
					result = result + passengers[i].toString();
					passengers[i] = null;
					this.passengerIndex--;
				}
			}
		}
		this.removedPassenger = result;
		return result;
	}
	
	
	/**
	 * This method will update the current station that the train is at. 
	 * @param s This string is what the current station name will be.
	 * Time Complexity: O(1)
	 */
	public void updateStation(String s) {
		//TODO
		this.currentStation = s;
	}
	
	/**
	 * This method will return the station name of the current station.
	 * @return the current station name. 
	 * Time Complexity: O(1)
	 */
	public String getStation() {
		//TODO
		return this.currentStation;
	}
	
	/**
	 * This method will return the string of the current station and passengers.
	 * @return The string of the combination.
	 * Time Complexity: O(1)
	 */
	public String toString() {
		//TODO
		String result = "";
		String direction;
		if(this.direction == 1) {
			direction = "Southbound";
		}else {
			direction = "Northbound";
		}
		result = this.getStation() + " Disembarking Passengers: "+ this.removedPassenger+"\n"+"Direction: "+ direction + "\n" +"Passengers: " + this.currentPassengers()+ "\n"+"Current Station: "+this.currentStation;
		return result;
	}
}
