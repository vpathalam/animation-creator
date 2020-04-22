package cs3500.animation.view;

import cs3500.animation.model.IReadOnlyAnimationModel;
import javax.swing.JFrame;


/**
 * Abstract View class which supports standard views: visual, text, and svg: with commonalities.
 */
public abstract class AView extends JFrame implements IViewAnimation {
  protected IReadOnlyAnimationModel model;
  protected int tempo;

  /** Updates the current animation model to be visible with default being non visible. **/
  @Override
  public void viewVisibility() {
    setVisible(false);
  }

}
