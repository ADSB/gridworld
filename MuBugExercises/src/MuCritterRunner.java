import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class MuCritterRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.setGrid(new BoundedGrid<Actor>(19, 19));
		world.add(new Location(0, 0), new MuChameleonCritter());
		world.add(new Location(0, 1), new MuChameleonKid());
		world.add(new Location(0, 2), new MuRockHound());
		for (int i = 0; i < 5; i++) {
			world.add(new Critter());
		}
		for (int i = 0; i < 5; i++) {
			world.add(new Rock());
		}
		world.show();
	}

}
