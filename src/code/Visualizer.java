package code;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class Visualizer extends JPanel implements Observer {
  /**
   * Class that extends JPanel that is responsible for drawing the
   * data in a graphical form.
   */
  //Member Variables
  protected VisualizableSort data;
  protected ArrayList<Integer> list;

  public Visualizer(VisualizableSort sort) {
    super();
    //Constructor initializes member variables
    data = sort;

    add(new JLabel(data.getName()));

    data.addObserver(this);
    list = sort.getData();
  }

  public void close() {
    if (data != null) {
      data.deleteObserver(this);
      data = null;
    }
  }

  @Override
  public void update(Observable o, Object arg) {
    repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

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

      g.fillRect(i * (800 / list.size()), 100 - list.get(i), 800 / list.size(), list.get(i));
    }
    g.setColor(Color.BLACK);
  }
}
