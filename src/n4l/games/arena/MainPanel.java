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

import n4l.games.arena.drawable.DrawableContext;
import n4l.games.arena.drawable.DrawableContextArray;
import n4l.games.arena.drawable.DrawableRegistry;
import n4l.games.arena.drawable.PanableContextArray;
import n4l.games.arena.map.HexGrid;
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

		HexGrid h = new HexGrid(20, 20);
		// h.accommodate();

		// Static offset
		DrawableContext c = new DrawableContext();
		c.addDrawable(h);
		// c.accommodate();

		PanableContextArray map = new PanableContextArray();
		map.setBounds(new Rectangle(0, 0, 300, 300));
		map.addContext(c);
		map.accommodate();
		this.addMouseListener(map);
		this.addMouseMotionListener(map);

		DrawableContextArray mapView = new DrawableContextArray();
		mapView.setBounds(new Rectangle(20, 20, getWidth() - 40,
				getHeight() - 140));
		mapView.addContext(map);
		// Allow to pan all the map
		map.offsetLimits(-h.getBounds().width + mapView.getBounds().width - 30,
				-h.getBounds().height + mapView.getBounds().height - 30,
				h.getBounds().width - mapView.getBounds().width + 30,
				h.getBounds().height - mapView.getBounds().height + 30);

		DrawableRegistry.getInstance().registerContext(mapView);

		// DrawableRegistry.getInstance().registerDrawable(h, p);
		mapView.show();

		/*
		 * Drawable d = DrawableRegistry.getInstance().getFactory()
		 * .createDrawable(Drawable.class.getName()); d.setBounds(new
		 * Rectangle(5, 5, 20, 20)); DrawableContext c = new DrawableContext();
		 * c.setBounds(new Rectangle(getWidth() / 2, 50, 50, 50));
		 * 
		 * DrawableRegistry.getInstance().registerDrawable(d, c); c.show();
		 * 
		 * c = new DrawableContext(); c.setBounds(new Rectangle(50, 50, 0, 0));
		 * 
		 * Image i = new Image(SpriteRegistry.getInstance().getSprite(
		 * "sprites/smurf/01.png"));
		 * DrawableRegistry.getInstance().registerDrawable(i, c); c.show();
		 * 
		 * c = new DrawableContext(); c.setBounds(new Rectangle(50, 350, 0, 0));
		 * 
		 * Animation a = new
		 * Animation(SpriteRegistry.getInstance().getAnimation(
		 * "animations/smurf.txt"));
		 * DrawableRegistry.getInstance().registerDrawable(a, c); c.show();
		 */

		thread = new MainThread(this);
		thread.setRunning(true);
		thread.start();
	}

	/**
	 * 
	 */
	public void update() {
		DrawableRegistry.getInstance().update();
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
				(getWidth() - g.getFontMetrics().stringWidth(AvgFps)),
				(getHeight()));
		DrawableRegistry.getInstance().render(g);

		g.dispose();
		strategy.show();
	}

	public void setAvgFps(double average) {
		DecimalFormat df = new DecimalFormat("0.##");
		this.AvgFps = "FPS: " + df.format(average);
	}
}
