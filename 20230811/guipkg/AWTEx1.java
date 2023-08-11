package guipkg;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTEx1 {

	public static void main(String[] args) {
		Frame f = new Frame("Hello Wordl!!");
		f.setLayout(new FlowLayout());
		Label label = new Label("Welcome to AWT");
		f.add(label);
		f.setSize(500, 500);
		f.setVisible(true);
		f.addWindowListener(new WindowCloseHandler());
	}

}

class WindowCloseHandler extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}