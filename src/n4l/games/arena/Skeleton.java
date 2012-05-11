/**
 * 
 */
package n4l.games.arena;

import java.awt.HeadlessException;

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

	/**
	 * @throws HeadlessException
	 */
	public Skeleton() throws HeadlessException {
		// Skeleton yra vaikas JFrame klasės. Jis turi daug veikiančių metodų.
		// Vienas iš jų į JFrame įdeda kitą JFrame. Tai kaip langas lange.
		add(new Board());
		// Čia lango parametrai:
		setTitle("Skeleton");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 280);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		// Viskas. Kiti metodai, kaip lango perpaišymui ar pelės jautimui
		// lieka neperrašyti.
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Šis metodas priklauso klasei, ir yra kviečiamas kaip Skeleton.main();
		// Jis sukuria naują Skeleton instance (inicijuotą objektą):
		new Skeleton();
		// Kas vyksta toliau -- žr. konstruktorių Skeleton().
	}

}
