package code;

import javax.swing.*;
import java.awt.*;

/**
 * An internal frame that will display the title page for the project including author, class, professor, and
 * a statement about the originality of the work.
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public class Author extends JInternalFrame {

  /**
   * Fonts for displaying text.
   */
  Font small, normal, bold, bigNormal, bigBold;

  /**
   * Holds the width of the last string drawn.
   */
  int stringWidth;

  /**
   * Hold the y value of the next string to be drawn.
   */
  int y;

  /**
   * The string to be drawn.
   */
  String string;

  /**
   * Constructor for a Author object.
   * @param width the width of the panel
   * @param height the height of the panel
   */
  public Author(int width, int height) {
    super("Author", true, true, true, true);
    setSize(width, height);
    setOpaque(true);
    setVisible(true);

    small = new Font("Helvetica", Font.PLAIN, 18);
    normal = new Font("Helvetica", Font.PLAIN, 25);
    bold = new Font("TimesRoman", Font.BOLD, 25);
    bigNormal = new Font("Courier", Font.PLAIN, 40);
    bigBold = new Font("SansSerif", Font.BOLD, 40);

    setLayout(new FlowLayout());
  }

  /**
   * Paints the text on the panel.
   * @param g The graphics object used to draw to the panel
   */
  @Override
  public void paint(Graphics g) {
    super.paint(g);

    y = 115;

    g.setFont(bold);
    g.setColor(Color.BLUE);
    string = "Demonstration of Assignment for";
    stringWidth = g.getFontMetrics(bold).stringWidth(string);
    g.drawString(string, getWidth() / 2 - (stringWidth / 2), y);

    string = "Java, GUI, and Visualization";
    y += 20;
    stringWidth = g.getFontMetrics(bold).stringWidth(string);
    g.drawString(string, getWidth() / 2 - (stringWidth / 2), y);

    g.setFont(normal);
    string = "For";
    y += 30;
    stringWidth = g.getFontMetrics(normal).stringWidth(string);
    g.drawString(string, getWidth() / 2 - (stringWidth / 2), y);

    string = "Dr. Chaman Lal Sabharwal";
    y += 40;
    stringWidth = g.getFontMetrics(normal).stringWidth(string);
    g.drawString(string, getWidth() / 2 - (stringWidth / 2), y);

    string = " Presented by ";
    y += 50;
    stringWidth = g.getFontMetrics(normal).stringWidth(string);
    g.drawString(string, getWidth() / 2 - (stringWidth / 2), y);

    g.setFont(bold);
    g.setColor(Color.MAGENTA);
    string = "Alex Wright, Jordan Schlechte, Tyler Catanzaro";
    y += 60;
    stringWidth = g.getFontMetrics(bold).stringWidth(string);
    g.drawString(string, getWidth() / 2 - (stringWidth / 2), y);

    g.setFont(bigBold);
    g.setColor(Color.RED);
    string = "All code is our own development";
    y += 70;
    stringWidth = g.getFontMetrics(bigBold).stringWidth(string);
    g.drawString(string, getWidth() / 2 - (stringWidth / 2), y);
    
    g.setFont(small);
    g.setColor(Color.BLACK);
    string = "Tyler Catanzaro worked on the graphs and got them to draw to the screen.";
    y += 30;
    stringWidth = g.getFontMetrics(small).stringWidth(string);
    g.drawString(string, getWidth() / 2 - (stringWidth / 2), y);

    g.setFont(small);
    g.setColor(Color.BLACK);
    string = "Jordan Schlechte implemented the VisualizableSorts.";
    y += 20;
    stringWidth = g.getFontMetrics(small).stringWidth(string);
    g.drawString(string, getWidth() / 2 - (stringWidth / 2), y);

    g.setFont(small);
    g.setColor(Color.BLACK);
    string = "Alex Wright organized and implemented the menus and internal frames.";
    y += 20;
    stringWidth = g.getFontMetrics(small).stringWidth(string);
    g.drawString(string, getWidth() / 2 - (stringWidth / 2), y);
  }
}
