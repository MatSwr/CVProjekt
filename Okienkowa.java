package Aplikacja;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Okienkowa extends JFrame implements ActionListener {

	JTextField imie = new JTextField(15);
	JPasswordField nazwisko = new JPasswordField(15);
	JButton dalej = new JButton("Dalej");
	JButton wyjdz = new JButton("Wyjdz");

	public Okienkowa() {
		super("Konto uzytkownika");
		setSize(500, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel okno = new JPanel();

		JLabel imieLabel = new JLabel("Imie: ");
		JLabel nazwiskoLabel = new JLabel("Nazwisko: ");
		dalej.addActionListener(this);
		wyjdz.addActionListener(this);

		okno.add(imieLabel);
		okno.add(imie);
		okno.add(nazwiskoLabel);
		okno.add(nazwisko);
		okno.add(dalej);
		okno.add(wyjdz);
		add(okno);

		setVisible(true);
	}



	public void actionPerformed(ActionEvent evt) {
        Object przycisk = evt.getSource();
        if (przycisk == dalej) {
            Ankieta ank  = new Ankieta();
            getContentPane().removeAll();
            getContentPane().add(ank);
            this.pack();
            System.out.println("Przechodzimy do JPanel");
 
        } else if (przycisk == wyjdz) {
            setVisible(false);
            System.out.println("Koniec programu");
        }
    }

	public static void main(String[] args) {
		Okienkowa okienko = new Okienkowa();

	}

}
