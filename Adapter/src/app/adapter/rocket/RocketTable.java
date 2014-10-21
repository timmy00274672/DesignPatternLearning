package app.adapter.rocket;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class RocketTable extends AbstractTableModel {
    protected Rocket[] rockets;
    protected String[] columnsName = new String[] { "Name", "Price", "Apogee" };

    public RocketTable(Rocket[] rockets) {
	super();
	this.rockets = rockets;
    }

    @Override
    public int getRowCount() {
	return rockets.length;
    }

    @Override
    public int getColumnCount() {
	return 3;
    }

    @Override
    public String getColumnName(int column) {
	return columnsName[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
	switch (columnIndex) {
	case 0:
	    return rockets[rowIndex].getName();
	case 1:
	    return rockets[rowIndex].getPrice();
	case 2:
	    return rockets[rowIndex].getApogee();
	default:
	    throw new RuntimeException("Unreachable");
	}
    }
}
