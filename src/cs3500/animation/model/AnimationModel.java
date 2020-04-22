package cs3500.animation.model;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Interface represents base functionality of an AnimationModel that can be view,text,svg,or edit.
 */
public interface AnimationModel extends IReadOnlyAnimationModel {

  /**
   * Sets the full arraylist of motions based on a specified input.
   * @param Motions of the motion implementations in a sequence for animating.
   * @throws IllegalArgumentException if the specified name doesn't exist.
   */
  void setMotions(ArrayList<MotionImpl> Motions);

  /**
   * It saves the given type to the name storage.
   *
   * @param name the keyword string that can store value.
   * @param type the value that needs to be stored.
   */
  void addShape(String name, String type);

  /**
   * Removes a motion based on a specific key and interval of ticks in the hashmap of String and
   * arraylit of motions.
   *
   * @param name  the key name of the motion associated.
   * @param tick1 the initial tick of the specific motion.
   * @param tick2 the end tick of the specific motion.
   * @throws NoSuchElementException if the motion doesn't exist.
   * @throws NoSuchElementException if the key doesn't exist for shape name.
   */
  void removeMotion(String name, int tick1, int tick2);

  /**
   * Created a specified motion based on given attributes to the arraylist of motions datastruct.
   * @param name name of the shape being modified in this motion.
   * @param t1 the initial tick of the motion.
   * @param x1 the initial x axis position of the shape.
   * @param y1 the initial y axis position of the shape.
   * @param w1 the initial shape width.
   * @param h1 the initial shape height.
   * @param r1 the initial shape red value 0-255.
   * @param b1 the initial shape blue value 0-255.
   * @param g1 the initial shape green value 0-255.
   * @throws IllegalArgumentException if the animation has time gaps after the motion is added.
   */
  void addMotion(String name, int t1, int x1,
                 int y1, int w1, int h1, int r1, int g1, int b1);

  /**
   * Removes a shape based on the specified name from the animation.
   * @param name name of the shape to be deleted.
   */
  void removeShape(String name);

  /**
   * Based on builder pattern implementation. Accesses the nested class to construct an animation.
   * @return AnimationModelImpl.Builder for contructing an animation model based on inputs.
   */
  AnimationModelImpl.Builder getBuilder();

}
