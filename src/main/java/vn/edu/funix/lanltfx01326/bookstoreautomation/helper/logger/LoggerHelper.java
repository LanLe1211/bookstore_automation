package vn.edu.funix.lanltfx01326.bookstoreautomation.helper.logger;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class LoggerHelper {

	public static Logger getLogger(Class<?> cls) {

		return LogManager.getLogger(cls);

	}

}