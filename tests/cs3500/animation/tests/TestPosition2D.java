package cs3500.animation.tests;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

/**test cass for position2d.
 *

public class TestPosition2D {

  @Test
  public void testNegativeXY() {
    int x = -5;
    int y = -7;
    Position2D instance = new Position2D(x, y);
    assertEquals(instance.getX(), x);
    assertEquals(instance.getY(), y);
  }

  @Test
  public void testPosXY() {
    int x = 5;
    int y = 7;
    Position2D instance = new Position2D(x, y);
    int y2 = y;
    instance.setY(x);
    instance.setX(y2);
    assertEquals(instance.getX(), y2);
    assertEquals(instance.getY(), x);
  }

  @Test
  public void testPos1Equals() {
    int x = 5;
    int y = 7;
    Position2D instance = new Position2D(x, y);
    int x2 = 5;
    int y2 = 7;
    Position2D instance2 = new Position2D(x2, y2);
    assertEquals(true, instance.equals(instance2));
  }

  @Test
  public void testPos2Equals() {
    int x = 5;
    int y = 7;
    Position2D instance = new Position2D(x, y);
    int x2 = 7;
    int y2 = 5;
    Position2D instance2 = new Position2D(x2, y2);
    assertEquals(false, instance.equals(instance2));
  }
}
*/