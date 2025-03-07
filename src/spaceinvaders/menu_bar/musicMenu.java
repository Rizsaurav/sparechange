package spaceinvaders.menu_bar;

import javax.swing.*;

public class musicMenu extends JMenu {
    public musicMenu() {
        super("musicMenu");

        JMenuItem music1 = new JMenuItem("Music Track 1");
        JMenuItem music2 = new JMenuItem("Music Track 2");
        JMenuItem music3 = new JMenuItem("Music Track 3");
        JMenuItem customMusic = new JMenuItem("Custom Music Track");

        add(music1);
        add(music2);
        add(music3);
        add(customMusic);
    }
}
