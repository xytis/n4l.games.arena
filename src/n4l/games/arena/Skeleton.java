/**
 * 
 */
package n4l.games.arena;

import java.awt.HeadlessException;
import java.util.logging.Logger;

import javax.swing.JFrame;

/**
 * @author xytis
 * 
 */
public class Skeleton extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @throws HeadlessException
	 */
	public Skeleton() throws HeadlessException {
		MainPanel panel = new MainPanel();

		add(panel);
		// Čia lango parametrai:
		setTitle("Skeleton");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 280);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Šis metodas priklauso klasei, ir yra kviečiamas kaip Skeleton.main();
		// Jis sukuria naują Skeleton instance (inicijuotą objektą):
		new Skeleton();
		// Kas vyksta toliau -- žr. konstruktorių Skeleton().

		@SuppressWarnings("unused")
		Logger globalLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	}

}
