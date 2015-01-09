import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class MuHomingBugFloodFill extends Bug {

	protected Location _destination;

	public MuHomingBugFloodFill() {
		super();
		_destination = getLocation();
	}

	public MuHomingBugFloodFill(Location l) {
		super();
		_destination = l;
	}

	protected Tile _cachedDestination;

	@Override
	public void act() {

		// calculate destination if not already existent
		if (_cachedDestination == null) {
			_cachedDestination = getDestinationTile();
		}

		// if not already at destination
		if (!getLocation().equals(_destination)) {

			Tile next = _cachedDestination;
			Tile parent;

			// focus on next tile
			while (next.hasParent()) {
				parent = next.getParent();
				if (parent.getLocation().equals(getLocation())) {
					break;
				}
				next = parent;
			}

			int targetDirection = getLocation().getDirectionToward(next.getLocation());

			// move if facing or turn towards if not
			if (getDirection() == targetDirection) {
				move();
			}
			else {
				turnTowards(targetDirection);
			}

		}

	}

	/**
	 * Make a half turn in direction
	 *
	 * @param direction to turn towards
	 */

	public void turnTowards(int direction) {
		int current = getDirection();
		int differential = direction - current;
		if (differential < 0) {
			// increase to positive
			differential += 360;
		}
		if (differential > 180) {
			setDirection(current - 45);
		}
		else {
			setDirection(current + 45);
		}
	}

	/**
	 * Find destination tile containing shortest path
	 *
	 * @return destination tile
	 */

	protected Tile getDestinationTile() {
		Grid<Actor> grid = getGrid();

		// represent already considered grid locations
		boolean[][] visited = new boolean[grid.getNumRows()][grid.getNumCols()];

		// current iteration queue
		ArrayList<Tile> current = new ArrayList<Tile>();
		// next iteration queue
		ArrayList<Tile> next = new ArrayList<Tile>();

		Location here = getLocation();

		// occupy initial location
		visited[here.getCol()][here.getRow()] = true;
		current.add(new Tile(here));

		for (;;) {
			// process each tile
			for (Tile tile: current) {
				Location location = tile.getLocation();
				// set location to visited
				visited[location.getRow()][location.getCol()] = true;

				for (Location node: grid.getValidAdjacentLocations(tile.getLocation())) {
					Actor actor = grid.get(node);
					// only if not visited and movable
					if (!visited[node.getRow()][node.getCol()] && (actor == null || actor instanceof Flower)) {
						// return immediately if reached
						if (node.equals(_destination)) {
							return new Tile(tile, node);
						}
						// otherwise queue tile
						next.add(new Tile(tile, node));
					}
				}
			}

			// move queue forward
			current.clear();
			current.addAll(next);
			next.clear();
		}

	}

}

