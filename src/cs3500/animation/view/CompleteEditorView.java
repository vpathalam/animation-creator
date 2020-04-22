package cs3500.animation.view;

import cs3500.animation.model.IReadOnlyAnimationModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import cs3500.animation.model.AnimationModel;
import cs3500.animation.view.panels.ButtonPanel;
import cs3500.animation.view.panels.MenuPanel;
import cs3500.animation.view.panels.ExcellencePanel;

/** Modifiable version of visual view that has new panels to construct an animation class. */
public class CompleteEditorView extends JFrame implements CompleteIViewAnimation {

  private AnimationModel model;
  private ButtonPanel bp;
  private ExcellencePanel ep;
  private MenuPanel mp;


  /**
   * Constructor for editor view that sets the JFrame layout with panels and inputs.
   * @param model IReadOnlyAnimationModel that has only getters.
   * @param tempo the ticks per second the animation will operate at.
   */
  public CompleteEditorView(IReadOnlyAnimationModel model, int tempo) {
    this.model = (AnimationModel) model;
    VisualView vView = new VisualView(model, tempo);

    this.setTitle(vView.getTitle());
    this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

    this.setSize(vView.getSize());
    this.setDefaultCloseOperation(vView.getDefaultCloseOperation());

    this.setLayout(vView.getLayout());
    this.ep = new ExcellencePanel(model, tempo);
    ep.setPreferredSize(new Dimension(500, 500));
    this.add(ep, BorderLayout.CENTER);

    bp = new ButtonPanel();
    this.add(bp, BorderLayout.NORTH);

    mp = new MenuPanel(model.getShapesStringMap());
    this.add(mp, BorderLayout.SOUTH);
    ep.startTimer();
  }

  /**
   * Declared button listeners to set up functionality in button panel and menu panel.
   * @param mouseClick this occurs on a mouse click.
   */
  public void setButtonListeners(ActionListener mouseClick) {
    bp.setListeners(mouseClick);
    mp.setButtonListener(mouseClick);
  }

  /** Updates the current animation model to be visible. **/
  @Override
  public void viewVisibility() {
    setVisible(true);
  }

  /**
   * Retrieves the current animation model with full privileges.
   * @return AnimationModel the current animation model with full functionality.
   */
  @Override
  public AnimationModel getModel() {
    return this.model;
  }

  /** Starts the animation timer which increments ticks. */
  @Override
  public void startTimer() {
    ep.startTimer();
  }

  /** Pauses the current timer, hence making the animation freeze in its current state. */
  @Override
  public void stopTimer() {
    ep.stopTimer();
  }

  /** Restarts the timer by making tick = 0 again. */
  @Override
  public void restartTimer() {
    ep.restartTimer();
  }

  /** Removes a shape and all of its motions from the current animation.
   * @param name the name of the Shape to be deleted.
   * */
  @Override
  public void deleteShape(String name) {
    ep.deleteShape(name);
  }

  /**
   * Getter to return the animation excellence panel.
   * @return the excellence panel of the current animation.
   */
  @Override
  public ExcellencePanel getExcellencePanel() {
    return this.ep;
  }

  /**
   * Toggles the loop off if on and on if off. Looping functionality allows for an animation to
   * restart automatically indefinitely once it ends.
   */
  @Override
  public void toggleLoop() {
    ep.toggleLoop();
    if (ep.getLoop()) {
      bp.setToggleLabel("Toggle Loop Off");
    } else {
      bp.setToggleLabel("Toggle Loop On");
    }
  }

  /**
   * Presents a shape related instruction to create a new object to be added to the animation.
   * @return an instruction of name and type, attributes of the shape to be created in String form.
   */
  @Override
  public String getCreateShapeCommand() {
    String command = null;
    if (!(mp.getShapeType().equals("rectangle") || mp.getShapeType().equals("ellipse"))) {
      throw new IllegalArgumentException("Illegal Type");
    }
    if (mp.getShapeName().equals("") || mp.getShapeType().equals("")) {
      bp.setVisualLabel("Input cannot be empty");
      throw new IllegalArgumentException("Input cannot be empty ok2");
    }
    if (!model.getShapes().containsKey(this.mp.getShapeName())) {
      command = this.mp.getShapeName() + " " + this.mp.getShapeType();
      mp.addShape(mp.getShapeName());
      this.mp.setShapeName("");
      this.mp.setShapeType("");
    } else {
      bp.setVisualLabel("Shape name already exists");
    }
    return command;
  }

  /**
   * Presents a shape related instruction to delete a new object to be removed from the animation.
   * @return an instruction of name of the shape to be deleted in String form.
   */
  @Override
  public String getDeleteShapeCommand() {
    String command = null;
    if (mp.getShapeName().equals("")) {
      throw new IllegalArgumentException("Input cannot be empty");
    }
    if (model.getShapes().containsKey(this.mp.getShapeName())) {
      command = this.mp.getShapeName() + " " + this.mp.getShapeType();
      mp.removeList(mp.getShapeName());
      mp.setShapeName("");
    } else {
      bp.setVisualLabel("No shape with such name");
    }
    return command;
  }

  /**
   * Retrieves the motion related instruction to be performed.
   * @return an instruction of attributes of the motion in String form.
   */
  @Override
  public String getTransformationCommand() {
    return mp.getMotionFields();
  }

  /**
   * Adds a new motion to the current animation.
   */
  @Override
  public void insertTransformation() {
    ep.addMotion(mp.getKshapeName(), mp.getKShapeTick(),
            mp.getShapeXPos(), mp.getShapeYPos(), mp.getShapeWidth(), mp.getShapeHeight(),
            mp.getShapeRed(), mp.getShapeGreen(), mp.getShapeBlue());

  }

  /**
   * Removes a specified motion from the current animation.
   */
  @Override
  public void removeTransformation() {
    ep.deleteMotion(mp.getKshapeName(), mp.getKShapeTick());
  }

  /**
   * Zeroes the motion field for resetting functionality.
   * Zeroes the motion field for resetting functionality.
   */
  @Override
  public void clearMenuTrans() {
    mp.clearField("");
  }

  /**
   * Creates a new shape in the animation based on the input parameters, name and type of shape.
   * @param name the name of the Shape to be created.
   * @param type the type of the shape to be created, either rectangle or ellipse.
   */
  @Override
  public void createShape(String name, String type) {
    if (name == null || type == null) {
      throw new IllegalArgumentException("input can't be null");
    }
    this.getModel().addShape(name, type);
  }

  /**
   * Retrieves the menu panel of the current animation.
   * @return the MenuPanel of the current animation.
   */
  @Override
  public MenuPanel getMenuPanel() {
    return this.mp;
  }

  /**
   * Sets a text label on the button panel to show the most recently completed action.
   * @param s a string to set the text label to.
   */
  @Override
  public void setVisualText(String s) {
    bp.setVisualLabel(s);
  }

  /**
   * Sets the animation to a current tick/second tempo to be played at.
   * @handles NumberFormatException if non-integer input.
   * @throws IllegalArgumentException if a negative tempo is specified.
   */
  @Override
  public void setTempo() {
    try {
      int i = Integer.parseInt(this.bp.getTempoField().getText().trim());
      if (i < 0) { throw new IllegalArgumentException("Invalid tempo specified."); }
      ep.setTempo(i);
    } catch (NumberFormatException e) {
      System.out.println("NumberFormatException: " + e.getMessage());
    }
  }

  /**
   * Sets the tempo label to be the current animation tempo.
   */
  @Override
  public void setLabelSpeed() {
    bp.setTempoLabel("Speed " + ep.getTempo());
  }

}
