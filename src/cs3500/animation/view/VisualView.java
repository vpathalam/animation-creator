package cs3500.animation.view;

import cs3500.animation.model.IReadOnlyAnimationModel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import cs3500.animation.view.panels.ExcellencePanel;

/**
 * Visual View Class that will be used to represent a view class of IView. Using java swing to
 * produce animations and make a panel of animation.
 */
public class VisualView extends AView implements IViewAnimation {

  /**
   * VisualView Constructor that takes in a model and produce a view.
   * @param am model
   */
  public VisualView(IReadOnlyAnimationModel am, int tempo) {
    this.setTitle("Excellence");
    this.setSize(am.getBackgroundW(), am.getBackgroundH());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    ExcellencePanel ep = new ExcellencePanel(am, tempo);
    ep.startTimer();
    ep.setPreferredSize(new Dimension(500, 500));
    this.add(ep, BorderLayout.CENTER);
  }

  @Override
  public void viewVisibility() {
    setVisible(true);
  }

}
