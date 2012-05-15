/**
 * 
 */
package n4l.games.arena;

import java.awt.Canvas;

import n4l.games.arena.drawable.Drawable;
import n4l.games.arena.drawable.DrawableContext;
import n4l.games.arena.drawable.DrawableRegistry;
import n4l.games.arena.utils.KeyInputHandler;

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
	private MainThread thread;

	/**
	 * 
	 */
	public MainPanel() {

		// Let this class call it's own repaints.
		setIgnoreRepaint(true);

		// Register key listener, for user input.
		addKeyListener(new KeyInputHandler());
		
		Drawable d = DrawableRegistry.getInstance().getFactory().createDrawable("Drawable");
		DrawableContext c = new DrawableContext();
		
		DrawableRegistry.getInstance().registerDrawable(d, c);
		
		
		thread = new MainThread(this);
		thread.setRunning(true);
		thread.start();
	}

	/**
	 * 
	 */
	public void update() {
		DrawableRegistry.getInstance().update();
	}

	/**
	 * 
	 */
	public void render() {
		DrawableRegistry.getInstance().render();
	}
}
