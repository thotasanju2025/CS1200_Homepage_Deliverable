import javax.swing.*;
import java.awt.*;

public class LyricGeneratorGUI {

    public LyricGeneratorGUI() {

        JFrame frame = new JFrame("Rhythmix — Lyric Generator");
        frame.setSize(450, 600);
        frame.setLayout(new GridLayout(8, 1, 10, 10));

        JLabel label = new JLabel("Enter prompt:", SwingConstants.CENTER);
        JTextArea promptArea = new JTextArea();
        promptArea.setLineWrap(true);

        String[] genres = {"Pop", "Rap", "Country", "Rock", "EDM"};
        JComboBox<String> genreDropdown = new JComboBox<>(genres);

        String[] lengths = {"Short (8 lines)", "Medium (16 lines)", "Long (32 lines)"};
        JComboBox<String> lengthDropdown = new JComboBox<>(lengths);

        String[] languages = {"English", "Spanish", "Hindi", "Korean"};
        JComboBox<String> languageDropdown = new JComboBox<>(languages);

        JButton generateBtn = new JButton("Generate Lyrics");
        JButton backBtn = new JButton("Back");

        frame.add(label);
        frame.add(new JScrollPane(promptArea));
        frame.add(genreDropdown);
        frame.add(lengthDropdown);
        frame.add(languageDropdown);
        frame.add(generateBtn);
        frame.add(backBtn);

        generateBtn.addActionListener(e ->
                JOptionPane.showMessageDialog(frame,
                        "AI would generate lyrics here.\n(Not connected to API for this project.)")
        );

        backBtn.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }
}
