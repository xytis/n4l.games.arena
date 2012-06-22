/**
 * 
 */
package n4l.games.arena.drawable;

import java.awt.event.MouseEvent;

/**
 * @author xytis
 *
 */
public class ClickableDrawable extends MouseAwareDrawable {

	private Integer lastMouseX;
	private Integer lastMouseY;
	
	public ClickableDrawable() {
		lastMouseX = new Integer(0);
		lastMouseY = new Integer(0);
	}


	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (eventCheck(e)) {
			lastMouseX = e.getX();
			lastMouseY = e.getY();
		}
	}
}
