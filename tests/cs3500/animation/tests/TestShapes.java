package cs3500.animation.tests;


import static org.junit.Assert.assertEquals;

/** Test for shapes.
 *
public class TestShapes {

  @Test
  public void testCircleGetR() {
    //Name, Type, W, H, R, G, B, X, Y
    Circle instance = new Circle("test", "circle", 5, 10,
        125, 10, 15, -5, 7);
    int red = 125;
    assertEquals(red, instance.getR());
  }

  @Test
  public void testCircleGetG() {
    //Name, Type, W, H, R, G, B, X, Y
    Circle instance = new Circle("test", "circle", 5, 10,
        125, 10, 15, -5, 7);
    int green = 10;
    assertEquals(green, instance.getG());
  }

  @Test
  public void testCircleGetB() {
    //Name, Type, W, H, R, G, B, X, Y
    Circle instance = new Circle("test", "circle", 5, 10, 125,
        10, 15, -5, 7);
    int blue = 15;
    assertEquals(blue, instance.getB());
  }

  @Test
  public void testCircleGetName() {
    //Name, Type, W, H, R, G, B, X, Y
    Circle instance = new Circle("test", "circle", 5, 10, 125,
        10, 15, -5, 7);
    String name = "test";
    assertEquals(name, instance.getName());
  }

  @Test
  public void testCircleGetType() {
    //Name, Type, W, H, R, G, B, X, Y
    Circle instance = new Circle("test", "circle", 5, 10, 125,
        10, 15, -5, 7);
    String type = "circle";
    assertEquals(type, instance.getType());
  }

  @Test
  public void testCircleGetW() {
    //Name, Type, W, H, R, G, B, X, Y
    Circle instance = new Circle("test", "circle", 5, 10, 125,
        10, 15, -5, 7);
    int width = 5;
    assertEquals(width, instance.getW());
  }

  @Test
  public void testCircleGetH() {
    //Name, Type, W, H, R, G, B, X, Y
    Circle instance = new Circle("test", "circle", 5, 10, 125,
        10, 15, 5, -7);
    int height = 10;
    assertEquals(height, instance.getH());
  }

  @Test
  public void testCircleGetX() {
    //Name, Type, W, H, R, G, B, X, Y
    Circle instance = new Circle("test", "circle", 5, 10, 125,
        10, 15, 5, 7);
    int x = 5;
    assertEquals(x, instance.getX());
  }

  @Test
  public void testCircleGetY() {
    //Name, Type, W, H, R, G, B, X, Y
    Circle instance = new Circle("test", "circle", 5, 10, 125,
        10, 15, 5, -7);
    int y = -7;
    assertEquals(y, instance.getY());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCircleWNegative() {
    //Name, Type, W, H, R, G, B, X, Y
    Circle instance = new Circle("test", "circle", -5, 10, 125,
        10, 15, -5, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCircleHNegative() {
    //Name, Type, W, H, R, G, B, X, Y
    Circle instance = new Circle("test", "circle", 5, -10, 125,
        10, 15, 5, -7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRectangleWNegative() {
    //Name, Type, W, H, R, G, B, X, Y
    Rectangle instance = new Rectangle("test", "rectangle", -5, 10,
        125, 10, 15, -5, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRectangleHNegative() {
    //Name, Type, W, H, R, G, B, X, Y
    Rectangle instance = new Rectangle("test", "rectangle", 5, -10,
        125, 10, 15, 5, -7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTriangleWNegative() {
    //Name, Type, W, H, R, G, B, X, Y
    Triangle instance = new Triangle("test", "triangle", -5, 10, 125,
        10, 15, -5, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTriangleHNegative() {
    //Name, Type, W, H, R, G, B, X, Y
    Triangle instance = new Triangle("test", "triangle", 5, -10, 125,
        10, 15, 5, -7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSquareSizeNegative() {
    //Name, Type, Size, R, G, B, X, Y
    Rectangle instance = new Rectangle("test", "square", -10, -10,
        125, 10, 15, 5, -7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTriangleRNegative() {
    //Name, Type, W, H, R, G, B, X, Y
    Triangle instance = new Triangle("test", "triangle", 5, 10,
        -125, 10, 15, -5, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTriangleGNegative() {
    //Name, Type, W, H, R, G, B, X, Y
    Triangle instance = new Triangle("test", "triangle", 5, 10,
        125, -10, 15, 5, -7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSquareBNegative() {
    //Name, Type, Size, R, G, B, X, Y
    Rectangle instance = new Rectangle("test", "square", 10, 10,
        125, 10, -15, 5, -7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTriangleR256() {
    //Name, Type, W, H, R, G, B, X, Y
    Triangle instance = new Triangle("test", "circle", 5, 10, 256,
        10, 15, -5, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTriangleG256() {
    //Name, Type, W, H, R, G, B, X, Y
    Triangle instance = new Triangle("test", "triangle", 5, 10, 125,
        256, 15, 5, -7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSquareB256() {
    //Name, Type, Size, R, G, B, X, Y
    Rectangle instance = new Rectangle("test", "square", 10, 10, 125,
        10, 256, 5, -7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTriangleNullName() {
    //Name, Type, W, H, R, G, B, X, Y
    Triangle instance = new Triangle(null, "triangle", 5, 10, 125,
        55, 15, 5, -7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTriangleSpaceName() {
    //Name, Type, W, H, R, G, B, X, Y
    Triangle instance = new Triangle("  ", "triangle", 5, 10, 125,
        55, 15, 5, -7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSquareInvalidType() {
    //Name, Type, Size, R, G, B, X, Y
    Rectangle instance = new Rectangle("test", "invalid", 10, 10, 125,
        10, 55, 5, -7);
  }


}
*/