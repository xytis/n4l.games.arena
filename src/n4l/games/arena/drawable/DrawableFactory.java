/**
 * 
 */
package n4l.games.arena.drawable;

/**
 * @author xytis
 * 
 */
public class DrawableFactory {

	/**
	 * Constructor
	 */
	public DrawableFactory() {

	}

	public Drawable createDrawable(String name) {
		try {
			Class<?> c = Class.forName(name);
			return (Drawable) c.newInstance();
		} catch (Throwable e) {
			System.err.println(e);
		}
		return null;
	}

}
