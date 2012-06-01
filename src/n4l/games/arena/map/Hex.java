package n4l.games.arena.map;

import java.awt.Graphics2D;
import java.awt.Polygon;

import sun.java2d.loops.DrawPolygons;

public class Hex {
	private double a;
	private double b;
	private double c;
	private Polygon polygon;
	
	private int i;
	private int j;
	
	public Hex(int a)
	{
		this.seta((double) a);
	}

	private void seta(double a) {
		// TODO Auto-generated method stub
		this.a = a;
		this.b = a/2;
		this.c = a * Math.sqrt(3);
		this.polygon = null;
	}
	
	private Polygon getPolygon()
	{
		if (polygon != null) {
			return polygon;
		} else {
			int[] xpoints = new int[6];
			int[] ypoints = new int[6];
			
			// (0, 0) hex
			xpoints[0] = (int) (c/2 );
			xpoints[1] = (int) (c );
			xpoints[2] = (int) (c);
			xpoints[3] = (int) (c/2);
			xpoints[4] = (int) (0);
			xpoints[5] = (int) (0);
			
			ypoints[0] = (int) (0);
			ypoints[1] = (int) (b);
			ypoints[2] = (int) (3*b);
			ypoints[3] = (int) (2*a);
			ypoints[4] = (int) (3*b);
			ypoints[5] = (int) (b);
			
			/*
			//(i, j) hex
			for (int ii : xpoints) {
				xpoints[ii]+= (int) ((Math.sqrt(3)*(1/2 + j % 2 + i))*a);
			}
			
			for (int ii : ypoints) {
				ypoints[ii] = (int) (1+3*j/2);
			}
			*/
			
			polygon = new Polygon(xpoints, ypoints, 6);
			return polygon;
			 
		}
	}

	public void draw(Graphics2D g, int x, int y) {
		//Draw hex around a center.
		this.getPolygon().translate(x, y);
		g.drawPolygon(this.getPolygon());
		this.getPolygon().translate(-x, -y);
		
	}

}
