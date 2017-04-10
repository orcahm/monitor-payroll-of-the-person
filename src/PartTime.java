/**
 * This class holds the Part-time employee informations and calculates salary
 * @author Ahmet ORUC
 * 
 */
public class PartTime extends Employee{

	private int minHour = 10;
	private int maxHour = 20;
	private int hourofPay = 12 ;
	
	/**
	 * @param str informations of the line that is splitted by 'tab' character in the text file
	 */
	public PartTime(String[] str) {
		super(str);
		
	}
	
	/**
	 * calculate salary of personnel
	 */
	@Override
	public void salaryCalculation() {
		int salary = 0;
		for(int i=0; i<super.getWeekHours().size();i++){
			if(super.getWeekHours().get(i)<minHour){
				continue;
			}else if(super.getWeekHours().get(i)>maxHour){
				salary += (maxHour*hourofPay);
			}else salary += (hourofPay*super.getWeekHours().get(i));
		}
		super.setSalary(salary);
	}
	

}
