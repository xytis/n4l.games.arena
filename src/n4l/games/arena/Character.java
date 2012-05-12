package n4l.games.arena;

public class Character {
	//fields
	private String name;
	private int size;
	private int health;
	
	// getters
	public String getName() {
		return name;
	}
	public int getSize() {
		return size;
	}
	public int getHealth() {
		return health;
	}
	
	// setters
	public void setName(String name) {
		this.name = name;
	}
	public void setSize (int size) {
		this.size = size;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	//constructor
	public Character() {
		name = "unknown name";
		size = 1;
		health = 2;
	}
	
	public Character(String N, int W, int H) {
		name = N;
		size = W;
		health = H;
	}
	
	public String reportStatus() {
		if (this.health>0)
			return "My name is " + this.getName() +" My health is " + this.getHealth()+
				" hp. and size is " + this.getSize() + ".\n";
		else
			return this.getName() +" is dead";
	}
	
}
