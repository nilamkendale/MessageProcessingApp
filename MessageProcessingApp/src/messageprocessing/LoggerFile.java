package messageprocessing;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Nilam
 * Creates the Logger file
 */
public class LoggerFile {

	/**
	 * @param logger
	 * This method creates Log file on specified location(Path must exists)
	 * 
	 */
	public static void setLogger(Logger logger) {
		FileHandler fh;  
		try {
			fh = new FileHandler(Utility.FILE);
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();  
			fh.setFormatter(formatter); 

		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}  
	}
}
