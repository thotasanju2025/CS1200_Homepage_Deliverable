import javax.swing.*;
import java.awt.*;

public class SettingsGUI {

    public SettingsGUI() {

        JFrame frame = new JFrame("Rhythmix — Settings");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(4, 1, 10, 10));

        JCheckBox darkMode = new JCheckBox("Dark Mode");
        JButton account = new JButton("Account Settings");
        JButton about = new JButton("About");
        JButton back = new JButton("Back");

        frame.add(darkMode);
        frame.add(account);
        frame.add(about);
        frame.add(back);

        about.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Rhythmix v1.0\nCreated for CS 1200 Project.")
        );
        back.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }
}
