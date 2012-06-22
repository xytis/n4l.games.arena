/**
 * 
 */
package n4l.games.arena.drawable;

import java.awt.Canvas;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * @author xytis
 *
 */
public abstract class MouseAwareDrawable extends DrawableContext implements
		MouseListener, MouseMotionListener, MouseWheelListener {

	private String state;
	
	/*
	 * 
	 */
	public void register(Canvas panel) {
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		panel.addMouseWheelListener(this);
	}
	
	

	/* (non-Javadoc)
	 * @see java.awt.event.MouseWheelListener#mouseWheelMoved(java.awt.event.MouseWheelEvent)
	 */
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		state = "Mouse wheel moved";
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		state = "Mouse dragged";
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		state = "Mouse moved";
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		state = "Mouse clicked";
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		state = "Mouse entered";
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		state = "Mouse exited";
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		state = "Mouse pressed";
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		state = "Mouse released";
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + " State: " + state;
	}
	
	/*
	 * Checks if given event is in the bounding box of this context.
	 * 
	 * @param event
	 */
	protected Boolean eventCheck(MouseEvent e) {
		if (this.getBounds() != null) {
			Rectangle box = new Rectangle(this.getGlobalX(), this.getGlobalY(),
					this.getBounds().width, this.getBounds().height);
			if (this.getParent() != null) {
				if (this.getParent().getBounds() != null) {
					// Object is bounded (and clipped) by parent
					Rectangle parentBounds = this.getParent().getBounds();
					// Top left corner
					if (parentBounds.x > box.x) {
						box.x = parentBounds.x;
					}
					if (parentBounds.y > box.y) {
						box.y = parentBounds.y;
					}
					// Bottom right corner
					if (parentBounds.x + parentBounds.width < box.x + box.width) {
						box.width = parentBounds.x + parentBounds.width - box.x;
					}
					if (parentBounds.y + parentBounds.height < box.y
							+ box.height) {
						box.height = parentBounds.y + parentBounds.height
								- box.y;
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

}
