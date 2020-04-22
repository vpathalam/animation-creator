package cs3500.animation.shapes;

import java.util.Objects;

/**
 * Class representing a type of shape, circle extension of abstract shape.
 */
public class Ellipse extends AbstractShape {

  public Ellipse(String name, String type, int width, int height, int r, int g, int b, int x,
      int y) {
    super(name, type, r, g, b, x, y, width, height);
  }

  /**
   * Checks to see if two circle objects are equal based on attributes.
   *
   * @return boolean whether equal or not based on attributes.
   */
  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Ellipse)) {
      return false;
    }
    Ellipse c = (Ellipse) o;
    return this.name == c.name && this.type == c.type && this.width == c.width &&
        this.height == c.height &&
        this.r == c.r && this.g == c.g
        && this.b == c.b &&
        this.x == c.x && this.y == c.y;
  }

  /**
   * Creates a hashcode for the given Circle.
   *
   * @return int representing unique hashcode in memory.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, type, width, height, r, g, b, x, y);
  }
}
