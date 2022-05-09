import java.util.ArrayList;

public class ArrayStack implements IStackable {
  ArrayList<Integer> l = new ArrayList<Integer>();

  public int size() {
    return l.size();
  }

  public void push(int v) {
    l.add(v);
  }

  public int pop() {
    return l.remove(0);
  }
}
