package n4l.games.arena;

public class Mage extends Character {
	protected String type;
	protected int mana;

	// getter and setter
	public String getType() {
		return this.type;
	}

	public Mage setType(String type) {
		this.type = type;
		return this;
	}

	// constructor
	/**
	 * Empty constructor, creates a mage with default info.
	 */
	public Mage() {
		super(); // Explicit call. If anyone wondered what happened =]
		this.mana = 2;
		this.type = "weakling";
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
	 * @param type
	 *            Type string
	 */
	public Mage(String name, int size, int health, String type) {
		super(name, size, health);
		this.mana = 2;
		this.type = type;
	}

	/**
	 * How should I be called? Mages are titled, you know...
	 * 
	 * @return String name, to call me.
	 */
	@Override
	public String getTitle() {
		return this.getType() + " " + super.getTitle();
	}

	/**
	 * How do I feel?
	 * 
	 * @return String condition
	 */
	@Override
	public String getCondition() {
		if (health <= 0) {
			return "dead";
		} else {
			if (mana > 0) {
				return "standing " + getSize() + " feet tall, ready to rumble";
			} else {
				return "out of mana, yet standing " + getSize() + " feet tall";
			}
		}
	}

	/**
	 * This is how I cast stuff.
	 * 
	 * @param spellname
	 *            in String
	 * @return casted spell in String
	 */
	public String castSpell(String spellname) {
		if (mana > 0) {
			this.mana--;
			return "I, " + this.getTitle() + ", fiersly cast " + spellname
					+ "!";
		} else {
			return "I, " + this.getTitle() + ", am out of mana.";
		}
	}
}
