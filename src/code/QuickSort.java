package code;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Quick sort implementation of a VisualizableSort
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public class QuickSort extends VisualizableSort {

  public QuickSort() {
    super();
    name = "Quick Sort";
  }

  /**
   * Runs the sort on the data.
   */
  @Override
  public void run() {
    quickSort(mData,0,mData.size()-1);
  }

  /**
   * Quicksort implementation
   * @param array The ArrayList to be sorted in place.
   * @param left The left bound
   * @param right The right bound
   */
  private void quickSort(ArrayList<Integer> array, int left, int right) {
    if(left < right) {
      int pivotIndex = ((right - left) / 2) + left;
      int pivotNewIndex = partition(array,left,right,pivotIndex);
      quickSort(array, left, pivotNewIndex - 1);
      quickSort(array, pivotNewIndex + 1, right);
    }
  }

  /**
   *
   * @param array The ArrayList which is being sorted
   * @param left The left bound
   * @param right The right bound
   * @param pivotIndex The current pivot index
   * @return The index of hte next pivotas
   */
  private int partition(ArrayList<Integer> array, int left, int right, int pivotIndex) {
    int pivotValue = array.get(pivotIndex);
    Collections.swap(array, pivotIndex, right);

    // Sleep on our change.
    this.sortSleep(pivotIndex, right);

    int storeIndex = left;
    for(int i=left; i<right; i++) {
      if(array.get(i) <= pivotValue) {
        Collections.swap(array,i,storeIndex);

        // Sleep on our change.
        this.sortSleep(i, storeIndex);

        storeIndex++;
      }
    }
    Collections.swap(array, storeIndex, right);

    // Sleep on our change.
    this.sortSleep(storeIndex, right);

    return storeIndex;
  }
  
}
