import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;

import java.awt.*;
import java.util.ArrayList;

public class MuRockHound extends Critter {

	public MuRockHound() {
		super();
		setColor(Color.red);
	}

	@Override
	public void processActors(ArrayList<Actor> actors) {
		super.processActors(actors);
		for (Actor actor: actors) {
			if (actor instanceof Rock) {
				// remove actor if Rock
				actor.removeSelfFromGrid();
			}
		}
	}
}
