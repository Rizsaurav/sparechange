package spaceinvaders.menu_bar;

import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

public class musicMenu extends JMenu {
    public musicMenu() {
        super("Music");

        JMenuItem music1 = new JMenuItem("Music Track 1");
        JMenuItem music2 = new JMenuItem("Music Track 2");
        JMenuItem music3 = new JMenuItem("Music Track 3");
        JMenuItem customMusic = new JMenuItem("Custom Music Track");
        JMenuItem noMusic = new JMenuItem("No Music");

        music1.addActionListener(e -> MusicSelection.getInstance().playMusic("/resources/music1.wav"));
        music2.addActionListener(e -> MusicSelection.getInstance().playMusic("/resources/music2.wav"));
        music3.addActionListener(e -> MusicSelection.getInstance().playMusic("/resources/music3.wav"));

        customMusic.addActionListener(e -> {
            String url = JOptionPane.showInputDialog("Enter URL for Custom Music:");
            if (url != null && !url.isEmpty()) {
                MusicSelection.getInstance().playMusic(url);
            }
        });

        noMusic.addActionListener(e -> MusicSelection.getInstance().stopMusic());

        add(music1);
        add(music2);
        add(music3);
        add(customMusic);
        add(noMusic);
    }

    // Inner class MusicSelection defined here
    private static class MusicSelection {
        private static MusicSelection instance;
        private Clip clip;

        private MusicSelection() {}

        public static MusicSelection getInstance() {
            if (instance == null) {
                instance = new MusicSelection();
            }
            return instance;
        }

        public void playMusic(String filepath) {
            stopMusic();
            try {
                AudioInputStream audioStream;
                if (filepath.startsWith("http")) {
                    audioStream = AudioSystem.getAudioInputStream(new URL(filepath));
                } else {
                    audioStream = AudioSystem.getAudioInputStream(getClass().getResource(filepath));
                }
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error loading music: " + e.getMessage());
            }
        }

        public void stopMusic() {
            if (clip != null && clip.isRunning()) {
                clip.stop();
                clip.close();
            }
        }
    }
}
