/**
 * This class holds the Worker informations and calculates salary
 * @author Ahmet ORUC
 * 
 */
public class Worker extends FullTime {

	private int dayofPay =73;
	private int weekMaxHours = 10;
	private int overHourPay = 4;
	
	/**
	 * @param str informations of the line that is splitted by 'tab' character in the text file
	 */
	public Worker(String[] str) {
		super(str);
		this.setSeverancePay((super.getNowYear()-super.getStartYear())*20*0.8);
	}
	/**
	 * calculates salary of the personnel
	 */
	@Override
	public void salaryCalculation() {
		setOverWorkSalary(owsCalculation());
		super.setSalary(getSeverancePay()+getOverWorkSalary()+(dayofPay*getDayofWork()));
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
