package swing_learning;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SubmitSwingProgram extends JFrame{
	//singalton
	static private SubmitSwingProgram swp;
	static SubmitSwingProgram getSubmitSwingProgram(){
		if (swp == null)
			swp = new SubmitSwingProgram();
		return swp;
	}
	JLabel label;
	
	private SubmitSwingProgram() {
		super("hello Swing");
		label = new JLabel("a label");
		add(label);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,100);
		setVisible(true);
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				SubmitSwingProgram.getSubmitSwingProgram();
			}
		});
		
		TimeUnit.SECONDS.sleep(1);
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				getSubmitSwingProgram().label.setText("Label Text");
			}
		});
		
	}
	
}
