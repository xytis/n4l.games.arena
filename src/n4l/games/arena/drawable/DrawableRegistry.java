/**
 * 
 */
package n4l.games.arena.drawable;

import java.awt.Graphics2D;
import java.awt.Point;

/**
 * This singleton class is responsible for storing drawable factories and
 * holding the registry of instantiated objects, along with contexts, where they
 * belong.
 * 
 * @author xytis
 * 
 */
public class DrawableRegistry {

	DrawableContext contexts;

	DrawableFactory factory;

	/**
	 * @return the factory
	 */
	public DrawableFactory getFactory() {
		return factory;
	}

	/**
	 * @param factory
	 *            the factory to set
	 */
	public void setFactory(DrawableFactory factory) {
		this.factory = factory;
	}

	// Private constructor prevents instantiation from other classes
	private DrawableRegistry() {
		contexts = new DrawableContext();
		factory = new DrawableFactory();
	}

	/**
	 * DrawableRegistryHolder is loaded on the first execution of
	 * DrawableRegistry.getInstance() or the first access to
	 * DrawableRegistryHolder.INSTANCE, not before.
	 */
	private static class DrawableRegistryHolder {
		public static final DrawableRegistry instance = new DrawableRegistry();
	}

	public static DrawableRegistry getInstance() {
		return DrawableRegistryHolder.instance;
	}

	/**
     * 
     */
	public void registerDrawable(Drawable drawable, DrawableContext context) {
		if (!context.contains(drawable)) {
			context = context.addDrawable(drawable);
		}
		if (!contexts.contains(context)) {
			contexts = contexts.addDrawable(context);
		}
	}

	/**
     * 
     */
	public void registerContext(DrawableContext context) {
		if (!contexts.contains(context)) {
			contexts = contexts.addDrawable(context);
		}
	}
	
	/**
	 * 
	 */
	public void swap(Drawable one, Drawable two) {
		two.setParent(one.getParent());
		if (contexts.contains(one)) {
			                                              
		}
	}
	
	/**
	 * 
	 */
	public boolean containsDrawable(Drawable drawable) {
		for (Drawable context : contexts) {
			if (context.contains(drawable)) {
					return true;
			}
		}		
		return false;
	}

	public void update() {
		contexts.update();
	}

	public void render(Graphics2D g) {
		contexts.render(g, new Point(0, 0));
	}

	public void show_all() {
		contexts.show();
	}

	public void hide_all() {
		contexts.hide();
	}
}
