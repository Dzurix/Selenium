package JavaBASICS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class arrayList {

  public static void main(String[] args) {
    // ArrayList<String> al = new ArrayList<String>(); //ovako definisemo ArrayList

    // al.add("Upoje");
    // al.add("Rahul");

    // System.out.println(al); // a kod Array moramo for loop ili nesto drugo da bi isprintali clanove

    // al.add(0, "student");
    // System.out.println(al);
    // // al.remove(1); //brisanje
    // // al.remove("Rahul");

    // System.out.println(al);

    // System.out.println(al.get(0));
    // System.out.println(al.indexOf("Rahul"));
    // System.out.println(al.size());

    // HashSet<String> hs = new HashSet<String>();

    // hs.add("lolo");
    // hs.add("wololo");
    // hs.add("RAHUL");
    // hs.add("RAHUL");
    // hs.add("he");
    // hs.add("she");

    // System.out.println(hs);
    // // hs.remove("RAHUL");
    // System.out.println(hs);

    // // bitan nam je Iterator da bi mogli da radimo sa setovima
    // Iterator<String> i = hs.iterator();
    // System.out.println(i.next());

    // while (i.hasNext()) {
    //   System.out.println(i.next());
    // }

    // HashMap<Integer, String> hm = new HashMap<Integer, String>();

    // hm.put(0, "hello");
    // hm.put(1, "good night");
    // hm.put(2, "evening");
    // hm.put(3, "morning");

    // System.out.println(hm.get(2));
    // // da bih dobio pojedinacno key value , moram da konvertujem map u set
    // Set sm = hm.entrySet();
    // Iterator it = sm.iterator();

    // while (it.hasNext()) {
    //   Map.Entry mp = (Map.Entry) it.next();
    //   System.out.println(mp.getKey());
    //   System.out.println(mp.getValue());
    // }

    int a[] = { 4, 5, 5, 5, 4, 6, 6, 9, 4 };
    // Print unique number from the list- Amazon

    //Istampaj svaki jedinstveni broj i koliko se puta ponavlja
    ArrayList<Integer> ab = new ArrayList<Integer>();
    for (int i = 0; i < a.length; i++) {
      int k = 0;
      if (!ab.contains(a[i])) {
        ab.add(a[i]);
        k++;
        for (int j = i + 1; j < a.length; j++) {
          if (a[i] == a[j]) {
            k++;
          }
        }

        System.out.println(a[i]);
        System.out.println(k);
        if (k == 1) System.out.println(a[i] + " is unique number");
      }
    }
  }
}
