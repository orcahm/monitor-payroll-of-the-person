/**
 * This class holds the Chief informations and calculates salary
 * @author Ahmet ORUC
 * 
 */
public class Chief extends FullTime {

	private int dayofPay =84;
	private int weekMaxHours = 8;
	private int overHourPay = 5;
	
	/**
	 * @param str informations of the line that is splitted by 'tab' character in the text file
	 */
	public Chief(String[] str) {
		super(str);
		super.setSeverancePay((super.getNowYear()-super.getStartYear())*20*0.8);
	}
	
	/**
	 * calculate salary of personnel
	 */
	@Override
	public void salaryCalculation() {
		setOverWorkSalary(owsCalculation());
		super.setSalary(getSeverancePay()+super.getOverWorkSalary()+(dayofPay*super.getDayofWork()));
	}
	/**
	 * calculates the overwork salary
	 * @return overwork salary 
	 */
	private int owsCalculation(){
		int ownSalary = 0;
		for(int i=0;i<super.getWeekHours().size();i++){
			int hour = super.getWeekHours().get(i)-this.getWeekNormalHour();
			if(hour>0 && hour<=this.weekMaxHours){
				ownSalary += (hour*this.overHourPay);
			}else if(hour>this.weekMaxHours){
				hour = this.weekMaxHours;
				ownSalary += (hour*this.overHourPay);
			}
		}
		return ownSalary;
	}

}
