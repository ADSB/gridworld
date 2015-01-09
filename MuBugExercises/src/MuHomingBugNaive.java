import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class MuHomingBugNaive extends Bug {

	protected Location _destination;

	public MuHomingBugNaive() {
		super();
	}

	public MuHomingBugNaive(Location l) {
		super();
		_destination = l;
	}

	@Override
	public void act() {
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

}
