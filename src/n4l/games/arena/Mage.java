package n4l.games.arena;

public class Mage extends Character {
	private String type;

	//getter and setter
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	//constructor
	public Mage (){
		type = "weakling";
	}
	
	public Mage (String name, int W, int H,String Type){
		super(name, W, H);
		type = Type;
	}

	/*
	public static void main(String[] args) {
		//create dude
		Mage Dude = new Mage("Dude", 60, 2, "Archmage");
		
		//create Gaia
		Mage Gaia = new Mage();
		Gaia.setName("Gaia");
		Gaia.setHeight(20);
		Gaia.setType("Primal Deity");
		Gaia.setWeight(500);
		
		Dude.printStatus();
		Gaia.printStatus();
		
	}
	*/
	
	private void printStatus() {
		System.out.println("My name is " + this.getName() + ". I am " + this.getType());
		System.out.println("My height is " + this.getHeight()+ " m. "
				+ "and weight is " + this.getWeight() + " kg \n");
		
	}
}
