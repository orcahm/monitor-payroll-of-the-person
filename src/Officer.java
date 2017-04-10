/**
 * This class holds the Officer informations and calculates salary
 * @author Ahmet ORUC
 * 
 */
public class Officer extends Personnel {

	private int baseSalary=1800;
	private double ssBenfit=0.49;
	private double severancePay;
	private int overWorkSalary;
	private int weekNormalHour = 40;
	private int weekMaxOverHours = 10;
	private int hourOverPay=4;
	
	/**
	 * @param str informations of the line that is splitted by 'tab' character in the text file
	 */
	public Officer(String[] str) {
		super(str);
		this.severancePay = (super.getNowYear()-super.getStartYear())*20*0.8;
	}

	/**
	 * calculate salary of personnel
	 */
	@Override
	public void salaryCalculation() {
		this.overWorkSalary = owsCalculation();
		super.setSalary(baseSalary+(baseSalary*ssBenfit)+severancePay+overWorkSalary);
	}
	/**
	 * calculates the overwork salary
	 * @return overwork salary 
	 */
	private int owsCalculation(){
		int ownSalary = 0;
		for(int i=0;i<super.getWeekHours().size();i++){
			int hour = super.getWeekHours().get(i)-this.weekNormalHour;
			if(hour>0 && hour<=this.weekMaxOverHours){
				ownSalary += (hour*this.hourOverPay);
			}else if(hour>this.weekMaxOverHours){
				hour = this.weekMaxOverHours;
				ownSalary += (hour*this.hourOverPay);
			}
		}
		return ownSalary;
	}


	

}
