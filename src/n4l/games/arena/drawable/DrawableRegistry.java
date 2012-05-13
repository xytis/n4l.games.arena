/**
 * 
 */
package n4l.games.arena.drawable;

/**
 * This singleton class is responsible for storing drawable
 * factories and holding the registry of instantiated objects,
 * along with contexts, where they belong. 
 * 
 * @author xytis
 *
 */
public class DrawableRegistry {
	// Private constructor prevents instantiation from other classes
    private DrawableRegistry() {
    	
    }

    /**
    * DrawableRegistryHolder is loaded on the first execution of DrawableRegistry.getInstance() 
    * or the first access to DrawableRegistryHolder.INSTANCE, not before.
    */
    private static class DrawableRegistryHolder { 
            public static final DrawableRegistry instance = new DrawableRegistry();
    }

    public static DrawableRegistry getInstance() {
            return DrawableRegistryHolder.instance;
    }
    
    /**
     * 
     */
    public void registerDrawable(Drawable drawable, DrawableContext context)
    {
    	
    }
}
