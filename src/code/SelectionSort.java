package code;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Selection sort implementation of a VisualizableSort
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public class SelectionSort extends VisualizableSort {

  public SelectionSort() {
    super();
    
  }
  
  /**
   * Runs the sort on the data.
   */
  @Override
  public void run() {
    selectionSort(mData);
  }
  
  /**
   * Selectionsort Implementation
   * @param array The ArrayList to be sorted in place.
   */
  private void selectionSort(ArrayList<Integer> array) {
    int iMin;
    
    for(int j = 0; j < array.size() - 1; j++) {
      iMin = j;
      for(int i = j + 1; i < array.size(); i++) {
        if(array.get(i) < array.get(iMin)) {
          iMin = i;
        }
      }
      
      if(iMin != j) {
        Collections.swap(array, iMin, j);

        // Sleep on our change.
        this.sortSleep(j);

      }
    }  
  }

}
