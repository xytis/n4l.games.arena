/**
 * 
 */
package n4l.games.arena;

/**
 * @author xytis
 * 
 * @category Main application
 * 
 *           This class encapsulates the main thread, which controls the refresh
 *           rate, the update sequence, and stop sequence.
 * 
 */
public class MainThread extends Thread {

	private boolean running;

	/**
	 * 
	 */
	public MainThread() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		while (running) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

}
