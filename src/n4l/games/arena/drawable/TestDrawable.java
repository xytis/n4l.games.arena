/**
 * 
 */
package n4l.games.arena.drawable;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * @author xytis
 *
 */
public class TestDrawable extends BaseDrawable {

	@Override
	protected void draw(Graphics2D g, int x, int y) {
		g.setColor(Color.pink);
		g.drawRect(x - 1, y - 1, getBounds().width + 2, getBounds().height + 2);
		g.drawOval(x - 1, y - 1, 3, 3);
		g.drawString("(" + getBounds().x + ":" + getBounds().y + ")", x, y);
		g.drawOval(x + getBounds().width - 1, y + getBounds().height - 1, 3, 3);
		g.drawString("(" + (getBounds().x + getBounds().width) + ":"
				+ (getBounds().y + getBounds().height) + ")", x
				+ getBounds().width, y + getBounds().height);
		g.drawString(this.toString(), x+2, y+10);
	}
}
