package code;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

/**
 * Class that extends JPanel that is responsible for drawing the
 * data in a graphical form.
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public class Visualizer extends JPanel implements Observer {

  /**
   * This is the VisualizableSort that will be displayed.
   */
  protected VisualizableSort data;

  /**
   * This is the ArrayList that is being displayed.
   */
  protected ArrayList<Integer> list;

  public Visualizer(VisualizableSort sort) {
    super();
    //Constructor initializes member variables
    data = sort;

    add(new JLabel(data.getName()));

    data.addObserver(this);
    list = sort.getData();
  }

  /**
   * Unregisters the observer.
   */
  public void close() {
    if (data != null) {
      data.deleteObserver(this);
      data = null;
    }
  }

  /**
   * Update used to allow the sorts to call Visualizer's repaint directly.
   *
   * @param o
   * @param arg
   */
  @Override
  public void update(Observable o, Object arg) {
    repaint();
  }

  /**
   * Used to draw the graph that visually represents the data being sorted.
   *
   * @param g
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    int width = Math.max(getWidth(),list.size());
    int height = getHeight()-10;
    
    //For loop that sets the color of graphics to yellow if it was the last
    //changed index, otherwise blue, and then draws a filled rectangle the
    //height of the value in the arraylist.
    int[] changes = data.getLatestChanges();
    for (int i = 0; i < list.size(); i++) {

      boolean indexChanged = false;
      for(int j : changes) {
        if(i == j) {
          indexChanged = true;
          break;
        }
      }

      g.setColor(indexChanged ? Color.RED : Color.BLUE);

      g.fillRect(i * (width / list.size()) + 10, height - list.get(i), width / list.size(), list.get(i));
    }
    g.setColor(Color.BLACK);
  }
}
