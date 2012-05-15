/**
 * 
 */
package n4l.games.arena.drawable;

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
	 * 
	 */
	@Override
	public void update() {
		for (DrawableContext context : contexts) {
			context.update();
		}
	}

	/**
	 * 
	 */
	@Override
	public void render() {
		for (DrawableContext context : contexts) {
			context.render();
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
