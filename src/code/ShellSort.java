package code;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Shell sort implementation of a VisualizableSort
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public class ShellSort extends VisualizableSort {
  
  /**
   * The gaps to be used in the shell sort.
   */
  private static final ArrayList<Integer> GAPS = new ArrayList<Integer>(Arrays.asList(701, 301, 132, 57, 23, 10, 4, 1));
  
  public ShellSort() {
    super();
    
  }
  
  /**
   * Runs the sort on the data.
   */
  @Override
  public void run() {
    // TODO: Implement this.
  }
  
  /**
   * Shellsort Implementation
   * @param array The ArrayList to be sorted in place.
   */
  private void shellSort(ArrayList<Integer> array) {  
    for(Integer gap : GAPS) {    
      for(int i = gap; i < array.size(); i++) {
        int temp = array.get(i);
        int j;        
        for(j = i; j >= gap && array.get(j - gap) > temp; j -= gap) {
          array.set(j, array.get(j - gap));
        } 
        array.set(j, temp);
      }  
    }
  }

}
