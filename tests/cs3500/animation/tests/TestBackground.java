package cs3500.animation.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**test cass for background.
 *
public class TestBackground {

  @Test(expected = IllegalArgumentException.class)
  void testNegativeDimsW() {
    int x = -5;
    int y = -3;
    int w = -5;
    int h = 7;
    Background instance = new Background(x, y, w, h);
  }

  @Test(expected = IllegalArgumentException.class)
  void testNegativeDimsH() {
    int x = -5;
    int y = -3;
    int w = 5;
    int h = -7;
    Background instance = new Background(x, y, w, h);
  }

  @Test
  void testValidBG() {
    int x = -5;
    int y = -3;
    int w = 5;
    int h = 7;
    Background instance = new Background(x, y, w, h);
    assertEquals(instance.getWidth(), w);
    assertEquals(instance.getHeight(), h);
    assertEquals(instance.getX(), x);
    assertEquals(instance.getY(), y);
  }
}
*/