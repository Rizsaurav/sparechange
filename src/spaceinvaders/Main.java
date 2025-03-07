package spaceinvaders;

import javax.swing.*;
import spaceinvaders.menu_bar.MenuBar;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Space Invaders with Images");
            ImageSelection imageSelection = ImageSelection.getInstance();
            SpaceInvadersUI game = new SpaceInvadersUI(imageSelection);
            frame.add(game);

            frame.setJMenuBar(MenuBar.createMenuBar(imageSelection));

            frame.setSize(600, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
