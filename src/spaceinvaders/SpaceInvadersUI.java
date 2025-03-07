package spaceinvaders;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SpaceInvadersUI extends JPanel implements ActionListener, KeyListener {

    private final Timer timer;
    public ArrayList<InvaderBox> invaderboxes;
    public ArrayList<Bullet> bullets;
    public Random random;
    public boolean moveLeft, moveRight, shooting;
    private final ListenerActions listenerActions;
    public final ImageSelection imageSelection;
    private final PaintingActions paintingActions;
    private final int shooter_width = 50;
    private final int shooter_height = 60;
    private int shooter_X_Coordinate = 200;

    // Constructor receives ImageSelection instance
    public SpaceInvadersUI(ImageSelection imageSelection) {
        this.imageSelection = imageSelection;
        this.imageSelection.setGameImages();

        timer = new Timer(20, this); // 20ms delay for smooth animations
        invaderboxes = new ArrayList<>();
        bullets = new ArrayList<>();
        random = new Random();
        moveLeft = false;
        moveRight = false;
        shooting = false;
        listenerActions = new ListenerActions();
        paintingActions = new PaintingActions();

        setFocusable(true);
        timer.start();
        setupListeners();
    }

    private void setupListeners() {
        addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listenerActions.updatePositions(this);

        // Keep shooting even when changing direction
        if (shooting) {
            bullets.add(new Bullet(shooter_X_Coordinate + shooter_width / 2, 550));
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        listenerActions.keyPressed(e, this);
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            shooting = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        listenerActions.keyReleased(e, this);
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            shooting = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        // Draw shooter with updated image
        g.drawImage(imageSelection.getShooterImage(), shooter_X_Coordinate, 550, shooter_width, shooter_height, this);

        // Draw falling invader boxes
        paintingActions.drawInvaders(g, invaderboxes, imageSelection.getInvaderImage(), this);

        // Draw bullets
        paintingActions.drawBullets(g, bullets);
    }

    public int getShooterWidth() {
        return shooter_width;
    }

    public int getShooterHeight() {
        return shooter_height;
    }

    public int getShooter_X_Coordinate() {
        return shooter_X_Coordinate;
    }

    public void setShooter_X_Coordinate(int shooter_X) {
        shooter_X_Coordinate = shooter_X;
    }

    // Inner class representing falling invader boxes
    public class InvaderBox {
        int x, y, size;

        public InvaderBox(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    // Inner class representing bullets
    public class Bullet {
        int x, y;

        public Bullet(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
