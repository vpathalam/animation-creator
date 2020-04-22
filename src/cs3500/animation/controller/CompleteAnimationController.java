package cs3500.animation.controller;

import cs3500.animation.model.Motion;
import cs3500.animation.model.MotionImpl;
import cs3500.animation.view.CompleteEditorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * The controller that enables the user to see the interface. Have a field for CompleteEditorView
 * and implements EnhancedIController and ActionListener.
 */
public class CompleteAnimationController implements CompleteIController, ActionListener {
  private CompleteEditorView view;

  /**
   * Constructor for a editable animation controller based on the view specified.
   * @param view the complete editable excellence view.
   */
  public CompleteAnimationController(CompleteEditorView view) {
    this.view = view;
    view.setButtonListeners(this);
  }

  /**
   * Processes the instruction of the name of the string to delete from the animation.
   * @param instr of the name of the string shape.
   **/
  public void processDeleteShapeCommand(String instr) {
    Scanner s = new Scanner(instr);
    String name = s.next();
    view.deleteShape(name);
    view.setVisualText("Deleted " + name);
  }

  /**
   * Processes the instruction to add a certain keyframe to the animation.
   * @param instr which contains the user inputs to create a specified keyframe.
   **/
  public void processCreateKButtonCommand(String instr) {
    Scanner s = new Scanner(instr);
    view.getModel().addMotion(s.next(),
            Integer.parseInt(s.next())
            , Integer.parseInt(s.next()), Integer.parseInt(s.next()),
            Integer.parseInt(s.next()),
            Integer.parseInt(s.next()), Integer.parseInt(s.next()), Integer.parseInt(s.next()),
            Integer.parseInt(s.next()));
    view.getExcellencePanel().repaint();
    view.getExcellencePanel().revalidate();
    view.setVisualText("Added Key Frame");
  }

  /**
   * Sets the view to visible when constructing an animation.
   */
  @Override
  public void animateObject() {
    view.viewVisibility();
  }


  /**
   * Processes the instruction to delete a certain keyframe from the animation.
   * @param instr the name of the keyframe and the specific tick.
   */
  public void processDeleteKButtonCommand(String instr) {
    Scanner s = new Scanner(instr);
    view.getExcellencePanel().repaint();
    view.getExcellencePanel().revalidate();
    view.setVisualText("Deleted Key Frame");
  }

  /**
   * Main controller method. Delegates functionality to excellence panel view based on input action,
   * also controls the timer and state labels.
   * @param e an ActionEvent that the user performs.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {

      case "Play":
        if (view.getExcellencePanel().getTick() == 0) {
          view.startTimer();
          view.setLabelSpeed();

          view.setVisualText("Played");
        }
        break;
      case "Resume":
        view.startTimer();

        view.setVisualText("Resumed");
        break;
      case "Pause":
        this.view.stopTimer();

        view.setVisualText("Paused");
        break;
      case "Restart":
        view.restartTimer();

        view.setVisualText("Restarting");
        break;
      case "Delete":
        String instr = view.getDeleteShapeCommand();
        try { processDeleteShapeCommand(instr);
        } catch (Exception e1) { e1.printStackTrace(); }
        break;
      case "Change Tempo":
        view.setTempo();
        view.setLabelSpeed();

        view.setVisualText("New Tempo Declared");
        break;
      case "Toggle Loop Off":
        view.toggleLoop();
        view.setVisualText("Loop is Off");
        break;
      case "Create":
        try {
          String instru = view.getCreateShapeCommand();

          processCreateShapeCommand(instru);

        } catch (NoSuchElementException n) {
          throw new IllegalArgumentException("Create Shape Input Invalid: Empty");
        } catch (IllegalArgumentException i) {
          view.setVisualText("Illegal Type Specified");
          throw new IllegalArgumentException(i);
        }
        break;
      case "add key":
        String instruc = view.getTransformationCommand();
        try {
          processCreateKButtonCommand(instruc);
        } catch (Exception e2) {
          e2.printStackTrace();
        }
        view.insertTransformation();
        view.clearMenuTrans();
        break;
      case "del key":
        String instruct = view.getTransformationCommand();
        try {
          processDeleteKButtonCommand(instruct);
          view.removeTransformation();
        } catch (IllegalArgumentException n) {
          view.setVisualText("Invalid KeyFrame Tick Specified");
          throw new IllegalArgumentException("Invalid keykrame tick specified " + n);
        }

        view.clearMenuTrans();
        break;
      default:
        break;
    }
  }

  /**
   * Processes the string instruction to add a shape to the animation.
   * @param instr of the specified shape attributes to be created.
   **/
  public void processCreateShapeCommand(String instr) {
    Scanner s = new Scanner(instr);
    String name = s.next();
    String type = s.next();
    view.createShape(name, type);
    view.setVisualText("Created " + name + " of type " + type);
  }
}
