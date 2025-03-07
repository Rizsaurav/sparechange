package spaceinvaders.menu_bar;

import javax.swing.*;
import spaceinvaders.ImageSelection;

public class invaderMenu extends JMenu {
    public invaderMenu(ImageSelection imageSelection) {
        super("Invader Image");

        JMenuItem invader1 = new JMenuItem("Invader Image 1");
        JMenuItem invader2 = new JMenuItem("Invader Image 2");
        JMenuItem invader3 = new JMenuItem("Invader Image 3");
        JMenuItem customInvader = new JMenuItem("Custom Invader Image");

        invader1.addActionListener(e -> imageSelection.setInvaderImage("./resources/InvaderImages/InvaderImage1.png"));
        invader2.addActionListener(e -> imageSelection.setInvaderImage("./resources/InvaderImages/InvaderImage11.png"));
        invader3.addActionListener(e -> imageSelection.setInvaderImage("./resources/InvaderImages/InvaderImage3.png"));

        customInvader.addActionListener(e -> {
            String url = JOptionPane.showInputDialog("Enter URL for Invader Image:");
            if (url != null && !url.isEmpty()) {
                imageSelection.setInvaderImage(url);
            }
        });

        add(invader1);
        add(invader2);
        add(invader3);
        add(customInvader);
    }
}
