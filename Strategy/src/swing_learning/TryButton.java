package swing_learning;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TryButton extends JFrame {
	private JButton b1 = new JButton("B1"), b2 = new JButton("B2");
	private JTextField txt = new JTextField(10);

	private ActionListener buttonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Should be register at Button
			String name = "error";
			if (e.getSource() instanceof JButton)
				name = ((JButton) e.getSource()).getText();
			txt.setText(name);
		}
	};

	public TryButton() {
		b1.addActionListener(buttonListener);
		b2.addActionListener(buttonListener);
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(txt);
	}

	public static void main(String[] args) {
		SwingConsole.run(new TryButton(), 200, 100);
	}
}
