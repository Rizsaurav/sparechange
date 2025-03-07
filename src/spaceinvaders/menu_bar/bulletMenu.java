package spaceinvaders.menu_bar;

import javax.swing.*;
import spaceinvaders.ImageSelection;

public class bulletMenu extends JMenu {
    public bulletMenu(ImageSelection imageSelection) {
        super("Bullet Type");

        JMenuItem bullet1 = new JMenuItem("Bullet Type 1");
        JMenuItem bullet2 = new JMenuItem("Bullet Type 2");
        JMenuItem bullet3 = new JMenuItem("Bullet Type 3");
        JMenuItem customBullet = new JMenuItem("Custom Bullet Type");

        bullet1.addActionListener(e -> imageSelection.updateImage("bullet", "./resources/BulletImages/BulletImage2.png"));
        bullet2.addActionListener(e -> imageSelection.updateImage("bullet", "./resources/BulletImages/BulletImage2.png"));
        bullet3.addActionListener(e -> imageSelection.updateImage("bullet", "./resources/BulletImages/BulletImage2.png"));

        customBullet.addActionListener(e -> {
            String url = JOptionPane.showInputDialog(null, "Enter URL for Bullet Image:");
            if (url != null && !url.isEmpty()) {
                imageSelection.updateImage("bullet", url);
            }
        });

        add(bullet1);
        add(bullet2);
        add(bullet3);
        add(customBullet);
    }
}
