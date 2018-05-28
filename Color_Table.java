package Layout_Test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Color_Frame extends JFrame {
	Color_Frame() {
		// ---Basic Frame Setting
		this.setTitle("Color_Table");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(650, 450);

		this.setVisible(true);
		this.setSize(new Dimension(700, 300));
		JPanel Color_Panel = new JPanel();

		Color_Panel.setLayout(new GridLayout(4, 4, -1, -1));

		makeButton(Color_Panel, "1");
		makeButton(Color_Panel, "2");
		makeButton(Color_Panel, "3");
		makeButton(Color_Panel, "4");
		makeButton(Color_Panel, "5");
		makeButton(Color_Panel, "6");
		makeButton(Color_Panel, "7");
		makeButton(Color_Panel, "8");
		makeButton(Color_Panel, "9");
		makeButton(Color_Panel, "10");
		makeButton(Color_Panel, "11");
		makeButton(Color_Panel, "12");
		makeButton(Color_Panel, "13");
		makeButton(Color_Panel, "14");
		makeButton(Color_Panel, "15");
		makeButton(Color_Panel, "16");
		add(Color_Panel);
	}

	public void makeButton(JPanel Color_Panel, String t) {
		JButton b = new JButton(t);
		b.setAlignmentX(Component.LEFT_ALIGNMENT);

		int R, G, B; // --- 랜덤으로 RGB값 넣을 변수

		R = (int) (Math.random() * 255 + 0);
		G = (int) (Math.random() * 255 + 0);
		B = (int) (Math.random() * 255 + 0);
		b.setBackground(new Color(R, G, B));
		b.setForeground(Color.WHITE);
		b.setHorizontalAlignment(JButton.LEFT);

		Color_Panel.add(b);
	}

	// --- Last Frame Setting

}// --- End Of Color_Frame Creator

public class Color_Table {
	public static void main(String asg[]) {
		new Color_Frame();
	}
}
