package code;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Heap sort implementation of a VisualizableSort
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public class HeapSort extends VisualizableSort {
  
  public HeapSort() {
    super();
    
  }
  
  /**
   * Runs the sort on the data.
   */
  @Override
  public void run() {
    heapSort(mData);
  }
  
  /**
   * Heapsort Implementation
   * @param array The ArrayList to be sorted in place.
   */
  private void heapSort(ArrayList<Integer> array) {
    heapify(array);
    
    int end = array.size() - 1;
    while(end > 0) {
      Collections.swap(array, 0, end);

      // Sleep on our change.
      this.sortSleep(end);

      end--;
      siftDown(array,0,end);
    }
  }
  
  /**
   * Arranges an ArrayList in heap form.
   * @param array The ArrayList to be placed in heap order.
   */
  private void heapify(ArrayList<Integer> array) {
    int start = (array.size() - 2) / 2;
    
    while(start >= 0) {
      siftDown(array, start, array.size() - 1);
      start--;
    }
  }
  
  /**
   * Sifts the ArrayList being heapified
   * @param array The ArrayList being operated on.
   * @param start Start of the sift segment.
   * @param end End of the sift segment.
   */
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

        // Sleep on our change.
        this.sortSleep(swap);

      } else {
        return;
      }
    }
  }

}
