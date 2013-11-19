package code;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Visualizer extends JPanel 
{
  protected VisualizableSort data;
  protected ArrayList<Integer> list;

  public Visualizer(VisualizableSort sort)
  {
    data = sort;
    list = new ArrayList<Integer>(sort.getData());
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
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
