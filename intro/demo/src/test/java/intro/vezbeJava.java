package intro;

import java.util.ArrayList;

public class vezbeJava {

  public static void main(String[] args) {
    // moram da odredim tip podatka
    int myNum = 5;
    String website = "Rahul Shetty Academy";
    char letter = 'r';
    double dec = 5.99;

    boolean myCard = true;

    System.out.println(myNum + " is the value stored in the myNum variable");
    //Arrays

    // I nacin kreiranja
    int[] arr = new int[5]; // sintaksa za array, 5 elemenata ce biti u array
    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 8;
    arr[3] = 7;
    arr[4] = 6;
    // II nacin kreiranja (kada znamo koje cemo elemente koristiti)

    int[] arr1 = { 7, 5, 8, 6, 8, 9 };

    System.out.println(arr1[2]);

    // FOR loop

    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }

    String[] name = { "rahul", "sheety", "selenium" };

    for (int i = 0; i < name.length; i++) {
      System.out.println(name[i]);
    }

    //napisano na II nacin loopavanje po String array
    for (String s : name) {
      System.out.println(s);
    }

    // if, else  deljivo sa 2

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 == 0) { // za komparaciju koristimo ==
        System.out.println(arr[i]);
        break; // kada uslov bude true prvi put, prekini
      } else {
        System.out.println(arr[i] + " nije deljivo sa 2");
      }
    }

    //ARAYLIST - sluze da dinamicki prosirujemo ARRAY

    ArrayList<String> a = new ArrayList<String>();
    // ako hocu da pristupim metodama koje se nalaze u klasi, moram kreirati objekat te klase  => a.metod
    a.add("upoje");
    a.add("jonas");
    a.add("tim");
    a.add("selenium");
    a.remove("jonas");

    System.out.println(a);
    System.out.println(a.get(2));

    //U javi STRING je objekat

    //definisanje STRINGA preko STRING LITERAL
    String r = "Rahul Shetty Accademy";
    String r1 = "Rahul Shetty Accademy"; // ovo je samo referenca na r, nece ponovo kreirati objekat

    //definisanje STRINGA preko NEW memory alocator-a
    String s2 = new String("Welcome");
    String s3 = new String("Welcome"); // ponovo ce se kreirati objekat u JAVA memoriji

    String s = "Rahul Shetty Academy";
    String[] splittedString = s.split(" ");
    System.out.println(splittedString[0].trim());

    for (int i = s.length() - 1; i >= 0; i--) {
      System.out.println(s.charAt(i)); //printovanje pojedinacnog slova
    }

    vezbeJava d = new vezbeJava(); //kreiram objekat od klase

    // d.getData(); //ovako pozivam metod

    String ime = getData();
    System.out.println(ime);

    metod d1 = new metod();
    String poruka = d1.getUserData();
    System.out.println(poruka);
  }

  //METODI
  //uvek se kreiraju van MAIN block jer se ne izvrsavaju

  // void znaci da ne vraca nista
  // kako pristupiti metodama moje klase, bez kreiranja objekta - oznacimo metod kao "STATIC"
  // STATIC pomera moj metod koji sam kreirao ka levelu KLASE
  public static String getData() {
    System.out.println("Hello upoje!");
    return "Rahul SHEETY";
  }
}
