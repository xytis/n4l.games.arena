/**
 * 
 */
package n4l.games.arena.sprite;

import java.awt.Graphics2D;
import java.util.Vector;

import org.javatuples.Pair;

/**
 * @author xytis
 * 
 */
public class AnimatedSprite {

	private Integer frame;
	private Integer counter;
	private Boolean loop;
	private Boolean animate;
	private Vector<Pair<Sprite, Integer>> frames;

	/**
	 * Get the width of the drawn sprite
	 * 
	 * @return The width in pixels of this sprite
	 */
	public int getWidth() {
		return frames.firstElement().getValue0().getWidth();
	}

	/**
	 * Get the height of the drawn sprite
	 * 
	 * @return The height in pixels of this sprite
	 */
	public int getHeight() {
		return frames.firstElement().getValue0().getHeight();
	}

	/**
	 * @return the loop flag
	 */
	public boolean isLoop() {
		return loop;
	}

	/**
	 * @param loop
	 *            the loop flag to set
	 */
	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	/**
	 * @return the animate flag
	 */
	public boolean isAnimate() {
		return animate;
	}

	/**
	 * @param animate
	 *            the animate to set
	 */
	public void setAnimate(boolean animate) {
		this.animate = animate;
	}

	/**
	 * Resets the animation to the begining.
	 */
	public void start() {
		this.animate = true;
		this.frame = 0;
		this.counter = 0;
	}

	/**
	 * Stops the animation
	 */
	public void stop() {
		this.animate = false;
	}

	/**
	 * Resumes the animation
	 */
	public void resume() {
		this.animate = true;
	}

	/**
	 * 
	 */
	public AnimatedSprite(Vector<Pair<Sprite, Integer>> frames) {
		this.frame = 0;
		this.counter = 0;
		this.frames = frames;
		this.loop = false;
		this.animate = true;
	}

	/**
	 * Advance the current frame timer
	 */
	public void update() {
		if (animate) {
			counter++;
			if (frames.get(frame).getValue1() <= counter) {
				// Move to next frame
				counter = 0;
				frame++;
				if (frame >= frames.size()) {
					frame = 0;
					if (!loop) {
						animate = false;
					}
				}
			}
		}
	}

	/**
	 * Draw the current sprite onto the graphics context provided
	 * 
	 * @param g
	 *            The graphics context on which to draw the sprite
	 * @param x
	 *            The x location at which to draw the sprite
	 * @param y
	 *            The y location at which to draw the sprite
	 */
	public void draw(Graphics2D g, int x, int y) {
		frames.get(frame).getValue0().draw(g, x, y);
	}

}
