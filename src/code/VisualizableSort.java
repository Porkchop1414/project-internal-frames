package code;

import java.util.ArrayList;

// TODO: Add some method of tracking the last change.
// TODO: Determine how sleeping is going to work in terms of when to do it.

/**
 * VisualizableSort is an abstract base class which enables a sorting algorithm to expose
 * its data whilst sorting in place, for visualization purposes.
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public abstract class VisualizableSort implements Runnable {

  /**
   * ArrayList of data to be sorted in place.
   */
  protected ArrayList<Integer> mData;
  
  /**
   * Number of milliseconds to sleep between sort iterations.
   */
  public static volatile int sleepDuration = 500;

  public VisualizableSort() {

  }

  /**
   * Gets the data which is being or will be sorted.
   * @return The ArrayList of integers being sorted.
   */
  public ArrayList<Integer> getData() {
    return mData;
  }

  /**
   * Sets the data to be sorted by copying the provided ArrayList
   * @param data The ArrayList to be copied.
   */
  public void copyData(ArrayList<Integer> data) {
    mData = new ArrayList<Integer>(data);
  }
}
