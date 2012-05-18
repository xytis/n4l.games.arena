/**
 * 
 */
package n4l.games.arena;

import java.util.logging.Logger;

/**
 * @author xytis
 * 
 */
public class Skeleton {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Šis metodas priklauso klasei, ir yra kviečiamas kaip Skeleton.main();
		// Jis sukuria naują Skeleton instance (inicijuotą objektą):
		new MainPanel();
		// Kas vyksta toliau -- žr. konstruktorių Skeleton().

		@SuppressWarnings("unused")
		Logger globalLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	}

}
