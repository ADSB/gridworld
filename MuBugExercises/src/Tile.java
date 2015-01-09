import info.gridworld.grid.Location;

public class Tile {

	protected Tile _parent;
	protected Location _location;

	public Tile(Location location) {
		_location = location;
	}

	public Tile(Tile parent, Location location) {
		this(location);
		_parent = parent;
	}

	public boolean hasParent() {
		return _parent != null;
	}

	public Tile getParent() {
		return _parent;
	}

	public Location getLocation() {
		return _location;
	}

}
