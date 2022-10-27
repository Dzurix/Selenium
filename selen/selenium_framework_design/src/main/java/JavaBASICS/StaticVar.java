package JavaBASICS;

public class StaticVar {

  // ovo su 1) INSTANCE variables => vezane su za objekat
  String name;
  String adress;
  static String city; // static znaci da se ova varijabla deli sa svim objektima a cilj je optimizacija da ne koristimo mnogo memorije
  static int i;

  //static blok sluzi za inicijalizaciju svih STATIC varijabli
  static {
    city = "Bangalour";
    i = 0;
  }

  // sve 'static' varijable se nazivaju 2) CLASS varijablama i na njih Objekti nemaju uticaja

  //konstruktor
  StaticVar(String name, String adress) {
    //ove varijable koje su parametri su 3) LOKALNE varijable

    //ovako dodeljujemo - asignujemo lokalne varijable u INSTANCE varijable
    this.name = name;
    this.adress = adress;
    i++;
    System.out.println(i);
  }

  public void getAdress() {
    System.out.println(adress + ", " + city);
  }

  public static void getCity() {
    // STATIC metod prihvata SAMO STATIC varijable
    System.out.println(city);
  }

  public static void main(String[] args) {
    //kreiramo objekat ako hocemo da pristupimo bilo kojem metodu ove klase (i konstruktoru) i to radimo samo u MAIN
    //dddfreeeeeeeeeeeeeeeeeeeeeeeeee    - Secer pisao
    //
    StaticVar obj = new StaticVar("Bob", "Martaly");
    StaticVar obj1 = new StaticVar("Ram", "Bandaly");
    StaticVar obj2 = new StaticVar("rammstein", "Wendaly");

    // pozivanje metoda
    obj.getAdress();
    obj1.getAdress();
    // obj2.getCity();  na STATIC metode OBJEKTI nemaju uticaja, pa ne vredi da ih ovako pozivamo
    StaticVar.getCity();

    int a = 7;
    int b = 0;

    try {
      int c = a / b;
    } catch (ArithmeticException ae) {
      System.out.println("uhvatio sam aritmeticku gresku");
    } catch (Exception e) {
      System.out.println("Ovo je genericka greska, generalni Exception");
    } finally {
      System.out.println("delete cookies, and closing the window");
    }
  }
}
