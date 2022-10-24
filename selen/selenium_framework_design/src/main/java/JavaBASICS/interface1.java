package JavaBASICS;

public interface interface1 {
  // INTERFACE je slican CLASSi. Imace metode, ali nema body
  // Klase treba da definisu i implementuju metode prisutne u INTERFACE
  // sve varijable definisane u interface su public po prirodi
  // jedna klasa moze IMPLEMENTS vise INTERFACE

  int b = 4; //mozemo definisati i varijable, ali MORAJU biti PUBLIC (bice svakako PUBLIC)

  public void greenGo(); //ovo je INTERFACE, nema body

  public void redStop();

  public void flashYellow();
}
