package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main applet for the program. Project is responsible for displaying a menu that is used
 * to display JInternalFrames and JPanels.
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public class Project extends JApplet implements ActionListener {
  JMenu demosMenu, aboutMenu;
  JMenuItem authorMenuItem, problemMenuItem, referenceMenuItem, helpMenuItem;
  JInternalFrame author, problem, reference, help;
  JDesktopPane desktopPane;
  JMenuBar menuBar;

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

    desktopPane = new JDesktopPane();
    desktopPane.setBackground(Color.DARK_GRAY);
    getContentPane().add(desktopPane);

    repaint();
  }


  /**
   * Implementation of the ActionListener used in conjunction with the menu.
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
    }

    repaint();
  }

  /**
   * Main function allows the program to be run as an application.
   * @param args
   */
  public static void main(String args[]) {
    JFrame frame = new JFrame("Project");
    frame.setSize(800, 600);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setVisible(true);

    Project demo = new Project();
    frame.add(demo);
    demo.init();
    demo.start();
  }
}
