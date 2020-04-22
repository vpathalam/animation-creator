package cs3500.animation.model.position;

import java.util.Objects;

/**
 * Class representing a x y coordinate with Position2D.
 */
public final class Position2D implements IPosition2D{
  private int x;
  private int y;

  /**
   * Initialize this object to the specified position.
   *
   * @param x the x position of the shape.
   * @param y the y position of the shape.
   */
  public Position2D(int x, int y) {

    this.setX(x);
    this.setY(y);
  }

  /**
   * Deep copy constructor for creating the same position.
   *
   * @param v the given position
   */
  public Position2D(Position2D v) {
    this.setX(v.x);
    this.setY(v.y);
  }

  /**
   * Get the x coordinate of this position.
   * @return int the x coordinate value of the position.
   */
  public int getX() {
    int copy = this.x; return copy;
  }

  /**
   * Set the x coordinate of this position.
   * @param x the x coordinate to set the positions value to.
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Get the y coordinate of this position.
   * @return int the y coordinate value of the position.
   */
  public int getY() {
    int copy = this.y; return copy;
  }

  /**
   * Set the y coordinate of this position.
   * @param y the y coordinate to set the positions value to.
   */
  public void setY(int y) {
    this.y = y;
  }

  /**
   * Determines whether or not the given position and this position are equivalent.
   * @param a which is an Object instance of position.
   * @return boolean whether or not the two positions are equal to each other in attributes.
   */
  @Override
  public boolean equals(Object a) {
    if (this == a) {
      return true;
    }
    if (!(a instanceof Position2D)) {
      return false;
    }

    Position2D that = (Position2D) a;

    return ((Math.abs(this.x - that.x) < 0.01)
            && (Math.abs(this.y - that.y) < 0.01));
  }

  /**
   * Returns a unique hashcode for the given position object.
   * @return int representing the hashcode number.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y);
  }
}
