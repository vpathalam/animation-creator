package cs3500.animation.shapes;

/**Interface for shapes.
 * */
public interface Shapes {

  /**
   * gets the AbstractShapes type.
   *
   * @return String representing the shape type.
   */
  String getType();

  /**
   * gets the AbstractShapes name.
   *
   * @return String representing the shape name.
   */
  String getName();

  /**
   * gets the AbstractShapes red value.
   *
   * @return int representing the R value.
   */
  int getR();

  /**
   * gets the AbstractShapes green value.
   *
   * @return int representing the G value.
   */
  int getG();

  /**
   * gets the AbstractShapes blue value.
   *
   * @return int representing the B value.
   */
  int getB();

  /**
   * gets the AbstractShapes x coordinate.
   *
   * @return int representing the x value.
   */
  int getX();

  /**
   * gets the AbstractShapes y coordinate.
   *
   * @return int representing the y value.
   */
  int getY();

  /**
   * gets the AbstractShapes width dimension.
   *
   * @return int representing the width value.
   */
  int getW();

  /**
   * gets the AbstractShapes height dimension.
   *
   * @return int representing the height value.
   */
  int getH();

  /**
   * sets the AbstractShapes red color value.
   */
  void setR(int r2);

  /**
   * sets the AbstractShapes green color value.
   */
  void setG(int g2);

  /**
   * sets the AbstractShapes width dimension.
   */
  void setW(int w2);

  /**
   * sets the AbstractShapes height dimension.
   */
  void setH(int h2);

  /**
   * sets the AbstractShapes blue color value.
   */
  void setB(int b2);

  /**
   * sets the AbstractShapes x coordinate.
   */
  void setX(int x2);

  /**
   * sets the AbstractShapes y coordinate.
   */
  void setY(int y2);
}
