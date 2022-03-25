package censuscsv;

import com.opencsv.bean.CsvBindByName;

public class StateCensusCSV {
	
	/**
	 * 1.variable decration
	 * 2.Generating Getters/Setters
	 */
	
	/**
	 * 
	 * 1.variable decration
	 */
	
	private String state;
	private long pop;
	private int area;
	private int density;

	/**
	 * 2.Generating Getters/Setters
	 */

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPop() {
		return pop;
	}

	public void setPop(long pop) {
		this.pop = pop;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getDensity() {
		return density;
	}

	public void setDensity(int density) {
		this.density = density;
	}

	@Override
	public String toString() {
		return "StateCensusCSV [state=" + state + ", pop=" + pop + ", area=" + area + ", density=" + density + "]";
	}

	
}
