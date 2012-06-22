/**
 * 
 */
package n4l.games.arena.drawable;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseWheelEvent;

/**
 * @author xytis
 *
 */
public class ZoomableDrawable extends MouseAwareDrawable {

	private double scale;
	
	private Rectangle zoomedBounds;
	
	public ZoomableDrawable() {
		scale = 1;
	}
	
	@Override
	public void render(Graphics2D g, Point r) {
		g.scale(scale, scale);
		//g.translate(scale, scale);
		super.render(g, r);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		System.out.println("Mouse wheel moved " + scale);
		int c = e.getWheelRotation();
		if (c > 0) {
			scale += 0.1;
		} else if (scale > 0.2) {
			if (c < 0) {
				scale -= 0.1;
			}
		}

	}
}
