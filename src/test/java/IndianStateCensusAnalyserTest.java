import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import censuscsv.CensusAnalyserException;
import censuscsv.CensusAnalyzer;
import censuscsv.StateCensusCSV;

public class IndianStateCensusAnalyserTest {
    /**
     * File path INDIAN State CENSUS 
     */
	 private static final String INDIA_CENSUS_CSV_FILE_PATH= "C:\\Users\\shard\\eclipse-workspace\\Advance java"
			+ "\\IndianStateCensusAnalyserProblem\\IndianStateCensusAnalyserProblem\\src\\Resource\\IndiaStateCensusData.csv";
	 private static final String WRONG_CSV_FILE_PATH = "C:\\Users\\shard\\eclipse-workspace\\Advance java"
				+ "\\IndianStateCensusAnalyserProblem\\IndianStateCensusAnalyserProblem\\src\\Resource\\IndiaStateCensusData.csv";
	 private static final String WRONG_CSV_FILE_TYPE_PATH = "C:\\Users\\shard\\eclipse-workspace\\Advance java"
				+ "\\IndianStateCensusAnalyserProblem\\IndianStateCensusAnalyserProblem\\src\\Resource\\IndiaStateCensusData.txt";
	 private static final String INVALID_DELIMITER_FILE_PATH =  "C:\\Users\\shard\\eclipse-workspace\\Advance java"
				+ "\\IndianStateCensusAnalyserProblem\\IndianStateCensusAnalyserProblem\\src\\Resource\\invalidDelimitersIndiaStateCensusData.csv";
	 private static final String INVALID_HEADER_FILE_PATH =  "C:\\Users\\shard\\eclipse-workspace\\Advance java"
				+ "\\IndianStateCensusAnalyserProblem\\IndianStateCensusAnalyserProblem\\src\\Resource\\invalidHeadersIndiaStateCensusData.csv";
	 
	 
	 private static final String INDIA_STATE_CODE_CSV_FILE_PATH = "C:\\Users\\shard\\eclipse-workspace\\Advance java"
				+ "\\IndianStateCensusAnalyserProblem\\IndianStateCensusAnalyserProblem\\src\\Resource\\IndiaStateCode.csv";
	 
	 
		// Test Case 1.1
		@Test
		public void givenIndianCensusDataCSVFileReturnsCorrectRecords() {
			try {
				CensusAnalyzer censusAnalyser = new CensusAnalyzer();
				int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
				Assert.assertEquals(29, numOfRecords);
			} catch (CensusAnalyserException e) {
			}
		}

		// Test Case 1.2
		@Test
		public void givenIndianCensusDataCSVFile_whenWithWrongPath_shouldThrowException() {
			CensusAnalyzer censusAnalyser = new CensusAnalyzer();

			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			try {
				censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
			} catch (CensusAnalyserException e) {
				Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
			}
		}

		 //Test Case 1.3
	    @Test
	    public void givenIndianCensusDataCSVFile_whenWithWrongFileType_shouldThrowException()
	    {
	        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
	        ExpectedException exceptionRule =  ExpectedException.none();
	        exceptionRule.expect(CensusAnalyserException.class);
	        try
	        {
	            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_TYPE_PATH);
	        }
	        catch (CensusAnalyserException e)
	        {
	            Assert.assertNotSame(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
	        }
	    }


	    //Test Case 1.4
	    @Test
	    public void givenIndianCensusDataCSVFile_whenWithWrongDelimiters_shouldThrowException()
	    {
	        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
	        ExpectedException exceptionRule =  ExpectedException.none();
	        exceptionRule.expect(CensusAnalyserException.class);
	        try
	        {
	            censusAnalyser.loadIndiaCensusData(INVALID_DELIMITER_FILE_PATH);
	        }
	        catch (CensusAnalyserException e)
	        {
	            Assert.assertNotSame(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
	        }
	    }


	    //Test Case 1.5
	    @Test
	    public void givenIndianCensusDataCSVFile_whenWithWrongHeaders_shouldThrowException()
	    {
	        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
	        ExpectedException exceptionRule = ExpectedException.none();
	        exceptionRule.expect(CensusAnalyserException.class);
	        try
	        {
	            censusAnalyser.loadIndiaCensusData(INVALID_HEADER_FILE_PATH);
	        }
	        catch (CensusAnalyserException e)
	        {
	            Assert.assertNotSame(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
	        }
	    }
	    
	    //Test Case 2.1
	    @Test
	    public void givenIndiaStateCodeCSVFileReturnsCorrectRecords()
	    {
	        try
	        {
	            CensusAnalyzer censusAnalyser = new CensusAnalyzer();
	            int numOfRecords = censusAnalyser.loadIndiaStateCode(INDIA_STATE_CODE_CSV_FILE_PATH);
	            Assert.assertEquals(37,numOfRecords);
	        }
	        catch (CensusAnalyserException e) { }
	    }
	}
