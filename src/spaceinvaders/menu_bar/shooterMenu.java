package spaceinvaders.menu_bar;

import javax.swing.*;
import spaceinvaders.ImageSelection;

public class shooterMenu extends JMenu {
    public shooterMenu(ImageSelection imageSelection) {
        super("Shooter Image");

        JMenuItem shooter1 = new JMenuItem("Shooter Image 1");
        JMenuItem shooter2 = new JMenuItem("Shooter Image 2");
        JMenuItem shooter3 = new JMenuItem("Shooter Image 3");
        JMenuItem customShooter = new JMenuItem("Custom Shooter Image");

        shooter1.addActionListener(e -> imageSelection.setShooterImage("./resources//ShooterImages/ShooterImage1.png"));
        shooter2.addActionListener(e -> imageSelection.setShooterImage("./resources//ShooterImages/ShooterImage2.png"));
        shooter3.addActionListener(e -> imageSelection.setShooterImage("./resources//ShooterImages/ShooterImage3.png"));

        customShooter.addActionListener(e -> {
            String url = JOptionPane.showInputDialog("Enter URL for Shooter Image:");
            if (url != null && !url.isEmpty()) {
                imageSelection.setShooterImage(url);
            }
        });

        add(shooter1);
        add(shooter2);
        add(shooter3);
        add(customShooter);
    }
}
