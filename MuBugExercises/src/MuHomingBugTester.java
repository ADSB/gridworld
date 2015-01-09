import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class MuHomingBugTester {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.setGrid(new BoundedGrid<Actor>(11, 11));
		world.add(new Location(10, 1), new MuHomingBugFloodFill(new Location(3, 3)));
		world.add(new Location(1, 4), new Rock());
		world.add(new Location(2, 2), new Rock());
		world.add(new Location(3, 2), new Rock());
		world.add(new Location(4, 2), new Rock());
		world.add(new Location(5, 2), new Rock());
		world.add(new Location(5, 1), new Rock());
		world.add(new Location(6, 2), new Rock());
		world.add(new Location(7, 2), new Rock());
		world.add(new Location(8, 2), new Rock());
		world.add(new Location(9, 2), new Rock());
		world.add(new Location(10, 2), new Rock());
		world.add(new Location(2, 2), new Rock());
		world.add(new Location(1, 4), new Rock());
		world.add(new Location(1, 4), new Rock());
		world.add(new Location(1, 4), new Rock());
		world.add(new Location(1, 4), new Rock());
		world.add(new Location(1, 4), new Rock());
		world.show();
	}

}
