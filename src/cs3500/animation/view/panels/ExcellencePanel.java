package cs3500.animation.view.panels;
import cs3500.animation.model.MotionImpl;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import cs3500.animation.model.IReadOnlyAnimationModel;
import cs3500.animation.model.Motion;

/**
 * ExcellencePanel which is used to draw the animation based on shapes and motions onto the UI. */
public class ExcellencePanel extends JPanel implements ActionListener {
  private IReadOnlyAnimationModel model;

  private int tick;
  private Timer timer;

  private int tempo;
  private boolean loop;

  private ArrayList<MotionImpl> motions;
  private ArrayList<MotionImpl> linearInterpMotions;


  /**
   * Excellence panel constructor that takes in model.
   *
   * @param model AnimationModel class.
   */
  public ExcellencePanel(IReadOnlyAnimationModel model, int tempo) {
    this.model = model;
    this.tempo = tempo;
    this.timer = new Timer(1000 / this.tempo, this);
    this.tick = 0;
    this.loop = true;
    this.motions = model.getMotionsMap();
    this.linearInterpMotions = model.getAnimationState();
    this.setBackground(Color.WHITE);
  }

  /**
   * Paints the user interface component given the current shapes and motions based on tick.
   * @param g the graphics to be composed.
   */
  protected void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    super.paintComponent(g);
    for (MotionImpl m : this.linearInterpMotions) {
      g2d = (Graphics2D) g.create();
      if (m.getTick1() == tick) {
        g2d.setColor(new Color(m.getR1(), m.getG1(),
                m.getB1()));
        if (model.getShapesStringMap().get(m.getName()).equals("ellipse")) {
          g2d.drawOval(m.getX1(), m.getY1(), m.getW1(),
                  m.getH1());
          g2d.fillOval(m.getX1(), m.getY1(), m.getW1(),
                  m.getH1());

        } else if (model.getShapesStringMap().get(m.getName()).equals("rectangle")) {
          g2d.drawRect(m.getX1(), m.getY1(), m.getW1(),
                  m.getH1());
          g2d.fillRect(m.getX1(), m.getY1(), m.getW1(),
                  m.getH1());
        } }
      g2d.dispose();
    }
  }

  /**
   * Performs based on an action to increment tick, account for looping, and repaint per tick.
   * @param action of the ActionEvent.
   */
  @Override
  public void actionPerformed(ActionEvent action) {
    tick++;
    if (loop) {
      if (tick > linearInterpMotions.size() / model.getShapes().size()) {
        tick = 0;
      }
    }
    repaint();
  }

  /**
   * Kicks off the timer of the animation to keep track of time.
   */
  public void startTimer() {
    this.timer.start();
  }

  /**
   * Pauses the timer of the animation to halt movement at its current state.
   */
  public void stopTimer() {
    this.timer.stop();
  }

  /**
   * Restarts the timer of the animation, thereby retarting the animation itself.
   */
  public void restartTimer() {
    tick = 0;
    this.timer.restart();
  }

  /**
   * Retrieves the current tick (point in time) of the animation.
   * @return int current tick of animation state.
   */
  public int getTick() {
    return this.tick;
  }


  /**
   * Toggles the loop functionality to either continue looping or stop looping based on previous.
   */
  public void toggleLoop() {
    if (this.loop) {
      this.loop = false;
    } else {
      this.loop = true;
    }
  }

  /**
   * Retrieves the current state of the looping for the animation.
   * @return boolean representing whether the current animation will loop or not.
   */
  public boolean getLoop() {
    return this.loop;
  }

  /**
   * Creates a deep copy based on the given motion attributes, and inserts it into the list of
   * motions in the animation.
   * @param name the name of shape.
   * @param tick  initial tick.
   * @param x1   initial x position.
   * @param y1   initial y position.
   * @param w1   initial width.
   * @param h1   initial height.
   * @param r1   initial red color.
   * @param g1   initial green color.
   * @param b1   initial blue color.
   * @throws IllegalArgumentException when there is an illegal input value.
   */
  public void addMotion(String name, int tick, int x1, int y1,
                        int w1, int h1, int r1, int g1, int b1) {

    if (model.getShapes().containsKey(name)) {
      MotionImpl first = null;
      MotionImpl last = null;

        for (MotionImpl motion : motions) {
          if (tick < motion.getTick2() && tick > motion.getTick1()) {
            first = motion;
          } else if (tick > motion.getTick2()) {
            if (last != null && motion.getTick2() > last.getTick2()) {
              last =  motion;
            } else {
              last =  motion;
            } } }


      if (last != null) {
        motions.add(new MotionImpl(name, first.getTick1(), first.getX1(),
                first.getY1(), first.getW1(), first.getH1(),
                first.getR1(), first.getG1(), first.getB1(),
                tick, x1, y1, w1, h1, r1, g1, b1));
        motions.add(new MotionImpl(name, tick, (int) x1, (int) y1, w1, h1, r1, g1, b1, first.getTick2(),
                first.getX2(), first.getY2(), first.getW2(),
                first.getH2(), first.getR2(), first.getG2(), first.getB2()));
      } else if (first != null) {
        motions.add(new MotionImpl(name, last.getTick1(), last.getX1(),
                last.getY1(), last.getW1(), last.getH1(),
                last.getR1(), last.getG1(), last.getB1(),
                tick, (int) x1, (int) y1, w1, h1, r1, g1, b1));
      } else {
        throw new IllegalArgumentException("Invalid input value.");
      } }
    linearInterpMotions = model.getAnimationState();
  }


  /**
   * Deletes a motion based on the name of the shape being transformed and
   * @param name name of shape
   * @param t1   initial tick
   * @throws IllegalArgumentException when there is a null start or end specified.
   */
  public void deleteMotion(String name, int t1) {
    Motion end = null;
    Motion start = null;
    ArrayList<MotionImpl> toRemove = new ArrayList<>();
    if (model.getShapes().containsKey(name)) {
      for(MotionImpl motion : motions) {
        if (motion.getName().equals(name) && motion.getTick2() == t1) {
          start = motion;
          toRemove.add(motion);
        }
        if (motion.getName().equals(name) && motion.getTick1() == t1) {
          end = motion;
          toRemove.add(motion);
        }
      }
      motions.removeAll(toRemove);
    }
    if (end != null && start != null) {
      motions.add(new MotionImpl(name, start.getTick1(), start.getX1(),
              start.getY1(), start.getW1(),
              start.getH1()
              , start.getR1(), start.getG1(),
              start.getB1(), end.getTick2(),
              end.getX2(), end.getY2(), end.getW2(),
              end.getH2(),
              end.getR2(), end.getG2(), end.getB2()));
    } else if (end == null && start == null) {
      throw new IllegalArgumentException("Null End & Start");
    }
    linearInterpMotions = model.getAnimationState();
    this.revalidate();
  }


  /**
   * Deletes a shape from the current animation, thereby removing any of its motions as well.
   * @param name of the shape to be removed.
   */
  public void deleteShape(String name) {
    ArrayList<MotionImpl> toRemove = new ArrayList<>();

    for(MotionImpl motion : motions) {
      if(motion.getName().equals(name)) {
        toRemove.add(motion);
      }
    }
    motions.removeAll(toRemove);
    model.getShapes().remove(name);
    linearInterpMotions = model.getAnimationState();
  }

  /**
   * Verifies whether or not the timer is running.
   * @return boolean based on whether timer is running or not.
   */
  public boolean isTimerRunning() {
    return this.timer.isRunning();
  }

  /**
   * Retrieves the largest tick of the animation.
   * @return int the maximum tick of the current animation.
   */
  public int getMaxTick() {
    return this.linearInterpMotions.size() / model.getShapes().size();
  }

  /**
   * Sets the current animation tick to the specified value.
   * @param tick based on what tick to set.
   */
  public void setTick(int tick) {
    this.tick = tick;
  }


  /**
   * Sets the excellence panel animation to a certain ticks/second tempo.
   * @param tempo the adjusted tempo.
   */
  public void setTempo(int tempo) {
    if (this.tempo < 0) {
      throw new IllegalArgumentException("Tempo is invalid.");
    } else {
      this.tempo = tempo;
      timer.setDelay(1000 / tempo);
    }
  }

  /**
   * Retrieves the current ticks/second tempo of the animation.
   * @return int the current tempo.
   */
  public int getTempo() {
    return this.tempo;
  }

}

