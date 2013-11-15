package code;

import java.util.ArrayList;
import java.util.Collections;

public class HeapSort extends VisualizableSort {
  
  public HeapSort() {
    super();
    
  }
  
  @Override
  public void run() {
    // TODO: Implement this.
  }
  
  private void heapSort(ArrayList<Integer> array) {
    heapify(array);
    
    int end = array.size() - 1;
    while(end > 0) {
      Collections.swap(array, 0, end);
      end--;
      siftDown(array,0,end);
    }
  }
  
  private void heapify(ArrayList<Integer> array) {
    int start = (array.size() - 2) / 2;
    
    while(start >= 0) {
      siftDown(array, start, array.size() - 1);
      start--;
    }
  }
  
  private void siftDown(ArrayList<Integer> array, int start, int end) {
    int root = start;
    
    while((root * 2 + 1) <= end) {
      int child = root * 2 + 1;
      int swap = root;
      
      if(array.get(swap) < array.get(child)) {
        swap = child;
      }
      
      if(child + 1 <= end && array.get(swap) < array.get(child + 1)) {
        swap = child + 1;
      }
      
      if(swap != root) {
        Collections.swap(array, swap, root);
        root = swap;
      } else {
        return;
      }
    }
  }

}
