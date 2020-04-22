package cs3500.animation.tests;

import cs3500.animation.controller.CompleteAnimationController;

import cs3500.animation.model.AnimationModel;
import cs3500.animation.model.AnimationModelImpl;
import cs3500.animation.view.CompleteEditorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test Controller.
 **/
public class ControllerTest {

  @Test
  public void testNotPlaying() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            10,
            200, 200, 50, 100, 255, 0, 0)
        .build();
    CompleteEditorView evv = new CompleteEditorView(m, 1);
    ActionListener al = new CompleteAnimationController(evv);
    JButton button1 = new JButton();
    ActionEvent ae = new ActionEvent(this, 1, "Play");
    Assert.assertEquals(false, evv.getExcellencePanel().isTimerRunning());
  }

  @Test
  public void testPlay() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            10,
            200, 200, 50, 100, 255, 0, 0)
        .build();
    CompleteEditorView evv = new CompleteEditorView(m, 1);
    ActionListener al = new CompleteAnimationController(evv);
    JButton button1 = new JButton();
    ActionEvent ae = new ActionEvent(this, 1, "Play");
    Assert.assertEquals(false, evv.getExcellencePanel().isTimerRunning());
  }

  @Test
  public void testTweening() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            3,
            200, 200, 50, 100, 255, 0, 0).addMotion("R", 3, 200, 200, 50, 100, 255, 0, 0,
            5,
            200, 200, 50, 100, 0, 255, 0)
        .build();
    CompleteEditorView evv = new CompleteEditorView(m, 1);
    ActionListener al = new CompleteAnimationController(evv);
    JButton button1 = new JButton();
    ActionEvent ae = new ActionEvent(this, 1, "Play");
  }
}

/**
  @Test
  public void testResume() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            10,
            200, 200, 50, 100, 255, 0, 0)
        .build();
    EnhancedVisualView evv = new EnhancedVisualView(m, 1);
    ActionListener al = new EnhancedController(evv);
    JButton button1 = new JButton();
    ActionEvent ae = new ActionEvent(this, 1, "Resume");

    al.actionPerformed(ae);

    Assert.assertEquals(true, evv.getVisualPanel().isTimerRunning());
  }

  @Test
  public void testPause() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            10,
            200, 200, 50, 100, 255, 0, 0)
        .build();
    EnhancedVisualView evv = new EnhancedVisualView(m, 1);
    ActionListener al = new EnhancedController(evv);
    JButton button1 = new JButton();
    ActionEvent ae = new ActionEvent(this, 1, "Pause");

    al.actionPerformed(ae);

    Assert.assertEquals(false, evv.getVisualPanel().isTimerRunning());
  }

  @Test
  public void testRestart() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            10,
            200, 200, 50, 100, 255, 0, 0)
        .build();
    EnhancedVisualView evv = new EnhancedVisualView(m, 1);
    ActionListener al = new EnhancedController(evv);
    JButton button1 = new JButton();
    ActionEvent ae = new ActionEvent(this, 1, "Restart");

    al.actionPerformed(ae);

    Assert.assertEquals(0, evv.getVisualPanel().getTick());
  }

  @Test
  public void testDelete() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            10,
            200, 200, 50, 100, 255, 0, 0)
        .build();
    EnhancedVisualView evv = new EnhancedVisualView(m, 1);
    ActionListener al = new EnhancedController(evv);
    JButton button1 = new JButton();
    ActionEvent ae = new ActionEvent(this, 1, "Delete");
    evv.getMenuPanel().setShapeNameText("R");

    al.actionPerformed(ae);

    Assert.assertEquals(false, evv.getModel().getShapes().containsKey("R"));
  }

  @Test
  public void testIncreaseSpeed() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            10,
            200, 200, 50, 100, 255, 0, 0)
        .build();
    EnhancedVisualView evv = new EnhancedVisualView(m, 1);
    ActionListener al = new EnhancedController(evv);
    JButton button1 = new JButton();
    ActionEvent ae = new ActionEvent(this, 1, "+1 speed");

    al.actionPerformed(ae);

    Assert.assertEquals(2, evv.getVisualPanel().getSpeed());
  }

  @Test(expected = ArithmeticException.class)
  public void testDecreaseSpeed() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            10,
            200, 200, 50, 100, 255, 0, 0)
        .build();
    EnhancedVisualView evv = new EnhancedVisualView(m, 1);
    ActionListener al = new EnhancedController(evv);
    JButton button1 = new JButton();
    ActionEvent ae = new ActionEvent(this, 1, "-1 speed");

    al.actionPerformed(ae);

    Assert.assertEquals(0, evv.getVisualPanel().getSpeed());
  }

  @Test
  public void testToggleLoopOn() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            10,
            200, 200, 50, 100, 255, 0, 0)
        .build();
    EnhancedVisualView evv = new EnhancedVisualView(m, 1);
    ActionListener al = new EnhancedController(evv);
    JButton button1 = new JButton();
    ActionEvent ae = new ActionEvent(this, 1, "Toggle Loop On");

    al.actionPerformed(ae);

    Assert.assertEquals(true, evv.getVisualPanel().getLoop());
  }

  @Test
  public void testCreateShape() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            10,
            200, 200, 50, 100, 255, 0, 0)
        .build();
    EnhancedVisualView evv = new EnhancedVisualView(m, 1);
    ActionListener al = new EnhancedController(evv);
    JButton button1 = new JButton();
    ActionEvent ae = new ActionEvent(this, 1, "Create");
    evv.getMenuPanel().setShapeNameText("C");
    evv.getMenuPanel().setShapeTypeText("rectangle");

    al.actionPerformed(ae);

    Assert.assertEquals(true, evv.getModel().getShapes().containsKey("C"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoElement() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            10,
            200, 200, 50, 100, 255, 0, 0)
        .build();
    EnhancedVisualView evv = new EnhancedVisualView(m, 1);
    ActionListener al = new EnhancedController(evv);
    JButton button1 = new JButton();
    ActionEvent ae = new ActionEvent(this, 1, "Create");
    evv.getMenuPanel().setShapeNameText("");
    evv.getMenuPanel().setShapeTypeText("");

    al.actionPerformed(ae);

  }
}*/