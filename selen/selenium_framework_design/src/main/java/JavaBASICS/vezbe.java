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
  }
}
