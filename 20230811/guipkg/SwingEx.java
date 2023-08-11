package guipkg;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingEx extends JFrame {
	
	public SwingEx() {
		super("Hello World");
		getContentPane().setLayout(new FlowLayout());
		JLabel label = new JLabel("Welcome to Swing!!");
		getContentPane().add(label);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingEx app = new SwingEx();
	}

}
