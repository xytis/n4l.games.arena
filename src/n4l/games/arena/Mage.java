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

	
	public String reportStatus()
	{
		if (this.getHealth()>0)
			return super.reportStatus() + " I am " + this.getType() + ".\n";
		else
			return super.reportStatus();
	}
	
	
	
	
	//spelai
	
	public String fireball() {
		return this.getName() + "casts Fireball";
	}
	
	public String healingLight() {
		return this.getName() + "casts Healing light";
	}
	
	public String bitchSlap() {
		return this.getName() + "casts BitchSlap";
	}
	
}
