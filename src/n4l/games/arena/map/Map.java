/**
 * 
 */
package n4l.games.arena.map;

import java.awt.Canvas;
import java.awt.Rectangle;

import n4l.games.arena.drawable.ClickableDrawable;
import n4l.games.arena.drawable.Drawable;
import n4l.games.arena.drawable.DrawableContext;
import n4l.games.arena.drawable.PanableDrawable;
import n4l.games.arena.drawable.ZoomableDrawable;

/**
 * @author xytis
 *
 */
public class Map extends DrawableContext {
	//TODO: shit and stuff. Should be able to load and reload maps from files.
	//The change should be done on context c.
	
	public Map(Canvas panel) {
		HexGrid h = new HexGrid(20, 20);
		// h.accommodate();

		// Static offset
		ClickableDrawable c = new ClickableDrawable();
		c.addDrawable(h);
		// c.accommodate();
		

		PanableDrawable map = new PanableDrawable();
		map.setBounds(new Rectangle(0, 0, 300, 300));
		map.addDrawable(c);
		map.accommodate();
		
		map.register(panel);

		this.setBounds(new Rectangle(20, 20, panel.getWidth() - 40,
				panel.getHeight() - 140));
		this.addDrawable((Drawable) map);
		// Allow to pan all the map
		map.offsetLimits(-h.getBounds().width + this.getBounds().width - 30,
				-h.getBounds().height + this.getBounds().height - 30,
				h.getBounds().width - this.getBounds().width + 30,
				h.getBounds().height - this.getBounds().height + 30);
	}

	public void load(String filename) {
		
	}
}
