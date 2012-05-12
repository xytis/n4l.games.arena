package n4l.games.arena;

public class Warrior extends Character {
	private String type;

	// getter and setter
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// constructor
	public Warrior() {
		type = "weakling";
	}

	public Warrior(String name, int W, int H, String Type) {
		super(name, W, H);
		type = Type;
	}

	public String reportStatus() {
		return super.reportStatus() + " I am " + this.getType() + ".\n";
	}

}
