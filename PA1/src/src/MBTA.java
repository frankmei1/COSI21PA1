package src;
//Qingtian Mei
//frankmei@brandeis.edu
//02, 12, 2019
//PA1
/* This class is a main class. This class will read all the files and data from the text files, then put all the file into the other object class, and running starting doing the operations, by calling other methods from all the other class, which is the stimulation. This class will also print everything, results out */
/* Known Bugs: none */

import java.util.*;
import java.io.*;

public class MBTA {
	
	static final int HOURS = 6;
	static Scanner s;
	static Railway r;
	
	/**
	 * This method is the main method that is calling all the other classes for this program. 
	 * @param args	this is the array that read from the terminal. Not really being used here.
	 * @throws Exception File not being found and Null Exceptions. 
	 * Time Complexity: O(1) or O(N^4) depending on whether considering the length of array, constant or N.
	 */
	public static void main (String[] args) throws Exception{
		r = new Railway();
		initiateStations("redLine.txt");
		initiateRiders("riders.txt");
		initiateTrains("trains.txt");
		runTrains(HOURS);
		//TODO
	}

	/**
	 * This method receives a int, and you will need to run the trains.
	 * @param tics The integer that give 
	 * @throws Exception 
	 * Time Complexity: O(1) or O(N^3) depending on whether considering the length of array, constant or N.
	 */
	public static void runTrains(int tics) throws Exception {
		//TODO
		int count = 0;
		while(count<tics) {
			String headline = "--------------------------------------\n" +""+"Beginning Simulation"+"\n"+"--------------------------------------\n";
			System.out.println(headline);
			String result = r.simulate();
			System.out.println(result);
			System.out.println("--------------------------------------\n" + 
					"");
			count++;
		}
	}
	
	/**
	 * This method recieve a filename from the main class. And then read the words from the file that put to the railway.
	 * @param filename he filename will be the name of the file that we want to read.
	 * @throws FileNotFoundException In the case, this program is not able to find file;
	 * Time Complexity: O(N)
	 */
	public static void initiateStations(String filename) throws Exception {
		File RedLine = new File(filename);
		s = new Scanner(RedLine);
		while(s.hasNextLine()) {
			String name = s.nextLine();
			Station input = new Station(name);
			r.addStation(input);
		}
		//TODO
	}
	/**
	 * This method is to read the riders files and put the riders to the stations that has been putted into the railway.
	 * @param filename	The filename will be the name of the file that we want to read.
	 * @throws Exception In the case, this program is not able to find file;
	 * Time Complexity: O(N)
	 */
	public static void initiateRiders(String filename) throws Exception {
		File Riders = new File(filename);
		s = new Scanner(Riders);
		while(s.hasNextLine()) {
			String name = s.nextLine();
			String startingstation = s.nextLine();
			String destinationstation = s.nextLine();
			Rider input = new Rider(name,startingstation,destinationstation);
			r.addRider(input);
		}
		//TODO	
	}
	
	/**
	 * This method is to read the riders files and put the trains to the stations that has been put into the railway.
	 * @param filename The filename will be the name of the file that we want to read.
	 * @throws Exception	In the case, this program is not able to find file;
	 * Time Complexity: O(N)
	 */
	public static void initiateTrains(String filename) throws Exception {
		File Trains = new File(filename);
		s = new Scanner (Trains);
		while(s.hasNextLine()) {
			String name = s.nextLine();
			int direction = Integer.parseInt(s.nextLine());
			Train input = new Train(name,direction);
			r.addTrains(input);
		}
		//TODO
	}
	
}

