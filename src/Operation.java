import java.io.IOException;
import java.util.ArrayList;

/**
 * This class that all the operations are processed
 * @author Ahmet ORUC
 * 
 */
public class Operation {
	
	ArrayList<Personnel> personnelList;

	/**
	 * This method splits the text files and with using this informations it creates new objects that fits to itself.
	 * Then it sends the list of the informations to WrtieFile method.
	 * @param args the text files that is given
	 * @throws IOException it gives this exception if a file exception occurs
	 */
	public Operation(String []args) throws IOException{
		
		personnelList = new ArrayList<Personnel>();
		
		ReadFile personnelFile = new ReadFile();
		personnelFile.read(args[0]);
		
		ReadFile monitoringFile = new ReadFile();
		monitoringFile.read(args[1]);
		
		for(int i=0 ; i<personnelFile.line.size(); i++){
			this.newPersonnal(personnelFile.line.get(i).split("\t"));
		}
		
		for(int i=0 ; i<monitoringFile.line.size() ; i++){
			this.workingHours(monitoringFile.line.get(i).split("\t"));
		}
		
		for(int i = 0 ; i<personnelList.size(); i++){
			new WriteFile(personnelList.get(i));
		}
	}
	
	/**
	 * This method find and compare the position information at text file and create new object each personnel.
	 * While doing this, it uses the line parameter.
	 * @param line informations of the line that is splitted by 'tab' character in the text file
	 */
	public void newPersonnal(String [] line){
		
		if(line[2].equals("MANAGER")){
			personnelList.add(new Manager(line));
		}else if(line[2].equals("OFFICER")){
			personnelList.add(new Officer(line));
		}else if(line[2].equals("SECURITY")){
			personnelList.add(new Security(line));
		}else if(line[2].equals("PARTTIME_EMPLOYEE")){
			personnelList.add(new PartTime(line));
		}else if(line[2].equals("WORKER")){
			personnelList.add(new Worker(line));
		}else if(line[2].equals("CHIEF")){
			personnelList.add(new Chief(line));
		}
		
	}

	/**
	 * This method finds the register number of each personnel and then, 
	 * it goes the setWeekHours() and salaryCalculation() methods.
	 * @param line informations of the line that is splitted by 'tab' character in the text file
	 */
	public void workingHours(String [] line){
		
		for(int i = 0 ; i<this.personnelList.size(); i++){
			if(line[0].equals(personnelList.get(i).getRegisterNumber())){
				personnelList.get(i).setWeekHours(line);
				personnelList.get(i).salaryCalculation();
			}
		}
	}
}
