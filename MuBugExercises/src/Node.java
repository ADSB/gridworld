import info.gridworld.grid.Location;

public class Node {

	public Location _destination;

	public Node _parent;
	public Location _location;

	protected Integer _fCost;
	protected Integer _gCost;
	protected Integer _hCost;
	protected Integer _lCost;

	public Node(Location _destination, Node parent, int linkCost) {
		_parent = parent;
		_lCost = linkCost;
	}

	public int getfCost() {
		if (_fCost == null) {
			_fCost = getgCost() + gethCost();
		}
		return _fCost;
	}

	public int getgCost() {
		if (_gCost == null) {
			_gCost = _parent.getgCost() + _lCost;
		}
		return _gCost;
	}

	public int gethCost() {
		if (_hCost == null) {
			_hCost = Math.abs(_location.getRow() - _destination.getRow()) + Math.abs(_location.getCol() - _destination.getCol());
		}
		return _hCost;
	}

}
