/**
 * 
 */
package n4l.games.arena;

import java.awt.Canvas;
import n4l.games.arena.utils.*;


/**
 * @author xytis
 *
 */
public class MainPanel extends Canvas {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public MainPanel() {

		//Let this class call it's own repaints.
		setIgnoreRepaint(true);
		
		//Register key listener, for user input.
		addKeyListener(new KeyInputHandler());
	}
	
	
	/**
	 * 
	 */
	public void update() {
		
	}
	
	/**
	 * 
	 */
	public void render() {
		
	}
}
