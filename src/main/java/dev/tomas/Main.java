package dev.tomas;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends JFrame {
    private final JLabel label;

    public Main() {
        setTitle("Relógio Digital");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(40, 40, 40));
        panel.setLayout(new FlowLayout());

        label = new JLabel();
        label.setForeground(new Color(255, 255, 255));
        label.setFont(new Font("Arial", Font.PLAIN, 36));

        panel.add(label);

        add(panel, BorderLayout.CENTER);

        updateClock();

        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();
        setVisible(true);
    }

    private void updateClock() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = dateFormat.format(now);

        label.setText(formattedTime);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
