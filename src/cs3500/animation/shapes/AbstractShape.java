package cs3500.animation.shapes;

/**
 * Abstract Class implementing Shapes interface which is super to Circle, Rectangle, Triangle
 * classes.
 */
public abstract class AbstractShape implements Shapes {

  protected String name;
  protected String type;
  protected int r;
  protected int g;
  protected int b;
  protected int x;
  protected int y;
  protected int width;
  protected int height;

  /**
   * Constructor for bstract Class implementing Shapes interface which is super to Circle,
   * Rectangle, Triangle classes based on standard shape parameters.
   */
  public AbstractShape(String name, String type, int r, int g, int b, int x, int y, int width,
      int height) {
    if (r < 0 || r > 255 || g > 255 || b > 255 || g < 0 || b < 0 || !checkType(
        type) || checkName(name) || width < 0 || height < 0) {
      throw new IllegalArgumentException("Specified input has an invalid parameter");
    } else {
      this.name = name;
      this.type = type;
      this.r = r;
      this.g = g;
      this.b = b;
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
    }
  }

  /**
   * gets the AbstractShapes name.
   *
   * @return String representing the shape name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * gets the AbstractShapes type.
   *
   * @return String representing the shape type.
   */
  public String getType() {
    return this.type;
  }

  /**
   * gets the AbstractShapes red value.
   *
   * @return int representing the R value.
   */
  public int getR() {
    return this.r;
  }

  /**
   * gets the AbstractShapes green value.
   *
   * @return int representing the G value.
   */
  public int getG() {
    return this.g;
  }

  /**
   * gets the AbstractShapes blue value.
   *
   * @return int representing the B value.
   */
  public int getB() {
    return this.b;
  }

  /**
   * gets the AbstractShapes x coordinate.
   *
   * @return int representing the x value.
   */
  public int getX() {
    return this.x;
  }

  /**
   * gets the AbstractShapes y coordinate.
   *
   * @return int representing the y value.
   */
  public int getY() {
    return this.y;
  }

  /**
   * gets the AbstractShapes width dimension.
   *
   * @return int representing the width value.
   */
  public int getW() {
    return this.width;
  }

  /**
   * gets the AbstractShapes height dimension.
   *
   * @return int representing the height value.
   */
  public int getH() {
    return this.height;
  }

  /**
   * Checks to see if the name provided is valid.
   *
   * @return boolean if there is a non-null non-space string.
   */
  private boolean checkName(String name) {
    return (name == null || name.trim().isEmpty());
  }

  /**
   * Checks to see if the type provided is valid, either a circle rectangle or triangle.
   *
   * @return boolean if there the type provided is an instance of a class type.
   */
  private boolean checkType(String t) {
    return (t.equals("ellipse") || t.equals("rectangle") || t.equals("triangle"));
  }

  /**
   * sets the AbstractShapes red color value.
   */
  public void setR(int r2) {
    this.r = r2;
  }

  /**
   * sets the AbstractShapes green color value.
   */
  public void setG(int g2) {
    this.g = g2;
  }

  /**
   * sets the AbstractShapes x coordinate.
   */
  public void setX(int x2) {
    this.x = x2;
  }

  /**
   * sets the AbstractShapes y coordinate.
   */
  public void setY(int y2) {
    this.y = y2;
  }

  /**
   * sets the AbstractShapes width dimension.
   */
  public void setW(int w2) {
    this.width = w2;
  }

  /**
   * sets the AbstractShapes height dimension.
   */
  public void setH(int h2) {
    this.height = h2;
  }

  /**
   * sets the AbstractShapes blue color value.
   */
  public void setB(int b2) {
    this.b = b2;
  }
}
