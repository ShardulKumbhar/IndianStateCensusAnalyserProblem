package censuscsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateCensusAnalyser {
	/**
	 * PROCEDURE
	 * =================================================================
	 * 1.Given a File Path of IndiaStateCensusData.csv
	 * 2.create method readCSVData that reads the data from csv file
	 * 3.taking ArrayList to store the csv file
	 * 4.Taken buffer reder to read csv file
	 * 5.Reading the lines until it gets null/empty
	 * 6.printing format
	 * ===================================================================
	 * @author shard
	 * 
	 */

	/**
	 * 1.Given a File Path of IndiaStateCensusData.csv
	 */
	private static final String CSV_PATH = "C:\\Users\\shard\\eclipse-workspace\\Advance java"
			+ "\\IndianStateCensusAnalyserProblem\\IndianStateCensusAnalyserProblem\\src\\Resource\\IndiaStateCensusData.csv";

	/**
	 * 2.create method readCSVData that reads the data from csv file
	 * 
	 * @throws IOException -throws exception
	 */
	public static void readCSVData() throws IOException {

		/**
		 * 3.taking ArrayList to store the csv file
		 */
		List<StateCensusCSV> users = new ArrayList<StateCensusCSV>();
		String line = "";
		/*
		 * 4.Taken buffer reder to read csv file
		 */
		BufferedReader reader = new BufferedReader(new FileReader(CSV_PATH));
		reader.readLine();

		/*
		 * 5.Reading the lines until it gets null/empty
		 */
		while ((line = reader.readLine()) != null) {
			/*
			 * 6.Line to splite by commo
			 */
			String[] fields = line.split(",");

			if (fields.length > 0) {
				StateCensusCSV user = new StateCensusCSV();
				user.setState(fields[0]);
				user.setPop(Integer.parseInt(fields[1]));
				user.setArea(Integer.parseInt(fields[2]));
				user.setDensity(Integer.parseInt(fields[3]));
				users.add(user);
			}
		}

		/**
		 * 6.printing format
		 */
		for (StateCensusCSV u : users) {
			System.out.printf("[state=%s, population=%d, area=%d, density=%d]\n", u.getState(), u.getPop(), u.getArea(),
					u.getDensity());
		}

	}

	public static void main(String[] args) throws IOException {

		readCSVData();

	}
}
