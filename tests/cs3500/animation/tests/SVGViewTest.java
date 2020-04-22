package cs3500.animation.tests;

import cs3500.animation.model.AnimationModel;
import cs3500.animation.model.AnimationModelImpl;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Test;
/***
public class SVGViewTest {

  @Test
  public void testSVGView() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 10, 20)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            10,
            200, 200, 50, 100, 255, 0, 0).build();

    IView svg = new SVGView(m, "out.svg", 500);
    String data = "";
    try {
      FileReader fd = new FileReader("out.svg");
      data = new String(Files.readAllBytes(Paths.get("out.svg")));
    } catch (IOException io) {
      throw new IllegalStateException("File not found");
    }


    System.out.println(data);
    Assert.assertEquals("<svg width=\"10\" height=\"20\" version=\"1.1\"" +
        " xmlns=\"http://www.w3.org/2000/svg\">\n" +
        "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\" height=\"100\"" +
        " fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"x\" from=\"200\" to=\"200\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"y\" from=\"200\" to=\"200\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"width\" from=\"50\" to=\"50\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"height\" from=\"100\" to=\"100\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"fill\" from=\"rgb(255,0,0)\" to=\"rgb(255,0,0)\" fill=\"freeze\" />\n"
        +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" " +
        "from=\"200\" to=\"200\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" " +
        "from=\"200\" to=\"200\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"width\"" +
        " from=\"50\" to=\"50\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"height\" " +
        "from=\"100\" to=\"100\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\" "
        +
        "from=\"rgb(255,0,0)\" to=\"rgb(255,0,0)\" fill=\"freeze\" />\n" +
        "</rect>\n" +
        "</svg>", data);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testSVGView2() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 10, 20)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 10, 200, 200, 50, 100, 255, 0, 0,
            1000, 600, 100, 10, 1000, 0, 255, 0).build();

    IView svg = new SVGView(m, "out.svg", 300);
    String data = "";
    try {
      FileReader fd = new FileReader("out.svg");
      data = new String(Files.readAllBytes(Paths.get("out.svg")));
    } catch (IOException io) {
      throw new IllegalStateException("File not found");
    }

  }

  //tests if file does not exist
  @Test(expected = IllegalStateException.class)
  public void testSVGView3() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 10, 20)
        .declareShape("R", "rectangle")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            1000,
            600, 100, 10, 1000, 0, 255, 0).build();

    IView svg = new SVGView(m, "out.svg", 300);
    String data = "";
    try {
      FileReader fd = new FileReader("out.svg");
      data = new String(Files.readAllBytes(Paths.get("doesnotexist.txt")));
    } catch (IOException io) {
      throw new IllegalStateException("File not found");
    }

  }

  // tests 2 shape 1 action
  @Test
  public void testSVGView4() {
    AnimationModel m = new AnimationModelImpl.Builder().setBounds(0, 0, 0, 0)
        .declareShape("R", "rectangle")
        .declareShape("E", "ellipse")
        .addKeyframe("R", 1, 200, 200, 50, 100, 255, 0, 0)
        .addKeyframe("E", 10, 250, 200, 10, 20, 0, 255, 0)
        .addMotion("R", 1, 200, 200, 50, 100, 255, 0, 0,
            20,
            200, 200, 50, 100, 255, 0, 0)
        .addMotion("E", 10, 200, 100, 10, 20,
            255, 0, 0, 30, 200, 250, 40, 20, 0,
            255,
            0).build();

    IView svg = new SVGView(m, "out.svg", 500);
    String data = "";
    try {
      FileReader fd = new FileReader("out.svg");
      data = new String(Files.readAllBytes(Paths.get("out.svg")));
    } catch (IOException io) {
      throw new IllegalStateException("File not found");
    }


    System.out.println(data);
    Assert.assertEquals("<svg width=\"0\" height=\"0\" " +
        "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
        "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" " +
        "fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"x\" from=\"200\" to=\"200\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"y\" from=\"200\" to=\"200\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"width\" from=\"50\" to=\"50\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\"" +
        " attributeName=\"height\" from=\"100\" to=\"100\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\"" +
        " attributeName=\"fill\" from=\"rgb(255,0,0)\" to=\"rgb(255,0,0)\" fill=\"freeze\" " +
        "/>\n"
        +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"x\" from=\"200\" to=\"200\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"y\" from=\"200\" to=\"200\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\"" +
        " attributeName=\"width\" from=\"50\" to=\"50\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"height\" from=\"100\" to=\"100\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"fill\" from=\"rgb(255,0,0)\" to=\"rgb(255,0,0)\" fill=\"freeze\" />\n"
        +
        "</rect>\n" +
        "<ellipse id=\"E\" cx=\"250\" cy=\"200\" rx=\"10\" ry=\"20\" " +
        "fill=\"rgb(0,255,0)\" visibility=\"visible\" >\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"cx\" from=\"250\" to=\"250\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"cy\" from=\"200\" to=\"200\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"rx\" from=\"10\" to=\"10\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\"" +
        " attributeName=\"ry\" from=\"20\" to=\"20\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"fill\" from=\"rgb(0,255,0)\" to=\"rgb(0,255,0)\" fill=\"freeze\" " +
        "/>\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"cx\" from=\"200\" to=\"200\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"cy\" from=\"100\" to=\"250\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"rx\" from=\"10\" to=\"40\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"ry\" from=\"20\" to=\"20\" fill=\"freeze\" />\n" +
        "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" " +
        "attributeName=\"fill\" from=\"rgb(255,0,0)\" to=\"rgb(0,255,0)\" fill=\"freeze\" />\n"
        +
        "</ellipse>\n" +
        "</svg>", data);
  }
}
*/