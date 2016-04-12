package Cukiernia;

class Producent extends Thread {
	private Cukiernia cukiernia;
	private int ilosc_paczkow_na_s;

	public Producent(Cukiernia cukiernia, int ilosc_paczkow_na_s) {
		this.cukiernia = cukiernia;
		this.ilosc_paczkow_na_s = ilosc_paczkow_na_s;
	}

	public void run() {
//		int i = 0;

		while (true) {
			try {
//				i++;
				cukiernia.wlozPaczka(ilosc_paczkow_na_s);
				System.out.println("Producent " + " wlozyl: " + ilosc_paczkow_na_s + " paczkow");

				sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
