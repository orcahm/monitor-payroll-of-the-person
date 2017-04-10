/**
 * This class holds the Security informations and calculates salary
 * @author Ahmet ORUC
 * 
 */
public class Security extends Personnel {

	private double severancePay;
	private int transMoney = 4;
	private int foodMoney = 5;
	private int maxDay= 24;
	private double hoursOfPay = 6.5;
	
	/** 
	 * @param str informations of the line that is splitted by 'tab' character in the text file
	 */
	public Security(String[] str) {
		super(str);
		this.severancePay = (super.getNowYear()-super.getStartYear())*20*0.8;
	}

	/**
	 * calculate salary of personnel
	 */
	@Override
	public void salaryCalculation() {
		super.setSalary((maxDay*transMoney)+(maxDay*foodMoney)+severancePay+(monWorkingHours()*hoursOfPay));
	}
	/**
	 * calculates the overwork salary
	 * @return overwork salary 
	 */
	private int monWorkingHours(){
		int ownSalary = 0;
		for(int i=0;i<super.getWeekHours().size();i++){
			int hour = super.getWeekHours().get(i);
			ownSalary += hour;
		}
		return ownSalary;
	}


}
