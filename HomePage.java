import javax.swing.*;
import java.awt.*;

public class HomePageGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Rhythmix — Homepage");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 1, 10, 10));

        JLabel title = new JLabel("🎵 Rhythmix — AI Lyric Generator 🎵", SwingConstants.CENTER);
        frame.add(title);

        JButton generateBtn = new JButton("Generate Lyrics");
        JButton savedBtn = new JButton("Saved Lyrics");
        JButton profileBtn = new JButton("Profile Page");
        JButton settingsBtn = new JButton("Settings");
        JButton logoutBtn = new JButton("Logout");

        frame.add(generateBtn);
        frame.add(savedBtn);
        frame.add(profileBtn);
        frame.add(settingsBtn);
        frame.add(logoutBtn);

        // Navigation
        generateBtn.addActionListener(e -> new LyricGeneratorGUI());
        savedBtn.addActionListener(e -> new SavedLyricsGUI());
        profileBtn.addActionListener(e -> new ProfileGUI());
        settingsBtn.addActionListener(e -> new SettingsGUI());
        logoutBtn.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }
}
