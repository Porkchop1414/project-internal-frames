package code;

import java.util.ArrayList;

/**
 * VisualizableSort is an abstract base class which enables a sorting algorithm to expose
 * its data whilst sorting in place, for visualization purposes.
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public abstract class VisualizableSort implements Runnable {

  /**
   * Number of milliseconds to sleep between sort iterations.
   */
  public static int sleepDuration = 500;

  /**
   * ArrayList of data to be sorted in place.
   */
  protected ArrayList<Integer> mData;

  /**
   * Index of the most recently changed element.
   */
  private int mLatestChange = 0;

  public VisualizableSort() {

  }

  /**
   * Causes the sort to sleep and updates the latest changed index.
   * @param changedIndex The index of the most recently changed element.
   */
  protected void sortSleep(int changedIndex) {
    // Update the latest changed index.
    if(changedIndex >= 0 && changedIndex <= mData.size()) {
      mLatestChange = changedIndex;
    }

    // Sleep for the configured amount of time.
    try {
      Thread.sleep(sleepDuration);
    } catch (InterruptedException e) {
      // Do nothing. We don't really care.
    }
  }

  /**
   * Gets the data which is being or will be sorted.
   * @return The ArrayList of integers being sorted.
   */
  public ArrayList<Integer> getData() {
    return mData;
  }

  public int getLatestChangedIndex() {
    return mLatestChange;
  }

  /**
   * Sets the data to be sorted by copying the provided ArrayList
   * @param data The ArrayList to be copied.
   */
  public void copyData(ArrayList<Integer> data) {
    mData = new ArrayList<Integer>(data);
  }
}
