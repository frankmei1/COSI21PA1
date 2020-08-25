package src;

//Qingtian Mei
//frankmei@brandeis.edu
//02, 12, 2019
//PA1
/* This class is a Station Object class, containing all the method and constructor for building a Station object. This station class will serve as a station that being on the railway class.It will be inplemented by queue*/
/* Known Bugs: None  */

public class Station {
	public String name;
	Queue<Rider> northWaiting;
	Queue<Rider> southWaiting;
	Queue<Train> northBoundTrains;
	Queue<Train> southBoundTrains;
	
	/**
	 *This is a constructor, receiving the station name, and create everything in the object to be set size.
	 * @param name The station name.
	 *  Time complexity: O(1)
	 */
	public Station(String name) {
		this.name = name;
		northWaiting = new Queue(10);
		southWaiting = new Queue(10);
		northBoundTrains = new Queue(20);
		southBoundTrains = new Queue(20);
		//TODO
	}
	
	/**
	 * This method will add the rider into the queue, depending the direction that the rider is trying to go. 
	 * @param r The rider that will be add. 
	 * Time complexity: O(1)
	 * @throws Exception This queue is already full.
	 */
	public void addWaitingRider(Rider r) throws Exception {
		int direction = r.direction;
		if(direction == 0) {
			northWaiting.enqueue(r);
		}
		if(direction == 1) {
			southWaiting.enqueue(r);
		}
		//TODO
	}
	
	/**
	 * This method will add the train to the station they want to be in.
	 * @param t The train that want to be add in.
	 * @return return the name of the train. 
	 * Time complexity: O(1)
	 * @throws Exception This queue is already full.
	 */
	public String addTrainToStation(Train t) throws Exception {
		//TODO
		int direction = t.direction;
		t.removePassenger(this);
		if(direction == 0) {
			northBoundTrains.enqueue(t);
			t.updateStation(this.stationName());
		}else{
			southBoundTrains.enqueue(t);
			t.updateStation(this.stationName());
		}
		return t.toString();
	}
	
	/**
	 * This method will return the train that from south bound train after being filled by the riders.,
	 * @return The filled train.
	 * Time Complexity: O(1) or O(N^2) depending on whether considering the length of array, constant or N.
	 * @throws Exception In case, the queue is full;
	 */
	public Train southBoardTrain() throws Exception {
		//TODO
		if(southBoundTrains.isEmpty()) {
			System.out.println("this south trains are empty already");
			return null;
		}
		Train result = this.southBoundTrains.dequeue();
		while(result.canAddPassenger()&& !southWaiting.isEmpty()) {
			Rider z = southWaiting.dequeue();
			result.addPassenger(z);
		}
		return result;
	}

	/**
	 * This method will return the train that from north bound train after being filled.
	 * @return The train being filled with passengers.
	 * O(1) or O(N^2) depending on whether considering the length of array, constant or N.
	 * @throws Exception In case, the queue is full;
	 */
	public Train northBoardTrain() throws Exception {
		//TODO
		if(northBoundTrains.isEmpty()) {
			return null;
		}
		Train result = this.northBoundTrains.dequeue();
		while(result.canAddPassenger()&& !northWaiting.isEmpty()) {
			Rider z = northWaiting.dequeue();
			result.addPassenger(z);
		}
		return result;
	}
	
	/**
	 * This move the train from north station to the south station after they reach to the end.
	 * Time Complexity: O(1)
	 * @throws Exception In case, the queue is full;
	 */
	public void moveTrainNorthToSouth() throws Exception {
		if(northBoundTrains.isEmpty()) {
			throw new Exception("there is no train on the North");
		}
		Train input= northBoundTrains.dequeue();
		input.setDirection(1);
		this.southBoundTrains.enqueue(input);
		//TODO
	}
	
	/**
	 * This move the train from south station to the north station after they reach to the end.
	 * Time Complexity: O(1)
	 * @throws Exception In case, the queue is full;
	 */
	public void moveTrainSouthToNorth() throws Exception {
		if(southBoundTrains.isEmpty()) {
			throw new Exception("there is no train on the South");
		}
		Train input= southBoundTrains.dequeue();
		input.setDirection(0);
		northBoundTrains.enqueue(input);
		//TODO
	}
	/**
	 * This method will return all the string of the field in the object.
	 * @return The String that being returned.
	 * Time Complexity: O(1) 
	 */
	public String toString() {
		//TODO
		String northwaiting= Integer.toString(northWaiting.length);
		String southwaiting = Integer.toString(southWaiting.length);
		String northtrains =Integer.toString(northBoundTrains.length);
		String southtrains = Integer.toString(southBoundTrains.length);
		String result = "Station: "+ name +"\n"+ northtrains +" north-bound trains waiting"+"\n"+southtrains+" south-bound trains waiting"+"\n"+northwaiting+" north-bound passengers waiting"+"\n"+southwaiting+" south-bound passengers waiting";
		return result;
	}
    /**
     * This method will return the name of the station.
     * @return	This will be the name of the station name;
     *Time Complexity: O(1)
     */
	public String stationName() {
		//TODO
		return this.name;
	}
	
	/**
	 * This method will return the comparing result of whether the object S equal to the name of the station.
	 *Time Complexity: O(1)
	 */
	@Override
	public boolean equals(Object s) {
		//TODO
		return s.equals(this.name);
	}
}
