package facade.flight;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FlightPanel extends JPanel {
    public void paintComponent(Graphics g) {
	super.paintComponents(g);

	int nPoint = 101;
	FlightPath fPath = new FlightPath(getWidth() - 1, getHeight() - 1);
	g.drawPolygon(fPath.getX(nPoint), fPath.getY(nPoint), nPoint);
    }

}
