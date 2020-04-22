package cs3500.animation.tests;

import static org.junit.Assert.assertEquals;

import cs3500.animation.model.AnimationModel;
import cs3500.animation.model.AnimationModelImpl;
import cs3500.animation.view.IViewAnimation;
import cs3500.animation.view.TextualView;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Test;

public class TextViewTest {

  // tests normal textview
  @Test
  public void testTextView1() {

    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 10, 20)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            1000, 600, 100, 10, 1000, 0, 255, 0).build();

    IViewAnimation text = new TextualView(m, "buildings.txt", 1);

    String data = "";
    try {
      FileReader fd = new FileReader("out.svg");
      data = new String(Files.readAllBytes(Paths.get("buildings.txt")));
    } catch (IOException io) {
      throw new IllegalStateException("File not found");
    }
    System.out.println(data);

    assertEquals("canvas 0 0 10 20\n" +
        "shape R rectangle\n" +
        "motion R 1 200 200 50 100 255 0 0    1 200 200 50 100 255 0 0\n" +
        "motion R 1 200 200 50 100 255 0 0    1000 600 100 10 1000 0 255 0\n", data);
  }

  // tests 2 action one R
  @Test
  public void testTextView2() {

    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 10, 20)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            1000, 600, 100, 10, 1000, 0, 255, 0)
        .addMotion("R", 1000, 600, 100, 10, 1000, 0, 255,
            0,
            1500, 800, 700, 500, 500, 0, 255, 0).build();

    IViewAnimation text = new TextualView(m, "buildings.txt", 1);

    String data = "";
    try {
      FileReader fd = new FileReader("out.svg");
      data = new String(Files.readAllBytes(Paths.get("buildings.txt")));
    } catch (IOException io) {
      throw new IllegalStateException("File not found");
    }
    System.out.println(data);

    assertEquals("canvas 0 0 10 20\n" +
        "shape R rectangle\n" +
        "motion R 1 200 200 50 100 255 0 0    1 200 200 50 100 255 0 0\n" +
        "motion R 1 200 200 50 100 255 0 0    1000 600 100 10 1000 0 255 0\n" +
        "motion R 1000 600 100 10 1000 0 255 0    1500 800 700 500 500 0 255 0\n", data);
  }

  // tests 2 Shape one action
  @Test
  public void testTextView3() {

    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
        .declareShape("R", "rectangle")
        .declareShape("E", "ellipse")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addKeyframe("E", 10, 250, 200, 10, 20, 0, 255, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            20, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("E", 10, 200, 100, 10, 20,
            255, 0, 0, 30, 200, 250, 40, 20, 0,
            255, 0).build();

    IViewAnimation text = new TextualView(m, "buildings.txt", 1);

    String data = "";
    try {
      FileReader fd = new FileReader("out.svg");
      data = new String(Files.readAllBytes(Paths.get("buildings.txt")));
    } catch (IOException io) {
      throw new IllegalStateException("File not found");
    }
    System.out.println(data);

    assertEquals("canvas 0 0 0 0\n" +
        "shape R rectangle\n" +
        "motion R 1 200 200 50 100 255 0 0    1 200 200 50 100 255 0 0\n" +
        "motion R 1 200 200 50 100 255 0 0    20 200 200 50 100 255 0 0\n" +
        "shape E ellipse\n" +
        "motion E 10 250 200 10 20 0 255 0    10 250 200 10 20 0 255 0\n" +
        "motion E 10 200 100 10 20 255 0 0    30 200 250 40 20 0 255 0\n", data);
  }

  //checks if file does not exist
  @Test(expected = IllegalStateException.class)
  public void testTextView4() {

    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
        .declareShape("R", "rectangle")
        .declareShape("E", "ellipse")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addKeyframe("E", 10, 250, 200, 10, 20, 0, 255, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            20, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("E", 10, 200, 100, 10, 20,
            255, 0, 0, 30, 200, 250, 40, 20, 0,
            255, 0).build();

    IViewAnimation text = new TextualView(m, "buildings.txt", 1);

    String data = "";
    try {
      FileReader fd = new FileReader("built.sta");
      data = new String(Files.readAllBytes(Paths.get("built.sta.txt")));
    } catch (IOException io) {
      throw new IllegalStateException("File not found");
    }

  }
}
