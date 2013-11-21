package code;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * An internal frame that will display up to three sorting algorithms sorting in real-time, sliders to control
 * speed/input number, button to start, and button to reset the data.
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public class MainDisplay extends JInternalFrame implements ActionListener, ChangeListener {

  /**
   * JPanels for displaying the sort visualizers.
   */
  private List<JPanel> sortPanels;

  /**
   * JButtons for controlling the sort visualizations.
   */
  private JButton startButton, resetButton;

  /**
   * JSliders for controlling the size of data set and the speed of simulation.
   */
  private JSlider sizeSlider, speedSlider;

  /**
   * TitledBorders for the sliders.
   */
  private TitledBorder sizeSliderBorder, speedSliderBorder;

  /**
   * The selected case for data for the sort.
   */
  private DataType selectedDataType;

  /**
   * ArrayList of integers to sort.
   */
  private ArrayList<Integer> dataSet;
  private List<JCheckBoxMenuItem> sorts;

  /**
   * Constructor for a Author object.
   *
   * @param width  the width of the panel
   * @param height the height of the panel
   */
  public MainDisplay(int width, int height, DataType selectedDataType, List<JCheckBoxMenuItem> sorts) {
    super("Main Display", true, true, true, true);
    setSize(width, height);
    setOpaque(true);
    setVisible(true);

    this.sorts = sorts;
    this.selectedDataType = selectedDataType;
    dataSet = new ArrayList<>();

    JPanel controlPanel = new JPanel();
    add(controlPanel);

    sizeSlider = new JSlider(1, 800, 400);
    sizeSliderBorder = new TitledBorder(new LineBorder(Color.BLUE, 10), "Array Length: " + String.valueOf(sizeSlider.getValue()), TitledBorder.CENTER, TitledBorder.TOP);
    sizeSlider.setBorder(sizeSliderBorder);
    sizeSlider.addChangeListener(this);
    controlPanel.add(sizeSlider);

    startButton = new JButton("Start");
    startButton.addActionListener(this);
    controlPanel.add(startButton);

    resetButton = new JButton("Reset");
    resetButton.addActionListener(this);
    controlPanel.add(resetButton);

    speedSlider = new JSlider(1, 1000, 500);
    speedSliderBorder = new TitledBorder(new LineBorder(Color.BLUE, 10), "Current Delay: " + String.valueOf(speedSlider.getValue()) + "ms", TitledBorder.CENTER, TitledBorder.TOP);
    speedSlider.setBorder(speedSliderBorder);
    speedSlider.addChangeListener(this);
    controlPanel.add(speedSlider);

    sortPanels = new ArrayList<>();
    sortPanels.add(new JPanel());
    sortPanels.add(new JPanel());
    sortPanels.add(new JPanel());

    setLayout(new GridLayout(4, 1, 5, 5));
  }

  /**
   * Action listener that will be called when the start and reset buttons are pressed.
   *
   * @param e The ActionEvent object.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == startButton) {
      // Create the data set before starting the sorts
      dataSet.clear();
      if(selectedDataType == DataType.Random) {
        Random random = new Random();
        for(int i = 0; i < sizeSlider.getValue(); i++) {
          dataSet.add(random.nextInt(100));
        }
      } else if(selectedDataType == DataType.Best) {
        // In order
        for(float i = 0; i < sizeSlider.getValue(); i++) {
          dataSet.add((int)((i / sizeSlider.getValue()) * 100));
        }
      } else if(selectedDataType == DataType.Worst) {
        // Reverse order
        for(float i = 0; i < sizeSlider.getValue(); i++) {
          dataSet.add((int)(100 - ((i / sizeSlider.getValue()) * 100)));
        }
      }

      createVisualizerPanels();
    } else if (e.getSource() == resetButton) {
      createVisualizerPanels();
    }
  }

  /**
   * Change listener that will be called when the sliders are moved.
   *
   * @param e The ChangeEvent object.
   */
  @Override
  public void stateChanged(ChangeEvent e) {
    if (e.getSource() == sizeSlider) {
      sizeSliderBorder.setTitle("Array Length: " + String.valueOf(sizeSlider.getValue()));
    } else if (e.getSource() == speedSlider) {
      speedSliderBorder.setTitle("Current Delay: " + String.valueOf(speedSlider.getValue()) + "ms");
      VisualizableSort.sleepDuration = speedSlider.getValue();
    }
  }

  /**
   * Sets the data type for the sort.
   * @param dataType The DataType for the sort.
   */
  public void setDataType(DataType dataType) {
    selectedDataType = dataType;
  }

  /**
   * Gets the indices of the selected sorting algorithms.
   * @return A List of the indices of the algorithms
   */
  private List<Integer> getSelectedSortIndexes() {
    ArrayList<Integer> indexes = new ArrayList<>();
    if(sorts.get(0).isSelected()) {
      indexes.add(0);
    }
    if(sorts.get(1).isSelected()) {
      indexes.add(1);
    }
    if(sorts.get(2).isSelected()) {
      indexes.add(2);
    }
    if(sorts.get(3).isSelected()) {
      indexes.add(3);
    }
    if(sorts.get(4).isSelected()) {
      indexes.add(4);
    }
    if(sorts.get(5).isSelected()) {
      indexes.add(5);
    }
    return indexes;
  }

  /**
   * Creates the sort visualizer panels.
   */
  private void createVisualizerPanels() {
    remove(sortPanels.get(0));
    remove(sortPanels.get(1));
    remove(sortPanels.get(2));
    sortPanels.add(0, new JPanel());
    sortPanels.add(1, new JPanel());
    sortPanels.add(2, new JPanel());
    ExecutorService executorPool = Executors.newFixedThreadPool(3);

    List<Integer> indexes = getSelectedSortIndexes();
    for(int i = 0; i < indexes.size() && i < 3; i++) {
      VisualizableSort sort = null;
      if(indexes.get(i) == 0) {
        sort = new BubbleSort();
        sort.copyData(dataSet);
      } else if(indexes.get(i) == 1) {
        sort = new InsertionSort();
        sort.copyData(dataSet);
      } else if(indexes.get(i) == 2) {
        sort = new SelectionSort();
        sort.copyData(dataSet);
      } else if(indexes.get(i) == 3) {
        sort = new QuickSort();
        sort.copyData(dataSet);
      } else if(indexes.get(i) == 4) {
        sort = new HeapSort();
        sort.copyData(dataSet);
      } else if(indexes.get(i) == 5) {
        sort = new ShellSort();
        sort.copyData(dataSet);
      }
      sortPanels.add(i, new Visualizer(sort));
      if(sort != null) {
        executorPool.execute(sort);
      }
    }

    add(sortPanels.get(0));
    add(sortPanels.get(1));
    add(sortPanels.get(2));

    validate();
    repaint();
  }
}
