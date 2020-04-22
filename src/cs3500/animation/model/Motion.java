package cs3500.animation.model;

import java.awt.Color;

import cs3500.animation.model.position.Position2D;

/**
 * The interface of Motion, which represents a method contract relationship with the
 * Motion class. All methods in the interface is available to be called by the
 * Motion class that implements this interface.
 */
public interface Motion {
  /**
   * Gets the initial color before the motion.
   * @return Color representing the initial r g b values.
   */
  Color getInitialColor();

  /**
   * Gets the end color after the motion.
   * @return Color representing the end r g b values.
   */
  Color getEndColor();

  /**
   * Gets the initial position before the motion.
   * @return Position2D representing the initial x y coordinates.
   */
  Position2D getInitialPos();

  /**
   * Gets the end position after the motion.
   * @return Position2D representing the end x y coordinates.
   */
  Position2D getEndPos();

  /**
   * Gets the initial tick of the motion.
   * @return int representing the initial tick.
   */
  int getTick1();

  /**
   * Gets the initial x poisition of the motion.
   * @return double representing the initial x coordinate.
   */
  int getX1();

  /**
   * Gets the initial y position of the motion.
   * @return double representing the initial y coordinate.
   */
  int getY1();

  /**
   * Gets the initial width of shape before the motion.
   * @return int representing the initial width dimension.
   */
  int getW1();

  /**
   * Gets the initial red color of the shape before the motion.
   * @return int representing the initial red color value.
   */
  int getR1();

  /**
   * Gets the initial height of the shape before the motion.
   * @return int representing the initial height dimension.
   */
  int getH1();

  /**
   * Gets the initial green color of the shape before the motion.
   * @return int representing the initial green color value.
   */
  int getG1();

  /**
   * Gets the initial blue color of the shape before the motion.
   * @return int representing the initial blue color value.
   */
  int getB1();

  /**
   * Gets the end of the tick of the motion.
   * @return int representing the end tick.
   */
  int getTick2();

  /**
   * Gets the end x value of the position after the motion.
   *
   * @return double representing the end x coordinate.
   */
  int getX2();

  /**
   * Gets the end y value of the position after the motion.
   *
   * @return double representing the end y coordinate.
   */
  int getY2();

  /**
   * Gets the end width of the shape after the motion.
   *
   * @return int representing the end width dimension.
   */
  int getW2();

  /**
   * Gets the end red color of the shape after the motion.
   *
   * @return int representing the end red color value.
   */
  int getR2();

  /**
   * Gets the end height of the shape after the motion.
   *
   * @return int representing the end height dimension.
   */
  int getH2();

  /**
   * Gets the end green color of the shape after the motion.
   *
   * @return int representing the end green color value.
   */
  int getG2();

  /**
   * Gets the end blue color of the shape after the motion.
   *
   * @return int representing the end blue color value.
   */
  int getB2();

  /**
   * Gets the name of the shape.
   *
   * @return String representing the shape name.
   */
  String getName();

  /**
   * Gets the attributes of the motion based on the specific tick.
   *
   * @param currTick the tick at a specific interval.
   * @return returns the motion with values of a specific tick.
   */
  Motion getAttributesBasedOnTick(int currTick);
}
