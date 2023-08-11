package guipkg;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingLayout extends JFrame {
	JButton button1 = new JButton("Button1");
	JButton button2 = new JButton("Button2");
	JButton button3 = new JButton("Button3");
	JButton button4 = new JButton("Button4");
	JButton button5 = new JButton("Button5");
	
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	
	void flowLayout() {
		p1.setLayout(new FlowLayout());
		p1.add(button1);
		p1.add(button2);
		p1.add(button3);
		p1.add(button4);
		p1.add(button5);
	}
	
	void borderLayout() {
		p1.setLayout(new BorderLayout());
		p1.add(button1, BorderLayout.NORTH);
		p1.add(button2, BorderLayout.WEST);
		p1.add(button3, BorderLayout.EAST);
		p1.add(button4, BorderLayout.SOUTH);
		p1.add(button5, BorderLayout.CENTER);
	}
	
	void cardLayout() {
		final CardLayout CARD = new CardLayout();
		setLayout(CARD);
		p1.add(button1);
		p1.add(button2);
		p1.add(button3);
		p2.add(button4);
		p2.add(button5);
		add("p1", p1);
		add("p2", p2);
		
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CARD.show(getContentPane(), "p2");
			}
		});
		
		button5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CARD.show(getContentPane(), "p1");
			}
		});
	}
	
	public SwingLayout() {
		super("Layout Showcase");
		getContentPane().add(p1);
//		flowLayout(); // 창 크기에 따라 버튼의 위치가 바뀜
//		borderLayout(); // 설정한 위치(동-서-남-북-중앙)로 버튼이 할당
		cardLayout(); // 특정 버튼을 누르면 레이아웃 이동
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingLayout app = new SwingLayout();
	}

}
