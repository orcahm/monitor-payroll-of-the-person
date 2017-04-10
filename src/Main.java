import java.io.IOException;
/**
 * A system to payroll of personnel who is working in a governmental institution
 * @author Ahmet ORUC
 * 
 */
public class Main {

	/**
	 * Main program to run
	 * @param args the text files that is given
	 * @throws IOException it gives this exception if a file exception occurs
	 */
	public static void main(String[] args) throws IOException{
		
		new Operation(args);
	}

}
