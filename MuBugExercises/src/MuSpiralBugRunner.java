import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class MuSpiralBugRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.setGrid(new BoundedGrid<Actor>(60, 60));
		world.add(new Location(29, 29), new MuSpiralBug(3));
		world.show();
	}

}
