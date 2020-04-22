package cs3500.animation.model;

import java.awt.Color;


import cs3500.animation.model.position.Position2D;

/**
 * Motion class represents the small descriptions needed in animation.
 */
public class MotionImpl implements Motion {

  private String sName;
  private int tick1;
  private Position2D p1;
  private Color c1;
  private int w1;
  private int h1;
  private int tick2;
  private Position2D p2;
  private Color c2;
  private int w2;
  private int h2;

  /**
   * The constructor that has same initial and final stats.
   *
   * @param sName the name of the shape
   * @param tick1 the tick 3
   * @param x1    initial x posiiton
   * @param y1    initial y position
   * @param w1    initial width
   * @param h1    initial height
   * @param r1    initial red color
   * @param g1    initial green color
   * @param b1    initial blue color
   */
  public MotionImpl(String sName, int tick1, double x1, double y1, int w1, int h1, int r1, int g1,
                    int b1) {
    if (w1 < 0 || h1 < 0) {
      throw new IllegalArgumentException("Invalid argument, negative dimensions are included.");
    }
    if (r1 < 0 || g1 < 0 || b1 < 0 || r1 > 255 || g1 > 255 || b1 > 255) {
      throw new IllegalArgumentException("Invalid argument, colors are out of 0-255 bound.");
    }

    this.sName = sName;
    this.p1 = new Position2D((int) x1, (int) y1);
    this.c1 = new Color(r1, g1, b1);
    this.w1 = w1;
    this.h1 = h1;
    this.tick1 = tick1;
    this.tick2 = tick1;
    this.p2 = new Position2D((int) x1, (int) y1);
    this.c2 = new Color(r1, g1, b1);
    this.w2 = w1;
    this.h2 = h1;
  }

  /**
   * The constructor that has different initial and final stats.
   *
   * @param sName the name of the shape
   * @param tick1 the initial tick of the shape
   * @param x1    the initial x position
   * @param y1    the initial y position
   * @param w1    the initial width
   * @param h1    the initial height
   * @param r1    initial red
   * @param g1    initial green
   * @param b1    initial blue
   * @param tick2 final tick
   * @param x2    final x position
   * @param y2    final y position
   * @param w2    final width
   * @param h2    final height
   * @param r2    final red color
   * @param g2    final green color
   * @param b2    final blue color
   */
  public MotionImpl(String sName, int tick1, double x1, double y1, int w1, int h1,
                    int r1, int g1, int b1, int tick2, double x2, double y2, int w2, int h2, int r2, int g2,
                    int b2) {
    if (w1 < 0 || w2 < 0 || h1 < 0 || h2 < 0) {
      throw new IllegalArgumentException("Invalid argument, negative dimensions are included.");
    }
    if (r1 < 0 || g1 < 0 || b1 < 0 || r1 > 255 || g1 > 255 || b1 > 255 || r2 < 0 || g2 < 0 || b2 < 0
            || r2 > 255 || g2 > 255 || b2 > 255) {
      throw new IllegalArgumentException("Invalid argument, colors are out of 0-255 bound.");
    }
    this.sName = sName;
    this.p1 = new Position2D((int) x1, (int) y1);
    this.c1 = new Color(r1, g1, b1);
    this.w1 = w1;
    this.h1 = h1;
    this.tick1 = tick1;
    this.tick2 = tick2;
    this.p2 = new Position2D((int) x2, (int) y2);
    this.c2 = new Color(r2, g2, b2);
    this.w2 = w2;
    this.h2 = h2;
  }

  /**
   * The constructor that creates a MotionImpl based on all stats.
   *
   * @param sName the name of the shape
   * @param tick1 the initial tick
   * @param tick1 the end tick
   * @param p1    initial position
   * @param w1    initial width
   * @param h1    initial height
   * @param w2    end width
   * @param h2    end height
   * @param c1    initial color
   * @param p2    end position
   * @param c2    initial blue color
   */
  public MotionImpl(String sName, int tick1, Position2D p1, Color c1, int w1, int h1, int tick2,
                    Position2D p2,
                    Color c2, int w2, int h2) {
    if (w1 < 0 || w2 < 0 || h1 < 0 || h2 < 0) {
      throw new IllegalArgumentException("Invalid argument, negative dimensions are included.");
    }
    this.sName = sName;
    this.tick1 = tick1;
    this.p1 = p1;
    this.c1 = c1;
    this.w1 = w1;
    this.h1 = h1;
    this.tick2 = tick2;
    this.p2 = p2;
    this.c2 = c2;
    this.w2 = w2;
    this.h2 = h2;
  }


  /**
   * Gets the name of the shape.
   * @return String representing the shape name.
   */
  @Override
  public String getName() {
    return this.sName;
  }

  /**
   * Gets the initial tick of the motion.
   * @return int representing the initial tick.
   */
  @Override
  public int getTick1() {
    return this.tick1;
  }


  /**
   * Gets the end of the tick of the motion.
   * @return int representing the end tick.
   */
  @Override
  public int getTick2() {
    return this.tick2;
  }

  /**
   * Gets the initial width of shape before the motion.
   * @return int representing the initial width dimension.
   */
  @Override
  public int getW1() {
    return this.w1;
  }

