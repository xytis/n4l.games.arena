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
public class MorphDrawable implements Drawable {
	
	public MorphDrawable()
	{
		object = new BaseDrawable();
	}
	
	private Drawable object;

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#getParent()
	 */
	@Override
	public Drawable getParent() {
		return object.getParent();
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#setParent(n4l.games.arena.drawable.Drawable)
	 */
	@Override
	public Drawable setParent(Drawable parent) {
		object.setParent(parent);
		return this;
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#addDrawable(n4l.games.arena.drawable.Drawable)
	 */
	@Override
	public Drawable addDrawable(Drawable drawable) {
		if (object instanceof DrawableContext) {
			object.addDrawable(drawable);
		} else {
			DrawableContext context = new DrawableContext();
			context.addDrawable(object);
			context.addDrawable(drawable);
			DrawableRegistry.getInstance().swap(object, context);
			object = context;
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#removeDrawable(n4l.games.arena.drawable.Drawable)
	 */
	@Override
	public Drawable removeDrawable(Drawable drawable) {
		return object.removeDrawable(drawable);
	}
	
	@Override
	public boolean contains(Drawable drawable) {
		return object.contains(drawable);
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#getGlobalX()
	 */
	@Override
	public int getGlobalX() {
		return object.getGlobalX();
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#getGlobalY()
	 */
	@Override
	public int getGlobalY() {
		return object.getGlobalY();
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#getBounds()
	 */
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#setBounds(java.awt.Rectangle)
	 */
	@Override
	public Drawable setBounds(Rectangle bounds) {
		return object.setBounds(bounds);
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#accommodate()
	 */
	@Override
	public void accommodate() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#show()
	 */
	@Override
	public void show() {
		object.show();
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#hide()
	 */
	@Override
	public void hide() {
		object.hide();
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#update()
	 */
	@Override
	public void update() {
		object.update();
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#render(java.awt.Graphics2D, java.awt.Point)
	 */
	@Override
	public void render(Graphics2D g, Point r) {
		object.render(g, r);
	}

}
