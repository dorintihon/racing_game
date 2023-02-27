import javax.swing.*;
import java.awt.*;

public class RaceDemo extends JPanel {
    private static final int PANEL_WIDTH = 600;
    private static final int PANEL_HEIGHT = 400;
    private static final int DELAY = 10; // delay in milliseconds
    private boolean isRaceFinished = false;
    private RacingVenue racingVenue;

    public RaceDemo() {

        racingVenue = new RacingVenue();

        Timer timer = new Timer(DELAY, e -> {
            if (!isRaceFinished) {
                racingVenue.updatePositions();

                if (racingVenue.isRaceFinished()) {
                    isRaceFinished = true;
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        racingVenue.draw(g);
        if (isRaceFinished) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("Race finished!", PANEL_WIDTH / 2 - 120, PANEL_HEIGHT / 2);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Race Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new RaceDemo());
        frame.pack();
        frame.setVisible(true);
    }
}