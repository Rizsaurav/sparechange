package spaceinvaders;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageSelection {
    private static ImageSelection instance;

    private Image shooterImage;
    private Image invaderImage;
    private Image bulletImage;

    private ImageSelection() {
        setGameImages();
    }

    public static ImageSelection getInstance() {
        if (instance == null) {
            instance = new ImageSelection();
        }
        return instance;
    }

    public Image getShooterImage() { return shooterImage; }
    public Image getInvaderImage() { return invaderImage; }
    public Image getBulletImage() { return bulletImage; }

    public void setShooterImage(String imagePath) {
        shooterImage = loadImage("shooter", imagePath);
    }

    public void setInvaderImage(String imagePath) {
        invaderImage = loadImage("invader", imagePath);
    }

    public void setBulletImage(String imagePath) {
        bulletImage = loadImage("bullet", imagePath);
    }

    // ✅ Universal update method
    public void updateImage(String type, String imagePath) {
        switch (type) {
            case "shooter" -> setShooterImage(imagePath);
            case "invader" -> setInvaderImage(imagePath);
            case "bullet" -> setBulletImage(imagePath);
            default -> JOptionPane.showMessageDialog(null, "Invalid image type: " + type);
        }
    }

    public void setGameImages() {
        shooterImage = loadImage("shooter", "./resources/ShooterImage.png");
        invaderImage = loadImage("invader", "./resources/InvaderImage.png");
        bulletImage = loadImage("bullet", "./resources/BulletImage1.png");
    }

    private static Image loadImage(String imageType, String imagePath) {
        try {
            if (imagePath.startsWith("http")) {
                return ImageIO.read(new URL(imagePath));
            } else {
                return ImageIO.read(ImageSelection.class.getResource(imagePath));
            }
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "Invalid URL for " + imageType + " image.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to load " + imageType + " image.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "File not found: " + imagePath);
        }
        return null;
    }
}
