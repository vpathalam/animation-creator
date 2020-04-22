package cs3500.animation.controller;


import cs3500.animation.view.IViewAnimation;

/**
 * A controller class that is used to coordinate the model and the view based on user input.
 **/
public class AnimationController implements IController {

  private IViewAnimation view;

  /**
   * Controller constructor for visual, text, svg view that takes a view param.
   * @param view the given view (text, svg, or visual)
   */
  public AnimationController(IViewAnimation view) {
    this.view = view;
  }

  /**
   * Sets the view to visible when constructing an animation.
   */
  @Override
  public void animateObject() {
    this.view.viewVisibility();
  }
}
