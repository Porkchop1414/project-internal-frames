package code;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Visualizer extends JPanel 
{
  /**
    Class that extends JPanel that is responsible for drawing the 
    data in a graphical form.
  */
  //Member Variables
  protected VisualizableSort data;
  protected ArrayList<Integer> list;

  public Visualizer(VisualizableSort sort)
  {
    //Constructor initializes member variables
    data = sort;
    list = new ArrayList<Integer>(sort.getData());
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    //For loop that sets the color of graphics to yellow if it was the last
    //changed index, otherwise blue, and then draws a filled rectangle the
    //height of the value in the arraylist.
    for(int i = 0; i < list.size(); i++)
    {
      if(Arrays.asList(data.getLatestChanges()).contains(i))
      {
        g.setColor(Color.YELLOW);
      }
      else
      {
        g.setColor(Color.BLUE);
      }
      g.fillRect(i * (800 / list.size()), 100 - list.get(i), 800 / list.size(), list.get(i));
    }
    g.setColor(Color.BLACK);
  }
}
