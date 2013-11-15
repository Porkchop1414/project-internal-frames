package code;

import java.util.ArrayList;
import java.util.Arrays;

public class ShellSort extends VisualizableSort {
  
  private static final ArrayList<Integer> GAPS = new ArrayList<Integer>(Arrays.asList(701, 301, 132, 57, 23, 10, 4, 1));
  
  public ShellSort() {
    super();
    
  }
  
  @Override
  public void run() {
    // TODO: Implement this.
  }
  
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
