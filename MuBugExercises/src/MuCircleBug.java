import info.gridworld.actor.Bug;

public class MuCircleBug extends Bug {
	private int steps;
	private int sideLength;

	public MuCircleBug(int length) {
		steps = 0;
		sideLength = length;
	}

	public void act() {
		if (steps < sideLength && canMove()) {
			move();
			steps++;
		}
		else {
			turn();
			steps = 0;
		}
	}
}
