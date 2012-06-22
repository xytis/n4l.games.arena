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
public abstract class DrawableDecorator implements Drawable {

	protected Drawable decoratedDrawable;
	 
    public DrawableDecorator (Drawable decoratedDrawable) {
        this.decoratedDrawable = decoratedDrawable;
    }
	
	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#getParent()
	 */
	@Override
	public Drawable getParent() {
		return decoratedDrawable.getParent();
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#setParent(n4l.games.arena.drawable.Drawable)
	 */
	@Override
	public Drawable setParent(Drawable parent) {
		return decoratedDrawable.setParent(parent);
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#addDrawable(n4l.games.arena.drawable.Drawable)
	 */
	@Override
	public Drawable addDrawable(Drawable drawable) {
		return decoratedDrawable.addDrawable(drawable);
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#removeDrawable(n4l.games.arena.drawable.Drawable)
	 */
	@Override
	public Drawable removeDrawable(Drawable drawable) {
		return decoratedDrawable.removeDrawable(drawable);
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#contains(n4l.games.arena.drawable.Drawable)
	 */
	@Override
	public boolean contains(Drawable drawable) {
		return decoratedDrawable.contains(drawable);
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#getGlobalX()
	 */
	@Override
	public int getGlobalX() {
		return decoratedDrawable.getGlobalX();
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#getGlobalY()
	 */
	@Override
	public int getGlobalY() {
		return decoratedDrawable.getGlobalY();
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#getBounds()
	 */
	@Override
	public Rectangle getBounds() {
		return decoratedDrawable.getBounds();
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#setBounds(java.awt.Rectangle)
	 */
	@Override
	public Drawable setBounds(Rectangle bounds) {
		return decoratedDrawable.setBounds(bounds);
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#accommodate()
	 */
	@Override
	public void accommodate() {
		decoratedDrawable.accommodate();
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#show()
	 */
	@Override
	public void show() {
		decoratedDrawable.show();
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#hide()
	 */
	@Override
	public void hide() {
		decoratedDrawable.hide();
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#update()
	 */
	@Override
	public void update() {
		decoratedDrawable.update();
	}

	/* (non-Javadoc)
	 * @see n4l.games.arena.drawable.Drawable#render(java.awt.Graphics2D, java.awt.Point)
	 */
	@Override
	public void render(Graphics2D g, Point r) {
		decoratedDrawable.render(g, r);
	}

}
