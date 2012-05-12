/**
 * 
 */
package n4l.games.arena;

import java.awt.HeadlessException;
<<<<<<< HEAD
import java.util.logging.Logger;

=======
>>>>>>> 1a9ecb7d23091c8259b8b7b6e571dbce0fd109f1
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
	
<<<<<<< HEAD
	
	
	public Skeleton() throws HeadlessException {
		console = new TextOutput();
		add(console);
		
		setTitle("Skeleton");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 280);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
	}
	
	
	public void print(String text)
	{
		console.print(text);
=======
	/**
	 * @throws HeadlessException
	 */
	public Skeleton() throws HeadlessException {
		console = new TextOutput();
		add(console);
		// Čia lango parametrai:
        setTitle("Skeleton");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 280);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        // Viskas. Kiti metodai, kaip lango perpaišymui ar pelės jautimui 
        // lieka neperrašyti.
>>>>>>> 1a9ecb7d23091c8259b8b7b6e571dbce0fd109f1
	}
	
	/**
	 * 
	 */
	public void print(String text)
	{
		console.print(text);
	}

	
	public static void main(String[] args) {
		// Šis metodas priklauso klasei, ir yra kviečiamas kaip Skeleton.main();
		// Jis sukuria naują Skeleton instance (inicijuotą objektą):
		Skeleton window = new Skeleton();
		// Kas vyksta toliau -- žr. konstruktorių Skeleton().
		
<<<<<<< HEAD
		
		@SuppressWarnings("unused")
		Logger globalLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
=======
>>>>>>> 1a9ecb7d23091c8259b8b7b6e571dbce0fd109f1
		// Toliau programa ->
		window.print("Hello, my dear friend");
	}

}
