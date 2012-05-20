/**
 * 
 */
package n4l.games.arena.sprite;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Vector;

import javax.imageio.ImageIO;

import org.javatuples.Pair;

/**
 * A resource manager for sprites in the game. Its often quite important how and
 * where you get your game resources from. In most cases it makes sense to have
 * a central resource loader that goes away, gets your resources and caches them
 * for future use.
 * <p>
 * [singleton]
 * <p>
 * 
 * @author Kevin Glass
 */
public class SpriteRegistry {

	// ---- Singleton begin ----------------------------------------------------
	private SpriteRegistry() {
		sprites = new HashMap<String, Sprite>();
		animations = new HashMap<String, AnimatedSprite>();
	}

	private static class SpriteRegistryHolder {
		public static final SpriteRegistry instance = new SpriteRegistry();
	}

	public static SpriteRegistry getInstance() {
		return SpriteRegistryHolder.instance;
	}

	// -------------------------------------------------------------------------

	private HashMap<String, Sprite> sprites;
	private HashMap<String, AnimatedSprite> animations;

	/**
	 * Retrieve a sprite from the store
	 * 
	 * @param ref
	 *            The reference to the image to use for the sprite
	 * @return A sprite instance containing an accelerate image of the request
	 *         reference
	 */
	public Sprite getSprite(String ref) {
		// if we've already got the sprite in the cache
		// then just return the existing version

		if (sprites.get(ref) != null) {
			return (Sprite) sprites.get(ref);
		}

		// otherwise, go away and grab the sprite from the resource
		// loader

		BufferedImage sourceImage = null;

		try {
			// The ClassLoader.getResource() ensures we get the sprite
			// from the appropriate place, this helps with deploying the game
			// with things like webstart. You could equally do a file look
			// up here.

			URL url = this.getClass().getClassLoader().getResource(ref);

			if (url == null) {
				fail("Can't find ref: " + ref);
			}

			// use ImageIO to read the image in
			sourceImage = ImageIO.read(url);
		} catch (IOException e) {
			fail("Failed to load: " + ref);
		}

		// create an accelerated image of the right size to store our sprite in
		GraphicsConfiguration gc = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		Image image = gc.createCompatibleImage(sourceImage.getWidth(),
				sourceImage.getHeight(), Transparency.BITMASK);

		// draw our source image into the accelerated image
		image.getGraphics().drawImage(sourceImage, 0, 0, null);

		// create a sprite, add it the cache then return it
		Sprite sprite = new Sprite(image);
		sprites.put(ref, sprite);

		return sprite;
	}

	/**
	 * Retrieve an animation from the store
	 * 
	 * @param ref
	 *            The reference to the animation file
	 * @return An animation instance
	 */
	public AnimatedSprite getAnimation(String ref) {
		if (animations.get(ref) != null) {
			return (AnimatedSprite) animations.get(ref);
		}

		Vector<Pair<Sprite, Integer>> array = new Vector<Pair<Sprite, Integer>>();

		try {

			InputStream stream = this.getClass().getClassLoader()
					.getResourceAsStream(ref);

			if (stream == null) {
				fail("Can't find ref: " + ref);
			}

			DataInputStream in = new DataInputStream(stream);
			BufferedReader fileReader = new BufferedReader(
					new InputStreamReader(in));

			String strLine;
			String split[];

			while ((strLine = fileReader.readLine()) != null) {
				// Print the content on the console
				System.out.println(strLine);
				split = strLine.split(" ", 2);
				Sprite sprite = getSprite(split[0]);
				Integer time = Integer.parseInt(split[1].trim());
				array.add(new Pair<Sprite, Integer>(sprite, time));
			}

		} catch (IOException e) {
			fail("Failed to load: " + ref);
		}

		AnimatedSprite animation = new AnimatedSprite(array);
		animations.put(ref, animation);

		return animation;
	}

	/**
	 * Utility method to handle resource loading failure
	 * 
	 * @param message
	 *            The message to display on failure
	 */
	private void fail(String message) {
		// we'n't available
		// we dump the message and exit the game

		System.err.println(message);
		System.exit(1);
	}

}
