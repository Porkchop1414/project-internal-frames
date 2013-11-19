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
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * An internal frame that will display up to three sorting algorithms sorting in real-time, sliders to control
 * speed/input number, button to start, and button to reset the data.
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public class MainDisplay extends JInternalFrame implements ActionListener, ChangeListener {

  private JPanel sortOne, sortTwo, sortThree;
  private JButton startButton, resetButton;
  private JSlider sizeSlider, speedSlider;
  private TitledBorder sizeSliderBorder, speedSliderBorder;
  private DataType selectedDataType;
  private ArrayList<Integer> dataSet;
  private Executor executor;

  /**
   * Constructor for a Author object.
   *
   * @param width  the width of the panel
   * @param height the height of the panel
   */
  public MainDisplay(int width, int height, DataType selectedDataType) {
    super("Main Display", true, true, true, true);
    setSize(width, height);
    setOpaque(true);
    setVisible(true);

    this.selectedDataType = selectedDataType;
    dataSet = new ArrayList<>();
    executor = Executors.newFixedThreadPool(3);

    JPanel controlPanel = new JPanel();
    getContentPane().add(controlPanel);

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
    speedSliderBorder = new TitledBorder(new LineBorder(Color.BLUE, 10), "Current Delay: " + String.valueOf(speedSlider.getValue()), TitledBorder.CENTER, TitledBorder.TOP);
    speedSlider.setBorder(speedSliderBorder);
    speedSlider.addChangeListener(this);
    controlPanel.add(speedSlider);

    /*sortOne = new JPanel();
    getContentPane().add(sortOne);

    sortTwo = new JPanel();
    getContentPane().add(sortTwo);

    sortThree = new JPanel();
    getContentPane().add(sortThree);*/

    getContentPane().setLayout(new GridLayout(4, 1, 5, 5));
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
        for(int i = 0; i < sizeSlider.getValue(); i++) {
          dataSet.add(i / sizeSlider.getValue());
        }
      } else if(selectedDataType == DataType.Worst) {
        // Reverse order
        for(int i = 0; i < sizeSlider.getValue(); i++) {
          dataSet.add(100 - (i / sizeSlider.getValue()));
        }
      }

      // Create visualizers here for each of the sort panels
      BubbleSort sort = new BubbleSort();
      sort.copyData(dataSet);
      sortOne = new Visualizer(sort);
      executor.execute(sort);

      add(sortOne);

      validate();
      repaint();
    } else if (e.getSource() == resetButton) {

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
      speedSliderBorder.setTitle("Current Delay: " + String.valueOf(speedSlider.getValue()));
      VisualizableSort.sleepDuration = speedSlider.getValue();
    }
  }
}
