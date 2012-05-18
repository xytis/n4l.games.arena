/**
 * 
 */
package n4l.games.arena;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import n4l.games.arena.drawable.Drawable;
import n4l.games.arena.drawable.DrawableContext;
import n4l.games.arena.drawable.DrawableRegistry;
import n4l.games.arena.utils.KeyInputHandler;

/**
 * @author xytis
 * 
 */
public class MainPanel extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private MainThread thread;

	/**
	 * 
	 */
	private BufferStrategy strategy;

	private String AvgFps;

	/**
	 * 
	 */
	public MainPanel() {

		AvgFps = new String();

		JFrame container = new JFrame("Arena");

		JPanel panel = (JPanel) container.getContentPane();

		panel.setPreferredSize(new Dimension(800, 600));
		panel.setLayout(null);

		setBounds(0, 0, 800, 600);
		panel.add(this);

		container.pack();
		container.setResizable(false);
		container.setVisible(true);

		container.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// Let this class call it's own repaints.
		setIgnoreRepaint(true);

		// Register key listener, for user input.
		addKeyListener(new KeyInputHandler());

		requestFocus();

		createBufferStrategy(2);
		strategy = getBufferStrategy();

		Drawable d = DrawableRegistry.getInstance().getFactory()
				.createDrawable("Drawable");
		d.setBounds(new Rectangle(5, 5, 20, 20));
		DrawableContext c = new DrawableContext();
		c.setBounds(new Rectangle(getWidth() / 2, 50, 50, 50));

		DrawableRegistry.getInstance().registerDrawable(d, c);

		c.show();

		thread = new MainThread(this);
		thread.setRunning(true);
		thread.start();
	}

	/**
	 * 
	 */
	public void update() {
		// DrawableRegistry.getInstance().update();
	}

	/**
	 * 
	 */
	public void render() {
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		// Blank this buffer out
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.white);
		g.drawString(AvgFps,
				(getWidth() - g.getFontMetrics().stringWidth(AvgFps)) / 2,
				getHeight() / 2);
		DrawableRegistry.getInstance().render(g);

		g.dispose();
		strategy.show();
	}

	public void setAvgFps(double average) {
		DecimalFormat df = new DecimalFormat("0.##");
		this.AvgFps = "FPS: " + df.format(average);
	}
}
