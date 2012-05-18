/**
 * 
 */
package n4l.games.arena.drawable;

import java.awt.Graphics2D;
import java.awt.Point;

/**
 * @author xytis
 * 
 */
public interface Refreshable {
	
	public void update();

	public void render(Graphics2D g, Point r);
}
