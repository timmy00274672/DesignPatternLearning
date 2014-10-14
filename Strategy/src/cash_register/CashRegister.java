package cash_register;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import swing_learning.SwingConsole;

@SuppressWarnings("serial")
public class CashRegister extends JFrame {
	private JTextArea priceTitleTextArea = new JTextArea("prices", 1, 2);
	private JTextField priceTextField = new JTextField(20);
	private JTextArea numberTitleTextArea = new JTextArea("number", 1, 2);
	private JTextField numberTextField = new JTextField(20);
	private JComboBox<String> comboBox = new JComboBox<>(CashStategy
			.getStrategy().keySet().toArray(new String[] {}));
	private JButton addButton = new JButton("ADD");
	private JTextArea resultTextArea = new JTextArea("NONE", 4, 400);

	public CashRegister() {
		super();
		priceTitleTextArea.setEditable(false);
		numberTitleTextArea.setEditable(false);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double price = Double.parseDouble(priceTextField.getText());
				int number = (int) Double.parseDouble(numberTextField.getText());
				String strategy = comboBox.getSelectedItem().toString();
				double tempSum = CashStategy.getStrategy().get(strategy).getSum(number, price);
				setResultText("$" + tempSum + strategy);
			}
		});

		setLayout(new FlowLayout());
		add(priceTitleTextArea);
		add(priceTextField);
		add(numberTitleTextArea);
		add(numberTextField);
		add(comboBox);
		add(addButton);
		add(resultTextArea);
	}

	public static void main(String[] args) {
		SwingConsole.run(new CashRegister(), 300, 400);
	}

	private void setResultText(final String msg) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				resultTextArea.setText(msg);
			}
		});
	}

}
