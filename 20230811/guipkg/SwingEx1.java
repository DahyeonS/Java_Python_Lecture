package guipkg;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEx1 extends JFrame implements ActionListener {
	int index = 0;
	String[] msg = {"첫번째 문장", "두번째 문장", "세번째 문장"};
	JButton button1 = new JButton("<<");
	JButton button2 = new JButton(">>");
	JButton button3 = new JButton(msg[0]);
	
	public SwingEx1() {
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.setEnabled(false);
		add(button1, BorderLayout.WEST);
		add(button2, BorderLayout.EAST);
		add(button3, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 100);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o == button1) {
			index--;
		} else if (o == button2) {
			index++;
		}
		if (index > 2) index = 0;
		else if (index < 0) index = 2;
		
		button3.setText(msg[index]);
	}
	
	public static void main(String[] args) {
		SwingEx1 app = new SwingEx1();
	}

}
