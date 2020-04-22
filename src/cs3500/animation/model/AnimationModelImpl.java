package cs3500.animation.model;

import cs3500.animation.shapes.Ellipse;
import cs3500.animation.shapes.Rectangle;
import cs3500.animation.shapes.Shapes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import cs3500.animation.model.animator.util.AnimationBuilder;


/**
 * Class that implements functionality specified in AnimationModel to create and modify excellence.
 */
public class AnimationModelImpl implements AnimationModel {
  private Background background;
  private Map<String, Shapes> shapes;
  private ArrayList<MotionImpl> motions;
  private Builder builder;

  /**
   * Constructor for the AnimationModelImpl class which takes in a builder for construction.
   * @param build the given animation builder.
   */
  public AnimationModelImpl(Builder build) {
    this.builder = build;
    this.shapes = build.shapes;
    this.background = build.background;
    this.motions = build.motions;
  }

  @Override
  public String theStateOfMotion() {
    StringBuilder res = new StringBuilder();
    res.append("canvas " + background.getX() + " " + background.getY() + " " +
            background.getWidth() + " " + background.getHeight() + " ");
    res.append("\n");
    for (String name : this.shapes.keySet()) {
      res.append("shape" + " " + name + " " + this.shapes.get(name).getType());
      res.append("\n");
      for (MotionImpl motion : this.motions) {
        if (motion.getName().equals(name)) {
          res.append("motion" + " "
                  + name + " "
                  + motion.getTick1()
                  + " " + motion.getX1()
                  + " "
                  + motion.getY1() + " "
                  + motion.getW1() + " "
                  + motion.getH1() + " "
                  + motion.getR1() + " "
                  + motion.getG1() + " "
                  + motion.getB1()
                  + "    "
                  + motion.getTick2() + " "
                  + motion.getX2()
                  + " " + motion.getY2() + " " +
                  + motion.getW2() + " "
                  + motion.getH2() + " "
                  + motion.getR2() + " "
                  + motion.getG2() + " "
                  + motion.getB2() +
                  "\n");
        }
      }
    }
    return res.toString();
  }

  @Override
  public Background getBackground() {
    Background deepCopy = new Background(this.background.getX(), this.background.getY(),
            this.background.getWidth(), this.background.getHeight());

    return deepCopy;
  }

  /**
   * Gets the current background width of the Animation.
   *
   * @return width of the current Background.
   */
  @Override
  public int getBackgroundW() {
    return this.background.getWidth();
  }

  /**
   * Gets the current background height of the Animation.
   *
   * @return height of the current Background.
   */
  @Override
  public int getBackgroundH() {
    return this.background.getHeight();
  }

  @Override
  public Map<String, Shapes> getShapes() {
    return this.shapes;
  }


  @Override
  public HashMap<String, String> getShapesStringMap() {
    HashMap<String, String> clone = new HashMap<String, String>();
    for (String name : this.shapes.keySet()) {
      String type = shapes.get(name).getType();
      clone.put(name, type);
    }
    return clone;
  }

  @Override
  public ArrayList<MotionImpl> getMotionsMap() {
    return this.motions;
  }

  @Override
  public void setMotions(ArrayList<MotionImpl> Motions) {
    this.motions = Motions;
  }

  @Override
  public ArrayList<MotionImpl> getAnimationState() {
    ArrayList<MotionImpl> res = new ArrayList<MotionImpl>();
    for (Motion m : this.motions) {
      int currTick = m.getTick2();
      while (currTick >= m.getTick1()) {
        MotionImpl updated = (MotionImpl) m.getAttributesBasedOnTick(currTick);
        res.add(updated);
        currTick -= 1;
      }
    }
    return res;
  }

  @Override
  public void addShape(String name, String type) {
    if (type.equals("rectangle")) {
      Rectangle shape1 = new Rectangle(name, type, 0, 0, 0, 0, 0, 0,
              0);
      this.shapes.put(name, shape1);
    } else if (type.equals("ellipse")) {
      Ellipse shape2 = new Ellipse(name, type, 0, 0, 0, 0, 0, 0,
              0);
      this.shapes.put(name, shape2);
    }
    else {
      throw new IllegalArgumentException("Invalid type");
    }
  }

