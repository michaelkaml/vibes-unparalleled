import java.util.LinkedList;

public class YourImplementationOfDeque<FORTNITE> implements Deque<FORTNITE> {
  private LinkedList<FORTNITE> _fort;

  public YourImplementationOfDeque() {
    _fort = new LinkedList();
  }

  public FORTNITE peekFirst() {
    return _fort.peekFirst();
  }

  public FORTNITE peekLast() {
    return _fort.peekLast();
  }

  public void addFirst(FORTNITE x) {
    _fort.addFirst(x);
  }

  public void addLast(FORTNITE x) {
    _fort.addLast(x);
  }

  public FORTNITE removeFirst() {
    FORTNITE retVal = _fort.removeFirst();
    return retVal;
  }

  public FORTNITE removeLast() {
    FORTNITE retVal = _fort.removeLast();
    return retVal;
  }

  public FORTNITE pollFirst() {
    if (_fort.peekFirst() == null) {
      return null;
    } else {
      return _fort.removeFirst();
    }
  }

  public FORTNITE pollLast() {
    if (_fort.peekLast() == null) {
      return null;
    } else {
      return _fort.removeLast();
    }
  }

  public static void main(String[] args) {
    YourImplementationOfDeque<String> nite = new YourImplementationOfDeque();

    nite.addFirst("a");
    System.out.println(nite.peekFirst());
    nite.addLast("b");
    System.out.println(nite.peekLast());
    nite.addFirst("c");
    System.out.println(nite.peekFirst());
    nite.addLast("d");
    System.out.println(nite.peekLast() + "\n");

    System.out.println(nite.removeFirst());
    System.out.println(nite.removeFirst());
    System.out.println(nite.removeFirst());
    System.out.println(nite.removeFirst() + "\n");

    nite.addFirst("a");
    nite.addLast("b");
    nite.addFirst("c");
    nite.addLast("d");

    System.out.println("\n" + nite.removeLast());
    System.out.println(nite.removeLast());
    System.out.println(nite.removeLast());
    System.out.println(nite.removeLast() + "\n");

    System.out.println(nite.pollFirst());
    System.out.println(nite.pollLast());

    nite.addFirst("a");
    nite.addLast("b");
    nite.addFirst("c");
    nite.addLast("d");

    System.out.println(nite.pollFirst());
    System.out.println(nite.pollLast());
  }
}
