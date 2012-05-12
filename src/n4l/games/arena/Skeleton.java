/**
 * 
 */
package n4l.games.arena;

import java.awt.HeadlessException;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * @author xytis
 * 
 */
public class Skeleton extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected TextOutput console;

	/**
	 * @throws HeadlessException
	 */
	public Skeleton() throws HeadlessException {
		console = new TextOutput();
		add(console);
		// ia lango parametrai:
		setTitle("Skeleton");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

	}

	/**
	 * 
	 */
	public void print(String text) {
		console.print(text + '\n');
	}

	public static void main(String[] args) {

		Skeleton window = new Skeleton();
		@SuppressWarnings("unused")
		Logger globalLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

		// Check this out:
		Character bob = new Character("Bob", 1, 10);
		window.print("Report by " + bob.getClass().getName() + ": "
				+ bob.reportStatus());
		// Runtime error:
		// Try to compile =]
		// window.print(((Mage) bob).castSpell("Bitch Slap Majore"));

		// How to address this:
		if (bob instanceof Mage) {
			window.print(((Mage) bob).castSpell("Bitch Slap Majore"));
		} else {
			window.print(bob.getTitle()
					+ " is unable to cast spells. Get over it.");
		}

		// Now inspect this:
		Character dude = new Mage("Dude the Gray", 1, 2, "Archmage");
		window.print("Report by " + dude.getClass().getName() + ": "
				+ dude.reportStatus());
		// He is a Character, so compile error here:
		// window.print(dude.castSpell("Spark"));
		// And check this out:
		if (dude instanceof Mage) {
			window.print(((Mage) dude).castSpell("Spark"));
		} else {
			window.print(dude.getTitle()
					+ " is unable to cast sparkles. Shame on him!");
		}

		// Finally -- lets try a simple mage
		Mage gaya = new Mage("Gaya", 20, 500, "Primal Deity");
		window.print("Report by " + gaya.getClass().getName() + ": "
				+ gaya.reportStatus());
		window.print(gaya.castSpell("Trembling heavens"));
		
		// Now the hard part:
		// Try understanding:
		window.print("This is how everyone introduces:");
		window.print(bob.getTitle()); //I am Character
		window.print(dude.getTitle()); //I am Character
		window.print(gaya.getTitle()); //I am Mage
		window.print("This is how everyone feels:");
		window.print(bob.getCondition());
		window.print(dude.getCondition());
		window.print(gaya.getCondition());

	}
}
