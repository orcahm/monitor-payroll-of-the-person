/**
 * This class holds the Employee informations and calculates salary
 * @author Ahmet ORUC
 * 
 */
public abstract class Employee extends Personnel {

	/**
	 * @param str informations of the line that is splitted by 'tab' character in the text file
	 */
	public Employee(String[] str) {
		super(str);
	}

	/**
	 * calculate salary of personnel
	 */
	@Override
	public void salaryCalculation() {
		
	}

}
