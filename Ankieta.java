package Aplikacja;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ankieta extends JPanel implements ActionListener {
	int currentCard = 0;
	CardLayout karta = new CardLayout();
	SurveyPanel[] ask = new SurveyPanel[3];

	public Ankieta() {
		super();
		setSize(240, 140);
		setLayout(karta);

		String pytanie1 = "Czy Mamuty zyly na Ziemi gdy ukonczono Piramide Heopsa?";
		String[] odp1 = { "Tak", "Nie", "Nie wiem" };
		ask[0] = new SurveyPanel(pytanie1, odp1, 2);
		String pytanie2 = "Do czego sluzy skrot klawiszowy (Ctrl + Shift + Esc)?";
		String[] odp2 = { "Do wylaczenia komputera", "Do wlaczenia menedzera zadan", "Do przejscia w tryb uspienia", };
		ask[1] = new SurveyPanel(pytanie2, odp2, 1);
		String pytanie3 = "Jaki jest domyslny menedzer ukladu panelu ?";
		String[] odp3 = { "zaden", "BorderLayout", "FlowLayout" };
		ask[2] = new SurveyPanel(pytanie3, odp3, 1);
		ask[2].setFinalQuestion(true);
		addListeners();
	}

	public void addListeners() {
		for (int i = 0; i < ask.length; i++) {
			ask[i].nextButton.addActionListener(this);
			ask[i].finalButton.addActionListener(this);
			add(ask[i], "Karta " + i);

		}
	}

	public void actionPerformed(ActionEvent evt) {
		currentCard++;
		if (currentCard >= ask.length) {
			JOptionPane.showMessageDialog(null,"Odpowiedz w Pytaniu 1: Tak");
			JOptionPane.showMessageDialog(null,"Odpowiedz w Pytaniu 2: Do wlaczenia menedzera zadan");
			JOptionPane.showMessageDialog(null,"Odpowiedz w Pytaniu 3: FlowLayout");
			System.exit(0);
		}
		karta.show(this, "Karta " + currentCard);
		
	}
}

class SurveyPanel extends JPanel {
	JLabel pytania;
	JRadioButton[] odp;
	JButton nextButton = new JButton("Dalej");
	JButton finalButton = new JButton("Zakoncz");

	SurveyPanel(String ques, String[] resp, int def) {
		super();
		setSize(160, 110);
		pytania = new JLabel(ques);
		odp = new JRadioButton[resp.length];
		JPanel okno1 = new JPanel();
		ButtonGroup group = new ButtonGroup();
		JLabel quesLabel = new JLabel(ques);
		okno1.add(quesLabel);
		JPanel okno2 = new JPanel();
		for (int i = 0; i < resp.length; i++) {
			if (def == i) {
				odp[i] = new JRadioButton(resp[i], true);

			} else {
				odp[i] = new JRadioButton(resp[i], false);

			}
			group.add(odp[i]);
			okno2.add(odp[i]);
		}
		JPanel okno3 = new JPanel();
		nextButton.setEnabled(true);
		okno3.add(nextButton);
		finalButton.setEnabled(false);
		okno3.add(finalButton);
		GridLayout grid = new GridLayout(3, 1);
		setLayout(grid);
		add(okno1);
		add(okno2);
		add(okno3);

	}

	void setFinalQuestion(boolean finalQuestion) {
		if (finalQuestion) {
			nextButton.setEnabled(false);
			finalButton.setEnabled(true);

		}
	}
}
