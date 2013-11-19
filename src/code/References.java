package code;

import javax.swing.*;
import java.awt.*;

/**
 * An internal frame that will display references used in this program.
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public class References extends JInternalFrame {

  /**
   * Constructor for a References object.
   * @param width the width of the panel
   * @param height the height of the panel
   */
  public References(int width, int height) {
    super("References", true, true, true, true);
    setSize(width, height);
    setOpaque(true);
    setVisible(true);

    JTextArea textArea = new JTextArea();
    textArea.setMargin(new Insets(10, 10, 10, 10));
    add(new JScrollPane(textArea));
    String str = "\nThis assignment uses the following only:\n\n";
    str = str+"1. Deite/Deitel Java How to Program TextBook\n";
    str = str+"2. Handouts, Example codes given in the class\n";
    textArea.setText(str);
    textArea.setBackground(Color.BLACK);
    textArea.setForeground(Color.CYAN);
    textArea.setFont(new Font("Arial", Font.BOLD,16));

    setLayout(new FlowLayout());
  }
}
