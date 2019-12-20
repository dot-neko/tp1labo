package ui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;



public abstract class AbstractPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public AbstractPanel() {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setSize(500,  300);
		this.setLocation(20,100);
		this.setVisible(true);
	}
}