  /**
   * Gets the initial height of the shape before the motion.
   * @return int representing the initial height dimension.
   */
  @Override
  public int getH1() {
    return this.h1;
  }

  /**
   * Gets the end width of the shape after the motion.
   *
   * @return int representing the end width dimension.
   */
  @Override
  public int getW2() {
    return this.w2;
  }

  /**
   * Gets the end height of the shape after the motion.
   * @return int representing the end height dimension.
   */
  @Override
  public int getH2() {
    return this.h2;
  }

  /**
   * Gets the initial x poisition of the motion.
   * @return int representing the initial x coordinate.
   */
  @Override
  public int getX1() {
    return this.p1.getX();
  }

  /**
   * Gets the end x value of the position after the motion.
   *
   * @return int representing the end x coordinate.
   */
  @Override
  public int getX2() {
    return this.p2.getX();
  }

  /**
   * Gets the initial y position of the motion.
   * @return int representing the initial y coordinate.
   */
  @Override
  public int getY1() {
    return this.p1.getY();
  }

  /**
   * Gets the end y value of the position after the motion.
   *
   * @return int representing the end y coordinate.
   */
  @Override
  public int getY2() {
    return this.p2.getY();
  }

  /**
   * Gets the initial red color of the shape before the motion.
   * @return int representing the initial red color value.
   */
  @Override
  public int getR1() {
    return this.c1.getRed();
  }

  /**
   * Gets the end red color of the shape after the motion.
   * @return int representing the end red color value.
   */
  @Override
  public int getR2() {
    return this.c2.getRed();
  }

  /**
   * Gets the initial green color of the shape before the motion.
   * @return int representing the initial green color value.
   */
  @Override
  public int getG1() {
    return this.c1.getGreen();
  }

  /**
   * Gets the end green color of the shape after the motion.
   * @return int representing the end green color value.
   */
  @Override
  public int getG2() {
    return this.c2.getGreen();
  }

  /**
   * Gets the initial blue color of the shape before the motion.
   * @return int representing the initial blue color value.
   */
  @Override
  public int getB1() {
    return this.c1.getBlue();
  }

  /**
   * Gets the end blue color of the shape after the motion.
   * @return int representing the end blue color value.
   */
  @Override
  public int getB2() {
    return this.c2.getBlue();
  }

  /**
   * Gets the initial position before the motion.
   * @return Position2D representing the initial x y coordinates.
   */
  @Override
  public Position2D getInitialPos() {
    return this.p1;
  }

  /**
   * Gets the end position after the motion.
   * @return Position2D representing the end x y coordinates.
   */
  @Override
  public Position2D getEndPos() {
    return this.p2;
  }

  /**
   * Gets the initial color before the motion.
   *
   * @return Color representing the initial r g b values.
   */
  @Override
  public Color getInitialColor() {
    return this.c1;
  }

  /**
   * Gets the end color after the motion.
   * @return Color representing the end r g b values.
   */
  @Override
  public Color getEndColor() {
    return this.c2;
  }

  /**
   * Gets motion attributes based on the current tick. This uses linear interpolation, or tweening
   * to calculate intermediate values to render a shape.
   * @param currTick the current tick to be processed.
   * @return Motion with the newly set values based on linear interpolation.
   */
  @Override
  public Motion getAttributesBasedOnTick(int currTick) {
    MotionImpl m = new MotionImpl(this.sName, this.tick1, this.p1, this.c1, this.w1,
            this.h1, this.tick2, this.p2,
            this.c2, this.w2, this.h2);

    MotionImpl temp = new MotionImpl(m.getName(), currTick,
            this.linearInterpolation(currTick, m.getTick1(), m.getX1(),
                    m.getTick2(), m.getX2()),
            this.linearInterpolation(currTick, m.getTick1(), m.getY1(),
                    m.getTick2(), m.getY2()),
            (int) this.linearInterpolation(currTick, m.getTick1(), m.getW1(),
                    m.getTick2(), m.getW2()),
            (int) this.linearInterpolation(currTick, m.getTick1(), m.getH1(),
                    m.getTick2(), m.getH2()),
            (int) this.linearInterpolation(currTick, m.getTick1(), m.getR1(),
                    m.getTick2(), m.getR2()),
            (int) this.linearInterpolation(currTick, m.getTick1(), m.getG1(),
                    m.getTick2(), m.getG2()),
            (int) this.linearInterpolation(currTick, m.getTick1(), m.getB1(),
                    m.getTick2(), m.getB2()));

    return temp;

  }

  /**
   * Gets motion attributes based on the current tick. This uses linear interpolation, or tweening
   * to calculate intermediate values to render a shape.
   * @param t representing the current tick.
   * @param t1 representing the initial tick of the motion.
   * @param a representing the value to be changed initial.
   * @param t2 representing the end tick of the motion.
   * @param b representing the value to be changed end.
   * @return double based on newly set values of tweening equation.
   */
  private double linearInterpolation(int t, int t1, double a, int t2, double b) {
    if (t2 == t1) {
      return a;
    }
    return a * (t2 - t) / (t2 - t1) + b * (t - t1) / (t2 - t1);
  }
}