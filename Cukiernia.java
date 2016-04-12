package Cukiernia;

public class Cukiernia {
	private int ilosc_paczkow;
	private boolean dostepne_paczki = false;

	public synchronized void wezPaczka() {
		while (dostepne_paczki == false) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		ilosc_paczkow--;
		if (ilosc_paczkow == 0) {
			dostepne_paczki = false;
		}
		notifyAll();
	}

	public synchronized void wlozPaczka(int ilosc) {
		/*
		 * while (dostepne_paczki == true) { try { wait(); } catch
		 * (InterruptedException e) { } }
		 */
		ilosc_paczkow = ilosc;
		dostepne_paczki = true;
		notifyAll();
	}
	
	public synchronized boolean paczki() {
		if (ilosc_paczkow == 0) {
			return dostepne_paczki = false;
		} else {
			return dostepne_paczki = true;
		}
	}
}