package code;

import java.util.ArrayList;

/**
 * Insertion sort implementation of a VisualizableSort
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public class InsertionSort extends VisualizableSort {

  public InsertionSort() {
    name = "Insertion Sort";
  }

  /**
   * Runs the sort on the data.
   */
  @Override
  public void run() {
    insertionSort(mData);
  }

  /**
   * Insertion sort implementation
   * @param array The ArrayList to be sorted in place.
   */
  private void insertionSort(ArrayList<Integer> array) {
    for(int i=1; i<array.size(); i++) {
      int valueToInsert = array.get(i);
      int holePos = i;
      while(holePos > 0 && valueToInsert < array.get(holePos - 1)) {
        array.set(holePos, array.get(holePos - 1));

        // Sleep on our change.
        this.sortSleep(holePos);

        holePos = holePos - 1;
      }
      array.set(holePos, valueToInsert);

      // Sleep on our change.
      this.sortSleep(holePos);

    }
  }
  
}
