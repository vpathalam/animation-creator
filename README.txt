README:

The Shapes MenuPanel represents the current shapes that are in the animation, if a shape is selected, it can be deleted. Otherwise, a
new shape can be added using Create Shape and the new shape will appear in the animation, and on the list of shapes.
The Keyframe modification menu allows a user to input different values for a keyframe, and if valid, you will have the ability to add
that certain keyframe.
The button panel below has a textfield which shows the most recent action, and another textfield which allows the user to input
a certain tempo to be changed to. Once the user selects Submit Tempo, then the tempo of the animation will be changed accordingly
to speed up or speed down the animation. Next, we have Play Resume Pause Restart and Toggle Loop buttons to support
other animation functionality.

UI/Controller Description:

Each shape (rectangle and circle) gets its own extension of AbstractShape which implements the Shape interface.
These shapes contain all relevant variables including name, type, color, width, height, and position.
Shapes are represented in this manner because it cuts down on code redundancy using multiple shapes.
The AnimationModel stores a hashmap of <String name, Shapes> representing the current shapes in the animation. We also
decided to store an arraylist of motions that allows us to view the current motions in the animation.

Our controller implementation is very straight forward. We have an IController which is implemented to support the standard views.
The implementation of this class has an instance of IView which allows for support of the standard views: svg, text, visual.
We also have another more complete editor interface controller which extends IController, and the implementation of this interface
has contains an instance of the EditorView to delegate actions based on the switch statement.

As mentioned in the other questions we answered, we decided to have an AView which implements an IView to support all of the
non-modifiable views including text, svg, and visual. To implement the more complete editor view, we decided to extend IView with an
interface, and this now supports additional functionality to modify the animation.

These views, specifically visual and editor, are based on the panels we provided. Button panel is at the bottom of the UI, ExcellencePanel
is the bulk of the animation being represented on the UI, and the MenuPanel is to the left of the UI.
EditorView mainly delegates functionality to these panels, where ExcellencePanel for example implements an ActionListener and can handle
painting the component with respective changes.
