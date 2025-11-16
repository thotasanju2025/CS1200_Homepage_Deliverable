import javax.swing.*;
import java.awt.*;

public class SavedLyricsGUI {

    public SavedLyricsGUI() {
        JFrame frame = new JFrame("Rhythmix — Saved Lyrics");
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        JTextArea area = new JTextArea("No saved lyrics yet...");
        area.setEditable(false);

        JButton back = new JButton("Back");

        frame.add(new JScrollPane(area), BorderLayout.CENTER);
        frame.add(back, BorderLayout.SOUTH);

        back.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }
}
