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
        setSize(300, 280);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
	}
	
	/**
	 * 
	 */
	public void print(String text)
	{
		console.print(text);
	}

	
	public static void main(String[] args) {
		
		Skeleton window = new Skeleton();
		// Kas vyksta toliau		
		//create dude
		Mage Dude = new Mage("Dude", 1, 2, "Archmage");
				
		//create Gaia
		Mage Gaia = new Mage("Gaia", 20, 500, "Primal Deity");
		
		//keistas kurimo bbudas
		Character tree = new Mage("tree", 5, 2, "MightyTree");
		
		
		
		@SuppressWarnings("unused")
		Logger globalLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
		// Toliau programa
		window.print(Dude.reportStatus() + tree.reportStatus() + Dude.bitchSlap()+ "\n" + Dude.fireball()+"\n");
		
		tree.setHealth(0);
		window.print(tree.reportStatus());
		
	}
	
	

}
