/**
 * 
 */
package n4l.games.arena.sprite;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

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
	}

	private static class SpriteRegistryHolder {
		public static final SpriteRegistry instance = new SpriteRegistry();
	}

	public static SpriteRegistry getInstance() {
		return SpriteRegistryHolder.instance;
	}

	// -------------------------------------------------------------------------

	private HashMap<String, Sprite> sprites;

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
	 * Utility method to handle resource loading failure
	 * 
	 * @param message
	 *            The message to display on failure
	 */
	private void fail(String message) {
		// we'n't available
		// we dump the message and exit the game

		System.err.println(message);
		System.exit(0);
	}

}
