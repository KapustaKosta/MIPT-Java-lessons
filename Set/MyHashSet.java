package Set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class MyHashSet<E> implements BaseSet<E> {

  private static final int DEFAULT_CAPACITY = 1 << 4;
  private static final int MAX_CAPACITY = 1 << 30;
  private static final float LOAD_FACTOR = 0.75f;

  private Node<E>[] table;
  private int size;
  private final float loadFactor;
  private int threshold;

  public MyHashSet() {
    this(DEFAULT_CAPACITY, LOAD_FACTOR);
  }

  public MyHashSet(int initialCapacity) {
    this(initialCapacity, LOAD_FACTOR);
  }

  public MyHashSet(int initialCapacity, float loadFactor) {
    if (initialCapacity < 0 || loadFactor <= 0 || Float.isNaN(loadFactor)) {
      throw new IllegalArgumentException();
    }
    if (initialCapacity > MAX_CAPACITY) {
      initialCapacity = MAX_CAPACITY;
    }
    this.loadFactor = loadFactor;
    threshold = (int) (initialCapacity * loadFactor);
    table = new Node[initialCapacity];
  }

  private static int hash(Object key, int length) {
    int h = key.hashCode();
    h ^= (h >>> 20) ^ (h >>> 12);
    h ^= (h >>> 7) ^ (h >>> 4);
    return h & (length - 1);
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    int oldCapacity = table.length;
    if (oldCapacity == MAX_CAPACITY) {
      threshold = Integer.MAX_VALUE;
      return;
    }
    Node<E>[] newTable = new Node[oldCapacity << 1];
    for (Node<E> node : table) {
      while (node != null) {
        Node<E> next = node.next;
        int index = (newTable.length - 1) & node.hash;
        node.next = newTable[index];
        newTable[index] = node;
        node = next;
      }
    }
    table = newTable;
    threshold = (int) (newTable.length * loadFactor);
  }

  @Override
  public void add(E e) {
    int hash = hash(e, table.length);
    int index = (table.length - 1) & hash;
    Node<E> node = table[index];
    while (node != null) {
      if (node.hash == hash && Objects.equals(node.key, e)) {
        return;
      }
      node = node.next;
    }
    if (++size > threshold) {
      resize();
      index = (table.length - 1) & hash;
    }
    table[index] = new Node<>(hash, e, table[index]);
  }

  @Override
  public void remove(Object o) {
    int hash = hash(o, table.length);
    int index = (table.length - 1) & hash;
    Node<E> node = table[index];
    Node<E> prev = null;
    while (node != null) {
      if (node.hash == hash && Objects.equals(node.key, o)) {
        if (prev == null) {
          table[index] = node.next;
        } else {
          prev.next = node.next;
        }
        size--;
        return;
      }
      prev = node;
      node = node.next;
    }
  }

  @Override
  public void clear() {
    Arrays.fill(table, null);
    size = 0;
  }

  @Override
  public boolean contains(Object o) {
    int hash = hash(o, table.length);
    int index = (table.length - 1) & hash;
    Node<E> node = table[index];
    while (node != null) {
      if (node.hash == hash && Objects.equals(node.key, o)) {
        return true;
      }
      node = node.next;
    }
    return false;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof BaseSet<?>)) {
      return false;
    }
    BaseSet<?> set = (BaseSet<?>) o;
    if (set.size() != size) {
      return false;
    }
    try {
      for (E e : this) {
        if (!set.contains(e)) {
          return false;
        }
      }
    } catch (ClassCastException | NullPointerException e) {
      return false;
    }
    return true;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<>() {

      private int index = -1;
      private Node<E> node;

      @Override
      public boolean hasNext() {
        if (node != null && node.next != null) {
          return true;
        }
        for (int i = index + 1; i < table.length; i++) {
          if (table[i] != null) {
            return true;
          }
        }
        return false;
      }

      @Override
      public E next() {
        if (node != null && node.next != null) {
          node = node.next;
        } else {
          do {
            node = table[++index];
          } while (node == null);
        }
        return node.key;
      }

      @Override
      public void remove() {
        MyHashSet.this.remove(node.key);
      }
    };
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    for (E e : this) {
      sb.append(e).append(", ");
    }
    if (size > 0) {
      sb.setLength(sb.length() - 2);
    }
    sb.append("]");
    return sb.toString();
  }

  static class Node<T> {

    final int hash;
    final T key;
    Node<T> next;

    public Node(int hash, T key, Node<T> next) {
      this.hash = hash;
      this.key = key;
      this.next = next;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Node<?> node = (Node<?>) o;
      return hash == node.hash && Objects.equals(key, node.key) && Objects.equals(
          next, node.next);
    }

    @Override
    public int hashCode() {
      return Objects.hash(hash, key, next);
    }

    @Override
    public String toString() {
      return key.toString();
    }
  }
}
