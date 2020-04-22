package cs3500.animation.tests;


import cs3500.animation.shapes.Rectangle;
import org.junit.Test;


/**
 * test cass for motion.



public class TestMotion {

  Circle c1 = new Circle("c1", "circle", 4, 4, 255, 0, 0,
      60, 60);
  Rectangle r1 = new Rectangle("r1", "rectangle", 2, 2, 255, 0,
      0, 50, 50);
  MotionImpl m1 = new MotionImpl("t1", 1, 50, 50, 2, 2, 255,
      0, 0,
      10, 60, 60, 4, 4, 0, 255, 0);
  MotionImpl m2 = new MotionImpl("c1", 10, 60, 60, 4,
      4, 0, 255, 0, 20,
      70, 70, 6, 6, 0, 0, 255);

  @Test(expected = IllegalArgumentException.class)
  public void invalidMotionTicks() {
    MotionImpl m3 = new MotionImpl("r1", -1, 50, 50, 2,
        2, 255, 0, 0, 10, 60, 60, 4, 4, 0, 255,
        0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMotionTicks3() {
    MotionImpl m3 = new MotionImpl("r1", 20, 50, 50, 2,
        2, 255, 0, 0, 1, 60, 60, 4, 4, 0, 255,
        0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMotionDimsW() {
    MotionImpl m3 = new MotionImpl("r1", -1, 50, 50, 2,
        2, 255, 0, 0, 10, 60, 60, -4, 4, 0, 255,
        0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMotionDimsH() {
    MotionImpl m3 = new MotionImpl("r1", -1, 50, 50, 2,
        2, 255, 0, 0, 10, 60, 60, 4, -4, 0, 255,
        0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMotionColor() {
    MotionImpl m3 = new MotionImpl("r1", -1, 50, 50, 2,
        2, -255, 0, 0, 10, 60, 60, 4, 4, 0, 255,
        0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMotionColor2() {
    MotionImpl m3 = new MotionImpl("r1", -1, 50, 50, 2,
        2, 255, -5, 0, 10, 60, 60, 4, 4, 0, 255,
        0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMotionColor3() {
    MotionImpl m3 = new MotionImpl("r1", -1, 50, 50, 2,
        2, 255, 0, -5, 10, 60, 60, 4, 4, 0, 255,
        0);
  }
}
*/