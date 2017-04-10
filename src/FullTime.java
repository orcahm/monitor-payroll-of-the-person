/**
 * This class holds the Full-time employee informations and calculates salary
 * @author Ahmet ORUC
 * 
 */
public class FullTime extends Employee {

	private double severancePay;
	private double overWorkSalary;	
	private int weekNormalHour=40;
	private int dayofWork = 20;
	
	/**
	 * @param str informations of the line that is splitted by 'tab' character in the text file
	 */
	public FullTime(String[] str) {
		super(str);
	}

	public double getSeverancePay() {
		return severancePay;
	}

	public void setSeverancePay(double severancePay) {
		this.severancePay = severancePay;
	}

	public double getOverWorkSalary() {
		return overWorkSalary;
	}

	public void setOverWorkSalary(double overWorkSalary) {
		this.overWorkSalary = overWorkSalary;
	}

	public int getWeekNormalHour() {
		return weekNormalHour;
	}

	public int getDayofWork() {
		return dayofWork;
	}

}
