package cs3500.animation.view.panels;


import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.FlowLayout;
import javax.swing.*;

/** JPanel component of the UI that serves as a menu panel for displaying current anim. shapes. */
public class MenuPanel extends JPanel {


  private DefaultListModel<String> shapes;

  private JTextField inputShapeName;
  private JTextField inputShapeType;
  private JTextField shapeName;
  private JTextField shapeTick;

  private JTextField x;
  private JTextField y;

  private JTextField w;
  private JTextField h;

  private JTextField r;
  private JTextField g;
  private JTextField b;

  private JButton addShape;
  private JButton removeShape;

  private JButton createKey;
  private JButton removeKey;

  /**
   * A MenuPanel which represents a list of the current shapes in the animation.
   * @param set of strings and shapes.
   **/
  public MenuPanel(HashMap<String, String> set) {
    JLabel labelInputShapeName;
    JLabel labelInputShapeType;
    JList jList;
    JLabel labelName;
    JLabel labelTick;
    JLabel labelX;
    JLabel labelY;
    JLabel labelW;
    JLabel labelH;
    JLabel labelR;
    JLabel labelG;
    JLabel labelB;
    Dimension dimension;
    JScrollPane scroll;
    JLabel menuLabel;

    dimension = new Dimension(200, 200);
    this.setPreferredSize(dimension);
    this.setLayout(new FlowLayout());

    labelName = new JLabel("Current Animation Shapes: ");
    labelName.setBounds(30, 0, 100, 20);
    this.add(labelName);

    scroll = new JScrollPane();

    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setPreferredSize(new Dimension(180, 100));
    this.add(scroll);

    shapes = new DefaultListModel<String>();
    for (String s : set.keySet()) {
      shapes.addElement(s);
    }

    jList = new JList(shapes);
    jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    jList.setSelectedIndex(0);
    jList.setVisibleRowCount(10);
    scroll.setViewportView(jList);

    labelInputShapeName = new JLabel("Name:");
    this.add(labelInputShapeName);
    inputShapeName = new JTextField(5);
    this.add(inputShapeName);

    labelInputShapeType = new JLabel("Type:");
    this.add(labelInputShapeType);
    inputShapeType = new JTextField(5);
    this.add(inputShapeType);

    addShape = new JButton("Create Shape");
    addShape.setActionCommand("Create");
    this.add(addShape);

    removeShape = new JButton("Delete");
    removeShape.setActionCommand("Delete");
    this.add(removeShape);

    menuLabel = new JLabel("KeyFrame Editor:");
    this.add(menuLabel);

    labelName = new JLabel("Name: ");
    this.add(labelName);
    shapeName = new JTextField(5);
    this.add(shapeName);

    labelTick = new JLabel("Tick (>0): ");
    this.add(labelTick);
    shapeTick = new JTextField(5);
    this.add(shapeTick);

    labelX = new JLabel("X Coord:");
    this.add(labelX);
    x = new JTextField(5);
    this.add(x);

    labelY = new JLabel("Y Coord:");
    this.add(labelY);
    y = new JTextField(5);
    this.add(y);

    labelW = new JLabel("Width (>0):");
    this.add(labelW);
    w = new JTextField(5);
    this.add(w);

    labelH = new JLabel("Height (>0):");
    this.add(labelH);
    h = new JTextField(5);
    this.add(h);

    labelR = new JLabel("Red Color (0-255):");
    this.add(labelR);
    r = new JTextField(5);
    this.add(r);

    labelG = new JLabel("Green Color (0-255):");
    this.add(labelG);
    g = new JTextField(5);
    this.add(g);

    labelB = new JLabel("Blue Color (0-255):");
    this.add(labelB);
    b = new JTextField(5);
    this.add(b);

    createKey = new JButton("Create");
    createKey.setActionCommand("add key");
    this.add(createKey);

    removeKey = new JButton("Delete");
    removeKey.setActionCommand("del key");
    this.add(removeKey);
  }

  /**
   * Sets the shape name text based on str input.
   * @param str str name to be set.
   */
  public void setShapeName(String str) {
    this.shapeName.setText(str);
  }

  /**
   * Sets the shape type based on the given str input.
   * @param str type str to be set.
   */
  public void setShapeType(String str) {
    this.inputShapeName.setText(str);
  }

