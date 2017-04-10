import java.util.ArrayList;
/**
 * This class holds all informations about each personnel.
 * @author Ahmet ORUC
 * 
 */
public abstract class Personnel {

	private String name;
	private String lastName;
	private String registerNumber;
	private String position;
	private int startYear;
	private int nowYear = 2016;
	private ArrayList<Integer> weekHours;
	private double salary = 0;
	
	/**
	 * @param str informations of the line that is splitted by 'tab' character in the text file
	 */
	public Personnel(String [] str){
		String [] split = str[0].split(" ");
		this.name = "";
		for(int i = 0; i<split.length-1;i++){
			if(i!=0){
				this.name = this.name + " ";
			}
			this.name = this.name + split[i];
		}
		this.lastName = split[split.length-1];
		this.registerNumber = str[1];
		this.position = str[2];
		this.startYear = Integer.parseInt(str[3]);
		this.weekHours = new ArrayList<Integer>();
	}
	
	/**
	 * calculate salary method
	 */
	public abstract void salaryCalculation();
	
	/**
	 * @param weekHours informations of the line that is splitted by 'tab' character in the text file
	 */
	public void setWeekHours(String []weekHours) {
		for(int i=1; i<weekHours.length;i++)
		this.weekHours.add(Integer.parseInt(weekHours[i]));
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public String getRegisterNumber() {
		return registerNumber;
	}
	public String getPosition() {
		return position;
	}
	public int getStartYear() {
		return startYear;
	}
	public ArrayList<Integer> getWeekHours() {
		return weekHours;
	}
	public double getSalary() {
		return salary;
	}
	public int getNowYear() {
		return nowYear;
	}
}
