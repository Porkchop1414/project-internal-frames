package code;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort extends VisualizableSort {

  public SelectionSort() {
    super();
    
  }
  
  @Override
  public void run() {
    // TODO: Implement this.
  }
  
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
      }
    }  
  }

}
