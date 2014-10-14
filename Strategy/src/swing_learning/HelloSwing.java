package swing_learning;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HelloSwing {

	public static void main(String[] args) {
		final JFrame frame = new JFrame("Hello");
		
		final JLabel label = new JLabel("label");
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,100);
		frame.setVisible(true);
	
		//not good to modify GUI in main thread
		//label.setText("Label Text");
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				label.setText("Label Text");
			}
		});
	}

}
