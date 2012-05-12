package n4l.games.arena;

public class Character {
	// fields
	protected String name;
	protected int size;
	protected int health;

	// getters
	public String getName() {
		return this.name;
	}

	public int getSize() {
		return this.size;
	}

	public int getHealth() {
		return this.health;
	}

	// setters
	public Character setName(String name) {
		this.name = name;
		return this;
	}

	public Character setSize(int size) {
		this.size = size;
		return this;
	}

	public Character setHealth(int health) {
		this.health = health;
		return this;
	}

	// constructors
	/**
	 * Empty constructor, creates character with template info.
	 */
	public Character() {
		this.name = "unknown name";
		this.size = 1;
		this.health = 2;
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 *            Descriptive character name
	 * @param size
	 *            Size factor
	 * @param health
	 *            Total health
	 */
	public Character(String name, int size, int health) {
		this.name = name;
		this.size = size;
		this.health = health;
	}

	/**
	 * Verbose parameter reporting
	 * 
	 * @return String verbose status
	 */
	public String reportStatus() {
		return "My name is " + this.getTitle() + " and I am "
				+ this.getCondition() + '.';
	}

	/**
	 * How should I be called?
	 * 
	 * @return String name, to call me.
	 */
	public String getTitle() {
		return this.getName();
	}

	/**
	 * How do I feel?
	 * 
	 * @return String condition
	 */
	public String getCondition() {
		if (health <= 0) {
			return "dead";
		} else {
			return "standing " + getSize() + " feet tall";
		}
	}

}
