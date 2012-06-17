package n4l.games.arena.map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Hex {
	private double a;
	private double b;
	private double c;
	private Polygon polygon;

	public Hex(int a) {
		this.setA((double) a);
	}

	public void setA(double a) {
		// TODO Auto-generated method stub
		this.a = a;
		this.b = a / 2;
		this.c = a * Math.sqrt(3);
		this.polygon = null;
	}

	public double getA() {
		return a;
	}

	private Polygon getPolygon() {
		if (polygon != null) {
			return polygon;
		} else {
			int[] xpoints = new int[6];
			int[] ypoints = new int[6];

			// (0, 0) hex
			xpoints[0] = (int) (c / 2);
			xpoints[1] = (int) (c);
			xpoints[2] = (int) (c);
			xpoints[3] = (int) (c / 2);
			xpoints[4] = (int) (0);
			xpoints[5] = (int) (0);

			ypoints[0] = (int) (0);
			ypoints[1] = (int) (b);
			ypoints[2] = (int) (3 * b);
			ypoints[3] = (int) (2 * a);
			ypoints[4] = (int) (3 * b);
			ypoints[5] = (int) (b);

			polygon = new Polygon(xpoints, ypoints, 6);
			return polygon;

		}
	}

	public void draw(Graphics2D g, int x, int y, int type) {
		// Draw hex around a center.
		this.getPolygon().translate(x, y);
		g.setColor(Color.white);
		g.drawPolygon(this.getPolygon());
		g.drawString("T" + type, x + this.getPolygon().getBounds().width / 2, y
				+ this.getPolygon().getBounds().height / 2);
		this.getPolygon().translate(-x, -y);

	}

}
