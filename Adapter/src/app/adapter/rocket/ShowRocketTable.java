package app.adapter.rocket;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author timmy00274672
 * 
 */
public class ShowRocketTable {
    public static void main(String[] args) {
	Rocket[] rockets =
		new Rocket[] {
			new Rocket("Shooter", 3.95, 50.0),
			new Rocket("Orbit", 29.95, 5000.0) };
	AbstractTableModel tableModel = new RocketTable(rockets);
	JTable table = new JTable(tableModel);
	table.setRowHeight(36);
	JScrollPane pane = new JScrollPane(table);
	pane.setPreferredSize(new java.awt.Dimension(300, 100));
	display(pane, " Rockets");
    };

    public static void display(Component c, String title) {
	JFrame frame = new JFrame(title);
	frame.getContentPane().add(c);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
	frame.setVisible(true);
    }

}
