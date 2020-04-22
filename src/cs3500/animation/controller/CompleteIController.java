package cs3500.animation.controller;

/**
 * A complete editable controller that allows user to manipulate the view with multiple commands.
 * Functionality is provided that is not initially allowed for IController views.
 **/
public interface CompleteIController extends IController {

  /**
   * Processes the instruction to delete a certain keyframe from the animation.
   * @param instr the name of the keyframe and the specific tick.
   */
  void processDeleteKButtonCommand(String instr);

  /**
   * Processes the instruction to add a certain keyframe to the animation.
   * @param instr which contains the user inputs to create a specified keyframe.
   **/
  void processCreateKButtonCommand(String instr);

  /**
   * Processes the instruction of the name of the string to delete from the animation.
   * @param instr of the name of the string shape.
   **/
  void processDeleteShapeCommand(String instr);

  /**
   * Processes the string instruction to add a shape to the animation.
   * @param instr of the specified shape attributes to be created.
   **/
  void processCreateShapeCommand(String instr);


}
