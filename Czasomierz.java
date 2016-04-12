package Cukiernia;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class Czasomierz {
  Toolkit toolkit;

  Timer timer;

  public Czasomierz(int czas) {
    toolkit = Toolkit.getDefaultToolkit();
    timer = new Timer();
    timer.schedule(new RemindTask(), czas * 1000);
  }

  class RemindTask extends TimerTask {
    public void run() {
      toolkit.beep();
    }
  }

  public static void metablizm(int czas) {
    new Czasomierz(czas);
  }
}
