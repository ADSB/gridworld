import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.Random;

public class MuCrabRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.setGrid(new BoundedGrid<Actor>(19, 19));
		world.add(new Location(1, 1), new MuQuickCrab(Color.yellow));
		world.add(new Location(0, 0), new Rock());
		world.add(new Location(0, 1), new Rock());
		world.add(new Location(0, 2), new Rock());
		world.add(new Location(1, 2), new Rock());
		world.add(new Location(2, 2), new Rock());
		world.add(new Location(2, 1), new Rock());
		world.add(new Location(2, 0), new Rock());
		world.add(new MuQuickCrab());
		MuKingCrab king = new MuKingCrab();
		king.setDirection(90);
		world.add(new Location(1, 0), king);
		{
			Random r = new Random();
			for (int i = 0; i < 10; i++) {
				world.add(new MuKingCrab());
				world.add(new Rock(new Color(r.nextFloat(), r.nextFloat(), r.nextFloat())));
				world.add(new MuQuickCrab(Color.yellow));
			}
		}

		world.show();
	}

}
