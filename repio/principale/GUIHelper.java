package repio.principale;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by osboxes on 30/01/17.
 */
public class GUIHelper {

    public static void showOnFrame(JComponent component, String framName,JFrame win){
    	win = new JFrame(framName);
        WindowAdapter wa = new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        };
        win.addWindowListener(wa);
        win.getContentPane().add(component);
        win.pack();
        win.setVisible(true);
    }
}
