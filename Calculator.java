package Layout_Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class CalcuFrame extends JFrame implements ActionListener {

	//--- ��ư ����
	JButton CE = new JButton("CE");
	JButton C = new JButton("C");
	JButton Back = new JButton("��");
	JButton Divide = new JButton("/");
	JButton One = new JButton("1");
	JButton Two = new JButton("2");
	JButton Three = new JButton("3");
	JButton Four = new JButton("4");
	JButton Five = new JButton("5");
	JButton Six = new JButton("6");
	JButton Seven = new JButton("7");
	JButton Eight = new JButton("8");
	JButton Nine = new JButton("9");
	JButton Zero = new JButton("0");
	JButton Multi = new JButton("X");
	JButton Minus = new JButton("-");
	JButton Plus = new JButton("+");
	JButton Point = new JButton(".");
	JButton PlusMinus = new JButton("��");
	JButton Result = new JButton("=");
	double Operate_Result;
	static int CalcuMode = 1;
	boolean Point_Operate = false; // --- �Ҽ���� ���(int, Double ó�� ����)
	
	//--- ��� ���� ���̴� Saver
	String Operate_Save = "";
	String Operand_Save = "";
	Double PlusMinus_Save; 

	//--- �г� �߰�
	JPanel NorthPanel = new JPanel();
	JPanel NumberPanel1 = new JPanel();
	JPanel NumberPanel2 = new JPanel();
	JPanel NumberPanel3 = new JPanel();
	JPanel NumberPanel4 = new JPanel();

	JPanel OperatePanel = new JPanel();
	JTextArea Text = new JTextArea(); // --- show number

	CalcuFrame() {

		// --- set Button Size and style (for readability)
		OperatePanel.setLayout(null);
		CE.setBounds(10, 10, 60, 40);
		C.setBounds(85, 10, 60, 40);
		Back.setBounds(160, 10, 60, 40);
		Divide.setBounds(235, 10, 60, 40);
		// --- ����. ���� �ֱ� �� 
		OperatePanel.setBackground(new Color(250, 244, 192));
		NumberPanel2.setBackground(new Color(222, 165, 165));
		NumberPanel4.setBackground(new Color(212, 244, 250));

		NumberPanel1.setLayout(null);
		Seven.setBounds(10, 0, 60, 40);
		Eight.setBounds(85, 0, 60, 40);
		Nine.setBounds(160, 0, 60, 40);
		Multi.setBounds(235, 0, 60, 40);

		NumberPanel2.setLayout(null);
		Four.setBounds(10, 0, 60, 40);
		Five.setBounds(85, 0, 60, 40);
		Six.setBounds(160, 0, 60, 40);
		Minus.setBounds(235, 0, 60, 40);

		NumberPanel3.setLayout(null);
		One.setBounds(10, 0, 60, 40);
		Two.setBounds(85, 0, 60, 40);
		Three.setBounds(160, 0, 60, 40);
		Plus.setBounds(235, 0, 60, 40);

		NumberPanel4.setLayout(null);
		PlusMinus.setBounds(10, 0, 60, 40);
		Zero.setBounds(85, 0, 60, 40);
		Point.setBounds(160, 0, 60, 40);
		Result.setBounds(235, 0, 60, 40);

		// --- Frame basic setting
		this.setTitle("����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(5, 5));
		this.setResizable(false); // --- Do not change Frame Size
		this.setLocation(750, 450);

		// --- Text basic Setting
		Text.setText("");
		Text.setPreferredSize(new Dimension(300, 500));
		Text.setEditable(false); // --- �ؽ�Ʈâ�ȿ� �۾� ���� ���ϵ��� ��

		// ---Set Basic Panel use and add Button in panel
		this.setLayout(new GridLayout(6, 4, 5, 5));

		add(NorthPanel, BorderLayout.NORTH);
		NorthPanel.add(Text);

		add(OperatePanel, BorderLayout.CENTER);
		OperatePanel.add(CE);
		OperatePanel.add(C);
		OperatePanel.add(Back);
		OperatePanel.add(Divide);

		add(NumberPanel1, BorderLayout.SOUTH);
		NumberPanel1.add(Seven);
		NumberPanel1.add(Eight);
		NumberPanel1.add(Nine);
		NumberPanel1.add(Multi);

		add(NumberPanel2, BorderLayout.SOUTH);
		NumberPanel2.add(Four);
		NumberPanel2.add(Five);
		NumberPanel2.add(Six);
		NumberPanel2.add(Minus);

		add(NumberPanel3, BorderLayout.SOUTH);
		NumberPanel3.add(One);
		NumberPanel3.add(Two);
		NumberPanel3.add(Three);
		NumberPanel3.add(Plus);

		add(NumberPanel4, BorderLayout.SOUTH);
		NumberPanel4.add(PlusMinus);
		NumberPanel4.add(Zero);
		NumberPanel4.add(Point);
		NumberPanel4.add(Result);

		this.setSize(310, 450);
		this.setVisible(true);

		// ---ActionListener �߰�
		CE.addActionListener(this);
		C.addActionListener(this);
		Back.addActionListener(this);
		Result.addActionListener(this);

		One.addActionListener(this);
		Two.addActionListener(this);
		Three.addActionListener(this);
		Four.addActionListener(this);
		Five.addActionListener(this);
		Six.addActionListener(this);
		Seven.addActionListener(this);
		Eight.addActionListener(this);
		Nine.addActionListener(this);
		Zero.addActionListener(this);

		Plus.addActionListener(this);
		Minus.addActionListener(this);
		Divide.addActionListener(this);
		Multi.addActionListener(this);
		PlusMinus.addActionListener(this);
		Point.addActionListener(this);

		// ==================== ���� ���̾ƿ�, ActionListener �߰� �κ�

		// ======================= ���� ��� �κ�

	}// --- End of CalcuFrame Creator

	public void actionPerformed(ActionEvent e) {

		String Operate = ""; // --- ��� �߻��� ������ ����
		String Operand = ""; // --- ����߻��� ���� ����
		String s = e.getActionCommand(); // ---��ư ���� Text ����
		String Text_window = Text.getText(); // --- ȭ�� â

		if (s == "1" || s == "2" || s == "3" || s == "4" || s == "5" || s == "6" || s == "7" || s == "8" || s == "9"
				|| s == "0") {

			if (CalcuMode == 1) { 
				Text.setText(Text_window + s);
			}

			else if (CalcuMode == 0) { //--- = �� ������ ��
				Text_window = "";
				Text.setText(Text_window + s);
				CalcuMode = 1;
			}
		}

		if (s == ".") {
			Text.setText(Text_window + s);
			Point_Operate = true; // --- �Ҽ� ��� ��� ON
		}

		if (s == "+" || s == "-" || s == "X" || s == "/") {
			Operand = Text_window;
			Operate = s;
			
			//----  ��� ����� ���� Save
			Operate_Save = Operate.substring(0);
			Operand_Save = Operand.substring(0, Operand.length());

			Text.setText("");

		}

		// ---CE , C ����

		if (s == "CE") {// --- ���� �� �ٷ� ���� ���� ������
			Text.setText("");
			Point_Operate = false;
			Operate_Result = 0;
		}

		if (s == "C") { //--- ���� ���ν���
			Text.setText("");
			Point_Operate = false;
			
		}

		if (s == "��") {// ---���� Text�θ��� ���� �����
			String Back = Text.getText();
			Back = Back.substring(0, Back.length() - 1); // ---���ڿ� ����(0��°�ε�������
															// - ���ڸ� �A�ͱ���)
			Text.setText(Back);
		}

		if (Point_Operate == false && s == "=") { //--- �Ҽ� ����� �ƴϰ�, Result ��ư ������ ��
			CalcuMode = 0; // --- = ����� ������ �־���

			Text_window = Text.getText();

			switch (Operate_Save) {
			case "+":

				Operate_Result = Double.parseDouble(Operand_Save) + Double.parseDouble(Text_window);

				Text.setText("" + (int) Operate_Result);
				Operate_Result = 0;
				break;

			case "-":
				Operate_Result += Double.parseDouble(Operand_Save) - Double.parseDouble(Text_window);

				Text.setText("" + (int) Operate_Result);
				Operate_Result = 0;
				break;

			case "/":
				Operate_Result += Double.parseDouble(Operand_Save) / Double.parseDouble(Text_window);

				Text.setText("" + Operate_Result);
				PlusMinus_Save = Operate_Result;

				Operate_Result = 0;
				break;

			case "X":
				Operate_Result += Double.parseDouble(Operand_Save) * Double.parseDouble(Text_window);

				Text.setText("" + (int) Operate_Result);
				PlusMinus_Save = Operate_Result;

				Operate_Result = 0;
				break;
			}
		}//--- �Ҽ����� �ƴ�
		
		if (Point_Operate == true && s == "=") { //--- �Ҽ� ����� �ƴϰ�, Result ��ư ������ ��
			CalcuMode = 0; // --- = ����� ������ �־���

			Text_window = Text.getText();

			switch (Operate_Save) {
			case "+":

				Operate_Result = Double.parseDouble(Operand_Save) + Double.parseDouble(Text_window);

				Text.setText("" + Operate_Result);
				Operate_Result = 0;

				break;

			case "-":
				Operate_Result += Double.parseDouble(Operand_Save) - Double.parseDouble(Text_window);

				Text.setText("" + Operate_Result);
				Operate_Result = 0;
				break;

			case "/":
				Operate_Result += Double.parseDouble(Operand_Save) / Double.parseDouble(Text_window);

				Text.setText("" + Operate_Result);
				PlusMinus_Save = Operate_Result;

				Operate_Result = 0;
				break;

			case "X":
				Operate_Result += Double.parseDouble(Operand_Save) * Double.parseDouble(Text_window);

				Text.setText("" + Operate_Result);
				PlusMinus_Save = Operate_Result;

				Operate_Result = 0;
				break;
			}
		}
		
		// ---�÷��� ���̳ʽ� ������ ������� �ݿ� 
		if (s == "��") {
			PlusMinus_Save *= -1;
			Text.setText("" + PlusMinus_Save);
		}
	}
}

public class Calculator {
	public static void main(String ags[]) {
		CalcuFrame CF = new CalcuFrame();
	}
}
