/**
 * 
 */
package n4l.games.arena.drawable;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Vector;

/**
 * @author xytis
 * 
 */
public class DrawableContext extends Drawable {

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
		Point nr = r;
		if (getBounds() != null) {
			nr.x = nr.x + getBounds().x;
			nr.y = nr.y + getBounds().y;
		}
		for (Drawable drawable : drawables) {
			drawable.render(g, nr);
		}
	}

	/**
	 * 
	 */
	public DrawableContextArray addContext(DrawableContext context) {
		DrawableContextArray array = new DrawableContextArray();
		array.addContext(this);
		array.addContext(context);
		return array;
	}

	/**
	 * 
	 */
	public DrawableContext addDrawable(Drawable drawable) {
		this.drawables.add(drawable);
		return this;
	}

	/**
	 * 
	 */
	public boolean contains(Drawable drawable) {
		return this.drawables.contains(drawable);
	}
}
