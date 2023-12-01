package MyLinkedList;

import Interfaces.List;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements List<E>, Iterable<E> {

  private Node<E> head;
  private Node<E> tail;
  private int size;

  public MyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  private static class Node<E> {

    E data;
    Node<E> prev;
    Node<E> next;

    public Node(E data, Node<E> prev, Node<E> next) {
      this.data = data;
      this.prev = prev;
      this.next = next;
    }
  }

  public void add(E el) {
    Node<E> newNode = new Node<>(el, tail, null);
    if (tail != null) {
      tail.next = newNode;
    }
    tail = newNode;
    if (head == null) {
      head = newNode;
    }
    size++;
  }

  public void insertHead(E el) {
    Node<E> newNode = new Node<>(el, null, head);
    if (head != null) {
      head.prev = newNode;
    }
    head = newNode;
    if (tail == null) {
      tail = newNode;
    }
    size++;
  }

  public void printList() {
    Node<E> current = head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
  }

  @Override
  public void add(int index, E el) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }
    if (index == size) {
      add(el);
      return;
    }
    Node<E> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    Node<E> newNode = new Node<>(el, current.prev, current);
    if (current.prev != null) {
      current.prev.next = newNode;
    } else {
      head = newNode;
    }
    current.prev = newNode;
    size++;
  }

  @Override
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }
    Node<E> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current.data;
  }

  @Override
  public void remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }
    Node<E> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    if (current.prev != null) {
      current.prev.next = current.next;
    } else {
      head = current.next;
    }
    if (current.next != null) {
      current.next.prev = current.prev;
    } else {
      tail = current.prev;
    }
    size--;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  public E getFirst() {
    if (head == null) {
      return null;
    }
    return head.data;
  }

  public E getLast() {
    if (tail == null) {
      return null;
    }
    return tail.data;
  }

  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  public MyIterator<E> iterator() {
    return new MyLinkedListIterator();
  }

  private class MyLinkedListIterator extends MyIterator<E> {

    private Node<E> current;

    public MyLinkedListIterator() {
      this.current = head;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public boolean hasPrevious() {
      return current.prev != null;
    }

    @Override
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      E data = current.data;
      current = current.next;
      return data;
    }

    public E previous() {
      if (!hasPrevious()) {
        throw new NoSuchElementException();
      }
      E data = current.prev.data;
      current = current.prev;
      return data;
    }
  }
}