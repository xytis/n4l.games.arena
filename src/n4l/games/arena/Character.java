package n4l.games.arena;

public class Character {
	//fields
	private String name;
	private int weight;
	private int height;
	
	// getters
	public String getName() {
		return name;
	}
	public int getWeight() {
		return weight;
	}
	public int getHeight() {
		return height;
	}
	
	// setters
	public void setName(String name) {
		this.name = name;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	//constructor
	public Character() {
		name = "unknown name";
		weight = 50;
		height = 2;
	}
	
	public Character(String N, int W, int H) {
		name = N;
		weight = W;
		height = H;
	}
	
	
}
