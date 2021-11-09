

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Sean Grimes, sean@seanpgrimes.com
 *
 * Utility class for getting user input
 */
@SuppressWarnings("WeakerAccess")
public class Input {
    // Validate input as an int between inclusive range
    public static int readIntInRange(int start, int end){
        String failSpeech = "Please enter a valid number between " + start + " - " + end;
        // BufferedReader is better than Scanner. Prove me wrong.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "z";  // Some non-integer value to fail parsing if checks are missed
        try{
            line = br.readLine();
            while(
                    line == null
                            || line.length() <= 0
                            || !Validation.isIntBetweenInclusive(start, end, line)
            ){
                System.out.println(failSpeech);
                line = br.readLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        //noinspection ConstantConditions
        return Integer.parseInt(line);
    }
}
