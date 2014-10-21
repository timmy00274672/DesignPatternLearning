package facade.flight;

public class FlightPath {
    protected double distance;
    protected double apogee;

    public FlightPath(double distance, double apogee) {
	super();
	this.distance = distance;
	this.apogee = apogee;
    }

    public int[] getX(int nPoint) {
	int[] x = new int[nPoint];
	for (int i = 0; i < x.length; i++) {
	    double t = ((double) i) / (nPoint - 1);
	    x[i] = (int) (t * distance);
	}
	return x;
    }

    public int[] getY(int nPoint) {
	int[] y = new int[nPoint];
	for (int i = 0; i < y.length; i++) {
	    double t = ((double) i) / (nPoint - 1);
	    y[i] = (int) (4 * apogee * (t - .5) * (t - .5));
	}
	return y;
    }
}
