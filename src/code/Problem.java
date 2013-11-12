package code;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * An internal frame that will display the problem statement using Fonts, Borders, and a TextArea.
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public class Problem extends JInternalFrame {
  Font font;
  String string;
  TitledBorder tBorder;

  /**
   * Constructor for a Problem object.
   * @param width the width of the panel
   * @param height the height of the panel
   */
  public Problem(int width, int height) {
    super("Problem", true, true, true, true);
    setSize(width, height);
    setOpaque(true);
    setVisible(true);

    font = new Font("Sarif", Font.BOLD + Font.ITALIC, 12);
    tBorder = new TitledBorder(new LineBorder(Color.BLUE, 16),
        "Problem Description", TitledBorder.CENTER, TitledBorder.TOP, new Font("TimesRoman", Font.BOLD, 25), Color.MAGENTA);

    string = "Write a program using new threads (Do not use old threads to get credit for the project) as discussed in the " +
        "class for Algorithm Visualization. Your program should be menu driven as seen in the demos and previous " +
        "assignments. Your program uses JInternalFrames (full functionality) and JPanels for proper display of the " +
        "program components to do all the work. The JInternalFrames and JPanels may be placed in JApplet and/or " +
        "JFrame. The program should be executable as an applet or an application. Use package command for package " +
        "the appropriate files. Jar the whole package. Document the code using Java style code. Every class, function " +
        "and variable has javadoc descriptive comments. Make your program as fancy as you can.\n\n" +
        "The program implements sorting algorithms at least Bubble, Insertion, Selection, Quicksort, Heapsort, Shellsort. " +
        "Extra credit for additional sorting algorithms. Program should be able to display at most three of the sorting " +
        "algorithms simultaneously in executing in parallel for visual comparison. Scale the displays depending on the " +
        "number of algorithms displayed. Data consists at most 800 numerical values in the range [1, 100].\n\n" +
        "Draw vertical-rectangle bar chart showing the numbers in the original data. For running multiple algorithms in " +
        "parallel, draw bar charts side-by-side showing the numbers at each step of the selected sorting algorithms. Color " +
        "code the bars corresponding to the exchanged data items. A titled border may be used to identify which " +
        "algorithms are executing.\n\n" +
        "Use menu items to select algorithms and for various options for data, reset algorithms, reset data, speed control for\n" +
        "each algorithm. " +
        "Use a slider with border to interactively input a count n of numbers to be sorted. The program generates these n " +
        "numbers randomly, upper bound on the numbers to be sorted is 800. Let the min and max value of slider be 1 " +
        "and 800. Border of the slider shows the count of numbers used to sort in the experiment.\n\n" +
        "Use Slider to control the speed of display. Slider shows the sleep time in the titled border.\n\n" +
        "Use Button to start the simulation.\n\n" +
        "Use menuItem to select data version: Random, Best, Worst case data.\n\n" +
        "Use JCheckBoxMenuItems to select the algorithms at the same time.\n\n" +
        "You may use GridLayout to place drawPanels with vertical bar barchart of original numbers and sorting threads for " +
        "the algorithms.\n\n" +
        "Use a Reset menu item to restart, reselect algorithms.";

    JTextArea textArea = new JTextArea(string, 20, 40);
    textArea.setForeground(Color.BLUE);
    textArea.setFont(font);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setBorder(tBorder);
    add(new JScrollPane(textArea));

    getContentPane().setLayout(new FlowLayout());
  }
}
