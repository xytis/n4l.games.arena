/**
 * 
 */
package n4l.games.arena.drawable;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * @author xytis
 * 
 */
public class PanableDrawable extends MouseAwareDrawable {

	public PanableDrawable() {
		lastMouseX = new Integer(0);
		lastMouseY = new Integer(0);
		offsetX = new Double(0);
		offsetY = new Double(0);
		scale = 1;
		lifted = false;
	}


	Integer lastMouseX, lastMouseY;
	Double offsetX, offsetY;

	private Boolean lifted;

	private Rectangle limits;
	
	private double scale;

	public Rectangle getLimits() {
		return limits;
	}

	public void setLimits(Rectangle limits) {
		this.limits = limits;
	}

	public void offsetLimits(int x1, int y1, int x2, int y2) {
		if (this.getParent() != null) {
			if (this.getParent().getBounds() != null) {
				this.limits = new Rectangle(x1, y1, this.getParent()
						.getBounds().width + x2 - x1, this.getParent()
						.getBounds().height + y2 - y1);
				return;
			}
		}
		System.err.println("Limits for " + this.toString()
				+ " not set due to invalid parent!");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		if (this.eventCheck(e)) {
			lifted = true;
			lastMouseX = e.getX();
			lastMouseY = e.getY();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		if (this.eventCheck(e)) {
			lifted = false;
			lastMouseX = e.getX();
			lastMouseY = e.getY();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if (this.eventCheck(e)) {
			lastMouseX = e.getX();
			lastMouseY = e.getY();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		super.mouseDragged(e);
		if (this.eventCheck(e)) {
			if (lifted) {
				//TODO: go to Graphics.translate.
				
				this.getBounds().x += e.getX() - lastMouseX;
				this.getBounds().y += e.getY() - lastMouseY;
				if (limits != null) {
					// Apply drag limits
					if (this.getBounds().x < this.getLimits().x) {
						this.getBounds().x = this.getLimits().x;
					}
					if (this.getBounds().y < this.getLimits().y) {
						this.getBounds().y = this.getLimits().y;
					}
					if (this.getBounds().x + this.getBounds().width > this
							.getLimits().x + this.getLimits().width) {
						this.getBounds().x = this.getLimits().x
								+ this.getLimits().width
								- this.getBounds().width;
					}
					if (this.getBounds().y + this.getBounds().height > this
							.getLimits().y + this.getLimits().height) {
						this.getBounds().y = this.getLimits().y
								+ this.getLimits().height
								- this.getBounds().height;
					}
				}
				
				/*
				offsetX += e.getX() - lastMouseX;
				offsetY += e.getY() - lastMouseY;
				if (limits != null) {
					// Apply drag limits
					if (offsetX < this.getLimits().x + this.getLimits().width * (1.0 - scale)/2) {
						offsetX = this.getLimits().x + this.getLimits().width * (1.0 - scale)/2;
					}
					if (offsetY < this.getLimits().y + this.getLimits().height * (1.0 - scale)/2) {
						offsetY = this.getLimits().y + this.getLimits().height * (1.0 - scale)/2;
					}
					if (offsetX + this.getBounds().width * scale > this
							.getLimits().x + this.getLimits().width  - this.getLimits().width * (1.0 - scale)/2) {
						offsetX = this.getLimits().x
								+ this.getLimits().width
								- this.getBounds().width * scale
								- this.getLimits().width * (1.0 - scale)/2;
					}
					if (offsetY + this.getBounds().height * scale > this
							.getLimits().y + this.getLimits().height - this.getLimits().height * (1.0 - scale)/2) {
						offsetY = this.getLimits().y
								+ this.getLimits().height
								- this.getBounds().height * scale
								- this.getLimits().height * (1.0 - scale)/2;
					}
				}
				*/
			}
			lastMouseX = e.getX();
			lastMouseY = e.getY();
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		super.mouseMoved(e);
		if (this.eventCheck(e)) {
			lastMouseX = e.getX();
			lastMouseY = e.getY();
		}
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
	

	@Override
	public String toString() {
		return super.toString() + " Coords: (" + getGlobalX() + ":"
				+ getGlobalY() + ") Local: (" + this.getBounds().x + ":"
				+ this.getBounds().y + ")";
	}
	
	@Override
	public void render(Graphics2D g, Point r) {
		//g.translate(offsetX, offsetY);
		//g.scale(scale, scale);
		super.render(g, r);
		//g.scale(1, 1);
		//g.translate(-offsetX, -offsetY);
	}


}
