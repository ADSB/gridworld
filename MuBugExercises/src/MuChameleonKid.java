import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class MuChameleonKid extends MuChameleonCritter {

	@Override
	public void processActors(ArrayList<Actor> actors) {
		super.processActors(actors);

		int direction = getDirection();
		Location here = getLocation();
		Location next;
		Object candidate;
		Grid gr = getGrid();

		if (
			((gr.isValid(next = here.getAdjacentLocation(direction)))
				&& (candidate = gr.get(next)) instanceof Actor)
			|| ((gr.isValid(next = here.getAdjacentLocation(direction + 180)))
				&& (candidate = gr.get(next)) instanceof Actor)) {
			// copy color of actor
			setColor(((Actor)(candidate)).getColor());
		}

		// otherwise, self will have already darkened

	}
}
