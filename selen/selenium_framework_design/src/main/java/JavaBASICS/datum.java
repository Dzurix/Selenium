package JavaBASICS;

import java.text.SimpleDateFormat;
import java.util.Date;

public class datum {

  public static void main(String[] args) {
    Date d = new Date(); // ovo je klasa za datum

    System.out.println(d.toString());

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    System.out.println(sdf.format(d));
    System.out.println(sd.format(d));
    // Konstruktor izvrsava blok koda kad god je objekat kreiran
    // kad god kreiramo objekat, konstruktor je invoke - pozvan
    //razlika izmedju metoda i konstruktora je u tome sto konstruktor ne vraca vrednosti a ime uvek kao ime klase
    //svrha konstruktora je da ko god bude kreirao objekat od ove klase 'datum', automatski ce se prvo izvrsiti kod u konstruktoru

    // kreiram objekat od ove klase
    datum objekatDatum = new datum(); //ovako cemo pozvati DEFAULT konstruktor jer nismo definisali parametre da bi pozvali drugi konstruktor

    datum objekatDatu = new datum(1, 2); // ovako cemo pozvati PARAMETARIZOVANI konstruktor jer smo definisali parametre
  }

  // evo ga "Default" konstruktor posto nema definisane vrednosti

  public datum() {
    super(); //uvek na prvoj liniji mora biti
    System.out.println("I am in CONTRUCTOR");
  }

  // evo ga Parametarizovani konstruktor

  public datum(int a, int b) {
    System.out.println("I am in PARAMETARIZED CONTRUCTOR");
  }

  // ovo je metod
  public void getData() {
    System.out.println(" I AM METHOD");
  }
}
