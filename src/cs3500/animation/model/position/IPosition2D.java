package cs3500.animation.model.position;

/** An interface for Position2D.
 * */
public interface IPosition2D {

  /**
   * Get the x coordinate of this position.
   * @return int the x coordinate value of the position.
   */
  int getX();

  /**
   * Set the x coordinate of this position.
   * @param x the x coordinate to set the positions value to.
   */
  void setX(int x);

  /**
   * Get the y coordinate of this position.
   * @return int the y coordinate value of the position.
   */
  int getY();

  /**
   * Set the y coordinate of this position.
   * @param y the y coordinate to set the positions value to.
   */
  void setY(int y);

}
