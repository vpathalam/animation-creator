package cs3500.animation.view.panels;


import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;

/** Represents the panel for modification buttons on the UI. **/
public class ButtonPanel extends JPanel {


  private JButton submitTempo;
  private JLabel tempoLabel;

  private JButton startB;
  private JButton pauseB;
  private JButton restartB;
  private JButton loopB;
  private JButton resumeB;

  private JTextField visualText;
  private JTextField tempoField;

  /** Created and adds buttons to the panel for animation modification using Swing. **/
  public ButtonPanel() {
    this.setLayout(new FlowLayout());

    visualText = new JTextField("");
    visualText.setPreferredSize(new Dimension(150, 20));
    this.add(visualText);

    tempoLabel = new JLabel("Tempo: 0");
    this.add(tempoLabel);

    startB = new JButton("Play");
    startB.setActionCommand("Play");
    this.add(startB);

    pauseB = new JButton("Pause");
    pauseB.setActionCommand("Pause");
    this.add(pauseB);

    resumeB = new JButton("Resume");
    resumeB.setActionCommand("Resume");
    this.add(resumeB);

    restartB = new JButton("Restart");
    restartB.setActionCommand("Restart");
    this.add(restartB);

    loopB = new JButton("Toggle Loop Off");
    loopB.setActionCommand("Toggle Loop Off");
    this.add(loopB);

    tempoField = new JTextField("Please specify a tempo");
    tempoField.setPreferredSize(new Dimension(150, 20));
    submitTempo = new JButton("Submit Tempo");
    submitTempo.setActionCommand("Change Tempo");
    this.add(tempoField);
    this.add(submitTempo);
  }

  /**
   * Sets up action listeners for each button on the panel to assign functionality.
   * @param mouseClick is the click of the mouse.
   **/
  public void setListeners(ActionListener mouseClick) {

    this.startB.addActionListener(mouseClick);
    this.loopB.addActionListener(mouseClick);
    this.resumeB.addActionListener(mouseClick);
    this.pauseB.addActionListener(mouseClick);
    this.restartB.addActionListener(mouseClick);
    this.submitTempo.addActionListener(mouseClick);
  }

  /**
   * Modifies the label to display the text of the most recently completed action.
   * @param str the text the label should be set to.
   **/
  public void setVisualLabel(String str) {
    this.visualText.setText(str);
  }

  /**
   * Modifies the toggle label to display the text of the most recently completed action.
   * @param str the text the toggle label should be set to.
   **/
  public void setToggleLabel(String str) {
    this.loopB.setText(str);
  }

  /**
   * Modifies the tempo label to display the text of the most recently completed action.
   * @param str the text the tempo label should be set to.
   * */
  public void setTempoLabel(String str) {
    this.tempoLabel.setText(str);
  }

  /**
   * Retrieves the current tempo field of the animation.
   * @return the tempoField JTextField
   **/
  public JTextField getTempoField() {
    return this.tempoField;
  }

  /**
   * Sets the tempo field to a certain string value.
   * @param tempo the the field should be set to.
   **/
  public void setTempoField(String tempo) {
    this.tempoField.setText(tempo);
  }
}