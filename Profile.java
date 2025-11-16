import javax.swing.*;
import java.awt.*;

public class ProfileGUI {

    public ProfileGUI() {

        JFrame frame = new JFrame("Rhythmix — Profile");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

        JTextField name = new JTextField("Your Name");
        JTextField email = new JTextField("your@email.com");

        JButton save = new JButton("Save");
        JButton back = new JButton("Back");

        frame.add(new JLabel("Profile Page", SwingConstants.CENTER));
        frame.add(name);
        frame.add(email);
        frame.add(save);
        frame.add(back);

        save.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Profile Saved!"));
        back.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }
}
