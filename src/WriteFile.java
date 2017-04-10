import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * This class write the informations to a new text file 
 * according to 'RegisterNumber.txt' format.
 * @author Ahmet ORUC
 */
public class WriteFile {
	
	/**
	 * The method that writes the informations of personnels in new text files with 'registerNumber.txt' format
	 * @param pr the object that the personnel belongs
	 * @throws IOException The error occurs when it can not find the file.
	 */
	public WriteFile(Personnel pr) throws IOException{
		
		StringBuilder strb = new StringBuilder();
		strb.append(pr.getRegisterNumber()+".txt");
	
		BufferedWriter bw = new BufferedWriter(new FileWriter(strb.toString()));
		strb.setLength(0);
		
		strb.append("Name : "+pr.getName()+"\n\n");
		strb.append("Surname : "+pr.getLastName()+"\n\n");
		strb.append("Registiration Number : "+pr.getRegisterNumber()+"\n\n");
		strb.append("Position : "+pr.getPosition()+"\n\n");
		strb.append("Year of Start : "+pr.getStartYear()+"\n\n");
		strb.append("Total Salary : "+String.format("%.2f", pr.getSalary())+" TL");
		
		bw.write(strb.toString());
		bw.close();

	}

}
