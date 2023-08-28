package demo_programs;
import org.apache.logging.log4j.*;

public class LogginDemo {
	private static Logger demoLogger = LogManager.getLogger(LogginDemo.class.getClass());

	public static void main(String[] args) {
		
		demoLogger.info("This is info level of the message");
		demoLogger.error("This is error level of message");
		demoLogger.fatal("This is fatal level of message");
		demoLogger.warn("This is warn level of message");
		demoLogger.debug("This is debug level of message");
	}

}
