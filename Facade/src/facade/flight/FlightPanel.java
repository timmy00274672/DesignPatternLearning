package facade.flight;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class FlightPanel extends JPanel {
    public void paintComponent(Graphics g) {
	super.paintComponents(g);

	int nPoint = 101;
	double w = getWidth() - 1;
	double h = getHeight() - 1;

	int[] x = new int[nPoint];
	int[] y = new int[nPoint];

	for (int i = 0; i < nPoint; i++) {
	    double t = ((double) i) / (nPoint - 1);
	    x[i] = (int) (t * w);
	    y[i] = (int) (4 * h * (t - .5) * (t - .5));
	}
	g.drawPolygon(x, y, nPoint);
    }

    /**
     * Create a new panel that wraps a titled border around a given panel.
     */
    public static JPanel createTitledPanel(String title, JPanel in) {
	JPanel out = new JPanel();
	out.add(in);
	out.setBorder(createTitledBorder(title));
	return out;
    }

    public static TitledBorder createTitledBorder(String title) {
	TitledBorder tb =
		BorderFactory.createTitledBorder(
			BorderFactory.createBevelBorder(BevelBorder.RAISED),
			title, TitledBorder.LEFT, TitledBorder.TOP);
	tb.setTitleColor(Color.black);
	tb.setTitleFont(getStandardFont());
	return tb;
    }

    /**
     * @return a standard font for GUI use
     */
    public static Font getStandardFont() {
	return new Font("Dialog", Font.PLAIN, 18);
    }

    public static void main(String[] args) {
	FlightPanel fPanel = new FlightPanel();
	fPanel.setPreferredSize(new Dimension(300, 200));
	JPanel fp_titled = createTitledPanel("Flight Path", fPanel);
	JFrame frame = new JFrame("Flight Path for Shell Duds");
	frame.getContentPane().add(fp_titled);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
	frame.setVisible(true);

    }
}