  /**
   * Retrieves the current shape input name.
   * @return String the current shape input name.
   */
  public String getShapeName() {
    return this.inputShapeName.getText();
  }

  /**
   * Retrieves the current shape input type.
   * @return String the current shape input type.
   */
  public String getShapeType() {
    return this.inputShapeType.getText();
  }

  /**
   * Retrieves the current shape input tick.
   * @return int the current shape input tick.
   */
  public int getShapeTick() {
    return Integer.parseInt(this.shapeTick.getText());
  }

  /**
   * Retrieves the current shape input x coordinate.
   * @return int the current shape input x coordinate.
   */
  public int getShapeXPos() {
    return Integer.parseInt(this.x.getText());
  }

  /**
   * Retrieves the current shape input y coordinate.
   * @return int the current shape input y coordinate.
   */
  public int getShapeYPos() {
    return Integer.parseInt(this.x.getText());
  }


  /**
   * Retrieves the current fields of motion and forms a resulting string.
   * @return String of the current motion attribute fields.
   */
  public String getMotionFields() {
    StringBuilder res = new StringBuilder();

    res.append(shapeName.getText())
        .append(" ")
            .append(shapeTick.getText())
        .append(" ")
            .append(x.getText())
        .append(" ")
            .append(y.getText())
        .append(" ")
            .append(w.getText())
        .append(" ")
            .append(h.getText())
        .append(" ")
            .append(r.getText())
        .append(" ")
            .append(g.getText())
        .append(" ")
            .append(b.getText());

    return res.toString();
  }

  /**
   * Retrieves the current keyframe input name of shape.
   * @return String of the current keyframe shape name.
   */
  public String getKshapeName() {
    return this.shapeName.getText();
  }

  /**
   * Retrieves the current keyframe input tick of shape.
   * @return int of the current keyframe shape tick.
   */
  public int getKShapeTick() {
    return Integer.parseInt(this.shapeTick.getText());
  }

  /**
   * Retrieves the current keyframe input red value of shape.
   * @return int of the current keyframe shape red value.
   */
  public int getShapeRed() {
    return Integer.parseInt(this.r.getText());
  }

  /**
   * Retrieves the current keyframe input green value of shape.
   * @return int of the current keyframe green value.
   */
  public int getShapeGreen() {
    return Integer.parseInt(this.g.getText());
  }

  /**
   * Retrieves the current keyframe input blue value of shape.
   * @return int of the current keyframe blue value.
   */
  public int getShapeBlue() {
    return Integer.parseInt(this.b.getText());
  }

  /**
   * Retrieves the current keyframe input width of shape.
   * @return int of the current keyframe width value.
   */
  public int getShapeWidth() {
    return Integer.parseInt(this.w.getText());
  }

  /**
   * Retrieves the current keyframe input height value of shape.
   * @return int of the current keyframe height value.
   */
  public int getShapeHeight() {
    return Integer.parseInt(this.h.getText());
  }

  /**
   * Adds action listeners to delegate functionality of clicked buttons on the animation.
   * @param mouseClick is the mouse click.
   */
  public void setButtonListener(ActionListener mouseClick) {
    this.addShape.addActionListener(mouseClick);
    this.removeShape.addActionListener(mouseClick);

    this.createKey.addActionListener(mouseClick);
    this.removeKey.addActionListener(mouseClick);
  }

  /**
   * Adds a given shape to the list of shapes.
   * @param name of the shape to be added.
   */
  public void addShape(String name) {
    this.shapes.addElement(name);
  }

  /**
   * Removes a given shape from the list of shapes.
   * @param name of the shape to be removed.
   */
  public void removeList(String name) {
    String element = name;
    if (this.shapes.contains(element)) {
      this.shapes.removeElement(element);
    }
  }

  /**
   * Resets the text fields for cleaning implementation.
   * @param str the string to be set for the name and tick when cleared.
   */
  public void clearField(String str) {
    this.shapeName.setText(str);
    this.shapeTick.setText(str);
    this.x.setText(str);
    this.y.setText(str);
    this.w.setText(str);
    this.h.setText(str);
    this.r.setText(str);
    this.g.setText(str);
    this.b.setText(str);
  }

}
