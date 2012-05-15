/**
 * 
 */
package n4l.games.arena.utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * A class to handle keyboard input from the user.
 * 
 * @author xytis
 * 
 */
public class KeyInputHandler extends KeyAdapter {

	/**
	 * Notification from AWT that a key has been pressed.
	 * 
	 * @param e
	 *            The details of the key that was pressed
	 */
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
	}

	/**
	 * Notification from AWT that a key has been released.
	 * 
	 * @param e
	 *            The details of the key that was released
	 */
	public void keyReleased(KeyEvent e) {
		System.out.println(e.getKeyCode());
	}

	/**
	 * Notification from AWT that a key has been typed. Note that typing a key
	 * means to both press and then release it.
	 * 
	 * @param e
	 *            The details of the key that was typed.
	 */
	public void keyTyped(KeyEvent e) {
		System.out.println(e.getKeyCode());

		// Temp exit place
		if (e.getKeyChar() == 27) {
			System.exit(0);
		}
	}
}