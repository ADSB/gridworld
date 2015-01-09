import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.PriorityQueue;

public class MuHomingBugAStar extends Bug {

	protected Location _destination;

	public MuHomingBugAStar() {
		super();
	}

	public MuHomingBugAStar(Location l) {
		super();
		_destination = l;
	}

	@Override
	public void act() {
		PriorityQueue<Node> open = new PriorityQueue<Node>();
		PriorityQueue<Node> closed = new PriorityQueue<Node>();
		PriorityQueue<Node> tab = new PriorityQueue<Node>();

		Grid<Actor> grid = getGrid();

		for (int i = 0; i < grid.getNumRows(); i++) {
			for (int j = 0; j < grid.getNumCols(); j++) {
				open.add(new Node(_destination, null, 0));
			}
		}

		for (Location neighbor: grid.getValidAdjacentLocations(getLocation())) {

		}

		if (!getLocation().equals(_destination)) {
			int targetDirection = getLocation().getDirectionToward(_destination);
			if (getDirection() == targetDirection) {
				move();
			}
			else {
				turnTowards(targetDirection);
			}
		}
	}

	public void turnTowards(int direction) {
		int current = getDirection();
		int differential = direction - current;
		if (differential < 0) {
			differential += 360;
		}
		if (differential > 180) {
			setDirection(current - 45);
		}
		else {
			setDirection(current + 45);
		}
	}

}
