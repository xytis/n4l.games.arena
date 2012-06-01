/**
 * 
 */
package n4l.games.arena.map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.reflect.Array;

import n4l.games.arena.drawable.Drawable;

/**
 * @author xytis
 *
 */
public class HexGrid extends Drawable{
	private Hex[][] grid;
	private int height;
	private int width;
	
	public HexGrid(int height, int width) {
		grid = new Hex [height][width];
	}
	
	public Hex get(int i, int j)
	{
		//TODO: checks
		return grid[i][j];
	}
	
	@Override
	protected void draw(Graphics2D g, int x, int y) {
		g.setColor(Color.white);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++)
			{
				grid[i][j].draw(g, convertX(i), convertY(j));
			}
		}
			
	}

	private int convertY(int j) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int convertX(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
}
