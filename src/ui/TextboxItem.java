package ui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextboxItem extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtField;

	public TextboxItem(String label, int size) {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setSize(500,  300);
		this.setLocation(20,100);
		this.add(new JLabel(label + " :"));
		this.add(txtField=new JTextField(size));
		txtField.setMaximumSize(txtField.getPreferredSize());
	}

	public JTextField getTxtField() {
		return txtField;
	}	
}
