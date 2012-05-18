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
	public void show()
	{
		super.show();
		for (DrawableContext context : contexts) {
			context.show();
		}
	}
	
	@Override
	public void hide()
	{
		super.hide();
		for (DrawableContext context : contexts) {
			context.hide();
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
		//Offset
		Point nr = r;
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
	public DrawableContextArray addContext(DrawableContext context) {
		contexts.add(context);
		return this;
	}

	/**
	 * 
	 */
	@Override
	public DrawableContextArray addDrawable(Drawable drawable) {
		// Get first context from array, add stuff to that context
		this.contexts.firstElement().addDrawable(drawable);
		return this;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean contains(Drawable drawable)
	{
		for (DrawableContext context : contexts) {
			if (context.contains(drawable))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 */
	public boolean contains(DrawableContext context)
	{
		return contexts.contains(context);
	}
}
