import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.Random;

public class MuQuickCrab extends CrabCritter {

	public MuQuickCrab() {
		super();
	}

	public MuQuickCrab(Color color) {
		super();
		setColor(color);
	}

	@Override
	public void act() {
		Grid gr = getGrid();
		Location here = getLocation();
		Location next;
		int side = (new Random()).nextBoolean() ? getDirection() + 90 : getDirection() + 270;
		if (gr.isValid(next = here.getAdjacentLocation(side))
			&& !(gr.get(next) instanceof Actor)
			&& gr.isValid(next = next.getAdjacentLocation(side))
			&& !(gr.get(next) instanceof Actor)) {
			// move two spaces if nothing in the way
			moveTo(here.getAdjacentLocation(side).getAdjacentLocation(side));
		}
		else {
			super.act();
		}

	}

}
