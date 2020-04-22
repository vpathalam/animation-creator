package cs3500.animation.model;

import cs3500.animation.shapes.Shapes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** The read only model interface for an animation model(limited functionality to not edit). */

public interface IReadOnlyAnimationModel {

  /**
   * Returns the state of the entire animation as a string. The string is formatted as follows:
   * <pre>
   *   shape [shape name] [shape type]
   *
   *   motion [shape name] [tick] [x-value] [y-value] [width] [height] [red] [green] [blue]
   * </pre>
   *
   * @return the current state of motion as formatted above.
   */
  String theStateOfMotion();

  /**
   * Gets the current background of the Animation.
   *
   * @return Background which consists of a X, Y position and Width and Height.
   */
  Background getBackground();

  /**
   * Gets the current background width of the Animation.
   *
   * @return width of the current Background.
   */
  int getBackgroundW();

  /**
   * Gets the current background height of the Animation.
   *
   * @return height of the current Background.
   */
  int getBackgroundH();

  /**
   * Get the Map of shapes, with the name of shape being the key and type the value.
   *
   * @return the HashMap of shapes.
   */
  Map<String, Shapes> getShapes();

  /**
   * Get the complete list of Motions from the animation.
   *
   * @return ArrayList of Motions.
   */
  ArrayList<MotionImpl> getMotionsMap();

  /**
   * Get the shape name and type as a hashmap of strings.
   *
   * @return hashmap of string name and type.
   */
  HashMap<String, String> getShapesStringMap();

  /**
   * Returns the state of the animation as a string based on a specific tick based on tweening. the
   * tick in a specific interval.
   *
   * @return the assumed current state of motion as formatted above at a specific tick.
   */
  ArrayList<MotionImpl> getAnimationState();


}
