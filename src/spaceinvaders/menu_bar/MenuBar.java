package spaceinvaders.menu_bar;

import javax.swing.*;
import spaceinvaders.ImageSelection;

public class MenuBar {

    public static JMenuBar createMenuBar(ImageSelection imageSelection) {
        JMenuBar menuBar = new JMenuBar();

        // Adding shooter, invader, bullet, and music menus with image selection support
        menuBar.add(new shooterMenu(imageSelection));
        menuBar.add(new invaderMenu(imageSelection));
        menuBar.add(new bulletMenu(imageSelection));
        menuBar.add(new musicMenu());

        return menuBar;
    }
}
