package demo_programs2;
import org.apache.logging.log4j.*;

public class LogginDemo2 {
	private static Logger demoLogger = LogManager.getLogger(LogginDemo2.class.getClass());

	public static void main(String[] args) {
		
		demoLogger.info("This is info level of the message");
		demoLogger.error("This is error level of message");
		demoLogger.fatal("This is fatal level of message");
		demoLogger.warn("This is warn level of message");
		demoLogger.debug("This is debug level of message");
		demoLogger.trace("This is trace level of message");
		demoLogger.trace("This is trace level message");
		demoLogger.trace("This is trace level message");
		demoLogger.trace("This is trace level message");
	}

}
