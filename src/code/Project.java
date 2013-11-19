package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The main applet for the program. Project is responsible for displaying a menu that is used
 * to display JInternalFrames and JPanels.
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public class Project extends JApplet implements ActionListener {
  JMenu demosMenu, aboutMenu, algorithmsMenu, dataMenu;
  JMenuItem authorMenuItem, problemMenuItem, referenceMenuItem, helpMenuItem, mainDisplayMenuItem, deselectAllMenuItem, randomMenuItem, bestMenuItem, worstMenuItem;
  JCheckBoxMenuItem bubble, insertion, selection, quick, heap, shell;
  JInternalFrame author, problem, reference, help;
  MainDisplay mainDisplay;
  JDesktopPane desktopPane;
  JMenuBar menuBar;
  DataType selectedDataType;
  List<JCheckBoxMenuItem> sorts;

  /**
   * This function is responsible for initializing the menu and panels.
   */
  public void init() {
    menuBar = new JMenuBar();
    setJMenuBar(menuBar);

    aboutMenu = new JMenu("About");
    menuBar.add(aboutMenu);

    demosMenu = new JMenu("Demos");
    menuBar.add(demosMenu);

    authorMenuItem = new JMenuItem("Author");
    authorMenuItem.addActionListener(this);
    aboutMenu.add(authorMenuItem);

    problemMenuItem = new JMenuItem("Problem");
    problemMenuItem.addActionListener(this);
    aboutMenu.add(problemMenuItem);

    referenceMenuItem = new JMenuItem("References");
    referenceMenuItem.addActionListener(this);
    aboutMenu.add(referenceMenuItem);

    helpMenuItem = new JMenuItem("Help");
    helpMenuItem.addActionListener(this);
    aboutMenu.add(helpMenuItem);

    algorithmsMenu = new JMenu("Algorithms");
    demosMenu.add(algorithmsMenu);

    bubble = new JCheckBoxMenuItem("Bubble Sort");
    algorithmsMenu.add(bubble);

    insertion = new JCheckBoxMenuItem("Insertion Sort");
    algorithmsMenu.add(insertion);

    selection = new JCheckBoxMenuItem("Selection Sort");
    algorithmsMenu.add(selection);

    quick = new JCheckBoxMenuItem("Quick Sort");
    algorithmsMenu.add(quick);

    heap = new JCheckBoxMenuItem("Heap Sort");
    algorithmsMenu.add(heap);

    shell = new JCheckBoxMenuItem("Shell Sort");
    algorithmsMenu.add(shell);

    sorts = new ArrayList<>();
    sorts.add(bubble);
    sorts.add(insertion);
    sorts.add(selection);
    sorts.add(quick);
    sorts.add(heap);
    sorts.add(shell);

    deselectAllMenuItem = new JMenuItem("Deselect All");
    deselectAllMenuItem.addActionListener(this);
    algorithmsMenu.add(deselectAllMenuItem);

    dataMenu = new JMenu("Data");
    demosMenu.add(dataMenu);
    selectedDataType = DataType.Random;

    randomMenuItem = new JMenuItem("Random");
    randomMenuItem.addActionListener(this);
    dataMenu.add(randomMenuItem);

    bestMenuItem = new JMenuItem("Best");
    bestMenuItem.addActionListener(this);
    dataMenu.add(bestMenuItem);

    worstMenuItem = new JMenuItem("Worst");
    worstMenuItem.addActionListener(this);
    dataMenu.add(worstMenuItem);

    mainDisplayMenuItem = new JMenuItem("Main Display");
    mainDisplayMenuItem.addActionListener(this);
    demosMenu.add(mainDisplayMenuItem);

    desktopPane = new JDesktopPane();
    desktopPane.setBackground(Color.DARK_GRAY);
    add(desktopPane);

    repaint();
  }

  /**
   * Implementation of the ActionListener used in conjunction with the buttons.
   *
   * @param e The ActionEvent object.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == authorMenuItem && (author == null || author.isClosed())) {
      author = new Author(700, 500);
      desktopPane.add(author);
      author.toFront();
    } else if (e.getSource() == problemMenuItem && (problem == null || problem.isClosed())) {
      problem = new Problem(700, 500);
      desktopPane.add(problem);
      problem.toFront();
    } else if(e.getSource() == referenceMenuItem && (reference == null || reference.isClosed())) {
      reference = new References(700, 500);
      desktopPane.add(reference);
      reference.toFront();
    } else if(e.getSource() == helpMenuItem && (help == null || help.isClosed())) {
      help = new Help(700, 500);
      desktopPane.add(help);
      help.toFront();
    } else if(e.getSource() == mainDisplayMenuItem && (mainDisplay == null || mainDisplay.isClosed())) {
      mainDisplay = new MainDisplay(1000, 700, selectedDataType, sorts);
      desktopPane.add(mainDisplay);
      mainDisplay.toFront();
    } else if(e.getSource() == deselectAllMenuItem) {
      bubble.setSelected(false);
      insertion.setSelected(false);
      selection.setSelected(false);
      quick.setSelected(false);
      heap.setSelected(false);
      shell.setSelected(false);
    } else if(e.getSource() == randomMenuItem) {
      selectedDataType = DataType.Random;
      if(mainDisplay != null) {
        mainDisplay.setDataType(selectedDataType);
      }
    } else if(e.getSource() == bestMenuItem) {
      selectedDataType = DataType.Best;
      if(mainDisplay != null) {
        mainDisplay.setDataType(selectedDataType);
      }
    } else if(e.getSource() == worstMenuItem) {
      selectedDataType = DataType.Worst;
      if(mainDisplay != null) {
        mainDisplay.setDataType(selectedDataType);
      }
    }

    repaint();
  }

  /**
   * Main function allows the program to be run as an application.
   * @param args
   */
  public static void main(String args[]) {
    JFrame frame = new JFrame("Project");
    frame.setSize(1200, 800);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setVisible(true);

    Project demo = new Project();
    frame.add(demo);
    demo.init();
    demo.start();
    frame.setVisible(true); // This is to appease Jordan's messed up Java
  }
}
