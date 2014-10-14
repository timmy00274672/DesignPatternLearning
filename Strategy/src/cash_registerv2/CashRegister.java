package cash_registerv2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

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
	private JComboBox<String> comboBox = new JComboBox<>(CashStategy.getSupportedStrategy());
	private JButton addButton = new JButton("ADD");
	private JTextArea resultTextArea = new JTextArea("NONE");

	private double total = 0;
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
				double tempSum = CashStategy.getStategy(strategy).getSum(number, price);
				appendResultText(String.format(Locale.TAIWAN, "%.2f in %s method", tempSum, strategy));
				total += tempSum;
			}
		});
		setResultText("");

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

	private void appendResultText(final String msg) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				resultTextArea.append(msg + "\n");
			}
		});
	}
}
