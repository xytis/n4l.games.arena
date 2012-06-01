/**
 * 
 */
package n4l.games.arena.map;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import n4l.games.arena.drawable.Drawable;

/**
 * @author xytis
 * 
 */
public class HexGrid extends Drawable {
	private Hex[][] grid;
	private Hex hex;
	private int height;
	private int width;

	public HexGrid(int height, int width) {
		grid = new Hex[height][width];
		hex = new Hex(50);
		this.height = height;
		this.width = width;
		this.setBounds(new Rectangle(height * 20, width * 20));
	}

	public Hex get(int i, int j) {
		// TODO: checks
		return grid[i][j];
	}

	@Override
	protected void draw(Graphics2D g, int x, int y) {
		super.draw(g, x, y);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// TODO: fix offsets
				//j = 0, y == 0
				//j = *, y == j * 1.5a
				//j%2 = 0, x == 0 + i*width
				//j%2 = 1, x == 0.5*width + i*width
				
				double offsetX = (Math.sqrt(3) * hex.getA()) * (0.5*(j%2) + i);
				double offsetY = (1.5*j * hex.getA());
				hex.draw(g, x + (int) offsetX, y + (int) offsetY);
			}
		}

	}
}
