/**
 * 
 */
package n4l.games.arena;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author xytis
 *
 */
public class Game extends BasicGame {

	/**
	 * 
	 * @param name
	 */
	public Game() {
		super("Mordath Arena");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(GameContainer c, Graphics g) throws SlickException {
		//g.drawString("Hello, Slick world!", 0, 100);
	}


	@Override
	public void init(GameContainer c) throws SlickException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(GameContainer c, int delay) throws SlickException {
		// TODO Auto-generated method stub
		
	} 

	
	/** 
     * Entry point to our game 
     *  
     * @param argv The arguments to pass into the test 
     */ 
    public static void main(String[] argv) { 
        try { 
            AppGameContainer container = new AppGameContainer(new Game()); 
            container.setDisplayMode(800,600,false); 
            container.start(); 
        } catch (SlickException e) { 
            e.printStackTrace(); 
        } 
    }
}
