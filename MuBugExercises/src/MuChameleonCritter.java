import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;

import java.awt.*;
import java.util.ArrayList;

public class MuChameleonCritter extends Critter {

	@Override
	public void processActors(ArrayList<Actor> actors) {
		super.processActors(actors);
		darken();
	}

	/**
	 * Darken the color by 1/20.
	 */
	protected void darken() {
		Color c = getColor();
		setColor(new Color((int)(c.getRed() * .95), (int)(c.getGreen() * .95), (int)(c.getBlue() * .95)));
	}

}
