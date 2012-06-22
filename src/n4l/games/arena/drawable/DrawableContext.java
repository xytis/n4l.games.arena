/**
 * 
 */
package n4l.games.arena.drawable;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author xytis
 * 
 */
public class DrawableContext extends BaseDrawable implements Iterable<Drawable> {

	private Vector<Drawable> drawables;

	/**
	 * 
	 */
	public DrawableContext() {
		this.drawables = new Vector<Drawable>();
	}

	/**
	 * Toggle hidden
	 */
	@Override
	public void show() {
		super.show();
		for (Drawable drawable : drawables) {
			drawable.show();
		}
	}

	@Override
	public void hide() {
		super.hide();
		for (Drawable drawable : drawables) {
			drawable.hide();
		}
	}

	@Override
	public void accommodate() {
		// TODO: finish this shit.
		int width = 0;
		int height = 0;
		for (Drawable drawable : drawables) {
			drawable.accommodate();
			if (drawable.getBounds().x + drawable.getBounds().width > width) {
				width = drawable.getBounds().x + drawable.getBounds().width;
			}
			if (drawable.getBounds().y + drawable.getBounds().height > height) {
				height = drawable.getBounds().y + drawable.getBounds().height;
			}
		}
		if (this.getBounds() != null) {
			this.getBounds().width = width;
			this.getBounds().height = height;
		} else {
			this.setBounds(new Rectangle(0, 0, width, height));
		}
	}

	/**
	 * 
	 */
	@Override
	public void update() {
		for (Drawable drawable : drawables) {
			drawable.update();
		}
	}

	/**
	 * @param g
	 * 
	 */
	@Override
	public void render(Graphics2D g, Point r) {
		super.render(g, r);
		// Offset
		Point nr = (Point) r.clone();
		if (getBounds() != null) {
			nr.x = nr.x + getBounds().x;
			nr.y = nr.y + getBounds().y;
			g.clipRect(nr.x, nr.y, getBounds().width, getBounds().height);
		}

		for (Drawable drawable : drawables) {
			drawable.render(g, nr);
		}
	}

	@Override
	protected void draw(Graphics2D g, int x, int y) {
		g.setColor(Color.green);
		g.drawRect(x, y, getBounds().width, getBounds().height);
		g.drawString(this.toString(), x+2, y+10);
	}


	/**
	 * 
	 */
	@Override
	public DrawableContext addDrawable(Drawable drawable) {
		this.drawables.add(drawable);
		drawable.setParent(this);
		return this;
	}

	/**
	 * 
	 */
	@Override
	public boolean contains(Drawable drawable) {
		return this.drawables.contains(drawable);
	}

	@Override
	public Iterator<Drawable> iterator() {
		return drawables.iterator();
	}
}
