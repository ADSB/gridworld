import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class MuCircleBugRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.setGrid(new BoundedGrid<Actor>(20, 20));
		world.add(new Location(0, 0), new MuCircleBug(6));
		world.show();
	}

}
