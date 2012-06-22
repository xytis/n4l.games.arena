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
public class BaseDrawable implements Drawable {

	private Rectangle bounds;

	private boolean hidden;

	private Drawable parent;

	/**
	 * @return the parent
	 */
	@Override
	public Drawable getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	@Override
	public Drawable setParent(Drawable parent) {
		this.parent = parent;
		return this;
	}
	
	@Override
	public Drawable addDrawable(Drawable drawable) {
		return null;
	}

	@Override
	public Drawable removeDrawable(Drawable drawable) {
		return null;
	}
	

	@Override
	public boolean contains(Drawable drawable)
	{
		return this == drawable;
	}

	/**
	 * 
	 */
	@Override
	public int getGlobalX() {
		if (this.getParent() != null) {
			if (this.getBounds() != null) {
				return this.getParent().getGlobalX() + this.getBounds().x;
			} else {
				return this.getParent().getGlobalX();
			}
		} else {
			if (this.getBounds() != null) {
				return this.getBounds().x;
			} else {
				return 0;
			}
		}
	}

	/**
	 * 
	 */
	@Override
	public int getGlobalY() {
		if (this.getParent() != null) {
			if (this.getBounds() != null) {
				return this.getParent().getGlobalY() + this.getBounds().y;
			} else {
				return this.getParent().getGlobalY();
			}
		} else {
			if (this.getBounds() != null) {
				return this.getBounds().y;
			} else {
				return 0;
			}
		}
	}

	/**
	 * @return the bounds
	 */
	@Override
	public Rectangle getBounds() {
		return bounds;
	}

	/**
	 * @param bounds
	 *            the bounds to set
	 */
	@Override
	public Drawable setBounds(Rectangle bounds) {
		this.bounds = bounds;
		return this;
	}

	/**
	 * Change the bounds to accommodate the drawable
	 */
	@Override
	public void accommodate() {
		if (this.getBounds() == null) {
			this.setBounds(new Rectangle());
		}
		System.err.println("Base drawable has nothing to accommodate.");
	}

	/**
	 * Toggle hidden
	 */
	@Override
	public void show() {
		this.hidden = false;
	}

	@Override
	public void hide() {
		this.hidden = true;
	}

	/**
	 * Constructor
	 */
	public BaseDrawable() {
		this.bounds = null;
		this.hidden = true;
	}

	/**
	 * Constructor
	 * 
	 * @param bounds
	 */
	public BaseDrawable(Rectangle bounds) {
		this.bounds = bounds;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		//System.out.println(this.toString() + " is updated.");

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
