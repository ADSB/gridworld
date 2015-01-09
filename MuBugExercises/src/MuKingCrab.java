import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class MuKingCrab extends CrabCritter {

	@Override
	public void processActors(ArrayList<Actor> actors) {
		Grid gr = getGrid();
		Location here = getLocation();

		{
			Location remote;
			Location destination;

			for (Actor actor: actors) {
				remote = actor.getLocation();
				destination = remote.getAdjacentLocation(remote.getDirectionToward(here) + 180);
				if (gr.isValid(destination) && !(gr.get(destination) instanceof Actor)) {
					// move actor away if possible
					actor.moveTo(destination);
				}
				else {
					// remove actor
					actor.removeSelfFromGrid();
				}
			}
		}

		super.processActors(actors);
	}

}
