package JavaBASICS;

public class vezbe implements interface1 {

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

      //posto su metodi definisani izvan MAIN, moramo da kreiramo objekte klase da bi ih pokrenuli
      interface1 a = new vezbe();

      a.redStop();
      a.flashYellow();
      a.greenGo();
      //  a.setajNaZeleno();
      //ovaj metod nece raditi jer nije definisan u INTERFACE
      //zato moramo kreirati njegov objekat

      vezbe b = new vezbe();
      b.setajNaZeleno();
    }
  }

  @Override
  public void flashYellow() {
    // TODO Auto-generated method stub
    System.out.println("Yellow light");
  }

  @Override
  public void greenGo() {
    // TODO Auto-generated method stub
    System.out.println("Green light");
  }

  public void setajNaZeleno() {
    System.out.println("Predji ulicu na zeleno");
  }

  @Override
  public void redStop() {
    // TODO Auto-generated method stub

    System.out.println("Red light");
  }
}
