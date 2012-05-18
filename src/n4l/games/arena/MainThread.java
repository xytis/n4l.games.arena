/**
 * 
 */
package n4l.games.arena;

import n4l.games.arena.utils.AverageCounter;

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

	// desired fps
	private final static int MAX_FPS = 50;
	// maximum number of frames to be skipped
	private final static int MAX_FRAME_SKIPS = 5;
	// the frame period
	private final static int FRAME_PERIOD = 1000 / MAX_FPS;

	private MainPanel mainPanel;

	/**
	 * 
	 */
	public MainThread(MainPanel panel) {
		mainPanel = panel;
	}

	/**
	 * 
	 */
	public boolean getRunning() {
		return this.running;
	}

	/**
	 * 
	 */
	public MainThread setRunning(boolean running) {
		this.running = running;
		return this;
	}

	/**
	 * 
	 */
	@Override
	public void run() {
		System.out.println("Starting game loop");

		AverageCounter fps = new AverageCounter();

		long beginTime; // the time when the cycle begun
		long timeDiff; // the time it took for the cycle to execute
		int sleepTime = 0; // ms to sleep (<0 if we're behind)
		int framesSkipped; // number of frames being skipped

		while (running) {
			beginTime = System.currentTimeMillis();

			framesSkipped = 0; // resetting the frames skipped
			// update game state
			this.mainPanel.update();

			// render state to the screen
			// draws the canvas on the panel
			this.mainPanel.render();

			// calculate how long did the cycle take
			timeDiff = System.currentTimeMillis() - beginTime;

			// calculate sleep time
			sleepTime = (int) (FRAME_PERIOD - timeDiff);

			if (sleepTime > 0) {
				// if sleepTime > 0 we're OK
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
				}
			}

			while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS) {
				// we need to catch up
				// update without rendering
				this.mainPanel.update();
				// add frame period to check if in next frame
				sleepTime += FRAME_PERIOD;
				framesSkipped++;
			}

			fps.mark();
			this.mainPanel.setAvgFps(fps.getAverage());
		}
	}

}
