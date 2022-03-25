import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import censuscsv.StateCensusCSV;

public class IndianStateCensusAnalyserTest {
    /**
     * steps
     * 1.checking file path of csv file
     * 2.method created for given Census CSV File returns correct number of entries
	 * otherwise throws exception....
     */
	/*
	 * 1.checking file path of csv file
	 */
	private static String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\shard\\eclipse-workspace\\Advance java"
			+ "\\IndianStateCensusAnalyserProblem\\IndianStateCensusAnalyserProblem\\src\\Resource\\IndiaStateCensusData.csv";
	private static final String WRONG_CSV_FILE_PATH ="C:\\Users\\shard\\eclipse-workspace\\Advance java"
			+ "\\IndianStateCensusAnalyserProblem\\IndianStateCensusAnalyserProblem\\src\\Resource\\IndiaStateCod.txt";
			
			
	/**
	 * 2.method created for given Census CSV File returns correct number of entries
	 * otherwise throws exception....
	 * 
	 * @throws IOException
	 */
	@Test
	public void givenIndianCensusCSVFileReturnsCorrectRecords() throws IOException {

		List<StateCensusCSV> users = new ArrayList<StateCensusCSV>();
		String line = "";
		BufferedReader reader = new BufferedReader(new FileReader(INDIA_CENSUS_CSV_FILE_PATH));
		reader.readLine();
		int count = 0;
		while ((line = reader.readLine()) != null) {
			count += 1;
		}
		Assert.assertEquals(29, count);
	}

	public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
    	List<StateCensusCSV> users = new ArrayList<StateCensusCSV>();
		String line = "";
		BufferedReader reader;
		int count1 = 0;
		try {
			reader = new BufferedReader(new FileReader(WRONG_CSV_FILE_PATH));
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				count1 += 1;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		Assert.assertEquals(29,count1);
		
    }


}
