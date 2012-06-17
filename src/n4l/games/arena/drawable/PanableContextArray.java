/**
 * 
 */
package n4l.games.arena.drawable;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author xytis
 * 
 */
public class PanableContextArray extends DrawableContextArray implements
		MouseListener, MouseMotionListener {

	Integer lastMouseX, lastMouseY;
	String state;
	private Boolean lifted;
	
	private Rectangle limits;

	/**
	 * 
	 */
	public PanableContextArray() {
		lastMouseX = new Integer(0);
		lastMouseY = new Integer(0);
		state = new String();
		lifted = false;
	}
	
	public PanableContextArray(Rectangle limits) {
		lastMouseX = new Integer(0);
		lastMouseY = new Integer(0);
		state = new String();
		lifted = false;
		
		this.setLimits(limits);
	}
	
	public Rectangle getLimits() {
		return limits;
	}

	public void setLimits(Rectangle limits) {
		this.limits = limits;
	}
	
	public void offsetLimits(int x1, int y1, int x2, int y2) {
		if (this.getParent() != null) {
			if (this.getParent().getBounds() != null) {
				this.limits = new Rectangle(x1, y1, this.getParent().getBounds().width + x2 - x1, this.getParent().getBounds().height + y2 - y1);
				return ;
			}
		}
		System.err.println("Limits for " + this.toString() + " not set due to invalid parent!");
	}

	@Override
	protected void draw(Graphics2D g, int x, int y) {
		g.setColor(Color.pink);
		g.drawRect(x - 1, y - 1, getBounds().width+2, getBounds().height+2);
		g.drawOval(x - 1, y - 1, 3, 3);
		g.drawString("("+ getBounds().x + ":" + getBounds().y + ")", x, y);
		g.drawOval(x + getBounds().width - 1, y + getBounds().height - 1, 3, 3);
		g.drawString("("+ (getBounds().x + getBounds().width) + ":" + (getBounds().y + getBounds().height) + ")", x + getBounds().width, y + getBounds().height);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// NOP
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// NOP
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (this.eventCheck(e)) {
			state = "Pressed";
			lifted = true;
			lastMouseX = e.getX();
			lastMouseY = e.getY();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.eventCheck(e)) {
			state = "Released";
			lifted = false;
			lastMouseX = e.getX();
			lastMouseY = e.getY();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (this.eventCheck(e)) {
			state = "Clicked";
			lastMouseX = e.getX();
			lastMouseY = e.getY();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (this.eventCheck(e)) {
			state = "Dragged";
			if (lifted) {
				this.getBounds().x += e.getX() - lastMouseX;
				this.getBounds().y += e.getY() - lastMouseY;
				if (limits != null)
				{
					//Apply drag limits
					if (this.getBounds().x < this.getLimits().x) {
						this.getBounds().x = this.getLimits().x;
					}
					if (this.getBounds().y < this.getLimits().y) {
						this.getBounds().y = this.getLimits().y;
					}
					if (this.getBounds().x + this.getBounds().width > this.getLimits().x + this.getLimits().width) {
						this.getBounds().x = this.getLimits().x + this.getLimits().width - this.getBounds().width;
					}
					if (this.getBounds().y + this.getBounds().height > this.getLimits().y + this.getLimits().height) {
						this.getBounds().y = this.getLimits().y + this.getLimits().height - this.getBounds().height;
					}
				}
			}
			lastMouseX = e.getX();
			lastMouseY = e.getY();
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (this.eventCheck(e)) {
			state = "Moved";
			lastMouseX = e.getX();
			lastMouseY = e.getY();
		}
	}

	private Boolean eventCheck(MouseEvent e) {
		if (this.getBounds() != null) {
			Rectangle box = new Rectangle(this.getGlobalX(), this.getGlobalY(),
					this.getBounds().width, this.getBounds().height);
			if (this.getParent() != null) {
				if (this.getParent().getBounds() != null) {
					//Object is bounded (and clipped) by parent
					Rectangle parentBounds = this.getParent().getBounds();
					//Top left corner
					if (parentBounds.x > box.x) {
						box.x = parentBounds.x;
					}
					if (parentBounds.y > box.y) {
						box.y = parentBounds.y;
					}
					//Bottom right corner
					if (parentBounds.x + parentBounds.width < box.x + box.width) {
						box.width = parentBounds.x + parentBounds.width - box.x;
					}
					if (parentBounds.y + parentBounds.height < box.y + box.height) {
						box.height = parentBounds.y + parentBounds.height - box.y;
					}
				}
			}
			if (box.contains(e.getPoint())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		return super.toString() + " Coords: (" + getGlobalX() + ":"
				+ getGlobalY() + ") Local: (" + this.getBounds().x + ":" + this.getBounds().y + ")";
		//return super.toString() + " Limits: (" + getLimits().x + ":" + getLimits().y + ":" + getLimits().width + ":" + getLimits().height + ")";
	}


}
