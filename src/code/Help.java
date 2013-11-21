package code;

import javax.swing.*;
import java.awt.*;

/**
 * An internal frame that will display help information about this program.
 *
 * @author Alex Wright, Jordan Schlechte, Tyler Catanzaro
 * @version 1.0
 */
public class Help extends JInternalFrame {

  /**
   * Constructor for a Help object.
   *
   * @param width  the width of the panel
   * @param height the height of the panel
   */
  public Help(int width, int height) {
    super("Help", true, true, true, true);
    setSize(width, height);
    setOpaque(true);
    setVisible(true);

    JTextArea textArea = new JTextArea();
    textArea.setMargin(new Insets(10, 10, 10, 10));
    add(new JScrollPane(textArea));
    String str = "\nTo Visualize Sorting Algorithms:\n\n";
    str = str + "1. Launch the Main Display in Demos > Main Display.\n";
    str = str + "2. Select up to three sorts from Demos > Algorithms.\n";
    str = str + "3. Select a data set from Demos > Data.\n";
    str = str + "4. Start the run from the Main Display window.\n";
    textArea.setText(str);
    textArea.setBackground(Color.BLACK);
    textArea.setForeground(Color.CYAN);
    textArea.setFont(new Font("Arial", Font.BOLD, 16));

    setLayout(new FlowLayout());
  }
}
