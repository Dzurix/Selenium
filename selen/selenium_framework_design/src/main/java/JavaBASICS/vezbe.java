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

      //Array
      // -container which stores multiple values of same data type

      int g[] = new int[5]; // array sa 5 elemenata

      int d[] = { 2, 3, 5, 6, 7 }; // odmah definisemo vrednosti

      // for (int n = 0; i < d.length; n++) {
      //   System.out.println(d[n]);
      // }
      //multidimenzionalni array ima dva ili vise parametara

      int x[][] = new int[2][3]; // 2 reda i 3 kolone

      x[0][0] = 4;
      x[0][1] = 3;
      x[0][2] = 2;
      x[1][0] = 1;
      x[1][1] = 5;
      x[1][2] = 6;

      //jednostavnije napisano je ovako

      int z[][] = { { 4, 3, 2 }, { 1, 5, 6 } };

      for (int l = 0; l < 2; l++) { //red
        for (int m = 0; m < 3; m++) { //kolona
          System.out.println(z[l][m]);
        }
      }
      //zadatak   istampaj minimalni broj iz matrice
      //  2  4  5
      //  3  4  7
      //  1  2  9

      int abc[][] = { { 2, 4, 5 }, { 3, 0, 7 }, { 1, 2, 9 } };

      int min = abc[0][0];
      int mincolumn;

      for (int prvi = 0; prvi < 3; prvi++) {
        for (int drugi = 0; drugi < 3; drugi++) {
          if (abc[prvi][drugi] < min) {
            min = abc[prvi][drugi];

            mincolumn = drugi;
          }
        }
      }
    }
  }

  // zadatak - u koloni gde je min, istampaj mi max broj

  //    -1. saznaj koji je min broj
  //    -2. identifikuj kolonu od min broj
  //    -3. pronadji max broj u toj koloni

  // int abc[][]={‌{2,4,5},{3,2,10},{1,2,0}};
  // int min=abc[0][0];
  // int mincoloumn = 0;

  // for(int i=0;i<3;i++)
  // {
  // for(int j=0;j<3;j++)
  // {
  // if(abc[i][j]<min)//2
  // {
  // min=abc[i][j];
  // mincoloumn=j;
  // }
  // }
  // }
  // //=1
  // int max=abc[0][mincoloumn];
  // int k = 0;
  // while(k<3)
  // {
  // if(abc[k][mincoloumn]>max)
  // {
  // max=abc[k][mincoloumn];
  // }
  // k++;
  // }

  // System.out.println(max);
  // }

  // }

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
