/**
 * 
 */
package n4l.games.arena.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import n4l.games.arena.drawable.BaseDrawable;
import n4l.games.arena.sprite.AnimatedSprite;

/**
 * @author xytis
 * 
 */
public class Animation extends BaseDrawable {

	private AnimatedSprite animation;

	/**
	 * 
	 */
	public Animation(AnimatedSprite animation) {
		super();
		this.animation = animation;
		this.animation.setLoop(true);
		this.setBounds(new Rectangle(0, 0, animation.getWidth(), animation
				.getHeight()));
	}

	/**
	 * @param bounds
	 */
	public Animation(Rectangle bounds) {
		super(bounds);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		super.update();
		animation.update();
	}

	@Override
	protected void draw(Graphics2D g, int x, int y) {
		animation.draw(g, x, y);
		super.draw(g, x, y);
	}

}
