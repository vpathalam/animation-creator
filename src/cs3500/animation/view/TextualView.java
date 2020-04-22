package cs3500.animation.view;

import cs3500.animation.model.IReadOnlyAnimationModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This view will show a textual description of the animation. This description should be the
 * description produced from AnimationModelImpl getAnimationState() method.
 */
public class TextualView extends AView {
  /**
   * Constructs an Textual View with given model, output file location and tempo of tick. Output
   * file's default is "System.out" and prints out SVG text in the console. tempo works by dividing
   * the actual tick by this tempo to get a unit in second.
   *
   * @param model       given AnimationModel to operate
   * @param outFileName given desired output file name
   * @param tempo       given the tempo of tick
   */
  public TextualView(IReadOnlyAnimationModel model, String outFileName, int tempo) {
    super.model = model;
    super.tempo = tempo;
    if (outFileName.equals("System.out")) {
      System.out.println(model.theStateOfMotion());
    } else {
      this.generateTXTFile(outFileName);
    }
  }

  /**
   * It creates the txt file of the given name.
   *
   * @param s name of the txt file that is to be created.
   */
  private void generateTXTFile(String s) {
    try {
      File file = new File(s);
      FileWriter writer = new FileWriter(file);
      writer.write(model.theStateOfMotion());
      writer.close();
    } catch (IOException io) {
      io.printStackTrace();
    }
  }

  @Override
  public void viewVisibility() {
    setVisible(true);
  }
}
