package cs3500.animation.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Produce a textual description of the animation that is compliant with the popular SVG file
 * format. The SVG file format is an XML-based format that can be used to describe images and
 * animations. It is an example of “vector-based graphics” where it stores explicitly the shapes to
 * be drawn and manipulations to be done on them, instead of pixel values.
 *
public class SVGView extends AView {
  /**
   * Constructs an SVGView with given model, output file location and scale of tick. Output file's
   * default is "System.out" and prints out SVG text in the console. scale works by dividing the
   * actual tick by this scale to get a unit in second.
   *
   * @param m           given AnimationModel to operate
   * @param outFileName given desired output file name
   * @param tempo       given the scale of tick
   *
  public SVGView(IReadOnlyModel m, String outFileName, int tempo) {
    super.model = m;
    super.tempo = tempo;
    if (outFileName.equals("System.out")) {
      System.out.println(this.generateSVG());
    } else {
      this.generateSVGFile(outFileName);
    }
  }

  /**
   * Generates an SVG code from each shape in the model. Adds transformation in form of animation
   * and write that in form of codes that are ready to be run by a browser that can run SVG type
   * file.
   *
   * @return String representing the SVG code
   *
  private String generateSVG() {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("<svg width=\"").append(model.getBoundingDimension().getWidth())
            .append("\" ").append("height=\"").append(model.getBoundingDimension().getHeight())
            .append("\" ").append("version=\"1.1\" ")
            .append("xmlns=\"http://www.w3.org/2000/svg\">\n");

    //for each shape add the xml code
    for (String name : model.getShapes().keySet()) {
      switch (model.getShapes().get(name)) {
        case "rectangle":
          stringBuilder.append(this.generateRectSVG(name));
          break;
        case "ellipse":
          stringBuilder.append(this.generateEllipseSVG(name));
          break;
        default:
          break;
      }
    }
    stringBuilder.append("</svg>");
    return stringBuilder.toString();
  }

  /**
   * Given a name of a shape, constructs a Rectangle SVG code for the given shape name based on the
   * Transformations recorded in the model for that shape.
   *
   * @param name given shape name
   * @return String representing a rectangle SVG code
   *
  private String generateRectSVG(String name) {
    StringBuilder stringBuilder = new StringBuilder();

    Transformation initial = null;

    //Get the initialized value of transformation that serves as the base Transformation
    for (Transformation t1 : model.getTransformations()) {
      if (t1.getName().equals(name) && t1.getT1() == t1.getT2()) {
        initial = t1;

        stringBuilder.append("<rect id=\"").append(name).append("\" ").append("x=\"")
            .append(initial.getPosition1().getX()).append("\" ").append("y=\"")
            .append(initial.getPosition1().getY()).append("\" ").append("width=\"")
            .append(initial.getDimn1().getWidth()).append("\" ").append("height=\"")
            .append(initial.getDimn1().getHeight()).append("\" ").append("fill=\"")
            .append("rgb(")
            .append(initial.getColor1().getRed()).append(",")
            .append(initial.getColor1().getGreen()).append(",")
            .append(initial.getColor1().getBlue()).append(")\" ")
            .append("visibility=\"visible\" >\n");


        //For each Transformation, add animate to XML
        //Scaling: Tick / ticktempo = second.  1 second is equal to 1000 ms
        for (Transformation t2 : model.getTransformations()) {
          if (t2.getName().equals(name)) {
            //Write XML for X change
            stringBuilder.append("<animate attributeType=\"xml\" ").append("begin=\"")
                .append((t2.getT1() / tempo) * 100).append("ms\" ")
                .append("dur=\"").append(((t2.getT2() - t2.getT1()) / tempo) * 100)
                .append("ms\" ").append("attributeName=\"x\" ").append("from=\"")
                .append(t2.getPosition1().getX()).append("\" ").append("to=\"")
                .append(t2.getPosition2().getX()).append("\" ")
                .append("fill=\"freeze\" />\n");
            //Write XML for Y change
            stringBuilder.append("<animate attributeType=\"xml\" ").append("begin=\"")
                .append((t2.getT1() / tempo) * 100).append("ms\" ")
                .append("dur=\"").append(((t2.getT2() - t2.getT1()) / tempo) * 100)
                .append("ms\" ").append("attributeName=\"y\" ").append("from=\"")
                .append(t2.getPosition1().getY()).append("\" ").append("to=\"")
                .append(t2.getPosition2().getY()).append("\" ")
                .append("fill=\"freeze\" />\n");
            //WriteXML for Width change
            stringBuilder.append("<animate attributeType=\"xml\" ").append("begin=\"")
                .append((t2.getT1() / tempo) * 100).append("ms\" ")
                .append("dur=\"").append(((t2.getT2() - t2.getT1()) / tempo) * 100)
                .append("ms\" ").append("attributeName=\"width\" ").append("from=\"")
                .append(t2.getDimn1().getWidth()).append("\" ").append("to=\"")
                .append(t2.getDimn2().getWidth()).append("\" ")
                .append("fill=\"freeze\" />\n");
            //Write XML for Height change
            stringBuilder.append("<animate attributeType=\"xml\" ").append("begin=\"")
                .append((t2.getT1() / tempo) * 100).append("ms\" ")
                .append("dur=\"").append(((t2.getT2() - t2.getT1()) / tempo) * 100)
                .append("ms\" ").append("attributeName=\"height\" ").append("from=\"")
                .append(t2.getDimn1().getHeight()).append("\" ").append("to=\"")
                .append(t2.getDimn2().getHeight()).append("\" ")
                .append("fill=\"freeze\" />\n");
            //Write XML for Color change
            stringBuilder.append("<animate attributeType=\"xml\" ").append("begin=\"")
                .append((t2.getT1() / tempo) * 100).append("ms\" ")
                .append("dur=\"").append(((t2.getT2() - t2.getT1()) / tempo) * 100)
                .append("ms\" ").append("attributeName=\"fill\" ").append("from=\"")
                .append("rgb(")
                .append(t2.getColor1().getRed()).append(",")
                .append(t2.getColor1().getGreen()).append(",")
                .append(t2.getColor1().getBlue()).append(")\" ")
                .append("to=\"")
                .append("rgb(")
                .append(t2.getColor2().getRed()).append(",")
                .append(t2.getColor2().getGreen()).append(",")
                .append(t2.getColor2().getBlue()).append(")\" ")
                .append("fill=\"freeze\" />\n");
            //rotation
            if (t2.getRad2() != -1 && t2.getRad1() != -1) {
              stringBuilder.append("<animateTransform ")
                  .append("attributeName=\"transform\" ")
                  .append("attributeType=\"XML\" ")
                  .append("type=\"rotate\" ").append("begin=\"")
                  .append((t2.getT1() / tempo) * 100).append("ms\" ")
                  .append("from=\"").append(t2.getRad1()).append(" ")
                  .append(t2.getPosition1().getX() + t2.getDimn1().getWidth() / 2)
                  .append(" ").append(t2.getPosition1().getY() + t2.getDimn1().getHeight() / 2)
                  .append("\" ")
                  .append("to=\"").append(t2.getRad2()).append(" ")
                  .append(t2.getPosition2().getX() + t2.getDimn2().getWidth() / 2)
                  .append(" ").append(t2.getPosition2().getY() + t2.getDimn2().getHeight() / 2)
                  .append("\" ")
                  .append("dur=\"").append(((t2.getT2() - t2.getT1()) / tempo) * 100).append("ms\" ")
                  .append("/>");
            }
          }
        }
      }
    }
    stringBuilder.append("</rect>\n");
    return stringBuilder.toString();
  }

  /**
   * Given a name of a shape, constructs an Ellipse SVG code for the given shape name based on the
   * Transformations recorded in the model for that shape.
   *
   * @param name given shape name
   * @return String representing an Ellipse SVG code
   *
  private String generateEllipseSVG(String name) {
    StringBuilder stringBuilder = new StringBuilder();

    Transformation initial = null;

    //Get the initialized value of transformation that serves as the base Transformation
    for (Transformation t1 : model.getTransformations()) {
      if (t1.getName().equals(name) && t1.getT1() == t1.getT2()) {
        initial = t1;


        stringBuilder.append("<ellipse id=\"").append(name).append("\" ").append("cx=\"")
            .append(initial.getPosition1().getX()).append("\" ").append("cy=\"")
            .append(initial.getPosition1().getY()).append("\" ").append("rx=\"")
            .append(initial.getDimn1().getWidth()).append("\" ").append("ry=\"")
            .append(initial.getDimn1().getHeight()).append("\" ").append("fill=\"")
            .append("rgb(")
            .append(initial.getColor1().getRed()).append(",")
            .append(initial.getColor1().getGreen()).append(",")
            .append(initial.getColor1().getBlue()).append(")\" ")
            .append("visibility=\"visible\" >\n");


        //For each Transformation, add animate to XML
        //Scaling: Tick / tempo = second.  1 second is equal to 1000 ms
        for (Transformation t2 : model.getTransformations()) {
          if (t2.getName().equals(name)) {
            //Write XML for X change
            stringBuilder.append("<animate attributeType=\"xml\" ").append("begin=\"")
                .append((t2.getT1() / tempo) * 100).append("ms\" ")
                .append("dur=\"").append(((t2.getT2() - t2.getT1()) / tempo) * 100)
                .append("ms\" ").append("attributeName=\"cx\" ").append("from=\"")
                .append(t2.getPosition1().getX()).append("\" ").append("to=\"")
                .append(t2.getPosition2().getX()).append("\" ")
                .append("fill=\"freeze\" />\n");
            //Write XML for Y change
            stringBuilder.append("<animate attributeType=\"xml\" ").append("begin=\"")
                .append((t2.getT1() / tempo) * 100).append("ms\" ")
                .append("dur=\"").append(((t2.getT2() - t2.getT1()) / tempo) * 100)
                .append("ms\" ").append("attributeName=\"cy\" ").append("from=\"")
                .append(t2.getPosition1().getY()).append("\" ").append("to=\"")
                .append(t2.getPosition2().getY()).append("\" ")
                .append("fill=\"freeze\" />\n");
            //WriteXML for Width change
            stringBuilder.append("<animate attributeType=\"xml\" ").append("begin=\"")
                .append((t2.getT1() / tempo) * 1000).append("ms\" ")
                .append("dur=\"").append(((t2.getT2() - t2.getT1()) / tempo) * 1000)
                .append("ms\" ").append("attributeName=\"rx\" ").append("from=\"")
                .append(t2.getDimn1().getWidth()).append("\" ").append("to=\"")
                .append(t2.getDimn2().getWidth()).append("\" ")
                .append("fill=\"freeze\" />\n");
            //Write XML for Height change
            stringBuilder.append("<animate attributeType=\"xml\" ").append("begin=\"")
                .append((t2.getT1() / tempo) * 100).append("ms\" ")
                .append("dur=\"").append(((t2.getT2() - t2.getT1()) / tempo) * 100)
                .append("ms\" ").append("attributeName=\"ry\" ").append("from=\"")
                .append(t2.getDimn1().getHeight()).append("\" ").append("to=\"")
                .append(t2.getDimn2().getHeight()).append("\" ")
                .append("fill=\"freeze\" />\n");
            //Write XML for Color change
            stringBuilder.append("<animate attributeType=\"xml\" ").append("begin=\"")
                .append((t2.getT1() / tempo) * 100).append("ms\" ")
                .append("dur=\"").append(((t2.getT2() - t2.getT1()) / tempo) * 100)
                .append("ms\" ").append("attributeName=\"fill\" ").append("from=\"")
                .append("rgb(")
                .append(t2.getColor1().getRed()).append(",")
                .append(t2.getColor1().getGreen()).append(",")
                .append(t2.getColor1().getBlue()).append(")\" ")
                .append("to=\"")
                .append("rgb(")
                .append(t2.getColor2().getRed()).append(",")
                .append(t2.getColor2().getGreen()).append(",")
                .append(t2.getColor2().getBlue()).append(")\" ")
                .append("fill=\"freeze\" />\n");
          }
        }
      }
    }
    stringBuilder.append("</ellipse>\n");
    return stringBuilder.toString();
  }

  /**
   * Generate a new file with the given String as its file name.
   *
   * @param s given file name
   *
  private void generateSVGFile(String s) {
    try {
      File file = new File(s);
      FileWriter writer = new FileWriter(file);
      writer.write(this.generateSVG());
      writer.close();
    } catch (IOException io) {
      io.printStackTrace();
    }
  }

}
*/