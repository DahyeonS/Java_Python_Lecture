package guipkg;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

public class AWTEx1 {

	public static void main(String[] args) {
		Frame f = new Frame("Hello Wordl!!");
		f.setLayout(new FlowLayout());
		Label label = new Label("Welcome to AWT");
		f.add(label);
	}

}
