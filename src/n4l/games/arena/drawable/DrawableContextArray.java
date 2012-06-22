/**
 * 
 */
package n4l.games.arena.drawable;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

/**
 * @author xytis
 * 
 */
@Deprecated
public class DrawableContextArray extends DrawableContext {

	private Vector<DrawableContext> contexts;

	/**
	 * 
	 */
	public DrawableContextArray() {
		this.contexts = new Vector<DrawableContext>();
	}

	/**
	 * Toggle hidden
	 */
	@Override
	public void show() {
		super.show();
		for (DrawableContext context : contexts) {
			context.show();
		}
	}

	@Override
	public void hide() {
		super.hide();
		for (DrawableContext context : contexts) {
			context.hide();
		}
	}

	@Override
	public void accommodate() {
		int width = 0;
		int height = 0;
		for (Drawable context : contexts) {
			context.accommodate();
			if (context.getBounds().x + context.getBounds().width > width) {
				width = context.getBounds().x + context.getBounds().width;
			}
			if (context.getBounds().y + context.getBounds().height > height) {
				height = context.getBounds().y + context.getBounds().height;
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
		for (DrawableContext context : contexts) {
			context.update();
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
		}
		for (DrawableContext context : contexts) {
			context.render(g, nr);
		}
	}

	/**
	 * 
	 */
	@Override
	public DrawableContextArray addDrawable(Drawable drawable) {
		// Get first context from array, add stuff to that context
		if (contexts.size() == 0) {
			throw new RuntimeException("empty Context array");
		}
		this.contexts.firstElement().addDrawable(drawable);
		return this;
	}

	/**
	 * 
	 */
	@Override
	public boolean contains(Drawable drawable) {
		for (DrawableContext context : contexts) {
			if (context.contains(drawable)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 */
	public boolean contains(DrawableContext context) {
		return contexts.contains(context);
	}
}
