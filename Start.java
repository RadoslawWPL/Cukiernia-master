package Cukiernia;

import javax.swing.JOptionPane;

public class Start {
	
		public static void main(String[] args) throws Exception
		{
//			int ilosc_klientow 	   = Integer.parseInt(JOptionPane.showInputDialog("Liczba klientow: "));
//			int zycie_bez_poaczka  = Integer.parseInt(JOptionPane.showInputDialog("Jak dlugo zyje bez paczka: "));
			int ilosc_paczkow_na_s = Integer.parseInt(JOptionPane.showInputDialog("Liczba paczkow na sekunde: "));
			int czas_zakupu		   = Integer.parseInt(JOptionPane.showInputDialog("Ile trwa kupno paczka: "));
//			int dlugosc_kolejki	   = Integer.parseInt(JOptionPane.showInputDialog("Dlugosc kolejki: "));
			
			Cukiernia cukiernia = new Cukiernia();
			Producent p1 = new Producent(cukiernia, ilosc_paczkow_na_s);
			Konsument c1 = new Konsument(cukiernia, czas_zakupu, 1);
			Konsument c2 = new Konsument(cukiernia, czas_zakupu, 2);
			p1.start();
			c1.start();
			c2.start();
		}

	
}
