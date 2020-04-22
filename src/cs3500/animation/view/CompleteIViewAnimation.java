package cs3500.animation.view;

import cs3500.animation.model.AnimationModel;
import cs3500.animation.view.panels.MenuPanel;
import cs3500.animation.view.panels.ExcellencePanel;

/** An interface that is an extension of a standard IView to allow for editor functionality. */
public interface CompleteIViewAnimation extends IViewAnimation {

  /** Starts the animation timer which increments ticks. */
  void startTimer();

  /** Pauses the current timer, hence making the animation freeze in its current state. */
  void stopTimer();

  /** Restarts the timer by making tick = 0 again. */
  void restartTimer();

  /** Removes a shape and all of its motions from the current animation.
   * @param name the name of the Shape to be deleted.
   * */
  void deleteShape(String name);

  /**
   * Creates a new shape in the animation based on the input parameters, name and type of shape.
   * @param name the name of the Shape to be created.
   * @param type the type of the shape to be created, either rectangle or ellipse.
   */
  void createShape(String name, String type);

  /**
   * Getter to return the animation excellence panel.
   * @return the excellence panel of the current animation.
   */
  ExcellencePanel getExcellencePanel();

  /**
   * Toggles the loop off if on and on if off. Looping functionality allows for an animation to
   * restart automatically indefinitely once it ends.
   */
  void toggleLoop();

  /**
   * Sets the current tempo label on the UI based on the current tempo of the animation.
   */
  void setLabelSpeed();

  /**
   * Presents a shape related instruction to create a new object to be added to the animation.
   * @return an instruction of name and type, attributes of the shape to be created in String form.
   */
  String getCreateShapeCommand();


  /**
   * Presents a shape related instruction to delete a new object to be removed from the animation.
   * @return an instruction of name of the shape to be deleted in String form.
   */
  String getDeleteShapeCommand();

  /**
   * Retrieves the motion related instruction to be performed.
   * @return an instruction of attributes of the motion in String form.
   */
  String getTransformationCommand();

  /**
   * Adds a new motion to the current animation.
   */
  void insertTransformation();

  /**
   * Removes a specified motion from the current animation.
   */
  void removeTransformation();

  /**
   * Zeroes the motion field for resetting functionality.
   */
  void clearMenuTrans();


  /**
   * Retrieves the menu panel of the current animation.
   * @return the MenuPanel of the current animation.
   */
  MenuPanel getMenuPanel();

  /**
   * Sets a text label on the button panel to show the most recently completed action.
   * @param s a string to set the text label to.
   */
  void setVisualText(String s);

  /**
   * Sets the animation to a current tick/second tempo to be played at.
   * @handles NumberFormatException if non-integer input.
   * @throws IllegalArgumentException if a negative tempo is specified.
   */
  void setTempo();

  /**
   * Retrieves the current animation model with full privileges.
   * @return AnimationModel the current animation model with full functionality.
   */
  AnimationModel getModel();
}