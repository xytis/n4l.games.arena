/**
 * 
 */
package n4l.games.arena.drawable;

/**
 * @author xytis
 * 
 */
public class Drawable implements Refreshable {

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println(this.toString() + " is updated.");

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		System.out.println(this.toString() + " is rendered.");

	}
}
