package JavaBASICS;

public class vezbe {

  public static void main(String[] args) {
    //stampanje piramide brojeva

    int k = 1;

    for (int i = 0; i < 4; i++) {
      for (int j = 1; j <= 4 - i; j++) {
        System.out.print(k); // print ispisuje sve u jednom redu
        System.out.print("\t"); //ovako stampamo veliki razmak => kao TAB npr
        k++;
      }
      System.out.println(""); // printLN ispisuje u sledeci red
    }

    // obrnuto

    int y = 10;

    for (int i = 0; i < 5; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(y); // print ispisuje sve u jednom redu
        System.out.print("\t"); //ovako stampamo veliki razmak => kao TAB npr
        y--; // ovo je za definisanje da li se povecava od y ili se smanjuje
      }
      System.out.println(""); // printLN ispisuje u sledeci red
    }

    //  treci primer

    for (int i = 1; i < 5; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j); // print ispisuje sve u jednom redu
        System.out.print("\t"); //ovako stampamo veliki razmak => kao TAB npr
      }
      System.out.println(""); // printLN ispisuje u sledeci red
    }
  }
  // INTERFACE je slican CLASSi. Imace metode, ali nema body
  // Klase treba da definisu i implementuju metode prisutne u INTERFACE
  // sve varijable definisane u interface su public po prirodi
  // jedna klasa moze IMPLEMENTS vise INTERFACE
}
