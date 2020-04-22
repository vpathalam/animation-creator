package cs3500.animation.shapes;

import java.util.Objects;

/**
 * Class representing a type of shape, rectangle extension of abstract shape.
 */
public class Rectangle extends AbstractShape {

  public Rectangle(String name, String type, int width, int height, int r, int g, int b, int x,
      int y) {
    super(name, type, r, g, b, x, y, width, height);
  }

  /**
   * Checks to see if two Rectangle objects are equal based on attributes.
   *
   * @return boolean whether equal or not based on attributes.
   */
  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Rectangle)) {
      return false;
    }
    Rectangle r = (Rectangle) o;
    return this.name == r.name && this.type == r.type && this.width == r.width &&
        this.height == r.height && this.r == r.r && this.g == r.g && this.b == r.b &&
        this.x == r.x && this.y == r.y;
  }

  /**
   * Creates a hashcode for the given Rectangle.
   *
   * @return int representing unique hashcode in memory.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, type, width, height, r, g, b, x, y);
  }
}
