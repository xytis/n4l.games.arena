/**
 * 
 */
package n4l.games.arena.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import n4l.games.arena.drawable.BaseDrawable;
import n4l.games.arena.sprite.Sprite;

/**
 * @author xytis
 * 
 */
public class Image extends BaseDrawable {

	private Sprite sprite;

	/**
	 * 
	 */
	public Image(Sprite sprite) {
		super();
		this.sprite = sprite;
		this.setBounds(new Rectangle(0, 0, sprite.getWidth(), sprite
				.getHeight()));
	}

	/**
	 * @param bounds
	 */
	public Image(Sprite sprite, Rectangle bounds) {
		super(bounds);
		this.sprite = sprite;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void draw(Graphics2D g, int x, int y) {
		sprite.draw(g, x, y);
		super.draw(g, x, y);
	}
}
