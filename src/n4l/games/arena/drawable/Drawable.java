/**
 * 
 */
package n4l.games.arena.drawable;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * @author xytis
 * 
 */
public interface Drawable {

	/**
	 * @return the parent
	 */
	public Drawable getParent();

	/**
	 * @param parent
	 *            the parent to set
	 */
	public Drawable setParent(Drawable parent);
	
	/**
	 * @param drawable
	 * 			  the Drawable to add
	 */
	public Drawable addDrawable(Drawable drawable);
	
	/**
	 * @param drawable
	 * 			  the Drawable to remove
	 */
	public Drawable removeDrawable(Drawable drawable);
	
	/**
	 * @param drawable
	 */
	public boolean contains(Drawable drawable);

	/**
	 * 
	 */
	public int getGlobalX();
	public int getGlobalY();

	/**
	 * @return the bounds
	 */
	public Rectangle getBounds();

	/**
	 * @param bounds
	 *            the bounds to set
	 */
	public Drawable setBounds(Rectangle bounds);

	/**
	 * Change the bounds to accommodate the drawable
	 */
	public void accommodate();

	/**
	 * Toggle visibility
	 */
	public void show();
	public void hide();


	public void update();
	public void render(Graphics2D g, Point r);
}
