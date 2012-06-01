/**
 * 
 */
package n4l.games.arena.drawable;

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

	/**
	 * 
	 */
	public PanableContextArray() {
		lastMouseX = new Integer(0);
		lastMouseY = new Integer(0);
		state = new String();
		lifted = false;

	}

	@Override
	public void render(Graphics2D g, Point r) {
		super.render(g, r);
		g.drawString("State: " + state + " Coords: " + lastMouseX.toString()
				+ ", " + lastMouseY.toString(), 0, 10);
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
				+ getGlobalY() + ")";
	}

}
