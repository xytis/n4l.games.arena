/**
 * 
 */
package n4l.games.arena.drawable;

import java.util.Vector;

/**
 * @author xytis
 * 
 */
public class DrawableContext implements Refreshable {

	private Vector<Drawable> drawables;

	/**
	 * 
	 */
	public DrawableContext() {
		this.drawables = new Vector<Drawable>();
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
	 * 
	 */
	@Override
	public void render() {
		for (Drawable drawable : drawables) {
			drawable.render();
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
	public boolean contains(Drawable drawable)
	{
		return this.drawables.contains(drawable);
	}
}
