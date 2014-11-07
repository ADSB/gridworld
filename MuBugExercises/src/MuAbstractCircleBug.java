import info.gridworld.actor.Bug;

public class MuAbstractCircleBug extends Bug {

	private int _angle;
	private float _remainder;
	private float _accumulator;

	public MuAbstractCircleBug(float radius) {
		float realAngle = (float)(1 / radius * 180.f / Math.PI);
		_angle = (int)(realAngle);
		_remainder = realAngle - _angle;
	}

	@Override
	public void turn() {
		int thisTurn = _angle;
		_accumulator += _remainder;
		if ((_accumulator += _remainder) > 1.f) {
			thisTurn++;
			_accumulator -= 1.f;
		}
		setDirection(getDirection() + thisTurn);
	}

	@Override
	public void act() {
		turn();
		while (!canMove()) {
			turn();
		}
		move();
	}

}
