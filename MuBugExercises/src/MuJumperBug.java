import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class MuJumperBug extends Bug {

	@Override
	public void move() {
		move(1);
	}

	public void move(int units) {
		Grid gr = getGrid();
		if (gr != null) {
			Location next = getLocation();
			int direction = getDirection();
			for (int i = 0; i < units; i++) {
				next = next.getAdjacentLocation(direction);
			}
			if (gr.isValid(next)) {
				this.moveTo(next);
			}
			else {
				this.removeSelfFromGrid();
			}
		}
	}

	@Override
	public boolean canMove() {
		return canMove(1);
	}

	public boolean canMove(int units) {
		Grid gr = getGrid();
		if (gr == null) {
			return false;
		}
		else {
			Location next = getLocation();
			int direction = getDirection();
			for (int i = 0; i < units; i++) {
				next = next.getAdjacentLocation(direction);
			}
			return gr.isValid(next) && !isOccupied(next);
		}
	}

	public boolean canJump() {
		Grid gr = getGrid();
		if (gr == null) {
			return false;
		}
		else {
			Location next = getLocation().getAdjacentLocation(getDirection());
			return gr.isValid(next) && isJumpable(next);
		}
	}

	public boolean isOccupied(Location location) {
		Grid gr = getGrid();
		return gr.get(location) instanceof Actor;
	}

	public boolean isJumpable(Location location) {
		Grid gr = getGrid();
		Object neighbor = gr.get(location);
		return neighbor instanceof Flower || neighbor instanceof Rock;
	}

	@Override
	public void act() {
		act(true);
	}

	public void act(boolean recur) {
		if (canMove()) {
			move();
			if (recur) {
				act(false);
			}
		}
		else {
			if (recur) {
				if (canMove(2) && canJump()) {
					move(2);
				}
				else {
					turn();
				}
			}
		}
	}

}
