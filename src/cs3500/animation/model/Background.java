package cs3500.animation.model;

/**
 * Background class representing the background of the animation model.
 **/
public class Background implements IBackground{

  private int width;
  private int height;
  private int x;
  private int y;


  /**
   * Constructor for the Background class taking in X, Y coordinates, Width, and Height which cannot
   * be negative.
   *
   * @throws IllegalArgumentException if height or width are negative.
   */
  public Background(int x, int y, int width, int height) {
    if (this.width < 0 || this.height < 0) {
      throw new IllegalArgumentException("Invalid negative dimensions");
    } else {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
    }
  }

  /**
   * Gets the x coordinate of the Background.
   * @return int representing x coordinate.
   */
  @Override
  public int getX() {
    return this.x;
  }

  /**
   * Gets the y coordinate of the Background.
   * @return int representing y coordinate.
   */
  @Override
  public int getY() {
    return this.y;
  }

  /**
   * Gets the width dimension of the Background.
   * @return int representing width dimension.
   */
  @Override
  public int getWidth() {
    return this.width;
  }


  /**
   * Gets the height dimension of the Background.
   * @return int representing height dimension.
   */
  @Override
  public int getHeight() {
    return this.height;
  }
}
