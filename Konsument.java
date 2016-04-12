package Cukiernia;
import java.util.Random;

class Konsument extends Thread {
	private Cukiernia cukiernia;
	private int numer_konsumenta;
	private int czas_zakupu;
	private boolean przelacznik;
	private int stan_najedzenia;
	
	public Konsument(Cukiernia cukiernia, int czas_zakupu, int nr_konsumenta) {
		this.cukiernia = cukiernia;
		this.numer_konsumenta = nr_konsumenta;
		this.przelacznik = ustaw_przelacznik();
		this.czas_zakupu = modyfikuj_czas(czas_zakupu);
		this.stan_najedzenia = 20;
		System.out.println("Konsument " + numer_konsumenta + ": " + this.czas_zakupu );
	}

	public void run() {
//	while (stan_najedzenia > 0) {
		boolean dostepne_paczki = cukiernia.paczki();
		stan_najedzenia();
		if (stan_najedzenia < 20) {
			while (dostepne_paczki == true) {
				cukiernia.wezPaczka();
				try {
					sleep(czas_zakupu);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Konsument #" + this.numer_konsumenta + " kupil paczka");
			}
		}
//	}
//	System.out.println("Polegl");
	}
	
	private boolean ustaw_przelacznik() {
		Random przelacznik = new Random();
		return przelacznik.nextBoolean();
	}

	private int modyfikuj_czas(int zmienna) {
		if (przelacznik == true) {
			zmienna = (int) Math.round(zmienna * 1.2);
		} else {
			zmienna = (int) Math.round(zmienna * 0.8);
		}
		return zmienna;
	}
	
	private void stan_najedzenia() {
		//		Random generator = new Random(50);
//		int stan = generator.nextInt(10) * 1000;
		Czasomierz.metablizm(1);
		stan_najedzenia --;
	}
	
	
}
