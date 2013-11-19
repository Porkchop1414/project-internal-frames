package code;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Bubble sort implementation of a VisualizableSort
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public class BubbleSort extends VisualizableSort {

  public BubbleSort() {
    super();
    name = "Bubble Sort";
  }

  /**
   * Runs the sort on the data.
   */
  @Override
  public void run() {
    bubbleSort(mData);
  }

  /**
   * Bubble sort implementation.
   *
   * @param array The ArrayList to be sorted in place.
   */
  private void bubbleSort(ArrayList<Integer> array) {
    boolean swapped;
    do {
      swapped = false;
      for (int i = 1; i < array.size(); i++) {
        if (array.get(i - 1) > array.get(i)) {
          Collections.swap(array, i - 1, i);
          swapped = true;

          // Sleep on our change.
          this.sortSleep(i - 1, i);

        }
      }
    } while (swapped);
  }
}
