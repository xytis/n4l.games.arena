/**
 * 
 */
package n4l.games.arena.utils;

/**
 * @author xytis
 * 
 */
public class AverageCounter {

	/**
	 * Length of average time window
	 */
	private final static int STAT_INTERVAL = 1000; // ms
	/**
	 * Trailing history of averages
	 */
	private final static int HISTORY_SIZE = 10;
	// last time the status was stored
	private long lastStoreTime = 0;
	// the status time counter
	private long statusIntervalTimer = 0l;

	// number of marks per statistics cycle
	private int markCountPerStatCycle = 0;
	// the last average values
	private double averages[];
	// the number of times the average was calculated
	private long averageCount = 0;
	// the trailing average
	private double average = 0.0;

	public AverageCounter() {
		// initialize timing elements
		averages = new double[HISTORY_SIZE];
		for (int i = 0; i < HISTORY_SIZE; i++) {
			averages[i] = 0.0;
		}
		System.out.println("Timing elements for stats initialised");
	}

	public double getAverage() {
		return average;
	}

	/**
	 * The statistics - it is called every cycle, it checks if time since last
	 * store is greater than the statistics gathering period (1 sec) and if so
	 * it calculates the average for the last period and stores it.
	 */
	public void mark() {
		markCountPerStatCycle++;

		// check the actual time
		statusIntervalTimer += (System.currentTimeMillis() - statusIntervalTimer);

		if (statusIntervalTimer >= lastStoreTime + STAT_INTERVAL) {
			// calculate the actual marks per stat_interval
			double mps = (double) (markCountPerStatCycle / (STAT_INTERVAL / 1000));

			// stores the latest average in the array
			averages[(int) averageCount % HISTORY_SIZE] = mps;

			// increase the number of times statistics was calculated
			averageCount++;

			double totalCount = 0.0;
			// sum up the stored average values
			for (int i = 0; i < HISTORY_SIZE; i++) {
				totalCount += averages[i];
			}

			// obtain the average
			if (averageCount < HISTORY_SIZE) {
				// in case of the first 10 triggers
				average = totalCount / averageCount;
			} else {
				average = totalCount / HISTORY_SIZE;
			}

			statusIntervalTimer = System.currentTimeMillis();
			markCountPerStatCycle = 0;
			lastStoreTime = statusIntervalTimer;
		}
	}
}
