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
		hex = new Hex(10);
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
				double offsetX = (Math.sqrt(3) * (1 / 2 + j % 2 + i))
						* hex.getA();
				double offsetY = ((1 + 3 * j / 2) * hex.getA());
				hex.draw(g, x + (int) offsetX, y + (int) offsetY);
			}
		}

	}
}
