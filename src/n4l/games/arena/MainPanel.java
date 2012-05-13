/**
 * 
 */
package n4l.games.arena;

import java.awt.Canvas;
import java.awt.event.KeyEvent;


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
	
	

}
