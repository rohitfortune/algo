package algorithms.string;

import java.io.IOException;
import java.util.Scanner;

public class CommonChild {

	    // Complete the commonChild function below.
	    static int commonChild(String s1, String s2) {
	    	
	    	if(s1.length()==0 || s2.length()==0)
	        	return 0;
	    	
	        if(s1.charAt(0)== s2.charAt(0)) {
	        	return 1 + commonChild(s1.substring(1), s2.substring(1));
	        }	            
	        else {
	        	return Math.max(commonChild(s1.substring(0), s2.substring(1)),
	        			commonChild(s1.substring(1), s2.substring(0)));
	        }
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        String s1 = scanner.nextLine();

	        String s2 = scanner.nextLine();

	        int result = commonChild(s1, s2);
	        
	        System.out.println("Common child: "+ result);

	       // bufferedWriter.write(String.valueOf(result));
	       // bufferedWriter.newLine();

	       // bufferedWriter.close();

	        scanner.close();
	    }
}

