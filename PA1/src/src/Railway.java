package src;
//Qingtian Mei
//frankmei@brandeis.edu
//02, 12, 2019
//PA1
/* This class is a Railway Object class, containing all the method and constructor for building a railway */
/* Known Bugs: the constructor without a parameter will create empty double linked list */

public class Railway {
	 DoubleLinkedList<Station> railway;
	 String[] stations;
	 int stationIndex;
/**
 * This constructor does not need a parameter. It will contains a empty double linked list.
 * Time Complexity : O(1)
 */
	public Railway(){
		//TODO
		this.railway = new DoubleLinkedList<Station>();
		this.stationIndex = 0;
		stations = new String[18];
	}
	
/**
 * The method takes in station parameter and add to the linkedlist and record the station index;
 * @param s a station parameter
 * Time complexity: O(1)
 */
	public void addStation(Station s) {
		//TODO
	    Node<Station> tail = railway.insert(s);
	    stations[stationIndex] = s.name;
	    stationIndex++;
	}
	
/**
 * This method receives a rider and add the rider into the Rider array.
 * @param rider r that will be put into the array.
 * Time Complexity: O(1) or O(N) depending on whether considering the length of array, constant or N.
 * @throws Exception The queue is already full.
 */
	public void addRider(Rider r) throws Exception {
		Station check = new Station(r.startingStation);
		Station place = this.railway.get(check);
		r.setDirection(this.calcStation(r.startingStation, r.destinationStation));
		place.addWaitingRider(r);
		//TODO
	}
	
/**
 * This method receives a train and add the train into the train array.
 * @param train t that will be put into the array.
 * Time Complexity: O(1) or O(N) depending on whether considering the length of array, constant or N.
 * @throws Exception The queue is full
 */
	public void addTrains(Train t) throws Exception {
		Station check = new Station(t.currentStation);
		Station result = railway.get(check);
		result.addTrainToStation(t);
		//TODO
	}
	
/**
 * This method is to calculate the distance between station 1 and station 2, to determine the direction of the rider;
 * @param station1 the startingdestination for the passenger
 * @param station2 the destinationstation for the passenger
 * @return the direction of the which way the rider should go. 
 * Time complexity: O(1) or O(N) depending on whether considering the length of array, constant or N.// Even though there is a for loop, the size of the loop is constant in 20, so the running time should a constant. 
 */
	public int calcStation(String station1, String station2) {
		//TODO
		int start = 0;
		int end = 0; 
		for(int i = 0; i<stationIndex;i++) {
			if(stations[i].equals(station1)) {
				start = i;
			}
			if(stations[i].equals(station2)) {
				end = i;
			}
		}
		int result = end - start;
		if(result >0) {
			result = 1;
		}else {
			result = 0;
		}
		return result;
	}
	
/**
 * This method is core for the entire program. This program goes from the beginning of the railway, and go down the railway, by going through the entire double linkedlist from the head to tail. It will shift and turn the trains, and remove and add the passengers by calling other methods accordingly. Then, it also return the what the movement has been down in the end using an array.
 * @return The running history, or what the program has done to the stations and the trains by string. 
 * @throws Exception The queues could be full or empty.
 * Time Complexity: O(1) or O(N^4) depending on whether considering the length of array, constant or N.
 */
	public String simulate() throws Exception {
		//TODO
		String runLog = "";
		Node<Station> pointer = new Node();
		pointer = this.railway.head;
		while(pointer!=null) {
			Station currentStation = pointer.element;
			runLog = runLog+"\n"+ currentStation.toString()+"\n\n";
			if(pointer== this.railway.head) {
				if(!currentStation.northBoundTrains.isEmpty()) {
					currentStation.moveTrainNorthToSouth();
				}else if (!currentStation.southBoundTrains.isEmpty()) {
					Train t = currentStation.southBoardTrain();
					pointer.next.element.addTrainToStation(t);
					runLog = runLog + "\n" + t.toString();
				}
			}else if(pointer == this.railway.tail) {
				if(!currentStation.southBoundTrains.isEmpty()) {
					currentStation.moveTrainSouthToNorth();
				}else if (!currentStation.northBoundTrains.isEmpty()) {
					Train t = currentStation.northBoardTrain();
					pointer.prev.element.addTrainToStation(t);
					runLog = runLog + "\n" + t.toString();
				}
				return runLog;
			}else {
				if(!currentStation.northBoundTrains.isEmpty()) {
					Train t = currentStation.northBoardTrain();
					pointer.prev.element.addTrainToStation(t);
					runLog = runLog + "\n" + t.toString();
				}
				if(!currentStation.southBoundTrains.isEmpty()) {
					Train t = currentStation.southBoardTrain();
					pointer.next.element.addTrainToStation(t);
					runLog = runLog + "\n" + t.toString();
				}
			}
			pointer = pointer.next;
		}
		return runLog;
	}
	/**
	 * This method will return the railway as the content from the double linkedlist;
	 *@return the string created by the double linkedlist. 
	 * Time Complexity: O(1) or O(N) depending on whether considering the length of array, constant or N.
	 */
	public String toString() {
		//TODO
		return this.railway.toString();
	}
}