  @Override
  public void removeMotion(String name, int tick1, int tick2) {
    ArrayList<MotionImpl> toRemove = new ArrayList<>();

    for(MotionImpl motion : motions) {
      if (motion.getName().equals(name)
              && motion.getTick1() == tick1
              && motion.getTick2() == tick2) {
        toRemove.add(motion);
      }
    }
    motions.removeAll(toRemove);
  }

  @Override
  public void addMotion(String name, int t1, int x1,
                        int y1, int w1, int h1, int r1, int g1, int b1) {
    MotionImpl temp = new MotionImpl(name, t1, x1, y1, w1, h1, r1, g1, b1);
    if (!this.motions.add(temp)) {
      throw new IllegalArgumentException("Keyframe Not Found");
    }
  }

  @Override
  public void removeShape(String name) {
    ArrayList<MotionImpl> mtns = getMotionsMap();
    ArrayList<MotionImpl> toRemove = new ArrayList<>();
    for (MotionImpl motion : mtns) {
      if(motion.getName().equals(name)) {
        toRemove.add(motion);
      }
    }
    motions.removeAll(toRemove);
    getShapes().remove(name);
  }

  @Override
  public AnimationModelImpl.Builder getBuilder() {
    return builder;
  }


  /**
   * The builder that builds up the animation using methods provided by the AnimationBuilder
   * interface. Each method call can be followed by another method call, constructing a final
   * document to the last, and build it.
   */
  public static class Builder implements AnimationBuilder<AnimationModel> {

    private Background background = new Background(0, 0, 500, 500);
    private Map<String, Shapes> shapes = new LinkedHashMap<>();
    private ArrayList<MotionImpl> motions = new ArrayList<>();
    private HashMap<String, Integer> keyframeEndpoints = new LinkedHashMap<>();

    @Override
    public AnimationModel build() {
      return new AnimationModelImpl(this);
    }

    @Override
    public AnimationBuilder<AnimationModel> setBounds(int x, int y, int width, int height) {
      if (width < 0 || height < 0) {
        throw new IllegalArgumentException("Invalid height or width parameter, negative.");
      } else {
        this.background = new Background(x, y, width, height);
        return this;
      }
    }

    @Override
    public AnimationBuilder<AnimationModel> declareShape(String name, String type) {
      if (type.equals("rectangle")) {
        this.shapes.put(name, new Rectangle(name, type, 0, 0, 0, 0, 0,
                0, 0));
      } else if (type.equals("ellipse")) {
        this.shapes.put(name, new Ellipse(name, type, 0, 0, 0, 0, 0,
                0, 0));
      }
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModel> addMotion(String name, int t1, int x1,
                                                      int y1, int w1, int h1, int r1,
                                                      int g1, int b1, int t2, int x2,
                                                      int y2, int w2, int h2,
                                                      int r2, int g2, int b2) {
      for (MotionImpl m : motions) {
        if (m.getName().equals(name) && t1 != keyframeEndpoints.get(name)) {
          throw new IllegalArgumentException("cannot have time gaps");
        }
      }
      try {
        this.keyframeEndpoints.put(name, t2);
        this.motions.add(new MotionImpl(name, t1, x1, y1, w1, h1, r1, g1, b1,
                t2, x2, y2, w2, h2, r2, g2, b2));
        return this;
      } catch (IllegalArgumentException e){
        throw new IllegalArgumentException("Invalid arguments specified for the motion.");
      }
    }

    @Override
    public AnimationBuilder<AnimationModel> addKeyframe(String name, int t, int x, int y, int w,
                                                        int h, int r, int g, int b) {
      this.keyframeEndpoints.put(name, t);
      this.motions.add(new MotionImpl(name, t, x, y, w, h, r, g, b));
      return this;
    }

  }
}









