/**
 * 
 */
package n4l.games.arena.drawable;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * @author xytis
 * 
 */
public class Drawable implements Refreshable {

	private Rectangle bounds;

	private boolean hidden;

	/**
	 * @return the bounds
	 */
	public Rectangle getBounds() {
		return bounds;
	}

	/**
	 * @param bounds
	 *            the bounds to set
	 */
	public Drawable setBounds(Rectangle bounds) {
		this.bounds = bounds;
		return this;
	}

	/**
	 * Toggle hidden
	 */
	public void show() {
		this.hidden = false;
	}

	public void hide() {
		this.hidden = true;
	}

	/**
	 * Constructor
	 */
	public Drawable() {
		this.bounds = null;
		this.hidden = true;
	}

	/**
	 * Constructor
	 * 
	 * @param bounds
	 */
	public Drawable(Rectangle bounds) {
		this.bounds = bounds;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println(this.toString() + " is updated.");

	}

	@Override
	public void render(Graphics2D g, Point r) {
		if (!hidden) {
			if (bounds != null) {
				this.draw(g, r.x + bounds.x, r.y + bounds.y);
			} else {
				// Do not render.
				System.out.println(this.toString() + " empty.");
			}
		}
		// Silently ignore hidden items
	}

	protected void draw(Graphics2D g, int x, int y) {
		g.setColor(Color.white);
		g.drawRect(x, y, bounds.width, bounds.height);
		g.drawString(this.toString(), x + bounds.width / 2, y + bounds.height
				/ 2);
	}
}
